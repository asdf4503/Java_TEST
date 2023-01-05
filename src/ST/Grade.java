package ST;

//성적 클래스
public class Grade extends Score{
    String grade;
    public Grade() {  }

    //Score 클래스에서 점수를 받아와 성적을 매기는
    public String getGrade(int point) {

        if (point > 90)     grade = "A";
        else if(point > 80) grade = "B";
        else if(point > 70) grade = "C";
        else if(point > 60) grade = "D";
        else                grade = "F";
        return grade;
    }
}

 /* 점수가 없으면 성적이 존재할 수 없다.
    Score 클래스에서 점수를 확인해줬기 떄문에 Grade 클래스 중복 확인해줄필요없음

    //성적을 매기기 위한 점수가 존재하는지 확인하는 함수
    public void Gcount(int point){
        if(point < 0 ){
            System.out.println("성적이 존재하지 않습니다.");
        }
    }
    */
