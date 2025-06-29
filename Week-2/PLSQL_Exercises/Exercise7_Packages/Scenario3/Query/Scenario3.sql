SET SERVEROUTPUT ON;

CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount(
        p_AccountID IN NUMBER,
        p_CustomerID IN NUMBER,
        p_AccountType IN VARCHAR2,
        p_Balance IN NUMBER
    );

    PROCEDURE CloseAccount(
        p_AccountID IN NUMBER
    );

    FUNCTION GetTotalBalance(
        p_CustomerID IN NUMBER
    ) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount(
        p_AccountID IN NUMBER,
        p_CustomerID IN NUMBER,
        p_AccountType IN VARCHAR2,
        p_Balance IN NUMBER
    ) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_AccountID, p_CustomerID, p_AccountType, p_Balance, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Account opened: ' || p_AccountID);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Account ID already exists: ' || p_AccountID);
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error opening account: ' || SQLERRM);
    END OpenAccount;

    PROCEDURE CloseAccount(
        p_AccountID IN NUMBER
    ) IS
    BEGIN
        DELETE FROM Accounts
        WHERE AccountID = p_AccountID;
        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('No account found with ID: ' || p_AccountID);
        ELSE
            DBMS_OUTPUT.PUT_LINE('Account closed: ' || p_AccountID);
        END IF;
    END CloseAccount;

    FUNCTION GetTotalBalance(
        p_CustomerID IN NUMBER
    ) RETURN NUMBER IS
        v_total NUMBER := 0;
    BEGIN
        SELECT NVL(SUM(Balance), 0)
        INTO v_total
        FROM Accounts
        WHERE CustomerID = p_CustomerID;
        RETURN v_total;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN 0;
    END GetTotalBalance;

END AccountOperations;
/
