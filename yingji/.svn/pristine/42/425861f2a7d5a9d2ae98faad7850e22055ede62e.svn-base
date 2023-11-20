package com.fh.controller.frontend;

import com.fh.common.WebConstant;
import com.fh.controller.base.BaseController;
import com.fh.entity.system.User;
import com.fh.service.backend.m_sys_user_org.M_sys_user_orgManager;
import com.fh.service.backend.morg.MOrgManager;
import com.fh.service.backend.rectifyinfo.RectifyInfoManager;
import com.fh.service.system.dictionaries.DictionariesManager;
import com.fh.service.system.user.UserManager;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
import com.fh.util.Tools;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value="/hkSafeFrontend")
public class hkSafeFrontend extends BaseController {
    @Resource(name="userService")
    private UserManager userService;
    @Resource(name="rectifyinfoService")
    private RectifyInfoManager rectifyinfoService;
    @Resource(name="dictionariesService")
    private DictionariesManager dictionariesService;
    @Resource(name="morgService")
    private MOrgManager morgService;
    @Resource(name="m_sys_user_orgService")
    private M_sys_user_orgManager m_sys_user_orgService;

    /**通用页面跳转
     * @param page
     * @throws Exception
     */
    @RequestMapping(value="/{CALL_INDEX}")
    public ModelAndView newsList(@PathVariable("CALL_INDEX") String CALL_INDEX) throws Exception {
        logBefore(logger, "通用页面跳转" + CALL_INDEX);
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        // 没有频道id时去首页
        if (StringUtils.isEmpty(CALL_INDEX)) {
            CALL_INDEX = "index";
        }
        mv.setViewName("/frontend/pc/" + CALL_INDEX);
        pd.put("CALL_INDEX", CALL_INDEX);
        mv.addObject("pd", pd);
        return mv;
    }

    /**
     * 查询驾驶舱中间的统计数据
     * @return
     * @throws Exception
     */
    @RequestMapping(value="dangerAll")
    @ResponseBody
    public PageData dangerAll(@RequestParam(value="ORG_CODE") String ORG_CODE) throws Exception {
        PageData pd = this.getPageData();
        pd.put("ORG_CODE",ORG_CODE);
        String NOW = Tools.date2Str(new Date(), "yyyy-MM-dd");
        int month = Integer.parseInt(NOW.substring(5, 7));
        pd.put("YEAR", NOW.substring(0, 4));
        pd.put("MONTH", NOW.substring(5, 7));
        pd.put("QUARTER", (month - 1) / 3 + 1);
        pd.put("NOW", NOW);
        pd = rectifyinfoService.tongjiAll(pd);
        return pd;
    }

    // 获取隐患整改统计
    @RequestMapping(value="dangerComplete")
    @ResponseBody
    public PageData dangerComplete() throws Exception {
        PageData pd = this.getPageData();
        int dayNum = 5; // 设置统计天数

        String dayNumStr = pd.getString("dayNum");
        if (StringUtils.isNotEmpty(dayNumStr)) {
            dayNum = Integer.parseInt(dayNumStr);
        }

        String[] dayArray = new String [dayNum];
        int[] finishArray = new int [dayNum];
        int[] unfinishArray = new int [dayNum];
        int[] overdueArray = new int [dayNum];
        int[] overFinishArray = new int [dayNum];


        // 获取今天开始的五天
        for (int i = 0; i > -dayNum; i--) {
            Date day = null;
            if(i == 0){
                day = Tools.getDayAgo(new Date(), i);//当前时间
            }
            else{
                day = Tools.getLashDay(new Date(), i);//往前i月的最后一天
            }
            String dayStr = Tools.date2Str(day, "yyyy-MM-dd");
            pd.put("NOW", dayStr);
            PageData data = rectifyinfoService.tongjiUntil(pd);

            dayArray[i+dayNum-1] = dayStr;
            finishArray[i+dayNum-1] = Integer.parseInt(data.get("zhenggaiwancheng").toString());
            unfinishArray[i+dayNum-1] = Integer.parseInt(data.get("zhenggaizhong").toString());
            overdueArray[i+dayNum-1] = Integer.parseInt(data.get("zhenggaiyuqi").toString());
            overFinishArray[i+dayNum-1] = Integer.parseInt(data.get("yuqiwancheng").toString());
        }

        pd.put("dayArray", dayArray);
        pd.put("finishArray", finishArray);
        pd.put("unfinishArray", unfinishArray);
        pd.put("overdueArray", overdueArray);
        pd.put("overFinishArray", overdueArray);
        return pd;
    }

    // 根据隐患类别统计
    @RequestMapping(value="classifyComplete")
    @ResponseBody
    public PageData classifyComplete() throws Exception {
        PageData pd = this.getPageData();

        List<PageData> list = rectifyinfoService.tongjiClassify(pd);
        Map<String, String> classifyMap = dictionariesService.listChildrenByEN(WebConstant.HIDDEN_DANGER_CLASSIFY, true);
        PageData[] array = new PageData[list.size()];

        int i = 0;
        for (PageData data : list) {
            PageData d = new PageData();

            String HIDDEN_DANGER_CLASSIFY = data.getString("HIDDEN_DANGER_CLASSIFY");

            if(HIDDEN_DANGER_CLASSIFY != null){
                d.put("value", data.get("num").toString());
                d.put("name", classifyMap.get(HIDDEN_DANGER_CLASSIFY).toString());

                array[i] = d;

                i++;
            }

        }

        pd.put("array", array);
        return pd;
    }

    // 按隐患因素统计
    @RequestMapping(value="factorComplete")
    @ResponseBody
    public PageData factorComplete() throws Exception {
        PageData pd = this.getPageData();

        List<PageData> list = rectifyinfoService.tongjiFactor(pd);
        Map<String, String> classifyMap = dictionariesService.listChildrenByEN(WebConstant.HIDDEN_DANGER_FACTOR, true);
        PageData[] array = new PageData[list.size()];

        int i = 0;
        for (PageData data : list) {
            PageData d = new PageData();

            String HIDDEN_DANGER_FACTOR = data.getString("HIDDEN_DANGER_FACTOR");

            d.put("value", data.get("num"));
            d.put("name", classifyMap.get(HIDDEN_DANGER_FACTOR).toString());

            array[i] = d;

            i++;
        }

        pd.put("array", array);
        return pd;
    }

    // 二级单位隐患情况
    @RequestMapping(value="erjiComplete")
    @ResponseBody
    public PageData erjiComplete() throws Exception {
        PageData pd = this.getPageData();

        // 按单位统计完成和未完成的数据
        PageData param = new PageData();
        List<PageData> allList = rectifyinfoService.tongjiByOrg(param);
        //已完成
        param.put("RECTIFY_STAGE", "4");
        List<PageData> finishList = rectifyinfoService.tongjiByOrg(param);

        // 获取二级单位列表
        PageData orgParam = new PageData();
        orgParam.put("ORG_LEVEL", "2");
        //临时加的参数
        orgParam.put("limitNum", "2");
        List<PageData> orgList = morgService.listAll(orgParam);

        // 匹配计算完成的数据
        for (PageData data : finishList) {
            String ORG_CODE = data.getString("ORG_CODE");
            int num = Integer.parseInt(data.get("num").toString());

            for (PageData org : orgList) {
                String ORG_CODE2 = org.getString("ORG_CODE");
                if (ORG_CODE.indexOf(ORG_CODE2) == 0) {
                    if (org.get("finishNum") == null) {
                        org.put("finishNum", num);
                    } else {
                        int finishNum = (Integer)org.get("finishNum");
                        finishNum = finishNum + num;
                        org.put("finishNum", finishNum);
                    }
                }
            }
        }
        // 匹配计算总数的数据
        for (PageData data : allList) {
            String ORG_CODE = data.getString("ORG_CODE");
            int num = Integer.parseInt(data.get("num").toString());

            for (PageData org : orgList) {
                String ORG_CODE2 = org.getString("ORG_CODE");
                if (ORG_CODE.indexOf(ORG_CODE2) == 0) {
                    if (org.get("allNum") == null) {
                        org.put("allNum", num);
                    } else {
                        int allNum = (Integer)org.get("allNum");
                        allNum = allNum + num;
                        org.put("allNum", allNum);
                    }
                }
            }
        }
        // 计算完成率
        PageData[] totalArr = new PageData[orgList.size()];
        PageData[] rateArr = new PageData[orgList.size()];
        int i = 0;
        for (PageData org : orgList) {
            BigDecimal allNum = new BigDecimal(org.get("allNum") == null ? 0 : (Integer)org.get("allNum"));
            BigDecimal finishNum = new BigDecimal(org.get("finishNum") == null ? 0 : (Integer)org.get("finishNum"));
            double rateDouble = 1; // 分母为0时，直接100%
            int rateInt = 100; // 分母为0时，直接100%
            if (!BigDecimal.ZERO.equals(allNum)) {
                BigDecimal rate = finishNum.divide(allNum, 2 , BigDecimal.ROUND_HALF_UP); // 计算比例，保留两位小数
                rateDouble = rate.doubleValue();

                rateInt = rate.multiply(new BigDecimal(100)).intValue();
            }
            org.put("total", allNum.intValue());
            org.put("rate", rateDouble);

            // 存入数组,原先存入的是finishNum
            PageData tatalData = new PageData();
            tatalData.put("name", org.getString("ORG_NAME_SHORT"));
            tatalData.put("value", allNum.intValue());
            totalArr[i] = tatalData;

            PageData rateData = new PageData();
            rateData.put("name", org.getString("ORG_NAME_SHORT"));
            rateData.put("value", rateInt);
            rateArr[i] = rateData;
            i++;
        }

        pd.put("orgList", orgList);
        pd.put("totalArr", totalArr);
        pd.put("rateArr", rateArr);

        return pd;
    }

    //二级页面获取机构名称
    @RequestMapping(value= "/getCompanyName")
    @ResponseBody
    public PageData getCompanyName() throws Exception{
        PageData pd = this.getPageData();
        pd = morgService.duplicate(pd);
        return pd;
    }

    //跳转隐患二级页面
    @RequestMapping(value= "/subviewIframe")
    @ResponseBody
    public ModelAndView subviewIframe() throws Exception{
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();

        String userId = Jurisdiction.getUserId();

        pd.put("USER_ID",userId);
        pd = m_sys_user_orgService.findByUserId(pd);
        pd = morgService.findById(pd);
        mv.setViewName("frontend/subviewIframe");

        mv.addObject("pd",pd);

        return mv;
    }

    //跳转隐患二级页面
    @RequestMapping(value= "/subviewBackend")
    @ResponseBody
    public ModelAndView subviewBackend() throws Exception{
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();

        String userId = Jurisdiction.getUserId();
        //获取roleName
        User userRole = userService.getUserAndRoleById(userId);
        //如果是admin就跳转一级页面
        if(userId.equals("1") || userRole.getRole().getROLE_NAME().equals("应急部")){
            mv.setViewName("/frontend/pc/index");
        }
        else{
            //mapper是根据code查询的，把org的所有数据查出来然后再进行查询
            pd.put("USER_ID",userId);
            pd = m_sys_user_orgService.findByUserId(pd);
            pd = morgService.findById(pd);
            mv.setViewName("frontend/pc/subview");

        }

        mv.addObject("pd",pd);

        return mv;
    }

    /**
     * 按rectifyinfo_stage统计
     */

    @RequestMapping(value = "tongjiByStage")
    @ResponseBody
    public List<PageData> tongjiByStage()throws Exception{
        PageData pd = this.getPageData();
        Date date = new Date();
        //sdf设置格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = sdf.format(date);
        pd.put("NOW",dateString);

        List<PageData> resultList = rectifyinfoService.tongjiByStage(pd);


        return resultList;
    }

    /**
     * 按项目id统计隐患
     */
    @RequestMapping(value = "tongjiByProject")
    @ResponseBody
    public List<PageData> tongjiByProject()throws Exception{
        PageData pd = this.getPageData();

        PageData result = rectifyinfoService.tongjiByProject(pd);
        List<PageData> resultList = new ArrayList<>();

        PageData temp = new PageData();
        temp.put("name","重大隐患");
        temp.put("value",result.get("more"));
        resultList.add(temp);
        PageData temp1 = new PageData();
        temp1.put("name","一般隐患");
        temp1.put("value",result.get("normal"));
        resultList.add(temp1);

        return resultList;
    }

    /**
     * 按项目id统计隐患整改率
     */
    @RequestMapping(value = "tongjiByProjectOnPrecent")
    @ResponseBody
    public PageData tongjiByProjectOnPrecent()throws Exception{
        PageData pd = this.getPageData();

        PageData result = rectifyinfoService.tongjiByProjectOnPrecent(pd);
        return result;
    }
}
