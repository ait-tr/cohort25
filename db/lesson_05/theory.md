## MongoDB GUI Client

[The Ultimate Client, IDE and GUI for MongoDB | Studio 3T](https://studio3t.com/)

## `URI` для подключения

```jsx
mongodb+srv://ab:Os9yUOqHKfxhKO0M@cluster0.u54vil2.mongodb.net/admin?retryWrites=true&replicaSet=atlas-qut493-shard-0&readPreference=primary&srvServiceName=mongodb&connectTimeoutMS=10000&authSource=admin&authMechanism=SCRAM-SHA-1&3t.uriVersion=3&3t.connection.name=atlas-qut493-shard-0&3t.databases=admin&3t.alwaysShowAuthDB=true&3t.alwaysShowDBFromUserRole=true&3t.sslTlsVersion=TLS
```

**Задача (Д/З). Вывести ТОП-3 стран по количеству доставленных заказов**

```sql
SELECT
    Customers.Country,
    count(*) as amount_orders
FROM [Orders]

join Customers on Orders.CustomerID = Customers.CustomerID

group by Customers.Country

order by amount_orders desc
limit 3
```

## Принципиальные отличия MongoDB от RDBMS

1. Другой язык для выполнения запросов (`NoSQL - QUERY API`)
2. Модель данных - **ДОКУМЕНТНАЯ** (документ - ассоц/массив)
3. Динамическая схема данных (без схемы, `schemaless`) - каждый документ может иметь свой набор полей
4. Использует `JSON` и Binary `JSON` (`BSON`)
5. Позволяет хранить вложенные структуры данных

```jsx
// пример
users = [
	{username: 'hacker', email: '123@example.org', is_blocked: true},
	{username: 'user1', email: 'hello@example.org', phone: '+0000000000'}
]
```

## Базовые структуры данных

1. Скаляр (скалярное значение)
2. Массив (список значений)
3. Ассоц/массив (пары ключ/значение)
4. Множество (список **уникальных** элементов)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/95d3eea4-bdd9-4866-805a-55b03d066b78/ba525cc6-3d5d-4a67-ba58-a8263829b422/Untitled.png)

## Категории запросов

1. `CRUD` - более простые запросы
2. Aggregation - получение вычисленных данных

## MongoDB: CRUD

**Create**

- `insertOne()` добавить один документ
    - один аргумент
        - ассоц/массив (объект)
- `insertMany()` добавить несколько документов
    - один аргумент
        - массив ассоц/массивов

**Read**

- `findOne()`  найти (выбрать) один документ
- `find()` найти (выбрать) несколько документов
    - аргументы
        - `filter`
        - `projection`
- `countDocuments()` ко-во совпадений
    - аргументы
        - `filter`

**Update**

- `updateOne()` изменить один документ
- `updateMany()` изменить несколько документов
    - аргументы
        - `filter`
        - `action`

**Delete**

- `deleteOne()` удалить один документ
- `deleteMany()` удалить несколько документов
    - аргументы
        - `filter`

![Screenshot from 2023-09-29 12-31-13.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/95d3eea4-bdd9-4866-805a-55b03d066b78/9b3d2b21-671b-4d1b-ac00-1236ac0ae325/Screenshot_from_2023-09-29_12-31-13.png)

## БД `music` сервис онлайн-прослушивания музыльных треков

**Основые сущности**

- `users`
- `tracks`
- `playlists`

**Пример. Добавление юзеров**

```jsx
db.users.insertMany([
    { _id: 1, fullname: 'Ivan Ivanov', country: 'Germany' },
    { _id: 2, fullname: 'Petr Ivanov', country: 'USA' },
    { _id: 3, fullname: 'Sidr Ivanov', country: 'Germany' },
    { _id: 4, fullname: 'hacker', country: 'USA' },
    { _id: 5, fullname: 'noname', country: 'France' }
])
```

**Пример. Вывести всех юзеров**

```jsx
db.users.find()
```

**Пример. Вывести юзеров из `USA`**

```jsx
db.users.find(
    { country: 'USA' } // filter
)

// с проекцией
db.users.find(
    { country: 'USA' }, // filter
    { fullname: 1, _id: 0 } // projection
)

// с проекцией
db.users.find(
    { country: 'USA' }, // filter
    { country: 0 } // projection
)
```

**Задача. Вывести имена юзеров из `Germany`**

```jsx
db.users.find(
    { country: 'Germany' }, // filter
    { fullname: 1, _id: 0 } // projection
)
```

**Задача. Вывести страну юзера `1`**

```jsx
db.users.findOne(
    { _id: 1 },
    { country: 1, _id: 0 }
)
```

**Задача. Добавить пять треков (`tracks`)**

```jsx
db.tracks.insertMany([
    { _id: 1, title: 'Track 1', duration_secs: 5 * 60, author_id: 1 },
    { _id: 2, title: 'Track 2', duration_secs: 4 * 60, author_id: 2 },
    { _id: 3, title: 'Track 3', duration_secs: 6 * 60, author_id: 3 },
    { _id: 4, title: 'Track 4', duration_secs: 7 * 60, author_id: 4 },
    { _id: 5, title: 'Track 5', duration_secs: 9 * 60, author_id: 5 }
])
```

**Задача. Вывести название и продолжительность трека `4`**

```jsx
db.tracks.findOne(
    { _id: 4 }, // filter
    { title: 1, duration_secs: 1, _id: 0 } // projection
)
```

**Задача. Вывести названия всех треков**

```jsx
db.tracks.find(
    {}, // filter
    { title: 1, _id: 0 }
)
```

**Задача. Вывести треки юзера `2` (кроме поля `author_id`)**

```jsx
db.tracks.find(
    { author_id: 2 },
    { author_id: 0, _id: 0 }
)
```

## Операторы сравнения

`$eq` равно (equal)

`$ne` не равно (not equal)

`$gt` больше (greater than)

`$gte` больше или равно (greater than or equal)

`$lt` меньше (less than)

`$lte` меньше или равно (less than or equal)

`$in` проверка принадлежности к списку значений

`$nin` не принадлежит списку значений

**Пример. Вывести треки с продолжительностью от `5` мин**

```jsx
db.tracks.find(
    { duration_secs: { $gte: 5 * 60 } }
)
```

**Задача. Вывести треки продолжительностью до одного часа (включительно)**

(проекция: `название_трека`, `продолжительность_трека`)

```jsx
db.tracks.find(
    { duration_secs: { $lte: 60 * 60 } },
    { title: 1, duration_secs: 1, _id: 0 }
)
```

**Задача. Вывести треки продолжительностью от `2` до `10` мин**

```jsx
db.tracks.find(
    { duration_secs: { $gte: 2 * 60, $lte: 10 * 60 } }
)
```

## Базовые операторы модификации (`updateOne` / `updateMany()`)

`$set` установить поля

`$unset` удалить (снять) поля

`$inc` инкремент полей (увеличить/уменьшить)

`$mul` умножение

**Пример. Заблокировать юзеров из `France`**

```jsx
db.users.updateMany(
    { country: 'France' }, // filter
    { $set: { is_blocked: true } } // action
)
```

**Задача. Вывести имена всех заблокированных юзеров**

```jsx
db.users.find(
    { is_blocked: true },
    { fullname: 1, _id: 0 }
)
```

**Пример. Вывести незаблокированных юзеров**

```jsx
db.users.find(
    { is_blocked: { $ne: true } }
)
```

**Задача. Вывести всех незаблокированных юзеров не из `Germany`**

```jsx
db.users.find(
    {
        is_blocked: { $ne: true },
        country: { $ne: 'Germany' }
    }
)
```

**Пример. Разблокировать всех юзеров**

```jsx
db.users.updateMany(
    {},
    { $unset: { is_blocked: null } }
)
```

**Пример. Увеличить баланс юзерам из `USA` на `100` (EUR)**

```jsx
db.users.updateMany(
    { country: 'USA' },
    { $inc: { balance: 100 } }
)
```

**Задача. Уменьшить баланс юзеров из `USA` на `20` EUR**

```jsx
db.users.updateMany(
    { country: 'USA' },
    { $inc: { balance: -20 } }
)
```

**Пример. Использование оператора `$in`**

```jsx
db.users.find(
    {
        country: { $in: ['USA', 'Germany'] }
    }
)
```