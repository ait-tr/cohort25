package generics.example03;

public class Cover<T> {
    private T phone;

    public Cover(T phone) {
        this.phone = phone;
    }

    public T getPhone() {
        return phone;
    }
}
