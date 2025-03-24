create table fic
(
    id       bigint auto_increment primary key,
    name     varchar(255) not null,
    uuid     varchar(255) not null,
    mimetype varchar(255) not null,
    size     bigint       not null,
    user_id  bigint       not null,
    type     varchar(255) not null,
    created_at datetime   not null default now(),
    updated_at datetime,
    foreign key (user_id) references user (id)
);