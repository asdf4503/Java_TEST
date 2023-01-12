package ST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//학생클래스
public class Student {
    private String ID; //학생학번
    private String name; //학생이름
    private String affiliation; //학생소속
    private int check;
    private String grade;
    private ArrayList<Score> scoreList = new ArrayList<Score>(5);
    Score score;
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    //Student 클래스 기본생성자
    public Student(String ID, String name, String affiliation) {
        this.ID = ID;
        this.name = name;
        this.affiliation = affiliation;
        this.scoreList = scoreList;
    }

    //Student 클래스 디폴트생성자
    public Student() {
    }

    //설정자 생성
    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    //접근자 생성
    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void plusScore(String subject, int point, String grade) {
        scoreList.add(new Score(subject, point, grade));
    }

    public void comeData() {
        System.out.print(scoreList.get(0).getSubject());
        System.out.print(" / ");
        System.out.print(scoreList.get(0).getScore());
        System.out.print(" / ");
        System.out.print(scoreList.get(0).getGrade());
        System.out.println();
    }

    //관리자인지 학생인지 확인하는 함수
    public String modeChecking() throws IOException {
        System.out.print("[1] 관리자 [2]학생 [3] 프로그램 종료 : "); //모드 선택
        check = Integer.parseInt(bf.readLine());
        if (check == 1) return String.valueOf(check); //관리자모드
        if (check == 2) return String.valueOf(check); //학생 모드
        else if (check == 3) {
            System.out.println("\n프로그램을 종료합니다.");
            return "종료"; //프로그램 종료
        } else { //관리자모드와 학생모드가 아닌 다른 모드 선택시
            System.out.println("잘못된 접근입니다.\n" + "나가세요.\n");
            System.out.println("프로그램을 종료합니다.");
            return "잘못된 접근"; //잘못된 접근 프로그램 종료
        }
    }


    public String checkingStudent() throws IOException {
        if (check == 2) { //학생 모드라면
            System.out.print("학생의 이름을 입력해주세요. : ");
            name = bf.readLine(); //이름 입력
            System.out.println("\n");
            return name; //이름값 반환
        }
        return null;
    }

    public void SubjectData() {
        for(int i = 0;i < scoreList.size();i++)
            System.out.print(scoreList.get(i).getSubject());
    }

    //백업데이터 불러오기
    public String backupinputdata(int loadcount) {
        String[] backupdata = new String[3];
        String findata = "";

        for(int i = 0;i < scoreList.size();i++) {
            backupdata[i] = scoreList.get(i).getSubject();
            backupdata[i+1] = String.valueOf(scoreList.get(i).getScore());
            backupdata[i+2] = scoreList.get(i).getGrade();
        }
        findata = String.join(" / ", backupdata);
        return findata;
    }
}