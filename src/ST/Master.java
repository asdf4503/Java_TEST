package ST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//관리자 클래스
public class Master {
    private String ProPw; //관리자 번호
    private String check; //항목선택
    private int checking; //항목선택
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public Master() { } //관리자 클래스 디폴트 생성자

    //로그인 메서드 (관리자 모드에 접속할 땐 관리자번호를 입력해야됨.)
    public boolean Login() throws IOException{
        String propw = "super"; //고정적인 관리자 번호
        System.out.print("\n관리자 번호를 입력하시오. : ");
        ProPw = bf.readLine(); //관리자 번호입력
        System.out.println("");
        if(propw.equals(ProPw)){ //관리자 번호를 제대로 입력한 경우
            System.out.println("관리자 서버 접속 성공");
            System.out.println("\n");
        }
        else { //관리자 번호가 틀린 경우
            System.out.println("관리자 번호가 틀렸습니다.");
            System.out.println("나가세요.");
            return false;
        }
        return true;
    }
    //관리자 모드 항복 선택하는 메서드
    public String checkingMaster() throws IOException {
        System.out.print("[1] 데이터 입력 [2] 데이터 확인 [3] 데이터 삭제 [4] 프로그램 종료 : ");
        checking = Integer.parseInt(bf.readLine()); //4개의 항목 선택
        System.out.println("\n");
        if (checking == 4) { //프로그램 종료를 선택한 경우
            System.out.println("프로그램을 종료합니다.");
            return "종료"; //프로그램 종료
        }
        return String.valueOf(checking); //입력 항목 번호 반환(1, 2, 3)
    }
    
    //항목을 받아와서 관리자모드의 기능을 수행하는 메서드
    public String ProCheck(String ck, ArrayList<Student> studentList) throws IOException {
        if(ck.equals("1")){ //데이터 입력을 선택한 경우
            //기존에 있는 학생인지 신규학생인지 확인
            System.out.print("[1] 기존 학생 [2] 신규 학생 : ");
            check = bf.readLine();
            System.out.println("\n");
            return check;
        }
        else if(ck.equals("2")) { //데이터 확인을 선택한 경우
            System.out.println("--------------");
            for(int i = 0; i < studentList.size();i++){
                System.out.println(studentList.get(i).getName());
            }
            System.out.println("--------------\n");
            System.out.println();
            System.out.print("확인하고 싶은 학생 이름을 입력하시오. : ");
            check = bf.readLine();
            System.out.println("\n");
            return check;
        }
        else if(ck.equals("3")) {
            return check;
        }
        else { //잘못된 접근일 경우
            System.out.println("잘못된 접근입니다.");
            return String.valueOf(0);
        }
    }
}