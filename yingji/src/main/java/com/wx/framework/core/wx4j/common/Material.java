package com.wx.framework.core.wx4j.common;

import com.alibaba.fastjson.JSONObject;
import com.wx.framework.core.wx4j.lang.HttpUtils;
import com.wx.framework.core.wx4j.token.TokenProxy;
import java.io.File;

import org.apache.commons.lang.StringUtils;

/**
 * 上传永久素材
 */
public class Material {
	private static final String UPLOAD = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=";
	private static final String DOWNLOAD = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=";
	private static final String PARAM_FILE = "media";
	private static final String PARAM_MEDIA_ID = "media_id";
	private static final String PARAM_TYPE = "type";
	private static final String PARAM_CREATE_TIME = "created_at";
	private MediaType type;
	private File file;
	private String mediaId;
	private String createdTimestamp;

	private String uploadUrl() {
		String url = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=" + TokenProxy.accessToken() + "&"
				+ "type" + "=" + this.type.name();

		return url;
	}

	private String downloadUrl() {
		String url = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=" + TokenProxy.accessToken() + "&"
				+ "media_id" + "=" + this.mediaId;

		return url;
	}

	public String upload(File file, MediaType type) {
		this.file = file;
		this.type = type;
		String url = uploadUrl();
		String result = HttpUtils.postFile(url, "media", file);
		parseUploadResult(result);
		if (StringUtils.isNotBlank(this.mediaId))
			return this.mediaId;
		return null;
	}

	private void parseUploadResult(String result) {
		JSONObject jsonObject = JSONObject.parseObject(result);
		if (jsonObject.containsKey("media_id")) {
			this.mediaId = jsonObject.getString("media_id");
			this.createdTimestamp = jsonObject.getString("created_at");
		} else {
			this.mediaId = null;
			this.createdTimestamp = null;
		}
	}

	public byte[] download(String mediaId) {
		this.mediaId = mediaId;
		String url = downloadUrl();
		byte[] fb = HttpUtils.getFile(url);
		if ((fb == null) || (fb.length == 0))
			return null;
		return fb;
	}

	public MediaType getType() {
		return this.type;
	}

	public String getMediaId() {
		return this.mediaId;
	}

	public String getCreatedTimestamp() {
		return this.createdTimestamp;
	}
}