CREATE TABLE Bill (
	b_id serial NOT NULL,
	discount integer,
	officiant integer NOT NULL,
	numTable integer NOT NULL,
	amount integer NOT NULL,
	payment integer NOT NULL,
	CONSTRAINT Bill_pk PRIMARY KEY (b_id)
);



CREATE TABLE Course (
	cour_id serial NOT NULL,
	nameCour varchar(20) NOT NULL,
	category integer NOT NULL,
	countryCour varchar(20) NOT NULL,
	cook integer NOT NULL,
	CONSTRAINT Course_pk PRIMARY KEY (cour_id)
);



CREATE TABLE Category (
	category_id serial NOT NULL,
	category varchar(10) NOT NULL,
	CONSTRAINT Category_pk PRIMARY KEY (category_id)
);



CREATE TABLE Officiant (
	off_id serial NOT NULL,
	nameOff varchar(20) NOT NULL,
	salaryOff integer NOT NULL,
	CONSTRAINT Officiant_pk PRIMARY KEY (off_id)
);



CREATE TABLE Payment (
	payment_id serial NOT NULL,
	typePay varchar(8) NOT NULL,
	CONSTRAINT Payment_pk PRIMARY KEY (payment_id)
);



CREATE TABLE Cook (
	cook_id serial NOT NULL,
	nameCook varchar(20) NOT NULL,
	salaryCook integer NOT NULL,
	CONSTRAINT Cook_pk PRIMARY KEY (cook_id)
);



CREATE TABLE Drink (
	drink_id serial NOT NULL,
	nameDr varchar(20) NOT NULL,
	typeDr varchar(10) NOT NULL,
	CONSTRAINT Drink_pk PRIMARY KEY (drink_id)
);



CREATE TABLE Drink_Bill (
	b_id integer NOT NULL,
	dr_id integer NOT NULL
);



CREATE TABLE Course_Bill (
	b_id integer NOT NULL,
	c_id integer NOT NULL
);



CREATE TABLE Discount (
	dis_id serial NOT NULL,
	discount integer NOT NULL,
	phoneCons varchar(15) NOT NULL,
	nameCons varchar(15) NOT NULL,
	CONSTRAINT Discount_pk PRIMARY KEY (dis_id)
);



ALTER TABLE Bill ADD CONSTRAINT Bill_fk0 FOREIGN KEY (discount) REFERENCES Discount(dis_id);
ALTER TABLE Bill ADD CONSTRAINT Bill_fk1 FOREIGN KEY (officiant) REFERENCES Officiant(off_id);
ALTER TABLE Bill ADD CONSTRAINT Bill_fk2 FOREIGN KEY (payment) REFERENCES Payment(payment_id);

ALTER TABLE Course ADD CONSTRAINT Course_fk0 FOREIGN KEY (category) REFERENCES Category(category_id);
ALTER TABLE Course ADD CONSTRAINT Course_fk1 FOREIGN KEY (cook) REFERENCES Cook(cook_id);







ALTER TABLE Drink_Bill ADD CONSTRAINT Drink_Bill_fk0 FOREIGN KEY (b_id) REFERENCES Bill(b_id);
ALTER TABLE Drink_Bill ADD CONSTRAINT Drink_Bill_fk1 FOREIGN KEY (dr_id) REFERENCES Drink(drink_id);

ALTER TABLE Course_Bill ADD CONSTRAINT Course_Bill_fk0 FOREIGN KEY (b_id) REFERENCES Bill(b_id);
ALTER TABLE Course_Bill ADD CONSTRAINT Course_Bill_fk1 FOREIGN KEY (c_id) REFERENCES Course(cour_id);












