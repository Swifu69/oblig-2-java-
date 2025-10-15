//Gruppe: 49 Studenter: Kasper André Larsen: S375151 og Johan Sebastian Saire Borgersen: josai3142
//imported arrays so i can use array methods

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Creating a world object and setting the default settings
        World world = new World(1, false);


        //Made 3 robots with different specs
        Robot Megatron = new Robot("Megatron", 40
                , 2000, "Decepticon", "Ryzen 9 7900x3d", "Kali Linux");
        Robot OptimusPrime = new Robot("Optimus Prime", 100
                , 2000, "Autobot", "Intel Core Ultra 9 285", "Windows 11 Pro Home");
        Robot ChatGPT = new Robot("Open AI Chat GTP", 1
                , 1000, "Clanker", "Snapdragon 8 Elite", "Android 16");
        Robot Dancatron = new Robot("Dancatron 4000", 80
                , 1500, "B-Bot", "Snapdragon 8 Elite", "Android 16");


        //array with robot objects
        Robot[] Robots = {Megatron, OptimusPrime, ChatGPT, Dancatron};

        for (Robot robot : Robots) {
            System.out.println("Hello my name is " + robot.getName() + ". My battery level is at " + robot.getBatteryLevel() + "%. I live " + robot.getDistanceToPark() + "m away from the park!, and my bot type is " + robot.getBotType() + "!");
            robot.reportStatus();
        }

        for (int i = 0; i < 14; i++) {
            System.out.println("\n======================================");
            System.out.println("Day: " + world.getSavedDay() + ": " + world.getDay(world.getSavedDay()));
            System.out.println("\n======================================");


            boolean raining = world.getIsRaining();
            System.out.println("Weather: " + (raining ? "Its raining outside" : "The weather is clear!"));

            for (Robot robot : Robots) {
                System.out.println("\n-- Testing " + robot.getName() + " --");

                robot.canWalkToThePark(world);
                robot.canDanceAtClub(world);
            }
            world.nextDay();
        }
    }
}


