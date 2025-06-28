CREATE OR REPLACE PACKAGE CustomerManagement IS
    PROCEDURE AddCustomer(cust_id NUMBER, cust_name VARCHAR2, dob DATE, balance NUMBER);
    PROCEDURE UpdateCustomer(cust_id NUMBER, new_name VARCHAR2, new_balance NUMBER);
    FUNCTION GetBalance(cust_id NUMBER) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement IS

    PROCEDURE AddCustomer(cust_id NUMBER, cust_name VARCHAR2, dob DATE, balance NUMBER) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (cust_id, cust_name, dob, balance, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Customer added: ' || cust_name);
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error adding customer: ' || SQLERRM);
    END;

    PROCEDURE UpdateCustomer(cust_id NUMBER, new_name VARCHAR2, new_balance NUMBER) IS
    BEGIN
        UPDATE Customers
        SET Name = new_name, Balance = new_balance
        WHERE CustomerID = cust_id;
        DBMS_OUTPUT.PUT_LINE('Customer updated: ' || new_name);
    END;

    FUNCTION GetBalance(cust_id NUMBER) RETURN NUMBER IS
        v_bal NUMBER;
    BEGIN
        SELECT Balance INTO v_bal FROM Customers WHERE CustomerID = cust_id;
        RETURN v_bal;
    END;

END CustomerManagement;
/
CREATE OR REPLACE PACKAGE EmployeeManagement IS
    PROCEDURE Hire(emp_id NUMBER, emp_name VARCHAR2, position VARCHAR2, salary NUMBER, dept VARCHAR2, hire_date DATE);
    PROCEDURE Update(emp_id NUMBER, new_position VARCHAR2, new_salary NUMBER);
    FUNCTION GetAnnualSalary(emp_id NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement IS

    PROCEDURE Hire(emp_id NUMBER, emp_name VARCHAR2, position VARCHAR2, salary NUMBER, dept VARCHAR2, hire_date DATE) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (emp_id, emp_name, position, salary, dept, hire_date);
        DBMS_OUTPUT.PUT_LINE('Employee hired: ' || emp_name);
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error hiring employee: ' || SQLERRM);
    END;

    PROCEDURE Update(emp_id NUMBER, new_position VARCHAR2, new_salary NUMBER) IS
    BEGIN
        UPDATE Employees
        SET Position = new_position, Salary = new_salary
        WHERE EmployeeID = emp_id;
        DBMS_OUTPUT.PUT_LINE('Employee updated: ID ' || emp_id);
    END;

    FUNCTION GetAnnualSalary(emp_id NUMBER) RETURN NUMBER IS
        v_annual NUMBER;
    BEGIN
        SELECT Salary * 12 INTO v_annual FROM Employees WHERE EmployeeID = emp_id;
        RETURN v_annual;
    END;

END EmployeeManagement;
/
CREATE OR REPLACE PACKAGE AccountOperations IS
    PROCEDURE Open(acc_id NUMBER, cust_id NUMBER, acc_type VARCHAR2, amount NUMBER);
    PROCEDURE Close(acc_id NUMBER);
    FUNCTION TotalBalance(cust_id NUMBER) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations IS

    PROCEDURE Open(acc_id NUMBER, cust_id NUMBER, acc_type VARCHAR2, amount NUMBER) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (acc_id, cust_id, acc_type, amount, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Account opened for Customer ID: ' || cust_id);
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error opening account: ' || SQLERRM);
    END;

    PROCEDURE Close(acc_id NUMBER) IS
    BEGIN
        DELETE FROM Accounts WHERE AccountID = acc_id;
        DBMS_OUTPUT.PUT_LINE('Account closed: ' || acc_id);
    END;

    FUNCTION TotalBalance(cust_id NUMBER) RETURN NUMBER IS
        v_total NUMBER;
    BEGIN
        SELECT SUM(Balance) INTO v_total FROM Accounts WHERE CustomerID = cust_id;
        RETURN NVL(v_total, 0);
    END;

END AccountOperations;
/
-- Test Package 1: CustomerManagement
BEGIN
    CustomerManagement.AddCustomer(10, 'Ravi Kumar', TO_DATE('1994-03-05', 'YYYY-MM-DD'), 4000);
    CustomerManagement.UpdateCustomer(10, 'Ravi K.', 4500);
    DBMS_OUTPUT.PUT_LINE('Balance of Ravi: ' || CustomerManagement.GetBalance(10));
END;
/

-- Test Package 2: EmployeeManagement
BEGIN
    EmployeeManagement.Hire(20, 'Nikita Das', 'Tester', 35000, 'QA', TO_DATE('2020-08-15', 'YYYY-MM-DD'));
    EmployeeManagement.Update(20, 'Senior Tester', 42000);
    DBMS_OUTPUT.PUT_LINE('Annual Salary: ' || EmployeeManagement.GetAnnualSalary(20));
END;
/

-- Test Package 3: AccountOperations
BEGIN
    AccountOperations.Open(30, 10, 'Savings', 8000);
    DBMS_OUTPUT.PUT_LINE('Total balance for Customer ID 10: ' || AccountOperations.TotalBalance(10));
    AccountOperations.Close(30);
END;
/
