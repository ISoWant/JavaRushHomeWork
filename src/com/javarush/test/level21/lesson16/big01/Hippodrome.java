package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

public class Hippodrome {
    public static Hippodrome game;
    private ArrayList<Horse> horses = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome();
        Horse zarplata = new Horse("Зарплата", 3.0, 0.0);
        Horse rashody = new Horse("Расходы", 3.0, 0.0);
        Horse bobik = new Horse("Бобик", 3.0, 0.0);

        game.getHorses().add(zarplata);
        game.getHorses().add(rashody);
        game.getHorses().add(bobik);
        game.run();
        game.printWinner();
    }

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move(){
        for (Horse horse : horses) {
            horse.move();
        }
    }
    public void print(){
        for (Horse horse : horses) {
            horse.print();
            System.out.println();
            System.out.println();
        }
    }

    public Horse getWinner() {
        if (horses != null) {
            Horse winner = horses.get(0);


            for (Horse horse : horses) {
                if (winner.getDistance() < horse.getDistance())
                    winner = horse;
            }
            return winner;
        } else return null;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

}
