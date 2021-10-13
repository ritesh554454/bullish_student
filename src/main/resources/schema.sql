create table students(
	id integer not null,
	firstName varchar(255) not null,
	lastName varchar(255),
	className varchar(10),
	nationality varchar(100),
	primary key(id)
);

insert into students(id, firstName, lastName, className, nationality)
values(1, 'Student1', 'StudentLastName1', '1 A', 'UAE');
insert into students(id, firstName, lastName, className, nationality)
values(2, 'Student2',  'StudentLastName2', '2 A', 'UK');
insert into students(id, firstName, lastName, className, nationality)
values(3, 'Student3',  'StudentLastName3', '3 A', 'UK');
insert into students(id, firstName, lastName, className, nationality)
values(4, 'Student4',  'StudentLastName4', '4 A', 'UAE');
insert into students(id, firstName, lastName, className, nationality)
values(5, 'Student5',  'StudentLastName5', '5 A', 'UK');
insert into students(id, firstName, lastName, className, nationality)
values(6, 'Student6',  'StudentLastName6', '3 A', 'UAE');
insert into students(id, firstName, lastName, className, nationality)
values(7, 'Student7',  'StudentLastName7', '3 A', 'UK');
insert into students(id, firstName, lastName, className, nationality)
values(8, 'Student8',  'StudentLastName8', '2A', 'UAE');
insert into students(id, firstName, lastName, className, nationality)
values(9, 'Student9',  'StudentLastName9', '4A', 'UAE');
insert into students(id, firstName, lastName, className, nationality)
values(10, 'Student10',  'StudentLastName10', '4A', 'UAE');