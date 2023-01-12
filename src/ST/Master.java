package ST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//교수 클래스
public class Master {
    String ProPw; //
    String check;
    int checking;
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public Master() { } //관리자 클래스 디폴트 생성자

    public boolean Login() throws IOException{
        String propw = "super"; //관리자 번호
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
    public String checkingMaster() throws IOException {
        System.out.print("[1] 데이터 입력 [2] 데이터 확인 [3] 프로그램 종료 : ");
        checking = Integer.parseInt(bf.readLine()); //항목 선택
        System.out.println("\n");
        if (checking == 3) { //프로그램 종료를 선택한 경우
            System.out.println("프로그램을 종료합니다.");
            return "종료"; //프로그램 종료
        }
        return String.valueOf(checking); //입력 항목 번호 반환
    }
    //관리자모드 함수
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
        else { //잘못된 접근일 경우
            System.out.println("잘못된 접근입니다.");
            return String.valueOf(0);
        }
    }
}