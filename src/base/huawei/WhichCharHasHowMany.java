package base.huawei;

import java.util.Scanner;

public class WhichCharHasHowMany {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()) {
            int count = 0;
            String input = scanner.next();
            String whichChar = scanner.next();
            input = input.toLowerCase();
            whichChar = whichChar.toLowerCase();
            for(int i = 0; i < input.length(); i++) {
                if(String.valueOf(input.charAt(i)).equals(whichChar)) {
                    ++count;
                }
            }
            System.out.println(count);
        }

        scanner.close();
    }
}
