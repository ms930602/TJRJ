import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import net.coobird.thumbnailator.Thumbnails;

public class MyTest {
	
	@Test
	public void test() throws IOException{
		File fromPic = new File("D:\\vs\\6342a197-78b7-4074-971d-0d068d1e9be3.jpg");//目标图片位置-图片源
		File toPic = new File("D:\\vs\\2018\\缩小的图片.jpg");	          //生成文件位置
		File waterPic=new File("picture/水印图片.jpg");            //作为水印的图片
		InputStream input = new FileInputStream(fromPic);
		File file = new File("D:\\vs\\2018\\");
		if(!file.exists()){
			file.mkdirs();
		}
		Thumbnails.of(input).size(180,150).toFile(toPic);
	}
	
}
