# SQL

## Commands

### Table Management
Keyword | Usage
-|-
create | create db obj
alter | alter db obj
drop | delete db obj

### Entry Management
Keyword | Usage
-|-
insert |  create entry
update | modify entry
delete | remove entry
modify | change property
add constraint | add more constraints to the table

### Query
Keyword | Usage
-|-
select | retrieve from table

## Concepts and Examples

### Keys
- **Primary Key:** Unique key in the table that serves as identifier for each entry.
- **Foreign Key:** Primary key in another table while having the foreign key in this table refering it.
```SQL
CREATE TABLE Example(
AGE INT NOT NULL,
NAME VARCHAR (20) NOT NULL,
CUSTOMER_ID INT references CUSTOMERS(ID),
PRIMARY KEY (AGE,NAME)
);
```
