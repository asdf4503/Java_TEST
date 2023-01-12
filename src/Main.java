import ST.*;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int loadcount = 0;
        ArrayList<Student> studentList = new ArrayList<Student>();

        loadcount = roading(studentList); //기존 데이터 불러오기 & 기존 리스트 개수 확인
        start(studentList);
    }

    public static void start(ArrayList<Student> studentList) throws IOException {
        String check;
        String save = "";
        String save1 = "";
        String save2 = "";
        int loadcount = 0;
        int checking = 0;
        String ch;
        boolean login = false;
        String line = "";

        Student student = new Student();
        Master master = new Master();

        //프로그램 실행 문구
        System.out.println("성적산출프로그램입니다.\n");
        System.out.println("본 프로그램은 컴퓨터공학과 학생의 성적을 산출하는 프로그램입니다.");
        System.out.println("\n");

        //프로그램 시작 (모드 선택)
        switch (check = student.modeChecking()) {
            case "1": //관리자 모드
                break;
            case "2": //학생 모드
                break;
            case "종료": //프로그램 종료
                break;
            case "잘못된 접근": //잘못된 접근
                break;
        }

        while (true) {
            if (check.equals("종료") || save2.equals("종료") || save.equals("종료")) break;
            else if (check.equals("잘못된 접근") || save2.equals("잘못된 접근"))      break;
            else if (check.equals("1")) { //관리자 모드를 선택한 경우
                if (login == false) {
                    login = master.Login(); //관리자 모드 로그인
                    if(login == false) break; //로그인 실패시 프로그램 종료
                }
                //데이터 입력(1) / 확인(2) /프로그램 종료(3) save에 저장
                save = master.checkingMaster();
                if (save.equals("종료")) break; //프로그램 종료(3)을 선택한 경우
                save1 = master.ProCheck(save, studentList); //데이터 입력 / 확인 처리
                if(save.equals("1")){
                    Write(studentList, save1, loadcount); //1이면 데이터 입력
                    save2 = exit();
                }
                //2번이면 데이터 확인 (학생이름으로 데이터 출력)
                if (save.equals("2")){
                    printChoice(studentList, save1);
                    save2 = exit();
                }
            } else { //학생 모드를 선택한 경우
                save = student.checkingStudent();
                printChoice(studentList, save);
                save2 = exit();
            }
        }
    }

    //로딩 메서드
    public static int roading(ArrayList<Student> studentList) throws IOException {
        String line = "";
        int count = 0;

        BufferedReader reader = new BufferedReader(new FileReader("src/Information.txt"));

        while ((line = reader.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line, " / ");
            studentList.add(new Student(st.nextToken(), st.nextToken(), st.nextToken()));
            studentList.get(count++).plusScore(st.nextToken(), Integer.parseInt(st.nextToken()), st.nextToken());
        }
        return count;
    }

    //데이터 출력 메서드
    public static void printAll(ArrayList<Student> studentList) {
        System.out.println("-------------2022년도 성적-------------");
        System.out.println("학번 / 이름 / 소속 / 과목명 / 점수 / 성적\n");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.print(studentList.get(i).getID());
            System.out.print(" / ");
            System.out.print(studentList.get(i).getName());
            System.out.print(" / ");
            System.out.print(studentList.get(i).getAffiliation());
            System.out.print(" / ");
            studentList.get(i).comeData();
        }
    }

    //데이터 선택 출력 메서드
    public static void printChoice(ArrayList<Student> studentList, String save) {
        String line = "";
        int count = 0;
        System.out.println("-------------2022년도 성적-------------");
        System.out.println("학번 / 이름 / 소속 / 과목명 / 점수 / 성적\n");
        for(int i = 0;i < studentList.size();i++) {
            if(save.equals(studentList.get(i).getName())) {
                System.out.print(studentList.get(i).getID());
                System.out.print(" / ");
                System.out.print(studentList.get(i).getName());
                System.out.print(" / ");
                System.out.print(studentList.get(i).getAffiliation());
                System.out.print(" / ");
                studentList.get(i).comeData();
                count++;
            }
        }
        if(count == 0) System.out.print("입력 정보가 없습니다.");
        System.out.println("");
    }

    public static String exit() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String ch;
        System.out.print("프로그램을 종료하시겠습니까? Y/N  ");
        ch = bf.readLine();
        if (ch.equals("Y")) {
            System.out.println("프로그램을 종료합니다.\n이용해주셔서 감사합니다.");
            return "종료";
        }
        else if(ch.equals("N")) return "계속";
        else {
            return "잘못된 접근";
        }
    }

    //데이터 입력 메서드
    public static void Write(ArrayList<Student> studentList, String saving, int loadcount) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("src/Information.txt");
        //FileWriter fileWriter = new FileWriter(file, true);

        String save = null;
        String save1 = null;
        String save2 = null;
        String ch;
        int count = 0;
        switch (saving) {
            case "1": //기존 학생을 입력하는 경우
                System.out.println("--------------");
                for(int i = 0;i < studentList.size();i++) {
                    System.out.println(studentList.get(i).getName());
                }
                System.out.println("--------------\n");
                System.out.print("어떤 학생의 정보를 보시겠습니까? ");
                ch = bf.readLine();

                for(int i = 0; i < studentList.size();i++){
                    if(ch.equals(studentList.get(i).getName()))     count++;
                }

                if(count == 0) System.out.println("\n입력한 학생이 없습니다.\n");
                if(count > 0)  System.out.println(ch + " 학생의 정보입니다.\n");

                for(int i = 0;i < studentList.size();i++) { //수강하는 과목 보여주기
                   if(ch.equals(studentList.get(i).getName())) {
                       System.out.println("----------------------------");
                       System.out.println("[학번 / 소속]");
                       System.out.print(studentList.get(i).getID());
                       System.out.println(" / " + studentList.get(i).getAffiliation());
                       System.out.println("----------------------------");
                       System.out.println("[수강과목]");
                       studentList.get(i).SubjectData();
                       System.out.println("\n");
                   }
                }
                break;

            case "2": //신규 학생을 입력하는 경우
                System.out.print("학번을 입력하시오. : ");
                save = bf.readLine();
                System.out.print("이름을 입력하시오. : ");
                save1 = bf.readLine();
                System.out.print("소속을 입력하시오. : ");
                save2 = bf.readLine();
                studentList.add(new Student(save, save1, save2));

                System.out.print("\n[이번학기 수강과목]\n");
                System.out.print("[1] 컴퓨터네트워크\n[2] 시스템프로그래밍\n");
                System.out.print("[3] 객체지향프로그래밍\n[4] 정보보안\n");
                System.out.print("[5] 웹프로그래밍\n[6] 데이터구조\n");
                System.out.println("");
                System.out.print("과목을 입력하시오. : ");
                save = bf.readLine();
                System.out.print("점수를 입력하시오. : ");
                save1 = bf.readLine();
                System.out.print("등급을 입력하시오. : ");
                save2 = bf.readLine();

                studentList.get(loadcount).plusScore(save, Integer.parseInt(save1), save2);
                Backup(studentList, loadcount);
                break;
            default:
                System.out.println("잘못된 접근입니다.");
        }
    }

    //백업 메서드
    public static void Backup(ArrayList<Student> studentList, int loadcount) throws IOException {
        File file = new File("src/Information.txt");
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        writer.write(studentList.get(loadcount).getID());
        writer.write(" / ");
        writer.write(studentList.get(loadcount).getName());
        writer.write(" / ");
        writer.write(studentList.get(loadcount).getAffiliation());
        writer.write(" / ");
        writer.write(String.valueOf(studentList.get(loadcount).backupinputdata(loadcount)));
        writer.write("\n");
        writer.close();
    }
}
