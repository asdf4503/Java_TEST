package ST;

//점수클래스
public class Score {
    private int score = -1; //점수
    private String ID; //학번
    private String grade; //성적
    private String subject;


    //Score 클래스 기본생성자
    public Score(String subject, int score, String grade) {
        this.subject = subject;
        this.score = score;
        this.grade = grade;
    }

    //Score 클래스 디폴트생성자
    public Score() { }

    //설정자 && 접근자
    public void setScore(int score){ this.score = score; }
    public int getScore() { return score; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getSubject() { return subject; }

    public void setGrade(String grade) { this.grade = grade; }
    public String getGrade() { return grade; }
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