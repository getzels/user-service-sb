CREATE SCHEMA IF NOT EXISTS test_db;

CREATE TABLE test_db."user" (
                                user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                user_name VARCHAR(255)
);

CREATE TABLE test_db.department (
                                    department_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    department_name VARCHAR(255)
);

CREATE TABLE test_db.department_user (
                                         department_id BIGINT NOT NULL,
                                         user_id BIGINT NOT NULL,
                                         PRIMARY KEY (department_id, user_id),
                                         CONSTRAINT department_user_department_id_fk
                                             FOREIGN KEY (department_id)
                                                 REFERENCES test_db.department (department_id),
                                         CONSTRAINT department_user_user_id_fk
                                             FOREIGN KEY (user_id)
                                                 REFERENCES test_db."user" (user_id)
);

INSERT INTO test_db.department (department_name)
VALUES ('department1'),
       ('department2'),
       ('department3'),
       ('department4'),
       ('department5'),
       ('department6'),
       ('department7'),
       ('department8'),
       ('department9'),
       ('department10');

INSERT INTO test_db."user" (user_name)
VALUES ('user1'),
       ('user2'),
       ('user3'),
       ('user4'),
       ('user5'),
       ('user6'),
       ('user7'),
       ('user8'),
       ('user9'),
       ('user10');

INSERT INTO test_db.department_user (department_id, user_id)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (2, 4),
       (3, 5),
       (3, 6),
       (3, 7),
       (3, 8),
       (3, 9),
       (3, 10),
       (4, 1),
       (4, 2),
       (4, 3),
       (4, 4),
       (5, 5),
       (5, 6),
       (6, 7),
       (6, 8),
       (6, 9),
       (6, 10),
       (7, 1),
       (7, 2),
       (7, 3);
