SET SERVEROUTPUT ON;

DECLARE
    v_count NUMBER := 0;

    CURSOR due_loans_cursor IS
        SELECT l.LOAN_ID, l.CUSTOMER_ID, l.DUE_DATE, c.NAME
        FROM Loans l
        JOIN Customers c ON l.CUSTOMER_ID = c.CUSTOMER_ID
        WHERE l.DUE_DATE BETWEEN SYSDATE AND SYSDATE + 30;

BEGIN
    FOR rec IN due_loans_cursor LOOP
        DBMS_OUTPUT.PUT_LINE(
            '📢 Reminder: Loan ID ' || rec.LOAN_ID ||
            ' for Customer ' || rec.NAME || 
            ' (ID: ' || rec.CUSTOMER_ID || ') is due on ' || TO_CHAR(rec.DUE_DATE, 'DD-MON-YYYY')
        );
        v_count := v_count + 1;
    END LOOP;

    IF v_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('✅ No loans due in the next 30 days.');
    END IF;
END;
/
