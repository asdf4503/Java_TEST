import ST.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String check;
        String save = null;
        String save1;
        String save2;

        Student student = new Student();
        Master master = new Master();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Student> studentList = new ArrayList<Student>();
        ArrayList<Subject> subjectList = new ArrayList<Subject>();
        ArrayList<Score> scoreList = new ArrayList<Score>();
        ArrayList<Grade> gradeList = new ArrayList<Grade>();

        studentList.add(new Student("20230000", "신용선", "컴퓨터공학과"));
        studentList.add(new Student("20231111", "신짱구", "컴퓨터공학과"));
        studentList.add(new Student("20232222", "이훈이", "컴퓨터공학과"));
        studentList.add(new Student("20233333", "한유리", "컴퓨터공학과"));
        studentList.add(new Student("20234444", "김철수", "컴퓨터공학과"));

        subjectList.add(new Subject("자바프로그래밍"));
        subjectList.add(new Subject("C++프로그래밍"));
        subjectList.add(new Subject(" 웹프로그래밍 "));
        subjectList.add(new Subject(" 데이터베이스 "));
        subjectList.add(new Subject("컴퓨터네트워크"));

        scoreList.add(new Score(95));
        scoreList.add(new Score(90));
        scoreList.add(new Score(95));
        scoreList.add(new Score(90));
        scoreList.add(new Score(95));

        gradeList.add(new Grade(scoreList.get(0).getScore()));
        gradeList.add(new Grade(scoreList.get(1).getScore()));
        gradeList.add(new Grade(scoreList.get(2).getScore()));
        gradeList.add(new Grade(scoreList.get(3).getScore()));
        gradeList.add(new Grade(scoreList.get(4).getScore()));

        switch (check = student.checking()) {
            case "1": //관리자 선택 (성적입력을 선택한 경우)
                save = master.ProCheck(check);
                break;
            case "2": //관리자 선택 (성적확인을 선택한 경우)
                save = master.ProCheck(check);
                break;
            case "3":
                System.out.print("프로그램을 종료합니다.");
                save = "4";
                break;
            default: //학생의 경우 성적확인만 가능 (학생 성적 출력문)
                for (int i = 0; i < studentList.size(); i++) {
                    if (check.equals(studentList.get(i).getName())) {
                        System.out.print(studentList.get(i).getID() + " / ");
                        System.out.print(studentList.get(i).getName() + " / ");
                        System.out.print(studentList.get(i).getAffiliation() + " / ");
                        System.out.print(subjectList.get(i).getSubject() + " / ");
                        System.out.print(scoreList.get(i).getScore() + " / ");
                        System.out.print(gradeList.get(i).getGrade() + "\n");
                    }
                }
                save = "5";
        }

        int count = 0;
        String ch;

        //성적입력문
        switch (save) {
            case "1": //학생을 입력하는 경우(학번, 이름, 소속)
                System.out.print("학번을 입력하시오. : ");
                save = bf.readLine();
                System.out.print("이름을 입력하시오. : ");
                save1 = bf.readLine();
                System.out.print("소속을 입력하시오. :");
                save2 = bf.readLine();
                studentList.add(new Student(save, save1, save2));

                System.out.println("입력을 종료하시겠습니까? (Y/N) : ");
                ch = bf.readLine();
                if (ch.equals("Y")) {
                    break;
                }
            case "2": //과목을 입력하는 경우(과목)
                System.out.print("[이번학기 수강과목]\n");
                System.out.print("[1] 컴퓨터네트워크\n[2] 시스템프로그래밍\n");
                System.out.print("[3] 객체지향프로그래밍\n[4] 정보보안");
                System.out.print("[5] 웹프로그래밍\n[6] 데이터구조\n");
                System.out.print("과목을 입력하시오. : ");
                save = bf.readLine();
                subjectList.add(new Subject(save));

                System.out.println("입력을 종료하시겠습니까? (Y/N) : ");
                ch = bf.readLine();
                if (ch.equals("Y")) {
                    break;
                }
            case "3":
                System.out.print("점수를 입력하시오");
                save = bf.readLine();
                scoreList.add(new Score(Integer.parseInt(save)));
                gradeList.add(new Grade(scoreList.get(count).getScore()));

                System.out.println("입력을 종료하시겠습니까? (Y/N) : ");
                ch = bf.readLine();
                if (ch.equals("Y")) {
                    break;
                }
                count++;
                break;

            case "4":
            case "5":
                break;
            default:
                System.out.println("잘못된 접근입니다.");
        }
    }
}

/*
        for(int i = 0;i < studentList.size();i++) {
                   System.out.println("[" + studentList.get(i).getName() + "]");
               }


        studentList.add(new Student("20231111", "신짱구", "컴퓨터공학과"));
        studentList.add(new Student("20232222", "이훈이", "컴퓨터공학과"));
        studentList.add(new Student("20233333", "한유리", "컴퓨터공학과"));
        studentList.add(new Student("20234444", "김철수", "컴퓨터공학과"));

        subjectList.add(new Subject("20230000", "자바프로그래밍"));
        subjectList.add(new Subject("20231111", "C++프로그래밍"));
        subjectList.add(new Subject("20232222", " 웹프로그래밍 "));
        subjectList.add(new Subject("20233333", " 데이터베이스 "));
        subjectList.add(new Subject("20234444", "컴퓨터네트워크"));

        scoreList.add(new Score("20230000", 95));
        scoreList.add(new Score("20231111", 90));
        scoreList.add(new Score("20232222", 95));
        scoreList.add(new Score("20233333", 90));
        scoreList.add(new Score("20234444", 95));

        gradeList.add(new Grade(scoreList.get(0).getScore()));
        gradeList.add(new Grade(scoreList.get(1).getScore()));
        gradeList.add(new Grade(scoreList.get(2).getScore()));
        gradeList.add(new Grade(scoreList.get(3).getScore()));
        gradeList.add(new Grade(scoreList.get(4).getScore()));

System.out.println("                        성적산출프로그램                        ");
            System.out.println("-------------------------------------------------------------");
            System.out.println("|  학   번  | 이  름 |  소    속  |   과    목   | 점 수 | 성 적 |");
            System.out.println("-------------------------------------------------------------");

            for (int i = 0; i < studentList.size(); i++) {
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
 */