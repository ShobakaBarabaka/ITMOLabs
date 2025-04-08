DROP TABLE IF EXISTS human CASCADE;
DROP TABLE IF EXISTS council CASCADE;
DROP TABLE IF EXISTS central_computer CASCADE;
DROP TABLE IF EXISTS hall CASCADE;
DROP TABLE IF EXISTS desk CASCADE;
DROP TABLE IF EXISTS doors CASCADE;
DROP TABLE IF EXISTS question CASCADE;
DROP TABLE IF EXISTS job CASCADE;
DROP TABLE IF EXISTS human_council_relation CASCADE;

CREATE TABLE human (
    human_id SERIAL PRIMARY KEY,
    council_membership BOOL NOT NULL,
    name VARCHAR(50) NOT NULL,
    date_of_birth DATE NOT NULL,
    is_male BOOL
);

CREATE TABLE council (
    council_id SERIAL PRIMARY KEY,
    number_of_members INT CHECK(number_of_members >= 0) NOT NULL,
    type_of_meeting VARCHAR(100),
    date_of_meeting DATE
);

CREATE TABLE central_computer (
    central_computer_id SERIAL PRIMARY KEY,
    number_of_solved_questions INTEGER CHECK(number_of_solved_questions >= 0),
    date_of_conversation DATE
);

CREATE TABLE hall (
    hall_id SERIAL PRIMARY KEY,
    hall_size VARCHAR(50),
    location VARCHAR(50),
    whose_hall VARCHAR(50),
    council_id INT REFERENCES council(council_id)
);

CREATE TABLE desk (
    desk_id SERIAL PRIMARY KEY,
    material VARCHAR(50) NOT NULL,
    shape VARCHAR(100) NOT NULL,
    hall_id INT REFERENCES hall(hall_id)
);


CREATE TABLE doors (
    doors_id SERIAL PRIMARY KEY,
    door_size VARCHAR(50) NOT NULL,
    type_of_doors VARCHAR(50),
    hall_id INT REFERENCES hall(hall_id)
);


CREATE TABLE question (
    question_id SERIAL PRIMARY KEY,
    importance VARCHAR(50),
    is_solved BOOL,
    council_id INT REFERENCES council(council_id),
    central_computer_id INT REFERENCES central_computer(central_computer_id)
);

CREATE TABLE job (
    job_id SERIAL PRIMARY KEY,
    description VARCHAR(100) NOT NULL,
    rating INT CHECK (rating >= 0 AND rating <= 100),
    human_id INT REFERENCES human(human_id)
);

CREATE TABLE human_council_relation (
    human_id INT REFERENCES human(human_id),
    council_id INT REFERENCES council(council_id),
    PRIMARY KEY(human_id, council_id)
);

INSERT INTO human (council_membership, name, date_of_birth, is_male) VALUES (TRUE, 'Джизирак', '1705-11-07', TRUE);
INSERT INTO human (council_membership, name, date_of_birth, is_male) VALUES (TRUE, 'Олвин', '1744-12-30', TRUE);
INSERT INTO human (council_membership, name, date_of_birth, is_male) VALUES (FALSE, 'Оксана', '1761-05-04', FALSE);

INSERT INTO council (number_of_members, type_of_meeting, date_of_meeting) VALUES (12, 'Собрание', '1776-07-22');
INSERT INTO council (number_of_members, type_of_meeting, date_of_meeting) VALUES (10, 'Вечеринка', '1777-11-10');

INSERT INTO central_computer (date_of_conversation, number_of_solved_questions) VALUES ('1776-07-22', 5);
INSERT INTO central_computer (date_of_conversation, number_of_solved_questions) VALUES ('1778-04-15', 999);

INSERT INTO hall (hall_size, location, whose_hall) VALUES ('Средний', 'Горы', 'Зал короля');
INSERT INTO hall (hall_size, location, whose_hall) VALUES ('Большой', 'Пустыня', 'Зал Совета');

INSERT INTO desk (material, shape) VALUES ('дерево', 'полумесяц');
INSERT INTO desk (material, shape) VALUES ('металл', 'круг');
INSERT INTO desk (material, shape) VALUES ('пластик', 'квадрат');

INSERT INTO doors (door_size, type_of_doors) VALUES ('Огромные', 'ворота');
INSERT INTO doors (door_size, type_of_doors) VALUES ('Обычные', 'раздвижные');

INSERT INTO question (importance, is_solved) VALUES ('очень важный', TRUE);
INSERT INTO question (importance, is_solved) VALUES ('неважный', TRUE);

INSERT INTO job (description, rating) VALUES ('председатель', 81);
