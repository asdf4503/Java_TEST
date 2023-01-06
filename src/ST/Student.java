package ST;

//학생클래스
public class Student {
    String ID; //학생학번
    String name; //학생이름
    String affiliation; //학생소속

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

    //학생을 입력했는지 확인하는 함수
    public void stcount(){
        if(ID == null || name == null || affiliation == null) {
            System.out.println("학생이 없습니다.");
        }
    }

    /*
    public void showStudent(){
        System.out.print();
    }*/
}