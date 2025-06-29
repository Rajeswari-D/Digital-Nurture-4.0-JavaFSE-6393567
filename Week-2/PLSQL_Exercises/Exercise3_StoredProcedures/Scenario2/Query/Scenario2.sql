CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_Department IN VARCHAR2,
    p_BonusPct   IN NUMBER  
) AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * (p_BonusPct / 100))
    WHERE Department = p_Department;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('✅ Bonus of ' || p_BonusPct || '% applied to department: ' || p_Department);
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('❌ Error: ' || SQLERRM);
        ROLLBACK;
END;
/
