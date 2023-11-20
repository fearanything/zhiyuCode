package com.wx.framework.core.wx4j.common;

import java.util.Arrays;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

public class ValidateSignature
{
  private String signature;
  private String timestamp;
  private String nonce;
  private String token;
  private static Logger logger = Logger.getLogger(ValidateSignature.class);

  public ValidateSignature(String signature, String timestamp, String nonce, String token)
  {
    this.signature = signature;
    this.timestamp = timestamp;
    this.nonce = nonce;
    this.token = token;
  }

  public boolean check()
  {
    String sha1 = encode();
    return sha1.equals(this.signature);
  }

  private String encode()
  {
    logger.info("token:" + this.token + "timestamp:" + this.timestamp + "nonce:" + this.nonce);
    String[] sa = { this.token, this.timestamp, this.nonce };
    Arrays.sort(sa);
    String sortStr = sa[0] + sa[1] + sa[2];
    return DigestUtils.shaHex(sortStr);
  }
}