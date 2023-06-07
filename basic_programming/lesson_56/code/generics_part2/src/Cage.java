public class Cage <T extends Animal>{
  // <T extends Animal> - означает, что мы сможем создавать клетки
  // с любыми классами производными от Animal
  public T prisoner;

  public Cage(T prisoner) {
    this.prisoner = prisoner;
  }
}
