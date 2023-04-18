public class Pizza {
    String title;
    int size;
    double price;
    String[] ingredients;

    Pizza(String title, int size, double price, String[] ingredients){
        this.title=title;
        this.price=price;
        this.size=size;
        this.ingredients=ingredients;
    }

    public String toString(){
        String ingr=ingredients[0];
        for (int i = 1; i <ingredients.length ; i++) {
            ingr+=", "+ingredients[i];
        }
        return  title + "[" + ingr+"]" + "  -"+size + "см." + "   "+ price;
    }



}
