package bank;

import java.math.BigInteger;

/*
                -----------BANK CURRENCY------------
       [1000_$HM]   | currency in denomination of 1000 shmekles
       [500_$HM]    | currency in denomination of 500 shmekles
       [100_$HM]    | currency in denomination of 100 shmekles
       [50_$HM]     | currency in denomination of 50 shmekles
       [10_$HM]     | currency in denomination of 10 shmekles
       [5_$HM]      | currency in denomination of 5 shmekles
       [1_$HM]      | currency in denomination of 1 shmekle

*/

class Money {
    private final int[] currency = {1, 5, 10, 50, 100, 500, 1000};  //валюта
    private BigInteger cash = new BigInteger("1000000000000");    //касса банка

    public void addCash(BigInteger add) {    //ДОБАВИТЬ ДЕНЕГ В КАССУ БАНКА
        System.out.println("Top up the cash register at: " + add + ".");
        cash = cash.add(add);
        System.out.println("Now the bank's cash desk is " + cash + " shmekles.");
    }

    public int userCash(int in, String cur) {      //собственная ВАЛЮТА банка
        int userEnter;
        if (cur.equals("[1000_$HM]")) {
            userEnter = in * currency[6];
            return userEnter;
        } else {
            if (cur.equals("[500_$HM]")) {
                userEnter = in * 500;
                return userEnter;
            } else {
                if (cur.equals("[100_$HM]")) {
                    userEnter = in * 100;
                    return userEnter;
                } else {
                    if (cur.equals("[50_$HM]")) {
                        userEnter = in * 50;
                        return userEnter;
                    } else {
                        if (cur.equals("[10_$HM]")) {
                            userEnter = in * 10;
                            return userEnter;
                        } else {
                            if (cur.equals("[5_$HM]")) {
                                userEnter = in * 5;
                                return userEnter;
                            } else {
                                if (cur.equals("[1_$HM]")) {
                                    userEnter = in;
                                    return userEnter;
                                } else {
                                    System.out.println("Oops! You have not indicated the currency of our bank.\n" +
                                            "Try again.");
                                    userEnter = -1;
                                    return userEnter;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


