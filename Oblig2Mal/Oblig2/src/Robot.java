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
        //Get distance to park for the robot we make and divide by one hundred, so we can get the battery level we need to reach the park
        double batteryNeeded = getDistanceToPark() / 100;
/*Check conditions first check if the day is not sunday, if its sunday go next or if its not then return false
,then check for rain, if its not raining then go next, and then check if we have enough battery, if all conditions are met
for the robot to go to the park return true */
        if (!world.isSunday()) {
            System.out.println("Cant go to the park because it is not sunday");
            return false;
        } else {

            if (world.getIsRaining()) {
                System.out.println(getName() + " cant go outside, because it is raining");
                return false;
            } else {

                if (getBatteryLevel() < batteryNeeded) {
                    System.out.println(getName() + " cant go to the park because it does not have enough battery");
                    System.out.println("Battery needed: " + batteryNeeded + "%, current: " + getBatteryLevel() + "%");
                    return false;
                }
            }
            return true;
        }
    }

    /*Kinda the same as what We wrote on canWalkToThePark() return false if its monday, return false if its raining,
    return false if the robot does not have enough battery, if none of the if statements are true, then just return true because the robot meets all the criteria, else return false */

    public boolean canDanceAtClub(World world) {

        if (world.isMonday()) {
            System.out.println(getName() + " cant go to the club, because the danceclub is closed on mondays");
            return false;
        } else {
            if (world.getIsRaining()) {
                System.out.println(getName() + " cant go to the club because it is raining");
                return false;
            } else {
                if (getBotType().equals("Clanker")) {
                    System.out.println(getName() + " cant go to the club because it is Clanker");
                    return false;
                } else {
                    if (getBatteryLevel() < 50) {
                        System.out.println(getName() + " cant go to the club because it needs at least 50% battery to dance");
                        return false;
                    }
                }
            }
        }
        System.out.println(getName() + " Can go to the club, because he meets all the criteria");
        return true;
    }
}
