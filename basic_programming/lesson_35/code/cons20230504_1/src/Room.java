public class Room {
    private int id;
    private int number;
    private int capacity;
    private RoomCategory category;

    public Room( int number, int capacity, RoomCategory category) {
        this.id = number;
        this.number = number;
        this.capacity = capacity;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", number=" + number +
                ", capacity=" + capacity +
                ", category=" + category +
                '}';
    }
}
