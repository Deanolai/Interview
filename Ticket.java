import java.util.Scanner;
public class Ticket {
    private static final double PEAK_FIRST_CLASS = 0.9;
    private static final double PEAK_ECONOMY = 0.85;
    private static final double OFF_PEAK_FIRST_CLASS = 0.7;
    private static final double OFF_PEAK_ECONOMY = 0.65;

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入机票原价：");
        double ticket = input.nextDouble();
        System.out.println("请输入月份（1-12）：");
        int month = input.nextInt();
        System.out.println("请输入舱位类型（头等舱/经济舱）：");
        String seatType = input.next();

        if (month < 1 || month > 12) {
            System.out.println("您输入的月份不合规");
            input.close();
            return;
        }

        if (month > 4 && month < 10) {
            System.out.print("旺季");
            ticket = calculateTicketPrice(ticket, seatType, PEAK_FIRST_CLASS, PEAK_ECONOMY);
        } else {
            System.out.print("淡季");
            ticket = calculateTicketPrice(ticket, seatType, OFF_PEAK_FIRST_CLASS, OFF_PEAK_ECONOMY);
        }

        System.out.print("票价为：" + ticket);
        input.close();
    }

    public static double calculateTicketPrice(double ticket, String seatType, double firstClassDiscount, double economyDiscount) {
        if ("头等舱".equals(seatType)) {
            return ticket * firstClassDiscount;
        } else if ("经济舱".equals(seatType)) {
            return ticket * economyDiscount;
        } else {
            System.out.println("您输入的舱位类型不合规");
            return ticket;
        }
    }
}