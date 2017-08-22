INSERT INTO BOOK (ID, TITLE) VALUES (null, 'book-4');
SET @book1 = LAST_INSERT_ID();
INSERT INTO BOOK (ID, TITLE) VALUES (null, 'book-5');
SET @book2 = LAST_INSERT_ID();

insert into CUSTOMER (ID, FIRSTNAME, LASTNAME) values (null, 'Kasper', 'Breindal');
set @customer1 = LAST_INSERT_ID();
insert into CUSTOMER (ID, FIRSTNAME, LASTNAME) values (null, 'Mathias', 'Jensen')
set @customer2= LAST_INSERT_ID();
insert into CUSTOMER (ID, FIRSTNAME, LASTNAME) values (null, 'Emil', 'Due')
set @customer3 = LAST_INSERT_ID();