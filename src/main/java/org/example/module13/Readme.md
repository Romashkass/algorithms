

test
1. c
2. c
3. c
4. c
5. b
6. b
7. d
8. c
9. c
10. b
11. a
12. d
13. c
14. a
15. b

questions
1. SQL - язык структурированных запросов, используется для работы с данными в бд.
2. SQL - язык структурированных запросов. Structured Query Language
3. select
4. create table <name> ( <column_name> <type>, ...)
5. delete from <table_name> where ...
6. insert into <table_name> (column1, ...) values (val1, ...)
7. order by
8. where ...
9. join
10. count(<column>)
11. скрыть повторы
12. update <table_name> set <column1> = <val1>, ... where ...
13. при создании таблицы 
    create table table_name (
        column1 type constraint, ...
    )
    или добавить в уже существующую alter table alter column column1 type constraint 
14. min() max() sum() avg() count()
15. результат из подзапроса можно использовать во внешнем запросе, например 
select product_name from products where product_price > (select avg(product_price) from products);
выбираем продукты у которых цена выше общей средней цены
