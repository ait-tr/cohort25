package models;

/**
 * 6/20/2023
 * cohort25
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Good { // товар
    private String id;
    private double price;
    private String title;

    public Good(String id, double price, String title) {
        this.id = id;
        this.price = price;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }
}
