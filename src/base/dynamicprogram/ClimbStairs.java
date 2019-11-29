package base.dynamicprogram;

import java.math.BigInteger;

/**
 * @author Letmesea
 * @title: ClimbStairs
 * @projectName algorith
 * @description: 爬楼梯
 * @date 2019/11/2711:03
 */
public class ClimbStairs {

    public static void main(String[] args){
        ClimbStairs climbStairs = new ClimbStairs();
//        int res = climbStairs.climbStairs(5);
//        int res1 = climbStairs.cnm(4,2).intValue();
        int res = climbStairs.climbStairs1(10000000);
    }

    /**
     * 斐波那契(爬楼梯)
     * @param n
     * @return
     */
    public int climbStairs1(int n){
        int f0=0,f1 = 1,f2=1;
        if(n==0){
            return f1;
        }
        if(n==1){
            return f2;
        }
        for (int i=1;i<=n;i++){
            f2 = f0+f1;
            f0=f1;
            f1 = f2;
        }
        return f2;
    }
    public int climbStairs(int n){
        int nf2 = n/2;
        long sum =1;
        while (nf2>0){
            int nf1=n-nf2*2;
//            sum=sum+(factorial(nf1+nf2).divide(factorial(nf2).multiply(factorial(nf1)))).intValue();
            sum = sum+ (cnm(nf1+nf2,nf2).multiply(cnm(nf1+nf2-nf2,nf1))).intValue();
            nf2--;
        }
        return (int)sum;
    }
    BigInteger cnm(int n,int m)
    {
        BigInteger s = BigInteger.ONE;
        int k = 1;
        if(m > n/2)
            m = n-m;
        for(int i=n-m+1;i<=n;i++)
        {
//            s *= (long)i;
            s = s.multiply(BigInteger.valueOf(i));
            while(k<=m && s.mod(BigInteger.valueOf(k)).intValue() == 0)
            {
//                s /= (long)k;
                s = s.divide(BigInteger.valueOf(k));
                k++;
            }
        }
        return s;
    }


    /**
     * 阶乘
     * @param n
     * @return
     */
    public BigInteger factorial(int n){
        BigInteger bigInteger = BigInteger.ONE;
        while (n>0){
            bigInteger = bigInteger.multiply(BigInteger.valueOf(n));
            n--;
        }
        return bigInteger;
    }
}
