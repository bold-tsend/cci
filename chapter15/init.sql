# Tables for buildings
############################
drop table if exists `complexes`; 
CREATE TABLE `complexes` (
  `ComplexID` int(11) NOT NULL AUTO_INCREMENT,
  `ComplexName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ComplexID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
insert into complexes (ComplexName) values ('Complex 1');

drop table if exists `buildings`; 
CREATE TABLE `buildings` (
  `BuildingID` int(11) NOT NULL AUTO_INCREMENT,
  `ComplexID` int(11) DEFAULT NULL,
  `BuildingName` varchar(45) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`BuildingID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
insert into buildings (ComplexID, BuildingName, Address) values (1, 'Building 1', 'Moon');
insert into buildings (ComplexID, BuildingName, Address) values (1, 'Building 2', 'Mars');

drop table if exists `apartments`;
CREATE TABLE `apartments` (
  `AptID` int(11) NOT NULL AUTO_INCREMENT,
  `UnitNumber` varchar(45) DEFAULT NULL,
  `BuildingID` int(11) DEFAULT NULL,
  PRIMARY KEY (`AptID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
insert into apartments (UnitNumber, BuildingID) values (1, 1);
insert into apartments (UnitNumber, BuildingID) values (2, 1);
insert into apartments (UnitNumber, BuildingID) values (3, 1);
insert into apartments (UnitNumber, BuildingID) values (4, 1);
insert into apartments (UnitNumber, BuildingID) values (5, 1);
insert into apartments (UnitNumber, BuildingID) values (1, 2);
insert into apartments (UnitNumber, BuildingID) values (2, 2);
insert into apartments (UnitNumber, BuildingID) values (3, 2);
insert into apartments (UnitNumber, BuildingID) values (4, 2);
insert into apartments (UnitNumber, BuildingID) values (5, 2);

drop table if exists `tenants`;
CREATE TABLE `tenants` (
  `TenantID` int(11) NOT NULL AUTO_INCREMENT,
  `TenantName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`TenantID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
insert into tenants (TenantName) values ('Bob');
insert into tenants (TenantName) values ('Alice');
insert into tenants (TenantName) values ('Kyle');

drop table if exists `apttenants`;
CREATE TABLE `apttenants` (
  `TenantID` int(11) DEFAULT NULL,
  `AptID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into apttenants (TenantID, AptID) values (1, 1);
insert into apttenants (TenantID, AptID) values (1, 2);
insert into apttenants (TenantID, AptID) values (1, 3);
insert into apttenants (TenantID, AptID) values (2, 4);
insert into apttenants (TenantID, AptID) values (2, 5);
insert into apttenants (TenantID, AptID) values (2, 6);
insert into apttenants (TenantID, AptID) values (2, 7);
insert into apttenants (TenantID, AptID) values (3, 8);

drop table if exists `requests`; 
CREATE TABLE `requests` (
  `RequestID` int(11) NOT NULL AUTO_INCREMENT,
  `Status` varchar(45) DEFAULT NULL,
  `AptID` int(11) DEFAULT NULL,
  `Description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`RequestID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into requests (Status, AptID, Description) values ('open', 1, '');
insert into requests (Status, AptID, Description) values ('closed', 2, '');
insert into requests (Status, AptID, Description) values ('open', 4, '');
insert into requests (Status, AptID, Description) values ('open', 6, '');
insert into requests (Status, AptID, Description) values ('closed', 1, '');
insert into requests (Status, AptID, Description) values ('open', 9, '');

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
