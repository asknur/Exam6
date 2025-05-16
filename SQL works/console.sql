create database cars;
create database continentsAndAttractions;
create database countries;

CREATE TABLE cars(
    id serial PRIMARY KEY,
    manufacturer VARCHAR(15) NOT NULL,
    fuel_type VARCHAR(15) NOT NULL
)

