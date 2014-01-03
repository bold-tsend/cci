# Tables for buildings
############################
drop table if exists `complexes`; 
CREATE TABLE `complexes` (
  `ComplexID` int(11) NOT NULL,
  `ComplexName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ComplexID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
insert into complexes values (1, 'Complex 1');

drop table if exists `buildings`; 
CREATE TABLE `buildings` (
  `BuildingID` int(11) NOT NULL,
  `ComplexID` int(11) DEFAULT NULL,
  `BuildingName` varchar(45) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`BuildingID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
insert into buildings values (1, 1, 'Building 1', 'Moon');
insert into buildings values (2, 1, 'Building 2', 'Mars');

drop table if exists `apartments`;
CREATE TABLE `apartments` (
  `AptID` int(11) NOT NULL,
  `UnitNumber` varchar(45) DEFAULT NULL,
  `BuildingID` int(11) DEFAULT NULL,
  PRIMARY KEY (`AptID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
insert into apartments values (1, 1, 1);
insert into apartments values (2, 2, 1);
insert into apartments values (3, 3, 1);
insert into apartments values (4, 4, 1);
insert into apartments values (5, 5, 1);
insert into apartments values (6, 1, 2);
insert into apartments values (7, 2, 2);
insert into apartments values (8, 3, 2);
insert into apartments values (9, 4, 2);
insert into apartments values (10, 5, 2);

drop table if exists `tenants`;
CREATE TABLE `tenants` (
  `TenantID` int(11) NOT NULL,
  `TenantName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`TenantID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
insert into tenants values (1, 'Bob');
insert into tenants values (2, 'Alice');
insert into tenants values (3, 'Kyle');

drop table if exists `apttenants`;
CREATE TABLE `apttenants` (
  `TenantID` int(11) DEFAULT NULL,
  `AptID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into apttenants values (1, 1);
insert into apttenants values (1, 2);
insert into apttenants values (1, 3);
insert into apttenants values (2, 4);
insert into apttenants values (2, 5);
insert into apttenants values (2, 6);
insert into apttenants values (2, 7);
insert into apttenants values (3, 8);

drop table if exists `requests`; 
CREATE TABLE `requests` (
  `RequestID` int(11) NOT NULL,
  `Status` varchar(45) DEFAULT NULL,
  `AptID` int(11) DEFAULT NULL,
  `Description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`RequestID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into requests values (1, 'open', 1, '');
insert into requests values (2, 'closed', 2, '');
insert into requests values (3, 'open', 4, '');
insert into requests values (4, 'open', 6, '');
insert into requests values (5, 'closed', 1, '');
insert into requests values (6, 'open', 9, '');

# Tables for student grades
############################
drop table if exists `students`;
CREATE TABLE `students` (
  `StudentID` int(11) NOT NULL,
  `StudentName` varchar(45) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`StudentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into students values (1, 'Bob', '');
insert into students values (2, 'Alan', '');
insert into students values (3, 'Maier', '');
insert into students values (4, 'Kyle', '');
insert into students values (5, 'Chloe', '');
insert into students values (6, 'Christian', '');
insert into students values (7, 'Michael', '');
insert into students values (8, 'Dave', '');

drop table if exists `courses`;
CREATE TABLE `courses` (
  `CourseID` int(11) NOT NULL,
  `CourseName` varchar(45) DEFAULT NULL,
  `ProfessorID` int(11) DEFAULT NULL,
  PRIMARY KEY (`CourseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into courses values (1, 'Math', 0);
insert into courses values (2, 'Databases', 0);
insert into courses values (3, 'Programming', 0);

drop table if exists `courseenrollment`;
CREATE TABLE `courseenrollment` (
  `CourseID` int(11) NOT NULL,
  `StudentID` int(11) NOT NULL,
  `Grade` float DEFAULT NULL,
  `Term` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into courseenrollment values (1, 1, 1.0, 1);
insert into courseenrollment values (1, 2, 2.3, 1);
insert into courseenrollment values (1, 3, 3.7, 1);
insert into courseenrollment values (2, 1, 3.0, 1);
insert into courseenrollment values (2, 2, 4.0, 1);
insert into courseenrollment values (2, 3, 2.7, 1);
insert into courseenrollment values (3, 1, 3.3, 1);
insert into courseenrollment values (3, 2, 2.3, 1);
insert into courseenrollment values (3, 3, 1.3, 1);
insert into courseenrollment values (4, 1, 3.7, 1);
insert into courseenrollment values (4, 2, 3.7, 1);
insert into courseenrollment values (4, 3, 3.7, 1);
insert into courseenrollment values (5, 1, 4.0, 1);
insert into courseenrollment values (5, 2, 2.0, 1);
insert into courseenrollment values (5, 3, 1.0, 1);
insert into courseenrollment values (6, 1, 5.3, 1);
insert into courseenrollment values (6, 2, 2.3, 1);
insert into courseenrollment values (6, 3, 1.7, 1);
insert into courseenrollment values (7, 1, 2.3, 1);
insert into courseenrollment values (7, 2, 1.7, 1);
insert into courseenrollment values (7, 3, 4.4, 1);
insert into courseenrollment values (8, 1, 3.7, 1);
insert into courseenrollment values (8, 2, 4.0, 1);
insert into courseenrollment values (8, 3, 2.0, 1);
