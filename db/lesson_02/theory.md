## SQL - файл

Текстовый файл с SQL-запросами

```sql
-- homework.sql
-- Задача 1. Вывести ..
SELECT *
FROM Customers;
```

**Задача. Вывести номер и дату предпоследнего заказа**

```sql
SELECT
		OrderID,
    OrderDate
FROM Orders

ORDER BY OrderDate DESC
LIMIT 1 OFFSET 1
```

**Задача. Вывести три самых дешевых товара из категории `4` с ценой до `500` EUR**

```sql
SELECT *
FROM Products

WHERE
		CategoryID=4
    AND
    Price<=500

ORDER BY Price ASC
LIMIT 3
```

## Псевдонимы в SQL / Оператор `AS`

```sql
SELECT
		ProductName,
    Price AS Price_eur,
    Price * 1.1 AS Price_usd
FROM Products
```

```sql
SELECT *,
    Price * 1.1 AS Price_usd
FROM Products
```

```sql
SELECT *,
    Price * .95 AS Price_down
FROM Products
```

**Задача. Вывести названия товаров, а также их стоимость:**

- полную
- со скидкой в `25%`
- с наценкой в `15%`

```sql
SELECT
		ProductName,
    Price AS Price_full,
    Price * .75 AS Price_low,
    Price * 1.15 AS Price_up
FROM Products
```

**Задача. Вывести название и стоимость со скидкой в `0.5%` товаров с ценой от `25` до `150` EUR**

```sql
SELECT 
	ProductName,
	Price * .995 AS Price_down
FROM Products

WHERE
	Price_down BETWEEN 25 AND 150
```

## SQL: CRUD

- **Create**
    - `INSERT INTO`
- **Read**
    - `SELECT`
    - `SELECT DISTINCT`
- **Update**
    - `UPDATE`
- **Delete**
    - `DELETE FROM`

![Screenshot from 2023-09-08 12-48-57.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/95d3eea4-bdd9-4866-805a-55b03d066b78/ed01821f-3360-46ac-b837-a25cef04f9dd/Screenshot_from_2023-09-08_12-48-57.png)

## Поиск по шаблону / Оператор `LIKE`

- поиск по нестрогому соответствию

**Базовые подстановочные символы (знаки)**

- `%` нулевой, один или несколько символов
- `_` один символ

```sql
SELECT *
FROM Customers
WHERE
	Country LIKE 'usa'
```

```sql
SELECT *
FROM Suppliers
WHERE
	Phone LIKE '%555%'
```

```sql
SELECT *
FROM Customers
WHERE
	CustomerName LIKE '%alf%'
```

**Задача. Вывести имена и фамилии сотрудников, у которых в имени или фамилии есть вхождение строки `lio`**

```sql
SELECT
		FirstName,
    LastName
FROM Employees

WHERE
		FirstName LIKE '%lio%'
    OR
    LastName LIKE '%lio%'
```

## SQL CRUD: Delete / удаление записей / Оператор `DELETE FROM`

**Пример. Удалить указанных клиентов**

```sql
DELETE FROM Customers
WHERE
	CustomerID IN (1, 3)
```

**Задача. Удалить товары, которые дешевле `5` EUR**

```sql
DELETE FROM Products
WHERE
	Price < 5
```

## SQL CRUD: Update / модификация / Оператор `UPDATE`

**Пример**

```sql

-- очистить указанные поля у клиента 1
UPDATE Customers
SET
		CustomerName='',
    ContactName=''
WHERE
	CustomerID=1
```

**Задача. Для поставщиков из `Japan` и `Spain` изменить телефон и контактное имя на произвольные значения**

```sql
UPDATE Suppliers
SET
	ContactName='Ivan Ivanov',
	Phone='0000000000'
WHERE
	Country IN ('Japan', 'Spain')
```

**Задача. У всех товаров от `50` до `60` (EUR) очистить `название` и установить `категорию 2`**

```sql
UPDATE Products
SET
		ProductName='',
	  CategoryID=2
WHERE
	Price BETWEEN 50 AND 60
```

## SQL CRUD: Create / добавление / Оператор `INSERT INTO`

**Пример**

```sql
-- добавить двух перевозчиков
INSERT INTO Shippers (ShipperName, Phone)
VALUES
		('Shipper X', '+00000000000'),
    ('Shipper Y', '+11111111111')
```

**Задача. Добавить произвольного поставщика из `China`**

```sql
INSERT INTO Suppliers (SupplierName, ContactName, Address, City, PostalCode, Country, Phone)
VALUES 
	('XYZ Company', NULL, NULL, NULL, NULL, 'China', NULL);
```

## Ключевые поля

- первичный ключ (`PRIMARY KEY`)
- внешний ключ (`FOREIGN KEY`)

## Горизонтальное объединение таблиц / Оператор `JOIN`

- синтаксис `JOIN`

```sql
SELECT <проекция>
FROM <таблица_1>
JOIN <таблица_2> ON <таблица_1.внешний_ключ>=<таблица_2.первичный_ключ>
```

**Пример**

```sql
SELECT *
FROM Products
JOIN Suppliers ON Products.SupplierID=Suppliers.SupplierID
```

```sql
SELECT
		Products.ProductName,
    Products.Price,
    Suppliers.SupplierName
FROM Products

JOIN Suppliers ON Products.SupplierID=Suppliers.SupplierID
```

```sql
SELECT *
FROM Orders

JOIN Customers ON Orders.CustomerID=Customers.CustomerID
JOIN Employees ON Orders.EmployeeID=Employees.EmployeeID
JOIN Shippers ON Orders.ShipperID=Shippers.ShipperID
```

**Задача. Вывести данные о заказах клиентов из `Germany`**

```sql
SELECT *
FROM Orders

JOIN Customers ON Orders.CustomerID=Customers.CustomerID

WHERE
	Customers.Country='Germany'
```

**Задача. Вывести данные о товарах**
(проекция: `название_товара`, `цена_товара`, `название_категории`)

```sql
SELECT
    Products.ProductName,
    Products.Price,
    Categories.CategoryName
FROM Products

JOIN Categories ON Products.CategoryID=Categories.CategoryID
```

**Задача. Вывести все заказы, которые повезет `Speedy Express`**

```sql
SELECT * 
FROM Orders

JOIN Shippers ON Orders.ShipperID=Shippers.ShipperID
****
WHERE
	Shippers.ShipperName='Speedy Express'
```