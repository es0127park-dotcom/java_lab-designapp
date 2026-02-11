package ex07.polling;

public class App {
    public static void main(String[] args) {
        LotteMart lm = new LotteMart();
        Customer1 cus1 = new Customer1();

        // 1. 마트에 상품 입고 확인 (마트 스레드)
        new Thread(() -> {
            // 10초 대기
            for (int i = 1; i < 11; i++) {
                System.out.println("입고중...(" + i + "초)");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            // 입고 완료
            lm.received();
            System.out.println("입고완료!!");
        }).start();

        // 2. 손님이 풀링 (손님 스레드)
        new Thread(() -> {
            // 3초에 한번씩 상품 확인 요청
            while (true) {
                System.out.println("[손님] 상품 있어?");
                cus1.request(lm);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
