CREATE OR REPLACE PROCEDURE TransferFunds (
    p_FromAccountID IN NUMBER,
    p_ToAccountID   IN NUMBER,
    p_Amount        IN NUMBER
) AS
    v_FromBalance NUMBER;
BEGIN
    SELECT Balance INTO v_FromBalance
    FROM Accounts
    WHERE AccountID = p_FromAccountID
    FOR UPDATE;

    IF v_FromBalance < p_Amount THEN
        DBMS_OUTPUT.PUT_LINE('❌ Insufficient balance in source account: ' || p_FromAccountID);
        RETURN;
    END IF;

    -- Deduct from source account
    UPDATE Accounts
    SET Balance = Balance - p_Amount,
        LastModified = SYSDATE
    WHERE AccountID = p_FromAccountID;

    -- Add to destination account
    UPDATE Accounts
    SET Balance = Balance + p_Amount,
        LastModified = SYSDATE
    WHERE AccountID = p_ToAccountID;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('✅ Transfer of ' || p_Amount || ' completed from Account ' ||
                         p_FromAccountID || ' to Account ' || p_ToAccountID);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('❌ One or both accounts not found.');
        ROLLBACK;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('⚠️ Error: ' || SQLERRM);
        ROLLBACK;
END;
/
