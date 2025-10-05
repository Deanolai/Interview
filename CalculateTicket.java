import java.util.Scanner;
/**
 * 机票价格计算程序 - 根据月份和舱位类型计算折扣后的票价
 */
public class CalculateTicket {
    // 定义各种情况下的折扣率
    private static final double PEAK_FIRST_CLASS = 0.9;      // 旺季头等舱打9折
    private static final double PEAK_ECONOMY = 0.85;          // 旺季经济舱打85折
    private static final double OFF_PEAK_FIRST_CLASS = 0.7;   // 淡季头等舱打7折
    private static final double OFF_PEAK_ECONOMY = 0.65;      // 淡季经济舱打65折

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 获取用户输入的基本信息
        System.out.println("请输入机票原价：");
        double ticket = input.nextDouble();
        System.out.println("请输入月份（1-12）：");
        int month = input.nextInt();
        System.out.println("请输入舱位类型（头等舱/经济舱）：");
        String seatType = input.next();
        // 先检查月份是否合法
        if (month < 1 || month > 12) {
            System.out.println("您输入的月份不合规");
            input.close();
            return; // 月份不对就直接结束程序
        }

        // 根据月份判断是旺季还是淡季，然后计算折扣
        if (month > 4 && month < 10) {
            System.out.print("旺季"); // 5-9月是旺季
            ticket = calculateTicketPrice(ticket, seatType, PEAK_FIRST_CLASS, PEAK_ECONOMY);
        } else {
            System.out.print("淡季"); // 其他月份是淡季
            ticket = calculateTicketPrice(ticket, seatType, OFF_PEAK_FIRST_CLASS, OFF_PEAK_ECONOMY);
        }

        // 输出最终价格
        System.out.print("票价为：" + ticket);
        input.close(); // 记得关闭扫描器，好习惯
    }

    /**
     * 计算实际票价的方法
     * @param ticket 原价
     * @param seatType 舱位类型
     * @param firstClassDiscount 头等舱折扣
     * @param economyDiscount 经济舱折扣
     * @return 折后价格
     */
    public static double calculateTicketPrice(double ticket, String seatType, 
                                             double firstClassDiscount, double economyDiscount) {
        // 根据舱位类型应用不同的折扣
        if ("头等舱".equals(seatType)) {
            return ticket * firstClassDiscount; // 头等舱价格计算
        } else if ("经济舱".equals(seatType)) {
            return ticket * economyDiscount; // 经济舱价格计算
        } else {
            // 如果舱位类型输入不对，就按原价算并提示用户
            System.out.println("您输入的舱位类型不合规");
            return ticket;
        }
    }

}
