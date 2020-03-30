package base.huawei;

import com.sun.xml.internal.ws.util.StringUtils;

import java.io.BufferedReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            StringBuilder stringBuilder = new StringBuilder(str);
            String ss = stringBuilder.reverse().toString();
        }
    }
}
