DECLARE
    CURSOR trans_cursor IS
        SELECT c.Name, t.AccountID, t.TransactionDate, t.Amount, t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE TO_CHAR(t.TransactionDate, 'MM-YYYY') = TO_CHAR(SYSDATE, 'MM-YYYY');

    v_name Customers.Name%TYPE;
    v_accid Accounts.AccountID%TYPE;
    v_date Transactions.TransactionDate%TYPE;
    v_amt Transactions.Amount%TYPE;
    v_type Transactions.TransactionType%TYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Monthly Statement for Current Month:');
    FOR rec IN trans_cursor LOOP
        DBMS_OUTPUT.PUT_LINE('Customer: ' || rec.Name || ', AccountID: ' || rec.AccountID ||
                             ', Date: ' || TO_CHAR(rec.TransactionDate, 'DD-Mon-YYYY') ||
                             ', Amount: ' || rec.Amount || ', Type: ' || rec.TransactionType);
    END LOOP;
END;
/
DECLARE
    CURSOR acc_cursor IS
        SELECT AccountID, Balance FROM Accounts;

    v_accid Accounts.AccountID%TYPE;
    v_balance Accounts.Balance%TYPE;
    v_fee NUMBER := 100;
BEGIN
    FOR rec IN acc_cursor LOOP
        UPDATE Accounts
        SET Balance = Balance - v_fee
        WHERE AccountID = rec.AccountID;

        DBMS_OUTPUT.PUT_LINE('₹' || v_fee || ' fee deducted from Account ID: ' || rec.AccountID ||
                             '. New Balance will be updated.');
    END LOOP;
END;
/
DECLARE
    CURSOR loan_cursor IS
        SELECT LoanID, LoanAmount, InterestRate FROM Loans;

    v_loanid Loans.LoanID%TYPE;
    v_amount Loans.LoanAmount%TYPE;
    v_rate Loans.InterestRate%TYPE;
BEGIN
    FOR rec IN loan_cursor LOOP
        IF rec.LoanAmount > 5000 THEN
            UPDATE Loans
            SET InterestRate = rec.InterestRate + 1
            WHERE LoanID = rec.LoanID;

            DBMS_OUTPUT.PUT_LINE('Interest increased by 1% for Loan ID: ' || rec.LoanID);
        ELSE
            UPDATE Loans
            SET InterestRate = rec.InterestRate + 0.5
            WHERE LoanID = rec.LoanID;

            DBMS_OUTPUT.PUT_LINE('Interest increased by 0.5% for Loan ID: ' || rec.LoanID);
        END IF;
    END LOOP;
END;
/
