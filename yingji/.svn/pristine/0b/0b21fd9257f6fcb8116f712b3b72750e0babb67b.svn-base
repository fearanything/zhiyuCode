package com.fh.entity.custommenu;

import com.wx.framework.core.wx4j.common.Wx4javaConfig;
import com.fh.entity.menubase.Button;
import com.fh.entity.menubase.ComButton;
import com.fh.entity.menubase.CustomMenu;
import com.fh.entity.menubase.ViewButton;
import com.fh.util.weixin.MenuUtil;

public class SuiShouPaiMenu {
	
	public static void main(String[] args) {
		String appId = Wx4javaConfig.instance().getAppid();
		String appSecret = Wx4javaConfig.instance().getAppSecret();
		int status = MenuUtil.createCustomMenu(getSuiShouPaiButton(), appId, appSecret);
		System.out.println("创建自定义菜单，返回值status: " + status);
	}
	
	/**
	 * 随手拍菜单
	 */
	private static CustomMenu getSuiShouPaiButton() {

		ViewButton btn1 = new ViewButton();
		btn1.setName("随手拍");
		btn1.setType("view");
		btn1.setUrl("http://wusiyin.imwork.net/weixin_guide/jssdk/takePhotos");

		ViewButton btn21 = new ViewButton();
		btn21.setName("服务导航");
		btn21.setType("view");
		btn21.setUrl("http://www.baidu.com");

		ViewButton btn22 = new ViewButton();
		btn22.setName("政策法规");
		btn22.setType("view");
		btn22.setUrl("http://www.baidu.com");

		ViewButton btn23 = new ViewButton();
		btn23.setName("组织架构");
		btn23.setType("view");
		btn23.setUrl("http://www.baidu.com");

		ViewButton btn31 = new ViewButton();
		btn31.setName("交警动态");
		btn31.setType("view");
		btn31.setUrl("http://www.baidu.com");

		ViewButton btn32 = new ViewButton();
		btn32.setName("违章查询");
		btn32.setType("view");
		btn32.setUrl("http://m.weizhangwang.com/");

		ViewButton btn33 = new ViewButton();
		btn33.setName("交警微博");
		btn33.setType("view");
		btn33.setUrl("http://t.qq.com/haikoujiaojing");

		ComButton mainBtn2 = new ComButton();
		mainBtn2.setName("信息查询");
		mainBtn2.setSubButton(new Button[] { btn21, btn22, btn23 });

		ComButton mainBtn3 = new ComButton();
		mainBtn3.setName("交警互动");
		mainBtn3.setSubButton(new Button[] { btn31, btn32, btn33 });

		CustomMenu me = new CustomMenu();
		me.setButton(new Button[] { btn1, mainBtn2, mainBtn3 });

		return me;
	}
	
}
