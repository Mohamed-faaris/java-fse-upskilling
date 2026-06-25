/*
 * ## Exercise 1: Control Structures
 *
 * Scenario 1: The bank wants to apply a discount to loan interest rates for customers above 60 years
 * old.
 * Question: Write a PL/SQL block that loops through all customers, checks their age, and if they are
 * above 60, apply a 1% discount to their current loan interest rates.
 * Scenario 2: A customer can be promoted to VIP status based on their balance.
 * Question: Write a PL/SQL block that iterates through all customers and sets a flag IsVIP to TRUE for
 * those with a balance over $10,000.
 * Scenario 3: The bank wants to send reminders to customers whose loans are due within the next 30
 * days.
 * Question: Write a PL/SQL block that fetches all loans due in the next 30 days and prints a reminder
 * message for each customer.
 */
BEGIN
    FOR
     rec IN (SELECT * FROM customers)   
    LOOP
        //senario 1
        IF rec.age > 60 THEN
            UPDATE customers SET loan_interest_rate = loan_interest_rate - 1 WHERE customer_id = rec.customer_id;
        END IF;

        //senario 2
        IF rec.balance > 10000 THEN
            UPDATE customers SET is_vip = TRUE WHERE customer_id = rec.customer_id;
        END IF;


    END LOOP;
END;

//senario 3

BEGIN
    FOR rec IN (SELECT * FROM loans WHERE due_date BETWEEN SYSDATE AND SYSDATE + 30)   
    LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan for customer ' || rec.customer_id || ' is due on ' || rec.due_date);
    END LOOP;
END;
