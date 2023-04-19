public class Pirate {
    String name;
    String nickName;
    boolean isDrunk;
    Pirate(String name, String nickName, boolean isDrunk){
        this.name = name;
        this.nickName = nickName;
        this.isDrunk = isDrunk;
    }
    public String toString(){
        return name + " " + nickName + " " + isDrunk;
    }
    public void say(){
        if(isDrunk){
            System.out.println("Yohohoho, what a good life");
        } else {
            System.out.println("It's a bad day");
        }
    }
    public void drink(){
        isDrunk = true;
    }
}
