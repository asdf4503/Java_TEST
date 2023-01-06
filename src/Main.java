import ST.Grade;
import ST.Score;
import ST.Student;
import ST.Subject;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<Student>(5);
        ArrayList<Subject> subjectList = new ArrayList<Subject>(5);
        ArrayList<Score>   scoreList   = new ArrayList<Score>(5);
        ArrayList<Grade>   gradeList   = new ArrayList<Grade>(5);

        studentList.add(new Student("20230000", "신땡땡", "컴퓨터공학과"));
        studentList.add(new Student("20231111", "신짱구", "컴퓨터공학과"));
        studentList.add(new Student("20232222", "ㅇ훈이", "컴퓨터공학과"));
        studentList.add(new Student("20233333", "ㅇ유리", "컴퓨터공학과"));
        studentList.add(new Student("20234444", "김철수", "컴퓨터공학과"));

        subjectList.add(new Subject("20230000", "자바프로그래밍"));
        subjectList.add(new Subject("20231111", "C++프로그래밍"));
        subjectList.add(new Subject("20232222", " 웹프로그래밍"));
        subjectList.add(new Subject("20233333", " 웹프레임워크"));
        subjectList.add(new Subject("20234444", "컴퓨터네트워크"));

        scoreList.add(new Score("20230000",95));
        scoreList.add(new Score("20231111",90));
        scoreList.add(new Score("20232222",95));
        scoreList.add(new Score("20233333",90));
        scoreList.add(new Score("20234444",95));

        gradeList.add(new Grade(scoreList.get(0).getScore()));
        gradeList.add(new Grade(scoreList.get(1).getScore()));
        gradeList.add(new Grade(scoreList.get(2).getScore()));
        gradeList.add(new Grade(scoreList.get(3).getScore()));
        gradeList.add(new Grade(scoreList.get(4).getScore()));

        for(int i = 0;i < studentList.size();i++){
            if (studentList.get(i).getID() == null || studentList.get(i).getName() == null || studentList.get(i).getAffiliation() == null) {
                //학생이 존재하지 않으면
                studentList.get(i).stcount();
            } else if (subjectList.get(i).getSubject() == null) {
                //과목이 존재하지 않으면
                subjectList.get(i).sjcount();
            } else if (scoreList.get(i).getScore() < 0) {
                //점수가 존재하지 않으면
                scoreList.get(i).sccount();
            }
        }


        System.out.println("                        성적산출프로그램                        ");
        System.out.println("-------------------------------------------------------------");
        System.out.println("|  학   번  | 이  름 |  소    속  |   과    목   | 점 수 | 성 적 |");
        System.out.println("-------------------------------------------------------------");

        for(int i = 0;i < studentList.size();i++){
            System.out.print("| ");
            System.out.print(studentList.get(i).getID());
            System.out.print(" | ");
            System.out.print(studentList.get(i).getName());
            System.out.print(" | ");
            System.out.print(studentList.get(i).getAffiliation());
            System.out.print(" | ");
            System.out.print(subjectList.get(i).getSubject());
            System.out.print(" |  ");
            System.out.print(scoreList.get(i).getScore());
            System.out.print("  |   ");
            System.out.print(gradeList.get(i).getGrade());
            System.out.print("   |\n");
        }
       System.out.println("--------------------------------------------------------------");
    }
}