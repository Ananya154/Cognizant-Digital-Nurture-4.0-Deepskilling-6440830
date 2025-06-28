--SCENARIO 1: Apply 1% discount to customers over 60 years old
BEGIN
   DECLARE
      v_count NUMBER := 0;
   BEGIN
      FOR cust IN (
         SELECT c.CustomerID, c.Name, l.LoanID, l.InterestRate
         FROM Customers c
         JOIN Loans l ON c.CustomerID = l.CustomerID
         WHERE MONTHS_BETWEEN(SYSDATE, c.DOB) / 12 > 60
      ) LOOP
         UPDATE Loans
         SET InterestRate = InterestRate - 1
         WHERE LoanID = cust.LoanID;

         DBMS_OUTPUT.PUT_LINE('1% discount applied for ' || cust.Name || ' (Customer ID: ' || cust.CustomerID || ')');
         v_count := v_count + 1;
      END LOOP;

      IF v_count = 0 THEN
         DBMS_OUTPUT.PUT_LINE(' No customers over 60 years with loans found.');
      END IF;
   END;
END;
/

-- SCENARIO 2: Promote high balance customers to VIP
BEGIN
   DECLARE
      v_count NUMBER := 0;
   BEGIN
      FOR cust IN (
         SELECT CustomerID, Name
         FROM Customers
         WHERE Balance > 10000
      ) LOOP
         UPDATE Customers
         SET IsVIP = 'TRUE'
         WHERE CustomerID = cust.CustomerID;

         DBMS_OUTPUT.PUT_LINE(' VIP promoted: ' || cust.Name || ' (Customer ID: ' || cust.CustomerID || ')');
         v_count := v_count + 1;
      END LOOP;

      IF v_count = 0 THEN
         DBMS_OUTPUT.PUT_LINE(' No customers with balance > 10000 found.');
      END IF;
   END;
END;
/

-- SCENARIO 3: Loan due reminders within next 30 days
BEGIN
   DECLARE
      v_count NUMBER := 0;
   BEGIN
      FOR loan IN (
         SELECT l.LoanID, c.Name, l.EndDate
         FROM Loans l
         JOIN Customers c ON l.CustomerID = c.CustomerID
         WHERE l.EndDate <= SYSDATE + 30
      ) LOOP
         DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || loan.LoanID || ' for ' || loan.Name || ' is due on ' || TO_CHAR(loan.EndDate, 'DD-Mon-YYYY'));
         v_count := v_count + 1;
      END LOOP;

      IF v_count = 0 THEN
         DBMS_OUTPUT.PUT_LINE(' No loans due within the next 30 days.');
      END IF;
   END;
END;
/
