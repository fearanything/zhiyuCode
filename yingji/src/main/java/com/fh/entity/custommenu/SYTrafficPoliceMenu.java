package com.fh.entity.custommenu;

import com.wx.framework.core.wx4j.common.Wx4javaConfig;
import com.fh.entity.menubase.Button;
import com.fh.entity.menubase.CustomMenu;
import com.fh.entity.menubase.ViewButton;
import com.fh.util.FH;
import com.fh.util.weixin.MenuUtil;

/**
 * @author laogui
 * 三亚交警自定义菜单
 */
public class SYTrafficPoliceMenu {
	
	public static void main(String[] args) {
		String appId = Wx4javaConfig.instance().getAppid();
		String appSecret = Wx4javaConfig.instance().getAppSecret();
		int status = MenuUtil.createCustomMenu(getTrafficPoliceButton(), appId, appSecret);
		System.out.println("创建自定义菜单，返回值status: " + status);
	}
	
	public static CustomMenu getTrafficPoliceButton() {
		String weburl = FH.getWebUrl();
		ViewButton btn1 = new ViewButton();
		btn1.setName("信息查询");
		btn1.setType("view");
		//btn1.setUrl(weburl + "mvnfhm/frontend/home/infoSearch");
		btn1.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?"  
		        + "appid="+ Wx4javaConfig.instance().getAppid()+"&redirect_uri="  
		        + weburl + "mvnfhm/frontend/home/index?target=xxzx&response_type=code&scope=snsapi_userinfo&state=1111&connect_redirect=1#wechat_redirect"
		       );

		ViewButton btn2 = new ViewButton();
		btn2.setName("业务办理");
		btn2.setType("view");
		//btn2.setUrl(weburl + "mvnfhm/frontend/home/busiMan");
		btn2.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?"  
		        + "appid="+ Wx4javaConfig.instance().getAppid()+"&redirect_uri="  
		        + weburl + "mvnfhm/frontend/home/index?target=ywbl&response_type=code&scope=snsapi_userinfo&state=1111&connect_redirect=1#wechat_redirect"
		       );
		
		ViewButton btn3 = new ViewButton();
		btn3.setName("警民互动");
		btn3.setType("view");
		//btn3.setUrl(weburl + "mvnfhm/frontend/home/plInter");
		btn3.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?"  
		        + "appid="+ Wx4javaConfig.instance().getAppid()+"&redirect_uri="  
		        + weburl + "mvnfhm/frontend/home/index?target=zmhd&response_type=code&scope=snsapi_userinfo&state=1111&connect_redirect=1#wechat_redirect"
		       );
		
		CustomMenu me = new CustomMenu();
		me.setButton(new Button[] { btn1, btn2, btn3 });

		return me;
	}
	
}
