import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class ss {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < T; i++) {
            String[] dateStr = scanner.nextLine().split("-");
            int year = Integer.parseInt(dateStr[0]);
            int month = Integer.parseInt(dateStr[1]);
            int dayOfMonth = Integer.parseInt(dateStr[2]);
            LocalDate birthDate = LocalDate.of(year, month, dayOfMonth);
            LocalDate now = LocalDate.now();
            LocalDate age18Birthday = birthDate.plusYears(18);
            if (age18Birthday.isAfter(now)) {
                System.out.println("-1");
            } else {
                long days = birthDate.until(age18Birthday, ChronoUnit.DAYS);
                System.out.println(days);
            }
        }
    }
}