/*
 * ## Exercise 3: Stored Procedures
 *
 * Scenario 1: The bank needs to process monthly interest for all savings accounts.
 * Question: Write a stored procedure ProcessMonthlyInterest that calculates and updates the balance of
 * all savings accounts by applying an interest rate of 1% to the current balance.
 *
 * Scenario 2: The bank wants to implement a bonus scheme for employees based on their performance.
 * Question: Write a stored procedure UpdateEmployeeBonus that updates the salary of employees in a
 * given department by adding a bonus percentage passed as a parameter.
 *
 * Scenario 3: Customers should be able to transfer funds between their accounts.
 * Question: Write a stored procedure TransferFunds that transfers a specified amount from one account
 * to another, checking that the source account has sufficient balance before making the transfer.
 */

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE accounts
    SET balance = balance + (balance * 0.01)
    WHERE account_type = 'savings';
END ProcessMonthlyInterest;

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department_id IN NUMBER,
    p_bonus_percentage IN NUMBER
) AS
BEGIN
    UPDATE employees
    SET salary = salary + (salary * (p_bonus_percentage / 100))
    WHERE department_id = p_department_id;
END UpdateEmployeeBonus;

CREATE OR REPLACE PROCEDURE TransferFunds(
    p_source_account_id IN NUMBER,
    p_target_account_id IN NUMBER,
    p_amount IN NUMBER
) AS 
    v_source_balance NUMBER;
BEGIN
    SELECT balance INTO v_source_balance FROM accounts WHERE account_id = p_source_account_id;
    IF v_source_balance >= p_amount THEN
        UPDATE accounts
        SET balance = balance - p_amount
        WHERE account_id = p_source_account_id;

        UPDATE accounts
        SET balance = balance + p_amount
        WHERE account_id = p_target_account_id;
    ELSE
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RAISE_APPLICATION_ERROR(-20002, 'Source or target account not found.');
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20003, 'An unexpected error occurred: ' || SQLERRM);
END TransferFunds;

/*
You're asking about this:

```sql
RAISE_APPLICATION_ERROR(
    -20001,
    'Insufficient balance.'
);
```

The `-20001` is a **custom Oracle error number**.

---

## Oracle Reserved Errors

Oracle has built-in error codes:

```text
ORA-00001  -> Unique constraint violated
ORA-01403  -> No data found
ORA-00942  -> Table does not exist
```

You don't create these.

---

## Your Own Errors

Oracle reserves:

```text
-20000 to -20999
```

for application-defined errors.

Example:

```sql
RAISE_APPLICATION_ERROR(
    -20001,
    'Insufficient balance'
);
```

Another:

```sql
RAISE_APPLICATION_ERROR(
    -20002,
    'Customer already exists'
);
```

Another:

```sql
RAISE_APPLICATION_ERROR(
    -20003,
    'Loan amount exceeds limit'
);
```

---

## What Happens?

```sql
BEGIN
    TransferFunds(1, 2, 100000);
END;
/
```

Output:

```text
ORA-20001: Insufficient balance.
```

Notice Oracle prefixes your error code with:

```text
ORA-
```

---

## Can I Use Any Number?

No.

This is invalid:

```sql
RAISE_APPLICATION_ERROR(-1, 'Error');
```

Use only:

```text
-20000
    ↓
-20999
```

---

## Good Practice

Define a meaning for each code.

| Error Code | Meaning                       |
| ---------- | ----------------------------- |
| `-20001`   | Insufficient balance          |
| `-20002`   | Customer not found            |
| `-20003`   | Invalid account               |
| `-20004`   | Loan already closed           |
| `-20005`   | Daily transfer limit exceeded |

This way, your application can react differently based on the error code.

For example, a Java Spring Boot service could catch `ORA-20001` and return:

```json
{
  "error": "Insufficient balance"
}
```

while `ORA-20002` could become:

```json
{
  "error": "Customer not found"
}
```

The numeric code gives your application a stable way to identify the specific business error.


Mostly convention.

Many developers leave -20000 unused or reserve it for a generic application error:

-20000 -> Generic application error
-20001 -> Insufficient balance
-20002 -> Customer not found
-20003 -> Invalid account
-20004 -> Daily transfer limit exceeded
*/
