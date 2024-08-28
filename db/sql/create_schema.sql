

CREATE  TABLE categories (
                                      id_category          bigint  NOT NULL GENERATED  ALWAYS AS IDENTITY ,
                                      name                 varchar(50)  NOT NULL  ,
                                      description          varchar(150)  NOT NULL  ,
                                      enabled               boolean DEFAULT true NOT NULL  ,
                                      CONSTRAINT categories_pk PRIMARY KEY ( id_category )
);

CREATE  TABLE customers (
                                     id_customer          bigint  NOT NULL GENERATED  ALWAYS AS IDENTITY ,
                                     company_name         varchar(100)  NOT NULL  ,
                                     type_document        varchar(10)  NOT NULL  ,
                                     number_document      varchar(20)  NOT NULL  ,
                                     address              varchar(150)  NOT NULL  ,
                                     name_contact         varchar(50)  NOT NULL  ,
                                     email_contact        varchar(100)  NOT NULL  ,
                                     cellphone_contact    varchar(10)  NOT NULL  ,
                                     enabled               boolean DEFAULT true NOT NULL  ,
                                     CONSTRAINT customer_pk PRIMARY KEY ( id_customer )
);

CREATE  TABLE products (
                                    id_product           bigint  NOT NULL GENERATED  ALWAYS AS IDENTITY ,
                                    id_category          bigint  NOT NULL  ,
                                    code                 varchar(20)  NOT NULL  ,
                                    name                 varchar(50)  NOT NULL  ,
                                    price                numeric(11,2)  NOT NULL  ,
                                    stock                integer  NOT NULL  ,
                                    description          varchar(150)  NOT NULL  ,
                                    enabled              boolean DEFAULT true NOT NULL  ,
                                    CONSTRAINT products_pk PRIMARY KEY ( id_product )
);

CREATE  TABLE roles (
                                 id_rol               bigint  NOT NULL GENERATED  ALWAYS AS IDENTITY ,
                                 name                 varchar(50)  NOT NULL  ,
                                 description          varchar(100)  NOT NULL  ,
                                 enabled               boolean DEFAULT true NOT NULL  ,
                                 CONSTRAINT roles_pk PRIMARY KEY ( id_rol )
);

CREATE  TABLE suppliers (
                                     id_supplier          bigint  NOT NULL GENERATED  ALWAYS AS IDENTITY ,
                                     company_name         varchar(50)  NOT NULL  ,
                                     type_document        varchar(10)  NOT NULL  ,
                                     number_document      varchar(20)  NOT NULL  ,
                                     address              varchar(150)  NOT NULL  ,
                                     name_contact         varchar(50)  NOT NULL  ,
                                     email_contact        varchar(100)  NOT NULL  ,
                                     cellphone_contact    varchar(10)  NOT NULL  ,
                                     enabled               boolean DEFAULT true NOT NULL  ,
                                     CONSTRAINT supplers_pk PRIMARY KEY ( id_supplier )
);

CREATE  TABLE users (
                                 id_user              bigint  NOT NULL GENERATED  ALWAYS AS IDENTITY ,
                                 full_name            varchar(100)  NOT NULL  ,
                                 type_document        varchar(10)    ,
                                 number_document      varchar(20)    ,
                                 address              varchar(50)    ,
                                 cellphone            varchar(50)    ,
                                 username             varchar  NOT NULL  ,
                                 password              varchar(100)  NOT NULL  ,
                                 enabled               boolean DEFAULT true NOT NULL  ,
                                 CONSTRAINT users_pk PRIMARY KEY ( id_user )
);

CREATE  TABLE users_roles (
                                       id_users             bigint  NOT NULL  ,
                                       id_roles             bigint  NOT NULL  ,
                                       CONSTRAINT many_user_has_many_roles_pk PRIMARY KEY ( id_users, id_roles )
);

CREATE  TABLE incomes (
                                   id_income            bigint  NOT NULL GENERATED  ALWAYS AS IDENTITY ,
                                   id_supplier          bigint  NOT NULL  ,
                                   id_user              bigint  NOT NULL  ,
                                   type_invoice         varchar(20)  NOT NULL  ,
                                   serial_invoice       varchar(7)  NOT NULL  ,
                                   number_invoice       varchar(20)  NOT NULL  ,
                                   date_time            timestamptz  NOT NULL  ,
                                   tax                  numeric(4,2)  NOT NULL  ,
                                   total                numeric(11,2)  NOT NULL  ,
                                   enabled               boolean DEFAULT true NOT NULL  ,
                                   CONSTRAINT incomes_pk PRIMARY KEY ( id_income )
);

CREATE  TABLE sales (
                                 id_sale              bigint  NOT NULL GENERATED  ALWAYS AS IDENTITY ,
                                 id_customer          bigint  NOT NULL  ,
                                 id_user              bigint  NOT NULL  ,
                                 type_invoice         varchar(20)  NOT NULL  ,
                                 serial_invoice       varchar(7)  NOT NULL  ,
                                 number_invoice       varchar(20)  NOT NULL  ,
                                 date_time            timestamp  NOT NULL  ,
                                 tax                  numeric(4,2)  NOT NULL  ,
                                 total                numeric(11,2)  NOT NULL  ,
                                 enabled               boolean DEFAULT true NOT NULL  ,
                                 CONSTRAINT sales_pk PRIMARY KEY ( id_sale )
);

CREATE  TABLE sales_details (
                                         id_sale_detail       uuid  NOT NULL  ,
                                         id_product           bigint  NOT NULL  ,
                                         id_sale              bigint  NOT NULL  ,
                                         quantity             integer  NOT NULL  ,
                                         sale_price           numeric(11,2)  NOT NULL  ,
                                         discount             numeric(11,2)  NOT NULL  ,
                                         CONSTRAINT sales_details_pk PRIMARY KEY ( id_sale_detail )
);

CREATE  TABLE income_details (
                                          id_income_details    uuid  NOT NULL  ,
                                          id_income            bigint  NOT NULL  ,
                                          id_product           bigint  NOT NULL  ,
                                          quantity             integer  NOT NULL  ,
                                          price                numeric(11,2)  NOT NULL  ,
                                          CONSTRAINT income_details_pk PRIMARY KEY ( id_income_details )
);

ALTER TABLE income_details ADD CONSTRAINT income_pk FOREIGN KEY ( id_income ) REFERENCES incomes( id_income ) ON DELETE SET NULL ON UPDATE CASCADE ;

ALTER TABLE income_details ADD CONSTRAINT product_fk FOREIGN KEY ( id_product ) REFERENCES products( id_product ) ON DELETE SET NULL ON UPDATE CASCADE ;

ALTER TABLE incomes ADD CONSTRAINT supplier_pk FOREIGN KEY ( id_supplier ) REFERENCES suppliers( id_supplier ) ON DELETE SET NULL ON UPDATE CASCADE ;

ALTER TABLE incomes ADD CONSTRAINT user_pk FOREIGN KEY ( id_user ) REFERENCES users( id_user ) ON DELETE SET NULL ON UPDATE CASCADE ;

ALTER TABLE products ADD CONSTRAINT categories_fk FOREIGN KEY ( id_category ) REFERENCES categories( id_category ) ON DELETE SET NULL ON UPDATE CASCADE ;

ALTER TABLE sales ADD CONSTRAINT customer_fk FOREIGN KEY ( id_customer ) REFERENCES customers( id_customer ) ON DELETE SET NULL ON UPDATE CASCADE ;

ALTER TABLE sales ADD CONSTRAINT user_fk FOREIGN KEY ( id_user ) REFERENCES users( id_user ) ON DELETE SET NULL ON UPDATE CASCADE ;

ALTER TABLE sales_details ADD CONSTRAINT product_fk FOREIGN KEY ( id_product ) REFERENCES products( id_product ) ON DELETE SET NULL ON UPDATE CASCADE ;

ALTER TABLE sales_details ADD CONSTRAINT sale_fk FOREIGN KEY ( id_sale ) REFERENCES sales( id_sale ) ON DELETE SET NULL ON UPDATE CASCADE ;

ALTER TABLE users_roles ADD CONSTRAINT usuarios_fk FOREIGN KEY ( id_users ) REFERENCES users( id_user ) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE users_roles ADD CONSTRAINT roles_fk FOREIGN KEY ( id_roles ) REFERENCES roles( id_rol ) ON DELETE RESTRICT ON UPDATE CASCADE ;

