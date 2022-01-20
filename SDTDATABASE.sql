
USE institution_database;


CREATE TABLE Cycle(
	cycle_id INT PRIMARY KEY,
    cycle_name VARCHAR(30),
    dep_id INT
    );
    
    
CREATE TABLE Department(
	dep_id INT PRIMARY KEY,
    dep_name VARCHAR(30),
    course_id VARCHAR(10)
);

ALTER TABLE Cycle ADD FOREIGN KEY(dep_id) 
REFERENCES Cycle(cycle_id) ON DELETE SET NULL;


ALTER TABLE Cycle ADD FOREIGN KEY(dep_id)
REFERENCES Cycle(cycle_id) ON DELETE SET NULL;


CREATE TABLE Course(
	course_id INT PRIMARY KEY,
    course_name VARCHAR(30),
    course_code VARCHAR(7),
    teacher_id INT
);

CREATE TABLE Teacher(
	teacher_id INT PRIMARY KEY,
    teacher_first_name VARCHAR(20),
    teacher_second_name VARCHAR(20),
    teacher_tel INT,
    teacher_email VARCHAR(20)
    );
    
CREATE TABLE Marks(
	mark_id INT PRIMARY KEY,
	mark DECIMAL,
    stu_id INT,
    course_id INT,
    FOREIGN KEY(course_id) REFERENCES Marks(mark_id) 
    ON DELETE SET NULL
);
 CREATE TABLE class(
 class_id int primary key,
 class_code varchar(10),
 class_name varchar(60),
 dep_id int,
 cycle_id int,
 foreign key(dep_id) references department(dep_id) on delete set null,
 foreign key(cycle_id) references cycle(cycle_id)  on delete set null
 );
drop table class;
 
 INSERT INTO class values
 (11200, "BTCCE", "basic technical cycle civil 
engineering year 1", 1, 1),
 (12200, "BTCRE","basic technical cycle rural 
engineering year 1", 2,1),
 (13200, "BTCTP","basic technical cycle town 
planning year 1", 3,1),
 (14200, "BTCLS","basic technical cycle land 
survey year 1", 4,1),
 (21200, "OTCCE","ordinary technical cycle civil 
engineering year 1", 1,2),
 (22200, "OTCRE","ordinary technical cycle rual 
engineering year 1", 2,2),
 (23200, "OTCTP","ordinary technical cycle town 
planning year 1", 3,2),
 (24200, "OTCLS","ordinary technical cycle land 
survey year 1", 4,2),
 (31200, "HTCCE","higher technical cycle civil 
engineering year 1", 1,3),
 (32200, "HTCRE","higher technical cycle rural 
engineering year 1", 2,3),
 (33200, "HTCTP","higher technical cycle town 
planning year 1", 3,3),
 (34200, "HTCLS","higher technical cycle land 
survey year 1",4,3);
 

CREATE TABLE users(
	user_id INT AUTO_INCREMENT PRIMARY KEY,
	typ VARCHAR(5),
    passwords VARCHAR(30),
    email VARCHAR(30)    
);

CREATE TABLE Adminn(
	f_name VARCHAR(20),
    l_name VARCHAR(20),
    user_id INT,
    FOREIGN KEY(user_id) REFERENCES users(user_id)
);

CREATE TABLE student(
	stu_id VARCHAR(20) PRIMARY KEY,
    f_name VARCHAR(20),
    l_name VARCHAR(20),
    sex VARCHAR(1),
    date_of_birth DATE,
    place_of_birth VARCHAR(20),
    mothers_name VARCHAR(20),
    mothers_address VARCHAR(50),
	fathers_name VARCHAR(20),
	fathers_address VARCHAR(50),
    division_of_origin VARCHAR(30),
    region_of_origin VARCHAR(20),
    address VARCHAR(50),
    marital_status VARCHAR(10),
    qualification VARCHAR(100),
    user_id INT,
    reg_date TIMESTAMP,
    cycle_id INT,
    dep_id INT,
    FOREIGN KEY(cycle_id) REFERENCES Cycle(cycle_id) 
    ON DELETE SET NULL,
    FOREIGN KEY(dep_id) REFERENCES Cycle(cycle_id) 
    ON DELETE SET NULL,
    FOREIGN KEY(user_id) REFERENCES users(user_id)
   );

CREATE TABLE enrolment(
class_id int,
stu_id int,
foreign key(class_id) references class(class_id) on delete set null,
foreign key(stu_id) references student(stu_id) on delete set null
);

drop table enrolment;

ALTER TABLE Marks ADD FOREIGN KEY(stu_id) 
REFERENCES users(user_id) ON DELETE SET NULL;

ALTER TABLE Course ADD FOREIGN KEY(teacher_id) 
REFERENCES Course(course_id) ON DELETE SET NULL;
   
  
   




