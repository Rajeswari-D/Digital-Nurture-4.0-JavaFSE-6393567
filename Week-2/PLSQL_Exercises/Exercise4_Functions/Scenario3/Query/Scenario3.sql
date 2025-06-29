CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_AccountID IN NUMBER,
    p_Amount    IN NUMBER
) RETURN BOOLEAN IS
    v_Balance NUMBER;
BEGIN
    SELECT Balance INTO v_Balance
    FROM Accounts
    WHERE AccountID = p_AccountID;

    RETURN v_Balance >= p_Amount;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('❌ Account ID ' || p_AccountID || ' not found.');
        RETURN FALSE;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('⚠️ Error: ' || SQLERRM);
        RETURN FALSE;
END;
/
