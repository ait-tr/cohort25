## Decision tables - Таблицы решений
одна из техник тест-дизайна методом черного ящика, которая относится к динамическому анализу. Используется в том случае, когда есть комбинация входных данных. Основной целью является проверка бизнес-логики и тестового покрытия

one of the black box test design techniques that relates to dynamic analysis. Used when there is a combination of input data. The main goal is to check business logic and test coverage

**Алгоритм работы с таблицами решений:**

- Определите все возможные условия(Conditions)
- Определите все соответствующие действия(Actions), которые могут произойти в системе 
- Сгенерируйте все возможные комбинации условий; каждая отдельная комбинация формы - отдельный столбец в таблице решений 
- Для каждой комбинации условий определите, какие действия должны выполняться, а какие - нет; заполните соответствующие поля в данном столбце ниже соответствующей комбинации условий 
- Для каждого столбца составьте как минимум один контрольный пример, в котором выполняется заданная комбинация условий; тест должен проверить, выполняются ли соответствующие действия

- Define all possible Conditions
- Define all relevant Actions 
- Generate all possible combinations of conditions; each individual shape combination is a separate column in the decision table 
- For each combination of conditions, determine which actions should be performed and which should not; fill in the appropriate fields in this column below the appropriate combination of conditions 
- For each column, create at least one test case in which the specified combination of conditions is true; the test should check if the appropriate actions are performed

[Презентация](https://docs.google.com/presentation/d/1X2AFW4ik4coNbsdNbLJOKXPa1iUiBR3S/edit?usp=sharing&ouid=116447005932578256378&rtpof=true&sd=true)

[Decision tables exercises](https://docs.google.com/spreadsheets/d/1Mhtohei-9ojiwFRl3FORMD_NIAAAqGlA/edit?usp=sharing&ouid=116447005932578256378&rtpof=true&sd=true)

## State transition diagrams - Диаграммы перехода состояний
методика тестирования ПО, когда изменения условий ввода вызывают изменения состояния в тестируемом приложении

a software testing technique where changes in input conditions cause state changes in the application under test

**Two types of visual representation of technology(Два вида визуального представления техники):**

- State-Transition Diagram(Диаграмма перехода состояний)

- State-Transition Table(Таблица перехода состояний)

**Components of a state transition diagram(Составляющие диаграммы перехода состояний)**

States(Состояния) - possible conditions for the existence of the system at the moment(возможные условия существования системы в данный момент)

Transitions(Переходы) - possible changes to the object leading to a change in state(возможные изменения объекта, приводящие к изменению состояния)

Events(События) - external events that can occur and cause a change in state(внешние события, которые могут произойти и вызывают изменение состояния)

[Презентация](https://docs.google.com/presentation/d/1ruKU-zimvqJ0eUabbj4C9a-7kzfOqyK-/edit?usp=sharing&ouid=116447005932578256378&rtpof=true&sd=true)

[State transition example](https://drive.google.com/file/d/1N8O_3VDvwHeJrt3SgTYrpFtMAHGJwYrh/view?usp=drive_link)

[State transition table](https://docs.google.com/spreadsheets/d/1fq2WKKsc3F16Q6kYm_vFyPnJduJFrov5B_1n8E3aDgQ/edit?usp=share_link)

