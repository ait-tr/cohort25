public abstract class School {
  private String title;
  public abstract void teach(Person person);

  public String getTitle() {
    return title;
  }

  public School(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return "School{" +
        "title='" + title + '\'' +
        '}';
  }
}
