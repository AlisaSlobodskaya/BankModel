package bank;

import java.util.HashMap;

class BankUser {                //КЛАСС для работы с пользователем
    HashMap<Integer, String> NumAndName = new HashMap<>();      //ключ-порядковый номер пользователя, значение-имя
    private int num;
    private final HashMap<String, Deposits> map = new HashMap<>();    //ключ-имя, значение-переменная типа Deposits

    public void AddUser(String newName) {                //ДОБАВИТЬ ПОЛЬЗОВАТЕЛЯ (имя, порядковый номер)
        if (!NumAndName.containsValue(newName)) {       //проверка на повторное добавление
            if (!NumAndName.containsValue("delete")) {  //заменить удаленного пользователя
                num += 1;
                NumAndName.put(num, newName);
                map.put(newName, new Deposits(newName));
                map.get(newName).createDeposits(1);     //создать 1 депозит для нового пользователя
            } else {
                for (int i = 0; i <= num; i++) {
                    if (NumAndName.get(i) == null || NumAndName.get(i).equals("delete")) {
                        NumAndName.replace(i, newName);
                        break;
                    }
                }
            }
            System.out.println("User [" + newName + "] ADDED to the system.");
        } else {
            System.out.println("User [" + newName + "] is already in the system.");
        }
    }

    public void DeleteUser(int UserNum) {    //УДАЛИТЬ ПОЛЬЗОВАТЕЛЯ
        if (!NumAndName.get(UserNum).equals("delete") & NumAndName.get(UserNum) != null) {    //проверка на уже удаленного пользователя
            String name = NumAndName.get(UserNum);
            System.out.println("User [" + name + "] DELETED from the system.");
            NumAndName.replace(UserNum, "delete");
        } else
            System.out.println("The user has already been deleted from the system");
    }

    public void CreateDeposit(int UserNum, int quantity) {   //СОЗДАТЬ ДЕПОЗИТ(Ы) пользователю
        String key = NumAndName.get(UserNum);
        Deposits a = map.get(key);
        if (a == null || key.equals("delete") || key == null)         //проверка на несуществующего пользователя
            System.out.println("Sorry! User does not exist :(");
        else {
            a.createDeposits(quantity);
            System.out.println("User: " + key);
        }
    }

    public void DeleteDeposit(int UserNum, int quantity) {     //УДАЛИТЬ ДЕПОЗИТ_ пользователю
        String key = NumAndName.get(UserNum);
        Deposits a = map.get(key);
        if (a == null || key.equals("delete") || key == null)
            System.out.println("Sorry! User does not exist :(");
        else {
            a.deleteDeposits(quantity);
            System.out.println("User: " + key);
        }
    }

    public void AddM(int UserNum, int DepNum, String cur, int denom) {      //ПОЛОЖИТЬ ДЕНЬГИ НА ДЕПОЗИТ пользователя
        String key = NumAndName.get(UserNum);
        Deposits a = map.get(key);
        if (a == null || key.equals("delete") || key == null)
            System.out.println("Sorry! User does not exist :(");
        else {
            a.addMoney(DepNum, cur, denom);
            System.out.println("User: " + key);
        }
    }

    public void SubM(int UserNum, int DepNum, String cur, int denom) {      //СНЯТЬ ДЕНЬГИ С ДЕПОЗИТА пользователя
        String key = NumAndName.get(UserNum);
        Deposits a = map.get(key);
        if (a == null || key.equals("delete") || key == null)
            System.out.println("Sorry! User does not exist :(");
        else {
            a.subMoney(DepNum, cur, denom);
            System.out.println("User: " + key);
        }
    }

    public void percent() {           //ЕЖЕМЕСЯЧНОЕ НАЧИСЛЕНИЕ ПРОЦЕНТОВ
        for (int i = 0; i < NumAndName.size(); i++) {
            if (!NumAndName.get(i).equals("delete")) {        //проверка на удаленного пользователя
                Deposits a = map.get(NumAndName.get(i));
                if (a != null) {
                    a.percent();
                } else
                    continue;
            } else
                continue;
        }
    }

    public void getUserList() {
        System.out.println(NumAndName);
    }
}
