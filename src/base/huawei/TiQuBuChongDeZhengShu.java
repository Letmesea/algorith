package base.huawei;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class TiQuBuChongDeZhengShu {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<Character,Integer> linkedHashMap = new LinkedHashMap<>();
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            for (int i=str.length()-1;i>=0;i--){
                linkedHashMap.put(str.charAt(i),i);
            }
            int ans = 0;
            Iterator<Character> integerIterator = linkedHashMap.keySet().iterator();
            int k=0;
            int k_ = 1;
            while (integerIterator.hasNext()){
                char c = integerIterator.next();
                if(c!='+'&&c!='-'){
                    if(k==0&&c=='0'){
                        k++;continue;
                    }else{
                        int cn = Integer.valueOf(c+"");
                        if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && cn > 7)) {
                            System.out.println(0);
                        }
                        if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && cn < -8)){
                            System.out.println(0);
                        }
                        ans = ans*10+cn;
                    }
                }else{
                    k_=c=='+'?k_:-1;
                }
                k++;
            }
            System.out.println(ans*k_);
        }
    }
    //整数翻转
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }
}
