package base.huawei;

import java.util.Scanner;

public class PrintStringWith8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()) {
            StringBuffer buffer = new StringBuffer();
            String input = scanner.next();
            if(input.length() == 0) {
                continue;
            }
            if(input.length() < 8) {
                int zeroCount = 8 - input.length();
                buffer.append(input);
                for(int i = 0; i < zeroCount; i++) {
                    buffer.append("0");
                }
                System.out.println(buffer.toString());
            } else if(input.length() > 8) {
                int beginIndex = 0;
                while(input.length() - beginIndex > 8) {
                    System.out.println(input.substring(beginIndex, beginIndex + 8));
                    beginIndex += 8;
                }
                // 若input.length() - beginIndex == 8则说明该字符串的长度为8的倍数，恰好可以整分为长度为8的字符串输出
                // 无需在后面追加0
                int zeroCount = 8 - (input.length() - beginIndex);
                buffer.append(input.substring(beginIndex));
                for(int i = 0; i < zeroCount; i++) {
                    buffer.append("0");
                }

                System.out.println(buffer.toString());
            } else {
                System.out.println(input);
            }
        }

        scanner.close();
    }
}
