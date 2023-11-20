package com.fh.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.*;

//import com.sun.xml.internal.ws.api.addressing.WSEndpointReference.Metadata;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifDirectoryBase;
import com.sun.javafx.iio.ImageMetadata;
import com.sun.xml.internal.ws.api.addressing.WSEndpointReference;
import net.coobird.thumbnailator.Thumbnails;


/**	文件处理
*  创建人：FH Q313596790
 * 创建时间：2014年12月23日
 * @author 67623
 */
public class FileUtil {

	
	/**获取文件大小 返回 KB 保留3位小数  没有文件时返回0
	 * @param filepath 文件完整路径，包括文件名
	 * @return
	 */
	public static Double getFilesize(String filepath){
		File backupath = new File(filepath);
		return Double.valueOf(backupath.length())/1000.000;
	}
	
	/**
	 * 创建目录
	 * @param destDirName目标目录名
	 * @return 
	 */
	public static Boolean createDir(String destDirName) {
		File dir = new File(destDirName);
		if(!dir.getParentFile().exists()){				//判断有没有父路径，就是判断文件整个路径是否存在
			return dir.getParentFile().mkdirs();		//不存在就全部创建
		}
		return false;
	}

	/**
	 * 删除文件
	 * @param filePathAndName
	 *            String 文件路径及名称 如c:/fqf.txt
	 * @param fileContent
	 *            String
	 * @return boolean
	 */
	public static void delFile(String filePathAndName) {
		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			java.io.File myDelFile = new java.io.File(filePath);
			myDelFile.delete();
		} catch (Exception e) {
			System.out.println("删除文件操作出错");
			e.printStackTrace();
		}
	}

	/**
	 * 读取到字节数组0
	 * @param filePath //路径
	 * @throws IOException
	 */
	public static byte[] getContent(String filePath) throws IOException {
		File file = new File(filePath);
		long fileSize = file.length();
		if (fileSize > Integer.MAX_VALUE) {
			System.out.println("file too big...");
			return null;
		}
		FileInputStream fi = new FileInputStream(file);
		byte[] buffer = new byte[(int) fileSize];
		int offset = 0;
		int numRead = 0;
		while (offset < buffer.length
				&& (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
			offset += numRead;
		}
		// 确保所有数据均被读取
		if (offset != buffer.length) {
			throw new IOException("Could not completely read file " + file.getName());
		}
		fi.close();
		return buffer;
	}

	/**
	 * 读取到字节数组1
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static byte[] toByteArray(String filePath) throws IOException {

		File f = new File(filePath);
		if (!f.exists()) {
			throw new FileNotFoundException(filePath);
		}
		ByteArrayOutputStream bos = new ByteArrayOutputStream((int) f.length());
		BufferedInputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(f));
			int buf_size = 1024;
			byte[] buffer = new byte[buf_size];
			int len = 0;
			while (-1 != (len = in.read(buffer, 0, buf_size))) {
				bos.write(buffer, 0, len);
			}
			return bos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			bos.close();
		}
	}

	/**
	 * 读取到字节数组2
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static byte[] toByteArray2(String filePath) throws IOException {
		File f = new File(filePath);
		if (!f.exists()) {
			throw new FileNotFoundException(filePath);
		}
		FileChannel channel = null;
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(f);
			channel = fs.getChannel();
			ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
			while ((channel.read(byteBuffer)) > 0) {
				// do nothing
				// System.out.println("reading");
			}
			return byteBuffer.array();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				channel.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Mapped File way MappedByteBuffer 可以在处理大文件时，提升性能
	 * 
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static byte[] toByteArray3(String filePath) throws IOException {

		FileChannel fc = null;
		RandomAccessFile rf = null;
		try {
			rf = new RandomAccessFile(filePath, "r");
			fc = rf.getChannel();
			MappedByteBuffer byteBuffer = fc.map(MapMode.READ_ONLY, 0,
					fc.size()).load();
			//System.out.println(byteBuffer.isLoaded());
			byte[] result = new byte[(int) fc.size()];
			if (byteBuffer.remaining() > 0) {
				// System.out.println("remain");
				byteBuffer.get(result, 0, byteBuffer.remaining());
			}
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				rf.close();
				fc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static String path = "D:\\Workspaces\\project\\mvnfhm\\src\\main\\webapp\\uploadFiles\\syjjImgs\\20171018\\";      
	  
    public static void main(String[] args) throws IOException { 
    	File file1 =null;
        file1 = new File(path, "20171018102247.jpg");  
       
        File file2 =null;
        file2 = new File(path, "20171018102332.jpg");  
        File file3 =null;
        file3 = new File(path, "20171018102336.jpg"); 
        File file4 =null;
        file4 = new File(path, "7.jpg"); 
        File toFile =null;
        toFile = new File(path, "9.jpg"); 
        mergeImage(file1, file2,file3,file4,toFile); 
        File fromPic = new File(path,  "7.jpg");
        File toPic = new File(path,  "9.jpg");
        //Thumbnails.of(fromPic).scale(1f).outputQuality(0.25f).toFile(toPic);
    }  
    /**
     * 合并图片
     * @param file1
     * @param file2
     * @param file3
     * @param file4
     * @param toFile
     * @throws IOException
     */
    public static void mergeImage(File file1, File file2,File file3,File file4,File toFile) throws IOException {   
    	try{
    		 BufferedImage image1 =null;
    		 BufferedImage image2=null;
    		 BufferedImage image3=null;
    		 BufferedImage image4=null;
    		 if(file1!=null){
    			 image1 = ImageIO.read(file1); 
    		 }
    		 if(file2!=null){
    			 image2 = ImageIO.read(file2); 
    		 }
    		 if(file3!=null){
    			 image3 = ImageIO.read(file3); 
    		 }
    		 if(file4!=null){
    			 image4 = ImageIO.read(file4); 
    		 }
    	     BufferedImage combined = new BufferedImage(image1.getWidth() * 2, image1.getHeight()*2, BufferedImage.TYPE_INT_RGB);
    	        // paint both images, preserving the alpha channels  
	        Graphics g = combined.getGraphics();
	        if(image1!=null){
	        	g.drawImage(image1, 0, 0, null);  
	        }
	        if(image2!=null){
	        	g.drawImage(image2, image1.getWidth(), 0, null);  
	        }
	        if(image3!=null){
	        	g.drawImage(image3, 0, image1.getHeight(), null);	
	        }
	        if(image4!=null){
	        	g.drawImage(image4, image3.getWidth(), image1.getHeight(), null);
	        }
	        // Save as new image  ;
	        ImageIO.write(combined, "JPG", toFile);
	      //图片尺寸不变，压缩图片文件大小outputQuality实现,参数1为最高质量   
    	}catch(Exception ex){
    		
    	}
    }

	/**
	 * Image转BufferedImage
	 *
	 * @param image
	 * @return
	 */
	public static BufferedImage toBufferedImage(Image image) {
		if (image instanceof BufferedImage) {
			return (BufferedImage) image;
		}
		image = new ImageIcon(image).getImage();
		boolean hasAlpha = false;
		BufferedImage bimage = null;
		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		try {
			int transparency = Transparency.OPAQUE;
			if (hasAlpha) {
				transparency = Transparency.BITMASK;
			}
			GraphicsDevice gs = ge.getDefaultScreenDevice();
			GraphicsConfiguration gc = gs.getDefaultConfiguration();
			bimage = gc.createCompatibleImage(image.getWidth(null),
					image.getHeight(null), transparency);
		} catch (HeadlessException e) {
		}
		if (bimage == null) {
			int type = BufferedImage.TYPE_INT_RGB;
			if (hasAlpha) {
				type = BufferedImage.TYPE_INT_ARGB;
			}
			bimage = new BufferedImage(image.getWidth(null),
					image.getHeight(null), type);
		}
		Graphics g = bimage.createGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();
		return bimage;
	}

	/**
	 * 计算图片旋转角度
	 * @param filePath   被旋转图片路径
	 */
	public static void calculateRotation(String filePath) throws IOException, ImageProcessingException {

		File fileTest = new File(filePath);
		//metadata查看图片信息
		Metadata metadata = ImageMetadataReader.readMetadata(fileTest);
		StringBuilder description = new StringBuilder();
		for (Directory directory : metadata.getDirectories()) {
			for (Tag tag : directory.getTags()) {
				System.out.println(tag + " = " + tag.getDescription());
				if (tag.getTagType() == ExifDirectoryBase.TAG_ORIENTATION) {
					description.append(tag.getDescription().replaceAll(" ", ""));
				}
			}
		}

		int rotateIndex = description.indexOf("Rotate");
		int cwIndex = description.indexOf("CW");
		if (rotateIndex >= 0 && cwIndex > 0 && rotateIndex < cwIndex) {
			int angel = Integer.parseInt(description.substring(rotateIndex + 6, cwIndex));
			FileUtil.Rotate(filePath,angel);
		}
	}

	/**
	 * 对图片进行旋转
	 * @param filePath   被旋转图片路径
	 * @param angel 旋转角度
	 * @return 旋转后的图片
	 */
	public static void Rotate(String filePath,int angel) throws IOException {
		ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();

		//需要导入的图片
		File file = new File(filePath);

		Image src = Toolkit.getDefaultToolkit().getImage(file.getPath());;
		BufferedImage bufferImg = toBufferedImage(src);
		ImageIO.write(bufferImg, "jpg", byteArrayOut);

		int srcWidth = src.getWidth(null);
		int srcHeight = src.getHeight(null);
		// 计算旋转后图片的尺寸
		Rectangle rect_des = CalcRotatedSize(new Rectangle(new Dimension(
				srcWidth, srcHeight)), angel);
		BufferedImage res = null;
		res = new BufferedImage(rect_des.width, rect_des.height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = res.createGraphics();
		// 进行转换
		g2.translate((rect_des.width - srcWidth) / 2,
				(rect_des.height - srcHeight) / 2);
		g2.rotate(Math.toRadians(angel), (double) srcWidth / 2, (double) srcHeight / 2);
		g2.drawImage(src, null, null);

		//将buffedImage写入file
		ImageIO.write(res,"jpg",file);
//		return res;
	}

	/**
	 * 计算旋转后的图片
	 *
	 * @param src   被旋转的图片
	 * @param angel 旋转角度
	 * @return 旋转后的图片
	 */
	private static Rectangle CalcRotatedSize(Rectangle src, int angel) {
		// 如果旋转的角度大于90度做相应的转换
		if (angel >= 90) {
			if (angel / 90 % 2 == 1) {
				int temp = src.height;
				src.height = src.width;
				src.width = temp;
			}
			angel = angel % 90;
		}
		double r = Math.sqrt(src.height * src.height + src.width * src.width) / 2;
		double len = 2 * Math.sin(Math.toRadians(angel) / 2) * r;
		double angelAlpha = (Math.PI - Math.toRadians(angel)) / 2;
		double angelDeltaWidth = Math.atan((double) src.height / src.width);
		double angelDeltaHeight = Math.atan((double) src.width / src.height);
		int lenDeltaWidth = (int) (len * Math.cos(Math.PI - angelAlpha
				- angelDeltaWidth));
		int lenDeltaHeight = (int) (len * Math.cos(Math.PI - angelAlpha
				- angelDeltaHeight));
		int desWidth = src.width + lenDeltaWidth * 2;
		int desHeight = src.height + lenDeltaHeight * 2;
		return new Rectangle(new Dimension(desWidth, desHeight));
	}

}