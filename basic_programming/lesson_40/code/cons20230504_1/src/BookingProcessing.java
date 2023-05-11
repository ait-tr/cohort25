import java.util.ArrayList;
import java.util.List;

public class BookingProcessing {
    private List<Booking> bookingList = new ArrayList<>();

    /* CRUD
       добавить
       найти
       изменить
       удалить
     */

    public boolean add(Booking booking){
        // проверить возможность добавить букинг
        if (checkBooking(booking)){
            bookingList.add(booking);
            return true;
        }
        return false;
    }

    public boolean add(Person person, Room room, MyDate start, MyDate end){
        Booking booking = new Booking(person,room,start,end);
        return add(booking);
    }

    // TODO реализовать проверку возможности бронирования
    private boolean checkBooking(Booking booking){
        return true;
    }

    public String toString(){
        String rez="";
        for (Booking booking:bookingList){
            rez+=booking.toString()+System.lineSeparator(); // \n
        }
        return rez;
    }




}
