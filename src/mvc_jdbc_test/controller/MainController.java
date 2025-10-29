package mvc_jdbc_test.controller;

import jdbc_test.JDBCConnector;
import mvc_jdbc_test.entity.Customer;
import mvc_jdbc_test.entity.Order;
import mvc_jdbc_test.view.CustomerView;
import mvc_jdbc_test.view.OrderView;

import mvc_jdbc_test.view.InputCustomerInfoView;

import oracle.jdbc.proxy.annotation.Pre;
import oracle.sql.TIMESTAMP;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainController {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        Connection con = JDBCConnector.getConnection();

        // customerListAndView(con);
        // orderListAndView(con);
        InputCustomerAndView(con);
    }

    // 고객 정보 입력
    public static void InputCustomerAndView(Connection con){
        Scanner sc = new Scanner(System.in);
        InputCustomerInfoView inputCustomer = new InputCustomerInfoView();
        while(true){
            // inputCustomer의 inputCustomerInfo 메소드가 실행되며, 그 결과값으로 return 되는 customer 값이
            // customer에 담기게 된다.
            Customer customer = inputCustomer.inputCustomerInfo();

            // CustomerView를 기반으로, 입력한 customer 값을 확인차 출력한다.
            CustomerView customerView = new CustomerView();
            customerView.printHead();
            customerView.printCustomer(customer);
            customerView.printFooter();

            // 실제 DB에 반영하는 부분.
            String sql = "insert into 고객 values(?,?,?,?,?,?)";

            try{
                // PreparedStatement: 이름 그대로 준비된(prepared) sql 문장을 실행하기 위해 사용하는 것.
                PreparedStatement pstmt = con.prepareStatement(sql);

                // 위의 ??????의 순서대로 값을 집어 넣는다.
                pstmt.setString(1, customer.getCustomerid());
                pstmt.setString(2, customer.getCustomername());
                pstmt.setInt(3, customer.getAge());
                pstmt.setString(4, customer.getLevel());
                pstmt.setString(5, customer.getJob());
                pstmt.setInt(6, customer.getReward());
                pstmt.executeUpdate();
                pstmt.close();

            } catch(Exception e){
                System.out.println("Statement or SQL Error");
            }
            System.out.print("프로그램 종료를 원하면 e를 입력: ");

            String input = sc.nextLine();

            if(input.equals("e")){
                break;
            }
        }
        System.out.println("프로그램이 종료되었습니다.");
    }

    // 주문별 관련 정보 출력
    public static void orderListAndView(Connection con){
        ArrayList<Order> orderList = new ArrayList<Order>();

        try {
            String sql = "select 주문번호, 주문고객, 제품명, 수량, 배송지, 주문일자, 고객이름, 고객아이디 from 고객 c, 제품 p, 주문 o where c.고객아이디 = o.주문고객 and p.제품번호 = o.주문제품";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            Order order = null;

            while(rs.next()){
                order = new Order();
                order.setOrderNum(rs.getString("주문번호"));
                order.setOrderCustomer(rs.getString("주문고객"));
                order.setOrderProduct(rs.getString("제품명"));
                order.setAuantity(rs.getInt("수량"));
                order.setShippingAddress(rs.getString("배송지"));

                // 주문일자의 경우, 자바에서 제공하는 TIMESTAMP와 SQL에서 제공하는 TIMESTAMP가
                // 서로 달라 아래와 같이 진행해야한다.
                order.setShippingDate(rs.getDate("주문일자"));

                order.setCustomername(rs.getString("고객이름"));
                order.setCustomerid(rs.getString("고객아이디"));

                orderList.add(order);
            }
        } catch(SQLException e ){
            System.out.println("SQL 오류가 발생했습니다.");
        }

        OrderView orderView = new OrderView();
        for(Order order : orderList){
            orderView.printOrder(order);
        }
    }

    // 고객 테이블 목록 출력
    public static void customerListAndView(Connection con){
        ArrayList<Customer> customerList = new ArrayList<Customer>();

        try {
            String sql = "select * from 고객";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
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


        CustomerView customerView = new CustomerView();
        customerView.printHead();
        for(Customer customer : customerList){
            customerView.printCustomer(customer);
            System.out.println();
        }
        customerView.printFooter();
    }
}
