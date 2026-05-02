-- Authorities
insert into authorities (authority)
values ('MAKE'),
       ('EDIT'),
       ('REMOVE'),
       ('READ_ONLY');

-- Roles
insert into roles(role)
values ('ADMIN'),
       ('USER');

-- Role_auth
-- Role_auth
insert into role_auth (auth_id, role_id)
values ((select id from authorities where authority = 'READ_ONLY'),
        (select id from roles where role = 'USER')),

       ((select id from authorities where authority = 'MAKE'),
        (select id from roles where role = 'USER')),

       ((select id from authorities where authority = 'READ_ONLY'),
        (select id from roles where role = 'ADMIN')),

       ((select id from authorities where authority = 'MAKE'),
        (select id from roles where role = 'ADMIN')),

       ((select id from authorities where authority = 'REMOVE'),
        (select id from roles where role = 'ADMIN'));

insert into user_role(role_id, usr_id)
values ((select id from roles where role = 'ADMIN'),
        (select id from usr where username = 'Admin')),
       ((select id from roles where role = 'USER'),
        (select id from usr where email = 'Айгерим')),
       ((select id from roles where role = 'USER'),
        (select id from usr where email = 'Тимур'));
