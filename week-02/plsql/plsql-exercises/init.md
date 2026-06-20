# Oracle XE + SQLPlus (Docker Only)

Assume:

* Docker is installed
* `init.sql` already exists

---

## Start Oracle XE

```bash
docker run -d \
  --name oracle-xe \
  -p 1521:1521 \
  -e ORACLE_PASSWORD=oracle \
  gvenzl/oracle-xe:21-slim
```

---

## Wait For Startup

```bash
docker logs -f oracle-xe
```

Wait until:

```text
DATABASE IS READY TO USE
```

---

## Open SQLPlus

```bash
docker exec -it oracle-xe sqlplus system/oracle@XEPDB1
```

If that fails:

```bash
docker exec -it oracle-xe sqlplus system/oracle@FREEPDB1
```

---

## Run init.sql

Copy file into container:

```bash
docker cp init.sql oracle-xe:/tmp/init.sql
```

Execute:

```sql
@/tmp/init.sql
```

---

## Enable Output

```sql
SET SERVEROUTPUT ON;
```

---

## Verify Connection

```sql
SELECT 'Hello Oracle'
FROM dual;
```

---

## Test PL/SQL

```sql
BEGIN
    DBMS_OUTPUT.PUT_LINE('PLSQL Works');
END;
/
```

Expected:

```text
PLSQL Works
```

---

## Show Tables

```sql
SELECT table_name
FROM user_tables;
```

---

## Show Data

```sql
SELECT *
FROM Customers;
```

---

## Exit SQLPlus

```sql
EXIT;
```

---

## Stop Database

```bash
docker stop oracle-xe
```

---

## Start Database

```bash
docker start oracle-xe
```

---

## Delete Database

```bash
docker rm -f oracle-xe
```
