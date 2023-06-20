package repositories.impl;

import models.Order;
import repositories.OrdersRepository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 6/20/2023
 * cohort25
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class OrdersRepositoryFileImpl implements OrdersRepository {

    private String fileName;

    public OrdersRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(Order order) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
            writer.write(order.getId() + "|" +
                    order.getDateTime().toString() + "|" +
                    order.getGoodId() + "|" +
                    order.getUserId());
            writer.newLine();
        } catch (IOException e) {
            throw new IllegalStateException("Проблемы с файлом");
        }
    }

    @Override
    public Order findById(String id) {
        return null;
    }
}
