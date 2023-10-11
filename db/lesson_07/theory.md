**Примеры запросов**

```jsx
// Вывести ко-во незаблокированных юзеров
db.users.aggregate([
    { $match: { is_blocked: { $ne: true } } },
    { $count: 'unblocked_users' }
])

// Вывести баланс и имя юзера 1
db.users.aggregate([
    { $match: { _id: 1 } },
    { $project: { fullname: 1, balance: 1, _id: 0 } }
])

// Вывести юзера, который находится на втором месте по балансу
db.users.aggregate([
    { $sort: { balance: -1 } },
    { $skip: 1 },
    { $limit: 1 }
])

// Вывести название и продолжительность трека, который находится на третьем месте по продолжительности
db.tracks.aggregate([
    { $sort: { duration_secs: -1 } },
    { $skip: 2 },
    { $limit: 1 },
    { $project: { title: 1, duration_secs: 1, _id: 0 } }
])

// Вывести имя одного произвольного незаблокированного юзера
db.users.aggregate([
    { $match: { is_blocked: { $ne: true } } },
    { $sample: { size: 1 } },
    { $project: { fullname: 1, _id: 0 } }
])

//  Вывести треки, включая данные об их авторах
db.tracks.aggregate([
    {
        $lookup: {
            from: 'users',
            localField: 'author_id',
            foreignField: '_id',
            as: 'author'
        }
    }
])
```

## Группировка / оператор `$group`

- получает на входе документы
- объединяет их в группы по заданному **полю (или полям)** группировки
- на выходе - один документ равен одному уникальному значению **поля группировки**

**Базовые операторы группировки (аккумуляторы)**

- `$sum`
- `$avg`
- `$min`
- `$max`
- `$count`

**Пример. Количественное распределение юзеров по странам**

```jsx
db.users.aggregate([
    {
        $group: {
            _id: '$country', // поле группировки
            total_users: { $count: {} },
            avg_balance: { $avg: '$balance' }
        }
    }
])
```

**Пример. Вывести среднюю продолжительность треков по каждому автору**

```jsx
db.tracks.aggregate([
    {
        $group: {
            _id: '$author_id',
            avg_duration: { $avg: '$duration_secs' }
        }
    }
])
```

**Пример. Вывести среднюю продолжительность всех треков**

```jsx
db.tracks.aggregate([
    {
        $group: {
            _id: null,
            avg_duration: { $avg: '$duration_secs' }
        }
    }
])
```

**Задача. Вывести статистику по трекам (по продолжительности)**

```jsx
db.tracks.aggregate([
    {
        $group: {
            _id: null,
            avg_duration: { $avg: '$duration_secs' },
            min_duration: { $min: '$duration_secs' },
            max_duration: { $max: '$duration_secs' },
            total_duration: { $sum: '$duration_secs' },
            total_tracks: { $count: {} }
        }
    }
])
```

**Задача. Вывести одного автора треков, у которого самая высокая средняя продолжительность**

```jsx
db.tracks.aggregate([
    {
        $group: {
            _id: '$author_id',
            avg_duration: { $avg: '$duration_secs' }
        }
    },
    { $sort: { avg_duration: -1 } },
    { $limit: 1 }
])
```

**Задача. Вывести одного автора треков, у которого самая высокая средняя продолжительность, включая имя автора**

```jsx
db.tracks.aggregate([
    {
        $group: {
            _id: '$author_id',
            avg_duration: { $avg: '$duration_secs' }
        }
    },
    { $sort: { avg_duration: -1 } },
    { $limit: 1 },
    {
        $lookup: {
            from: 'users',
            localField: '_id',
            foreignField: '_id',
            as: 'author'
        }
    }
])
```

## Оператор `$unwind`

- позволяет “развернуть” массив (отказаться от массива)

```jsx
db.tracks.aggregate([
    {
        $group: {
            _id: '$author_id',
            avg_duration: { $avg: '$duration_secs' }
        }
    },
    { $sort: { avg_duration: -1 } },
    { $limit: 1 },
    {
        $lookup: {
            from: 'users',
            localField: '_id',
            foreignField: '_id',
            as: 'author'
        }
    },
    **{ $unwind: '$author' },**
    {
        $project: {
            _id: 0,
            avg_duration: 1,
            author_fullname: '$author.fullname'
        }
    }
])
```

**Пример. Добавить несколько реакций (на треки)**

```jsx
db.reactions.insertMany([
    { track_id: 1, author_id: 1, value: 5 },
    { track_id: 2, author_id: 2, value: 2 },
    { track_id: 3, author_id: 3, value: 1 },
    { track_id: 4, author_id: 4, value: 5 },
    { track_id: 5, author_id: 5, value: 3 },
    { track_id: 2, author_id: 1, value: 5 },
    { track_id: 2, author_id: 1, value: 4 },
    { track_id: 4, author_id: 2, value: 4 },
    { track_id: 4, author_id: 4, value: 2 },
    { track_id: 1, author_id: 4, value: 3 },
    { track_id: 1, author_id: 3, value: 3 }
])
```

**Задача. Вывести самый рейтинговый трек**

(проекция: `название_трека`, `ср/оценка`)

```jsx
db.reactions.aggregate([
    {
        $group: {
            _id: '$track_id',
            rating: { $avg: '$value' }
        }
    },
    { $sort: { rating: -1 } },
    { $limit: 1 },
    {
        $lookup: {
            from: 'tracks',
            localField: '_id',
            foreignField: '_id',
            as: 'track'
        }
    },
    { $unwind: '$track' },
    {
        $project: {
            _id: 0,
            rating: 1,
            track_title: '$track.title'
        }
    }
])
```

**Задача. Вывести страну, в которой самые высокие реакции на треки**

(проекция: `страна`, `ср_оценка`)

```jsx
db.reactions.aggregate([
    {
        $lookup: {
            from: 'users',
            localField: 'author_id',
            foreignField: '_id',
            as: 'user'
        }
    },
    {
        $unwind: '$user'
    },
    {
        $group: {
            _id: '$user.country',
            avg_rating: { $avg: '$value' }
        }
    },
    {
        $sort: { avg_rating: -1 }
    },
    {
        $limit: 1
    },
    {
        $project: {
            country: '$_id',
            avg_rating: '$avg_rating',
            _id: 0
        }
    }
])
```

## Повторение `SQL`

**Задача. Вывести страны поставщиков**

```sql
SELECT DISTINCT
	Country
FROM Suppliers
```

**Задача. Вывести имена клиентов из `Germany` и `France`**

```sql
SELECT 
	CustomerName
FROM Customers

WHERE
	Country IN ('Germany', 'France')
```

**Задача. Вывести товары с ценой от `10` до `150` EUR**

```sql
SELECT * 
FROM Products

WHERE
	Price BETWEEN 10 AND 150
```

**Задача. Вывести два самых дорогих товара из категории `4`**

```sql
SELECT *
FROM Products

WHERE
    CategoryID = 4

ORDER BY Price DESC
LIMIT 2
```

**Задача. Вывести ко-во товаров из категории `4`**

```sql
SELECT 
	COUNT(*) AS total_products
FROM Products

WHERE
	CategoryID = 4
```

**Задача. Очистить телефоны у компаний-перевозчиков**

```sql
UPDATE Shippers
SET
	Phone=''
```

**Задача. Вывести среднюю стоимость товара для каждого поставщика**

```sql
SELECT
		SupplierID,
    AVG(Price)
FROM Products

GROUP BY SupplierID
```

d