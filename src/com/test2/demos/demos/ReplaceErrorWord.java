package com.test2.demos.demos;

/**
 * Created by thinkpad on 2018/1/24.
 */

import java.util.regex.*;

public class ReplaceErrorWord {
    public static void main(String args[]) {
        String str = "忘记密码，不要惊慌失措，请登陆www.yy.cn或登陆www.tt.cn";
        Pattern pattern;
        Matcher matcher;
        String regex = "登陆";
        //1. 使用regex初始化模式对象pattern
        pattern = Pattern.compile(regex);
        //2. 得到检索str的匹配对象matcher
        matcher = pattern.matcher(str);

        while(matcher.find()) {
            String s= matcher.group();
            System.out.print(matcher.start()+"位置出现：");
            System.out.println(s);
        }

        System.out.println("将\"登陆\"替换为\"登录\"的字符串:");
        String result = matcher.replaceAll("登录");
        System.out.println("惊慌失措");
        matcher = pattern.matcher(result);
        System.out.println("将\"惊慌失错\"替换为\"惊慌失措\"的字符串:");
        result = matcher.replaceAll("惊慌失措");
        System.out.println(result);

    }
}
