import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;


/**
 * @author IronSid
 * @create 2021-07-02 23:09
 */
public class Main {
    Commodity[] commodities = new Commodity[6];

    /**
     * 余额
     */
    int balance;

    /**
     * 钱盒中不同面额钱的数量
     * {1元张数, 2元张数, 5元张数, 10元张数}
     */
    int[] cashs = new int[4];

    /**
     * 面额数字，与cashes对应
     */
    int[] denomination = {1, 2, 5, 10};

    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        Main main = new Main();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.length() == 0) continue;
            String[] commands = line.split(";");
            for (String command : commands) {
                if (command.length() == 0) continue;
                //读入指令，进行操作
                switch (command.charAt(0)) {
                    case 'r':
                        main.initializate(command.substring(2));
                        //初始化余额
                        main.balance = 0;
                        break;
                    case 'p':
                        main.pay(command.substring(2));
                        break;
                    case 'b':
                        main.buy(command.substring(2));
                        break;
                    case 'c':
                        main.refund();
                        break;
                    case 'q':
                        main.quiry(command);
                        break;
                }
            }
        }
    }

    void initializate(String command) {
        String[] number = command.split("[- ]");
        int[] cost = {2, 3, 4, 5, 8, 6};
        for (int i = 0; i < 6; i++) {
            commodities[i] = new Commodity("A" + (i + 1), parseInt(number[i]), cost[i]);
        }
        for (int i = 6; i < 10; i++) {
            cashs[i - 6] = parseInt(number[i]);
        }
        out.println("S001:Initialization is successful");
    }

    void pay(String command) {
        int paid = parseInt(command);
        int index = 0;
        for (; index < denomination.length; index++) {
            if (denomination[index] == paid)
                break;
        }
        //没有匹配的面额
        if (index == denomination.length) {
            out.println("E002:Denomination error");
            return;
        }
        //零钱不足
        if (cashs[0] + cashs[1] * 2 < paid) {
            out.println("E003:Change is not enough, pay fail");
            return;
        }
        //无剩余商品
        if (isSoldOut(commodities)) {
            out.println("E005:All the goods sold out");
            return;
        }
        //投币成功
        balance += paid;
        cashs[index]++;
        out.println("S002:Pay success,balance=" + balance);
    }

    void buy(String name) {
        Commodity c = getCommdity(name, commodities);
        if (c == null) {
            out.println("E006:Goods does not exist");
            return;
        }
        if (c.number == 0) {
            out.println("E007:The goods sold out");
            return;
        }
        if (balance < c.cost) {
            out.println("E008:Lack of balance");
            return;
        }
        //购买成功，余额减价格，数量减一
        balance -= c.cost;
        c.number--;
        out.println("S003:Buy success,balance=" + balance);
    }

    /*
    3. 退币原则 ：
    1) 根据系统存钱盒内钱币的 信息 ，按钱币总张数最少的原则进行退币。
    2) 如果因零钱不足导致不能退币，则尽最大可能退币，以减少用户损失。
    例如：假设存钱盒内只有4张2元，无其它面额钱币。如果需要退币7元，
    系统因零钱不足无法退币，则继续尝试退币6元，最终系统成功退币3张2元,用户损失1元钱币。
     */
    void refund() {
        if (balance == 0) {
            out.println("E009:Work failure");
            return;
        }
        //退币张数
        int[] refundCashs = new int[cashs.length];
        //先退面额大的币
        for (int i = cashs.length - 1; i >= 0; i--) {
            //钱盒该面额的钱没了就跳过
            if(cashs[i]==0){
                break;
            }
            //若有，则尽量多得用这种面额退币
            while(cashs[i]>0&&balance>=denomination[i]){
                cashs[i]--;
                balance-=denomination[i];
                refundCashs[i]++;
            }
        }
        //余额归零，输出找零
        balance = 0;
        for (int i = 0; i < 4; i++) {
            out.println(denomination[i] + " yuan coin number=" + refundCashs[i]);
        }
    }

    void quiry(String command) {
        switch (command) {
            case "q 0":
                sort(commodities);
                for (Commodity commodity : commodities) {
                    out.println(commodity.toString());
                }
                break;
            case "q 1":
                for (int i = 0; i < 4; i++) {
                    out.println(denomination[i] + " yuan coin number=" + cashs[i]);
                }
                break;
            default:
                out.println("E010:Parameter error");
        }
    }

    void sort(Commodity[] c) {
        for (int i = 0; i < c.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < c.length - 1 - i; j++) {
                if (compare(c[j], c[j + 1]) > 0) {
                    flag = false;
                    Commodity temp = c[j];
                    c[j] = c[j + 1];
                    c[j + 1] = temp;
                }
            }
            if (flag) break;
        }
    }

    int compare(Commodity a, Commodity b) {
        //比较number,若number相等，则比较商品的字典顺序
        if (a.number != b.number)
            //number大的应该排在前
            return b.number - a.number;
        return a.name.compareTo(b.name);
    }

    boolean isSoldOut(Commodity[] c) {
        for (Commodity commodity : c) {
            if (commodity.number != 0)
                return false;
        }
        return true;
    }

    /**
     * 根据指定的商品名从商品数组中获取商品
     *
     * @param name 指定商品的名字
     * @param c    商品数组
     * @return 名字对应的商品，若没找到则返回null
     */
    Commodity getCommdity(String name, Commodity[] c) {
        for (Commodity commodity : c) {
            if (name.equals(commodity.name))
                return commodity;
        }
        return null;
    }
}

class Commodity {
    String name;
    int number;
    int cost;

    public Commodity(String name, int number, int cost) {
        this.name = name;
        this.number = number;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return this.name + " " + this.cost + " " + this.number;
    }
}
