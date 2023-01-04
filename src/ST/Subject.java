package ST;

//과목클래스
public class Subject {
    String subject; //과목명

    //Subject 클래스 기본생성자
    public Subject(String subject) {
        this.subject = subject;
    }

    //Subject 클래스 디폴트생성자
    public Subject() { }

    //설정자 && 접근자
    public void setSubject(String subject) { this.subject = subject; }
    public String getSubject() { return subject; }

    //과목을 확인하는 함수
    public void sjcount() {
        if(subject == null){
            System.out.println("과목을 입력하십시오.");
        }
    }

}
