# DB #6 / Oct 4, 2023

![Screenshot from 2023-10-04 11-43-43.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/95d3eea4-bdd9-4866-805a-55b03d066b78/374f2e1c-e7e0-4dd2-8607-d2ada289a3ce/Screenshot_from_2023-10-04_11-43-43.png)

## Метод `countDocuments()`

- **возвращает ко-во совпадений (целое число)**
- аргументы
    - `filter`

**Пример. Вывести общее ко-во юзеров**

```jsx
db.users.countDocuments({})
```

**Пример. Вывести ко-во юзеров из `USA`**

```jsx
db.users.countDocuments(
    { country: 'USA' }
)
```

**Задача. Вывести ко-во незаблокированных юзеров не из `Germany`**

```jsx
db.users.countDocuments(
    {
        is_blocked: { $ne: true },
        country: { $ne: 'Germany' }
    }
)
```

**Пример. Аутентификация (авторизация) на веб-сайте**

```jsx
db.users.countDocuments(
    {
        email: email,
        password: password,
        is_blocked: { $ne: true }
    }
)
```

**Пример. Вывести названия треков продолжительностью от `1` до `10` мин**

```jsx
db.tracks.find(
    { duration_secs: { $gte: 1 * 60, $lte: 10 * 60 } },
    { title: 1, _id: 0 }
)
```

**Задача. Увеличить баланс всех незаблокированных юзеров не из `China` на `100` EUR**

```jsx
db.users.updateMany(
    {
        country: { $ne: 'China' },
        is_blocked: { $ne: true }
    },
    { $inc: { balance: 100 } }
)
```

**Задача. Вывести названия треков `3` и `4`**

```jsx
db.tracks.find(
    { _id: { $in: [3, 4] } }, // filter
    { title: 1, _id: 0 } // projection
)
```

## MongoDB Aggregation Framework

- позволяет получить вычисленные данные
- инструмент для анализа, обработки данных
- реализуется методом `aggregate()`
- представляет конвеер (`pipeline`), который содержит определенные этапы обработки (`stages`)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/95d3eea4-bdd9-4866-805a-55b03d066b78/9c67aeba-d6fc-4f51-a3de-ceddfdbcd0fa/Untitled.png)

## Метод `aggregate()`

- аргументы
    - (1) массив этапов обработки (`pipeline`, конвеер)

**Пример. Вывести все треки**

```jsx
db.tracks.aggregate()
```

## Основные стадии (этапы, stages) обработки - операторы

- `$match` фильтрация
- `$sort` сортировка
    - `-1` по убыванию
    - `1` по возрастанию
- `$project` проекция
- `$limit` лимитирование
- `$skip` пропустить (документы)
- `$group` группировка
- `$lookup` объединение коллекций
- `$addFields` добавить поля
- `$sample` получить произвольные документы
- `$count` возвращает ко-во документов

**Пример. Работа с юзерами**

```jsx
// вывести всех юзеров
db.users.aggregate()

// вывести юзеров с балансом от 100 (EUR)
db.users.aggregate([
    { // фильтрация
        $match: {
            balance: { $gte: 100 }
        }
    }
])

// вывести незаблокир. юзеров
db.users.aggregate([
    {
        $match: {
            is_blocked: { $ne: true }
        }
    }
])

// вывести всех юзеров по убыванию баланса
db.users.aggregate([
    {
        $sort: { balance: -1 }
    }
])

// вывести ТОП-3 юзеров по макс. балансу
db.users.aggregate([
    {
        $sort: { balance: -1 }
    },
    { $limit: 3 }
])
```

**Задача. Вывести одного незаблокированного юзера с минимальным балансом**

```jsx
db.users.aggregate([
    { $match: { is_blocked: { $ne: true } } }, // фильтрация
    { $sort: { balance: 1 } }, // сортировка (по возраст.)
    { $limit: 1 } // лимитирование
])
```

**Пример. Вывести ко-во незаблокированных юзеров**

```jsx
// вар. 1
db.users.countDocuments(
    { is_blocked: { $ne: true } } // filter
)

// вар. 2
db.users.aggregate([
    { $match: { is_blocked: { $ne: true } } },
    { $count: 'unblocked_users' }
])
```

**Пример. Вывести имена юзеров**

```jsx
db.users.aggregate([
    {
        $project: { fullname: 1, _id: 0 }
    }
])
```

**Задача. Вывести баланс и имя юзера `1`**

```jsx
db.users.aggregate([
    { $match: { _id: 1 } },
    { $project: { fullname: 1, balance: 1, _id: 0 } }
])
```

**Задача. Вывести названия треков `1, 3, 5`**

```jsx
db.tracks.aggregate([
    { $match: { _id: { $in: [1, 3, 5] } } },
    { $project: { title: 1, _id: 0 } }
])
```

**Задача. Вывести имена юзеров с балансом от `10` до `1000` EUR**

```jsx
db.users.aggregate([
    { $match: { balance: { $gte: 10, $lte: 1000 } } },
    { $project: { fullname: 1, _id: 0 } }
])
```

**Пример. Вывести юзера, который находится на втором месте по балансу**

```jsx
db.users.aggregate([
    { $sort: { balance: -1 } },
    { $skip: 1 },
    { $limit: 1 }
])
```

**Задача. Вывести название и продолжительность трека, который находится на третьем месте по продолжительности**

```jsx
db.tracks.aggregate([
    { $sort: { duration_secs: -1 } },
    { $skip: 2 },
    { $limit: 1 },
    { $project: { title: 1, duration_secs: 1, _id: 0 } }
])
```

**Пример. Вывести один произвольный трек**

```jsx
db.tracks.aggregate([
    { $sample: { size: 1 } }
])
```

**Задача. Вывести имя одного произвольного незаблокированного юзера**

```jsx
db.users.aggregate([
    { $match: { is_blocked: { $ne: true } } },
    { $sample: { size: 1 } },
    { $project: { fullname: 1, _id: 0 } }
])
```

**Пример. Вывести треки, включая данные об их авторах**

```jsx
db.tracks.aggregate([
    {
        $lookup: {
            from: 'users', // название коллекции
            localField: 'author_id', // внешний ключ
            foreignField: '_id', // первичный ключ
            as: 'author' // куда поместить результат
        }
    }
])
```

**Задача. Необходимо вывести юзеров, у которых отсутствуют треки**

```jsx
db.users.aggregate([
    {
        $lookup: {
            from: 'tracks', // название коллекции
            localField: '_id',
            foreignField: 'author_id',
            as: 'tracks' // куда поместить результат
        }
    },
    { $match: { tracks: [] } }
])
```

**Пример. Добавление одного юзера**

```jsx
db.users.insertOne({
    _id: 6,
    fullname: 'No Tracks User',
    country: 'France'
})
```

**Задача. Вывести ко-во юзеров из `USA` и `Germany` с балансом от `10` EUR, использую метод `aggregate()`**

```jsx
db.users.aggregate([
    {
        $match: {
            country: { $in: ['USA', 'Germany'] },
            balance: { $gte: 10 }
        }
    },
    { $count: 'users_count' }
])
```