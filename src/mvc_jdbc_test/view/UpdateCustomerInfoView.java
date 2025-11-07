package mvc_jdbc_test.view;

import mvc_jdbc_test.entity.Customer;

import java.util.Scanner;

import my_util.*;

public class UpdateCustomerInfoView {

    // 업데이트 할
    public Customer updateCustomerInfo(Customer originalCustomer){
        Customer updateCustomer = new Customer();

        //
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);

        // 아이디 값을 토대로 업데이트 해야하므로, 아이디 값은 미리 지정해놓는다.
        updateCustomer.setCustomerid(originalCustomer.getCustomerid());
        System.out.println(originalCustomer.getCustomerid());
        System.out.println("===== 수정할 정보 입력(* 수정을 원치 않는 정보는 enter 입력) =====");

        String customerName = InputInfoIsEmpty.InputStringIsEmpty(s1, "고객 이름", originalCustomer.getCustomername());

        //int customerAge = s1.nextInt();
        int customerAge = InputInfoIsEmpty.InputNumberIsEmpty(s2, "고객의 나이", originalCustomer.getAge());

        String customerLevel = InputInfoIsEmpty.InputStringIsEmpty(s1, "고객 등급", originalCustomer.getLevel());
        //String customerLevel = s1.nextLine();

        String customerJob = InputInfoIsEmpty.InputStringIsEmpty(s1, "고객 직업", originalCustomer.getJob());

        int customerReward = InputInfoIsEmpty.InputNumberIsEmpty(s1, "고객 적립금", originalCustomer.getReward());

        updateCustomer.setCustomername(customerName);
        updateCustomer.setAge(customerAge);
        updateCustomer.setLevel(customerLevel);
        updateCustomer.setJob(customerJob);
        updateCustomer.setReward(customerReward);

        return updateCustomer;
    }
}
