# Повторение

## 01. Структура проекта

* У нас используется трехслойная архитектура - `controllers`, `services`, `repositories`

* `de.ait.shop`
  * `config`
  * `controllers` - обработка клиентских запросов.
  * `models` - модели предметной области. Описывают данные, которыми мы манипулируем.
    * `User`- описание пользователя нашей системы, те данные, которые мы храним
  * `repositories` - слой, построенный по принципу DAO (`Data Access Object`). Для каждого типа хранилища есть своя реализация соответствующего интерфейса.
    * `impl` - реализации репозиториев
      * `UsersRepositoryFileImpl` - реализация для работы с файлами
      * `UsersRepositoryListImpl` - реализация для работы со списками
    * `CrudRepository` - Generic-интерфейс, который содержит универсальный набор методов для работы с данными
    * `UsersRepository` - потомок `CrudRepository`, в дополнение к его методам имеет свой набор, применимый только к модели `User`
  * `services` - бизнес-логика (основные операции системы, то, что мы автоматизируем - бизнес-процессы)
    * `UsersService` - интерфейс, описывающий набор бизнес-методов
    * `impl` - пакет, содержащий реализации нашего бизнес-слоя (как правило, она одна)
      * `UsersServiceImpl` - реализация нашего интерфейса
  * `validation` - слой валидации. Здесь размещаются классы и интерфейсы, связанные с проверкой корректности входных данных
    * `impl` - реализация наших валидаторов
      * `EmailNotEmptyValidatorImpl` - проверка на пустоту
      * `EmailValidatorRegexImpl` - проверка в соответствии с регулярным выражением
      * `PasswordNotEmptyValidatorImpl` - проверка на пустоту
      * `PasswordValidatorRegexImpl` - проверка в соответствии с регулярным выражением
    * `EmailValidator` - интерфейс для проверки Email-а
    * `PasswordValidator` - интерфейс для проверки пароля
  * `Main` - отвечает за запуск приложения

![image](https://raw.githubusercontent.com/ait-tr/cohort25/main/back_end/lesson_04/img/1.png)

### Замечания

* Бизнес-логика - алгоритм работы вашей системы, например:
  * Операция Перевода денег на банковский счет другого человека:
    * Получить номер счета другого человека
    * Проверить наш баланс
    * Списать деньги с нашего баланса
    * Зачислить деньги на другой баланс
    * Оповестить нас по смс, что деньги отправлены
    * Оповестить другого человека, что деньги пришли
  * Регистрация пользователя:
    * Проверить, нормальный ли email
    * Проверить, нормальный ли пароль
    * Проверить, нет ли такого email-а в системе
    * Если все ок - сохранить пользователя
* Бизнес логику мы ВСЕГДА размещаем в отдельном слое, который называется сервисами.

* Контроллеры - к реальной жизни отношения имеет мало, но, в web-приложениях контроллеры обрабатывают HTTP-запросы.
* В нашем случае, контроллеры работают с консолью.
* Контроллер - это просто обертка над сервисом, которая позволяет вызывать методы сервиса из специфичной для клиента среды (в нашем случае - консоли)

## 02. Использование Spring

* В нашем случае Spring берет на себя ответственность за создание компонентов системы (все классы, кроме `Main` и `models`)
* А также за их связывание между собой.
* Каждый компонент системы, который обрабатывается Spring-ом мы называем Bean-ом
* Чтобы задать bean, необходимо определить его название, тип и процесс, по которому следует создать этот бин.

### Мы это делаем следующим образом:

* Создаем класс `JavaConfig` и помечаем его аннотацией `@Configuration`, таким образом, данный класс будет содержать описанные нами бины.
* Задаем бины в следующем виде:

```
@Bean
public PasswordValidator passwordValidatorNotEmpty() {
   return new PasswordNotEmptyValidatorImpl();
}
```  

* `@Bean` - аннотация, которой мы помечаем метод, создающий новый бин для Spring
* `PasswordValidator` - тип бина
* `passwordValidatorNotEmpty` - название, или `id` нашего бина
* `return new PasswordNotEmptyValidatorImpl();` - процесс создания бина

* Если бин требует каких-либо зависимостей на другие бины, то мы должны указать эти зависимости в параметрах метода, создающего наш бин:

```
@Bean
public UsersService usersService(UsersRepository usersRepositoryFile,
                          EmailValidator emailValidatorNotEmpty,
                          PasswordValidator passwordValidatorRegex) {
        return new UsersServiceImpl(usersRepositoryFile, emailValidatorNotEmpty, passwordValidatorRegex);
    }
```

* В данном случае, конструктор `UsersServiceImpl` требует трех других бинов
* Мы указали типы этих бинов в параметрах метода (именно интерфейсы, а не реализации, Spring уже сам подберет нужные реализации на основе ранее созданных бинов).
* Но, что делать, если под конкретный интерфейс попадает два варианта бинов? Какой Spring выберет?

* Вариант, когда наш параметр имеет "дефолтное название":

```
    @Bean
    public UsersRepository usersRepositoryList() {
        return new UsersRepositoryListImpl();
    }

    @Bean
    public UsersRepository usersRepositoryFile() {
        return new UsersRepositoryFileImpl("users.txt");
    }

    @Bean
    public UsersService usersService(UsersRepository usersRepository,
                                     EmailValidator emailValidatorNotEmpty,
                                     PasswordValidator passwordValidatorRegex) {
        return new UsersServiceImpl(usersRepository, emailValidatorNotEmpty, passwordValidatorRegex);
    }
```

* В этом случае будет ошибка, он не сможет подобрать нужный бин, потому что типу `UsersRepository` соответствует два бина:
  * `usersRepositoryList`
  * `usersRepositoryFile`
* Как решить эту проблему? Можно использовать `@Qualifier` с указанием конкретного бина:

```
@Bean
public UsersService usersService(@Qualifier("usersRepositoryList") UsersRepository usersRepository,
                                 EmailValidator emailValidatorNotEmpty,
                                 PasswordValidator passwordValidatorRegex) {
    return new UsersServiceImpl(usersRepository, emailValidatorNotEmpty, passwordValidatorRegex);
}
```

* Второй вариант - дать название параметру в соответствии с нужным бином:

```
@Bean
public UsersService usersService(UsersRepository usersRepositoryList,
                                 EmailValidator emailValidatorNotEmpty,
                                 PasswordValidator passwordValidatorRegex) {
    return new UsersServiceImpl(usersRepositoryList, emailValidatorNotEmpty, passwordValidatorRegex);
}
```

* Как запустить приложение с использованием Spring?

```
ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

Scanner scanner = applicationContext.getBean(Scanner.class);

UsersController usersController = applicationContext.getBean(UsersController.class);
```

* `ApplicationContext` - это интерфейс, который описывает поведение IoC-контейнера (контейнера всех бинов в Spring)
  * `T getBean(Class<T> aClass)` - метод для получения бина по его типу
* В данном случае, мы получаем два бина - `Scanner` и `UsersController` со всеми соответствующими связями.
* `AnnotationConfigApplicationContext(AppConfig.class);` - это конкретная реализация контейнера, которая работает на аннотациях.
* Мы скормили этой реализации наш с вами класс `AppConfig`, чтобы он знал, откуда брать бины.
* Сами бины можно посмотреть, поставив breakpoint на строку, после создания контекста -> `beanFactory` -> `beanDefinitionMap`

### Другие способы объявления бинов

* Мы можем заметить, что некоторые бины создаются достаточно тривиально, с помощью `new Класс()`.
* Spring предусмотрел такую ситуацию и предлагает нам другой вариант создания бинов.
* `@Component` - аннотация Spring, которую мы вешаем на класс, на основе которого Spring сам создаст бин с помощью `new Класс()`
* Но, Spring-у нужно сказать, что у нас в пакетах лежат классы, которые помечены этой аннотацией.
* Делаем это с помощью аннотации `@ComponentScan`
* Важный момент - если вы используете `@Component`, то по умолчанию названием такого бина будет название класса с маленькой буквы.
  * Вы можете поправить название параметра:
  ```
   @Bean
   public UsersService usersService(UsersRepository usersRepositoryList,
                                     EmailValidator emailValidatorNotEmpty,
                                     PasswordValidator passwordValidatorRegexImpl) 
  ```
  * Вы можете задать свое название бина внутри аннотации `@Component`: `@Component("passwordValidatorRegex")`

* А что делать с некоторыми значениями, которые мы кладем в наши бины? Например название файла?
  * Мы можем создать в папке `resources` файл `application.properties`, который содержит свойства нашего приложения.
  * Далее, подключим этот файл к Spring через `@PropertySource("classpath:application.properties")`
  * Затем, в самом файле определим свойство и его значение: `users.file-name=users.txt`
  * Далее, используем это свойство в конструкторе нашего репозитория с помощью аннотации `@Value` внутри которой указываем название свойства:

```
public UsersRepositoryFileImpl(@Value("${users.file-name}") String fileName) {
        this.fileName = fileName;
}
```

* Итого, мы определили свойство в отдельном файле, и теперь сможем менять название файла без переписывания кода приложения.

* А что делать с бинами, которые зависят от других бинов? Мы можем использовать аннотацию `@Autowired`.
* В целом эта аннотация позволяет автоматически связать существующий бин с местом инджекта.
  * Например, поле (главное, чтобы оно не было `final`).
    * Если существует несколько кандидатов, можно:
      * Либо назвать поле так же, как назвать какой-либо бин
      * Либо повесить `@Qualifier`
    * В целом, такой вариант не рекомендуется, потому что тогда ваш класс без Spring-а не может использоваться (Потому что нет конструктора)
  * Например, конструктор (тогда все поля лучше сделать `final`)
    * Если существует несколько кандидатов, просто называем параметры конструктора так же как и бины (или используем `@Qualifier`)

* А когда в итоге `@Bean`, а когда `@Component`?
  * Если ваш класс создается очень просто, то `@Component`
  * Если класс вообще не ваш, но нужно, чтобы его экземпляр был бинов - `@Bean`
  * Если ваш класс создается как-то сложно (в будущем рассмотрим и такие варианты).


### Резюмируя

* В целом программирование с использованием Spring позволяет просто вешать аннотации на ваши классы, а Spring сам все соединит между собой.

### А как на самом деле в реальных проектах?

1. Как правильно (чаще всего) не существует больше 1-го кандидата на связывания (за редким исключением, но они бывают)
2. На сервисах ставят аннотацию `@Service` (это синоним `@Component`)
3. На репозиториях ставят аннотацию `@Repository`
4. На конструктор необязательно вешать `@Autowired`, Spring и сам все прекрасно понимает

![image](https://raw.githubusercontent.com/ait-tr/cohort25/main/back_end/lesson_04/img/2.png)