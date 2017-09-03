# Web Application which pulls data from PostgreSQL DB

Quick Start
-----------

1. Install [PostgreSQL](https://www.postgresql.org/)
2. Get [PostgreSQL JDBC4 Driver](https://jdbc.postgresql.org/download.html)
and save it to Tomcat web server's *lib* directory
3. Create PostgreSQL DB
```sql
create user huser;
create database huser with owner = huser;

CREATE TABLE IF NOT EXISTS authors (
    id int PRIMARY KEY, 
    name VARCHAR(25)
);

INSERT INTO authors(id, name) VALUES(1, 'Rob Bal');
INSERT INTO authors(id, name) VALUES(2, 'John Carter');
INSERT INTO authors(id, name) VALUES(3, 'Chris London');
INSERT INTO authors(id, name) VALUES(4, 'Truman De Bal');
INSERT INTO authors(id, name) VALUES(5, 'Emile Capote');
INSERT INTO authors(id, name) VALUES(7, 'Breech Jabber');
INSERT INTO authors(id, name) VALUES(8, 'Bob Carter');
INSERT INTO authors(id, name) VALUES(9, 'Nelson Mand');
INSERT INTO authors(id, name) VALUES(10, 'Tennant Mark');

alter user huser with password 'huser';

grant all on authors to huser;
```
4. Open the project in Eclipse and run it "*Run as...*" &rarr; "*Run on Server*"