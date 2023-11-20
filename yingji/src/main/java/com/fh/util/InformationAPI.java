package com.fh.util;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wx.framework.core.wx4j.common.Article;
import com.wx.framework.core.wx4j.lang.HttpUtils;
import com.wx.framework.core.wx4j.token.TokenProxy;

/**
 * 上传图文素材管理类
 */
public class InformationAPI {
	private static Logger logger = Logger.getLogger(InformationAPI.class);
	/**
	 * 上传图文素材
	 */
	public static String uploadArticle(List<Article> articleList) {
		String result = "";
		if (CollectionUtils.isEmpty(articleList)) {
			return result;
		}
		String access_token = TokenProxy.accessToken();
		String uploadUrl = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=" + access_token;
		Map<String, Object> postData = new HashMap<String, Object>();
		logger.info("开始替换图文消息正文中的图片链接...");
		articleList = dealImgUrl(articleList);
		postData.put("articles", articleList);
		logger.info("开始上传图文素材...");
		result = HttpUtils.post(uploadUrl, JSON.toJSONString(postData));
		JSONObject jsonObject = JSONObject.parseObject(result);
		if (null == jsonObject.getString("media_id")) {
			return "";
		}
		return jsonObject.getString("media_id");
	}

	/**
	 * 替换图片链接
	 */
	public static List<Article> dealImgUrl(List<Article> articleList) {
		if (CollectionUtils.isNotEmpty(articleList)) {
			for (int i = 0; i < articleList.size(); i++) {
				Article everyArticle = articleList.get(i);
				String ynr = everyArticle.getContent();
				int index = 0;
				if (StringUtils.isBlank(ynr)) {
					continue;
				}
				while (index < ynr.length()) {
					int srcStart = ynr.indexOf("src=\"", index); // 获取src出现的位置
					if (srcStart < 0) {
						break;
					}
					int srcEnd = ynr.indexOf("\"", srcStart + 7);
					String src =PathUtil.getClasspath() + "../" + ynr.substring(srcStart + 6, srcEnd); // 获取图片路径
					File file = new File(src);
					logger.info("上传图文消息内的图片获取URL " + src);
					String result = uploadimg(file);
					if (StringUtils.isNotBlank(result)) {
						StringBuilder sb = new StringBuilder(ynr);
						sb.replace(srcStart + 5, srcEnd, result);
						ynr = sb.toString();
					} else {
						logger.info("上传图文消息内的图片获取URL 出错...");
					}
					index = srcStart + 5;
				}
				everyArticle.setContent(ynr);
			}
		}
		return articleList;
	}
	
	/**
	 * 上传图文消息内的图片获取URL
	 */
	public static String uploadimg (File file) {
		String url = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=" + TokenProxy.accessToken();
		try{
			String result = HttpUtils.postFile(url, "media", file);
			JSONObject jsonObject = JSONObject.parseObject(result);
			logger.info(result);
			return jsonObject.getString("url");
		} catch(Exception e) {
			logger.error("上传图文消息内的图片获取URL出错:" + e);
			return "";
		}
	}
	
	/**
	 * 群发消息
	 */
	public static String sendArticle(List<Article> articleList) {
		String result = "";
		logger.info("开始上传图文素材获取media_id...");
		String media_id = uploadArticle(articleList);
		if (StringUtils.isBlank(media_id)) {
			logger.info("没有成功获取到图文素材的media_id...");
			return result;
		}
		logger.info("成功获取到图文素材的media_id..." + media_id);
		Map<String, Object> postData = new HashMap<String, Object>();
		Map<String, String> mpnews = new HashMap<String, String>();
		mpnews.put("media_id", media_id);
		postData.put("mpnews", mpnews);
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("is_to_all", true);
		postData.put("filter", filter);
		postData.put("msgtype", "mpnews");
		postData.put("send_ignore_reprint", InformationConstants.CONTINUE_WHEN_REPRINT);
		String url = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=" + TokenProxy.accessToken();
		logger.info("开始群发图文消息...");
		result = HttpUtils.post(url, JSON.toJSONString(postData));
		JSONObject jsonObject = JSONObject.parseObject(result);
		int errcode = jsonObject.getInteger("errcode");
		if (0 != errcode) {
			logger.info("群发消息失败...");
			logger.info(jsonObject.toJSONString());
		}
		return result;
	}
}
