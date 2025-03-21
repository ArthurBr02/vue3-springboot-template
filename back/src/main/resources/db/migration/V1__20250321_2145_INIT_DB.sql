create table if not exists user (
    id bigint auto_increment primary key,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    email varchar(255) not null,
    password varchar(255) not null,
    locale varchar(255) not null default 'fr',
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp
);