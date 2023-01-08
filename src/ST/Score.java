package ST;

//점수클래스
public class Score {
    int score = -1; //점수
    String ID; //학번

    //Score 클래스 기본생성자
    public Score(int score) {
        //this.ID = ID;
        this.score = score;
    }


    //Score 클래스 디폴트생성자
    public Score() { }

    //설정자 && 접근자
    public void setScore(int score){ this.score = score; }
    public int getScore() { return score; }
    public void print() {
        System.out.print(score + " / ");
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