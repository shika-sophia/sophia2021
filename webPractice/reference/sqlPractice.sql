-- SQL practice / 2021-02-03

create table house_account (
  id int primary key auto_increment,
  date Date not null,
  thing varchar(20),
  memo varchar(100),
  income int,
  export int
);

show columns from practice;
show columns from house_account;
+--------+--------------+------+-----+---------+----------------+
| Field  | Type         | Null | Key | Default | Extra          |
+--------+--------------+------+-----+---------+----------------+
| id     | int          | NO   | PRI | NULL    | auto_increment |
| date   | date         | NO   |     | NULL    |                |
| thing  | varchar(20)  | YES  |     | NULL    |                |
| memo   | varchar(100) | YES  |     | NULL    |                |
| income | int          | YES  |     | NULL    |                |
| export | int          | YES  |     | NULL    |                |
+--------+--------------+------+-----+---------+----------------+

INSERT INTO HOUSE_ACCOUNT
  (DATE, THING, MEMO, INCOME, EXPORT)
  VALUES ('2021-02-03','education','text of CCNA', 0, 3800)
;

SELECT * FROM HOUSE_ACCOUNT;
+----+------------+-----------+--------------+--------+--------+
| id | date       | thing     | memo         | income | export |
+----+------------+-----------+--------------+--------+--------+
|  1 | 2021-02-03 | education | text of CCNA |      0 |   3800 |
+----+------------+-----------+--------------+--------+--------+


