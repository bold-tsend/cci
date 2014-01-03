drop database if exists `complexes`; 
CREATE TABLE `complexes` (
  `ComplexID` int(11) NOT NULL AUTO_INCREMENT,
  `ComplexName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ComplexID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
insert into complexes (ComplexName) values ('Complex 1');

drop database if exists `buildings`; 
CREATE TABLE `buildings` (
  `BuildingID` int(11) NOT NULL AUTO_INCREMENT,
  `ComplexID` int(11) DEFAULT NULL,
  `BuildingName` varchar(45) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`BuildingID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
insert into buildings (ComplexID, BuildingName, Address) values (1, 'Building 1', 'Moon');
insert into buildings (ComplexID, BuildingName, Address) values (1, 'Building 2', 'Mars');

drop database if exists `apartments`;
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

drop database if exists `tenants`;
CREATE TABLE `tenants` (
  `TenantID` int(11) NOT NULL AUTO_INCREMENT,
  `TenantName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`TenantID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
insert into tenants (TenantName) values ('Bob');
insert into tenants (TenantName) values ('Alice');
insert into tenants (TenantName) values ('Kyle');

drop database if exists `apttenants`;
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

drop database if exists `requests`; 
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
