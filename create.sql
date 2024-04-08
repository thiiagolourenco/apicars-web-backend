create table cars (yeear integer, id bigserial not null, user_id bigint, color varchar(255), license_plate varchar(255) unique, model varchar(255), primary key (id));
create table users (birthday date, created_at timestamp(6), id bigserial not null, last_login timestamp(6), email varchar(255) unique, first_name varchar(255), last_name varchar(255), login varchar(255) unique, password varchar(255), phone varchar(255), role varchar(255) check (role in ('ADMIN','USER')), primary key (id));
alter table if exists cars add constraint FKqw4c8e6nqrvy3ti1xj8w8wyc9 foreign key (user_id) references users;