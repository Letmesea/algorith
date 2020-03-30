package base.huawei;

import java.util.Scanner;

public class LastWordLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()) {
            String input = scanner.nextLine();
            String[] array = input.split(" ");
            System.out.println(array[array.length-1].length());
        }

        scanner.close();
    }
}
