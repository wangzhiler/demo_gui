package com.test2.demos.demos;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by thinkpad on 2018/1/24.
 */
public class ComparePrice {
    public static void main(String [] args){
        String menu="北京烤鸭:189元 西芹炒肉:12.9元 酸菜鱼:69元 铁板牛柳:32元";
        //1. Scanner类创建scanner,将menu传递给构造方法的参数
        Scanner scanner=new Scanner(menu);
        String regex="[^0123456789.]+";
        //scanner调用useDelimiter(String regex),将regex传递给该方法的参数
        scanner.useDelimiter(regex);
        double sum=0;
        while(scanner.hasNext()){
            try{
                //3. scaner调用nextDouble()返回数字单词
                double price=scanner.nextDouble();
                sum=sum+price;
//                System.out.println(price);
            }catch(InputMismatchException e){
                String t=scanner.next();
            }
        }
//        System.out.println("菜单总价格"+sum+"元");

        String str="中央电视台:www.cctv.com 清华大学:www" +
                ".tsinghua.edu.cn 音乐网站:www.violin.com";
        Scanner scan=new Scanner(str);
        regex="[^(http//|www)\56?\\w+\56{1}\\w+\56{1}\\p{Alpha}]+";
        scan.useDelimiter(regex);
        while(scan.hasNext()){
            try{
                String x=scan.next();
                System.out.println(x);
            }catch(InputMismatchException e){
                String t=scan.next();
            }
        }


    }
}







