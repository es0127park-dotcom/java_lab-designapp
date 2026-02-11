package ex06;

import ex06.notification.BasicNotifier;
import ex06.notification.EmailNotifier;
import ex06.notification.SmsNotifier;

/**
 *     {
 *      "sends" : [basic, email],
 *       "msg": "반가워!!"
 *     }
 */

// 책임 : 기존에 있는 클래스에 기능을 확장하면서 계속 추가하는 패턴
public class App {
    public static void main(String[] args) {
        // 1번 문제 (SMS 알림, SMS 알림, Email 알림)
        EmailNotifier b1 = new EmailNotifier(new SmsNotifier(new SmsNotifier()));
        b1.send();
        System.out.println("-----------------------------------------");

        // 2번 문제 (기본 알림, SMS 알림, Email 알림)
        EmailNotifier b2 = new EmailNotifier(new SmsNotifier(new BasicNotifier()));
        b2.send();
        System.out.println("-----------------------------------------");

        // 3번 문제 (SMS 알림)
        SmsNotifier b3 = new SmsNotifier();
        b3.send();
    }
}
