package base.huawei;

import java.util.Scanner;

public class ZuoBiaoYiDong {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            String strs[] = str.split(";");
            int x=0,y=0;
            String reg = "WASD";
            for(int i=0;i<strs.length;i++){
                if(strs[i].length()>=2&&strs[i].length()<=3){
                    String m = strs[i].substring(0,1);
                    if(reg.contains(m)){
                        String s = strs[i].substring(1);
                        char[] c = s.toCharArray();
                        if(c[0]>=48&&c[0]<=57){
                            if(c.length>1){
                                if(c[1]<48||c[1]>57){
                                    continue;
                                }
                            }
                            if("W".equals(m)){
                                y+=Integer.parseInt(s);
                            }else if("A".equals(m)){
                                x-=Integer.parseInt(s);
                            }else if("S".equals(m)){
                                y-=Integer.parseInt(s);
                            }else{
                                x+=Integer.parseInt(s);
                            }
                        }
                    }

                }
            }
            System.out.println(x+","+y);
        }
    }
}
