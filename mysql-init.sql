CREATE TABLE patient
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    name         VARCHAR(255)          NULL,
    cpf          VARCHAR(255)          NULL,
    email        VARCHAR(255)          NULL,
    phone        VARCHAR(255)          NULL,
    zip_code     VARCHAR(255)          NULL,
    street       VARCHAR(255)          NULL,
    number       VARCHAR(255)          NULL,
    complement   VARCHAR(255)          NULL,
    neighborhood VARCHAR(255)          NULL,
    city         VARCHAR(255)          NULL,
    state        VARCHAR(255)          NULL,
    created_at        DATETIME              NOT NULL,
    updated_at        DATETIME              NOT NULL,
    CONSTRAINT pk_patient PRIMARY KEY (id)
)ENGINE=INNODB;

CREATE TABLE speciality
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)          NULL,
    created_at        DATETIME              NOT NULL,
    updated_at        DATETIME              NOT NULL,
    CONSTRAINT pk_speciality PRIMARY KEY (id)
)ENGINE=INNODB;

CREATE TABLE doctor
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    name          VARCHAR(255)          NULL,
    cpf           VARCHAR(255)          NULL,
    phone         VARCHAR(255)          NULL,
    email         VARCHAR(255)          NULL,
    crm           VARCHAR(255)          NULL,
    speciality_id BIGINT                NULL,
    zip_code      VARCHAR(255)          NULL,
    street        VARCHAR(255)          NULL,
    number        VARCHAR(255)          NULL,
    complement    VARCHAR(255)          NULL,
    neighborhood  VARCHAR(255)          NULL,
    city          VARCHAR(255)          NULL,
    state         VARCHAR(255)          NULL,
    created_at        DATETIME              NOT NULL,
    updated_at        DATETIME              NOT NULL,
    CONSTRAINT pk_doctor PRIMARY KEY (id),
    CONSTRAINT fk_doctor_on_speciality FOREIGN KEY (speciality_id) REFERENCES speciality (id)
)ENGINE=INNODB;

CREATE TABLE nurse
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    name          VARCHAR(255)          NULL,
    cpf           VARCHAR(255)          NULL,
    phone         VARCHAR(255)          NULL,
    email         VARCHAR(255)          NULL,
    coren         VARCHAR(255)          NULL,
    zip_code      VARCHAR(255)          NULL,
    street        VARCHAR(255)          NULL,
    number        VARCHAR(255)          NULL,
    complement    VARCHAR(255)          NULL,
    neighborhood  VARCHAR(255)          NULL,
    city          VARCHAR(255)          NULL,
    state         VARCHAR(255)          NULL,
    created_at        DATETIME              NOT NULL,
    updated_at        DATETIME              NOT NULL,
    CONSTRAINT pk_nurse PRIMARY KEY (id)
)ENGINE=INNODB;

CREATE TABLE consultation
(
    id                BIGINT AUTO_INCREMENT                         NOT NULL,
    patient_id        BIGINT                                        NOT NULL,
    doctor_id         BIGINT                                        NOT NULL,
    nurse_id          BIGINT                                        NOT NULL,
    consultation_date DATETIME                                      NOT NULL,
    reason            VARCHAR(255)                                  NULL,
    created_at        DATETIME                                      NOT NULL,
    updated_at        DATETIME                                      NOT NULL,
    status            ENUM('SCHEDULED', 'CANCELED', 'LOST', 'DONE') NOT NULL DEFAULT 'SCHEDULED',
    observation       VARCHAR(255)                                  NULL,
    CONSTRAINT pk_consultation PRIMARY KEY (id),
    CONSTRAINT fk_consultation_patient FOREIGN KEY (patient_id) REFERENCES patient (id),
    CONSTRAINT fk_consultation_doctor FOREIGN KEY (doctor_id) REFERENCES doctor (id),
    CONSTRAINT fk_consultation_nurse FOREIGN KEY (nurse_id) REFERENCES nurse (id)
)ENGINE=INNODB;


-- Inserindo especialidades
INSERT INTO speciality (name, created_at, updated_at)
VALUES
    ('Cardiologia', NOW(), NOW()),
    ('Ortopedia', NOW(), NOW()),
    ('Pediatria', NOW(), NOW());

-- Inserindo pacientes
INSERT INTO patient (name, cpf, email, phone, zip_code, street, number, complement, neighborhood, city, state, created_at, updated_at)
VALUES
    ('João Silva', '12345678901', 'joao.silva@email.com', '(11)99999-1111', '01001-000', 'Rua A', '100', 'Apto 101', 'Centro', 'São Paulo', 'SP', NOW(), NOW()),
    ('Maria Oliveira', '98765432100', 'maria.oliveira@email.com', '(11)98888-2222', '20000-000', 'Av. B', '200', NULL, 'Copacabana', 'Rio de Janeiro', 'RJ', NOW(), NOW());

-- Inserindo médicos (associados às especialidades acima)
INSERT INTO doctor (name, cpf, phone, email, crm, speciality_id, zip_code, street, number, complement, neighborhood, city, state, created_at, updated_at)
VALUES
    ('Dr. Carlos Mendes', '12312312399', '(11)97777-3333', 'carlos.mendes@hospital.com', 'CRM12345', 1, '01001-000', 'Rua das Flores', '50', NULL, 'Centro', 'São Paulo', 'SP', NOW(), NOW()),
    ('Dra. Ana Souza', '32132132188', '(21)96666-4444', 'ana.souza@hospital.com', 'CRM54321', 2, '20000-000', 'Av. Atlântica', '300', 'Sala 2', 'Copacabana', 'Rio de Janeiro', 'RJ', NOW(), NOW());

-- Inserindo enfermeiros
INSERT INTO nurse (name, cpf, phone, email, coren, zip_code, street, number, complement, neighborhood, city, state, created_at, updated_at)
VALUES
    ('Fernanda Lima', '55566677788', '(31)95555-5555', 'fernanda.lima@hospital.com', 'COREN1234', '30110-000', 'Rua Minas', '120', NULL, 'Savassi', 'Belo Horizonte', 'MG', NOW(), NOW()),
    ('Ricardo Alves', '44433322211', '(41)94444-6666', 'ricardo.alves@hospital.com', 'COREN5678', '80000-000', 'Rua Paraná', '89', 'Bloco B', 'Centro', 'Curitiba', 'PR', NOW(), NOW());

-- Inserindo consultas
INSERT INTO consultation (patient_id, doctor_id, nurse_id, consultation_date, reason, created_at, updated_at, status, observation)
VALUES (1, 1, 1, '2025-09-26 09:00:00', 'Check-up de rotina', NOW(), NOW(), 'DONE', 'Paciente em boas condições gerais');
INSERT INTO consultation (patient_id, doctor_id, nurse_id, consultation_date, reason, created_at, updated_at, status, observation)
VALUES (2, 2, 2, '2025-09-26 10:30:00', 'Dor no joelho', NOW(), NOW(), 'SCHEDULED', 'Paciente relatou dor ao caminhar');
INSERT INTO consultation (patient_id, doctor_id, nurse_id, consultation_date, reason, created_at, updated_at, status, observation)
VALUES (1, 2, 1, '2025-09-27 14:00:00', 'Acompanhamento pós-tratamento', NOW(), NOW(), 'DONE', 'Evolução positiva, sem queixas');
INSERT INTO consultation (patient_id, doctor_id, nurse_id, consultation_date, reason, created_at, updated_at, status, observation)
VALUES (2, 1, 2, '2025-09-28 15:30:00', 'Avaliação cardiológica', NOW(), NOW(), 'CANCELED', 'Consulta cancelada pelo paciente');
INSERT INTO consultation (patient_id, doctor_id, nurse_id, consultation_date, reason, created_at, updated_at, status, observation)
VALUES (1, 1, 1, '2025-09-29 09:15:00', 'Dor no peito', NOW(), NOW(), 'SCHEDULED', 'Solicitado eletrocardiograma');
INSERT INTO consultation (patient_id, doctor_id, nurse_id, consultation_date, reason, created_at, updated_at, status, observation)
VALUES (2, 2, 2, '2025-09-30 11:00:00', 'Check-up ginecológico', NOW(), NOW(), 'DONE', 'Exames preventivos realizados com sucesso');
INSERT INTO consultation (patient_id, doctor_id, nurse_id, consultation_date, reason, created_at, updated_at, status, observation)
VALUES (1, 2, 1, '2025-10-01 16:00:00', 'Retorno da última consulta', NOW(), NOW(), 'LOST', 'Paciente não compareceu');
INSERT INTO consultation (patient_id, doctor_id, nurse_id, consultation_date, reason, created_at, updated_at, status, observation)
VALUES (2, 1, 2, '2025-10-02 10:45:00', 'Exame de rotina', NOW(), NOW(), 'SCHEDULED', 'Paciente pediu atestado médico');
INSERT INTO consultation (patient_id, doctor_id, nurse_id, consultation_date, reason, created_at, updated_at, status, observation)
VALUES (1, 1, 1, '2025-10-03 09:30:00', 'Acompanhamento cardiológico', NOW(), NOW(), 'DONE', 'Paciente com melhora significativa');
INSERT INTO consultation (patient_id, doctor_id, nurse_id, consultation_date, reason, created_at, updated_at, status, observation)
VALUES (2, 2, 2, '2025-10-04 14:15:00', 'Dor abdominal', NOW(), NOW(), 'SCHEDULED', 'Solicitada ultrassonografia abdominal');
