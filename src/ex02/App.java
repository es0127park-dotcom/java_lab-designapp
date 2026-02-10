package ex02;

public class App {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        Mouse mouse = new Mouse();
        Doorman doorman = new DoormanProxy();

        doorman.쫓아내(mouse);
    }
}
