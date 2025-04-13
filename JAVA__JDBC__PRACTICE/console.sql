-- Tạo cơ sở dữ liệu
CREATE DATABASE IF NOT EXISTS company_management;
USE company_management;

-- Bảng tài khoản (admin và HR)
CREATE TABLE accounts
(
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    status   ENUM ('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE'
);

-- Bảng phòng ban
CREATE TABLE departments
(
    department_id   INT PRIMARY KEY AUTO_INCREMENT,
    department_name VARCHAR(100) NOT NULL UNIQUE CHECK (LENGTH(department_name) BETWEEN 10 AND 100),
    description     VARCHAR(255),
    status          ENUM ('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE'
);

-- Bảng nhân viên
CREATE TABLE employees
(
    employee_id   VARCHAR(5) PRIMARY KEY CHECK (employee_id REGEXP '^E[0-9]{4}$'),
    full_name     VARCHAR(150)                     NOT NULL CHECK (LENGTH(full_name) BETWEEN 15 AND 150),
    email         VARCHAR(100)                     NOT NULL UNIQUE CHECK (email REGEXP '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$'),
    phone_number  VARCHAR(10)                      NOT NULL CHECK (phone_number REGEXP '^0[0-9]{9}$'),
    gender        ENUM ('MALE', 'FEMALE', 'OTHER') NOT NULL,
    pay_grade     INT                              NOT NULL CHECK (pay_grade > 0),
    salary        DOUBLE                           NOT NULL CHECK (salary > 0),
    birth_date    DATE                             NOT NULL,
    address       VARCHAR(255)                     NOT NULL,
    status        ENUM ('ACTIVE', 'INACTIVE', 'ONLEAVE', 'POLICYLEAVE') DEFAULT 'ACTIVE',
    department_id INT                              NOT NULL,
    FOREIGN KEY (department_id) REFERENCES departments (department_id)
);

-- Thêm dữ liệu mẫu cho bảng tài khoản
INSERT INTO accounts (username, password, status)
VALUES ('admin1', 'admin123', 'ACTIVE'),
       ('hr1', 'hr123', 'ACTIVE'),
       ('hr2', 'hr456', 'INACTIVE');

-- Thêm dữ liệu mẫu cho bảng phòng ban
INSERT INTO departments (department_name, description, status)
VALUES ('Phòng Kế Toán', 'Quản lý tài chính và kế toán', 'ACTIVE'),
       ('Phòng Nhân Sự', 'Quản lý nhân sự và tuyển dụng', 'ACTIVE'),
       ('Phòng Công Nghệ Thông Tin', 'Phát triển và bảo trì hệ thống CNTT', 'ACTIVE'),
       ('Phòng Marketing', 'Xây dựng chiến lược tiếp thị', 'INACTIVE');

-- Thêm dữ liệu mẫu cho bảng nhân viên
INSERT INTO employees (employee_id, full_name, email, phone_number, gender, pay_grade, salary, birth_date, address,
                       status, department_id)
VALUES ('E0001', 'Nguyễn Văn Hoàng Anh', 'hoanganh@gmail.com', '0912345678', 'MALE', 5, 15000000, '1990-05-15',
        '123 Đường Láng, Hà Nội', 'ACTIVE', 1),
       ('E0002', 'Trần Thị Minh Ngọc', 'minhngoc@gmail.com', '0987654321', 'FEMALE', 4, 12000000, '1995-08-22',
        '456 Lê Lợi, TP.HCM', 'ONLEAVE', 2),
       ('E0003', 'Phạm Quốc Hưng', 'quochung@gmail.com', '0901234567', 'MALE', 6, 20000000, '1988-03-10',
        '789 Nguyễn Huệ, Đà Nẵng', 'ACTIVE', 3),
       ('E0004', 'Lê Thị Thanh Huyền', 'thanhhuyen@gmail.com', '0932145678', 'FEMALE', 3, 10000000, '1997-11-30',
        '101 Trần Phú, Nha Trang', 'POLICYLEAVE', 1),
       ('E0005', 'Đỗ Minh Tuấn', 'minhtuan@gmail.com', '0923456789', 'OTHER', 5, 17000000, '1992-07-25',
        '202 Phạm Văn Đồng, Hà Nội', 'ACTIVE', 2);



USE company_management;

-- 1. Đăng nhập tài khoản
DELIMITER //
CREATE PROCEDURE Login(
    IN p_username VARCHAR(50),
    IN p_password VARCHAR(255),
    OUT p_result INT
)
BEGIN
    DECLARE v_count INT;
    SELECT COUNT(*) INTO v_count
    FROM accounts
    WHERE username = p_username AND password = p_password AND status='ACTIVE';
    IF v_count = 1 THEN
        SET p_result = 1; -- Đăng nhập thành công
    ELSE
        SET p_result = 2; -- Sai thông tin đăng nhập
    END IF;
END //
DELIMITER ;

-- 2. Quản lý phòng ban
-- a. Lấy danh sách phòng ban có phân trang
DELIMITER //
CREATE PROCEDURE GetDepartments(
    IN p_page INT,
    IN p_size INT,
    OUT p_result INT
)
BEGIN
    DECLARE v_offset INT;

    IF p_page < 1 OR p_size < 1 THEN
        SET p_result = 2;
    ELSE
        SET v_offset = (p_page - 1) * p_size;
        SELECT department_id, department_name, description, status
        FROM departments
        ORDER BY department_id
        LIMIT p_size OFFSET v_offset;
        SET p_result = 1;
    END IF;
END //
DELIMITER ;

-- b. Thêm phòng ban
DELIMITER //
CREATE PROCEDURE AddDepartment(
    IN p_department_name VARCHAR(100),
    IN p_description VARCHAR(255),
    IN p_status ENUM('ACTIVE', 'INACTIVE'),
    OUT p_result INT
)
BEGIN
    DECLARE v_count INT;

    SELECT COUNT(*) INTO v_count
    FROM departments
    WHERE department_name = p_department_name;

    IF v_count > 0 THEN
        SET p_result = 2;
    ELSEIF LENGTH(p_department_name) NOT BETWEEN 10 AND 100 THEN
        SET p_result = 3;
    ELSE
        INSERT INTO departments (department_name, description, status)
        VALUES (p_department_name, p_description, p_status);
        SET p_result = 1;
    END IF;
END //
DELIMITER ;

-- c. Cập nhật phòng ban
DELIMITER //
CREATE PROCEDURE UpdateDepartment(
    IN p_department_id INT,
    IN p_department_name VARCHAR(100),
    IN p_description VARCHAR(255),
    IN p_status ENUM('ACTIVE', 'INACTIVE'),
    OUT p_result INT
)
BEGIN
    DECLARE v_count INT;

    SELECT COUNT(*) INTO v_count
    FROM departments
    WHERE department_name = p_department_name AND department_id != p_department_id;

    IF v_count > 0 THEN
        SET p_result = 2;
    ELSEIF LENGTH(p_department_name) NOT BETWEEN 10 AND 100 THEN
        SET p_result = 3;
    ELSE
        UPDATE departments
        SET department_name = p_department_name,
            description = p_description,
            status = p_status
        WHERE department_id = p_department_id;
        SET p_result = 1;
    END IF;
END //
DELIMITER ;

-- d. Xóa phòng ban (chỉ xóa nếu không có nhân viên)
DELIMITER //
CREATE PROCEDURE DeleteDepartment(
    IN p_department_id INT,
    OUT p_result INT
)
BEGIN
    DECLARE v_employee_count INT;

    SELECT COUNT(*) INTO v_employee_count
    FROM employees
    WHERE department_id = p_department_id;

    IF v_employee_count > 0 THEN
        SET p_result = 2;
    ELSE
        DELETE FROM departments
        WHERE department_id = p_department_id;
        IF ROW_COUNT() = 0 THEN
            SET p_result = 3;
        ELSE
            SET p_result = 1;
        END IF;
    END IF;
END //
DELIMITER ;

-- e. Tìm kiếm phòng ban theo tên
DELIMITER //
CREATE PROCEDURE SearchDepartmentByName(
    IN p_department_name VARCHAR(100),
    OUT p_result INT
)
BEGIN
    IF p_department_name IS NULL OR LENGTH(p_department_name) = 0 THEN
        SET p_result = 2;
    ELSE
        SELECT department_id, department_name, description, status
        FROM departments
        WHERE department_name LIKE CONCAT('%', p_department_name, '%');
        SET p_result = 1;
    END IF;
END //
DELIMITER ;

-- 3. Quản lý nhân viên
-- a. Lấy danh sách nhân viên có phân trang
DELIMITER //
CREATE PROCEDURE GetEmployees(
    IN p_page INT,
    IN p_size INT,
    OUT p_result INT
)
BEGIN
    DECLARE v_offset INT;

    IF p_page < 1 OR p_size < 1 THEN
        SET p_result = 2;
    ELSE
        SET v_offset = (p_page - 1) * p_size;
        SELECT employee_id, full_name, email, phone_number, gender, pay_grade,
               salary, birth_date, address, status, department_id
        FROM employees
        ORDER BY employee_id
        LIMIT p_size OFFSET v_offset;
        SET p_result = 1;
    END IF;
END //
DELIMITER ;

-- b. Thêm nhân viên
DELIMITER //
CREATE PROCEDURE AddEmployee(
    IN p_employee_id VARCHAR(5),
    IN p_full_name VARCHAR(150),
    IN p_email VARCHAR(100),
    IN p_phone_number VARCHAR(10),
    IN p_gender ENUM('MALE', 'FEMALE', 'OTHER'),
    IN p_pay_grade INT,
    IN p_salary DOUBLE,
    IN p_birth_date DATE,
    IN p_address VARCHAR(255),
    IN p_status ENUM('ACTIVE', 'INACTIVE', 'ONLEAVE', 'POLICYLEAVE'),
    IN p_department_id INT,
    OUT p_result INT
)
BEGIN
    DECLARE v_department_status ENUM('ACTIVE', 'INACTIVE');
    DECLARE v_count INT;

    -- Kiểm tra phòng ban
    SELECT status INTO v_department_status
    FROM departments
    WHERE department_id = p_department_id;

    -- Kiểm tra trùng mã nhân viên hoặc email
    SELECT COUNT(*) INTO v_count
    FROM employees
    WHERE employee_id = p_employee_id OR email = p_email;

    IF v_department_status IS NULL THEN
        SET p_result = 2;
    ELSEIF v_department_status != 'ACTIVE' THEN
        SET p_result = 3;
    ELSEIF v_count > 0 THEN
        SET p_result = 4;
    ELSEIF p_employee_id NOT REGEXP '^E[0-9]{4}$' THEN
        SET p_result = 5;
    ELSEIF LENGTH(p_full_name) NOT BETWEEN 15 AND 150 THEN
        SET p_result = 6;
    ELSEIF p_email NOT REGEXP '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$' THEN
        SET p_result = 7;
    ELSEIF p_phone_number NOT REGEXP '^0[0-9]{9}$' THEN
        SET p_result = 8;
    ELSEIF p_pay_grade <= 0 THEN
        SET p_result = 9;
    ELSEIF p_salary <= 0 THEN
        SET p_result = 10;
    ELSE
        INSERT INTO employees (employee_id, full_name, email, phone_number, gender,
                               pay_grade, salary, birth_date, address, status, department_id)
        VALUES (p_employee_id, p_full_name, p_email, p_phone_number, p_gender,
                p_pay_grade, p_salary, p_birth_date, p_address, p_status, p_department_id);
        SET p_result = 1;
    END IF;
END //
DELIMITER ;

-- c. Cập nhật nhân viên
DELIMITER //
CREATE PROCEDURE UpdateEmployee(
    IN p_employee_id VARCHAR(5),
    IN p_full_name VARCHAR(150),
    IN p_email VARCHAR(100),
    IN p_phone_number VARCHAR(10),
    IN p_gender ENUM('MALE', 'FEMALE', 'OTHER'),
    IN p_pay_grade INT,
    IN p_salary DOUBLE,
    IN p_birth_date DATE,
    IN p_address VARCHAR(255),
    IN p_status ENUM('ACTIVE', 'INACTIVE', 'ONLEAVE', 'POLICYLEAVE'),
    IN p_department_id INT,
    OUT p_result INT
)
BEGIN
    DECLARE v_department_status ENUM('ACTIVE', 'INACTIVE');
    DECLARE v_count INT;

    -- Kiểm tra phòng ban
    SELECT status INTO v_department_status
    FROM departments
    WHERE department_id = p_department_id;

    -- Kiểm tra trùng email
    SELECT COUNT(*) INTO v_count
    FROM employees
    WHERE email = p_email AND employee_id != p_employee_id;

    IF v_department_status IS NULL THEN
        SET p_result = 2;
    ELSEIF v_department_status != 'ACTIVE' THEN
        SET p_result = 3;
    ELSEIF v_count > 0 THEN
        SET p_result = 4;
    ELSEIF LENGTH(p_full_name) NOT BETWEEN 15 AND 150 THEN
        SET p_result = 5;
    ELSEIF p_email NOT REGEXP '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$' THEN
        SET p_result = 6;
    ELSEIF p_phone_number NOT REGEXP '^0[0-9]{9}$' THEN
        SET p_result = 7;
    ELSEIF p_pay_grade <= 0 THEN
        SET p_result = 8;
    ELSEIF p_salary <= 0 THEN
        SET p_result = 9;
    ELSE
        UPDATE employees
        SET full_name = p_full_name,
            email = p_email,
            phone_number = p_phone_number,
            gender = p_gender,
            pay_grade = p_pay_grade,
            salary = p_salary,
            birth_date = p_birth_date,
            address = p_address,
            status = p_status,
            department_id = p_department_id
        WHERE employee_id = p_employee_id;
        IF ROW_COUNT() = 0 THEN
            SET p_result = 10;
        ELSE
            SET p_result = 1;
        END IF;
    END IF;
END //
DELIMITER ;

-- d. Xóa nhân viên (chuyển trạng thái thành INACTIVE)
DELIMITER //
CREATE PROCEDURE DeleteEmployee(
    IN p_employee_id VARCHAR(5),
    OUT p_result INT
)
BEGIN
    DECLARE v_count INT;

    SELECT COUNT(*) INTO v_count
    FROM employees
    WHERE employee_id = p_employee_id;

    IF v_count = 0 THEN
        SET p_result = 2;
    ELSE
        UPDATE employees
        SET status = 'INACTIVE'
        WHERE employee_id = p_employee_id;
        SET p_result = 1;
    END IF;
END //
DELIMITER ;

-- e. Tìm kiếm nhân viên theo tên
DELIMITER //
CREATE PROCEDURE SearchEmployeeByName(
    IN p_full_name VARCHAR(150),
    OUT p_result INT
)
BEGIN
    IF p_full_name IS NULL OR LENGTH(p_full_name) = 0 THEN
        SET p_result = 2;
    ELSE
        SELECT employee_id, full_name, email, phone_number, gender, pay_grade,
               salary, birth_date, address, status, department_id
        FROM employees
        WHERE full_name LIKE CONCAT('%', p_full_name, '%');
        SET p_result = 1;
    END IF;
END //
DELIMITER ;

-- f. Tìm kiếm nhân viên theo khoảng tuổi
DELIMITER //
CREATE PROCEDURE SearchEmployeeByAgeRange(
    IN p_min_age INT,
    IN p_max_age INT,
    OUT p_result INT
)
BEGIN
    IF p_min_age < 0 OR p_max_age < p_min_age THEN
        SET p_result = 2;
    ELSE
        SELECT employee_id, full_name, email, phone_number, gender, pay_grade,
               salary, birth_date, address, status, department_id
        FROM employees
        WHERE TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) BETWEEN p_min_age AND p_max_age;
        SET p_result = 1;
    END IF;
END //
DELIMITER ;

-- g. Sắp xếp nhân viên theo lương giảm dần
DELIMITER //
CREATE PROCEDURE SortEmployeeBySalaryDesc(
    IN p_page INT,
    IN p_size INT,
    OUT p_result INT
)
BEGIN
    DECLARE v_offset INT;

    IF p_page < 1 OR p_size < 1 THEN
        SET p_result = 2;
    ELSE
        SET v_offset = (p_page - 1) * p_size;
        SELECT employee_id, full_name, email, phone_number, gender, pay_grade,
               salary, birth_date, address, status, department_id
        FROM employees
        ORDER BY salary DESC
        LIMIT p_size OFFSET v_offset;
        SET p_result = 1;
    END IF;
END //
DELIMITER ;

-- h. Sắp xếp nhân viên theo tên tăng dần
DELIMITER //
CREATE PROCEDURE SortEmployeeByNameAsc(
    IN p_page INT,
    IN p_size INT,
    OUT p_result INT
)
BEGIN
    DECLARE v_offset INT;

    IF p_page < 1 OR p_size < 1 THEN
        SET p_result = 2;
    ELSE
        SET v_offset = (p_page - 1) * p_size;
        SELECT employee_id, full_name, email, phone_number, gender, pay_grade,
               salary, birth_date, address, status, department_id
        FROM employees
        ORDER BY full_name ASC
        LIMIT p_size OFFSET v_offset;
        SET p_result = 1;
    END IF;
END //
DELIMITER ;

-- 4. Thống kê
-- a. Số lượng nhân viên theo từng phòng ban
DELIMITER //
CREATE PROCEDURE GetEmployeeCountByDepartment(
    OUT p_result INT
)
BEGIN
    SELECT d.department_id, d.department_name, COUNT(e.employee_id) AS employee_count
    FROM departments d
             LEFT JOIN employees e ON d.department_id = e.department_id
    GROUP BY d.department_id, d.department_name;
    SET p_result = 1;
END //
DELIMITER ;

-- b. Tổng số nhân viên của toàn bộ hệ thống
DELIMITER //
CREATE PROCEDURE GetTotalEmployeeCount(
    OUT p_total INT,
    OUT p_result INT
)
BEGIN
    SELECT COUNT(*) INTO p_total
    FROM employees;
    SET p_result = 1;
END //
DELIMITER ;

-- c. Phòng ban có nhiều nhân viên nhất
DELIMITER //
CREATE PROCEDURE GetDepartmentWithMostEmployees(
    OUT p_result INT
)
BEGIN
    SELECT d.department_id, d.department_name, COUNT(e.employee_id) AS employee_count
    FROM departments d
             LEFT JOIN employees e ON d.department_id = e.department_id
    GROUP BY d.department_id, d.department_name
    ORDER BY employee_count DESC
    LIMIT 1;
    SET p_result = 1;
END //
DELIMITER ;

-- d. Phòng ban có tổng lương cao nhất
DELIMITER //
CREATE PROCEDURE GetDepartmentWithHighestSalary(
    OUT p_result INT
)
BEGIN
    SELECT d.department_id, d.department_name, SUM(e.salary) AS total_salary
    FROM departments d
             LEFT JOIN employees e ON d.department_id = e.department_id
    GROUP BY d.department_id, d.department_name
    ORDER BY total_salary DESC
    LIMIT 1;
    SET p_result = 1;
END //
DELIMITER ;
