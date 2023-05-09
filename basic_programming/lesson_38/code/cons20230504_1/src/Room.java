public class Room {
    private static int roomCounter=0;
    private int id;
    private int number;
    private int capacity;
    private RoomCategory category;

    public Room( int number, int capacity, RoomCategory category) {
        roomCounter+=10;
        this.id = roomCounter;
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
