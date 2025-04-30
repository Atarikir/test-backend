create table if not exists author
(
    id            serial primary key,
    full_name     varchar(255) not null,
    creation_date timestamp not null default current_timestamp
);