package br.com.techchallenge.schedule_management.infrastructure.consultation.datasource;

import br.com.techchallenge.schedule_management.application.adapters.datasource.ConsultationDataSource;
import br.com.techchallenge.schedule_management.application.dto.Consultation.ConsultationDTO;
import br.com.techchallenge.schedule_management.application.dto.Consultation.CreateConsultationDTO;
import br.com.techchallenge.schedule_management.application.dto.Consultation.UpdateConsultationDTO;
import br.com.techchallenge.schedule_management.application.dto.shared.PageResult;
import br.com.techchallenge.schedule_management.infrastructure.config.rabbitmq.RabbitMQConfiguration;
import br.com.techchallenge.schedule_management.infrastructure.consultation.dto.NotificationDTO;
import br.com.techchallenge.schedule_management.infrastructure.consultation.entity.Consultation;
import br.com.techchallenge.schedule_management.infrastructure.consultation.entity.ConsultationStatus;
import br.com.techchallenge.schedule_management.infrastructure.consultation.repository.ConsultationRepository;
import br.com.techchallenge.schedule_management.infrastructure.doctor.repository.DoctorRepository;
import br.com.techchallenge.schedule_management.infrastructure.nurse.repository.NurseRepository;
import br.com.techchallenge.schedule_management.infrastructure.patient.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ConsultationDataSourceImpl implements ConsultationDataSource {

    private final ConsultationRepository consultationRepository;
    private final DoctorRepository doctorRepository;
    private final NurseRepository nurseRepository;
    private final PatientRepository patientRepository;
    private final RabbitTemplate rabbitTemplate;

    @Override
    public ConsultationDTO createConsultation(CreateConsultationDTO createConsultationDTO) {
        var patientOp = patientRepository.findById(createConsultationDTO.patientId());
        var doctorOp = doctorRepository.findById(createConsultationDTO.doctorId());
        var nurseOp = nurseRepository.findById(createConsultationDTO.nurseId());

        Consultation consultation = new Consultation(
                createConsultationDTO,
                patientOp.get(),
                doctorOp.get(),
                nurseOp.get()
        );

        var createdConsultation = consultationRepository.save(consultation);

        return new ConsultationDTO(createdConsultation);
    }

    @Override
    public ConsultationDTO updateConsultation(Long consultationId, UpdateConsultationDTO updateConsultationDTO) {
        var consultationOp = consultationRepository.findById(consultationId);

        if (consultationOp.isEmpty()) return null;

        var consultation = consultationOp.get();
        var patientOp = patientRepository.findById(updateConsultationDTO.patientId());
        var doctorOp = doctorRepository.findById(updateConsultationDTO.doctorId());
        var nurseOp = nurseRepository.findById(updateConsultationDTO.nurseId());
        consultation.updateConsultation(
                updateConsultationDTO,
                patientOp.get(),
                doctorOp.get(),
                nurseOp.get()
        );

        consultation = consultationRepository.save(consultation);

        return new ConsultationDTO(consultation);
    }

    @Override
    public ConsultationDTO updateConsultationStatus(Long consultationId, String status) {
        var consultation = this.consultationRepository.findById(consultationId)
                .orElseThrow(() -> new RuntimeException("Consultation not found"));

        consultation.setStatus(ConsultationStatus.valueOf(status));

        this.consultationRepository.save(consultation);

        return new ConsultationDTO(consultation);
    }

    @Override
    public Optional<ConsultationDTO> getConsultationById(Long consultationId) {
        var consultationOp = consultationRepository.findById(consultationId);

        return consultationOp.map(ConsultationDTO::new);

    }

    @Override
    public PageResult<ConsultationDTO> getConsultations(Integer page, Integer size) {
        var pageable = PageRequest.of(page, size);

        var consultationsPage = consultationRepository.findAll(pageable);

        return new PageResult<>(
                consultationsPage.map(ConsultationDTO::new).toList(),
                page,
                size,
                consultationsPage.getTotalElements()
        );
    }

    @Override
    public PageResult<ConsultationDTO> getConsultationsByDoctorId(Long doctorId, Integer page, Integer size) {
        var pageable = PageRequest.of(page, size);

        var consultationsPage = consultationRepository.findByDoctorId(doctorId, pageable);

        return new PageResult<>(
                consultationsPage.map(ConsultationDTO::new).toList(),
                page,
                size,
                consultationsPage.getTotalElements()
        );
    }

    @Override
    public PageResult<ConsultationDTO> getConsultationsByPatientId(Long patientId, Integer page, Integer size) {
        var pageable = PageRequest.of(page, size);

        var consultationsPage = consultationRepository.findByPatientId(patientId, pageable);

        return new PageResult<>(
                consultationsPage.map(ConsultationDTO::new).toList(),
                page,
                size,
                consultationsPage.getTotalElements()
        );
    }

    @Override
    public void sendFinishedConsultationToQueue(ConsultationDTO consultationDTO) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfiguration.HISTORY_EXCHANGE_NAME,
                RabbitMQConfiguration.HISTORY_ROUTING_KEY,
                consultationDTO
        );
    }

    @Override
    public void sendNotificationToQueue(NotificationDTO notificationDTO) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfiguration.NOTIFICATION_EXCHANGE_NAME,
                RabbitMQConfiguration.NOTIFICATION_ROUTING_KEY,
                notificationDTO
        );
    }

    @Override
    public List<ConsultationDTO> getFinishedConsultations() {
        var finishedConsultations = this.consultationRepository.getFinishedConsultations(List.of(
                ConsultationStatus.DONE,
                ConsultationStatus.CANCELED,
                ConsultationStatus.LOST
        ));

        return finishedConsultations.stream().map(ConsultationDTO::new).toList();
    }

}
