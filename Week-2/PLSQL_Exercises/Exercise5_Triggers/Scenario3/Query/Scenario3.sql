CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_Balance NUMBER;
BEGIN
    -- Get the current balance of the account
    SELECT Balance INTO v_Balance
    FROM Accounts
    WHERE AccountID = :NEW.AccountID;

    -- Rule 1: Withdrawal should not exceed balance
    IF :NEW.TransactionType = 'Withdrawal' AND :NEW.Amount > v_Balance THEN
        RAISE_APPLICATION_ERROR(-20001, '❌ Withdrawal amount exceeds account balance.');
    END IF;

    -- Rule 2: Deposit must be a positive amount
    IF :NEW.TransactionType = 'Deposit' AND :NEW.Amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20002, '❌ Deposit amount must be greater than 0.');
    END IF;
END;
/
