package Settimana1.Services.OOP;

public enum Days {

    MONDAY("pot roast"),
    TUESDAY("spaghetti"),
    WEDNESDAY("tacos"),
    THURSDAY("meatloaf"),
    FRIDAY("chicken"),
    SATURDAY("hamburgers"),
    SUNDAY("pizza");

    private String meal;
    Days(String meal){
        this.meal = meal;
    }

    public String getMeal(){
        return this.meal;
    }

}
