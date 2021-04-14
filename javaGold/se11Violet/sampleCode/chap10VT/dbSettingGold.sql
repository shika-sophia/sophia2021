-- Database
USE practice;

-- Table Setting javaGold
CREATE TABLE javaGold
  (code INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR(20) NOT NULL,
   address VARCHAR(40) NOT NULL,
   tel VARCHAR(20));

SHOW FIELDS FROM JAVAGOLD;
+---------+-------------+------+-----+---------+----------------+
| Field   | Type        | Null | Key | Default | Extra          |
+---------+-------------+------+-----+---------+----------------+
| code    | int         | NO   | PRI | NULL    | auto_increment |
| name    | varchar(20) | NO   |     | NULL    |                |
| address | varchar(40) | NO   |     | NULL    |                |
| tel     | varchar(20) | YES  |     | NULL    |                |
+---------+-------------+------+-----+---------+----------------+

-- insert data
INSERT INTO JAVAGOLD
  (NAME, ADDRESS, TEL)
  VALUES ('SALES', 'TOKYO', '03-3333-XXXX');
INSERT INTO JAVAGOLD
  (NAME, ADDRESS, TEL)
  VALUES ('ENGINEER', 'YOKOHAMA', 'O45-555-XXXX');
INSERT INTO JAVAGOLD
  (NAME, ADDRESS, TEL)
  VALUES ('DEVEROP', 'OSAKA', NULL);
INSERT INTO JAVAGOLD
  (NAME, ADDRESS, TEL)
  VALUES ('MAKETING', 'FUKUOKA', '092-222-XXXX');
INSERT INTO JAVAGOLD
  (NAME, ADDRESS, TEL)
  VALUES ('EDUCATION', 'TOKYO', NULL);

SELECT * FROM JAVAGOLD;
+------+-----------+----------+--------------+
| code | name      | address  | tel          |
+------+-----------+----------+--------------+
|    1 | SALES     | TOKYO    | 03-3333-XXXX |
|    2 | ENGINEER  | YOKOHAMA | O45-555-XXXX |
|    3 | DEVEROP   | OSAKA    | NULL         |
|    4 | MAKETING  | FUKUOKA  | 092-222-XXXX |
|    5 | EDUCATION | TOKYO    | NULL         |
+------+-----------+----------+--------------+

-- ==== CallableStatement ====
-- Table Setting callable
CREATE TABLE CALLABLE
  (ID INT PRIMARY KEY AUTO_INCREMENT,
   VALUE INT,
   MEMO VARCHAR(50)
  )
;

SHOW FIELDS FROM CALLABLE;
+-------+-------------+------+-----+---------+----------------+
| Field | Type        | Null | Key | Default | Extra          |
+-------+-------------+------+-----+---------+----------------+
| ID    | int         | NO   | PRI | NULL    | auto_increment |
| VALUE | int         | YES  |     | NULL    |                |
| MEMO  | varchar(50) | YES  |     | NULL    |                |
+-------+-------------+------+-----+---------+----------------+

INSERT INTO CALLABLE
  (VALUE) VALUES (1100);
INSERT INTO CALLABLE
  (VALUE) VALUES (1100);
INSERT INTO CALLABLE
  (VALUE) VALUES (1200);
INSERT INTO CALLABLE
  (VALUE) VALUES (1300);

 SELECT * FROM CALLABLE;
+----+-------+------+
| ID | VALUE | MEMO |
+----+-------+------+
|  1 |  1100 | NULL |
|  2 |  1100 | NULL |
|  3 |  1200 | NULL |
|  4 |  1300 | NULL |
+----+-------+------+

-- procedure
CREATE PROCEDURE myProcedure (IN inPara INT, OUT total INT)
  BEGIN
    SELECT SUM(VALUE) INTO total
      FROM CALLABLE
      WHERE VALUE > inPara;
  END //

Query OK, 0 rows affected (0.02 sec)

