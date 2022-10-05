--employee
INSERT INTO employee(emp_no,first_name,last_name,position,department,email) 
values ('00001','อภิสิทธิ์','น้อยหลวงชัย','Programmer','ADD','apisitn9244@gmail.com');
INSERT INTO employee(emp_no,first_name,last_name,position,department,email) 
values ('00002','สรวิชญ์','เจียวก๊ก','Programmer','ADD','mixwalkerz1@gmail.com');
INSERT INTO employee(emp_no,first_name,last_name,position,department,email) 
values ('00003','ธนภัทร','ขาวสอาด','Programmer','ADD','mixlostarkstar@gmail.com');
INSERT INTO employee(emp_no,first_name,last_name,position,department) 
values ('00004','อดัม','สเมชเชอร์','Programmer','ADD');
INSERT INTO employee(emp_no,first_name,last_name,position,department) 
values ('C1001','เดวิด','มาติเนซ','Programmer Specialist 1','ADD');
INSERT INTO employee(emp_no,first_name,last_name,position,department) 
values ('C1006','บัวขาว','ใจทอง','Programmer Specialist 1','ADD');
INSERT INTO employee(emp_no,first_name,last_name,position,department) 
values ('C2007','จอร์จ','ลี','Programmer Specialist 2','ADD');
INSERT INTO employee(emp_no,first_name,last_name,position,department) 
values ('C2008','จอร์นนี่','เจ็คซัน','Programmer Specialist 2','ADD');
INSERT INTO employee(emp_no,first_name,last_name,position,department) 
values ('00009','อลัน','ทัวริ่ง','Programmer','ADD');
INSERT INTO employee(emp_no,first_name,last_name,position,department) 
values ('00010','สมชาย','ศิริ','Programmer','ADD');

--project
INSERT INTO Project(PROJ_REF,PROJ_CODE,CUSTOMER_CODE,PROJ_NAME,PROJ_TYPE,PROJ_ABBR_THAI,PROJ_ABBR_ENG,PROJ_START_DATE,PROJ_END_DATE,status)
VALUES (1,'PD220011','CDGS','โครงการแอปพลิเคชันขายสินค้าออนไลน์','2','ขายออนไลน์','POS',sysdate,sysdate,2);
INSERT INTO Project(PROJ_REF,PROJ_CODE,CUSTOMER_CODE,PROJ_NAME,PROJ_TYPE,PROJ_ABBR_THAI,PROJ_ABBR_ENG,PROJ_START_DATE,PROJ_END_DATE,status) 
VALUES (2,'PD220012','CDGS','โครงการแอปพลิเคชัน PG Pool','1','พีจีพู','PGP',sysdate,sysdate,2);
INSERT INTO Project(PROJ_REF,PROJ_CODE,CUSTOMER_CODE,PROJ_NAME,PROJ_TYPE,PROJ_ABBR_THAI,PROJ_ABBR_ENG,PROJ_START_DATE,PROJ_END_DATE,status) 
VALUES (3,'PD220013','CDGS','โครงการแอปพลิเคชันแบบข้อสอบออนไลน์','1','ข้อสอบออนไลน์','EXAM',sysdate,sysdate,2);
INSERT INTO Project(PROJ_REF,PROJ_CODE,CUSTOMER_CODE,PROJ_NAME,PROJ_TYPE,PROJ_ABBR_THAI,PROJ_ABBR_ENG,PROJ_START_DATE,PROJ_END_DATE,status) 
VALUES (4,'PD220014','CDGS','โครงการแอปพลิเคชัน Program-Spec','1','โปรแกรมสเปค','PGS',sysdate,sysdate,2);

--POS
INSERT INTO operation(op_id,emp_no,PROJ_REF)
values (1,'00001',1);
INSERT INTO operation(op_id,emp_no,PROJ_REF)
values (2,'00002',1);
INSERT INTO operation(op_id,emp_no,PROJ_REF)
values (3,'00003',1);
INSERT INTO operation(op_id,emp_no,PROJ_REF)
values (4,'00004',1);
INSERT INTO operation(op_id,emp_no,PROJ_REF)
values (5,'C1001',1);
INSERT INTO operation(op_id,emp_no,PROJ_REF)
values (6,'C1002',1);

--PGPOOL
INSERT INTO operation(op_id,emp_no,PROJ_REF)
values (7,'00001',2);
INSERT INTO operation(op_id,emp_no,PROJ_REF)
values (8,'00002',2);

--EXAM
INSERT INTO operation(op_id,emp_no,PROJ_REF)
values (9,'C1006',3);
INSERT INTO operation(op_id,emp_no,PROJ_REF)
values (10,'C2007',3);

--SPEC
INSERT INTO operation(op_id,emp_no,PROJ_REF)
values (11,'00009',4);
INSERT INTO operation(op_id,emp_no,PROJ_REF)
values (12,'C2008',4);

--POS
INSERT INTO employeeoperation(empop_id,empop_startdate,empop_enddate,duration,working,assigned,op_id) 
values (1,sysdate,sysdate,5.13,48.7,2.5,1);
INSERT INTO employeeoperation(empop_id,empop_startdate,empop_enddate,duration,working,assigned,op_id) 
values (2,sysdate,sysdate,5.13,100,2.5,2);
INSERT INTO employeeoperation(empop_id,empop_startdate,empop_enddate,duration,working,assigned,op_id) 
values (3,sysdate,sysdate,6.25,56,2.5,4);
INSERT INTO employeeoperation(empop_id,empop_startdate,empop_enddate,duration,working,assigned,op_id) 
values (5,sysdate,sysdate,6.25,58.00,2.5,5);
INSERT INTO employeeoperation(empop_id,empop_startdate,empop_enddate,duration,working,assigned,op_id) 
values (7,sysdate,sysdate,6.25,29,2.5,3);

--PGPOOL
INSERT INTO employeeoperation(empop_id,empop_startdate,empop_enddate,duration,working,assigned,op_id) 
values (8,sysdate,sysdate,1.4,48.7,2.5,7);
INSERT INTO employeeoperation(empop_id,empop_startdate,empop_enddate,duration,working,assigned,op_id) 
values (10,sysdate,sysdate,1,28,2.5,7);
INSERT INTO employeeoperation(empop_id,empop_startdate,empop_enddate,duration,working,assigned,op_id) 
values (9,sysdate,sysdate,1.5,100,2.5,8);

--Exam
INSERT INTO employeeoperation(empop_id,empop_startdate,empop_enddate,duration,working,assigned,op_id) 
values (11,sysdate,sysdate,1,75,2.5,9);
INSERT INTO employeeoperation(empop_id,empop_startdate,empop_enddate,duration,working,assigned,op_id) 
values (12,sysdate,sysdate,1.5,25,2.5,10);

--SPEC
INSERT INTO employeeoperation(empop_id,empop_startdate,empop_enddate,duration,working,assigned,op_id) 
values (13,sysdate,sysdate,1,60,2.5,11);
INSERT INTO employeeoperation(empop_id,empop_startdate,empop_enddate,duration,working,assigned,op_id) 
values (14,sysdate,sysdate,1.5,45,2.5,12);


INSERT INTO AMOUNT_EMPLOYEES(AMOUNT_ID) values (1);

INSERT INTO Users(username,password) values ('admin','1234');

INSERT INTO approve_project(approve_id,approve_month,approve_year) values (1,'1','1');
INSERT INTO approve_project(approve_id,approve_month,approve_year) values (2,'1','1');
