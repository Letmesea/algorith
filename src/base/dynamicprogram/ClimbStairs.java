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
        int res = climbStairs.climbStairs(1000);
        int res1 = climbStairs.cnm(4,2).intValue();
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
