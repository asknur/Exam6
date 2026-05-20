INSERT INTO usr (username, email, password, full_name, bio)
VALUES ('admin', 'admin@mail.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', 'Admin',
        'Site administrator'),
       ('john', 'john@mail.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', 'John Doe',
        'Just a user'),
       ('jane', 'jane@mail.com', '$2a$12$WB2YUbFcCN0tm44SBcKUjua9yiFBsfB3vW02IjuwzY7HGtlQIKzy2', 'Jane Smith',
        'Another user');
-- пароль для всех: qwe