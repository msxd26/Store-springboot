INSERT INTO categories (name, description, enabled) VALUES
                                                       ('Electronics', 'Devices and gadgets', true),
                                                       ('Furniture', 'Household furniture', true),
                                                       ('Clothing', 'Apparel and accessories', true),
                                                       ('Books', 'Various genres of books', true);


INSERT INTO customers (company_name, type_document, number_document, address, name_contact, email_contact, cellphone_contact, enabled) VALUES
                                                                                                                                          ('Tech Innovations', 'RUC', '12345678901', '123 Tech Street', 'John Doe', 'john.doe@techinnovations.com', '0987654321', true),
                                                                                                                                          ('Home Comfort', 'RUC', '10987654321', '456 Furniture Road', 'Jane Smith', 'jane.smith@homecomfort.com', '0976543210', true),
                                                                                                                                          ('Fashion Central', 'RUC', '11223344556', '789 Apparel Avenue', 'Emily Johnson', 'emily.johnson@fashioncentral.com', '0965432109', true);

INSERT INTO products (id_category, code, name, price, stock, description, enabled) VALUES
                                                                                      (1, 'ELEC001', 'Smartphone XYZ', 699.99, 50, 'Latest model with high-end features', true),
                                                                                      (2, 'FURN001', 'Office Chair', 129.99, 100, 'Ergonomic office chair with lumbar support', true),
                                                                                      (3, 'CLOTH001', 'Winter Jacket', 89.99, 200, 'Warm winter jacket with detachable hood', true),
                                                                                      (4, 'BOOK001', 'The Great Gatsby', 14.99, 300, 'Classic novel by F. Scott Fitzgerald', true);
INSERT INTO roles (name, description, enabled) VALUES
                                                  ('Admin', 'Administrator with full access', true),
                                                  ('Manager', 'Manager with access to most features', true),
                                                  ('Salesperson', 'Handles sales transactions', true),
                                                  ('Customer Service', 'Manages customer inquiries and support', true);
INSERT INTO suppliers (company_name, type_document, number_document, address, name_contact, email_contact, cellphone_contact, enabled) VALUES
                                                                                                                                          ('Gadget Suppliers Inc.', 'RUC', '12345678901', '321 Supply Lane', 'Michael Brown', 'michael.brown@gadgetsuppliers.com', '0954321098', true),
                                                                                                                                          ('Furniture Distributors', 'RUC', '10987654321', '654 Distribution Blvd', 'Sarah Lee', 'sarah.lee@furnituredist.com', '0943210987', true),
                                                                                                                                          ('Clothing Hub', 'RUC', '11223344556', '987 Fashion Street', 'Tom Wilson', 'tom.wilson@clothinghub.com', '0932109876', true);
INSERT INTO users (full_name, type_document, number_document, address, cellphone, username, "password", enabled) VALUES
                                                                                                                    ('Alice Cooper', 'DNI', '12345678', '123 Main St', '0912345678', 'alice', 'password123', true),
                                                                                                                    ('Bob Brown', 'DNI', '87654321', '456 Elm St', '0923456789', 'bob', 'password456', true);
INSERT INTO users_roles (id_users, id_roles) VALUES
                                                 (1, 1),  -- Alice Cooper as Admin
                                                 (2, 3);  -- Bob Brown as Salesperson
INSERT INTO incomes (id_supplier, id_user, type_invoice, serial_invoice, number_invoice, date_time, tax, total, enabled) VALUES
                                                                                                                            (1, 1, 'Purchase', 'A001', '000123', '2024-08-01 10:00:00+00', 15.00, 1000.00, true),
                                                                                                                            (2, 2, 'Purchase', 'B002', '000456', '2024-08-02 11:00:00+00', 10.00, 500.00, true);
INSERT INTO sales (id_customer, id_user, type_invoice, serial_invoice, number_invoice, date_time, tax, total, enabled) VALUES
                                                                                                                          (1, 1, 'Sale', 'S001', '001234', '2024-08-05 14:00:00', 8.00, 200.00, true),
                                                                                                                          (2, 2, 'Sale', 'S002', '001235', '2024-08-06 15:00:00', 12.00, 300.00, true);
INSERT INTO sales_details (id_sale_detail, id_product, id_sale, quantity, sale_price, discount) VALUES
                                                                                                    ('e5b00b7e-9a3c-4b1a-9df1-5a8d6b2a4d21', 1, 1, 2, 699.99, 0.00),
                                                                                                    ('d73b7c1e-0e48-4a1b-9f58-9c6c2c4e2d1f', 4, 2, 3, 14.99, 5.00);
INSERT INTO income_details (id_income_details, id_income, id_product, quantity, price) VALUES
                                                                                           ('a53e2b77-5a5b-4c4d-8f75-6b0a16b6a8d0', 1, 1, 10, 1000.00),
                                                                                           ('fb3c4f47-72d8-4a9b-83b0-7c8c10b40a51', 2, 2, 5, 500.00);
