INSERT INTO authorities (authority)
VALUES ('MAKE'),
       ('EDIT'),
       ('REMOVE'),
       ('READ_ONLY');

INSERT INTO roles(role)
VALUES ('APPLICANT'),
       ('EMPLOYER');

-- password=test123
INSERT INTO users (phone_number, username, password, role, enabled)
VALUES ('996700000000', 'Admin', '$2a$10$TwTLk6VeT3MmmAXXNcJpCeVidM0snQ8i3TlNrHx6HCAlXAWkNQCOe', 'ADMIN', true);

INSERT INTO users (phone_number, username, password, role, blocked)
VALUES ('996700112233', 'Айгерим', '$2a$10$TwTLk6VeT3MmmAXXNcJpCeVidM0snQ8i3TlNrHx6HCAlXAWkNQCOe', 'USER', true);

INSERT INTO users (phone_number, username, password, role, blocked)
VALUES ('996555223344', 'Тимур', '$2a$10$TwTLk6VeT3MmmAXXNcJpCeVidM0snQ8i3TlNrHx6HCAlXAWkNQCOe', 'USER', true);

INSERT INTO accounts (account_number, user_id, currency, balance)
VALUES ('A1-USD', 2, 'USD', 500.0000);

INSERT INTO accounts (account_number, user_id, currency, balance)
VALUES ('A1-EUR', 2, 'EUR', 300.0000);

INSERT INTO accounts (account_number, user_id, currency, balance)
VALUES ('A2-USD', 3, 'USD', 200.0000);

INSERT INTO accounts (account_number, user_id, currency, balance)
VALUES ('A2-KGS', 3, 'KGS', 10000.0000);
