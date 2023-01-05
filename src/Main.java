import ST.Grade;
import ST.Score;
import ST.Student;
import ST.Subject;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<Student>();
        ArrayList<Subject> subjectList = new ArrayList<Subject>();
        ArrayList<Score>   scoreList   = new ArrayList<Score>();
        ArrayList<Grade>   gradeList   = new ArrayList<Grade>();

        studentList.add(new Student("20230000", "신땡땡", "컴퓨터공학과"));
        studentList.add(new Student("20231111", "신짱구", "컴퓨터공학과"));
        studentList.add(new Student("20232222", "ㅇ훈이", "컴퓨터공학과"));
        studentList.add(new Student("20233333", "ㅇ유리", "컴퓨터공학과"));
        studentList.add(new Student("20234444", "김철수", "컴퓨터공학과"));

        subjectList.add(new Subject("자바프로그래밍"));
        subjectList.add(new Subject("C프로그래밍"));
        subjectList.add(new Subject("웹프로그래밍"));
        subjectList.add(new Subject("웹프레임워크"));
        subjectList.add(new Subject("컴퓨터네트워크"));

        scoreList.add(new Score(95));
        scoreList.add(new Score(95));
        scoreList.add(new Score(95));
        scoreList.add(new Score(95));
        scoreList.add(new Score(95));

        for(Student student : studentList)  student.stcount();
        for(Subject subject : subjectList)  subject.sjcount();
        for(Score score : scoreList)        score.sccount();

        System.out.println("                        성적산출프로그램                        ");
        System.out.println("-------------------------------------------------------------");
        System.out.println("|  학   번  | 이  름 |  소    속  |   과    목   | 점 수 | 성 적 |");
        System.out.println("-------------------------------------------------------------");

        for(Student student : studentList){
            System.out.print("| ");
            System.out.print(student.getID());
            System.out.print(" | ");
            System.out.print(student.getName());
            System.out.print(" | ");
            System.out.print(student.getAffiliation());
            System.out.print(" | ");


        }

       System.out.println("--------------------------------------------------------------");
    }
}
/*
Student student = new Student("20191480", "신용선", "컴퓨터공학과");
        Student student1 = new Student("20191480", "신용선", "컴퓨터공학과");
        Student student2 = new Student("20191480", "신용선", "컴퓨터공학과");

        Subject subject = new Subject("자바프로그래밍");
        Score score = new Score(99);
        Grade grade = new Grade();
 */


/*
    설정자를 이용하여 데이터 입력
    student.setID("20191480");
    student.setName("신용선");
    student.setAffiliation("컴퓨터공학과");
    subject.setSubject("자바프로그래밍");
    score.setScore(99);
 */

/*
// for(count = 0;count < 5;count ++) {
            if (student.getID() == null || student.getName() == null || student.getAffiliation() == null) {
                //학생이 존재하지 않으면
                student.stcount();
            } else if (subject.getSubject() == null) {
                //과목이 존재하지 않으면
                subject.sjcount();
            } else if (score.getScore() < 0) {
                //점수가 존재하지 않으면
                score.sccount();
            }
       // }
        else {
            //성적산출프로그램 출력
            //로깅파일로 바꾸고 반복문으로 출력 예정 (TEST)
            System.out.println("                        성적산출프로그램                        ");
            System.out.println("-------------------------------------------------------------");
            System.out.println("|  학   번  | 이  름 |  소    속  |   과    목   | 점 수 | 성 적 |");
            System.out.println("-------------------------------------------------------------");
            //for(int i = 0;i < student.length)
            System.out.print("| ");
            System.out.print(student.getID());
            System.out.print(" | ");
            System.out.print(student.getName());
            System.out.print(" | ");
            System.out.print(student.getAffiliation());
            System.out.print(" | ");
            System.out.print(subject.getSubject());
            System.out.print(" |  ");
            System.out.print(score.getScore());
            System.out.print("  |   ");
            System.out.print(grade.getGrade(score.getScore()));
            System.out.print("   |\n");
            System.out.println("-------------------------------------------------------------");
        }
 */