CREATE TABLE credentials
(
    id          BIGINT AUTO_INCREMENT               NOT NULL,
    email       VARCHAR(255)                        NOT NULL,
    password    VARCHAR(255)                        NOT NULL,
    user_type   ENUM('PATIENT', 'NURSE', 'DOCTOR')  NOT NULL,
    CONSTRAINT pk_credentials PRIMARY KEY (id)
)ENGINE=INNODB;

CREATE TABLE patient
(
    id              BIGINT AUTO_INCREMENT  NOT NULL,
    name            VARCHAR(255)           NULL,
    cpf             VARCHAR(255)           NULL,
    email           VARCHAR(255)           NOT NULL,
    phone           VARCHAR(255)           NULL,
    zip_code        VARCHAR(255)           NULL,
    street          VARCHAR(255)           NULL,
    number          VARCHAR(255)           NULL,
    complement      VARCHAR(255)           NULL,
    neighborhood    VARCHAR(255)           NULL,
    city            VARCHAR(255)           NULL,
    state           VARCHAR(255)           NULL,
    created_at      DATETIME               NOT NULL,
    updated_at      DATETIME               NOT NULL,
    credentials_id  BIGINT NOT NULL,
    CONSTRAINT pk_patient
        PRIMARY KEY (id),
    CONSTRAINT fk_patient_on_credentials
        FOREIGN KEY (credentials_id)
        REFERENCES credentials (id)
)ENGINE=INNODB;

CREATE TABLE speciality
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    name        VARCHAR(255)          NULL,
    created_at  DATETIME              NOT NULL,
    updated_at  DATETIME              NOT NULL,
    CONSTRAINT pk_speciality PRIMARY KEY (id)
)ENGINE=INNODB;

CREATE TABLE doctor
(
    id              BIGINT AUTO_INCREMENT   NOT NULL,
    name            VARCHAR(255)            NULL,
    cpf             VARCHAR(255)            NULL,
    phone           VARCHAR(255)            NULL,
    email           VARCHAR(255)            NOT NULL,
    crm             VARCHAR(255)            NULL,
    speciality_id   BIGINT                  NULL,
    zip_code        VARCHAR(255)            NULL,
    street          VARCHAR(255)            NULL,
    number          VARCHAR(255)            NULL,
    complement      VARCHAR(255)            NULL,
    neighborhood    VARCHAR(255)            NULL,
    city            VARCHAR(255)            NULL,
    state           VARCHAR(255)            NULL,
    created_at      DATETIME                NOT NULL,
    updated_at      DATETIME                NOT NULL,
    credentials_id  BIGINT                  NOT NULL,
    CONSTRAINT pk_doctor
        PRIMARY KEY (id),
    CONSTRAINT fk_doctor_on_speciality
        FOREIGN KEY (speciality_id)
        REFERENCES speciality (id),
    CONSTRAINT fk_doctor_on_credentials
        FOREIGN KEY (credentials_id)
        REFERENCES credentials (id)
)ENGINE=INNODB;

CREATE TABLE nurse
(
    id              BIGINT AUTO_INCREMENT   NOT NULL,
    name            VARCHAR(255)            NULL,
    cpf             VARCHAR(255)            NULL,
    phone           VARCHAR(255)            NULL,
    email           VARCHAR(255)            NOT NULL,
    coren           VARCHAR(255)            NULL,
    zip_code        VARCHAR(255)            NULL,
    street          VARCHAR(255)            NULL,
    number          VARCHAR(255)            NULL,
    complement      VARCHAR(255)            NULL,
    neighborhood    VARCHAR(255)            NULL,
    city            VARCHAR(255)            NULL,
    state           VARCHAR(255)            NULL,
    created_at      DATETIME                NOT NULL,
    updated_at      DATETIME                NOT NULL,
    credentials_id  BIGINT                  NOT NULL,
    CONSTRAINT pk_nurse PRIMARY KEY (id),
    CONSTRAINT fk_nurse_on_credentials
        FOREIGN KEY (credentials_id)
        REFERENCES credentials (id)
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

-- Pacientes
INSERT INTO credentials (email, password, user_type) VALUES
     ('paciente1@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'PATIENT'),
     ('paciente2@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'PATIENT'),
     ('paciente3@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'PATIENT'),
     ('paciente4@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'PATIENT'),
     ('paciente5@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'PATIENT'),
     ('paciente6@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'PATIENT'),
     ('paciente7@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'PATIENT'),
     ('paciente8@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'PATIENT'),
     ('paciente9@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'PATIENT'),
     ('paciente10@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'PATIENT');

-- Enfermeiros
INSERT INTO credentials (email, password, user_type) VALUES
     ('nurse1@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'NURSE'),
     ('nurse2@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'NURSE'),
     ('nurse3@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'NURSE'),
     ('nurse4@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'NURSE'),
     ('nurse5@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'NURSE'),
     ('nurse6@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'NURSE'),
     ('nurse7@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'NURSE'),
     ('nurse8@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'NURSE'),
     ('nurse9@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'NURSE'),
     ('nurse10@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'NURSE');

-- Médicos
INSERT INTO credentials (email, password, user_type) VALUES
     ('doctor1@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'DOCTOR'),
     ('doctor2@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'DOCTOR'),
     ('doctor3@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'DOCTOR'),
     ('doctor4@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'DOCTOR'),
     ('doctor5@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'DOCTOR'),
     ('doctor6@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'DOCTOR'),
     ('doctor7@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'DOCTOR'),
     ('doctor8@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'DOCTOR'),
     ('doctor9@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'DOCTOR'),
     ('doctor10@example.com', '$2a$10$6a7NTaaZlMLfxdaRqrjk/OxmPV0gZHOBly7tqehm1OvUndNHm42WG', 'DOCTOR');

INSERT INTO patient (name, cpf, email, phone, zip_code, street, number, complement, neighborhood, city, state, created_at, updated_at, credentials_id) VALUES
    ('João da Silva', '11111111111', 'paciente1@example.com', '(11)90001-0001', '01001-000', 'Rua A', '101', NULL, 'Centro', 'São Paulo', 'SP', NOW(), NOW(), 1),
    ('Maria Souza', '22222222222', 'paciente2@example.com', '(11)90001-0002', '01001-001', 'Rua B', '102', NULL, 'Bela Vista', 'São Paulo', 'SP', NOW(), NOW(), 2),
    ('Carlos Pereira', '33333333333', 'paciente3@example.com', '(11)90001-0003', '01001-002', 'Rua C', '103', NULL, 'Moema', 'São Paulo', 'SP', NOW(), NOW(), 3),
    ('Ana Oliveira', '44444444444', 'paciente4@example.com', '(11)90001-0004', '01001-003', 'Rua D', '104', NULL, 'Pinheiros', 'São Paulo', 'SP', NOW(), NOW(), 4),
    ('Pedro Santos', '55555555555', 'paciente5@example.com', '(11)90001-0005', '01001-004', 'Rua E', '105', NULL, 'Liberdade', 'São Paulo', 'SP', NOW(), NOW(), 5),
    ('Juliana Costa', '66666666666', 'paciente6@example.com', '(11)90001-0006', '01001-005', 'Rua F', '106', NULL, 'Consolação', 'São Paulo', 'SP', NOW(), NOW(), 6),
    ('Lucas Almeida', '77777777777', 'paciente7@example.com', '(11)90001-0007', '01001-006', 'Rua G', '107', NULL, 'Jardins', 'São Paulo', 'SP', NOW(), NOW(), 7),
    ('Fernanda Lima', '88888888888', 'paciente8@example.com', '(11)90001-0008', '01001-007', 'Rua H', '108', NULL, 'Ipiranga', 'São Paulo', 'SP', NOW(), NOW(), 8),
    ('Ricardo Gomes', '99999999999', 'paciente9@example.com', '(11)90001-0009', '01001-008', 'Rua I', '109', NULL, 'Santana', 'São Paulo', 'SP', NOW(), NOW(), 9),
    ('Patrícia Ribeiro', '10101010101', 'paciente10@example.com', '(11)90001-0010', '01001-009', 'Rua J', '110', NULL, 'Tatuapé', 'São Paulo', 'SP', NOW(), NOW(), 10);

INSERT INTO nurse (name, cpf, phone, email, coren, zip_code, street, number, complement, neighborhood, city, state, created_at, updated_at, credentials_id) VALUES
    ('Nurse 1', '12121212121', '(11)98888-0001', 'nurse1@example.com', 'COREN001', '02001-000', 'Rua N1', '201', NULL, 'Centro', 'São Paulo', 'SP', NOW(), NOW(), 11),
    ('Nurse 2', '13131313131', '(11)98888-0002', 'nurse2@example.com', 'COREN002', '02001-001', 'Rua N2', '202', NULL, 'Bela Vista', 'São Paulo', 'SP', NOW(), NOW(), 12),
    ('Nurse 3', '14141414141', '(11)98888-0003', 'nurse3@example.com', 'COREN003', '02001-002', 'Rua N3', '203', NULL, 'Moema', 'São Paulo', 'SP', NOW(), NOW(), 13),
    ('Nurse 4', '15151515151', '(11)98888-0004', 'nurse4@example.com', 'COREN004', '02001-003', 'Rua N4', '204', NULL, 'Pinheiros', 'São Paulo', 'SP', NOW(), NOW(), 14),
    ('Nurse 5', '16161616161', '(11)98888-0005', 'nurse5@example.com', 'COREN005', '02001-004', 'Rua N5', '205', NULL, 'Liberdade', 'São Paulo', 'SP', NOW(), NOW(), 15),
    ('Nurse 6', '17171717171', '(11)98888-0006', 'nurse6@example.com', 'COREN006', '02001-005', 'Rua N6', '206', NULL, 'Consolação', 'São Paulo', 'SP', NOW(), NOW(), 16),
    ('Nurse 7', '18181818181', '(11)98888-0007', 'nurse7@example.com', 'COREN007', '02001-006', 'Rua N7', '207', NULL, 'Jardins', 'São Paulo', 'SP', NOW(), NOW(), 17),
    ('Nurse 8', '19191919191', '(11)98888-0008', 'nurse8@example.com', 'COREN008', '02001-007', 'Rua N8', '208', NULL, 'Ipiranga', 'São Paulo', 'SP', NOW(), NOW(), 18),
    ('Nurse 9', '20202020202', '(11)98888-0009', 'nurse9@example.com', 'COREN009', '02001-008', 'Rua N9', '209', NULL, 'Santana', 'São Paulo', 'SP', NOW(), NOW(), 19),
    ('Nurse 10', '21212121212', '(11)98888-0010', 'nurse10@example.com', 'COREN010', '02001-009', 'Rua N10', '210', NULL, 'Tatuapé', 'São Paulo', 'SP', NOW(), NOW(), 20);

INSERT INTO doctor (name, cpf, phone, email, crm, speciality_id, zip_code, street, number, complement, neighborhood, city, state, created_at, updated_at, credentials_id) VALUES
    ('Doctor 1', '31313131313', '(11)97777-0001', 'doctor1@example.com', 'CRM001', 1, '03001-000', 'Rua D1', '301', NULL, 'Centro', 'São Paulo', 'SP', NOW(), NOW(), 21),
    ('Doctor 2', '32323232323', '(11)97777-0002', 'doctor2@example.com', 'CRM002', 2, '03001-001', 'Rua D2', '302', NULL, 'Bela Vista', 'São Paulo', 'SP', NOW(), NOW(), 22),
    ('Doctor 3', '33333333333', '(11)97777-0003', 'doctor3@example.com', 'CRM003', 3, '03001-002', 'Rua D3', '303', NULL, 'Moema', 'São Paulo', 'SP', NOW(), NOW(), 23),
    ('Doctor 4', '34343434343', '(11)97777-0004', 'doctor4@example.com', 'CRM004', 1, '03001-003', 'Rua D4', '304', NULL, 'Pinheiros', 'São Paulo', 'SP', NOW(), NOW(), 24),
    ('Doctor 5', '35353535353', '(11)97777-0005', 'doctor5@example.com', 'CRM005', 2, '03001-004', 'Rua D5', '305', NULL, 'Liberdade', 'São Paulo', 'SP', NOW(), NOW(), 25),
    ('Doctor 6', '36363636363', '(11)97777-0006', 'doctor6@example.com', 'CRM006', 3, '03001-005', 'Rua D6', '306', NULL, 'Consolação', 'São Paulo', 'SP', NOW(), NOW(), 26),
    ('Doctor 7', '37373737373', '(11)97777-0007', 'doctor7@example.com', 'CRM007', 1, '03001-006', 'Rua D7', '307', NULL, 'Jardins', 'São Paulo', 'SP', NOW(), NOW(), 27),
    ('Doctor 8', '38383838383', '(11)97777-0008', 'doctor8@example.com', 'CRM008', 2, '03001-007', 'Rua D8', '308', NULL, 'Ipiranga', 'São Paulo', 'SP', NOW(), NOW(), 28),
    ('Doctor 9', '39393939393', '(11)97777-0009', 'doctor9@example.com', 'CRM009', 3, '03001-008', 'Rua D9', '309', NULL, 'Santana', 'São Paulo', 'SP', NOW(), NOW(), 29),
    ('Doctor 10', '40404040404', '(11)97777-0010', 'doctor10@example.com', 'CRM010', 1, '03001-009', 'Rua D10', '310', NULL, 'Tatuapé', 'São Paulo', 'SP', NOW(), NOW(), 30);

INSERT INTO consultation (patient_id, doctor_id, nurse_id, consultation_date, reason, created_at, updated_at, status, observation) VALUES
    (1, 1, 1, '2025-10-01 09:00:00', 'Rotina', NOW(), NOW(), 'SCHEDULED', 'Consulta inicial'),
    (2, 2, 2, '2025-10-01 10:00:00', 'Dor no joelho', NOW(), NOW(), 'SCHEDULED', 'Paciente relatou dor'),
    (3, 3, 3, '2025-10-02 11:00:00', 'Exame pediátrico', NOW(), NOW(), 'DONE', 'Exame realizado'),
    (4, 4, 4, '2025-10-02 14:00:00', 'Checkup anual', NOW(), NOW(), 'CANCELED', 'Paciente desmarcou'),
    (5, 5, 5, '2025-10-03 09:30:00', 'Consulta cardiológica', NOW(), NOW(), 'SCHEDULED', NULL),
    (6, 6, 6, '2025-10-03 15:00:00', 'Dor abdominal', NOW(), NOW(), 'DONE', 'Prescrição dada'),
    (7, 7, 7, '2025-10-04 08:00:00', 'Exame de sangue', NOW(), NOW(), 'SCHEDULED', NULL),
    (8, 8, 8, '2025-10-04 16:00:00', 'Consulta pediatria', NOW(), NOW(), 'LOST', 'Paciente não compareceu'),
    (9, 9, 9, '2025-10-05 11:30:00', 'Rotina ginecológica', NOW(), NOW(), 'SCHEDULED', NULL),
    (10, 10, 10, '2025-10-05 13:00:00', 'Avaliação ortopédica', NOW(), NOW(), 'SCHEDULED', 'Paciente em observação');
