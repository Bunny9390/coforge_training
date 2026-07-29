-- ============================================================
-- supplier_db Database Setup Script
-- ============================================================

-- Create database if not exists
CREATE DATABASE IF NOT EXISTS supplier_db;

USE supplier_db;

-- ============================================================
-- Create supplier table
-- ============================================================
CREATE TABLE IF NOT EXISTS supplier (
    supplierId    BIGINT       NOT NULL AUTO_INCREMENT,
    supplierName  VARCHAR(100) NOT NULL,
    city          VARCHAR(100) NOT NULL,
    PRIMARY KEY (supplierId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ============================================================
-- Sample Data
-- ============================================================
INSERT INTO supplier (supplierName, city) VALUES
    ('ABC Technologies', 'Chennai'),
    ('Global Traders',   'Bangalore'),
    ('Tech World',       'Hyderabad');

SELECT * FROM supplier;
