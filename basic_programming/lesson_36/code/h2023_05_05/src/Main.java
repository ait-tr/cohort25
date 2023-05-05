import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    Product nikeAir = new Product(
        "Nike Airmax", 130, Category.CLOTHES);
    System.out.println(nikeAir.getTitle());
    System.out.println(nikeAir);
    List<Product> products = List.of(
        nikeAir,
        new Product("Wine", 7, Category.GROCERY),
        new Product("Samsung xh28", 200, Category.ELECTRONICS)
    );
    System.out.println(products);
    System.out.println(getMapPricesOfProducts(products));
    nikeAir.setPrice(20);
    nikeAir.setPrice(30);
    nikeAir.setPrice(140);
    nikeAir.setPrice(-5);
    nikeAir.printPriceHistory();
    products.get(1).printPriceHistory();
  }
  public static Map<String,Double> getMapPricesOfProducts (List<Product> products){
    Map<String, Double> map = new HashMap<>();
    for(Product product: products){
      map.put(product.getTitle(), product.getPrice());
    }
    return map;
  }

}


