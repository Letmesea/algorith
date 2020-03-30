package base.huawei;

import java.util.*;

public class ZiFuChuanDeLianJieZuiChangLuJing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();
        while (sc.hasNext()) {
            int len = sc.nextInt();
            for (int i=0;i<len;i++){
                arrayList.add(sc.next());
            }
            Collections.sort(arrayList, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            for(String s:arrayList){
                System.out.println(s);
            }
        }
    }
}
