import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()){

            int n = scanner.nextInt();

            int[] array = new int[3*n];
            long sum = 0;
            for (int i = 0; i <array.length ; i++) {
                array[i] = scanner.nextInt();
            }
            Arrays.sort(array);
            for (int i = 0; i < n ; i++) {
                sum+=array[array.length - 2*(i+1)];
            }
            System.out.println(sum);
        }
    }
}


