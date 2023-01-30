import ST.*;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        int loadcount = 0;
        ArrayList<Student> studentList = new ArrayList<Student>();
        Management management = new Management();

        loadcount = management.roading(studentList); //기존 데이터 불러오기 & 기존 리스트 개수 확인
        management.start(studentList, loadcount);
    }
}