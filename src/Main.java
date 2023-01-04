import ST.Student;
import ST.Subject;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        //File file = new File("Information.txt");

        Student student = new Student();
        Subject subject = new Subject();
        student.setID("22222222");
        student.setName("hi");
        student.setAffiliation("con");
        student.stcount();
        subject.sjcount();

        //Student student1 = new Student("20231111", "홍길동", "컴퓨터공학과");
        //Subject subject1 = new Subject("프로그래밍1");

        /*
        System.out.println(student1.getID());
        System.out.println(student1.getName());
        System.out.println(student1.getAffiliation());
        System.out.println(subject1.getSubject());
        */
    }
}