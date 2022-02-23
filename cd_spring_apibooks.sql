Create database cd_spring_apibooks;
Use cd_spring_apibooks;

Create table books (
	id int primary key auto_increment,
	title text not null,
	description text not null,
	language text not null,
	numberOfPages int not null,
	createdAt Datetime,
	updatedAt Datetime
);