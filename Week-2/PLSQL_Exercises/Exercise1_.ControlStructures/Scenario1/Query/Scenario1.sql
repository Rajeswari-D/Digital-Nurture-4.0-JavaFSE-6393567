SET SERVEROUTPUT ON;

DECLARE
    CURSOR cust_loan_cursor IS
        SELECT c.CUSTOMER_ID, c.DOB, l.LOAN_ID, l.INTEREST_RATE
        FROM Customers c
        JOIN Loans l ON c.CUSTOMER_ID = l.CUSTOMER_ID;

    v_age NUMBER;
BEGIN
    FOR rec IN cust_loan_cursor LOOP
        -- Calculate age from DOB
        v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12);

        IF v_age > 60 THEN
            UPDATE Loans
            SET INTEREST_RATE = rec.INTEREST_RATE - 1
            WHERE LOAN_ID = rec.LOAN_ID;

            DBMS_OUTPUT.PUT_LINE('✅ Updated Interest Rate for CUSTOMER_ID: ' || rec.CUSTOMER_ID ||
                                 ' | Age: ' || v_age || ' | LOAN_ID: ' || rec.LOAN_ID);
        END IF;
    END LOOP;

    COMMIT;
END;
/
