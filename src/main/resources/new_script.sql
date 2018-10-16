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

create table specialization
(
	name varchar(50) not null,
	id serial not null
    constraint specialization_pk
    primary key
)
;

alter table specialization owner to postgres
;

create unique index specialization_name_uindex
  on specialization (name);

create table users
(
	id serial not null
    constraint users_pk
    primary key,
	name varchar(255) not null,
	login varchar(50) not null
    constraint users_login_key
    unique,
	password varchar(100) not null,
	specialization_id integer
    constraint users_specialization_id_fk
    references specialization
)
;

alter table users owner to postgres
;

create table roles
(
  user_id serial  not null
    constraint roles_users_id_fk
    references users,
  roles   integer not null
);

alter table roles
  owner to postgres;

create table tests
(
	id serial not null
    constraint tests_pk
    primary key,
	description varchar(255) not null,
	user_id integer not null
    constraint tests_users_id_fk
    references users
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
  user_id integer not null
    constraint user_id_fk
    references users,
  test_id integer not null
    constraint tests_id_fk
    references tests,
  grade   integer not null,
  id      serial  not null
    constraint results_pk
    primary key
)
;

alter table results owner to postgres
;

create unique index results_user_id_test_id_uindex
  on results (user_id, test_id);

create table user_group
(
	user_id integer not null
    constraint user___fk
    references users,
	group_id integer not null
    constraint group___fk
    references groups,
	constraint user_group_pk
	primary key (user_id, group_id)
)
;

alter table user_group owner to postgres
;

