Drop TABLE greet;
CREATE TABLE greet(message_Id number(5) PRIMARY KEY,
 message VARCHAR2(25));
 
 CREATE SEQUENCE greet_seq;
 
 select * from greet;
 Drop TABLE student_master;
CREATE TABLE student_master
(student_id NUMBER(6) PRIMARY KEY,
student_name VARCHAR2(25));

CREATE SEQUENCE student_seq;

select * from student_master;
