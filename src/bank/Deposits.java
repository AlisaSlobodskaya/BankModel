package bank;

import java.util.ArrayList;
import java.util.Scanner;

class Deposits {
    public String name;
    private final ArrayList<Double> deposits = new ArrayList<>();      //список с депозитами пользователя

    public Deposits(String n) {
        name = n;
    }

    public void createDeposits(int quantity) {
        int a = deposits.size() + quantity;
        if (quantity < 6 & quantity > 0 & a < 6 & a > 0) {   //проверка на кол-во депозитов (макс=5)
            int num;
            for (int i = 0; i < quantity; i++) {
                deposits.add(0.0);
                num = i + 1;
                System.out.println(num + " deposit contains " + deposits.get(i) + " shmekles.");
            }
        } else {
            System.out.println("RULE No. 4543835835353\n" +
                    "| You can create no more than 5 deposits in our bank! |\n" +
                    "| Try again                                           |");
        }
    }

    public void percent() {        //ПРОЦЕНТНАЯ СТАВКА
        for (int i = 0; i < deposits.size(); i++) {
            double a = deposits.get(i) / 0.1;
            deposits.set(i, a);
        }
    }

    public void deleteDeposits(int num) {
        int in2 = deposits.size();
        if (num > 0) {             //проверка на корректно введенный номер депозита (от 1 до 5)
            if (num <= in2) {    //проверка на существующий у пользователя депозит
                num -= 1;
                if (deposits.get(num) != 0)
                    System.out.println("Oops! There is money on your deposit." +
                            "\nWithdraw it and try again");
                else {
                    deposits.remove(num);
                    num += 1;
                    System.out.println(num + " deposit deleted successfully!");
                }
            } else {
                System.out.println("You don't have that many deposits!\n" + "Try again.");
            }
        } else
            System.out.println("Incorrect input.");
    }

    public void addMoney(int num, String a, int b) {
        int in2 = deposits.size();
        if (num > in2 || num < 1) {         //проверка на существующий у пользователя депозит
            System.out.println("Sorry! The deposit does not exist :(");
        } else {
            Money in = new Money();
            Scanner input = new Scanner(System.in);
            num -= 1;
            int q1 = in.userCash(b, a);
            if (q1 != -1) {
                double q = deposits.get(num) + q1;
                deposits.set(num, q);
                int num1 = num + 1;
                System.out.println(q1 + " shmekle(s) are(is) credited to your "
                        + num1 + " account."
                        + "\nNow on your account: " + deposits.get(num) + " $HM");
            } else
                System.out.println("Incorrect input.");
        }
    }

    public void subMoney(int num, String a, int b) {          //снять деньги с депозита
        int in2 = deposits.size();
        if (num > in2 || num < 1) {          //проверка на существующий у пользователя депозит
            System.out.println("Sorry! The deposit does not exist :(");
        } else {
            Money in = new Money();
            Scanner input = new Scanner(System.in);
            num -= 1;
            int q1 = in.userCash(b, a);
            if (q1 != -1) {
                double q = deposits.get(num) - q1;
                deposits.set(num, q);
                if (deposits.get(num) < 0) {
                    System.out.println("You don't have that much money. You are a beggar..." +
                            "\nEnter an amount less and try again!");
                    q = deposits.get(num) + q1;
                    deposits.set(num, q);
                } else {
                    int r = num + 1;
                    System.out.println(q1 + " shemeckle(s) have(has) been withdrawn from your "
                            + r + " account."
                            + "\nNow on your account: " + deposits.get(num) + " $HM");
                }
            } else
                System.out.println("Incorrect input.");
        }
    }
}

