package com.fh.util.weixin;

import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fh.entity.menubase.CustomMenu;
import com.fh.entity.weixin.Button;
import com.fh.entity.weixin.CommonButton;
import com.fh.entity.weixin.ComplexButton;
import com.fh.entity.weixin.Menu;
import com.fh.entity.weixin.ViewButton;
import com.fh.util.FH;
import com.fh.util.PageData;
import com.wx.framework.core.wx4j.common.Wx4javaConfig;

/**
 * 
* 类描述： 微信自定义菜单
* @author FH  31 35 96790
* 作者单位： 
* 联系方式：
* 创建时间：206年11月1日
* @version 1.0
 */
public class MenuUtil {
	/**
	 * 	创建自定义菜单(每天限制1000次),方法1
	 * */
	public static int createMenu(Menu menu,String appid, String appsecret){
		
		String jsonMenu=JSONObject.fromObject(menu).toString();
		
		int status=0;
		
		//System.out.println("菜单："+jsonMenu);
		Weixin wx = new Weixin();
		String path="https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+wx.getAccess_token(appid, appsecret);
		try {
			URL url=new URL(path);
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			http.setDoOutput(true);
			http.setDoInput(true);
			http.setRequestMethod("POST");
			http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
			http.connect();
			OutputStream os = http.getOutputStream();
			os.write(jsonMenu.getBytes("UTF-8"));
			os.close();
			
			InputStream is = http.getInputStream();
			int size = is.available();
			byte[] bt = new byte[size];
			is.read(bt);
			String message=new String(bt,"UTF-8");
			JSONObject jsonMsg = JSONObject.fromObject(message);
			status = Integer.parseInt(jsonMsg.getString("errcode"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	/**
	 * 创建自定义菜单(每天限制1000次),方法2,用CustomMenu
	 */
	public static int createCustomMenu(CustomMenu menu, String appid, String appsecret) {

		String jsonMenu = JSONObject.fromObject(menu).toString();

		int status = 0;

		System.out.println("菜单："+jsonMenu);
		Weixin wx = new Weixin();
		String path = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="
				+ wx.getAccess_token(appid, appsecret);
		try {
			URL url = new URL(path);
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.setDoOutput(true);
			http.setDoInput(true);
			http.setRequestMethod("POST");
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			http.connect();
			OutputStream os = http.getOutputStream();
			os.write(jsonMenu.getBytes("UTF-8"));
			os.close();

			InputStream is = http.getInputStream();
			int size = is.available();
			byte[] bt = new byte[size];
			is.read(bt);
			String message = new String(bt, "UTF-8");
			JSONObject jsonMsg = JSONObject.fromObject(message);
			status = Integer.parseInt(jsonMsg.getString("errcode"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	/**封装菜单数据
	 * @return
	 */
	public static Menu getMenu(List<PageData> varList){
		
		PageData M1 = new PageData();
		PageData M2 = new PageData();
		PageData M3 = new PageData();
		
		List<PageData> listm1 = new ArrayList<PageData>();
		List<PageData> listm2 = new ArrayList<PageData>();
		List<PageData> listm3 = new ArrayList<PageData>();
		
		String[] arraym1 = {"M11","M12","M13","M14","M15"};
		String[] arraym2 = {"M21","M22","M23","M24","M25"};
		String[] arraym3 = {"M31","M32","M33","M34","M35"};
		
		for(int i=0;i<varList.size();i++){
			PageData pd = varList.get(i);
			if("M1".equals(pd.getString("XID"))){
				M1 = pd;
			}else if("M2".equals(pd.getString("XID"))){
				M2 = pd;
			}else if("M3".equals(pd.getString("XID"))){
				M3 = pd;
			}
		}
		
		for(int n=0;n < arraym1.length;n++){
			for(int i=0;i<varList.size();i++){
				PageData pd = varList.get(i);
				if(arraym1[n].equals(pd.getString("XID"))){
					if(null == pd.getString("TITLE") || "".equals(pd.getString("TITLE").trim())){
						break;
					}
					listm1.add(pd);
				}
			}
		}
		for(int n=0;n < arraym2.length;n++){
			for(int i=0;i<varList.size();i++){
				PageData pd = varList.get(i);
				if(arraym2[n].equals(pd.getString("XID"))){
					if(null == pd.getString("TITLE") || "".equals(pd.getString("TITLE").trim())){
						break;
					}
					listm2.add(pd);
				}
			}
		}
		for(int n=0;n < arraym3.length;n++){
			for(int i=0;i<varList.size();i++){
				PageData pd = varList.get(i);
				if(arraym3[n].equals(pd.getString("XID"))){
					if(null == pd.getString("TITLE") || "".equals(pd.getString("TITLE").trim())){
						break;
					}
					listm3.add(pd);
				}
			}
		}
		
		ComplexButton cx1 = new ComplexButton();
		if(null != M1.getString("TITLE") && !"".equals(M1.getString("TITLE").trim())){
			Button[] arrayB = new Button[listm1.size()];
			for(int i=0;i<listm1.size();i++){
				PageData pd = listm1.get(i);
				if("click".equals(pd.getString("TYPE"))){
					CommonButton cb = new CommonButton();
					cb.setKey(null == pd.getString("CONTENT")?"":pd.getString("CONTENT").trim());
					cb.setName(pd.getString("TITLE").trim());
					cb.setType("click");
					arrayB[i] = cb;
				}else{
					ViewButton vb = new ViewButton();
//					vb.setUrl(null == pd.getString("CONTENT")?"":pd.getString("CONTENT").trim());
					vb.setUrl(null == pd.getString("CONTENT")?"":makeUrl(pd.getString("CONTENT").trim()));
					vb.setName(pd.getString("TITLE").trim());
					vb.setType("view");
					arrayB[i] = vb;
				}
			}
			cx1.setName(M1.getString("TITLE").trim());
			cx1.setSub_button(arrayB);
		}
		
		ComplexButton cx2 = new ComplexButton();
		if(null != M2.getString("TITLE") && !"".equals(M2.getString("TITLE").trim())){
			Button[] arrayB = new Button[listm2.size()];
			for(int i=0;i<listm2.size();i++){
				PageData pd = listm2.get(i);
				if("click".equals(pd.getString("TYPE"))){
					CommonButton cb = new CommonButton();
					cb.setKey(null == pd.getString("CONTENT")?"":pd.getString("CONTENT").trim());
					cb.setName(pd.getString("TITLE").trim());
					cb.setType("click");
					arrayB[i] = cb;
				}else{
					ViewButton vb = new ViewButton();
//					vb.setUrl(null == pd.getString("CONTENT")?"":pd.getString("CONTENT").trim());
					vb.setUrl(null == pd.getString("CONTENT")?"":makeUrl(pd.getString("CONTENT").trim()));
					vb.setName(pd.getString("TITLE").trim());
					vb.setType("view");
					arrayB[i] = vb;
				}
			}
			cx2.setName(M2.getString("TITLE").trim());
			cx2.setSub_button(arrayB);
		}
		
		ComplexButton cx3 = new ComplexButton();
		if(null != M3.getString("TITLE") && !"".equals(M3.getString("TITLE").trim())){
			Button[] arrayB = new Button[listm3.size()];
			for(int i=0;i<listm3.size();i++){
				PageData pd = listm3.get(i);
				if("click".equals(pd.getString("TYPE"))){
					CommonButton cb = new CommonButton();
					cb.setKey(null == pd.getString("CONTENT")?"":pd.getString("CONTENT").trim());
					cb.setName(pd.getString("TITLE").trim());
					cb.setType("click");
					arrayB[i] = cb;
				}else{
					ViewButton vb = new ViewButton();
//					vb.setUrl(null == pd.getString("CONTENT")?"":pd.getString("CONTENT").trim());
					vb.setUrl(null == pd.getString("CONTENT")?"":makeUrl(pd.getString("CONTENT").trim()));
					vb.setName(pd.getString("TITLE").trim());
					vb.setType("view");
					arrayB[i] = vb;
				}
			}
			cx3.setName(M3.getString("TITLE").trim());
			cx3.setSub_button(arrayB);
		}
		
		// 剔除空白的菜单
		List<ComplexButton> buttonList = new ArrayList<>();
		if (StringUtils.isNotEmpty(cx1.getName())) {
			buttonList.add(cx1);
		}
		if (StringUtils.isNotEmpty(cx2.getName())) {
			buttonList.add(cx2);
		}
		if (StringUtils.isNotEmpty(cx3.getName())) {
			buttonList.add(cx3);
		}
		ComplexButton[] buttonArray = new ComplexButton[buttonList.size()];
		for (int i = 0; i < buttonList.size(); i++) {
			buttonArray[i] = buttonList.get(i);
		}
		
		Menu menu=new Menu();
		menu.setButton(buttonArray);
		return menu;
	}
	
	/**
	 * 拼接按钮地址
	 * @param url：lxcfhm/frontend/wx/index?target=ywbl
	 * @return
	 */
	public static String makeUrl(String url) {
		String finalUrl = url;
		String weburl = FH.getWebUrl();
		if (!url.contains("www.") && !url.contains("WWW.")) {
			// 不包含www，是内部链接，需要拼接字符串；如果包含www就是外部链接直接跳转
			finalUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?"  
			        + "appid="+ Wx4javaConfig.instance().getAppid()+"&redirect_uri="  
			        + weburl + url + "&response_type=code&scope=snsapi_userinfo&state=1111&connect_redirect=1#wechat_redirect";
		}
		return finalUrl;
	}
}