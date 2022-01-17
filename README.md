# DemoCrypto
Test Task


Read me


  before launch,
create schema in MySQL WorkBench,
create a table in the schema:
-- auto-generated definition
create table crypto_currency
(
     id int auto_increment
         primary key
     create_date datetime(6) null,
     crypto_currency_name varchar(255) null,
     last_price varchar(255) null
);


P.S:

in the CurrencyPuller class, the base is parsed every second,
 this time can be adjusted in the annotation @Scheduled(fixedRate = 1000);

it took me two days to complete the task, because after that, 
I worked all the time, I didn’t have time to test everything,
 but I hope that the code is working, 
I’m not very sure if I wrote the Query correctly in the CryptoCurrencyRepository interface