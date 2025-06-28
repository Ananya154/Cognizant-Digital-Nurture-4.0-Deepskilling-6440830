SET SERVEROUTPUT ON;

-- FUNCTION 1: CalculateAge - returns age in years based on DOB

CREATE OR REPLACE FUNCTION CalculateAge(p_dob DATE)
RETURN NUMBER
IS
   v_age NUMBER;
BEGIN
   v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
   RETURN v_age;
EXCEPTION
   WHEN OTHERS THEN
      RETURN NULL;
END;
/

-- Test Case 1: Get age of customer born on 15-May-1985
BEGIN
   DBMS_OUTPUT.PUT_LINE('Age: ' || CalculateAge(TO_DATE('1985-05-15', 'YYYY-MM-DD')));
END;
/

-- FUNCTION 2: CalculateMonthlyInstallment - calculates EMI for loans

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
   p_loan_amount   NUMBER,
   p_annual_rate   NUMBER,
   p_years         NUMBER
)
RETURN NUMBER
IS
   v_monthly_rate NUMBER;
   v_months       NUMBER;
   v_emi          NUMBER;
BEGIN
   v_monthly_rate := p_annual_rate / 12 / 100;
   v_months := p_years * 12;

   v_emi := p_loan_amount * v_monthly_rate * POWER(1 + v_monthly_rate, v_months) /
            (POWER(1 + v_monthly_rate, v_months) - 1);

   RETURN ROUND(v_emi, 2);
EXCEPTION
   WHEN OTHERS THEN
      RETURN NULL;
END;
/

-- Test Case 2: EMI for ₹5000 loan, 5% interest, 5 years
BEGIN
   DBMS_OUTPUT.PUT_LINE('Monthly EMI: ₹' || CalculateMonthlyInstallment(5000, 5, 5));
END;
/

-- FUNCTION 3: HasSufficientBalance - checks if balance ≥ required amount

CREATE OR REPLACE FUNCTION HasSufficientBalance(
   p_account_id NUMBER,
   p_amount     NUMBER
)
RETURN BOOLEAN
IS
   v_balance NUMBER;
BEGIN
   SELECT Balance INTO v_balance
   FROM Accounts
   WHERE AccountID = p_account_id;

   RETURN v_balance >= p_amount;
EXCEPTION
   WHEN NO_DATA_FOUND THEN
      RETURN FALSE;
   WHEN OTHERS THEN
      RETURN FALSE;
END;
/

-- Test Case 3: Check if Account ID 1 has at least ₹200
DECLARE
   result BOOLEAN;
BEGIN
   result := HasSufficientBalance(1, 200);
   IF result THEN
      DBMS_OUTPUT.PUT_LINE('Account 1 has sufficient balance.');
   ELSE
      DBMS_OUTPUT.PUT_LINE('Account 1 does NOT have sufficient balance.');
   END IF;
END;
/
