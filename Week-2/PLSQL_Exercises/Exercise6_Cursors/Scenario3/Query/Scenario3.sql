SET SERVEROUTPUT ON;

DECLARE
    CURSOR cur_loans IS
        SELECT LOAN_ID, INTEREST_RATE
        FROM Loans;

    v_new_rate NUMBER(5,2);
BEGIN
    FOR rec IN cur_loans LOOP
        -- Example Policy:
        -- If current interest rate > 8%, reduce it by 0.5%
        -- Else increase it by 0.25%
        IF rec.INTEREST_RATE > 8 THEN
            v_new_rate := rec.INTEREST_RATE - 0.5;
        ELSE
            v_new_rate := rec.INTEREST_RATE + 0.25;
        END IF;

        UPDATE Loans
        SET INTEREST_RATE = v_new_rate
        WHERE LOAN_ID = rec.LOAN_ID;

        DBMS_OUTPUT.PUT_LINE('LoanID ' || rec.LOAN_ID ||
                             ' updated to new interest rate: ' || v_new_rate || '%');
    END LOOP;

    COMMIT;
END;
/
