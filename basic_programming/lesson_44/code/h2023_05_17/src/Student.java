public class Student implements Comparable<Student>{
  private String fName;
  private String lName;
  private int doneHomeWork;
  private int missingLesson;

  public String getfName() {
    return fName;
  }

  public String getlName() {
    return lName;
  }

  public int getDoneHomeWork() {
    return doneHomeWork;
  }

  public int getMissingLesson() {
    return missingLesson;
  }

  public void setfName(String fName) {
    this.fName = fName;
  }

  public void setlName(String lName) {
    this.lName = lName;
  }

  public void setDoneHomeWork(int doneHomeWork) {
    this.doneHomeWork = doneHomeWork;
  }

  public void setMissingLesson(int missingLesson) {
    this.missingLesson = missingLesson;
  }

  public Student(String fName, String lName, int doneHomeWork, int missingLesson) {
    this.fName = fName;
    this.lName = lName;
    this.doneHomeWork = doneHomeWork;
    this.missingLesson = missingLesson;
  }

  @Override
  public String toString() {
    return "Student{" +
        "fName='" + fName + '\'' +
        ", lName='" + lName + '\'' +
        ", doneHomeWork=" + doneHomeWork +
        ", missingLesson=" + missingLesson +
        '}';
  }

  @Override
  public int compareTo(Student o) {
    return Integer.compare(this.missingLesson, o.missingLesson);
  }
}
