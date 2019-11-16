package test;

import java.util.Random;

public class AddOne {
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if(digits[i]==9){
                if(i!=0){
                    digits[i]=0;
                }else{
                    int[] b = new int[digits.length+1];
                    b[0] = 1;
                    return b;
                }
            }else{
                digits[i]++;
                return digits;
            }
        }
        return digits;
    }
    public static void main(String[] args) {
        int[] a = new int[100000000];
        Random random = new Random();
        for(int i=0;i<100000000;i++){
            a[i] = 9;
        }
        if(a[0]==0){
            a[0] = 9;
        }
       int[] aa =  plusOne(a);
        System.out.print(111);
    }
}
