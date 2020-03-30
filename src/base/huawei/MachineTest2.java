package base.huawei;

import java.util.ArrayList;
import java.util.Scanner;

public class MachineTest2 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (scanner.hasNext()){
            int num = scanner.nextInt();
            if(num==0){
                break;
            }

            if(num==1||num==2){
                arrayList.add(0);
                continue;
            }
            int cnt1=2,cnt2=num-cnt1,count=0;
            while (cnt1<=num-2&&cnt2>=2){

                if(isZhi(cnt1)&&isZhi(cnt2)){
                    count++;
                }
                if(num%2==0){
                    //偶
                    if(cnt1==cnt2)
                        break;
                }else{
                    if(cnt1-cnt2==1||cnt1-cnt2==-1){
                        break;
                    }
                }
                cnt1++;cnt2--;
            }
            arrayList.add(count);
//            arrayList.add(count);
        }
        for (int i = 0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
        System.out.println("end");
    }
    public static boolean isZhi(int n){
        if(n==2) return true;
        if (n<2||n%2==0) return false;
        for (int i=2;i<n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
