package ST;

//점수클래스
public class Score {
    int score = -1; //점수
    String ID; //학번
    String grade; //성적
    String subject;


    //Score 클래스 기본생성자
    public Score(String subject, int score) {
        this.score = score;
        this.subject = subject;
    }

    //Score 클래스 디폴트생성자
    public Score() { }

    //설정자 && 접근자
    public void setScore(int score){ this.score = score; }
    public int getScore() { return score; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getSubject() { return subject; }
    public String getGrade() {
        if (score > 89)     grade = "A"; //90점 이상이면 A
        else if(score > 79) grade = "B"; //80점 이상이면 B
        else if(score > 69) grade = "C"; //70점 이상이면 C
        else if(score > 59) grade = "D"; //60점 이상이면 D
        else                grade = "F"; //그 이하 F
        return grade; //grade값 리턴
    }
}
//---------------------------------------------------------------------------------------
//학생 학번을 확인해서 존재하면 점수 리턴
/*
public int cheakScore(String str) {
        if(str == ID){
            return score;
        }
        return 0;
    }
 */