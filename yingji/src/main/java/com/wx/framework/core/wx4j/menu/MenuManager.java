package com.wx.framework.core.wx4j.menu;

import com.alibaba.fastjson.JSON;
import com.wx.framework.core.wx4j.exception.WeChatException;
import com.wx.framework.core.wx4j.lang.HttpUtils;
import com.wx.framework.core.wx4j.menu.view.ViewButton;
import com.wx.framework.core.wx4j.token.TokenProxy;
import com.wx.framework.core.wx4j.util.WeChatUtil;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

public class MenuManager
{
  private static Logger logger = Logger.getLogger(MenuManager.class);
  private static final String MENU_CREATE_POST_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
  private static final String MENU_GET_GET_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=";
  private static final String MENU_DEL_GET_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=";
  private String accessToken;

  public MenuManager()
  {
    this.accessToken = TokenProxy.accessToken();
  }

  public void create(Menu menu)
    throws WeChatException
  {
    logger.info("创建菜单");
    String resultStr = HttpUtils.post("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + this.accessToken, JSON.toJSONString(menu));
    WeChatUtil.isSuccess(resultStr);
  }

  public Menu getMenu()
  {
    logger.info("查询菜单");

    net.sf.json.JSONObject json = HttpUtils.httpsRequest("https://api.weixin.qq.com/cgi-bin/menu/get?access_token=" + this.accessToken, "GET", null);
    String resultStr = json.toString();

    logger.info(resultStr);
    try {
      WeChatUtil.isSuccess(resultStr);
    } catch (WeChatException e) {
      e.printStackTrace();
      return null;
    }
    com.alibaba.fastjson.JSONObject menuObject = com.alibaba.fastjson.JSONObject.parseObject(resultStr);
    Menu menu = (Menu)menuObject.getObject("menu", Menu.class);
    return menu;
  }

  public void delete()
    throws WeChatException
  {
    logger.info("删除菜单");
    String resultStr = HttpUtils.get("https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=" + this.accessToken);
    WeChatUtil.isSuccess(resultStr);
  }

  public static void main(String[] args) throws WeChatException {
    MenuManager mg = new MenuManager();

    TreeNode node1 = new TreeNode();
    node1.setId(1);
    node1.setName("互动社区");

    TreeNode node2 = new TreeNode();
    node2.setId(2);
    node2.setName("就医助手");

    TreeNode node3 = new TreeNode();
    node3.setId(3);
    node3.setName("个人中心");

    List tree = new ArrayList();

    Childnode childmnus1 = new Childnode();
    childmnus1.setId(4);
    childmnus1.setParentid(1);
    childmnus1.setName("常见问题");
    childmnus1.setUrl("http://fangjian.ittun.com/appointment/coustomHtmlController/changjianwt.html");
    childmnus1.setType("view");
    node1.getChildnodes().add(childmnus1);

    Childnode childmnus11 = new Childnode();
    childmnus11.setId(11);
    childmnus11.setParentid(1);
    childmnus11.setName("矫正案例");
    childmnus11.setUrl("http://fangjian.ittun.com/appointment/coustomHtmlController/anli.html");
    childmnus11.setType("view");
    node1.getChildnodes().add(childmnus11);

    Childnode childmnus2 = new Childnode();
    childmnus2.setId(5);
    childmnus2.setParentid(2);
    childmnus2.setName("我要预约");
    childmnus2.setUrl("http://fangjian.ittun.com/appointment/URLOAuth2/urlOAuthVisit.do?targetUrl=WxIndex/select1.do");
    childmnus2.setType("view");
    node2.getChildnodes().add(childmnus2);

    Childnode childmnus4 = new Childnode();
    childmnus4.setId(7);
    childmnus4.setParentid(2);
    childmnus4.setName("我要咨询");
    childmnus4.setUrl("http://fangjian.ittun.com/appointment/URLOAuth2/urlOAuthVisit.do?targetUrl=bconsultationController/create.do");
    childmnus4.setType("view");
    node2.getChildnodes().add(childmnus4);

    Childnode childmnus3 = new Childnode();
    childmnus3.setId(6);
    childmnus3.setParentid(3);
    childmnus3.setName("个人中心");
    childmnus3.setUrl("http://fangjian.ittun.com/appointment/URLOAuth2/urlOAuthVisit.do?targetUrl=WxIndex/toUserCenter.do");
    childmnus3.setType("view");
    node3.getChildnodes().add(childmnus3);

    tree.add(node1);
    tree.add(node2);
    tree.add(node3);

    List childmnus = null;
    ComplexButton cb = null;
    Button[] b = null;
    Button[] mainb = new Button[tree.size()];
    int z = 0;
    for (Iterator i$ = tree.iterator(); i$.hasNext(); ) { TreeNode t = (TreeNode)i$.next();
      cb = new ComplexButton();
      cb.setName(t.getName());
      childmnus = t.getChildnodes();
      int length = childmnus.size();
      b = new Button[length];
      for (int i = 0; i < length; ++i) {
        Childnode menu = (Childnode)childmnus.get(i);
        b[i] = new ViewButton(menu.getType(), menu.getUrl(), menu.getName());
      }
      cb.setSub_button(b);
      mainb[z] = cb;
      ++z;
    }

    Menu menu = new Menu();

    System.out.println(mg.getMenu());
  }
}