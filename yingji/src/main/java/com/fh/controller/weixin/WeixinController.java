package com.fh.controller.weixin;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.session.Session;
import org.marker.weixin.DefaultSession;
import org.marker.weixin.HandleMessageAdapter;
import org.marker.weixin.MySecurity;
import org.marker.weixin.msg.Data4Item;
import org.marker.weixin.msg.Msg4Event;
import org.marker.weixin.msg.Msg4Image;
import org.marker.weixin.msg.Msg4ImageText;
import org.marker.weixin.msg.Msg4Link;
import org.marker.weixin.msg.Msg4Location;
import org.marker.weixin.msg.Msg4Text;
import org.marker.weixin.msg.Msg4Video;
import org.marker.weixin.msg.Msg4Voice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.wx.framework.core.wx4j.common.Wx4javaConfig;
import com.wx.framework.core.wx4j.util.WeChatUtil;
import com.fh.controller.base.BaseController;
import com.fh.service.weixin.command.CommandService;
import com.fh.service.weixin.imgmsg.ImgmsgService;
import com.fh.service.weixin.textmsg.TextmsgService;
import com.fh.util.Const;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
import com.fh.util.Tools;

/**
 * 
* 类名称：WeixinController.java
* 类描述： 微信公共平台开发 
* @author FH 313596790
* 作者单位： 
* 联系方式：
* 创建时间：2014年7月10日
* @version 1.0
 */
@Controller
@RequestMapping(value="/weixin")
public class WeixinController extends BaseController{
	private final static Logger log= Logger.getLogger(WeixinController.class);
	private static StringBuffer sb;
	private static String token = "";
	@Resource(name="textmsgService")
	private TextmsgService textmsgService;
	@Resource(name="commandService")
	private CommandService commandService;
	@Resource(name="imgmsgService")
	private ImgmsgService imgmsgService;
	/***
	* 
	* 方法名:第一次访问、 需要进行网页授权的链接访问地址，主要配置 targetUrl参数</br>
	* 方法描述: TODO</br>
	* 创建人：fangjian </br>
	* 创建时间：2015年12月3日 下午12:24:35   </br>
	* 修改人：fangjian   </br>
	* 修改时间：2015年12月3日 下午12:24:35   </br>
	* 修改备注：   </br>
	* 参数 @param request</br>
	* 参数 @param modelMap</br>
	* 参数 @param response</br>
	* 参数 @return 进行用户授权知乎的跳转</br>
	* 参数 @throws Exception</br>
	* 返回类型 String</br>
	* throws</br>
	 */
	@SuppressWarnings({ "deprecation", "unused" })
	@RequestMapping("/urlOAuthVisit")
	public String urlOAuthVisit(HttpServletRequest request,ModelMap modelMap,HttpServletResponse response) throws Exception
	{
		//回调地址
		String redirect_uri =Wx4javaConfig.instance().getRedirect_uri();
		//真实目标跳转地址
		String targetUrl = "weixin/urlAuth2_redirect_uri";
		System.out.println("urlOAuthVisit.do需要跳转的地址的targetUrl为："+targetUrl);
		
		if(true)
		{
			String APPID = Wx4javaConfig.instance().getAppid();
	        String SECRET = Wx4javaConfig.instance().getAppSecret();
			if(APPID!=null&&!APPID.equals("")&&SECRET!=null&&!SECRET.equals(""))
			{
				String RESPONSE_TYPE = "code";//返回类型，请填写code
				String REDIRECT_URL =URLEncoder.encode(redirect_uri+"?targetUrl="+targetUrl);//授权后重定向的回调链接地址
				String SCOPE = "snsapi_userinfo";
										//应用授权作用域，snsapi_base （不弹出授权页面，直接跳转，只能获取用户openid），
									    //snsapi_userinfo （弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息）
										//#wechat_redirect 直接在微信打开链接，可以不填此参数。做页面302重定向时候，必须带此参数
										//state  重定向后会带上state参数，开发者可以填写任意参数值 随便一个数字，这里填1
				
				String URL ="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+APPID+"&redirect_uri="+REDIRECT_URL+"&response_type="+RESPONSE_TYPE+"&scope="+SCOPE+"&state=1#wechat_redirect";
				System.out.println("进行授权的URL:"+URL);
				response.sendRedirect(URL);
				return null;
			}else{
				//modelMap.put("errormsg", "公众号基本信息不完整!无法完成授权!");
				return "/error/error_tip";
			}
		}else{
			//modelMap.put("errormsg", "无此公众号基本信息!");
			return "/error/error_tip";
		}	
		
	}
	
	/**
	 * 
	* 方法名: urlAuth2_redirect_uri </br>
	* 方法描述:授权方法、 网页授权访问页面 </br>
	* 创建人：fangjian </br>
	* 创建时间：2015年12月3日 下午12:46:26   </br>
	* 修改人：fangjian   </br>
	* 修改时间：2015年12月3日 下午12:46:26   </br>
	* 修改备注：   </br>
	* 参数 @param request</br>
	* 参数 @param response</br>
	* 参数 @param modelMap</br>
	* 参数 @return</br>
	* 返回类型 String</br>
	* throws</br>
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/urlAuth2_redirect_uri")
	public String urlAuth2_redirect_uri(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		log.info("进入用户授权方法!");
        //跳转的目标地址
    	String targetUrl = request.getParameter("targetUrl");
		if(targetUrl!=null&&!targetUrl.equals(""))
		{
	        String code = request.getParameter("code");
	        String state = request.getParameter("state");
	        log.info("获取code:"+code);
	        log.info("获取state:"+state);
	        String APPID = Wx4javaConfig.instance().getAppid();
	        String SECRET = Wx4javaConfig.instance().getAppSecret();
	        String URL ="https://api.weixin.qq.com/sns/oauth2/access_token?appid="+APPID+"&secret="+SECRET+"&code="+code+"&grant_type=authorization_code";
	        try {
				URL url = new URL(URL);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoInput(true);
				conn.setDoOutput(true);
				conn.connect();
				InputStream is = conn.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(is));
				sb = new StringBuffer();
				String line = "";
				while ((line = reader.readLine())!=null) {
					sb.append(line);
				}
				 JSONObject jsonObject =JSONObject.parseObject(sb.toString());
				 log.info("jsonObject:"+jsonObject);
				 String openid = (String) jsonObject.get("openid");
				 Session session = Jurisdiction.getSession();
				 session.setAttribute(Const.SESSION_OPENID, openid);			//把用户openid放session中
				return null;
			} catch (Exception e) {
				//modelMap.put("errormsg", "出现异常!");
				log.info("出现异常："+e.getMessage());
				//异常时的跳转
				return "";
			}
		}else{
			log.info("没有设置targetUrl跳转链接！");
			//modelMap.put("errormsg", "没有设置targetUrl跳转链接！");
			return "";
		}
	}
	
	//微信扫码登录,必须微信公众平台的认证，不是一般的微信的类型
	@RequestMapping("/wxLogin.do")
	public String wxLogin(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//http://fangjian.ittun.com/appointment/URLOAuth2/wxLogin.do
		log.info("微信扫码登录，必须开通开放平台，微信公众号平台不具备这个功能...........");
		//回调地址
		String redirect_uri =Wx4javaConfig.instance().getRedirect_uri();
		       redirect_uri =URLEncoder.encode(redirect_uri);
		String state = request.getSession().getId();
		String appid = Wx4javaConfig.instance().getAppid();
		String wxlogin_url = "https://open.weixin.qq.com/connect/qrconnect?appid="+appid+"&redirect_uri="+redirect_uri+"&response_type=code&scope=snsapi_base&state=316a932d158da2c500400285b642973e#wechat_redirect";
		System.out.println("微信扫码登录地址为："+wxlogin_url);
		response.sendRedirect(wxlogin_url);
		return null;
	}
	/**
	 * 接口验证,总入口
	 * @param out
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	 @SuppressWarnings("unused")
	@RequestMapping(value="/mainapi")
	 public void mainapi(HttpServletRequest request,HttpServletResponse response) throws Exception{     
		 logBefore(logger, "微信接口");
		 String code = request.getParameter("code");
		 String signature = request.getParameter("signature"); 
		 String timestamp = request.getParameter("timestamp");   
		 String nonce = request.getParameter("nonce"); 
		 String echostr = request.getParameter("echostr"); 
		 PrintWriter out = response.getWriter();
		 token = Wx4javaConfig.instance().getToken();
		 //验证
		 if (WeChatUtil.checkSignature(token,signature, timestamp, nonce)) {
			 logBefore(logger, "checkSignature success!");
			 out.print(echostr);  
		 }else{
			 logBefore(logger, "checkSignature false");
		 }
		 out.close(); 
		 out = null;
		
	}
	/**
	 * 接口验证,总入口
	 * @param out
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	 @RequestMapping(value="/index")
	 public void index(
			 PrintWriter out,
			 HttpServletRequest request,
			 HttpServletResponse response
			 ) throws Exception{     
		 logBefore(logger, "微信接口");
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			String signature = pd.getString("signature");		//微信加密签名
			String timestamp = pd.getString("timestamp");		//时间戳
			String nonce	 = pd.getString("nonce");			//随机数
			String echostr 	 = pd.getString("echostr");			//字符串

			if(null != signature && null != timestamp && null != nonce && null != echostr){/* 接口验证  */
				logBefore(logger, "进入身份验证");
			    List<String> list = new ArrayList<String>(3) { 
				    private static final long serialVersionUID = 2621444383666420433L; 
				    public String toString() {  // 重写toString方法，得到三个参数的拼接字符串
				               return this.get(0) + this.get(1) + this.get(2); 
				           } 
				         }; 
				   list.add(Tools.readTxtFile(Const.WEIXIN)); 		//读取Token(令牌)
				   list.add(timestamp); 
				   list.add(nonce); 
				   Collections.sort(list);							// 排序 
				   String tmpStr = new MySecurity().encode(list.toString(),MySecurity.SHA_1);								// SHA-1加密 
				    if (signature.equals(tmpStr)) { 
				           out.write(echostr);						// 请求验证成功，返回随机码 
				     }else{ 
				           out.write(""); 
			       } 
				out.flush();
				out.close(); 
			}else{/* 消息处理  */
				logBefore(logger, "进入消息处理");
				response.reset();
				sendMsg(request,response);
			}
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
	}
	 /**
	  * 处理微信服务器发过来的各种消息，包括：文本、图片、地理位置、音乐等等 
	  * @param request
	  * @param response
	  * @throws Exception
	  */
	 public void sendMsg(HttpServletRequest request, HttpServletResponse response) throws Exception{ 

         InputStream is = request.getInputStream(); 
         OutputStream os = response.getOutputStream(); 

         final DefaultSession session = DefaultSession.newInstance(); 
         session.addOnHandleMessageListener(new HandleMessageAdapter(){ 
        	 
        	/**
        	 * 事件
        	 */
        	@Override
        	public void onEventMsg(Msg4Event msg) {
        		/** msg.getEvent()
        		 * unsubscribe：取消关注 ; subscribe：关注
        		 */
        		if("subscribe".equals(msg.getEvent())){
        			returnMSg(msg,null,"关注");
        		}else if("CLICK".equals(msg.getEvent())){
        			returnMSg(msg,null,msg.getEventKey());
        		}
        	}
        	
        	 /**
        	  * 收到的文本消息
        	  */
        	 @Override 
             public void onTextMsg(Msg4Text msg) { 
                returnMSg(null,msg,msg.getContent().trim());
             }
        	 
        	 @Override
        	public void onImageMsg(Msg4Image msg) {
        		// TODO Auto-generated method stub
        		super.onImageMsg(msg);
        	}
        	 
        	 @Override
        	public void onLocationMsg(Msg4Location msg) {
        		// TODO Auto-generated method stub
        		super.onLocationMsg(msg);
        	}
        	 
        	@Override
        	public void onLinkMsg(Msg4Link msg) {
        		// TODO Auto-generated method stub
        		super.onLinkMsg(msg);
        	}
        	
        	@Override
        	public void onVideoMsg(Msg4Video msg) {
        		// TODO Auto-generated method stub
        		super.onVideoMsg(msg);
        	}
        	
        	@Override
        	public void onVoiceMsg(Msg4Voice msg) {
        		// TODO Auto-generated method stub
        		super.onVoiceMsg(msg);
        	}
        	
        	@Override
        	public void onErrorMsg(int errorCode) {
        		// TODO Auto-generated method stub
        		super.onErrorMsg(errorCode);
        	}
        	
        	/**
        	 * 返回消息
        	 * @param emsg
        	 * @param tmsg
        	 * @param getmsg
        	 */
        	public void returnMSg(Msg4Event emsg, Msg4Text tmsg, String getmsg){
        		 PageData msgpd;
                 PageData pd = new PageData();
                 String toUserName,fromUserName,createTime;
                 if(null == emsg){
                	 toUserName = tmsg.getToUserName();
                	 fromUserName = tmsg.getFromUserName();
                	 createTime = tmsg.getCreateTime();
                 }else{
                	 toUserName = emsg.getToUserName();
                	 fromUserName = emsg.getFromUserName();
                	 createTime = emsg.getCreateTime();
                 }
                 pd.put("KEYWORD", getmsg);
                 try {
 						msgpd = textmsgService.findByKw(pd);
 						if(null != msgpd){
 							 Msg4Text rmsg = new Msg4Text(); 
 		                     rmsg.setFromUserName(toUserName); 
 		                     //System.out.println(toUserName + "====" + fromUserName);
 		                     //fromUserName  关注者的身份ID
 		                     rmsg.setToUserName(fromUserName); 
 		                     //rmsg.setFuncFlag("0"); 
 		                     rmsg.setContent(msgpd.getString("CONTENT")); //回复文字消息
 		                     session.callback(rmsg); 
 						}else{
 							msgpd = imgmsgService.findByKw(pd);
 							if(null != msgpd){
 								 Msg4ImageText mit = new Msg4ImageText(); 
 				                 mit.setFromUserName(toUserName); 
 				                 mit.setToUserName(fromUserName);  
 				                 mit.setCreateTime(createTime);  
 								 //回复图文消息
 				                 if(null != msgpd.getString("TITLE1") && null != msgpd.getString("IMGURL1")){
 				                	 Data4Item d1 = new Data4Item(msgpd.getString("TITLE1"),msgpd.getString("DESCRIPTION1"),msgpd.getString("IMGURL1"),msgpd.getString("TOURL1")+"&FHWXID="+fromUserName);  
 				                	 mit.addItem(d1);
 				                	 
 				                	 if(null != msgpd.getString("TITLE2") && null != msgpd.getString("IMGURL2") && !"".equals(msgpd.getString("TITLE2").trim()) && !"".equals(msgpd.getString("IMGURL2").trim())){
 					                	 Data4Item d2 = new Data4Item(msgpd.getString("TITLE2"),msgpd.getString("DESCRIPTION2"),msgpd.getString("IMGURL2"),msgpd.getString("TOURL2"));  
 					                	 mit.addItem(d2);
 					                 }
 				                	 if(null != msgpd.getString("TITLE3") && null != msgpd.getString("IMGURL3") && !"".equals(msgpd.getString("TITLE3").trim()) && !"".equals(msgpd.getString("IMGURL3").trim())){
 					                	 Data4Item d3 = new Data4Item(msgpd.getString("TITLE3"),msgpd.getString("DESCRIPTION3"),msgpd.getString("IMGURL3"),msgpd.getString("TOURL3"));  
 					                	 mit.addItem(d3);
 					                 }
 				                	 if(null != msgpd.getString("TITLE4") && null != msgpd.getString("IMGURL4") && !"".equals(msgpd.getString("TITLE4").trim()) && !"".equals(msgpd.getString("IMGURL4").trim())){
 					                	 Data4Item d4 = new Data4Item(msgpd.getString("TITLE4"),msgpd.getString("DESCRIPTION4"),msgpd.getString("IMGURL4"),msgpd.getString("TOURL4"));  
 					                	 mit.addItem(d4);
 					                 }
 				                	 if(null != msgpd.getString("TITLE5") && null != msgpd.getString("IMGURL5") && !"".equals(msgpd.getString("TITLE5").trim()) && !"".equals(msgpd.getString("IMGURL5").trim())){
 					                	 Data4Item d5 = new Data4Item(msgpd.getString("TITLE5"),msgpd.getString("DESCRIPTION5"),msgpd.getString("IMGURL5"),msgpd.getString("TOURL5"));  
 					                	 mit.addItem(d5);
 					                 }
 				                	 if(null != msgpd.getString("TITLE6") && null != msgpd.getString("IMGURL6") && !"".equals(msgpd.getString("TITLE6").trim()) && !"".equals(msgpd.getString("IMGURL6").trim())){
 					                	 Data4Item d6 = new Data4Item(msgpd.getString("TITLE6"),msgpd.getString("DESCRIPTION6"),msgpd.getString("IMGURL6"),msgpd.getString("TOURL6"));  
 					                	 mit.addItem(d6);
 					                 }
 				                	 if(null != msgpd.getString("TITLE7") && null != msgpd.getString("IMGURL7") && !"".equals(msgpd.getString("TITLE7").trim()) && !"".equals(msgpd.getString("IMGURL7").trim())){
 					                	 Data4Item d7 = new Data4Item(msgpd.getString("TITLE7"),msgpd.getString("DESCRIPTION7"),msgpd.getString("IMGURL7"),msgpd.getString("TOURL7"));  
 					                	 mit.addItem(d7);
 					                 }
 				                	 if(null != msgpd.getString("TITLE8") && null != msgpd.getString("IMGURL8") && !"".equals(msgpd.getString("TITLE8").trim()) && !"".equals(msgpd.getString("IMGURL8").trim())){
 					                	 Data4Item d8 = new Data4Item(msgpd.getString("TITLE8"),msgpd.getString("DESCRIPTION8"),msgpd.getString("IMGURL8"),msgpd.getString("TOURL8"));  
 					                	 mit.addItem(d8);
 					                 }
 				                 }
 				                 //mit.setFuncFlag("0");   
 				                 session.callback(mit); 
 							}else{
 								msgpd = commandService.findByKw(pd);
 								if(null != msgpd){
 			             			Runtime runtime = Runtime.getRuntime(); 
 			             			runtime.exec(msgpd.getString("COMMANDCODE"));
 								}else{
 									 Msg4Text rmsg = new Msg4Text(); 
 				                     rmsg.setFromUserName(toUserName); 
 				                     rmsg.setToUserName(fromUserName); 
 				                     rmsg.setContent("无匹配结果");
 				                     session.callback(rmsg); 
 								}
 							}
 						}
 				} catch (Exception e1) {
 					logBefore(logger, "匹配错误");
 				}
        	}
        	
        }); 

         /*必须调用这两个方法   如果不调用close方法，将会出现响应数据串到其它Servlet中。*/ 
         session.process(is, os);	//处理微信消息  
         session.close();			//关闭Session 
     } 
}

