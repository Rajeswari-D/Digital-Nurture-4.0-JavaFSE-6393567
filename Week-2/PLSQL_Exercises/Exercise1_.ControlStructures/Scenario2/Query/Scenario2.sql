SET SERVEROUTPUT ON;

DECLARE
    CURSOR vip_cursor IS
        SELECT CUSTOMER_ID, BALANCE FROM Customers;

BEGIN
    FOR rec IN vip_cursor LOOP
        IF rec.BALANCE > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CUSTOMER_ID = rec.CUSTOMER_ID;

            DBMS_OUTPUT.PUT_LINE('✅ Promoted to VIP: CUSTOMER_ID = ' || rec.CUSTOMER_ID);
        ELSE
            UPDATE Customers
            SET IsVIP = 'FALSE'
            WHERE CUSTOMER_ID = rec.CUSTOMER_ID;

            DBMS_OUTPUT.PUT_LINE('ℹ️ Not VIP: CUSTOMER_ID = ' || rec.CUSTOMER_ID);
        END IF;
    END LOOP;

    COMMIT;
END;
/
