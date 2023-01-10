package ST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//교수 클래스
public class Master {
    String ProPw; //
    String check;
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public Master() { } //관리자 클래스 디폴트 생성자

    public boolean Login() throws IOException{
        String propw = "super"; //관리자 번호
        System.out.print("관리자 번호를 입력하시오. : ");
        ProPw = bf.readLine(); //관리자 번호입력
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

    //관리자모드 함수
    public String ProCheck(String ck) throws IOException {
        if(ck.equals("1")){ //처음 접근할떄 성적 입력을 선택한 경우
            System.out.println("항목을 선택하시오.");
            System.out.print("[1] 학생 입력 [2] 과목 입력 [3] 점수 입력 : ");
            check = bf.readLine();
            System.out.println("\n");
            return check;
        }
        else if(ck.equals("2")) { //성적 확인을 선택한 경우
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