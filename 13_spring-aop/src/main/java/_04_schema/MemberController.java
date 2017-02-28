package _04_schema;

import java.util.Random;

public class MemberController implements Controller {
		@Override
		public void execute() throws Exception {

		// 핵심 기능 - 등록 과정 (원래 MemberController가 해야할 일)
		Random r = new Random();
		for (int i = 0; i < r.nextInt(100); i++) {
			Thread.sleep(100);
		}
		System.out.println("MemberController 실행됨");
	
	}
	
}
