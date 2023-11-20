package com.fh.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
/**
 * 项目名称：
 * @author:fh qq313596790[青苔]
 * 修改日期：2015/11/2
 */
public class Const {
	public static final String SESSION_SECURITY_CODE = "sessionSecCode";	//验证码
	public static final String SESSION_USER = "sessionUser";				//session用的用户
	public static final String SESSION_USER_HK = "sessionUserHK";				//session用的移动端用户
	public static final String SESSION_ROLE_RIGHTS = "sessionRoleRights";
	public static final String sSESSION_ROLE_RIGHTS = "sessionRoleRights";
	public static final String SESSION_menuList = "menuList";				//当前菜单
	public static final String SESSION_allmenuList = "allmenuList";			//全部菜单
	public static final String SESSION_QX = "QX";
	public static final String SESSION_userpds = "userpds";
	public static final String SESSION_USERROL = "USERROL";					//用户对象
	public static final String SESSION_USERNAME = "USERNAME";				//用户名
	public static final String SESSION_USERID = "USER_ID";				//用户名
	public static final String SESSION_OPENID = "OPEN_ID";				//用户openid
	public static final String SESSION_NICKNAME = "NICKNAME";				//用户NICKNAME 昵称
	public static final String DEPARTMENT_IDS = "DEPARTMENT_IDS";			//当前用户拥有的最高部门权限集合
	public static final String DEPARTMENT_ID = "DEPARTMENT_ID";				//当前用户拥有的最高部门权限
	public static final String TRUE = "T";
	public static final String FALSE = "F";
	public static final String LOGIN = "/login_toLogin.do";					//登录地址
	public static final String SYSNAME = "admin/config/SYSNAME.txt";		//系统名称路径
	public static final String PAGE	= "admin/config/PAGE.txt";				//分页条数配置路径
	public static final String EMAIL = "admin/config/EMAIL.txt";			//邮箱服务器配置路径
	public static final String SMS1 = "admin/config/SMS1.txt";				//短信账户配置路径1
	public static final String SMS2 = "admin/config/SMS2.txt";				//短信账户配置路径2
	public static final String FWATERM = "admin/config/FWATERM.txt";		//文字水印配置路径
	public static final String IWATERM = "admin/config/IWATERM.txt";		//图片水印配置路径
	public static final String WEIXIN	= "admin/config/WEIXIN.txt";		//微信配置路径
	public static final String WEBSOCKET = "admin/config/WEBSOCKET.txt";	//WEBSOCKET配置路径
	public static final String LOGINEDIT = "admin/config/LOGIN.txt";		//登录页面配置
	public static final String ACCESSTOKEN = "admin/config/ACCESSTOKEN.txt";			//萤石云授权令牌
	public static final String FILEPATHIMG = "uploadFiles/uploadImgs/";		//图片上传路径
	public static final String FILEPATHVIDEO = "uploadFiles/uploadVideo/";		//图片上传路径
	public static final String FILEPATHFILE = "uploadFiles/file/";			//文件上传路径

	public static final String FILEPATHFILEOA = "uploadFiles/uploadFile/";	//文件上传路径(oa管理)
	public static final String FILEPATHTWODIMENSIONCODE = "uploadFiles/twoDimensionCode/"; //二维码存放路径
	public static final String NO_INTERCEPTOR_PATH = ".*/((login)|(logout)|(code)|(app)|(weixin)|(static)|(main)|(websocket)|(uploadImgs)).*";	//不对匹配该值的访问路径拦截（正则）
	public static final String CONSTRACT_NAME = "【智宇科技】合同名称：";
	public static final String CONSTRACT_NUM = "，合同编号：";
	public static final String CONSTRACT_END = "，付款到期，收款未完成，请处理。";
	/** 催款测试 */
	public static final String EMAILTITLE = "admin/config/EMAILTITLE.txt";		//提醒邮件标题
	public static final String CUIKUANNEIRONG = "admin/config/CUIKUANNEIRONG.txt";		//催款提醒内容
	public static final String EMAILCONTENTHEAD = "【智宇科技】付款提醒：";		//邮件头	
	public static ApplicationContext WEB_APP_CONTEXT = null; //该值会在web容器启动时由WebAppContextListener初始化

	/**
	 * APP Constants
	 */
	//系统用户注册接口_请求协议参数)
	public static final String[] SYSUSER_REGISTERED_PARAM_ARRAY = new String[]{"USERNAME","PASSWORD","NAME","EMAIL","rcode"};
	public static final String[] SYSUSER_REGISTERED_VALUE_ARRAY = new String[]{"用户名","密码","姓名","邮箱","验证码"};

	//app根据用户名获取会员信息接口_请求协议中的参数
	public static final String[] APP_GETAPPUSER_PARAM_ARRAY = new String[]{"USERNAME"};
	public static final String[] APP_GETAPPUSER_VALUE_ARRAY = new String[]{"用户名"};

	//app注册接口_请求协议参数)
	public static final String[] APP_REGISTERED_PARAM_ARRAY = new String[]{"countries","uname","passwd","title","full_name","company_name","countries_code","area_code","telephone","mobile"};
	public static final String[] APP_REGISTERED_VALUE_ARRAY = new String[]{"国籍","邮箱帐号","密码","称谓","名称","公司名称","国家编号","区号","电话","手机号"};

	public static Map<String, String> getBusinessType() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "合同信息导入");
		map.put("2", "工程设备信息导入");
		return map;
	}

}
