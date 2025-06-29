SET SERVEROUTPUT ON;

DECLARE
    CURSOR cur_monthly_transactions IS
        SELECT
            c.Name AS CustomerName,
            t.TransactionDate,
            t.AccountID,
            t.Amount,
            t.TransactionType
        FROM
            Transactions t
            JOIN Accounts a ON t.AccountID = a.AccountID
            JOIN Customers c ON a.CustomerID = c.Customer_ID
        WHERE
            EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
            AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE)
        ORDER BY
            c.Name, t.TransactionDate;

BEGIN
    FOR rec IN cur_monthly_transactions LOOP
        DBMS_OUTPUT.PUT_LINE('------------------------------------------');
        DBMS_OUTPUT.PUT_LINE('Customer: ' || rec.CustomerName);
        DBMS_OUTPUT.PUT_LINE('Date     : ' || TO_CHAR(rec.TransactionDate, 'DD-MON-YYYY'));
        DBMS_OUTPUT.PUT_LINE('Account  : ' || rec.AccountID);
        DBMS_OUTPUT.PUT_LINE('Amount   : ₹' || rec.Amount);
        DBMS_OUTPUT.PUT_LINE('Type     : ' || rec.TransactionType);
    END LOOP;
END;
/
