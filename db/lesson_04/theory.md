**Задача. Вывести ко-во поставщиков не из `UK` и не из `China`**

```sql
SELECT
	COUNT(*) AS total_not_usa_spain_suppliers
FROM Suppliers

WHERE
	NOT Country IN ('UK', 'China')
```

**Задача. Вывести `среднюю/MAX/MIN стоимости и ко-во` товаров из категорий `3` и `5`**

```sql
SELECT
    AVG(Price) AS avg_price,
		MAX(Price) AS max_price,
    MIN(Price) AS min_price,
		COUNT(*) AS total_products
FROM Products

WHERE
	CategoryID IN (3, 5)
```

**Задача. Вывести общую сумму проданных товаров**

```sql
SELECT
 SUM(Products.Price * OrderDetails.Quantity) AS total_order_cost
FROM OrderDetails

JOIN Products ON OrderDetails.ProductID=Products.ProductID
```

**Задача. Вывести ко-во стран, которые поставляют напитки**

```sql
SELECT
	COUNT(DISTINCT Suppliers.Country) AS count_country
FROM Products

JOIN Categories ON Products.CategoryID=Categories.CategoryID
JOIN Suppliers ON Products.SupplierID=Suppliers.SupplierID

WHERE
 Categories.CategoryName = 'Beverages'
```

**Задача. Вывести сумму, на которую было отправлено товаров клиентам в `Germany`**

```sql
SELECT
	SUM(Products.Price * OrderDetails.Quantity) AS total_sum
FROM OrderDetails

JOIN Products ON OrderDetails.ProductID = Products.ProductID
JOIN Orders ON OrderDetails.OrderID = Orders.OrderID
JOIN Customers ON Orders.CustomerID = Customers.CustomerID

WHERE
    Customers.Country = 'Germany'
```

**Задача. Вывести ко-во товаров в заказе `10248` (по именованиям)**

```sql
SELECT
	COUNT(*) AS total_products
FROM OrderDetails

WHERE
	OrderID=10248
```

## **Группировка в SQL (механизм агрегации) / оператор `GROUP BY`**

**Категории запросов**

1. **CRUD** - простые запросы
2. **Aggregation** - получение вычисленных данных

**Пример. Вывести страны покупателей**

```sql
SELECT DISTINCT
	Country
FROM Customers

-- вывести кол/распределение клиентов по странам
SELECT
		Country,
    COUNT(*) AS total_customers
FROM Customers

GROUP BY Country

ORDER BY total_customers DESC
```

**Пример. Найти кол/распределение товаров по категориям**

```sql
SELECT
		CategoryID,
    COUNT(*) AS total_products
FROM Products

GROUP BY CategoryID

ORDER BY total_products DESC
```

**Задача. Вывести кол/распределение товаров по поставщикам**

```sql
SELECT
		SupplierID,
    COUNT(*) AS total_products
FROM Products

GROUP BY SupplierID

ORDER BY total_products DESC
```

**Задача. Вывести кол/распределение товаров по поставщикам**

(проекция: `название_поставщика`, `ко-во_поставленных_товаров`)

```sql
SELECT
		Suppliers.SupplierName,
    COUNT(*) AS total_products
FROM Products

JOIN Suppliers ON Products.SupplierID=Suppliers.SupplierID

GROUP BY Suppliers.SupplierID

ORDER BY total_products DESC
```

**Задача. Вывести кол/распределение заказов по клиентам**

(проекция: `имя_клиента`, `ко-во_заказов`)

```sql
SELECT
		Customers.CustomerName,
    COUNT(*) AS total_orders
FROM Orders

JOIN Customers ON Orders.CustomerID=Customers.CustomerID

GROUP BY Customers.CustomerID

ORDER BY total_orders DESC
```

**Задача. Вывести ТОП-1 компанию-перевозчика (и ко-во заказов) по количеству доставок**

```sql
SELECT
		Shippers.ShipperName,
    COUNT(*) AS total_orders
FROM Orders

JOIN Shippers ON Orders.ShipperID=Shippers.ShipperID

GROUP BY Orders.ShipperID

ORDER BY total_orders DESC
LIMIT 1
```

**Задача. Вывести ТОП-3 самых продаваемых товаров**

(проекция: `название_товара`, `ко_во_проданных_единиц`)

```sql
SELECT
	Products.ProductName,
	SUM(OrderDetails.Quantity) AS sold_count
	
FROM OrderDetails

JOIN Products ON OrderDetails.ProductID=Products.ProductID

GROUP BY OrderDetails.ProductID

ORDER BY sold_count DESC
LIMIT 3
```

**Задача. Вывести стоимость каждого заказа в упорядоченном виде**

(проекция: `номер_заказа`, `сумма_заказа`)

```sql
SELECT
		OrderDetails.OrderID,
    SUM(OrderDetails.Quantity * Products.Price) AS order_cost

FROM OrderDetails

JOIN Products ON OrderDetails.ProductID=Products.ProductID

GROUP BY OrderDetails.OrderID

ORDER BY order_cost DESC
```

## Оператор `HAVING`

- аналог `WHERE`, который позволяет отфильтровать агрегированные данные

**Пример. Вывести заказы со стоимостью от `10000` (EUR)**

```sql
SELECT
		OrderDetails.OrderID,
    SUM(OrderDetails.Quantity * Products.Price) AS order_cost

FROM OrderDetails

JOIN Products ON OrderDetails.ProductID=Products.ProductID

GROUP BY OrderDetails.OrderID
HAVING
	order_cost >= 10000

ORDER BY order_cost DESC
```

**Задача. Вывести страны, в которые было отправлено `3` и более заказов**

(проекция: `страна`, `ко-во заказов`)

```sql
SELECT
		Customers.Country,
    COUNT(*) AS total_orders
FROM Orders

JOIN Customers ON Orders.CustomerID=Customers.CustomerID

GROUP BY Customers.Country
HAVING
	total_orders >= 3

ORDER BY total_orders DESC
```

**Задача. Вывести поставщиков, у которых средняя стоимость товара выше `40` EUR**

(проекция: `название_поставщика`, `сред_стоимость`)

```sql
SELECT 
		Suppliers.SupplierName,
		AVG(Products.Price) AS avg_price
FROM Products

JOIN Suppliers ON Products.SupplierID = Suppliers.SupplierID

GROUP BY Suppliers.SupplierID
HAVING
	avg_price > 40

ORDER BY avg_price DESC
```

## [Базовые виды (типы) связей между сущностями](https://github.com/ait-tr/cohort25/blob/main/db/lesson_03/theory.md#%D0%B1%D0%B0%D0%B7%D0%BE%D0%B2%D1%8B%D0%B5-%D0%B2%D0%B8%D0%B4%D1%8B-%D1%82%D0%B8%D0%BF%D1%8B-%D1%81%D0%B2%D1%8F%D0%B7%D0%B5%D0%B9-%D0%BC%D0%B5%D0%B6%D0%B4%D1%83-%D1%81%D1%83%D1%89%D0%BD%D0%BE%D1%81%D1%82%D1%8F%D0%BC%D0%B8)

- `1:1` (один к одному)
- `1:M` (один ко многим)
- `M:M` (многие ко многим)

**Связи между таблицами**

- `Orders.CustomerID (M:1) Customers.CustomerID`
- `Orders.OrderID (1:M) OrderDetails.OrderID`
- `Orders.EmployeeID (M:1) Employees.EmployeeID`
- `Orders.ShipperID (M:1) Shippers.ShipperID`
- `OrderDetails.ProductID (M:1) Products.ProductID`
- `Products.SupplierID (M:1) Suppliers.SupplierID`
- `Products.CategoryID (M:1) Categories.CategoryID`

## Ссылки

- [пример схемы онлайн-школа](https://dbdiagram.io/d/6502bef502bd1c4a5e8e1b33)
- [хеширование паролей](https://www.kaspersky.ru/blog/the-wonders-of-hashing/3633/)