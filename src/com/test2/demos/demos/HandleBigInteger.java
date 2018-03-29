package com.test2.demos.demos;

/**
 * Created by thinkpad on 2018/1/24.
 */

import java.math.*;

public class HandleBigInteger {
    public static void main(String args[]) {
        BigInteger n1 = new BigInteger("987654321987654321987654321"),
                n2 = new BigInteger("123456789123456789123456789"),
                result = null;
        //1. n1和n2做加法运算
        result = n1.add(n2);
        System.out.println("和"+result.toString());
        //2. n1和n2做减法运算
        result = n1.subtract(n2);
        System.out.println("差"+result.toString());
        //3. n1和n2做乘法运算
        result = n1.multiply(n2);
        System.out.println("积"+result.toString());
        //4. n1和n2做除法运算
        result = n1.divide(n2);
        System.out.println("商"+result.toString());
        BigInteger m = new BigInteger("1968957"),
                COUNT = new BigInteger("0"),
                ONE =  new BigInteger("1"),
                TWO = new BigInteger("2");
        System.out.println(m.toString()+"的因子有：");
        for(BigInteger i = TWO; i.compareTo(m) < 0; i = i.add(ONE)) {
            if((n1.remainder(i).compareTo(BigInteger.ZERO)) == 0) {
                COUNT = COUNT.add(ONE);
                System.out.print(" "+i.toString());
            }
        }
        System.out.println("");
        System.out.println(m.toString() + "一共有" +COUNT.toString() + "个因子");

        //计算大整数的阶乘
        BigInteger bi = new BigInteger("99");
        BigInteger sum = new BigInteger("1");
        for(BigInteger i = ONE; i.compareTo(bi) <= 0; i=i.add(ONE)) {
            sum = sum.multiply(i);
        }
        System.out.println(bi.toString()+"的阶乘是："+sum.toString());

        //计算1+99999999项的和
        BigInteger bi2 = new BigInteger("99999999");
        BigInteger sum2 = new BigInteger("0");
        for(BigInteger i = ONE; i.compareTo(bi2) <= 0; i=i.add(ONE)) {
            sum2 = sum2.add(i);
        }
        System.out.println("从1加到："+bi2.toString()+"的和是："+sum2.toString());

    }
}
