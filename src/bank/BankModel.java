package bank;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

class BankModel {

    public void model() {
        BankUser startingUsers = new BankUser();
        startingUsers.AddUser("Rick Sanchez");
        startingUsers.AddUser("Morty Smith");
        startingUsers.AddUser("Jerry Smith");
        startingUsers.AddUser("Cronenberg Rick");
        startingUsers.AddUser("Summer Smith");
        startingUsers.AddUser("Jessica");
        startingUsers.AddUser("Rick Sanchez");
        startingUsers.AddUser("Morty Smith");
        startingUsers.AddUser("Jerry Smith");
        startingUsers.AddUser("Cronenberg Rick");
        startingUsers.AddUser("Summer Smith");
        startingUsers.AddUser("Jessica");

        ArrayList<String> newUsers = new ArrayList<>();
        newUsers.add("Beth Smith");
        newUsers.add("Squanchy");
        newUsers.add("King Flippy Nips");
        newUsers.add("Mr. Meeseeks");
        newUsers.add("Birdperson");
        newUsers.add("Unity");
        newUsers.add("Abradolf Lincler");

        Random rand = new Random();
        Money cash = new Money();
        String[] currency = {"[1000_$HM]", "[500_$HM]", "[100_$HM]", "[50_$HM]", "[10_$HM]", "[5_$HM]", "[1_$HM]"};
        for (int i = 0; i < 24 * 365; i += rand.nextInt(120) + 1) {

            if (i % (24 * 30) == 0 && i != 0) {            //проценты каждый месяц
                System.out.println("\n\n------------------ACCRUAL OF INTEREST------------------\n");
                startingUsers.percent();
            }

            int choice = rand.nextInt(8);
            switch (choice) {
                case 1 -> {
                    System.out.println("\n------ADDING A USER------");
                    startingUsers.AddUser(newUsers.get(rand.nextInt(4)));
                }
                case 2 -> {
                    System.out.println("\n------DELETING A USER------");
                    startingUsers.DeleteUser(rand.nextInt(newUsers.size()));
                }
                case 3 -> {
                    System.out.println("\n------CREATING A DEPOSIT------");
                    startingUsers.CreateDeposit(rand.nextInt(newUsers.size()), rand.nextInt(7));
                }
                case 4 -> {
                    System.out.println("\n------DELETING A DEPOSIT------");
                    startingUsers.DeleteDeposit(rand.nextInt(newUsers.size()), rand.nextInt(7));
                }
                case 5 -> {
                    System.out.println("\n------ADD MONEY TO DEPOSIT------");
                    startingUsers.AddM(rand.nextInt(newUsers.size()), rand.nextInt(7), currency[rand.nextInt(6)], rand.nextInt(6));
                }
                case 6 -> {
                    System.out.println("\n------WITHDRAW MONEY FROM DEPOSIT------");
                    startingUsers.SubM(rand.nextInt(newUsers.size()), rand.nextInt(7), currency[rand.nextInt(6)], rand.nextInt(6));
                }
                case 7 -> {
                    System.out.println("\n------ADD BANK CASH------");
                    cash.addCash(BigInteger.valueOf(rand.nextInt(10000000)));
                }
            }
        }
    }
}