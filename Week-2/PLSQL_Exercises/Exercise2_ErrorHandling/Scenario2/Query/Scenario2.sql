CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_EmployeeID IN Employees.EmployeeID%TYPE,
    p_Percent    IN NUMBER
) AS
    v_Salary Employees.Salary%TYPE;
BEGIN
    -- Check if employee exists and get current salary
    SELECT Salary INTO v_Salary
    FROM Employees
    WHERE EmployeeID = p_EmployeeID;

    -- Update salary
    UPDATE Employees
    SET Salary = v_Salary + (v_Salary * p_Percent / 100)
    WHERE EmployeeID = p_EmployeeID;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('✅ Salary updated for Employee ID ' || p_EmployeeID ||
                         ' by ' || p_Percent || '%.');

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('❌ Error: Employee ID ' || p_EmployeeID || ' not found.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('⚠️ Unexpected error: ' || SQLERRM);
END;
/
