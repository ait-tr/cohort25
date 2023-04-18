public class Main {
    public static void main(String[] args) {
        String[] margaritaIngredients={"моцарелла","помидоры","соус"};
        String[] pepperoniIngredients={"моцарелла","помидоры","пепперони"};

        Pizza[] pizzas = {
                new Pizza("Маргарита",26,12.50,margaritaIngredients),
                new Pizza("Маргарита",32,16.99,margaritaIngredients),
                new Pizza("Маргарита",10,6.70,margaritaIngredients),
                new Pizza("Пепперони",26,12.70,pepperoniIngredients),
                new Pizza("Пепперони",10,7.00,pepperoniIngredients),
                new Pizza("Пепперони",32,16.99,pepperoniIngredients)
        };

        for (int i = 0; i <pizzas.length ; i++) {
            System.out.println(pizzas[i]);
        }
    }
}