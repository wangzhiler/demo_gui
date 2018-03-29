package com.test2.demos.demos;

import static java.lang.Long.toBinaryString;
import static java.lang.Long.toHexString;
import static java.lang.Long.toOctalString;

/**
 * Created by thinkpad on 2018/1/24.
 */


public class FindMess {
    public static void main(String []args){
        try {
            String mess = "姓名:张三 出生时间:1989.10.16. 个人网站:http://www.zhang.com."
                    + "身高:185 cm, 体重:72 kg";
            //1. mess调用indexOf(String s)方法返回字符串中首次出现冒号的位置
            int index = mess.indexOf(":");
            String name = mess.substring(index + 1);
            if (name.startsWith("张")) {
                System.out.println("简历中的姓名姓\"张\"");
            }
            //2. mess调用indexOf(String s, int start)返回字符串中第2次出现冒号的位置
            index = mess.indexOf(":", index + 1);
            String date = mess.substring(index + 1, index + 11);
            System.out.println(date);
            index = mess.indexOf(":", index + 1);
            //3. mess调用indexOf(String s)返回字符串中首次出现“身高”的位置
            int heightPosition = mess.indexOf("身高");
            String personNet = mess.substring(index + 1, heightPosition - 1);
            System.out.println(personNet);
            //4. mess调用indesOf(String s, int start)返回字符串中“身高“后面冒号位置
            index = mess.indexOf("身高", heightPosition);
            int cmPosition = mess.indexOf("cm");
            String height = mess.substring(index + 1, cmPosition);
            height = height.trim();
            int h = 0;
            try {
                h = Integer.parseInt(height);
            } catch (NumberFormatException e) {
//                e.printStackTrace();
            }
            if (h >= 180) {
                System.out.println("简历中的身高" + height + "大于或等于180cm");
            } else {
                System.out.println("简历中的身高" + height + "小于180cm");
            }
            //5. mess调用lastIndexOf(String s)返回字符串中最后一个冒号位置
            index = mess.lastIndexOf(":");
            int kgPosition = mess.indexOf("kg");
            String weight = mess.substring(index + 1, kgPosition);
            weight = weight.trim();
            int w = Integer.parseInt(weight);
            if (w >= 75) {
                System.out.println("简历中的体重" + weight + "大于等于75kg");
            } else {
                System.out.println("简历中的体重" + weight + "小于75kg");
            }

            String str1=new String ("ABCABC");
            String str2=null;
            String str3=null;
            String str4=null;
            str2=str1.replaceAll("A","First");
            str3=str2.replaceAll("B","Second");
            str4=str3.replaceAll("C","Third");
            System.out.println(str1);
            System.out.println(str2);
            System.out.println(str3);
            System.out.println(str4);

            str1=toBinaryString(12345);
            str2=toOctalString(12345);
            str3=toHexString(12345);
            System.out.println(str1);
            System.out.println(str2);
            System.out.println(str3);


        }catch(Exception e){
//            e.printStackTrace();
        }
    }








}
