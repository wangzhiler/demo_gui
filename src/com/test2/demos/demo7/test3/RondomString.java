package com.test2.demos.demo7.test3;

/**
 * Created by thinkpad on 2018/1/31.
 */
public class RondomString {  //负责随机排列单词中字母
    String str="";
    public String getRondomString(String s){
        StringBuffer stringBuffer=new StringBuffer(s);
        int m=stringBuffer.length();
        for(int k=0; k<m; k++){
            int index=(int)(Math.random()*stringBuffer.length());
            //Math.random()返回(0,1)之间的随机数
            char c=stringBuffer.charAt(index);
            str=str+c;
            stringBuffer=stringBuffer.deleteCharAt(index);
        }
        return str;
    }
}
