package com.fh.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.sql.Connection;
import java.util.Properties;

import com.fh.entity.FtpInfo;




/** 
 * 说明：用于备份、还原数据库、在线编辑SQL
 * 创建人：FH Q313596790
 * 修改时间：2016年3月29日
 * @version
 */
public class FH{
	private static Properties pros = getPprVue();
	private static FH dbFH = new FH();
	
	public static FH getDbFH(){
		return dbFH;
	}
	
	/**
	 * 获取域名
	 */
	public static String getWebUrl(){
		return pros.getProperty("weburl");
		
	}
	
	/**
	 * @return 获取conn对象(通过PageData)
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static FtpInfo getFtpInfo(){
		FtpInfo ftpinfo=new FtpInfo();
		ftpinfo.setFtpUrl( pros.getProperty("ftpUrl"));
		ftpinfo.setUserName(pros.getProperty("userName"));
		ftpinfo.setPassword(pros.getProperty("password"));
		ftpinfo.setPort(pros.getProperty("port"));
		ftpinfo.setDirectory(pros.getProperty("directory"));
		return ftpinfo;
		
	}
	
	
	/**读取dbfh.properties 配置文件
	 * @return
	 * @throws IOException
	 */
	public static Properties getPprVue() {
		InputStream inputStream = FH.class.getClassLoader().getResourceAsStream("fh.properties");
		Properties p = new Properties();
		try {
			p.load(inputStream);
			inputStream.close();
		} catch (IOException e) {
			//读取配置文件出错
			e.printStackTrace();
		}
		return p;
	}
	

}




//创建人：FH Q 3 135 9 67 90