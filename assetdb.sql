create database assetdb;
use assetdb;

create table User(
Userid varchar(10) primary key NOT NULL,
Username varchar(50) NOT NULL,
Role varchar(10) NOT NULL,
Telephone bigint NOT NULL,
Email varchar(50)NOT NULL,
Password varchar(20)NOT NULL,
IsBanned boolean
);

create table Asset(
	UniqueId bigint NOT NULL,
    AssetName varchar(30) NOT NULL,
    AssetType varchar(20) NOT NULL,
    Description varchar(50),
	DateAdded Date NOT NULL,
	IsAvailable boolean NOT NULL,
    LendingPeriod int NOT NULL,
    LateReturnFee double NOT NULL,
    NoOfDaysBanned int NOT NULL,
    DueDate Date NULL
);

