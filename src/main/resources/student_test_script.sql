create table users
(
	id serial not null
		constraint users_pk
		primary key,
	name varchar(255) not null,
	login varchar(50) not null
		constraint users_login_key
		unique,
	password varchar(100) not null
)
;

alter table users owner to postgres
;

create table teachers
(
	id serial not null
		constraint teachers_pk
		primary key
		constraint teachers_users_id_fk
		references users,
	specialization varchar(255) not null
)
;

alter table teachers owner to postgres
;

create table admins
(
	id serial not null
		constraint admins_pk
		primary key
		constraint admins_users_id_fk
		references users
)
;

alter table admins owner to postgres
;

create table groups
(
	id serial not null
		constraint groups_pk
		primary key,
	name varchar(30) not null,
	internal boolean not null,
	number integer not null
)
;

alter table groups owner to postgres
;

create table students
(
	id serial not null
		constraint students_pk
		primary key
		constraint students_user_id_fk
		references users,
	group_id integer not null
		constraint students_group_id_fk
		references groups
)
;

alter table students owner to postgres
;

create table teachers_groups
(
	teacher_id integer not null
		constraint teachers_id_fk
		references teachers,
	group_id integer not null
		constraint groups_id_fk
		references groups,
	constraint teachers_group_pk
	primary key (teacher_id, group_id)
)
;

alter table teachers_groups owner to postgres
;

create table tests
(
	id serial not null
		constraint tests_pk
		primary key,
	description varchar(255) not null,
	teacher_id integer not null
		constraint tests_teachers_id_fk
		references teachers
)
;

alter table tests owner to postgres
;

create table questions
(
	id serial not null
		constraint questions_pk
		primary key,
	text varchar(255) not null,
	test_id integer not null
		constraint questions_test_id_fk
		references tests
)
;

alter table questions owner to postgres
;

create table answers
(
	id serial not null
		constraint answers_pk
		primary key,
	text varchar(255) not null,
	correct boolean not null,
	question_id integer not null
		constraint answers_questions_id_fk
		references questions
)
;

alter table answers owner to postgres
;

create table groups_tests
(
	group_id integer not null
		constraint groups_id_fk
		references groups,
	test_id integer not null
		constraint tests_id_fk
		references tests,
	constraint groups_tests_pk
	primary key (group_id, test_id)
)
;

alter table groups_tests owner to postgres
;

create table results
(
	student_id integer not null
		constraint students_id_fk
		references students,
	test_id integer not null
		constraint tests_id_fk
		references tests,
	grade integer not null,
	constraint tests_results_pk
	primary key (student_id, test_id)
)
;

alter table results owner to postgres
;