package ST;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//학생클래스
public class Student {
    String ID; //학생학번
    String name; //학생이름
    String affiliation; //학생소속
    int check;
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    //Student 클래스 기본생성자
    public Student(String ID, String name, String affiliation) {
        this.ID = ID;
        this.name = name;
        this.affiliation = affiliation;
    }

    //Student 클래스 디폴트생성자
    public Student() { }

    //설정자 생성
    public void setID(String ID) { this.ID = ID; }
    public void setName(String name) { this.name = name; }
    public void setAffiliation(String affiliation) { this.affiliation = affiliation; }

    //접근자 생성
    public String getID() { return ID; }
    public String getName() { return name; }
    public String getAffiliation() { return affiliation; }


    //관리자인지 학생인지 확인하는 함수
    public String checking() throws IOException {
        System.out.print("[1] 관리자 [2]학생 [3] 프로그램 종료 : ");
        //모드 선택
        check = Integer.parseInt(bf.readLine());
        if(check == 1){ //관리자 모드라면
            System.out.print("[1] 데이터 입력 [2] 데이터 확인 [3] 프로그램 종료 : ");
            check = Integer.parseInt(bf.readLine()); //항목 선택
            System.out.println("\n");
            return String.valueOf(check); //입력 항목 번호 반환
        }
        else if(check == 2){ //학생 모드라면
            System.out.print("학생의 이름을 입력해주세요. : ");
            name = bf.readLine(); //이름 입력
            System.out.println("\n");
            return name; //이름값 반환

        }
        else if(check == 3){

            return String.valueOf(3); //잘못된 접근의 경우 0반환
        }
        else { //관리자모드와 학생모드가 아닌 다른 모드 선택시
            System.out.println("잘못된 접근입니다.\n" + "나가세요.");
            return String.valueOf(0); //잘못된 접근의 경우 0반환
        }
    }

    public void print() {
        System.out.print(ID + " / " + name + " / " + affiliation + " / ");
    }
}