-- тут будут и владельцы и водители
create table account
(
    id         bigserial primary key, -- первичный ключ, идентифицирует пользователя, генерируется базой данных
    first_name varchar(30),
    last_name  varchar(30)
);

insert into account (first_name, last_name)
values ('Marsel', 'Sidikov');
insert into account (first_name, last_name)
values ('Anna', 'Bieliaieva');
insert into account (first_name, last_name)
values ('Valentin', 'Dumler');
insert into account (first_name, last_name)
values ('Viktoriia', 'Ustymova');
insert into account (first_name, last_name)
values ('Irina', 'Frank');


-- таблица для хранения автомобилей
create table car
(
    id       bigserial primary key,
    model    varchar(20),
    color    varchar(20),
    owner_id bigint,
    foreign key (owner_id) references account (id)
);

insert into car (model, color, owner_id)
values ('BMW', 'Black', 2);
insert into car (model, color, owner_id)
values ('Audi', 'Red', 2);
insert into car (model, color, owner_id)
values ('MB', 'White', 3);
insert into car (model, color, owner_id)
values ('Bugatti', 'Blue', 4);
insert into car (model, color, owner_id)
values ('Ferrari', 'Red', 4);
insert into car (model, color)
values ('Ford', 'White');


create table driver_car
(
    driver_id bigint not null,
    car_id    bigint not null,
    foreign key (driver_id) references account (id),
    foreign key (car_id) references car (id),
    unique (driver_id, car_id)
);

insert into driver_car (driver_id, car_id)
values (1, 4);
insert into driver_car (driver_id, car_id)
values (1, 5);
insert into driver_car (driver_id, car_id)
values (3, 4);

-- хочу получить владельцев машин, которыми пользуется Марсель

-- сначала получить id марселя

;

-- получить все машины, которые водит Марсель

select model, color
from car
         inner join (select car_id
                     from driver_car
                     where driver_id = (select id from account where first_name = ?)) marsel_cars
                    on car.id = marsel_cars.car_id;

