package base.huawei;

import java.util.HashMap;
import java.util.Scanner;

public class TongJiBuTongZiFuGeShu {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            //1
/*            HashMap<Character,Integer> hashMap = new HashMap<>();
            String str = sc.nextLine();
            int cnt=0;
            for(int i=0;i<str.length();i++){
                char c = str.charAt(i);
                if(c>=0&&c<=127)
                    hashMap.put(c,1);
            }
            for(int i:hashMap.values()){
                cnt+=i;
            }
            System.out.println(cnt);*/

            //2
            int cnt=0;
            int nums[] = new int[128];
            String str = sc.nextLine();
            for(int i=0;i<str.length();i++){
                int is = SumStrAscii(str.charAt(i)+"");
                if(is>=0&&is<=127)
                    nums[is]=1;
            }
            for (int i:nums){
                cnt+=i;
            }
            System.out.println(cnt);
        }
    }
    public static int SumStrAscii(String str){
        byte[] bytestr = str.getBytes();
        int sum = 0;
        for(int i=0;i<bytestr.length;i++){
            sum += bytestr[i];
        }
        return sum;
    }
}
