package mvc_jdbc_test.controller;

import jdbc_test.JDBCConnector;
import mvc_jdbc_test.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainController {
    public static void main(String[] args){
        Connection con = JDBCConnector.getConnection();

        try {
            String sql = "select * from 고객";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Customer> customerList = new ArrayList<Customer>();
            Customer customer = null;

            // 좌측 바의 데이터베이스 아이콘 클릭 > + 아이콘 클릭 > 데이터소스 추가 > oracle 정보 입력 후 추가.
            // 그리고 누락된 드라이버 다운로드 옵션 클릭
            // ResultSet의 값이 true면(=값이 있는 동안)
            while(rs.next()){
                customer = new Customer();
                customer.setCustomerid(rs.getString("고객아이디"));
                customer.setCustomername(rs.getString("고객이름"));
                customer.setAge(rs.getInt("나이"));
                customer.setLevel(rs.getString("등급"));
                customer.setJob(rs.getString("직업"));
                customer.setReward(rs.getInt("적립금"));

                customerList.add(customer);
            }

        } catch (SQLException e) {
            System.out.println("Statement or SQL Error");
        }
    }
}
