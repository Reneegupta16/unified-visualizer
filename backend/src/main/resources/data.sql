CREATE DATABASE visualizer_db;
CREATE USER 'visualizer_user'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON visualizer_db.* TO 'visualizer_user'@'localhost';
FLUSH PRIVILEGES;

