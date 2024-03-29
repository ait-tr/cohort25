## Состояния файлов в Git

1. Неотслеж. (по умолчанию)
2. Отслеж.
3. Игнорируемые

## Отличие между проектом и репо

- **проект** - кодовая база
- **репо** - файловая БД с историей разработки

## Коммит

- `git commit` выполнить фиксацию (сохранение) изменений
    - `git commit -m 'update'`

## Просмотр состояния раб/каталога

- `git status`
    - `git status -s` сжатый вывод

## Легенда `git status -s`

- `??` - Untracked
- `M` - Modifed
- `D` - Deleted
- `A` - Added

## Добавить в очередь на коммит все изменения

- `git add .`
- `git add filename` (избирально)

## Базовый порядок сохранения изменений в проекте

1. Внести необходимые изменения в проект
2. Добавить сделанные изменения в очередь на сохранение (коммит)
    1. `git add .`
3. Выполнить сохранение (фиксация измнений, коммит)
    1. `git commit -m 'update'`

## Просмотр журнала коммитов

- `git log`

выйти из журнала - `q`

## Ветвление в Git

**Ветка** - поток изолированной разработки (еще одна версия проекта)

!https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f62a4a81-5ed2-4c7a-91ff-0189593adf41/Untitled.png

### Стратегии ветвления в Git

1. **Git Flow**
    1. `main/master/stable` - long-term (только для проверенного, оттестированного кода - “**священный грааль**”)
    2. `develop/current` - long-term (для тестирования, текущая разработка)
    3. `login/bugfix1/payments` - short-term
2. **GitHub Flow**
    1. `main/master/stable` - long-term
    2. `login/bugfix1/payments` - short-term
    

### Базовые команды по работе с ветками в Git

- `git branch` просмотр веток
    - `git branch -avv` подробный вывод
- `git branch новая_ветка`  создать ветку

- `git checkout ветка` переключиться на ветку
    - **ПЕРЕКЛЮЧАТЬСЯ НЕОБХОДИМО С “ЧИСТЫМ СТАТУСОМ”**
- `git checkout -b новая_ветка` создать и переключиться
- `git branch -D ветка` удалить ветку (локально)
- `git merge название_ветки` слияние веток
- `git push origin --delete ветка` удалить ветку (дистанционную)

## Слияние веток

- **Слияние (веток)** -  объединение (перенос или интеграция) изменений из одной ветки в другую
- `git merge название_ветки` выполнить слияние
- **перед слиянием необходимо переключиться на целевую ветку**

## Клонирование (скачивание) репозитория

- `git clone скопированная_ссылка`