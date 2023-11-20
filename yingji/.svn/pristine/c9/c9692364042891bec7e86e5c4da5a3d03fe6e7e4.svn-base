package com.fh.util;

import com.fh.entity.api.QCity;

import net.sf.json.JSONArray;


/**
 * 工具测试类
 * @author Administrator
 *
 */
public class TestTools {
	
	public static void main(String[] args) {
		
		//获取违章城市
		String appKey="08d8dca767475ca449b76ae59e4d9fb6";
		String wfCityUrl="http://v.juhe.cn/sweizhang/citys";
		
		QCity qCity=new QCity();
		qCity.setKey("08d8dca767475ca449b76ae59e4d9fb6");
		JSONArray arr = JSONArray.fromObject(qCity);
		//getWFCity(arr.toString(),wfCityUrl);
		
		String cityUrl="http://apis.haoservice.com/weizhang/citys?key=94493df2a0a44da3959a1d51d11fb56f";
		//getWFCity("",cityUrl);
		
		String wfUrl="http://v.juhe.cn/sweizhang/query";
		String jsonParam="{\"key\":\"08d8dca767475ca449b76ae59e4d9fb6\",\"city\":\"HAN_HAIKOU\",\"hphm\":\"%E7%90%BCA1A221\",\"engineno\":\"HA9156\",\"classno\":\"288119\"}";
		String url="http://api.sprzny.com/weizhang/api?hphm=琼A1A221&classno=288119&engineno=HA9156&phone=13976474999";
		url="http://hi.122.gov.cn/m/publicquery/vio?hpzl=02&hphm=琼A1A221&fdjh=HA9156&qm=wf";
		getWFData("",url);
	}
	
	/**
	 * 获取违章城市
	 */
	public  static void getWFCity(String requestJson,String url){
		
		
			  String  returnData=HttpRequest.sendPost(url,requestJson);
			  System.out.println(returnData);
	          
		

	}
	/**
	 * 获取违章数据
	 */
	public  static void getWFData(String requestJson,String url){
	
		 String  returnData=HttpRequest.sendPost(url,requestJson);
		 System.out.println(returnData);

	}
}
