package com.jdbc.demo1;

import java.sql.*;

/**
 * Created by thinkpad on 2018/2/13.
 *
 */
public class test1 {

    public static void main(String[] args) {
        //PreparedStatement

        //定义需要的对象
        PreparedStatement preparedStatement=null;
        Connection connection=null;
        ResultSet resultSet=null;

        try{
            //初始化我们对象
            //1. 加在驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2. 得到连接
            connection=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=spdb1"
                    ,"sa","sa");
            //3. 创建火箭车

            // 【查询】
            /*
            preparedStatement=connection.prepareStatement(
                    "select ename,sal,dname from emp, dept where emp.deptno=dept.deptno");
            //4. 执行[如果是 增加 删除 修改 executeUpdate(),如果是查询 executeQuery() ]
            resultSet=preparedStatement.executeQuery();

            //循环的取出，雇员的名字 雇员薪水 部门编号
            while (resultSet.next()) {
                String name = resultSet.getString("ename");
                float sal = resultSet.getFloat("sal");
                String dname = resultSet.getString("dname");
                System.out.println(name+" "+ sal+" "+dname);
            }
*/
            // 【增加 删除 修改】
            preparedStatement=connection.prepareStatement("insert into dept values(?,?,?)");
            preparedStatement.setInt(1, 100);
            preparedStatement.setString(2, "财务部");
            preparedStatement.setString(3,"大学城");
            int i=preparedStatement.executeUpdate();
            if (i == 1) {
                System.out.println("添加ok");
            }else{
                System.out.println("不ok");
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}























