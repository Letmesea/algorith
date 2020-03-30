package base.huawei;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class MachineTest1 {
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        ArrayList<String> arrayList = new ArrayList<>();
        while (sc.hasNext()){
            String str = sc.nextLine();
            if ("".equals(str)){
                break;
            }
            if(isOk(str)){
                linkedHashSet.add(str);
            }else{
                arrayList.add(str);
            }
        }
        Iterator<String> iterator = linkedHashSet.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();
        for(String ss:arrayList){
            System.out.print(ss+" ");
        }

    }
    public static boolean isOk(String s){
        int c=0;
        for (int i=0;i<s.length();i++){
            if((s.charAt(i)>='0'&&s.charAt(i)<='9')||
                    (s.charAt(i)>='a'&&s.charAt(i)<='z')||
                    (s.charAt(i)>='A'&&s.charAt(i)<='Z')){
                c++;
            }else{
                return false;
            }
        }
        if(c==s.length())
            return true;
        return false;
    }
}
