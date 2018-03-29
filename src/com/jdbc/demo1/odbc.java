package com.jdbc.demo1;

import java.sql.*;

/**
 * Created by thinkpad on 2018/2/13.
 * jdbc-odbc
 * 1. 配置数据源
 * 2. 在程序中连接数据源
 */
public class odbc {

    public static void main(String [] args){

        Connection ct=null;
        Statement sm=null;

        try{
            //1. 加载驱动 把需要的驱动程序加入内存
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //2. 得到连接 指定连接到哪个数据源，用户名，密码
            ct= DriverManager.getConnection("jdbc:odbc:mytest"
                    ,"sa","sa");
            //3. 创建statement或者PreparedStatement
            //Statement主要用于发送sql语句 到数据库
            sm=ct.createStatement();
            //4. 执行(crud)
                //1. 演示添加一条数据到dept表
                //executeUpdate可以执行cud create update delete 操作
                //executeUpdate会返回一个int 代表有几个数据加入表
//            int i=sm.executeUpdate("insert into dept values(50,'保安部','哈哈')");
//            if (i == 1) {
//                System.out.println("添加成功");
//            }else{
//                System.out.println("添加失败");
//            }

                //2. 演示从dept表中删除一条记录
//            int i=sm.executeUpdate("delete from dept where deptno='50'");
//            if (i == 1) {
//                System.out.println("删除成功");
//            } else {
//                System.out.println("删除失败");
//            }

            //查询，显示所有部门
            //ResultSet 结果集
            ResultSet rs=sm.executeQuery("select * from dept");
            //因为rs指向结果集的第一行的前一行

//            //试图取出第一行的第一列
//            rs.next();
//            int a=rs.getInt(1);
//            System.out.println(a);
//            //取出第一行的第二列
//            String b = rs.getString(2);
//            System.out.println(b);

            //循环取出
            while (rs.next()) {
                int deptno=rs.getInt(1);
                String dname = rs.getString(2);
                String loc = rs.getString(3);
                System.out.println(deptno + " " + dname + " " + loc);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭资源
            try {
                if (sm != null) {
                    sm.close();
                }
                if (ct != null) {
                    ct.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
