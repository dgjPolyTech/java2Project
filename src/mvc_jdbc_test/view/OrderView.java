package mvc_jdbc_test.view;

import mvc_jdbc_test.entity.Order;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderView {
    public void printOrder(Order order){
        System.out.println("* 고객이름: "+order.getCustomername());
        System.out.println("* 고객아이디: "+order.getCustomerid());
        System.out.println("* 제품명: "+order.getOrderProduct());
        System.out.println("* 수량: "+order.getAuantity());

        Date shippingDate = order.getShippingDate();

        // 년월일 형태로 뽑기 위해 변환.
        // String orderDate = (shippingDate.getYear()+1900) + "-" +(shippingDate.getMonth()+1)+"-"+ shippingDate.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String orderDate = dateFormat.format(shippingDate);

        System.out.println("* 주문일자: "+orderDate);

        System.out.println("* 배송지: "+order.getShippingAddress());
//
//        System.out.println("* 주문번호: "+order.getOrderNum());
//        System.out.println("* 주문고객: "+order.getOrderCustomer());

    }
}
