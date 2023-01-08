package ST;

//성적 클래스
public class Grade{
    String grade; //성적
    int point; //점수

    //Grade 클래스 기본생성자
    public Grade(int point) {
      this.point = point;
    }
    
    //Grade 클래스 디폴트 생성자
    public Grade() {  }

    //Score 클래스에서 점수를 받아와 성적을 매기는
    public String getGrade() {

        if (point > 89)     grade = "A"; //90점 이상이면 A
        else if(point > 79) grade = "B"; //80점 이상이면 B
        else if(point > 69) grade = "C"; //70점 이상이면 C
        else if(point > 59) grade = "D"; //60점 이상이면 D
        else                grade = "F"; //그 이하 F
        return grade; //grade값 리턴
    }
    public void print() {
        System.out.print(grade);
    }
}
//---------------------------------------------------------------------------------------
 /* 점수가 없으면 성적이 존재할 수 없다.
    Score 클래스에서 점수를 확인해줬기 떄문에 Grade 클래스 중복 확인해줄필요없음

    //성적을 매기기 위한 점수가 존재하는지 확인하는 함수
    public void Gcount(int point){
        if(point < 0 ){
            System.out.println("성적이 존재하지 않습니다.");
        }
    }
*/
