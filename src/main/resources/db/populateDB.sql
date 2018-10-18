DELETE FROM answers;
DELETE FROM questions;
DELETE FROM tests;
DELETE FROM roles;
DELETE FROM users;
ALTER SEQUENCE users_id_seq RESTART WITH 1;
ALTER SEQUENCE tests_id_seq RESTART WITH 1;
ALTER SEQUENCE questions_id_seq RESTART WITH 1;
ALTER SEQUENCE answers_id_seq RESTART WITH 1;

INSERT INTO users (name, login, password, specialization_id)
VALUES
       ('teacher_name', 'teacher_login', '5', null ),
       ('teacher_name2', 'teacher_login2', '5', null ),
       ('student_name', 'student_login', '5', null ),
       ('admin_name', 'admin_login', '5', null );

INSERT INTO roles(user_id, roles)
VALUES
       (1,2),
       (2,2),
       (3,0),
       (4,1);

INSERT INTO tests(description, user_id)
VALUES
       ('test description 1',1),
       ('test description 2',1),
       ('test description 3',2);

INSERT INTO questions(text, test_id)
VALUES
       ('question text 1-1',1),
       ('question text 1-2',1),

       ('question text 2-1',2),
       ('question text 2-2',2),
       ('question text 2-3',2),

       ('question text 3-1',3),
       ('question text 3-2',3);

INSERT INTO answers(text, correct, question_id)
VALUES
       ('answer text 1-1-1',true ,1),
       ('answer text 1-1-2',false ,1),
       ('answer text 1-1-3',false ,1),
       ('answer text 1-1-4',false ,1),
       ('answer text 1-2-1',false ,2),
       ('answer text 1-2-2',false ,2),
       ('answer text 1-2-3',true ,2),
       ('answer text 1-2-4',false ,2),

       ('answer text 2-1-1',false ,3),
       ('answer text 2-1-2',true ,3),
       ('answer text 2-1-3',false ,3),
       ('answer text 2-1-4',false ,3),
       ('answer text 2-2-1',false ,4),
       ('answer text 2-2-2',false ,4),
       ('answer text 2-2-3',true ,4),
       ('answer text 2-2-4',false ,4),
       ('answer text 2-3-1',false ,5),
       ('answer text 2-3-2',false ,5),
       ('answer text 2-3-3',false ,5),
       ('answer text 2-3-4',true ,5),

       ('answer text 3-1-1',false ,6),
       ('answer text 3-1-2',false ,6),
       ('answer text 3-1-3',false ,6),
       ('answer text 3-1-4',true ,6),
       ('answer text 3-2-1',false ,7),
       ('answer text 3-2-2',false ,7),
       ('answer text 3-2-3',false ,7),
       ('answer text 3-2-4',true ,7);
