package ex02;

public class DoormanProxy extends Doorman {

    // Doorman 아닌데 Doorman인 척!
    @Override
    public void 쫓아내(Animal a) {
        System.out.println("지갑 검사");
        super.쫓아내(a);
    }
}
