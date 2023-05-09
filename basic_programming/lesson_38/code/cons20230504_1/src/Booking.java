public class Booking {
    private Person client;
    private Room room;
    private MyDate start;
    private MyDate end;

    public Booking(Person client, Room room, MyDate start, MyDate end) {
        this.client = client;
        this.room = room;
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "client=" + client +
                ", room=" + room +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
