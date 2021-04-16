-- Database (Catalog)
use practice;

-- Table setting
CREATE TABLE SELFLEARN (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR(20) DEFAULT 'member name' NOT NULL,
  PASS VARCHAR(50) NOT NULL,
  ADDRESS VARCHAR(100),
  TEL VARCHAR(20),
  EMAIL VARCHAR(100)
) ENGINE=InnoDB;

Query OK, 0 rows affected (0.06 sec)

mysql> SHOW FIELDS FROM SELFLEARN;
+---------+--------------+------+-----+-------------+----------------+
| Field   | Type         | Null | Key | Default     | Extra          |
+---------+--------------+------+-----+-------------+----------------+
| ID      | int          | NO   | PRI | NULL        | auto_increment |
| NAME    | varchar(20)  | NO   |     | member name |                |
| PASS    | varchar(50)  | NO   |     | NULL        |                |
| ADDRESS | varchar(100) | YES  |     | NULL        |                |
| TEL     | varchar(20)  | YES  |     | NULL        |                |
| EMAIL   | varchar(100) | YES  |     | NULL        |                |
+---------+--------------+------+-----+-------------+----------------+

-- insert data
INSERT INTO SELFLEARN (NAME, PASS, ADDRESS, TEL, EMAIL)
  VALUES ('山田太郎','1111','東京都東京市','03-9999-xxxx','yamada@wings.masn.to');
INSERT INTO SELFLEARN (NAME, PASS, ADDRESS, TEL, EMAIL)
  VALUES ('鈴木浩二','1111','神奈川県横浜市','045-1111-xxxx','suzuki@wings.msn.to');
INSERT INTO SELFLEARN (NAME, PASS, ADDRESS, TEL, EMAIL)
  VALUES ('井上春子','1111','埼玉県浦安市','04-2222-xxxx','inoue@wings.msn.to');
INSERT INTO SELFLEARN (NAME, PASS, ADDRESS, TEL, EMAIL)
  VALUES ('佐々木のぞみ','1111','千葉県松戸市','04-3333-xxxx','sasaki@wings.msn.to');
INSERT INTO SELFLEARN (NAME, PASS, ADDRESS, TEL, EMAIL)
  VALUES ('川本健三','1111','埼玉県本庄市','04-4444-xxxx','kawamoto@wings.msn.to');
INSERT INTO SELFLEARN (NAME, PASS, ADDRESS, TEL, EMAIL)
  VALUES ('佐藤洋一','1111','東京都東京市','03-5555-xxxx','satou@wings.msn.to');
INSERT INTO SELFLEARN (NAME, PASS, ADDRESS, TEL, EMAIL)
  VALUES ('田中洋子','1111','埼玉県武蔵野市','04-6666-xxxx','tanaka@wings.msn.to');
INSERT INTO SELFLEARN (NAME, PASS, ADDRESS, TEL, EMAIL)
  VALUES ('中川洋一','1111','神奈川県横浜市','04-7777-xxxx','nakagawa@wings.msn.to');
INSERT INTO SELFLEARN (NAME, PASS, ADDRESS, TEL, EMAIL)
  VALUES ('松原ゆり','1111','東京都町田市','04-8888-xxxx','matsubara@wings.msn.to');
INSERT INTO SELFLEARN (NAME, PASS, ADDRESS, TEL, EMAIL)
  VALUES ('香原美穂','1111','神奈川県横浜市','04-9999-xxxx','kouhara@wings.msn.to');

 select * from selflearn;
+----+--------------------+------+-----------------------+---------------+------------------------+
| ID | NAME               | PASS | ADDRESS               | TEL           | EMAIL                  |
+----+--------------------+------+-----------------------+---------------+------------------------+
|  1 | 山田太郎           | 1111 | 東京都東京市          | 03-9999-xxxx  | yamada@wings.masn.to   |
|  2 | 鈴木浩二           | 1111 | 神奈川県横浜市        | 045-1111-xxxx | suzuki@wings.msn.to    |
|  3 | 井上春子           | 1111 | 埼玉県浦安市          | 04-2222-xxxx  | inoue@wings.msn.to     |
|  4 | 佐々木のぞみ       | 1111 | 千葉県松戸市          | 04-3333-xxxx  | sasaki@wings.msn.to    |
|  5 | 川本健三           | 1111 | 埼玉県本庄市          | 04-4444-xxxx  | kawamoto@wings.msn.to  |
|  6 | 佐藤洋一           | 1111 | 東京都東京市          | 03-5555-xxxx  | satou@wings.msn.to     |
|  7 | 田中洋子           | 1111 | 埼玉県武蔵野市        | 04-6666-xxxx  | tanaka@wings.msn.to    |
|  8 | 中川洋一           | 1111 | 神奈川県横浜市        | 04-7777-xxxx  | nakagawa@wings.msn.to  |
|  9 | 松原ゆり           | 1111 | 東京都町田市          | 04-8888-xxxx  | matsubara@wings.msn.to |
| 10 | 香原美穂           | 1111 | 神奈川県横浜市        | 04-9999-xxxx  | kouhara@wings.msn.to   |
+----+--------------------+------+-----------------------+---------------+------------------------+

