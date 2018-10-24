import java.io.File;
import java.io.IOException;

import net.coobird.thumbnailator.Thumbnails;
/*
 * 图片压缩类，使用第三方jar包完成图片压缩
 */
public class PictureCompress {
	//主函数，进行功能测试
	public static void main(String[] args) {
		PictureCompress pictureCompress=new PictureCompress();
		pictureCompress.Compress1();
	}

	//按比例进行图片压缩
	//从指定文件夹images读入图片文件，压缩完成后输出到compressimages文件夹
	private void Compress1() {
		// TODO Auto-generated method stub
		//定义源图片文件名和压缩后输出的文件名
		String inputpath="images";
		String compresspath="compressimages";
		
		// 创建文件对象
		File fileinput = new File(inputpath);
		File fileoutput=new File(compresspath);
		// 获取文件夹下的所有文件
		String[] arrayinput = fileinput.list();
		String[] arrayoutput=fileoutput.list();
		if(!arrayoutput.equals(null)) {
			for(String name: arrayoutput) {
				File deletefile=new File(compresspath,name);
				deletefile.delete();
			}
		}
		System.out.println("开始压缩...");
		for(int i=0;i<arrayinput.length;i++) {
			//对文件名分割后获取文件名和文件后缀
			String[] temp=arrayinput[i].split("\\.");
			String name=temp[0],type=temp[1];
			try {
				//图片大小（长宽）变为原来的25%
				Thumbnails.of(inputpath+"/"+name+"."+type).scale(0.25f).toFile(compresspath+"/"+name+"_25%."+type);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(arrayinput[i]+"已压缩完成!");
		}
		System.out.println("压缩结束");
	}
}
