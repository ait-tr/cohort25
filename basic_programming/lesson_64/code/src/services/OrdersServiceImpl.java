package services;

import models.Good;
import models.Order;
import models.User;
import repositories.GoodsRepository;
import repositories.OrdersRepository;
import repositories.UsersRepository;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 6/20/2023
 * cohort25
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class OrdersServiceImpl implements OrdersService {

    private UsersRepository usersRepository;
    private GoodsRepository goodsRepository;

    private OrdersRepository ordersRepository;

    public OrdersServiceImpl(UsersRepository usersRepository,
                             GoodsRepository goodsRepository,
                             OrdersRepository ordersRepository) {
        this.usersRepository = usersRepository;
        this.goodsRepository = goodsRepository;
        this.ordersRepository = ordersRepository;
    }

    @Override
    public String makeOrder(String email, String title) {
        User user = usersRepository.findByEmail(email); // находим пользователя по email

        if (user == null) {
            throw new IllegalArgumentException("Пользователь не найден");
        }

        Good good = goodsRepository.findByTitle(title); // находим товар по названию

        if (good == null) {
            throw new IllegalArgumentException("Товар не найден");
        }

        Order order = new Order(
                UUID.randomUUID().toString(), // сгенерировали идентификатор
                LocalDateTime.now(),
                good.getId(),
                user.getId()
        );

        ordersRepository.save(order);

        return "Квитанция № " + order.getId() + ", заказ был сделан на " + title + " в " + order.getDateTime();
    }
}
