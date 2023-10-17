## QA - QC - testing

Testing – проверка продукта на соответствие требованиям, реактивная деятельность

QC (Quality Control, контроль качества) – не только тестирование, но и проверка продукта на соответствие заранее согласованному уровню качества

QA (Quality Assurance, обеспечение качества) – включает мероприятия на всех этапах разработки, проактивная деятельность

Quality Control is a process through which a business seeks to ensure that product quality is maintained or improved, and manufacturing errors are reduced or eliminated

Quality Assurance the continuous and consistent improvement and maintenance of process that enables the QC job

Testing is the basic activity aimed at detecting issues in the software

## Стандарты тестирования

[Презентация](https://docs.google.com/presentation/d/1iv4BDXYYD_48rSDwBvUjZeF_sfbkCRi3/edit?usp=sharing&ouid=116447005932578256378&rtpof=true&sd=true)
модель качества используется для оценки качества ПО и определяет, какие характеристики необходимо при этом учитывать. **Качество ПО** — степень, в которой система удовлетворяет заявленные и подразумеваемые потребности различных заинтересованных сторон и, таким образом, обеспечивает его ценность

**Standard of testing**
a quality model used to assess the quality of software and determines which characteristics must be taken into account. **Software Quality** is the extent to which a system satisfies the stated and implied needs of various stakeholders and thus provides value

Стандарт ISO/IEC 25010: 2011
включает такие критерии как

**Функциональная стабильность(Functional suitability)**
**Надежность(Reliability)**
**Производительность(Performance Efficiency)**
**Удобство использования(Usability)**
**Ремонтопригодность(Maintainability)**
**Портативность(Portability)**
**Совместимость(Compatibility)**
**Безопасность(Security)**

##### Классификация тестирования по уровням(by levels)
**Модульное(Unit)**
**Интеграционное(Integration)**
**Системное(System)**
**Приемочное(Acceptance)**

##### Классификация тестирования по времени проведения(by time)
**Beta**
**Alfa**
**Дымовое(Smoky)**
**Санитарное(Sanity)**
**Регрессионное(Regression)**

##### Классификация тестирования по знанию системы(based on system knowledge)
- Черный ящик(Black-box)
- Серый ящик(Grey-box)
- Белый ящик(White-box)

##### Классификация тестирования по уровню автоматизации(by level of automation)
- Ручное(Manual)
- Полу-автоматизированное(Semi-automated)
- Автоматизированное(Automated)

##### Классификация тестирования по формализации(by formalization)
- Свободное(Monkey,Ed-hoke)
- Исследовательское(Exploratory)
- Основанное на тест-кейсах(Test case based)

##### Классификация тестирования по сценарию(by scenario)
- Positive(Позитивное)
- Negative(Негативное)


## Тест процесс

[Презентация](https://docs.google.com/presentation/d/17kZMyhhchqwJp07ASyfA5bsQ8rQeGOrd/edit?usp=sharing&ouid=116447005932578256378&rtpof=true&sd=true)

**Планирование**
определить

• объем работы и риски

• тестовый подход и стратегию

• необходимые ресурсы

составить

• расписание и определить критерии выхода

**Анализ**
исследовать базис тестирования, например:

• спецификацию требований

• информацию о проектировании и реализации

• реализацию самого компонента или системы

• отчеты анализа рисков

**Проектирование**
• разработать и приоритизировать тестовые сценарии и их наборы

• определить необходимые тестовые данные

• спроектировать тестовое окружение и определить необходимую инфраструктуру и инструменты

**Внедрение**
• разработать и расставить приоритеты тестирования

• организовать наборы тестов

• построить тестовое окружение

• подготовить и загрузить в тестовое окружение тестовые данные

**Реализация**
• записать идентификаторы и версии элемента(-ы) тестирования

• выполненть тесты вручную или с помощью инструментов

• сравнить фактические и ожидаемые результаты

• проанализировать отклонения

• составить отчеты о дефектах

• запротоколировать результаты выполнения тестов

**Оценка критериев выхода и написание отчетов**
• проверить тест-логи на соответствие критериям выхода, указанным в планировании тестирования

• оценить необходимость дополнительных тестов или изменения указанных критериев выхода

• создать итоговый отчет о тестировании для заинтересованных сторон

**Действия по завершению тестирования**
• проверить, какие запланированные результаты действительно получены, и убедиться, что все отчеты об инцидентах были устранены

• доработать и заархивировать тестовое ПО - сценарии, тестовые среды и т.д. для последующего повторного использования

• передать тестовое ПО обслуживающей организации, которая будет осуществлять поддержку ПО

• оценить, как прошло тестирование, и извлечь уроки для будущих выпусков и проектов

[Шпаргалка по документации](https://docs.google.com/spreadsheets/d/18pSPrnWRGI-rM4f0QdUMsE9LMxBOvCOa/edit?usp=sharing&ouid=116447005932578256378&rtpof=true&sd=true)

**Planning**
define

• scope of work and risks

• approach and deviation tests

• necessary resource

• schedule and define exit criteria

**Analysis**
explore the testing basis, for example:

• requirements specification

• information about design and implementation

• implementation of the component or system itself

• risk analysis reports

**Design**
• develop and prioritize test scenarios and suites

• determine the required test data

• design a test environment and determine the necessary infrastructure and tools

**Implementation**
• develop and prioritize testing

• organize test suites

• build a test environment

• prepare and load test data into the test environment

**Execution**
• record the identifiers and versions of the testing item(s)

• run tests manually or using tools

• compare actual and expected results

• analyze deviations

• create bug reports

• record the test results

**Evaluating exit criteria and reports**
• check the test logs for compliance with the exit criteria specified in the test planning

• assess the need for additional tests or changes to specified exit criteria

• create a final test report for stakeholders

**Test closure activities**
• check which planned results have actually been achieved and ensure that all incident reports have been resolved

• finalize and archive test software - scripts, test environments, etc. for later reuse

• transfer the test software to a service organization that will support the software

• evaluate how testing went and learn lessons for future releases and projects

## Test artefacts

[Презентация](https://docs.google.com/presentation/d/16SBaft7mBg5O39Uu3ABpytwvB_6FFSzb/edit?usp=sharing&ouid=116447005932578256378&rtpof=true&sd=true)

**План тестирования(Test Plan)**
документ, описывающий весь объем работы по тестированию, начиная с описания объекта, стратегии, расписания, критериев начала и окончания тестирования, до необходимого в процессе работы оборудования, специальных знаний, а также оценки рисков с вариантами их разрешения.

**Тест кейс и набор тестов(Test Case & Test suite)**
последовательность действий, позволяющая проверить соответствует ли тестируемая функция установленным требованиям.

**Дефекты/Баг Репорты(Defects/Bug Reports)**
документы, описывающие ситуацию или последовательность действий, ставшие причиной некорректной работы объекта тестирования, с указанием причин и ожидаемого результата.

**Форматы оформления тест планов**

[RUP (Rational Unified Process)](https://docs.google.com/document/d/1C95gRz-dTOsCfCTC9qdxQ0mXPQbbvR42/edit?usp=sharing&ouid=116447005932578256378&rtpof=true&sd=true)

[IEEE 829](https://drive.google.com/file/d/1UOQs5XH1AmQyY_8rfoKSzqsIjmkjaZOS/view?usp=sharing)

[Свой собственный шаблон](https://docs.google.com/document/d/1ggm5fQdjBKPY3lCNGb9m_2hDz-HoajyC/edit?usp=sharing&ouid=116447005932578256378&rtpof=true&sd=true)

[STP](https://docs.google.com/spreadsheets/d/1TQlAr1DmMJ5AE_watoJoid6myYUX1C5pPPhVKbLNd0Q/edit?usp=sharing)

[Software testing standards](https://drive.google.com/file/d/1yWSFqMy_LojzWvQ96ZutgmMy_pzj_65i/view?usp=sharing)
