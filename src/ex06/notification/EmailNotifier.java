package ex06.notification;

public class EmailNotifier implements Notifier {
    private Notifier notifier; // 뭐든지 has 할 수 있다(모든 것이 Notifier를 상속하고 있기 때문)

    public EmailNotifier() {}

    public EmailNotifier(Notifier notifier) {
        this.notifier = notifier;
    }

    public void send() {
        if (notifier != null) notifier.send();
        System.out.println("이메일 알림");
    }
}
