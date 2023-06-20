package repositories.impl;

import models.Good;
import repositories.GoodsRepository;

import java.util.UUID;

/**
 * 6/20/2023
 * cohort25
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class GoodsRepositoryFakeImpl implements GoodsRepository {
    @Override
    public void save(Good model) {

    }

    @Override
    public Good findById(String id) {
        return null;
    }

    @Override
    public Good findByTitle(String title) {
        if (title.equals("Бургер")) {
            return new Good(
                    "04c2490d-6af7-4ef5-a272-5a1ca861121b",
              100.0, "Бургер"
            );
        }
        return null;
    }
}
