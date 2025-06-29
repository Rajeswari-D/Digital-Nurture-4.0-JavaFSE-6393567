CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_FromAccountID IN NUMBER,
    p_ToAccountID   IN NUMBER,
    p_Amount        IN NUMBER
) AS
    v_FromBalance NUMBER;
BEGIN
    -- Get balance of source account
    SELECT Balance INTO v_FromBalance FROM Accounts WHERE AccountID = p_FromAccountID;

    -- Check for sufficient funds
    IF v_FromBalance < p_Amount THEN
        RAISE_APPLICATION_ERROR(-20001, '❌ Insufficient funds in source account.');
    END IF;

    -- Debit from source account
    UPDATE Accounts
    SET Balance = Balance - p_Amount
    WHERE AccountID = p_FromAccountID;

    -- Credit to destination account
    UPDATE Accounts
    SET Balance = Balance + p_Amount
    WHERE AccountID = p_ToAccountID;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('✅ Transfer of $' || p_Amount || ' from Account ' || p_FromAccountID || ' to ' || p_ToAccountID || ' successful.');
    
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('⚠️ Error occurred during transfer: ' || SQLERRM);
END;
/
