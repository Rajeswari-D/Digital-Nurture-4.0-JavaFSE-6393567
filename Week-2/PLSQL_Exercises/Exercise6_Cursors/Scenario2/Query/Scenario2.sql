SET SERVEROUTPUT ON;

DECLARE
    CURSOR cur_accounts IS
        SELECT AccountID, Balance
        FROM Accounts;

    v_fee CONSTANT NUMBER := 200;
BEGIN
    FOR rec IN cur_accounts LOOP
        -- Only deduct fee if balance is sufficient
        IF rec.Balance >= v_fee THEN
            UPDATE Accounts
            SET Balance = Balance - v_fee,
                LastModified = SYSDATE
            WHERE AccountID = rec.AccountID;

            DBMS_OUTPUT.PUT_LINE('Annual fee of ₹' || v_fee || ' deducted from AccountID: ' || rec.AccountID);
        ELSE
            DBMS_OUTPUT.PUT_LINE('Skipping AccountID ' || rec.AccountID || ' due to insufficient balance.');
        END IF;
    END LOOP;

    COMMIT;
END;
/
