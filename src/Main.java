import ST.*;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String check;
        String save = null;
        String save1;
        String save2;
        int count = 0;
        int checking = 0;
        String ch;
        boolean login = false;
        String line = "";

        Student student = new Student();
        Master master = new Master();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader("src/Information.txt"));
        File file = new File("src/Information.txt");
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        ArrayList<Student> studentList = new ArrayList<Student>();
        ArrayList<Subject> subjectList = new ArrayList<Subject>();
        ArrayList<Score> scoreList = new ArrayList<Score>();
        ArrayList<Grade> gradeList = new ArrayList<Grade>();

        System.out.println("성적산출프로그램입니다.");
        System.out.println("본 프로그램은 컴퓨터공학과 학생의 성적을 산출하는 프로그램입니다.");
        System.out.println("\n");

        while (true) {
            switch (check = student.checking()) {
                case "1": //관리자 선택 (데이터입력을 선택한 경우)
                    if(login == false) {
                        login = master.Login();
                    }
                    save = master.ProCheck(check);
                    break;
                case "2": //관리자 선택 (데이터확인을 선택한 경우)
                    if(login == false) {
                        login = master.Login();
                    }
                    save = master.ProCheck(check);
                    System.out.println("-------------2022학년 성적-------------");
                    System.out.println("학번 / 이름 / 소속 / 과목명 / 점수 / 성적\n");
                    if(save.equals("*")){
                        while(reader.readLine() != null){
                            System.out.println(reader.readLine());
                        }
                    }
                    while((line = reader.readLine()) != null){
                        if(line.contains(save) == true) {
                            System.out.println(line);
                        }
                    }
                    System.out.println("\n");
                    save = "5";
                    break;
                case "3":
                    System.out.print("프로그램을 종료합니다.");
                    save = "4";
                    break;
                default: //학생의 경우 성적확인만 가능 (학생 성적 출력문)
                    System.out.println("-------------2022학년 성적-------------");
                    System.out.println("학번 / 이름 / 소속 / 과목명 / 점수 / 성적\n");
                    while((line = reader.readLine()) != null){
                        if(line.contains(check) == true) {
                            System.out.println(line);
                        }
                    }
                    System.out.println("\n");
                    System.out.print("프로그램을 종료하시겠습니까? (Y/N) : ");
                    ch = bf.readLine();
                    if (ch.equals("Y")) {
                        System.out.println("프로그램을 종료합니다.");
                        System.out.println("\n");
                        save = "4";
                        break;
                    }
                    save = "5";
            }

            //입력문
            switch (save) {
                case "1": //학생을 입력하는 경우(학번, 이름, 소속)
                    System.out.print("학번을 입력하시오. : ");
                    save = bf.readLine();
                    System.out.print("이름을 입력하시오. : ");
                    save1 = bf.readLine();
                    System.out.print("소속을 입력하시오. : ");
                    save2 = bf.readLine();
                    studentList.add(new Student(save, save1, save2));
                    writer.write(studentList.get(count).getID());
                    writer.write(" / ");
                    writer.write(studentList.get(count).getName());
                    writer.write(" / ");
                    writer.write(studentList.get(count).getAffiliation());
                    writer.write(" / ");

                case "2": //과목을 입력하는 경우(과목)
                    System.out.print("[이번학기 수강과목]\n");
                    System.out.print("[1] 컴퓨터네트워크\n[2] 시스템프로그래밍\n");
                    System.out.print("[3] 객체지향프로그래밍\n[4] 정보보안\n");
                    System.out.print("[5] 웹프로그래밍\n[6] 데이터구조\n");
                    System.out.print("과목을 입력하시오. : ");
                    save = bf.readLine();
                    subjectList.add(new Subject(save));
                    writer.write(subjectList.get(count).getSubject());
                    writer.write(" / ");


                case "3":
                    System.out.print("점수를 입력하시오. : ");
                    save = bf.readLine();
                    scoreList.add(new Score(Integer.parseInt(save)));
                    gradeList.add(new Grade(scoreList.get(count).getScore()));
                    writer.write(String.valueOf(scoreList.get(count).getScore()));
                    writer.write(" / ");
                    writer.write(gradeList.get(count).getGrade());
                    writer.write("\n");
                    count++;

                    System.out.print("프로그램을 종료하시겠습니까? (Y/N) : ");
                    ch = bf.readLine();
                    if (ch.equals("Y")) {
                        save = "4";
                        break;
                    }
                case "4":
                case "5":
                    break;
                default:
                    System.out.println("잘못된 접근입니다.");
            }
            if (save.equals("4")) break;
        }
        writer.close();
    }
   /* public void fileCheck() {
        writer.write(studentList.get(count).getID());
        writer.write(" / ");
        writer.write(studentList.get(count).getName());
        writer.write(" / ");
        writer.write(studentList.get(count).getAffiliation());
        writer.write(" / ");
    }*/
}

/*



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
                    for(int i = 0;i < studentList.size();i++) {
                        System.out.println("[" + studentList.get(i).getName() + "]");
                    }
 */