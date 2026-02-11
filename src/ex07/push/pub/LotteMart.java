package ex07.push.pub;

import ex07.push.sub.Customer;

import java.util.ArrayList;
import java.util.List;

public class LotteMart implements Mart{

    private String value = null;  // 상품(1개로 전제)

    // 임계영역(여러 스레드가 동시접근이 일어나게 될 때) -> 레이스 컨디션
    private List<Customer> list = new ArrayList<>();  // 구독자 명단

    // synchronized를 붙이면 하나의 스레드가 접근하면 다른 스레드가 접근하지 못하도록 막음 (레이스 컨디션 안 걸릴 수 있음)
    @Override
    synchronized public void add(Customer customer) {
        list.add(customer);
    }

    @Override
    public void received() {
        value = "바나나";  // 입고 완료
        notify(value);
    }

    @Override
    public void notify(String msg) {
        list.forEach(customer -> {
            // 1. 구독에 따라 다르게 분기해줘야 함
            customer.update(msg);  // push
        });
    }

    @Override
    public void remove(Customer customer) {
        list.remove(customer);
    }
}
