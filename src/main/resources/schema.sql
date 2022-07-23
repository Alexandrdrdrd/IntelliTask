CREATE TABLE if not exists my_db.product (
                               id int NOT NULL AUTO_INCREMENT,
                               name varchar(15),
                               price double,
                               PRIMARY KEY (id)
);

CREATE TABLE if not exists my_db.user (
                            id int NOT NULL AUTO_INCREMENT,
                            first_name varchar(15),
                            last_name varchar(15),
                            wallet double,
                            PRIMARY KEY (id)
);

CREATE TABLE if not exists my_db.user_product (
                                    user_id int NOT NULL,
                                    product_id int NOT NULL,
                                    PRIMARY KEY (user_id, product_id),
                                    FOREIGN KEY (user_id) REFERENCES my_db.user(id),
                                    FOREIGN KEY (product_id) REFERENCES my_db.product(id));