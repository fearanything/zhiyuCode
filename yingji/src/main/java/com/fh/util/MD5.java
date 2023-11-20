package com.fh.util;

import java.security.MessageDigest;

import cn.hutool.crypto.SmUtil;
/** 
 * 说明：MD5处理
 * 创建人：FH Q313596790
 * 修改时间：2014年9月20日
 * @version
 */
public class MD5 {

	public static String md5(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			str = buf.toString();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return str;
	}
	public static void main(String[] args) {
		//System.out.println(md5("JH1c463945218a89b50c1578b4e0b3a0be"+"cc40b82d06b9bfe54ecdff9f4953d011" + "15595757943" + "10" + "asxxlaogui"));
		//System.out.println(md5("mj1"));
		
		String plain = "b4b25a6f6656bd1bed98a27ae68f532920220804163701{\"password\":\"cbdddb8e8421b23498480570d7d75330538a6882f5dfdc3b64115c647f3328c4\",\"pwdHashType\":\"1\",\"userName\":\"admin\",\"userId\":\"admin\"}";
        String hashString ="";
        try {
        	 hashString = SmUtil.sm3(plain);
        	 System.out.println("hashString结果:"+hashString);
        }catch(Exception ex){
        	System.out.println(ex.getMessage());
        }
	}
}
