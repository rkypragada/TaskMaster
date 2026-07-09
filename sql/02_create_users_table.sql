-- ===========================================
-- Create Users Table
-- ===========================================

USE taskmaster;

CREATE TABLE users(

    user_id INT PRIMARY KEY AUTO_INCREMENT,

    full_name VARCHAR(100),

    email VARCHAR(100),

    password VARCHAR(100)

);