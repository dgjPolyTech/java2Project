package mvc_jdbc_test.controller;

import jdbc_test.JDBCConnector;
import mvc_jdbc_test.entity.Customer;
import mvc_jdbc_test.entity.Order;
import mvc_jdbc_test.view.CustomerView;
import mvc_jdbc_test.view.OrderView;

import mvc_jdbc_test.view.InputCustomerInfoView;

import mvc_jdbc_test.view.UpdateCustomerInfoView;
import oracle.jdbc.proxy.annotation.Pre;
import oracle.sql.TIMESTAMP;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import my_util.*;

public class MainController {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Connection con = JDBCConnector.getConnection();

        while(true){
            System.out.println("===== 고객 관리 시스템 ======");
            System.out.println("1. 전체 고객 정보 확인");
            System.out.println("2. 주문 내역 확인");
            System.out.println("3. 신규 고객 정보 입력");
            System.out.println("4. 고객 정보 업데이트");
            System.out.println("5. 고객 정보 삭제");

            System.out.print("원하시는 서비스를 입력해주십시오. ==> ");
            String choose = sc.nextLine();

            switch(choose){
                case "4":
                    updateCustomerInfoView(con);
                    break;

                case "5":
                    deleteCustomerInfoView(con);
                    break;

                default:
                    System.out.println("올바른 값을 입력해주십시오.");
            }
        }

        // customerListAndView(con);
        // orderListAndView(con);
        // InputCustomerAndView(con);
    }

    //
    public static void updateCustomerInfoView(Connection con){
        Scanner sc = new Scanner(System.in);
        InputCustomerInfoView updateCustomerInfoView = new InputCustomerInfoView();

        while(true){
            try{
                String sql_select = "select * from 고객 where 고객아이디 = ?";
                Customer original_customer = new Customer(); // 정보 select 했을 때 값을 저장할 customer 변수

                System.out.println("\n===== [[고객 정보 업데이트]] ===== ");
                while(true){
                    System.out.print("업데이트할 고객의 \"고객 아이디\"를 입력하십시오. ==> ");

                    //고객 정보 입력 시, 그 아이디에 해당하는 고객 정보를 먼저 select
                    // 사용자에게 입력받는 (업데이트 할) 고객의 아이디
                    String customer_id = sc.nextLine();

                    while(true){
                        if(customer_id.equals("")){
                            System.out.println("아이디 값을 입력받지 못했습니다.");;
                        } else {
                            break;
                        }
                    }

                    //
                    PreparedStatement ps = con.prepareStatement(sql_select);
                    ps.setString(1, customer_id);

                    ResultSet rs = ps.executeQuery();
                    CustomerView customerView = new CustomerView();
                    // 고객 한명의 정보만 가져오는 경우이기에, 굳이 while문을 사용할 필요가 없다.
                    if(rs.next()){
                        original_customer = new Customer();
                        original_customer.setCustomerid(rs.getString("고객아이디"));
                        original_customer.setCustomername(rs.getString("고객이름"));
                        original_customer.setAge(rs.getInt("나이"));
                        original_customer.setLevel(rs.getString("등급"));
                        original_customer.setJob(rs.getString("직업"));
                        original_customer.setReward(rs.getInt("적립금"));

                        System.out.println("\n===== [[업데이트 할 사용자 정보]] =====");
                        customerView.printCustomer(original_customer);
                        break;
                    } else {
                        System.out.println("사용자 정보를 찾을 수 없습니다.");
                    }
                }


                // 고객 정보 select 되었으면, update할 정보를 입력 받아 업데이트 진행
                String sql_update = "update 고객 set 고객이름 = ?, 나이 = ?, 등급 = ?, 직업 = ?, 적립금 = ? where 고객아이디 = ?";
                Customer update_info = updateCustomerInfoView.updateCustomerInfo(original_customer);

                //
                try(PreparedStatement ps_update = con.prepareStatement(sql_update)) {
                    ps_update.setString(1, update_info.getCustomername());
                    ps_update.setInt(2, update_info.getAge());
                    ps_update.setString(3, update_info.getLevel());
                    ps_update.setString(4, update_info.getJob());
                    ps_update.setInt(5, update_info.getReward());
                    ps_update.setString(6, original_customer.getCustomerid());

                    // update 실행 후, 결과값을 1(성공)/0(실패)로 받아온다.
                    int result = ps_update.executeUpdate();
                    if(result == 1){
                        System.out.println("============");
                        System.out.println(original_customer.getCustomerid()+" 고객의 정보를 업데이트 하였습니다.");
                    } else {
                        System.out.println("============");
                        System.out.println("고객 정보 업데이트에 실패했습니다. 입력값을 다시 확인해주십시오.");
                    }
                }

                System.out.print("업데이트를 계속하시겠습니까?(종료를 원할 경우, q(소문자) 입력, 계속할 경우 아무 값이나 입력): ");
                String retry = sc.nextLine();

                if(retry.equals("q")){
                    System.out.println("업데이트를 종료합니다.");
                    break;
                }
            } catch(SQLException e){
                // e.getMessage 옵션을 추가하면 구체적으로 어떤 문제인지 알 수 있음.
                System.out.println("Statement or SQL Error" +e.getMessage());
            }
        }
    }

    // 고객 정보 삭제 view
    public static void deleteCustomerInfoView(Connection con){
        Scanner sc = new Scanner(System.in);
        Customer original_customer = new Customer(); // 정보 select 했을 때 값을 저장할 customer 변수

        while(true) {
                // 삭제할 고객의 정보를 입력받는 부분
                System.out.println("\n===== [[고객 정보 삭제]] ===== ");
                String customer_id; // 삭제할 고객의 아이디 입력 받는 변수

                while (true) {
                    System.out.print("삭제할 고객의 \"고객아이디\"를 입력하십시오. ==> ");
                    customer_id = sc.nextLine();

                    while (true) {
                        if (customer_id.equals("")) {
                            System.out.println("아이디 값을 입력받지 못했습니다.\n");
                        } else {
                            break;
                        }
                    }

                    try {
                        String sql_select = "SELECT * FROM 고객 WHERE 고객아이디 = ?";

                        PreparedStatement ps = con.prepareStatement(sql_select);
                        ps.setString(1, customer_id);

                        ResultSet rs = ps.executeQuery();

                        CustomerView customerView = new CustomerView();

                        // 입력받은 아이디를 토대로, 먼저 정보를 보여준다.
                        if (rs.next()) {
                            System.out.println("\n===== [[삭제할 사용자 정보]] =====");
                            original_customer = new Customer();

                            original_customer.setCustomerid(rs.getString("고객아이디"));
                            original_customer.setCustomername(rs.getString("고객이름"));
                            original_customer.setAge(rs.getInt("나이"));
                            original_customer.setLevel(rs.getString("등급"));
                            original_customer.setJob(rs.getString("직업"));
                            original_customer.setReward(rs.getInt("적립금"));

                            customerView.printCustomer(original_customer);
                        } else {
                            System.out.println("사용자 정보를 찾을 수 없습니다.");
                        }

                        // 고객 정보를 보여줬으면, 고객의 의사를 한번 더 묻고 delete를 진행한다.
                        String sql_delete = "DELETE FROM 고객 WHERE 고객아이디 = ?";

                        System.out.println("정말로 고객아이디 \"" + customer_id + "\" 고객의 정보를 삭제하시겠습니까? 복구할 수 없습니다.");
                        System.out.print("(* 삭제 동의: Y/y 입력, 취소: N/n 입력 ==> ");
                        String delChoice = sc.nextLine();

                        switch (delChoice) {
                            case "Y":
                            case "y":
                                try(PreparedStatement ps_delete = con.prepareStatement(sql_delete)){
                                    ps_delete.setString(1, customer_id);

                                    int result = ps_delete.executeUpdate();

                                    if(result == 1){
                                        System.out.println("============");
                                        System.out.println("고객 정보를 삭제하였습니다. ");
                                    } else {
                                        System.out.println("============");
                                        System.out.println("고객 정보 삭제에 실패했습니다. 입력값을 다시 확인해주십시오.");
                                    }
                                }
                                break;

                            case "N":
                            case "n":
                                System.out.println("사용자 정보 삭제를 취소합니다.");
                                break;
                        }


                    } catch (SQLException e) {
                        System.out.println("Statement or SQL Error" + e.getMessage());
                    }
                }
        }
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
