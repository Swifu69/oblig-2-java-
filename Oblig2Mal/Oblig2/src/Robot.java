//Making my robot class

public class Robot {

    private String name;
    private int batteryLevel;
    private double distanceToPark;
    private String botType;
    private String prossessor;
    private String osType;

    //constructor for the robot
    public Robot(String name, int batteryLevel, double distanceToPark, String botType, String prossessor, String osType) {
        this.name = name;
        this.batteryLevel = batteryLevel;
        this.distanceToPark = distanceToPark;
        this.botType = botType;
        this.prossessor = prossessor;
        this.osType = osType;
    }

    //Report status method, had it return as a string before, but didnt look good in main, so i opted for a sout
    public void reportStatus() {

        System.out.println("--------Status report for " + getName() + "--------\nName: " + name + "\nBatterylevel: " + batteryLevel + "\nDistance to park: " + distanceToPark + "Km" + "\nType of Robot: " + botType + "\nProssessor: " + prossessor + "\nOperative System: " + osType + "\n-------------End-------------");
    }

    //Some getters for later
    public String getName() {
        return this.name;
    }

    public int getBatteryLevel() {
        return this.batteryLevel;
    }

    public double getDistanceToPark() {
        return this.distanceToPark;
    }

    public String getBotType() {
        return this.botType;
    }

    //Method to check if the robot can go to the park
    public boolean canWalkToThePark(World world) {
        //dividing distance by hundred to get how much batery is needed acording to the distance to the park
        double batteryNeeded = getDistanceToPark() / 100;
        boolean canWalk = true;

        if (!world.isSunday()) {
            System.out.println(getName() + " can't go to the park because it is not Sunday.");
            canWalk = false;
        }
        if (world.getIsRaining()) {
            System.out.println(getName() + " can't go outside because it is raining.");
            canWalk = false;
        }
        if (getBatteryLevel() < batteryNeeded) {
            System.out.println(getName() + " can't go to the park because it does not have enough battery.");
            System.out.println("Battery needed: " + batteryNeeded + "%, current: " + getBatteryLevel() + "%");
            canWalk = false;
        }

        if (canWalk) {
            System.out.println(getName() + " can go to the park because all conditions are met!");
        }

        return canWalk;
    }


    /*Changed the way we aproched things, there is a boolean that gets updated if a condition is not met, if all conditions are met then make it true and return it*/

    public boolean canDanceAtClub(World world) {
        boolean canDance = true;

        if (world.isMonday()) {
            System.out.println(getName() + " can't go to the club, because the dance club is closed on Mondays.");
            canDance = false;
        }
        if (world.getIsRaining()) {
            System.out.println(getName() + " can't go to the club because it is raining.");
            canDance = false;
        }
        //Clankers and B-Bots cant come to the club....
        if (getBotType().equals("Clanker")|| getBotType().equals("B-Bot")) {
            System.out.println(getName() + " can't go to the club because it is a Clanker or B-Bot.");
            canDance = false;
        }
        if (getBatteryLevel() < 50) {
            System.out.println(getName() + " can't go to the club because it needs at least 50% battery to dance.");
            canDance = false;
        }

        if (canDance) {
            System.out.println(getName() + " can go to the club, because all criteria are met!");
        }

        return canDance;
    }

}
