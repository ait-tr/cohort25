public enum DaysOfWeek {
    MONDAY("пон"),
    TUESDAY("вт"),
    WEDNESDAY("ср"),
    THURSDAY("чт"),
    FRIDAY("пят"),
    SATURDAY("сб"),
    SUNDAY("вс");

    String ruName;

    DaysOfWeek(String ruName){
        this.ruName = ruName;
    }
    public String getRuName(){
        return ruName;
    }

    /*
    public String toString(){
        return "День недели:" + ruName;
    }

     */

}
