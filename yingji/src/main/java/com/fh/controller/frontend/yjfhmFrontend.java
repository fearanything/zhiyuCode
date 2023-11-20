package com.fh.controller.frontend;

import com.fh.common.WebConstant;
import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.entity.backend.Monitor;
import com.fh.entity.backend.Monitors;
import com.fh.entity.backend.Project;
import com.fh.entity.backend.Projects;
import com.fh.service.backend.answer.AnswerManager;
import com.fh.service.backend.burst.BurstManager;
import com.fh.service.backend.city.CityManager;
import com.fh.service.backend.duty.DutyManager;
import com.fh.service.backend.file.FileManager;
import com.fh.service.backend.filetype.FiletypeManager;
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
import com.fh.util.*;
import com.hazelcast.util.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "yjfhmFrontend")
public class yjfhmFrontend extends BaseController {
    String menuUrl = "loginimg/list.do"; //菜单地址(权限用)
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
    @Resource(name="rectifyinfoService")
    private RectifyInfoManager rectifyinfoService;
    @Resource(name="morgService")
    private MOrgManager morgService;
    @Resource(name="dictionariesService")
    private DictionariesManager dictionariesService;
    /**
     * 去首页
     */
    @RequestMapping(value="/index")
    public ModelAndView index(HttpServletRequest request, Page page) throws Exception{
        logBefore(logger, "去关首页");
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        //pd = this.getPageData();
        mv.setViewName("frontend/yingJiIndex");
        //查当前台风
        PageData typhoon =typhoonService.findByNow(pd);
        if(typhoon!=null) {
            pd.put("TYPHOON_ID", typhoon.getString("TYPHOON_ID"));
        }
        mv.addObject("typhoon", typhoon);

        //查通知公告
        if(typhoon!=null) {
            List<PageData> noticeList =noticeService.listAll(pd);
            mv.addObject("noticeList", noticeList);
        }
        //查海控应急响应级别
        if(typhoon!=null) {
            pd.put("ANSWER_COMPANY", "海南控股");
            pd.put("lastStart", DateUtil.getTime());
            PageData answer =answerService.findByName(pd);
            mv.addObject("answer", answer);
        }
        //取值班人员3个人
        if(typhoon!=null) {
            pd.put("limitStar", 0);
            pd.put("limitEnd", 3);
            String dateNowStr=DateUtil.getTime();//当前时间
            pd.put("lastStart", dateNowStr);
            List<PageData> dutyList =dutyService.listAll(pd);
            mv.addObject("dutyList", dutyList);
        }
        //取天气
        String weatherStr=getWeather();
        mv.addObject("weatherStr", weatherStr);

        //生成水情图表
        if(typhoon!=null) {
            PageData reservoir = reservoirService.findOne(pd);
            Double WATER_LEVEL=0.0;//警戒水位
            Double WATER_MAX=0.0;//最大水位
            if(reservoir!=null) {
                WATER_LEVEL=Double.valueOf(reservoir.get("WATER_LEVEL").toString());
                WATER_MAX=WATER_LEVEL+30;
            }
            //String lastStart=DateUtil.getDay()+" 00:00:00";
            String lastStart=DateUtil.getDay()+" 00:00:00";
            String lastEnd=DateUtil.getDay()+" 59:59:59";
            List<String> DATA_List=getLineData(reservoir,pd,lastStart,lastEnd);
            String WATER_DATA_STR="";
            String WATER_DATETIME_STR="";
            if(DATA_List!=null&&DATA_List.size()>0) {
                WATER_DATA_STR=DATA_List.get(0);
            }
            if(DATA_List!=null&&DATA_List.size()>1) {
                WATER_DATETIME_STR=DATA_List.get(1);
            }
            mv.addObject("lineChartDate", DateUtil.getDay());
            mv.addObject("WATER_DATA_STR", WATER_DATA_STR);
            mv.addObject("WATER_LEVEL", WATER_LEVEL);
            mv.addObject("WATER_MAX", WATER_MAX);
            mv.addObject("WATER_DATETIME_STR", WATER_DATETIME_STR);
        }
        //String graphURL1=getLineGrap(reservoir,pd,request);
        //mv.addObject("graphURL1", graphURL1);
        //生成项目图表
        String PROJECT_STR=getGrapData(pd);
        mv.addObject("PROJECT_STR", PROJECT_STR);
        //String graphURL2=getGrapPie(pd,request);
        //mv.addObject("graphURL2", graphURL2);
        //查视频数据
        List<Monitors> monitorsMap=new ArrayList<Monitors>();
        List<PageData> monitortypeList =monitortypeService.listAll(pd);
        if(monitortypeList!=null) {
            for(PageData monitortype:monitortypeList) {
                Monitors monitors=new Monitors();
                monitors.setMONITORTYPE_NAME(monitortype.getString("MONITORTYPE_NAME"));
                String MONITORTYPE_ID=monitortype.getString("MONITORTYPE_ID");
                pd.put("MONITORTYPE_ID", MONITORTYPE_ID);
                List<PageData> monitorList=monitorService.listAll(pd);
                if(monitorList!=null) {
                    List<Monitor> mONITOR_LIST=new ArrayList<Monitor>();
                    for(PageData item:monitorList) {
                        Monitor monitor=new Monitor();
                        monitor.setMONITOR_NAME(item.getString("MONITOR_NAME"));
                        monitor.setMONITOR_ID(item.getString("MONITOR_ID"));
                        mONITOR_LIST.add(monitor);
                    }
                    monitors.setMONITOR_LIST(mONITOR_LIST);
                }
                monitorsMap.add(monitors);
            }
        }
        //加载6个默认视频
        pd.put("limitStar", 0);
        pd.put("limitEnd", 6);
        pd.put("IS_DEFAULT", WebConstant.IS_YES);
        List<PageData> defaultList=monitorService.listAllTop(pd);
        if(defaultList!=null) {
            String nameStr="";
            String idStr="";
            for(int i=0;i<defaultList.size();i++) {
                nameStr="MONITOR_ID"+(i+1);
                idStr=defaultList.get(i).getString("MONITOR_ID");
//                String url = getSingleVideoUrl(idStr);
                mv.addObject(nameStr, idStr);
//                mv.addObject(nameStr, url);
            }

        }
        mv.addObject("monitorsMap", monitorsMap);
        return mv;
    }
    //取气象信息
    @SuppressWarnings("unused")
    private String getWeather() throws Exception {
        PageData testPd = SimpleWeather.mainIndexWeather("海口");

        String weatherStr="";
        try
        {
            weatherStr= SimpleWeather.queryWeather("海口");
            //读取当天气象信息
            PageData pd = new PageData();
            String nowDateStr=DateUtil.getDay();
            pd.put("WEATHER_DATE", nowDateStr);
            PageData weather =weatherService.findByDate(pd);

            if(StringUtil.isNullOrEmpty(weatherStr)) {
                if(weather!=null) {
                    weatherStr=weather.getString("WEATHER_INFO");
                }
            }else {
                if(weather!=null) {
                    //修改气象信息
                    weather.put("WEATHER_INFO", weatherStr);	//气象信息
                    String datestr= Tools.date2Str(new Date());
                    weather.put("MODIFYER", "1");	//修改人
                    weather.put("MODIFY_DATE", datestr);	//修改时间
                    weatherService.edit(weather);
                }else {
                    //保存气象信息
                    weather = new PageData();
                    weather.put("WEATHER_ID", this.get32UUID());	//主键
                    weather.put("WEATHER_DATE", nowDateStr);	//气象日期
                    weather.put("WEATHER_INFO", weatherStr);	//气象信息
                    weather.put("SORT", "0");	//排序
                    weather.put("ISDEL", "0");	//删除标志
                    String datestr=Tools.date2Str(new Date());
                    weather.put("CREATER", "1");	//创建人
                    weather.put("CREATE_DATE", datestr);	//创建时间
                    weather.put("MODIFYER", "1");	//修改人
                    weather.put("MODIFY_DATE", datestr);	//修改时间
                    weatherService.save(weather);
                }

            }

        }catch(Exception ex) {
            logBefore(logger, "取气象异常:"+ex.getMessage());
        }
        return  weatherStr;
    }
    //水情图生成方法
    @SuppressWarnings({ "unused", "deprecation" })
    private List<String> getLineData(PageData reservoir,PageData pd,String lastStart,String lastEnd) {
        List<String> DATA_LIST=new ArrayList<String>();
        try {
            pd.put("RESERVOIR_ID", reservoir.getString("RESERVOIR_ID"));
            pd.put("lastStart", lastStart);
            pd.put("lastEnd", lastEnd);
            List<PageData> waterList =waterService.listAll(pd);

            List<Double> WATER_DATA_LIST=new ArrayList<Double>();
            List<String> WATER_DATETIME_LIST=new ArrayList<String>();


            for(PageData water:waterList) {
                Double water_data_value=Double.parseDouble(water.get("WATER_DATA").toString());
                WATER_DATA_LIST.add(water_data_value);
                String water_datetimeStr=water.getString("WATER_DATETIME");
                String hours=String.valueOf(DateUtil.StrToDate(water_datetimeStr).getHours());
                WATER_DATETIME_LIST.add(hours);
            }
            String WATER_DATA_STR="";
            String WATER_DATETIME_STR="";
            if(WATER_DATA_LIST!=null) {

                JSONArray arrH = JSONArray.fromObject(WATER_DATA_LIST);
                WATER_DATA_STR=arrH.toString();
            }
            if(WATER_DATETIME_LIST!=null) {

                JSONArray arrH = JSONArray.fromObject(WATER_DATETIME_LIST);
                WATER_DATETIME_STR=arrH.toString();
            }
            DATA_LIST.add(WATER_DATA_STR);
            DATA_LIST.add(WATER_DATETIME_STR);

        }catch(Exception ex) {
            logBefore(logger, "生成水情图异常:"+ex.getMessage());
        }
        return DATA_LIST;
    }


    //水情图生成方法
    @SuppressWarnings({ "unused", "deprecation" })
    private String getLineGrap(PageData reservoir,PageData pd,HttpServletRequest request) {
        String graphURL ="";
        try
        {
            TimeSeries timeSeries=new TimeSeries("水情统计", Hour.class);
            //时间曲线数据集合
            TimeSeriesCollection lineDataset=new TimeSeriesCollection();
            String water_dateStr="";
            if(reservoir!=null) {
                //取水情数据
                pd.put("RESERVOIR_ID", reservoir.getString("RESERVOIR_ID"));
                List<PageData> waterList=waterService.listAll(pd);

                if(waterList!=null) {
                    for(PageData water:waterList){
                        //构造数据集合
                        String water_datetimeStr=water.getString("WATER_DATETIME");
                        SimpleDateFormat standardDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date myDate = standardDateFormat.parse(water_datetimeStr);
                        Day day = new Day(myDate);
                        water_dateStr=DateUtil.getDay(myDate);
                        int hourInt=DateUtil.StrToDate(water_datetimeStr).getHours();
                        Hour hour1=new Hour(hourInt,day);
                        Double water_data=Double.parseDouble(water.get("WATER_DATA").toString());
                        timeSeries.add(hour1,water_data);
                    }
                    lineDataset.addSeries(timeSeries);
                    JFreeChart chart= ChartFactory.createTimeSeriesChart("水位线","时间","水位",lineDataset,true,false,false);

                    //获得时序图显示区引用
                    XYPlot plot=(XYPlot)chart.getPlot();
                    XYLineAndShapeRenderer xyAndShapeRenderer=(XYLineAndShapeRenderer)plot.getRenderer();

                    //设置网格背景颜色
                    plot.setBackgroundPaint(Color.white);

                    //设置网格竖线颜色
                    plot.setDomainGridlinePaint(Color.pink);

                    //设置曲线图xy轴的距离
                    plot.setAxisOffset(new RectangleInsets(0D,0D,0D,10D));

                    //设置曲线是否显示数据点
                    xyAndShapeRenderer.setBaseShapesVisible(true);

                    //设置子标题
                    TextTitle subTitle=new TextTitle(water_dateStr,new Font("黑体",Font.BOLD,12));
                    chart.addSubtitle(subTitle);

                    //设置曲线显示各数据点的值
                    XYItemRenderer xyitem=plot.getRenderer();
                    xyitem.setBaseItemLabelsVisible(true);
                    xyitem.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));

                    xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
                    xyitem.setBaseItemLabelFont(new Font("Dialog",1,10));
                    plot.setRenderer(xyitem);

                    //设置主标题
                    chart.setTitle(new TextTitle(reservoir.getString("RESERVOIR_NAME")+"水位统计",new Font("隶书",Font.ITALIC,15)));

                    //使用ServletUtilities将报表转换为图片
                    //注意：保存的图片如果希望在浏览器中直接显示，必须使用saveChartAsPNG方法，而不能用saveChartAsJPEG
                    HttpSession session=request.getSession(true);
                    String fileName = ServletUtilities.saveChartAsPNG(chart, 700, 400,
                            null, session);
                    //通过JFreeChart提供的控制器，生成图片的绝对路径
                    graphURL = request.getContextPath() + "/DisplayChart?filename=" + fileName;
                }

            }

        }catch(Exception ex) {
            logBefore(logger, "生成水情图异常:"+ex.getMessage());
        }
        return graphURL;
    }
    //项目图生成方法
    @SuppressWarnings("unused")
    private String getGrapData(PageData pd) {
        String PROJECT_STR="";
        try
        {
            List<PageData> projectList=projectTypeService.listAll(pd);
            List<String> PROJECT_LIST=new ArrayList<String>();
            if(projectList!=null) {
                for(PageData project:projectList){
                    String projectName=project.getString("PROJECTTYPE_NAME");
                    int projectNum=Integer.parseInt(project.get("PROJECTTYPE_NUM").toString());
                    String projectColor=project.getString("PROJECTTYPE_COLOR");
                    String project_value="{ value:"+ projectNum+", name: '"+projectName+"', itemStyle: { color: '"+projectColor+"' } }";
                    PROJECT_LIST.add(project_value);
                }
                if(PROJECT_LIST!=null) {
                    PROJECT_STR= StringUtils.join(PROJECT_LIST,",");
                }
            }
            PROJECT_STR="["+PROJECT_STR+"]";
        }catch(Exception ex) {
            logBefore(logger, "生成项目图异常:"+ex.getMessage());
        }
        return PROJECT_STR;

    }
    //项目图生成方法
    @SuppressWarnings("unused")
    private String getGrapPie(PageData pd,HttpServletRequest request) {
        String graphURL ="";
        try
        {
            //创建饼状图形报表的数据集对象
            DefaultPieDataset dataset = new DefaultPieDataset();
            //添加报表统计数据
            //参数1：数据分类信息，代表数据是哪一类的数据信息，比如初级程序员人数为10000人
            //参数2：该类的数值
            List<PageData> projectList=projectTypeService.listAll(pd);
            if(projectList!=null) {
                for(PageData project:projectList){
                    String projectName=project.getString("PROJECT_NAME");
                    int projectNum=Integer.parseInt(project.get("PROJECT_NUM").toString());
                    dataset.setValue(projectName, projectNum);
                }
                //在内存中创建报表对象(此处使用的是工厂方法)
                //工厂方法参数介绍
                //参数1：报表的标题信息
                //参数2：数据集对象
                //参数6：是否生成图例
                //参数7：是否显示工具提示
                //参数8：是否生成URL
                JFreeChart chart = ChartFactory.createPieChart3D("项目分布图",dataset, true, false, false);

                PiePlot plot = (PiePlot) chart.getPlot();
                plot.setLabelFont(new Font("隶书", 0, 10));

                //没有数据的时候显示的内容
                plot.setNoDataMessage("无数据显示");

                //在饼图的各块中显示百分比
                plot.setCircular(true);
                plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}:{1}"));

                //使用ServletUtilities将报表转换为图片
                //注意：保存的图片如果希望在浏览器中直接显示，必须使用saveChartAsPNG方法，而不能用saveChartAsJPEG
                HttpSession session=request.getSession(true);
                String fileName = ServletUtilities.saveChartAsPNG(chart, 500, 300,
                        null, session);
                //通过JFreeChart提供的控制器，生成图片的绝对路径
                graphURL = request.getContextPath() + "/DisplayChart?filename=" + fileName;
            }

        }catch(Exception ex) {
            logBefore(logger, "生成项目图异常:"+ex.getMessage());
        }
        return graphURL;

    }

    /**
     * 去气象信息页面
     */
    @RequestMapping(value="/weather.html")
    public ModelAndView weather(HttpServletRequest request,Page page) throws Exception{
        logBefore(logger, "去气象信息页面");
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        //pd = this.getPageData();
        mv.setViewName("frontend/weather");
        //查当前台风
        PageData typhoon =typhoonService.findByNow(pd);
        mv.addObject("typhoon", typhoon);
        if(typhoon!=null) {
            pd.put("TYPHOON_ID", typhoon.getString("TYPHOON_ID"));
        }

        //查海控应急响应级别
        if(typhoon!=null) {
            pd.put("ANSWER_COMPANY", "海南控股");
            pd.put("lastStart", DateUtil.getTime());
            PageData answer =answerService.findByName(pd);
            mv.addObject("answer", answer);
        }
        //取天气
        String weatherStr=getWeather();
        mv.addObject("weatherStr", weatherStr);
        mv.addObject("pd", pd);
        return mv;
    }
    /**
     * 去值班信息页面
     */
    @RequestMapping(value="/zhibanMsg.html")
    public ModelAndView zhibanMsg(HttpServletRequest request,Page page) throws Exception{
        logBefore(logger, "去值班信息页面");
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        //pd = this.getPageData();
        mv.setViewName("frontend/zhibanMsg");
        //查当前台风
        PageData typhoon =typhoonService.findByNow(pd);
        mv.addObject("typhoon", typhoon);
        if(typhoon!=null) {
            pd.put("TYPHOON_ID", typhoon.getString("TYPHOON_ID"));
        }

        //取所有值班人员
        if(typhoon!=null) {
            pd.put("limitStar", 0);
            pd.put("limitEnd", 1000);
            String dateNowStr=DateUtil.getTime();//当前时间
            pd.put("lastStart", dateNowStr);
            List<PageData> dutyList =dutyService.listAll(pd);
            mv.addObject("dutyList", dutyList);
            mv.addObject("pd", pd);
        }
        //String cameraUrl=GetCameraPreviewURL.GetCameraURL();
        //logBefore(logger, "摄像头URL:"+cameraUrl);
        return mv;
    }
    /**
     * 去值班信息页面-水情页面
     */
    @RequestMapping(value="/yingji_shuiba.html")
    public ModelAndView yingji_shuiba(HttpServletRequest request,Page page) throws Exception{
        logBefore(logger, "去值班信息页面-水情页面");
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        mv.setViewName("frontend/yingji_shuiba");
        //查当前台风
        PageData typhoon =typhoonService.findByNow(pd);
        mv.addObject("typhoon", typhoon);
        if(typhoon!=null) {
            pd.put("TYPHOON_ID", typhoon.getString("TYPHOON_ID"));
        }

        //取所有水库
        List<PageData> reservoirList=reservoirService.listAll(pd);
        mv.addObject("reservoirList", reservoirList);

        //查第一个水库
        Double WATER_LEVEL=0.0;//警戒水位
        Double WATER_MAX=0.0;//最大水位
        PageData reservoir=new PageData();
        if(pd.getString("RESERVOIR_ID")==null) {
            if(reservoirList!=null) {
                reservoir=reservoirList.get(0);
                WATER_LEVEL=Double.valueOf(reservoir.get("WATER_LEVEL").toString());
                WATER_MAX=WATER_LEVEL+30;
            }
        }else {
            reservoir=reservoirService.findById(pd);
            WATER_LEVEL=Double.valueOf(reservoir.get("WATER_LEVEL").toString());
            WATER_MAX=WATER_LEVEL+30;
        }

        mv.addObject("reservoir", reservoir);
        //生成水情图表
        if(typhoon!=null) {
            String dateStr="";
            String lastStart=DateUtil.getDay()+" 00:00:00";
            dateStr=DateUtil.getDay()+"至";
            if(!StringUtil.isNullOrEmpty(pd.getString("DATE_ID"))) {
                lastStart=DateUtil.getAfterDayDate1(pd.getString("DATE_ID"));
                dateStr=lastStart+"至";
            }
            dateStr=dateStr+DateUtil.getDay();
            lastStart=lastStart+" 00:00:00";
            String lastEnd=DateUtil.getDay()+" 59:59:59";
            List<String> DATA_List=getLineData(reservoir,pd,lastStart,lastEnd);
            String WATER_DATA_STR="";
            String WATER_DATETIME_STR="";
            if(DATA_List!=null&&DATA_List.size()>0) {
                WATER_DATA_STR=DATA_List.get(0);
            }
            if(DATA_List!=null&&DATA_List.size()>1) {
                WATER_DATETIME_STR=DATA_List.get(1);
            }
            mv.addObject("lineChartDate", dateStr);
            mv.addObject("WATER_DATA_STR", WATER_DATA_STR);
            mv.addObject("WATER_LEVEL", WATER_LEVEL);
            mv.addObject("WATER_MAX", WATER_MAX);
            mv.addObject("WATER_DATETIME_STR", WATER_DATETIME_STR);
            //String graphURL1=getLineGrap(reservoir,pd,request);
            //mv.addObject("graphURL1", graphURL1);
        }
        mv.addObject("pd", pd);
        return mv;
    }
    /**
     * 去值班信息页面-项目页面
     */
    @RequestMapping(value="/yingji_gongcheng.html")
    public ModelAndView yingji_gongcheng(HttpServletRequest request,Page page) throws Exception{
        logBefore(logger, "去值班信息页面-项目页面");
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        mv.setViewName("frontend/yingji_gongcheng");
        //查当前台风
        PageData typhoon =typhoonService.findByNow(pd);
        mv.addObject("typhoon", typhoon);
        if(typhoon!=null) {
            pd.put("TYPHOON_ID", typhoon.getString("TYPHOON_ID"));
        }

        //生成项目图表
        String PROJECT_STR=getGrapData(pd);
        mv.addObject("PROJECT_STR", PROJECT_STR);
        //所有项目数据
        List<Projects> projectsMap=new ArrayList<Projects>();

        List<PageData> projectTypeList=projectTypeService.listAll(pd);
        if(projectTypeList!=null) {
            for(PageData projectType:projectTypeList) {
                //添加项目分类
                String PROJECTTYPE_NAME=projectType.getString("PROJECTTYPE_NAME");
                String PROJECTTYPE_NUM=projectType.get("PROJECTTYPE_NUM").toString();
                String PROJECTTYPE_ID=projectType.getString("PROJECTTYPE_ID");
                Projects projects=new Projects();
                projects.setPROJECTTYPE_NAME(PROJECTTYPE_NAME);
                projects.setPROJECTTYPE_NUM(PROJECTTYPE_NUM);
                //添加项目列表
                PageData pdProject = new PageData();
                pdProject.put("PROJECTTYPE_ID", PROJECTTYPE_ID);
                List<PageData> projectList=projectService.listAll(pdProject);
                List<Project> pROJECT_LIST=new ArrayList<Project>();
                if(projectList!=null) {
                    for(PageData project:projectList) {
                        Project item=new Project();
                        item.setPROJECT_NAME(project.getString("PROJECT_NAME"));
                        pROJECT_LIST.add(item);
                    }
                }

                projects.setPROJECT_LIST(pROJECT_LIST);
                //构造数据组
                projectsMap.add(projects);
            }
        }
        mv.addObject("projectsMap", projectsMap);

        mv.addObject("pd", pd);
        return mv;
    }
    /**
     * 去值班信息页面-项目页面
     */
    @RequestMapping(value="/yingji_map.html")
    public ModelAndView yingji_map(HttpServletRequest request,Page page) throws Exception{
        logBefore(logger, "去值班信息页面-项目页面");
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        mv.setViewName("frontend/yingji_map");
        //查当前台风
        PageData typhoon =typhoonService.findByNow(pd);
        mv.addObject("typhoon", typhoon);
        if(typhoon!=null) {
            pd.put("TYPHOON_ID", typhoon.getString("TYPHOON_ID"));
        }

        //所有项目数据
        String PROJECT_STR="";
        List<PageData> cityList=cityService.listAll(pd);
        if(cityList!=null) {
            for(PageData city:cityList) {

                String CITY_ID=city.getString("CITY_ID");
                String CITY_NAME=city.getString("CITY_NAME");//城市名称

                pd.put("CITY_ID", CITY_ID);
                List<PageData> projectList=projectService.listAll(pd);
                if(projectList!=null) {
                    int countValue=projectList.size();
                    String projectNameStr="";
                    for(PageData project:projectList) {
                        String PROJECT_NAME=project.getString("PROJECT_NAME");
                        projectNameStr=projectNameStr+"'"+PROJECT_NAME+"',";
                    }
                    if(projectNameStr.length()>0) {
                        projectNameStr=projectNameStr.substring(0,projectNameStr.length()-1);
                    }
                    PROJECT_STR=PROJECT_STR+"{ name:'"+ CITY_NAME+"', value: "+countValue+", item:["+projectNameStr+"]},";

                }

            }
        }

        mv.addObject("PROJECT_STR", PROJECT_STR);
        mv.addObject("pd", pd);
        return mv;
    }
    /**
     * 去通知详细页面
     */
    @RequestMapping(value="/detail.html")
    public ModelAndView detail(HttpServletRequest request,Page page) throws Exception{
        logBefore(logger, "去通知详细页面");
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        mv.setViewName("frontend/detail");
        //查通知数据
        PageData notice =noticeService.findById(pd);
        mv.addObject("notice", notice);

        mv.addObject("pd", pd);
        return mv;
    }

    /**
     * 去存储中心
     */
    @RequestMapping(value="/changtaiMsg.html")
    public ModelAndView changtaiMsg(HttpServletRequest request,Page page) throws Exception{
        logBefore(logger, "去存储中心");
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        mv.setViewName("frontend/changtaiMsg");
        //查通知数据
        if(!StringUtil.isNullOrEmpty(pd.getString("keywords2"))) {
            pd.put("keywords", pd.getString("keywords2"));
        }
        List<PageData> noticeList =noticeService.listAll(pd);
        mv.addObject("noticeList", noticeList);
        //查所有文件分类
        List<PageData> filetypeList=filetypeService.listAll(pd);
        mv.addObject("filetypeList", filetypeList);
        //查第一个分类
        if(pd.getString("FILETYPE_ID")==null) {
            if(filetypeList!=null) {
                PageData filetype=filetypeList.get(0);
                pd.put("FILETYPE_ID", filetype.getString("FILETYPE_ID"));
            }
        }
        //查第一个分类的文件
        if(!StringUtil.isNullOrEmpty(pd.getString("keywords1"))) {
            pd.put("keywords", pd.getString("keywords1"));
        }else {
            pd.put("keywords", "");
        }
        List<PageData> fileList=fileService.listAll(pd);
        mv.addObject("fileList", fileList);

        mv.addObject("pd", pd);
        return mv;
    }
    /**
     * 去应急响应页面
     */
    @RequestMapping(value="/yingji.html")
    public ModelAndView yingji(HttpServletRequest request,Page page) throws Exception{
        logBefore(logger, "去应急响应页面");
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        //pd = this.getPageData();
        mv.setViewName("frontend/yingji");
        //查当前台风
        PageData typhoon =typhoonService.findByNow(pd);
        mv.addObject("typhoon", typhoon);
        if(typhoon!=null) {
            pd.put("TYPHOON_ID", typhoon.getString("TYPHOON_ID"));
        }

        //查海控应急响应级别
        if(typhoon!=null) {
            pd.put("ANSWER_COMPANY", "海南控股");
            pd.put("lastStart", DateUtil.getTime());
            PageData answer =answerService.findByName(pd);
            mv.addObject("answer", answer);
        }
        //查I级响应公司
        if(typhoon!=null) {
            pd.put("ANSWER_LEVEL", WebConstant.ANSWER_LEVEL_1);
            pd.put("lastStart", DateUtil.getTime());
            List<PageData> answerList1 =answerService.listAll(pd);
            mv.addObject("answerList1", answerList1);
        }
        //查II级响应公司
        if(typhoon!=null) {
            pd.put("ANSWER_LEVEL", WebConstant.ANSWER_LEVEL_2);
            pd.put("lastStart", DateUtil.getTime());
            List<PageData> answerList2 =answerService.listAll(pd);
            mv.addObject("answerList2", answerList2);
        }
        //查III级响应公司
        if(typhoon!=null) {
            pd.put("ANSWER_LEVEL", WebConstant.ANSWER_LEVEL_3);
            pd.put("lastStart", DateUtil.getTime());
            List<PageData> answerList3 =answerService.listAll(pd);
            mv.addObject("answerList3", answerList3);
        }
        //查IV级响应公司
        if(typhoon!=null) {
            pd.put("ANSWER_LEVEL", WebConstant.ANSWER_LEVEL_4);
            pd.put("lastStart", DateUtil.getTime());
            List<PageData> answerList4 =answerService.listAll(pd);
            mv.addObject("answerList4", answerList4);
        }
        mv.addObject("pd", pd);
        return mv;
    }
    /**
     * 去应急响应页面-应急防讯
     */
    @RequestMapping(value="/yingji_fangxun.html")
    public ModelAndView yingji_fangxun(HttpServletRequest request,Page page) throws Exception{
        logBefore(logger, "去应急响应页面");
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        //pd = this.getPageData();
        mv.setViewName("frontend/yingji_fangxun");
        //查当前台风
        PageData typhoon =typhoonService.findByNow(pd);
        mv.addObject("typhoon", typhoon);
        if(typhoon!=null) {
            pd.put("TYPHOON_ID", typhoon.getString("TYPHOON_ID"));
        }
        List<PageData> riskList =riskService.listAll(pd);
        mv.addObject("riskList", riskList);
        mv.addObject("pd", pd);
        return mv;
    }
    /**
     * 去应急响应页面-突发事件
     */
    @RequestMapping(value="/yingji_tufa.html")
    public ModelAndView yingji_tufa(HttpServletRequest request,Page page) throws Exception{
        logBefore(logger, "去应急响应页面");
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        //pd = this.getPageData();
        mv.setViewName("frontend/yingji_tufa");
        //查当前台风
        PageData typhoon =typhoonService.findByNow(pd);
        mv.addObject("typhoon", typhoon);
        if(typhoon!=null) {
            pd.put("TYPHOON_ID", typhoon.getString("TYPHOON_ID"));
        }
        List<PageData> burstList =burstService.listAll(pd);
        mv.addObject("burstList", burstList);
        mv.addObject("pd", pd);
        return mv;
    }
    /**
     * 去视频播放
     */
    @RequestMapping(value="/video.html")
    public ModelAndView video(HttpServletRequest request,Page page) throws Exception{
        logBefore(logger, "去通知详细页面");
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        mv.setViewName("frontend/detail");
        //查视频数据
        List<Monitors> monitorsMap=new ArrayList<Monitors>();
        List<PageData> monitortypeList =monitortypeService.listAll(pd);
        if(monitortypeList!=null) {
            for(PageData monitortype:monitortypeList) {
                Monitors monitors=new Monitors();
                monitors.setMONITORTYPE_NAME(monitortype.getString("MONITORTYPE_NAME"));
                String MONITORTYPE_ID=monitortype.getString("MONITORTYPE_ID");
                pd.put("MONITORTYPE_ID", MONITORTYPE_ID);
                List<PageData> monitorList=monitorService.listAll(pd);
                if(monitorList!=null) {
                    List<Monitor> mONITOR_LIST=new ArrayList<Monitor>();
                    for(PageData item:monitorList) {
                        Monitor monitor=new Monitor();
                        monitor.setMONITOR_NAME(item.getString("MONITOR_NAME"));
                        monitor.setMONITOR_URL(item.getString("MONITOR_URL"));
                        mONITOR_LIST.add(monitor);
                    }
                    monitors.setMONITOR_LIST(mONITOR_LIST);
                }
                monitorsMap.add(monitors);
            }
        }
        mv.addObject("monitorsMap", monitorsMap);
        mv.addObject("pd", pd);
        return mv;
    }
    /**
     * 去视频播放
     */
    @RequestMapping(value="/play.html")
    public ModelAndView play(HttpServletRequest request,Page page) throws Exception{
        logBefore(logger, "去存储中心");
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        mv.setViewName("frontend/playVideo");
        PageData monitor =monitorService.findById(pd);
        String MONITORTYPE_CODE="";
        if(monitor!=null) {
            String MONITOR_NAME=monitor.getString("MONITOR_NAME");
            String MONITOR_URL=monitor.getString("MONITOR_URL");
            pd.put("URL", MONITOR_URL);
            pd.put("CODE", monitor.getString("MONITOR_CODE"));
            MONITORTYPE_CODE=monitor.getString("MONITORTYPE_CODE");
            //能源
            if(WebConstant.SYS_1001.equals(MONITORTYPE_CODE)) {
                // mv.setViewName("frontend/playVideo"); 以前的视频播放地址，后改用萤石云

                if(MONITOR_URL.contains("ezopen")) {
                    // 新的萤石云方式播放

                    //取动态莹石云的accessToken
                    String token_url="https://open.ys7.com/api/lapp/token/get";
                    String param="appKey=ae0249ea4d324b60b3cb6bed4df3712b&appSecret=39034312644bc68e8e2d9b29991e7f59";

                    if (MONITOR_NAME.indexOf("牛路岭") != -1) {
                        // 牛路岭的萤石云监控是另外的参数
                        param="appKey=4c96264b599448b99845dca68354376a&appSecret=f94798198bbafb3c1913f73b0ce6a259";
                    }

                    //tonkenStr是参数字符串
                    String tokenStr= HttpRequest.sendPost(token_url, param);
                    if(!StringUtil.isNullOrEmpty(tokenStr)) {
                        //获取参数
                        JSONObject jsonObject = JSONObject.fromObject(tokenStr);
                        //data中是accessToken和过期时间
                        JSONObject data = jsonObject.getJSONObject("data");
                        String accessToken=data.getString("accessToken");
                        accessToken="accessToken="+accessToken;
                        //数据库中的监控地址
                        String URL1=pd.getString("URL");
                        //分割成地址加参数
                        String[] urlList= URL1.split("&");
                        String URL="";
                        //替换accessToken
                        for(int i=0; i<urlList.length;i++) {
                            if(urlList[i].contains("accessToken")) {
                                urlList[i]=accessToken;
                            }
                        }
                        for(String str:urlList) {
                            URL=URL+str+"&";
                        }
                        if(!StringUtil.isNullOrEmpty(URL)) {
                            URL=URL.substring(0,URL.length()-1);
                        }
                        pd.put("URL", URL);
                    }

                    mv.setViewName("frontend/playVideo2");
                } else {
                    // 以前的播放地址
                    mv.setViewName("frontend/playVideo2");
                }
            }
            //业置
            if(WebConstant.SYS_1002.equals(MONITORTYPE_CODE)) {
                mv.setViewName("frontend/playVideo2");
            }
            //水电
            if(WebConstant.SYS_1003.equals(MONITORTYPE_CODE)) {
                //取动态莹石云的accessToken
                String token_url="https://open.ys7.com/api/lapp/token/get";
                String param="appKey=d0a2e366fe064d8e83c5ea394635e4eb&appSecret=a4e88667310ee5ca36616532d63128d6";
                if(MONITOR_NAME.contains("迈湾")) {
                    param="appKey=d0a2e366fe064d8e83c5ea394635e4eb&appSecret=a4e88667310ee5ca36616532d63128d6";
                }
                if(MONITOR_NAME.contains("天角潭")) {
                    param="appKey=79b2640e291f4ab2ad1964e01bb15659&appSecret=69c5e06d9f30a7d4fe07b09b43238f6d";
                }
                if(MONITOR_NAME.contains("琼西北一标")) {
                    param="appKey=22f1a03b19354b33a9b1786ccf3329d5&appSecret=ee9c4992ea6428b175fb190f3e6213ab";
                }
                if(MONITOR_NAME.contains("琼西北二标")) {
                    param="appKey=ba1388e7e1e240ea98d7fa48693a1cf2&appSecret=fb5f99295488f1920cd951a97f278070";
                }
                if(MONITOR_NAME.contains("琼西北三标")) {
                    param="appKey=ce9504f980924a17b808468faa8c9ba2&appSecret=c214731ffb5f514c6953c62a9ddae286";
                }
                String tokenStr=HttpRequest.sendPost(token_url, param);
                if(!StringUtil.isNullOrEmpty(tokenStr)) {
                    JSONObject jsonObject = JSONObject.fromObject(tokenStr);
                    JSONObject data = jsonObject.getJSONObject("data");
                    String accessToken=data.getString("accessToken");
                    accessToken="accessToken="+accessToken;
                    String URL1=pd.getString("URL");
                    String[] urlList= URL1.split("&");
                    String URL="";
                    for(int i=0; i<urlList.length;i++) {
                        if(urlList[i].contains("accessToken")) {
                            urlList[i]=accessToken;
                        }
                    }
                    for(String str:urlList) {
                        URL=URL+str+"&";
                    }
                    if(!StringUtil.isNullOrEmpty(URL)) {
                        URL=URL.substring(0,URL.length()-1);
                    }
                    pd.put("URL", URL);
                }

                mv.setViewName("frontend/playVideo2");
            }
        }
        mv.addObject("pd", pd);
        return mv;
    }

    /**
     * 进入主页面前获取播放地址
     * 使用直播地址加上accessToken参数进行播放
     * 新的直播地址是根据accessToken加上序列号和通道号查找到地址
     */
    @RequestMapping(value="/getSingleVideoUrl")
    public String getSingleVideoUrl(String monitorId) throws Exception{

        //传入monitorId
        PageData pd = new PageData();
        pd.put("MONITOR_ID",monitorId);

        PageData monitor =monitorService.findById(pd);
        String MONITORTYPE_CODE="";
        if(monitor!=null) {
            String MONITOR_NAME=monitor.getString("MONITOR_NAME");
            String MONITOR_URL=monitor.getString("MONITOR_URL");
            pd.put("URL", MONITOR_URL);
            pd.put("CODE", monitor.getString("MONITOR_CODE"));
            MONITORTYPE_CODE=monitor.getString("MONITORTYPE_CODE");
            //能源
            if(WebConstant.SYS_1001.equals(MONITORTYPE_CODE)) {
                //取动态莹石云的accessToken
                String token_url="https://open.ys7.com/api/lapp/token/get";
                String param="appKey=ae0249ea4d324b60b3cb6bed4df3712b&appSecret=39034312644bc68e8e2d9b29991e7f59";

                if (MONITOR_NAME.indexOf("牛路岭") != -1) {
                    // 牛路岭的萤石云监控是另外的参数
                    param="appKey=4c96264b599448b99845dca68354376a&appSecret=f94798198bbafb3c1913f73b0ce6a259";
                }

                //tonkenStr是参数字符串
                String tokenStr= HttpRequest.sendPost(token_url, param);
                if(!StringUtil.isNullOrEmpty(tokenStr)) {
                    //获取参数
                    JSONObject jsonObject = JSONObject.fromObject(tokenStr);
                    //data中是accessToken和过期时间
                    JSONObject data = jsonObject.getJSONObject("data");
                    String accessToken=data.getString("accessToken");
                    accessToken="accessToken="+accessToken;
                    //数据库中的监控地址
                    String URL1=pd.getString("URL");
                    //分割成地址加参数
                    String[] urlList= URL1.split("&");
                    String URL="";
                    //替换accessToken
                    for(int i=0; i<urlList.length;i++) {
                        if(urlList[i].contains("accessToken")) {
                            urlList[i]=accessToken;
                        }
                    }
                    for(String str:urlList) {
                        URL=URL+str+"&";
                    }
                    if(!StringUtil.isNullOrEmpty(URL)) {
                        URL=URL.substring(0,URL.length()-1);
                    }
                    pd.put("URL", URL);
                }

            }
            //业置
            if(WebConstant.SYS_1002.equals(MONITORTYPE_CODE)) {

            }
            //水电
            if(WebConstant.SYS_1003.equals(MONITORTYPE_CODE)) {
                //取动态莹石云的accessToken
                String token_url="https://open.ys7.com/api/lapp/token/get";
                String param="appKey=d0a2e366fe064d8e83c5ea394635e4eb&appSecret=a4e88667310ee5ca36616532d63128d6";
                if(MONITOR_NAME.contains("迈湾")) {
                    param="appKey=d0a2e366fe064d8e83c5ea394635e4eb&appSecret=a4e88667310ee5ca36616532d63128d6";
                }
                if(MONITOR_NAME.contains("天角潭")) {
                    param="appKey=79b2640e291f4ab2ad1964e01bb15659&appSecret=69c5e06d9f30a7d4fe07b09b43238f6d";
                }
                if(MONITOR_NAME.contains("琼西北一标")) {
                    param="appKey=22f1a03b19354b33a9b1786ccf3329d5&appSecret=ee9c4992ea6428b175fb190f3e6213ab";
                }
                if(MONITOR_NAME.contains("琼西北二标")) {
                    param="appKey=ba1388e7e1e240ea98d7fa48693a1cf2&appSecret=fb5f99295488f1920cd951a97f278070";
                }
                if(MONITOR_NAME.contains("琼西北三标")) {
                    param="appKey=ce9504f980924a17b808468faa8c9ba2&appSecret=c214731ffb5f514c6953c62a9ddae286";
                }
                String tokenStr=HttpRequest.sendPost(token_url, param);
                if(!StringUtil.isNullOrEmpty(tokenStr)) {
                    JSONObject jsonObject = JSONObject.fromObject(tokenStr);
                    JSONObject data = jsonObject.getJSONObject("data");
                    String accessToken=data.getString("accessToken");
                    accessToken="accessToken="+accessToken;
                    String URL1=pd.getString("URL");
                    String[] urlList= URL1.split("&");
                    String URL="";
                    for(int i=0; i<urlList.length;i++) {
                        if(urlList[i].contains("accessToken")) {
                            urlList[i]=accessToken;
                        }
                    }
                    for(String str:urlList) {
                        URL=URL+str+"&";
                    }
                    if(!StringUtil.isNullOrEmpty(URL)) {
                        URL=URL.substring(0,URL.length()-1);
                    }
                    pd.put("URL", URL);
                }

            }
        }

        //只返回直播地址
        return pd.getString("URL");
    }


    /**
     * 测试获取accessToken
     */
    @RequestMapping(value="/getVedioUrl")
    public String getAccessToken(HttpServletRequest request,Page page) throws Exception{
        String accessToken = null;

        String token_url="https://open.ys7.com/api/lapp/token/get";
        String param="appKey=ae0249ea4d324b60b3cb6bed4df3712b&appSecret=39034312644bc68e8e2d9b29991e7f59";

        //tonkenStr是参数字符串
        String tokenStr= HttpRequest.sendPost(token_url, param);
        //转化成json
        JSONObject jsonObject = JSONObject.fromObject(tokenStr);
        JSONObject data = jsonObject.getJSONObject("data");
        accessToken=data.getString("accessToken");

        Tools.writeFile(Const.ACCESSTOKEN,accessToken);	//写入授权令牌
        return "ssuccess";
    }

    /**TODO
     * 获取直播地址
     */
    @RequestMapping(value="/getStreamUrl")
    public String getStreamUrl(HttpServletRequest request,Page page) throws Exception{
        String token_url="https://open.ys7.com/api/lapp/v2/live/address/get";
        String param="accessToken=at.2llpaog7dqti3jzy8t5tgwho084t3xtd-4qqw9szs4l-1vt5wnq-ojutmjiya&deviceSerial=G26395399&channelNo=3";

        //tonkenStr是参数字符串
        String tokenStr= HttpRequest.sendPost(token_url, param);
        //转化成json
        JSONObject jsonObject = JSONObject.fromObject(tokenStr);
        JSONObject data = jsonObject.getJSONObject("data");
//        accessToken=data.getString("accessToken");

        return "ssuccess";
    }

    /**
     * 去关于我们页面
     */
    @RequestMapping(value="/about2.html")
    public void about(HttpServletRequest request, HttpServletResponse resp, Page page) throws Exception{
        logBefore(logger, "去关于我们页面");
        resp.sendRedirect("https://153.0.150.42:4430/portal/ui/index");
    }
    /**
     * 去关于我们页面
     */
    @RequestMapping(value="/about1.html")
    public ModelAndView about(HttpServletRequest request,Page page) throws Exception{
        logBefore(logger, "去关于我们页面");
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        mv.setViewName("frontend/about");
        mv.addObject("pd", pd);
        return mv;
    }
    /**
     * 去Demo1
     */
    @RequestMapping(value="/demo_for_iframe.html")
    public ModelAndView demoIframe1(HttpServletRequest request,Page page) throws Exception{
        logBefore(logger, "去关于我们页面");
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        mv.setViewName("frontend/demo_for_iframe");
        mv.addObject("pd", pd);
        return mv;
    }
    /**
     * 去Demo2
     */
    @RequestMapping(value="/demo_embedded_for_iframe.html")
    public ModelAndView demoIframe2(HttpServletRequest request,Page page) throws Exception{
        logBefore(logger, "去关于我们页面");
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        PageData monitor =monitorService.findById(pd);
        if(monitor!=null) {
            pd.put("CODE", monitor.getString("MONITOR_CODE"));
        }
        mv.setViewName("frontend/demo_embedded_for_iframe");
        mv.addObject("pd", pd);
        return mv;
    }
    /**
     * 去Demo2
     */
    @RequestMapping(value="/demo_embedded_for_iframe1.html")
    public ModelAndView demoIframe4(HttpServletRequest request,Page page) throws Exception{
        logBefore(logger, "去关于我们页面");
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        PageData monitor =monitorService.findById(pd);
        if(monitor!=null) {
            pd.put("CODE", monitor.getString("MONITOR_CODE"));
        }
        mv.setViewName("frontend/playMax/demo_embedded_for_iframe");
        mv.addObject("pd", pd);
        return mv;
    }
    /**
     * 去Demo3
     */
    @RequestMapping(value="/playVideohk.html")
    public ModelAndView demoIframe3(HttpServletRequest request,Page page) throws Exception{
        logBefore(logger, "去关于我们页面");
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        mv.setViewName("frontend/playVideohk");
        mv.addObject("pd", pd);
        return mv;
    }
    /**
     * 去视频播放
     */
    @RequestMapping(value="/playMax.html")
    public ModelAndView playMax(HttpServletRequest request,Page page) throws Exception{
        logBefore(logger, "去存储中心");
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        mv.setViewName("frontend/playVideo");
        PageData monitor =monitorService.findById(pd);
        String MONITORTYPE_CODE="";
        if(monitor!=null) {
            String MONITOR_NAME=monitor.getString("MONITOR_NAME");
            pd.put("URL", monitor.getString("MONITOR_URL"));
            pd.put("CODE", monitor.getString("MONITOR_CODE"));
            MONITORTYPE_CODE=monitor.getString("MONITORTYPE_CODE");
            //能源
            if(WebConstant.SYS_1001.equals(MONITORTYPE_CODE)) {
                mv.setViewName("frontend/playMax/playVideo");
            }
            //置业
            if(WebConstant.SYS_1002.equals(MONITORTYPE_CODE)) {
                mv.setViewName("frontend/playMax/demo_for_iframe");
            }
            //水电
            if(WebConstant.SYS_1003.equals(MONITORTYPE_CODE)) {
                //取动态莹石云的accessToken
                String token_url="https://open.ys7.com/api/lapp/token/get";
                String param="appKey=d0a2e366fe064d8e83c5ea394635e4eb&appSecret=a4e88667310ee5ca36616532d63128d6";
                if(MONITOR_NAME.contains("迈湾")) {
                    param="appKey=d0a2e366fe064d8e83c5ea394635e4eb&appSecret=a4e88667310ee5ca36616532d63128d6";
                }
                if(MONITOR_NAME.contains("天角潭")) {
                    param="appKey=79b2640e291f4ab2ad1964e01bb15659&appSecret=69c5e06d9f30a7d4fe07b09b43238f6d";
                }
                if(MONITOR_NAME.contains("琼西北一标")) {
                    param="appKey=22f1a03b19354b33a9b1786ccf3329d5&appSecret=ee9c4992ea6428b175fb190f3e6213ab";
                }
                if(MONITOR_NAME.contains("琼西北二标")) {
                    param="appKey=ba1388e7e1e240ea98d7fa48693a1cf2&appSecret=fb5f99295488f1920cd951a97f278070";
                }
                if(MONITOR_NAME.contains("琼西北三标")) {
                    param="appKey=ce9504f980924a17b808468faa8c9ba2&appSecret=c214731ffb5f514c6953c62a9ddae286";
                }
                String tokenStr=HttpRequest.sendPost(token_url, param);
                if(!StringUtil.isNullOrEmpty(tokenStr)) {
                    JSONObject jsonObject = JSONObject.fromObject(tokenStr);
                    JSONObject data = jsonObject.getJSONObject("data");
                    String accessToken=data.getString("accessToken");
                    accessToken="accessToken="+accessToken;
                    String URL1=pd.getString("URL");
                    String[] urlList= URL1.split("&");
                    String URL="";
                    for(int i=0; i<urlList.length;i++) {
                        if(urlList[i].contains("accessToken")) {
                            urlList[i]=accessToken;
                        }
                    }
                    for(String str:urlList) {
                        URL=URL+str+"&";
                    }
                    if(!StringUtil.isNullOrEmpty(URL)) {
                        URL=URL.substring(0,URL.length()-1);
                    }
                    pd.put("URL", URL);
                }

                mv.setViewName("frontend/playMax/playVideo2");
            }
        }
        mv.addObject("pd", pd);
        return mv;
    }
}
