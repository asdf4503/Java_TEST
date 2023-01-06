package ST;

//과목클래스
public class Subject {
    String subject; //과목명
    String ID;

    //Subject 클래스 기본생성자
    public Subject(String ID, String subject) {
        this.ID = ID;
        this.subject = subject;
    }

    //Subject 클래스 디폴트생성자
    public Subject() { }

    //설정자 && 접근자
    public void setSubject(String subject) { this.subject = subject; }
    public void getID(String ID) { this.ID = ID; }
    public String getSubject() { return subject; }

    //과목을 입력했는지 확인하는 함수
    public void sjcount() {
        if(subject == null){
            System.out.println("과목을 입력하십시오.");
        }
    }
}
//학생의 학번을 확인해서 존재하면 과목을 리턴
/*public String cheakSubject(String str){
        if(str == ID) {
            return subject;
        }
        return ID;
    }

 */
