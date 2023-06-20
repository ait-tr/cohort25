package repositories;

import models.Good;

/**
 * 6/20/2023
 * cohort25
 *
 * @author Marsel Sidikov (AIT TR)
 */
public interface GoodsRepository extends CrudRepository<Good> {
    // save(Good good);
    // Good findById(String id);

    Good findByTitle(String title);
}
