-- Scenario 1: Add 1% interest to all savings accounts
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
   FOR acc IN (
      SELECT AccountID, Balance
      FROM Accounts
      WHERE AccountType = 'Savings'
   ) LOOP
      UPDATE Accounts
      SET Balance = Balance + (acc.Balance * 0.01),
          LastModified = SYSDATE
      WHERE AccountID = acc.AccountID;

      DBMS_OUTPUT.PUT_LINE('Interest added to Account ID: ' || acc.AccountID);
   END LOOP;

   COMMIT;
EXCEPTION
   WHEN OTHERS THEN
      ROLLBACK;
      DBMS_OUTPUT.PUT_LINE('Error during interest processing: ' || SQLERRM);
END;
/

-- Scenario 2: Give 10% bonus to IT department
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
   p_department IN VARCHAR2,
   p_bonus_pct  IN NUMBER  
) AS
BEGIN
   UPDATE Employees
   SET Salary = Salary + (Salary * p_bonus_pct / 100)
   WHERE Department = p_department;

   IF SQL%ROWCOUNT > 0 THEN
      DBMS_OUTPUT.PUT_LINE('Bonus applied to department: ' || p_department);
   ELSE
      DBMS_OUTPUT.PUT_LINE('No employees found in department: ' || p_department);
   END IF;

   COMMIT;
EXCEPTION
   WHEN OTHERS THEN
      ROLLBACK;
      DBMS_OUTPUT.PUT_LINE('Failed to update bonus: ' || SQLERRM);
END;
/

-- Scenario 3: Transfer ₹200 from Account 1 to Account 2
CREATE OR REPLACE PROCEDURE TransferFunds(
   p_from_account IN NUMBER,
   p_to_account   IN NUMBER,
   p_amount       IN NUMBER
) AS
   v_balance NUMBER;
BEGIN
   SELECT Balance INTO v_balance
   FROM Accounts
   WHERE AccountID = p_from_account
   FOR UPDATE;
   IF v_balance < p_amount THEN
      RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
   END IF;
   UPDATE Accounts
   SET Balance = Balance - p_amount,
       LastModified = SYSDATE
   WHERE AccountID = p_from_account;
   UPDATE Accounts
   SET Balance = Balance + p_amount,
       LastModified = SYSDATE
   WHERE AccountID = p_to_account;

   DBMS_OUTPUT.PUT_LINE('₹' || p_amount || ' transferred from Account ' || p_from_account || ' to Account ' || p_to_account);

   COMMIT;
EXCEPTION
   WHEN OTHERS THEN
      ROLLBACK;
      DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END;
/
-- Test 1
EXEC ProcessMonthlyInterest;

-- Test 2
EXEC UpdateEmployeeBonus('IT', 10);

-- Test 3
EXEC TransferFunds(1, 2, 200);
