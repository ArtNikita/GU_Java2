package hw1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Runnable> participants = new ArrayList<>();
        participants.add(new Human(100, 1.5, 5));
        participants.add(new Robot(300, 2, 10));
        participants.add(new Cat(200, 1.7, 10));
        participants.add(new Human(170, 1.8, 7));

        ArrayList<Object> obstacles = new ArrayList<>();
        obstacles.add(new Treadmill(30));
        obstacles.add(new Wall(1));
        obstacles.add(new Treadmill(40));
        obstacles.add(new Wall(1.4));
        obstacles.add(new Treadmill(100));
        obstacles.add(new Wall(1.8));

        for (int i = 0; i < participants.size(); i++) {
            System.out.println("\n" + (i+1) + " participant.\n");
            int tempCounter = 0;
            for (Object obstacle : obstacles) {
                if (obstacle instanceof Wall){
                    if (!((Wall) obstacle).take((Jumpable) participants.get(i))){
                        System.out.println("Participant lost the race.. Wall was too high...\nLucky next time!");
                        break;
                    }
                    tempCounter++;
                } else {
                    if (!((Treadmill) obstacle).take(participants.get(i))){
                        System.out.println("Participant lost the race.. Treadmill was too long...\nLucky next time!");
                        break;
                    }
                    tempCounter++;
                }
            }
            if (tempCounter == obstacles.size()) System.out.println("\nParticipant overcame the race!!!!!!\nCongratulations!!!!!!! :D");
        }
    }
}
