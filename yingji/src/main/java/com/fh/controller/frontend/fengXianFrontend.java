package com.fh.controller.frontend;

import com.alibaba.fastjson.JSONObject;
import com.fh.common.WebConstant;
import com.fh.controller.backend.FengxianController;
import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.entity.Picker;
import com.fh.entity.system.Dictionaries;
import com.fh.service.backend.answer.AnswerManager;
import com.fh.service.backend.burst.BurstManager;
import com.fh.service.backend.city.CityManager;
import com.fh.service.backend.duty.DutyManager;
import com.fh.service.backend.file.FileManager;
import com.fh.service.backend.filetype.FiletypeManager;
import com.fh.service.backend.m_fengxian.M_fengxianManager;
import com.fh.service.backend.monitor.MonitorManager;
import com.fh.service.backend.monitortype.MonitortypeManager;
import com.fh.service.backend.morg.MOrgManager;
import com.fh.service.backend.notice.NoticeManager;
import com.fh.service.backend.project.ProjectManager;
import com.fh.service.backend.projectType.ProjectTypeManager;
import com.fh.service.backend.rectifyinfo.RectifyInfoManager;
import com.fh.service.backend.reservoir.ReservoirManager;
import com.fh.service.backend.risk.RiskManager;
import com.fh.service.backend.typhoon.TyphoonManager;
import com.fh.service.backend.water.WaterManager;
import com.fh.service.backend.weather.WeatherManager;
import com.fh.service.system.dictionaries.DictionariesManager;
import com.fh.service.system.user.UserManager;
import com.fh.util.PageData;
import com.fh.util.Tools;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Controller
@RequestMapping(value="/fengXianFrontend")
public class fengXianFrontend extends BaseController {

    @Resource(name="userService")
    private UserManager userService;
    @Resource(name="dictionariesService")
    private DictionariesManager dictionariesService;
    @Resource(name="rectifyinfoService")
    private RectifyInfoManager rectifyinfoService;
    @Resource(name="m_fengxianService")
    private M_fengxianManager m_fengxianService;
    @Resource(name="morgService")
    private MOrgManager morgService;
    @Resource(name="typhoonService")
    private TyphoonManager typhoonService;
    @Resource(name="noticeService")
    private NoticeManager noticeService;
    @Resource(name="answerService")
    private AnswerManager answerService;
    @Resource(name="dutyService")
    private DutyManager dutyService;
    @Resource(name="reservoirService")
    private ReservoirManager reservoirService;
    @Resource(name="waterService")
    private WaterManager waterService;
    @Resource(name="projectTypeService")
    private ProjectTypeManager projectTypeService;
    @Resource(name="projectService")
    private ProjectManager projectService;
    @Resource(name="cityService")
    private CityManager cityService;
    @Resource(name="filetypeService")
    private FiletypeManager filetypeService;
    @Resource(name="fileService")
    private FileManager fileService;
    @Resource(name="monitortypeService")
    private MonitortypeManager monitortypeService;
    @Resource(name="monitorService")
    private MonitorManager monitorService;
    @Resource(name="weatherService")
    private WeatherManager weatherService;
    @Resource(name="riskService")
    private RiskManager riskService;
    @Resource(name="burstService")
    private BurstManager burstService;

    //跳转风险管控平台
    @RequestMapping(value="/index")
    public ModelAndView fengXianIndex(HttpServletRequest request, Page page) throws Exception{
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        List<PageData> allData =  getFengXianByArea();

        mv.addObject("allData",allData);
        mv.setViewName("frontend/fengxianIndex");
        mv.addObject("pd",pd);
        return mv;
    }

    /*二级机构风险点列表
     * */
    @RequestMapping(value="/getListFengXian")
    @ResponseBody
    public List<PageData> getListFengXian() throws Exception{
        PageData pd = this.getPageData();
        List<PageData> list = morgService.listFengXian(pd);
        return list;
    }

    /*按地区划分统计风险点
     * */
    @RequestMapping(value="/getFengXianByArea")
    @ResponseBody
    public List<PageData> getFengXianByArea() throws Exception{

        //获取海南地区
        String hainanParam = "2ba8e6d0fd944983aa19b781c6b53477";
        List<Dictionaries> areaList = dictionariesService.listSubDictByParentId(hainanParam);
        //填充子list
        for(Dictionaries dictionaries : areaList){
            String parentId = dictionaries.getDICTIONARIES_ID();
            List<Dictionaries> subList = dictionariesService.listSubDictByParentId(parentId);
            dictionaries.setSubDict(subList);
        }

        //先获取一级区域的数据
        List<PageData> list = new ArrayList<>();
        for(Dictionaries dictionaries : areaList){
            PageData pd = new PageData();
            pd.put("DICTIONARIES_ID",dictionaries.getDICTIONARIES_ID());
            pd.put("NAME",dictionaries.getNAME());
            PageData subList = m_fengxianService.listFengXianByArea(pd);
            if(subList != null){
                pd.put("ALL_RISK",subList.get("全部风险点"));
                pd.put("MAJOR_RISK",subList.get("重大风险"));
                pd.put("MORE_RISK",subList.get("较大风险"));
                pd.put("NORMAL_RISK",subList.get("一般风险"));
                pd.put("LOW_RISK",subList.get("低风险"));
            }

//			pd.put("data",subList);

            //二级区域
            List<Dictionaries> subDictionaries =  dictionaries.getSubDict();
            List<PageData> secondAreaList = new ArrayList<>();
            //统计二级区域的风险点数量，显示在点击区域地图展开的地方
            long allRisk = 0;
            if(pd.get("ALL_RISK") != null){
                allRisk = (long) pd.get("ALL_RISK");
            }

            for(Dictionaries secondDictionaries : subDictionaries){
                PageData param = new PageData();
                param.put("DICTIONARIES_ID",secondDictionaries.getDICTIONARIES_ID());
                param.put("NAME",secondDictionaries.getNAME());
                PageData secondSubList = m_fengxianService.listFengXianByArea(param);
                if(secondSubList != null){
                    param.put("ALL_RISK",secondSubList.get("全部风险点"));
                    param.put("MAJOR_RISK",secondSubList.get("重大风险"));
                    param.put("MORE_RISK",secondSubList.get("较大风险"));
                    param.put("NORMAL_RISK",secondSubList.get("一般风险"));
                    param.put("LOW_RISK",secondSubList.get("低风险"));
                    //获取二级区域的风险点数量
                    if(param.get("ALL_RISK") != null){
                        allRisk += (long) param.get("ALL_RISK");
                    }
                }

                secondAreaList.add(param);
            }
            pd.put("sublist",secondAreaList);
            pd.put("tongJi",allRisk);
            list.add(pd);
        }

        return list;
    }

    /*驾驶舱顶部统计数据
     * */
    @RequestMapping(value="/getTongJiFengXian")
    @ResponseBody
    public PageData getTongJiFengXian() throws Exception{
        PageData pd = this.getPageData();
        pd = m_fengxianService.tongJiFengXian(pd);
        return pd;
    }

    /*驾驶舱顶部统计数据
     * */
    @RequestMapping(value="/getTongJiFengXianPrev")
    @ResponseBody
    public PageData getTongJiFengXianPrev() throws Exception{
        PageData pd = this.getPageData();
        pd.put("NOW", Tools.date2Str(new Date()));
        pd = m_fengxianService.tongJiFengXian(pd);
        return pd;
    }

    /*驾驶舱右边统计风险等级
     * */
    @RequestMapping(value="/getTongJiFengXianLevel")
    @ResponseBody
    public PageData getTongJiFengXianLevel() throws Exception{
        PageData pd = this.getPageData();
        List<PageData> list = m_fengxianService.tongJiFengXianLevel(pd);

        //弄成map依次判断放入
        PageData result = new PageData();
        for(PageData temp : list){
            if(temp.getString("NAME").equals("低风险")){
                result.put("dfx",temp.get("total"));
            }
            else if(temp.getString("NAME").equals("一般风险")){
                result.put("yb",temp.get("total"));
            }
            else if(temp.getString("NAME").equals("较大风险")){
                result.put("jd",temp.get("total"));
            }
            else if(temp.getString("NAME").equals("重大风险")){
                result.put("zd",temp.get("total"));
            }
        }

        return result;
    }

    /*驾驶舱右下角统计可能导致的事故类型
     * */
    @RequestMapping(value="/getTongJiAccident")
    @ResponseBody
    public  Map<String,Integer> getTongJiAccident() throws Exception{
        PageData pd = this.getPageData();
        //需要分割多选的部分，先按编码查出来然后分割字符串，用map去匹配
        Map<String, String> accidentTypeMap = dictionariesService.listChildrenByEN(WebConstant.ACCIDENT_TYPE, true);
        List<PageData> list = m_fengxianService.tongJiAccident(pd);

        Map<String,Integer> resultMap = new HashMap<>();

        //初始化resultMap
        for(Map.Entry<String,String> map : accidentTypeMap.entrySet()){
            resultMap.put(map.getKey(),0);
        }

        for(PageData temp : list){
            //如果可以用逗号分隔说明是多选
            String[] str = temp.getString("FENGXIAN_ACCIDENT_TYPE").split(",");
            //多选
            if(str.length != 1){
                for(String tempStr : str){
                    String key = tempStr;
                    BigInteger bigInteger = (BigInteger) temp.get("total");
                    resultMap.put(key, resultMap.get(key) + bigInteger.intValue());
                }
            }
            else{
                String key = temp.getString("FENGXIAN_ACCIDENT_TYPE");
                BigInteger bigInteger = (BigInteger) temp.get("total");
                resultMap.put(key, resultMap.get(key) + bigInteger.intValue());
            }
        }

        Map<String,Integer> resultMapTrue = new HashMap<>();
        for(Map.Entry<String,String> map : accidentTypeMap.entrySet()){
            resultMapTrue.put(map.getValue(),resultMap.get(map.getKey()));
        }

        return resultMapTrue;
    }

    //驾驶舱右下角趋势图
    @RequestMapping(value="/getFengXianByDate")
    @ResponseBody
    public List<PageData> getFengXianByDate() throws Exception {
        PageData pd = this.getPageData();

        //获取前n月的数据
        Date date = new Date();
        //获取到日期,往前4个月
        List<PageData> list = new ArrayList<>();
        for(int i = 1; i<=4;i++){
            SimpleDateFormat sdf = new SimpleDateFormat("M月");
            Date before = getLashDay(new Date(),-i);
            pd.put("before",before);
            Date after = getLashDay(new Date(),-i+1);
            pd.put("after",after);
            String chineseDate = sdf.format(after);
            PageData result = m_fengxianService.tongJiFengXianByDate(pd);
            result.put("date",chineseDate);
            list.add(result);
        }

        return list;
    }

    //获取点击后的表单，传入风险等级和地区id
    @RequestMapping(value="/listByAreaAndLevel")
    @ResponseBody
    public List<PageData> listByAreaAndLevel() throws Exception{
        PageData pd = this.getPageData();
        List<PageData>  result = m_fengxianService.listByAreaAndLevel(pd);
        return result;
    }

    //跳转二级页面
    @RequestMapping(value="/fengXianERJi")
    @ResponseBody
    public ModelAndView fengXianERJi() throws Exception{
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();

        List<PageData>  varList = m_fengxianService.listAll(pd);

        PageData param = new PageData();
        param.put("ORG_LEVEL",2);
        List<PageData> secondUnit = morgService.listAll(param);

        HashMap<String,String> secondMap = new HashMap<>();
        for(PageData pageData : secondUnit){
            secondMap.put(pageData.getString("ORG_ID"),pageData.getString("ORG_NAME"));
        }
        List<Object> secondList = mapToJson(secondMap);

        param.put("ORG_LEVEL","");
        List<PageData> thirdUnit = morgService.listAll(param);

        //获取海南地区
        String hainanParam = "1";
        List<Dictionaries> areaList = dictionariesService.listAllDict(hainanParam);

        PageData hazardParam = new PageData();
        List<PageData> hazardList = m_fengxianService.listAll(hazardParam);

        //事故类型
        Map<String, String> accidentTypeMap = dictionariesService.listChildrenByEN(WebConstant.ACCIDENT_TYPE, true);
        List<Object> accidentTypeJsonList =mapToJson(accidentTypeMap);
        for(PageData temp : varList){
            String[] accident = temp.getString("FENGXIAN_ACCIDENT_TYPE").split(",");
            temp.put("FENGXIAN_ACCIDENT_TYPE",accident);
        }

        Map<String, String> riskLevelMap = dictionariesService.listChildrenByEN(WebConstant.RISK_LEVEL, true);
        List<Object> riskLevelJsonList =mapToJson(riskLevelMap);

        PageData responsibilityParam = new PageData();
        List<PageData> responsibilityList = morgService.listAll(responsibilityParam);

        mv.addObject("pd", pd);
        mv.addObject("varList", varList);
        mv.addObject("secondUnit", secondUnit);
        mv.addObject("thirdUnit", thirdUnit);
        mv.addObject("areaList", areaList);
        mv.addObject("accidentTypeMap", accidentTypeJsonList);
        mv.addObject("riskLevelMap", riskLevelJsonList);
        mv.addObject("responsibilityList", responsibilityList);
        mv.addObject("hazardList", hazardList);
        mv.addObject("secondList", secondList);
        mv.setViewName("frontend/fengXianDetail");
        return mv;
    }


    //获取点击后的表单，传入风险等级和地区id
    @RequestMapping(value="/listFengXian")
    @ResponseBody
    public List<PageData> listFengXian() throws Exception{
        PageData pd = this.getPageData();
        List<PageData>  result = m_fengxianService.listAll(pd);
        return result;
    }

    //获取前n月的日期
    public static String getPrevMonthDate(Date date,int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - n);
        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
    }

    /**封装隐患整改map转json对象的函数
     * @param
     * @throws Exception
     */
    public List<Object> mapToJson(Map<String, String> rectifyMap){
        List<Picker> rectify =new ArrayList<>();
        List<Object> PickerJsonList =new ArrayList<>();
        for(Map.Entry<String,String> entry:rectifyMap.entrySet()){
            Picker picker = new Picker();			//自定义的类，只有编码和名字两个属性
            picker.setBIANMA(entry.getKey());		//分别拿到编码和名字
            picker.setNAME(entry.getValue());
            Object PickerJson = JSONObject.toJSON(picker);//转化为json对象存入
            rectify.add(picker);
            PickerJsonList.add(PickerJson);
        };
        return PickerJsonList;
    }

    /**
     * 获取每月最后一天
     */
    public static Date getLashDay(Date date,int interval) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, interval+1);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }


}
