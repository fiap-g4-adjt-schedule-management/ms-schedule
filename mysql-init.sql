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