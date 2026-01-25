-- USER SEED DATA (Kept your existing users)
-- password in plaintext: "password"
INSERT INTO USER (user_id, password, email, username, name, last_name, active)
VALUES (1, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'admin@securebank.com', 'admin', 'System', 'Admin', 1);

INSERT INTO USER (user_id, password, email, username, name, last_name, active)
VALUES (2, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'johndoe@gmail.com', 'johndoe', 'John', 'Doe', 1);

-- ROLE SEED DATA
INSERT INTO ROLE (role_id, role) VALUES (1, 'ROLE_ADMIN');
INSERT INTO ROLE (role_id, role) VALUES (2, 'ROLE_USER');

-- ASSIGN ROLES
INSERT INTO USER_ROLE (user_id, role_id) VALUES (1, 1); -- Admin has Admin role
INSERT INTO USER_ROLE (user_id, role_id) VALUES (1, 2); -- Admin has User role
INSERT INTO USER_ROLE (user_id, role_id) VALUES (2, 2); -- John has User role

-- BANK ACCOUNT SEED DATA
-- Map these to your new ACCOUNT Entity
-- Fields: name (Account Type), description, balance (was price), account_number (was quantity)
INSERT INTO ACCOUNT (name, description, balance, account_number)
VALUES ('Checking Account', 'Primary Everyday Spending', 1250.50, 'ACT-778899');

INSERT INTO ACCOUNT (name, description, balance, account_number)
VALUES ('Savings Account', 'High-Interest Wealth Fund', 45000.00, 'SAV-112233');

INSERT INTO ACCOUNT (name, description, balance, account_number)
VALUES ('Investment Account', 'Stock Market Portfolio', 1200.00, 'INV-445566');

INSERT INTO ACCOUNT (name, description, balance, account_number)
VALUES ('Credit Line', 'Emergency Backup Credit', 5000.00, 'CRD-990011');
