import java.util.Comparator;

public class StudentsByHomeworkComparator implements Comparator<Student> {
  @Override
  public int compare(Student o1, Student o2) {
    return Integer.compare(o1.getDoneHomeWork(), o2.getDoneHomeWork());
  }
}
