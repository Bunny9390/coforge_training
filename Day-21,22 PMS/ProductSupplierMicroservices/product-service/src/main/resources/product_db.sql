-- ============================================================
-- product_db Database Setup Script
-- ============================================================

-- Create database if not exists
CREATE DATABASE IF NOT EXISTS product_db;

USE product_db;

-- ============================================================
-- Create product table
-- ============================================================
CREATE TABLE IF NOT EXISTS product (
    productId    BIGINT        NOT NULL AUTO_INCREMENT,
    productName  VARCHAR(200)  NOT NULL,
    price        DOUBLE        NOT NULL,
    quantity     INT           NOT NULL,
    supplierId   BIGINT        NOT NULL,
    PRIMARY KEY (productId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ============================================================
-- Sample Data
-- (supplierId 1 = ABC Technologies, 2 = Global Traders, 3 = Tech World)
-- ============================================================
INSERT INTO product (productName, price, quantity, supplierId) VALUES
    ('Laptop',   65000.00, 20,  1),
    ('Mouse',      700.00, 100, 1),
    ('Keyboard',  1200.00, 50,  2);

SELECT * FROM product;
