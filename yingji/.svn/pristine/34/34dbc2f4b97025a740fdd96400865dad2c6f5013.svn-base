package com.fh.common;

import java.net.URLEncoder;

/**
 * 获取微信的code
 * @author 宗潇帅
 * @修改日期 2014-7-21下午1:01:45
 */
public class GetWeiXinCode {
    public static String  GetCodeRequest = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
    public static String getCodeRequest(){
        String result = null;
        GetCodeRequest  = GetCodeRequest.replace("APPID", urlEnodeUTF8("wx9d98ebf944469d4d"));
        GetCodeRequest  = GetCodeRequest.replace("REDIRECT_URI",urlEnodeUTF8("http://wusiyin.imwork.net/mvnfhm/weixin/mainapi.do"));
        GetCodeRequest = GetCodeRequest.replace("SCOPE", "snsapi_userinfo");
        result = GetCodeRequest;
        return result;
    }
    public static String urlEnodeUTF8(String str){
        String result = str;
        try {
            result = URLEncoder.encode(str,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(getCodeRequest());
    }
}
