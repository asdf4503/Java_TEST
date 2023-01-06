package ST;

//점수클래스
public class Score {
    int score = -1; //점수
    String ID;

    //Score 클래스 기본생성자
    public Score(String ID, int score) {
        this.ID = ID;
        this.score = score;
    }


    //Score 클래스 디폴트생성자
    public Score() { }

    //설정자 && 접근자
    public void setScore(int score){ this.score = score; }
    public int getScore() { return score; }

    //점수를 입력했는지 확인하는 함수
    public void sccount() {
        if(score < 0) {
            System.out.println("점수를 입력하시오.");
        }
    }

    
}
//학생 학번을 확인해서 존재하면 점수 리턴
/*
public int cheakScore(String str) {
        if(str == ID){
            return score;
        }
        return 0;
    }
 */
