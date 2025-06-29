CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_LoanAmount        IN NUMBER,
    p_AnnualInterestRate IN NUMBER,
    p_LoanDurationYears IN NUMBER
) RETURN NUMBER IS
    v_MonthlyRate   NUMBER;
    v_TotalMonths   NUMBER;
    v_EMI           NUMBER;
BEGIN
    v_MonthlyRate := p_AnnualInterestRate / 12 / 100;
    v_TotalMonths := p_LoanDurationYears * 12;

    IF v_MonthlyRate = 0 THEN
        v_EMI := p_LoanAmount / v_TotalMonths;
    ELSE
        v_EMI := (p_LoanAmount * v_MonthlyRate * POWER(1 + v_MonthlyRate, v_TotalMonths)) /
                 (POWER(1 + v_MonthlyRate, v_TotalMonths) - 1);
    END IF;

    RETURN ROUND(v_EMI, 2);
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('⚠️ Error calculating EMI: ' || SQLERRM);
        RETURN NULL;
END;
/
