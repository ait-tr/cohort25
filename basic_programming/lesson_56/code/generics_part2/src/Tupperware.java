public class Tupperware <T extends Food>{
  public T containing;
  public void throwAway(){
    containing = null;
  }
  public T getFood(){
    T food = containing;
    containing = null;
    return food;
  }
  public boolean addFood(T food){
    if(containing == null){
      containing = food;
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return "Tupperware{" +
        "containing=" + containing +
        '}';
  }
}
