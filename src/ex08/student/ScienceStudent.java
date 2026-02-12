package ex08.student;

// 책임 : 숙제를 하는 것
public class ScienceStudent implements Student {

    private static final String name = "SCIENCE";

    public void doHomework() {
        System.out.println("과학 숙제를 합니다.");
    }

    public boolean isSameHomework(String keyboard) {
        return name.equals(keyboard.toUpperCase());
    }
}
