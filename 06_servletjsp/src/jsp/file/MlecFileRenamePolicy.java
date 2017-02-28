package jsp.file;

import java.io.File;
import java.util.UUID;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MlecFileRenamePolicy implements FileRenamePolicy{

	@Override
	public File rename(File f) {
		// C:/java90/tomcat-work/wtpwebapps/06_servletjsp/upload/2017/01/19/chicken.jpg 라면 getName은 맨 뒤 이름만! 
		String name = f.getName(); // chicken.jpg
		
		String parent = f.getParent(); // 파일의 경로 -> C:/java90/tomcat-work/wtpwebapps/06_servletjsp/upload/2017/01/19
		
		// 확장자 추출하기
		String ext = "";
		int index = name.lastIndexOf(".");
		// 모든 파일이 확장자를 가져야하는 것은 아님
		if (index != -1)
			ext = name.substring(index);
		
		// 파일 이름 고유하게 생성하기
		String uName = UUID.randomUUID().toString();
		//(임시 비밀번호)
		
		return new File(parent, uName + ext);
	}

}
