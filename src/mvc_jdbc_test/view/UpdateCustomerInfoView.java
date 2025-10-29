package mvc_jdbc_test.view;

import mvc_jdbc_test.entity.Customer;

import java.util.Scanner;

public class UpdateCustomerInfoView {

    // 업데이트 할
    public Customer updateCustomerInfo(){
        Customer customer = new Customer();

        //
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);

        System.out.println("=== 수정할 정보 입력(* 수정을 원치 않는 정보는 enter 입력)");

        System.out.println("고객 이름 수정할 값 입력: ");
        String customerName = s1.nextLine();

        System.out.println("고객 나이 수정할 값 입력: ");
        int customerAge = s1.nextInt();

        // nextLine을 쓰다가 Int를 쓰는 경우, enter가 버퍼에 남은 걸 비워주는 과정이 필요하다.
        s1.nextLine();

        System.out.println("고객 등급 수정할 값 입력: ");
        String customerLevel = s1.nextLine();

        System.out.println("고객 직업 입력: ");
        String customerJob = s1.nextLine();

        System.out.println("고객 적립액 입력: ");
        int customerReward = s1.nextInt();

        customer.setCustomername(customerName);
        customer.setAge(customerAge);
        customer.setLevel(customerLevel);
        customer.setJob(customerJob);
        customer.setReward(customerReward);

        return customer;
    }
}
