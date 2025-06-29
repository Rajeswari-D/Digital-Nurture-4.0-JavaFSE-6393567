-- Enable output
SET SERVEROUTPUT ON;

-- PACKAGE SPEC
CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer(
        p_CustomerID   IN NUMBER,
        p_Name         IN VARCHAR2,
        p_DOB          IN DATE,
        p_Balance      IN NUMBER
    );

    PROCEDURE UpdateCustomer(
        p_CustomerID   IN NUMBER,
        p_Name         IN VARCHAR2,
        p_DOB          IN DATE
    );

    FUNCTION GetCustomerBalance(
        p_CustomerID IN NUMBER
    ) RETURN NUMBER;
END CustomerManagement;
/

-- PACKAGE BODY
CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer(
        p_CustomerID   IN NUMBER,
        p_Name         IN VARCHAR2,
        p_DOB          IN DATE,
        p_Balance      IN NUMBER
    ) IS
    BEGIN
        INSERT INTO Customers (Customer_ID, Name, DOB, Balance, LastModified)
        VALUES (p_CustomerID, p_Name, p_DOB, p_Balance, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Customer added: ' || p_Name);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Error: Customer ID ' || p_CustomerID || ' already exists.');
    END AddCustomer;

    PROCEDURE UpdateCustomer(
        p_CustomerID   IN NUMBER,
        p_Name         IN VARCHAR2,
        p_DOB          IN DATE
    ) IS
    BEGIN
        UPDATE Customers
        SET Name = p_Name,
            DOB = p_DOB,
            LastModified = SYSDATE
        WHERE Customer_ID = p_CustomerID;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('No customer found with ID: ' || p_CustomerID);
        ELSE
            DBMS_OUTPUT.PUT_LINE('Customer updated: ' || p_Name);
        END IF;
    END UpdateCustomer;

    FUNCTION GetCustomerBalance(
        p_CustomerID IN NUMBER
    ) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance
        FROM Customers
        WHERE Customer_ID = p_CustomerID;

        RETURN v_balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Customer not found: ' || p_CustomerID);
            RETURN NULL;
    END GetCustomerBalance;

END CustomerManagement;
/
