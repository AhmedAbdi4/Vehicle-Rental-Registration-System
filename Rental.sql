
DROP TABLE rental;
DROP TABLE customer;


CREATE TABLE customer (
   customerID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
   name varchar (20) NOT NULL,
   street varchar (30) NOT NULL,
   city varchar (30) NOT NULL,
   state varchar (30) NOT NULL,
   zip varchar (30) NOT NULL,
   creditcard varchar (30) NOT NULL,
   phonenumber varchar (30) NOT NULL,
   PRIMARY KEY (customerID)
);

CREATE TABLE rental (
   rentalID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
   customername varchar (20) NOT NULL,
   priceperday varchar (30) NOT NULL,
   numberofdays varchar (30) NOT NULL,
   numberofmiles varchar (30) NOT NULL,
   cartype varchar (30) NOT NULL,
   PRIMARY KEY (rentalID)
);