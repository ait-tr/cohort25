import java.util.Comparator;

public class StudentsByNamesComparator implements Comparator<Student> {

  @Override
  public int compare(Student o1, Student o2) {
    if(o1.getlName().equals(o2.getlName())){
      return o1.getfName().compareTo(o2.getfName());
    }
    return o1.getlName().compareTo(o2.getlName());
    // A.compareTo(B)
    // compare(A, B)
  }
}
