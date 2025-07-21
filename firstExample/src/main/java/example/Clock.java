package example;

import java.text.SimpleDateFormat;
import java.util.Date;

// 출력 오류나는게 정상. date.jsp로 호출하려고 만든 클래스기 때문에. 
// 웹에서 클래스를 접근하기 위해서는 반드시 패키지를 설정. 
public class Clock {
	public String now() {
		Date jiwon = new Date();
		SimpleDateFormat dateFormant = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		return dateFormant.format(jiwon);
	}
}
