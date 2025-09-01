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
    CONSTRAINT pk_patient PRIMARY KEY (id)
)ENGINE=INNODB;

CREATE TABLE speciality
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)          NULL,
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
    CONSTRAINT pk_doctor PRIMARY KEY (id),
    CONSTRAINT fk_doctor_on_speciality FOREIGN KEY (speciality_id) REFERENCES speciality (id)
)ENGINE=INNODB;

INSERT INTO patient
    (name, cpf, email, phone, zip_code, street, number, complement, neighborhood, city, state)
VALUES
    ('João Silva', '12345678901', 'joao.silva@email.com', '11987654321', '01001-000', 'Av. Paulista', '1000', 'Ap 12', 'Bela Vista', 'São Paulo', 'SP'),
    ('Maria Souza', '98765432100', 'maria.souza@email.com', '11912345678', '20040-010', 'Rua das Flores', '250', NULL, 'Centro', 'Rio de Janeiro', 'RJ'),
    ('Pedro Santos', '45678912377', 'pedro.santos@email.com', '11999998888', '30140-071', 'Rua da Bahia', '350', NULL, 'Funcionários', 'Belo Horizonte', 'MG'),
    ('Ana Oliveira', '32165498700', 'ana.oliveira@email.com', '11922223333', '40020-000', 'Av. Sete de Setembro', '789', 'Sala 5', 'Pelourinho', 'Salvador', 'BA'),
    ('Lucas Lima', '74185296311', 'lucas.lima@email.com', '11944445555', '60025-000', 'Av. Beira Mar', '123', NULL, 'Meireles', 'Fortaleza', 'CE'),
    ('Carla Ferreira', '85296374122', 'carla.ferreira@email.com', '11966667777', '70040-010', 'Esplanada', '10', 'Bloco A', 'Plano Piloto', 'Brasília', 'DF'),
    ('Rafael Almeida', '15975348600', 'rafael.almeida@email.com', '11955556666', '80010-000', 'Rua XV de Novembro', '456', NULL, 'Centro', 'Curitiba', 'PR'),
    ('Fernanda Costa', '36925814700', 'fernanda.costa@email.com', '11988887777', '88010-000', 'Rua Felipe Schmidt', '789', 'Ap 101', 'Centro', 'Florianópolis', 'SC'),
    ('Rodrigo Martins', '95175385200', 'rodrigo.martins@email.com', '11911112222', '64000-000', 'Av. Frei Serafim', '1234', NULL, 'Centro', 'Teresina', 'PI'),
    ('Juliana Rocha', '25836914700', 'juliana.rocha@email.com', '11977778888', '69005-000', 'Rua dos Andradas', '567', NULL, 'Centro', 'Manaus', 'AM');

INSERT INTO speciality
    (name)
VALUES
    ('Cardiologia'),
    ('Pediatria'),
    ('Ortopedia'),
    ('Dermatologia'),
    ('Ginecologia'),
    ('Neurologia'),
    ('Psiquiatria'),
    ('Oftalmologia'),
    ('Endocrinologia'),
    ('Urologia');

INSERT INTO doctor
    (name, cpf, phone, email, crm, speciality_id, zip_code, street, number, complement, neighborhood, city, state)
VALUES
    ('Dr. Marcos Silva', '12345678911', '11911110000', 'marcos.silva@hospital.com', 'CRM12345SP', 1, '01001-000', 'Av. Paulista', '2000', 'Conj 45', 'Bela Vista', 'São Paulo', 'SP'),
    ('Dra. Camila Santos', '98765432111', '11922220000', 'camila.santos@hospital.com', 'CRM54321RJ', 2, '20040-010', 'Rua das Flores', '300', NULL, 'Centro', 'Rio de Janeiro', 'RJ'),
    ('Dr. Henrique Almeida', '45678912311', '11933330000', 'henrique.almeida@hospital.com', 'CRM67890MG', 3, '30140-071', 'Rua da Bahia', '150', NULL, 'Funcionários', 'Belo Horizonte', 'MG'),
    ('Dra. Beatriz Oliveira', '32165498711', '11944440000', 'beatriz.oliveira@hospital.com', 'CRM13579BA', 4, '40020-000', 'Av. Sete de Setembro', '950', 'Sala 12', 'Pelourinho', 'Salvador', 'BA'),
    ('Dr. Felipe Lima', '74185296322', '11955550000', 'felipe.lima@hospital.com', 'CRM24680CE', 5, '60025-000', 'Av. Beira Mar', '321', NULL, 'Meireles', 'Fortaleza', 'CE'),
    ('Dra. Patrícia Ferreira', '85296374133', '11966660000', 'patricia.ferreira@hospital.com', 'CRM11223DF', 6, '70040-010', 'Esplanada', '20', 'Bloco B', 'Plano Piloto', 'Brasília', 'DF'),
    ('Dr. Gustavo Rocha', '15975348611', '11977770000', 'gustavo.rocha@hospital.com', 'CRM44556PR', 7, '80010-000', 'Rua XV de Novembro', '567', NULL, 'Centro', 'Curitiba', 'PR'),
    ('Dra. Larissa Costa', '36925814722', '11988880000', 'larissa.costa@hospital.com', 'CRM77889SC', 8, '88010-000', 'Rua Felipe Schmidt', '890', 'Ap 202', 'Centro', 'Florianópolis', 'SC'),
    ('Dr. André Martins', '95175385211', '11999990000', 'andre.martins@hospital.com', 'CRM99001PI', 9, '64000-000', 'Av. Frei Serafim', '432', NULL, 'Centro', 'Teresina', 'PI'),
    ('Dra. Carolina Souza', '25836914711', '11910101010', 'carolina.souza@hospital.com', 'CRM22334AM', 10, '69005-000', 'Rua dos Andradas', '678', NULL, 'Centro', 'Manaus', 'AM');
