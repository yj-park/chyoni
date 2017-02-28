package kr.co.mlec.file;

import java.io.File;
import java.util.UUID;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MlecFileRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File f) {
		// C:/java90/.../upload/2017/01/19/aaa.jpg
		String name = f.getName();  // aaa.jpg
		
		String parent = f.getParent(); // // C:/java90/.../upload/2017/01/19
		
		String ext = "";
		int index = name.lastIndexOf(".");
		if (index != -1) 
			ext = name.substring(index);
		
		// 파일 이름 고유하게 생성하기
		String uName = UUID.randomUUID().toString();
		return new File(parent, uName + ext);
	}
}










