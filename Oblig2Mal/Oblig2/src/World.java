//imported random class to make rain randomized

import java.util.Random;

public class World {
    private boolean isRaining;
    private int day;
    private Random random = new Random();


    //Constructor for the world-class, we can make multiple worlds, aka parallel universes
    public World(int day, boolean isRaining) {
        this.day = day;
        this.isRaining = isRaining;
        this.random = new Random();
    }

    //method to skip to next day and to generate a new chance for raining
    /*we made it so isRaining = Random number less than 30, so we get a 30% chance of rain for each day,
    then isRaining becomes either true or false depending on if the random number is less than 30*/
    public void nextDay() {
        day++;
        isRaining = random.nextInt(100) < 30;// increase day count
    }

    //method to get the day
    public int getSavedDay() {
        return day;
    }

    //method to check if it's monday
    public boolean isMonday() {
        return getSavedDay() == 1;
    }

    //same just for sunday
    public boolean isSunday() {return getSavedDay() == 7;}



    public boolean getIsRaining() {
        return isRaining;
    }

    //Method to get the day, it takes a number, and depending on the number we can check which day it its by returning the array[index].
    public String getDay(int n) {
        String[] dager = {"Mandag", "Tirsdag", "Onsdag", "Torsdag", "Fredag", "Lørdag", "Søndag"};

        int dagIndex = (n - 1) % 7;
        return dager[dagIndex];
    }
}
