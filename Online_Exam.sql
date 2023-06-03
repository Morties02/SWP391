create database SWProject
-------Drop DB--------
 USE master;
  GO
 ALTER DATABASE SWProject SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
  GO
  DROP DATABASE SWProject;
  GO
-------Create profile table--------
create table PROFILE(
ProfileId int primary key,
)
-------Create class table--------
create table CLASS(
ClassId int identity(1,1) primary key,
ClassName nvarchar(32),
LecturerId int,
)
insert into CLASS(LecturerId) values (1)
-------Create role table--------
create table Role(
RoleId int primary key,
Role varchar(32),
)
-------Create account table--------
create table ACCOUNT(
UserId int identity(1,1) primary key,
Username varchar(32) not null,
PWD varchar(16) not null,  
RoleId int references Role(RoleId),
ProfileId int references Profile(ProfileId)
)
-------Create StudentofClass table--------
create table StudentOfClass(
UserId int references ACCOUNT(UserID),
ClassId int references CLASS(ClassId) 
)
-------Create test table--------
create table Test(
TestId int identity(1,1) primary key,
ClassId int references CLASS(ClassId),
Name varchar(32),
EnrollKey varchar(32)
)
-------Create question table--------
create table Question(
QuestionId int identity(1,1) primary key,
Details nvarchar(max),
ImageUrl nvarchar(max),
Option1 nvarchar(max),
Option2 nvarchar(max),
Option3 nvarchar(max),
Option4 nvarchar(max),
Answer char check(Answer = 'A' or Answer = 'B' or Answer = 'C' or Answer ='D'),
)
-------Create QuestOfTest table--------
create table QuestionOfTest(
QuestionId int references Question(QuestionId),
TestId int references Test(TestId)
)
-------Create result table--------
create table RESULT(
ResultId int identity(1,1) primary key,
TestId int references Test(TestId),
AccountId int references ACCOUNT(UserId),
Score float,
)
-------Create answer table--------
create table Answer(
AnswerId int identity(1,1) primary key,
StudentId int references ACCOUNT(UserId),
Answer char check(Answer = 'A' or Answer = 'B' or Answer = 'C' or Answer ='D'),
TestId int references Test(TestId),
QuestionId int references Question(QuestionId),
Correctness char check (Correctness ='T' or Correctness ='F')
)
-------Stored Procedures--------
-------Insert role data--------
insert into Role(RoleId, Role) values(1, 'Admin');
insert into Role(RoleId, Role) values(2, 'Lecturer');
insert into Role(RoleId, Role) values(3, 'Student');
-------Insert Account data--------
insert into ACCOUNT(Username, PWD, RoleId) values ('Admin01', 'AdminPassword', 1);
insert into ACCOUNT(Username, PWD, RoleId) values ('Student01', 'StudentPassword', 3);
-------Select all question of a test--------
select Question.QuestionId, Question.Details, Question.ImageUrl, Question.Option1, Question.Option2, Question.Option3, Question.Option4, Question.Answer
 from (Question inner JOIN QuestionOfTest on Question.QuestionId = QuestionOfTest.QuestionId) where QuestionOfTest.TestId = 1
insert into CLASS(ClassName, LecturerId) values('MyClass', 1);
----