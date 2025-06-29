CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_CustomerID   IN NUMBER,
    p_Name         IN VARCHAR2,
    p_DOB          IN DATE,
    p_Balance      IN NUMBER
) AS
BEGIN
    INSERT INTO Customers (Customer_ID, Name, DOB, Balance, LastModified)
    VALUES (p_CustomerID, p_Name, p_DOB, p_Balance, SYSDATE);

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('✅ New customer inserted: ID ' || p_CustomerID || ', Name: ' || p_Name);

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('❌ Error: Customer ID ' || p_CustomerID || ' already exists. Insertion aborted.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('⚠️ Unexpected error: ' || SQLERRM);
END;
/
