create schema ums;

CREATE TABLE student (
  idstudent int NOT NULL AUTO_INCREMENT,
  firstname varchar(45) DEFAULT NULL,
  lastname varchar(45) DEFAULT NULL,
  totalcredits int DEFAULT NULL,
  PRIMARY KEY (idstudent)
);

CREATE TABLE teacher (
  idteacher int NOT NULL AUTO_INCREMENT,
  firstname varchar(45) DEFAULT NULL,
  lastname varchar(45) DEFAULT NULL,
  PRIMARY KEY (idteacher)
);

CREATE TABLE course (
  idcourse int NOT NULL AUTO_INCREMENT,
  namecourse varchar(45) DEFAULT NULL,
  maxenrollment int NOT NULL,
  credits int NOT NULL,
  PRIMARY KEY (idcourse)
);

CREATE TABLE course_teacher (
  idteacher int NOT NULL,
  idcourseTeacher int NOT NULL,
  PRIMARY KEY (idteacher,idcourseTeacher),
  KEY idcourse_idx (idcourseTeacher),
  CONSTRAINT idcourse FOREIGN KEY (idcourseTeacher) REFERENCES course (idcourse),
  CONSTRAINT idteacher FOREIGN KEY (idteacher) REFERENCES teacher (idteacher)
);

CREATE TABLE student_course (
  idstudent int NOT NULL,
  idcourse int NOT NULL,
  PRIMARY KEY (idstudent,idcourse),
  KEY idcourse_idx (idcourse),
  CONSTRAINT idcourseStudent FOREIGN KEY (idcourse) REFERENCES course (idcourse),
  CONSTRAINT idstudent FOREIGN KEY (idstudent) REFERENCES student (idstudent)
);