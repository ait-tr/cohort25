import repositories.GoodsRepository;
import repositories.OrdersRepository;
import repositories.UsersRepository;
import repositories.impl.GoodsRepositoryFakeImpl;
import repositories.impl.OrdersRepositoryFileImpl;
import repositories.impl.UsersRepositoryFakeImpl;
import services.OrdersService;
import services.OrdersServiceImpl;

import java.util.UUID;

/**
 * 6/20/2023
 * cohort25
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main {
    public static void main(String[] args) {
        GoodsRepository goodsRepository = new GoodsRepositoryFakeImpl();
        UsersRepository usersRepository = new UsersRepositoryFakeImpl();
        OrdersRepository ordersRepository = new OrdersRepositoryFileImpl("orders.txt");
        OrdersService ordersService = new OrdersServiceImpl(
                usersRepository, goodsRepository, ordersRepository);

        String receipt = ordersService.makeOrder("user@gmail.com", "Бургер");

        System.out.println(receipt);
    }
}
