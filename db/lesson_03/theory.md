## Повторение материала

### **CRUD**

- `Create Read Update Delete`

### Оператор `LIKE`

**Пример**

```sql
-- поиск по клиентам в части имени
SELECT *
FROM Customers
WHERE
	CustomerName LIKE '%alf%'
```

### Оператор `UPDATE`

**Пример**

```sql
UPDATE Customers
SET
		CustomerName='',
    ContactName=''
WHERE
	CustomerID=1

UPDATE Suppliers
SET
	ContactName='Ivan Ivanov',
	Phone='0000000000'
WHERE
	Country IN ('Japan', 'Spain')
```

### **Горизонтальное объединение таблиц / Оператор `JOIN`**

### Ключевые поля

- первичный ключ (`PRIMARY KEY`)
- внешний ключ (`FOREIGN KEY`)

**Пример**

```sql
SELECT *
FROM Orders

JOIN Customers ON Orders.CustomerID=Customers.CustomerID

WHERE
	Customers.Country='Germany'
```

**Задача. Вывести два самых дорогих товара из категории `Beverages` из `USA`**

```sql
SELECT *
FROM Products

JOIN Categories ON Products.CategoryID=Categories.CategoryID
JOIN Suppliers ON Products.SupplierID=Suppliers.SupplierID

WHERE
	Categories.CategoryName LIKE 'beverages'
	AND
	Suppliers.Country LIKE 'usa'

ORDER BY Products.Price DESC
LIMIT 2
```

**Задача. Вывести список стран, которые поставляют напитки**

```sql
SELECT DISTINCT
	Suppliers.Country

FROM Products

JOIN Suppliers ON Products.SupplierID=Suppliers.SupplierID
JOIN Categories ON Products.CategoryID=Categories.CategoryID

WHERE
	Categories.CategoryName LIKE 'beverages'
```

## Самая распространенная архитектура хранения данных

- ОДНА СУЩНОСТЬ (ОБЪЕКТ) == ОДНА ЗАПИСЬ

## Агрегация данных в SQL

**Базовые категории запросов**

1. **CRUD** - более простые запросы
2. **Aggregation** - получение вычисленных данных (итоги, статистика, аналитика)

**Базовые операторы агрегации**

- `COUNT()` расчет ко-ва строк
- `AVG()` расчет сред/ариф. знач.
- `MAX()` расчет макс. значения
- `MIN()` расчет мин. значения
- `SUM()` расчет суммы

**Примеры**

```sql
-- вывести ко-во клиентов из `Germany`
SELECT
	COUNT(*) AS total_germany_customers
FROM Customers

WHERE
	Country='Germany'

-- вывести ко-во всех клиентов
SELECT
	COUNT(*) AS total_germany_customers
FROM Customers
```

**Пример. найти среднюю стоимость товара**

```sql
SELECT
	AVG(Price) AS avg_price
FROM Products
```

**Пример. Вывести статистику по товарам**

```sql
SELECT
	AVG(Price) AS avg_price,
	MIN(Price) AS min_price,
	MAX(Price) AS max_price,
	COUNT(*) AS total_products,
	SUM(Price) as products_sum
FROM Products
```

**Задача. Вывести ко-во поставщиков из `USA`**

```sql
SELECT
	COUNT(*) AS usa_suppliers
FROM Suppliers

WHERE
	Country='USA'
```

**Задача. Вывести ко-во поставщиков из `USA, UK, Japan`**

```sql
SELECT
	COUNT(*) AS total_suppliers
FROM Suppliers

WHERE
	Country IN ('USA', 'UK', 'Japan')
```

**Задача. Вывести среднюю стоимость товаров с ценой до `150` EUR**

```sql
SELECT
	AVG(Price) AS avg_price
FROM Products

WHERE
	Price <= 150
```

**Задача. Вывести MAX-стоимость товаров с ценой от `20` до `200` EUR из категории `4`**

```sql
SELECT
	MAX(Price) AS max_price
FROM Products

WHERE
		Price BETWEEN 20 AND 200
    AND
    CategoryID=4
```

**Задача. Вывести сред/стоимость товаров из категорий `1, 2, 5`, у которых название (товаров) начинается с `t`**

```sql
SELECT
	AVG(Price) AS avg_price
FROM Products

WHERE
	CategoryID IN (1, 2, 5)
	AND
	ProductName LIKE 't%'
```

**Задача. Найти, сколько раз был продан (заказан) товар `11`**

```sql
SELECT
	COUNT(*) AS total_sold
FROM OrderDetails

WHERE
	ProductID=11
```

**Задача. Вывести `ко-во заказов`, которое оформил клиент `1`**

```sql
SELECT
	COUNT(*) AS total_orders
FROM Orders

WHERE
	CustomerID=1
```

**Задача. Вывести среднюю стоимость товаров от поставщика `4`**

(проекция: `название_поставщика`, `сред_стоимость_товаров`)

```sql
SELECT
	Suppliers.SupplierName,
	AVG(Products.Price) AS avg_price
    
FROM Products
JOIN Suppliers ON Products.SupplierID=Suppliers.SupplierID

WHERE
	Suppliers.SupplierID = 4
```

**Задача. Посчитать стоимость заказа `10248`**

```sql
SELECT
	SUM(Products.Price * OrderDetails.Quantity) AS order_cost
FROM OrderDetails

JOIN Products ON OrderDetails.ProductID=Products.ProductID

WHERE
	OrderDetails.OrderID=10248
```

**Задача. Вывести ко-во заказов, которое компания `Speedy Express` доставила в `Brazil`**

```sql
SELECT
	COUNT(*) AS total_shipped_to_brazil

FROM Orders

JOIN Shippers ON Orders.ShipperID=Shippers.ShipperID
JOIN Customers ON Orders.CustomerID=Customers.CustomerID

WHERE
		Shippers.ShipperName='Speedy Express'
    AND
    Customers.Country='Brazil'
```

**Задача. На какую сумму было отправлено товаров клиентам в `USA`**

```sql
SELECT
	SUM(Products.Price * OrderDetails.Quantity) AS total_sold_to_usa

FROM OrderDetails

JOIN Orders ON OrderDetails.OrderID=Orders.OrderID
JOIN Customers ON Orders.CustomerID=Customers.CustomerID
JOIN Products ON OrderDetails.ProductID=Products.ProductID

WHERE
	Customers.Country='USA'
```

## Проектирование БД

### Общие этапы проектирования БД

1. Анализ предметной области (бизнес-процессов)
2. Выделение сущностей и их свойств (характеристик)
3. Связывание сущностей между собой (установление связей)
    1. с помощью ключевых полей (`первичный` и `внешний` ключи)
4. Проверка решения (гипотезы)

### Общие тезисы

1. На одном сервере могут находиться **СУБД (DBMS)**
- **сетевой порт** - сетевой идентификатор процесса (программы)
1. В одной **СУБД** может находиться несколько **БД**
2. Стандартный подход: **ОДНА БД == ОДИН ПРОЕКТ**
3. Стандартный подход: **ОДНА СУЩНОСТЬ == ОДНА ЗАПИСЬ**
4. В одной **БД** может храниться несколько типов сущностей (объектов)

## Первичный ключ (primary key)

- Является идентификатором каждой сущности

**Свойства**

- уникальный
- неизменяемый
- ненулевой

**Стандартные подходы к определению значения**

1. Авто-инкремент
2. Случайные значения (`UUID`, `GUID`, `ULID`)

## Базовые виды (типы) связей между сущностями

- `1:1` (один к одному)
- `1:M` (один ко многим)
- `M:M` (многие ко многим)

## Схема БД “онлайн-магазин” песочница

**Связи между таблицами**

- `Orders.CustomerID (M:1) Customers.CustomerID`
- `Orders.OrderID (1:M) OrderDetails.OrderID`
- `Orders.EmployeeID (M:1) Employees.EmployeeID`
- `Orders.ShipperID (M:1) Shippers.ShipperID`
- `OrderDetails.ProductID (M:1) Products.ProductID`
- `Products.SupplierID (M:1) Suppliers.SupplierID`
- `Products.CategoryID (M:1) Categories.CategoryID`

## Основные типы данных в MySQL

- каждый столбец (поле) таблицы должен иметь указание на тип данных

### Числовые

- `int` / `integer`
- `float`

### Строковые

- `varchar(x)`
    - `x` - макс. ко-во символов
- `text(x)`
    - `x` - макс. ко-во символов

### Логические

- `bool`

### Дата / время

- `datetime`
- `**timestamp**`
- `date`
- `time`

## Схема БД “онлайн-шахматы”

**Сущности**

- `players`
- `matches`
    - `игрок1`
    - `игрок2`
    - `кто_выйграл`
- `chats`
- `messages`
    - `author_id`
    - `chat_id`
    - `content`
- `maps`

[Пример схемы онлайн-школа](https://dbdiagram.io/d/6502bef502bd1c4a5e8e1b33)