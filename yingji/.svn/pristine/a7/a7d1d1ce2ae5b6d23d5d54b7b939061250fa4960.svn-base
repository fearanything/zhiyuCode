package com.fh.controller.frontend;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fh.common.WebConstant;
import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.entity.Picker;
import com.fh.service.backend.morg.MOrgManager;
import com.fh.service.backend.rectifyinfo.RectifyInfoManager;
import com.fh.service.backend.userorg.UserOrgManager;
import com.fh.service.system.dictionaries.DictionariesManager;
import com.fh.service.system.user.UserManager;
import com.fh.util.*;
import net.sf.json.JSONArray;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.*;

/**
 * 移动端
 * @author bill
 *
 */
@Controller
@RequestMapping(value="/frontend/mobile")
public class FrontendMobileCotroller extends BaseController {

	@Resource(name="userService")
	private UserManager userService;
	@Resource(name="morgService")
	private MOrgManager morgService;
	@Resource(name="rectifyinfoService")
	private RectifyInfoManager rectifyinfoService;

	@Resource(name="dictionariesService")
	private DictionariesManager dictionariesService;
	@Resource(name="userorgService")
	private UserOrgManager userorgService;

	
	/**通用页面跳转
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/{CALL_INDEX}")
	public ModelAndView newsList(@PathVariable("CALL_INDEX") String CALL_INDEX) throws Exception {
		Session session = Jurisdiction.getSession();
		logBefore(logger, "通用页面跳转" + CALL_INDEX);
		ModelAndView mv = this.getModelAndView();
		PageData user = new PageData();
		user = (PageData) session.getAttribute(Const.SESSION_USER_HK);
		PageData pd = new PageData();
		pd = this.getPageData();
		// 没有频道id时去首页
		if (user == null) {
			CALL_INDEX = "login";
		}
		mv.setViewName("/frontend/mobile/" + CALL_INDEX);
		pd.put("CALL_INDEX", CALL_INDEX);
		mv.addObject("pd", pd);
		return mv;
	}

	/**进入新增页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goFinish")
	public ModelAndView goFinish() throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();

		//判断是否登录
		Session session = Jurisdiction.getSession();
		PageData verify = (PageData) session.getAttribute(Const.SESSION_USER_HK);
		if(verify == null){
			mv.setViewName("/frontend/mobile/login");
		}
		else{
			mv.setViewName("/frontend/mobile/editFinish");

			//在sys_dictionaries查找对应parentid下的数据,然后转成Map数组
			//json数组中存入的是对象，需要一个对应的类让前端拿到元素,所以这里新建了Picker类用于方便获取对象属性
			Map<String, String> classifyMap = dictionariesService.listChildrenByEN(WebConstant.HIDDEN_DANGER_CLASSIFY, true);
			List<Object> classifyJsonList =mapToJson(classifyMap);

			Map<String, String> levelMap = dictionariesService.listChildrenByEN(WebConstant.HIDDEN_DANGER_LEVEL, true);
			List<Object> levelJsonList =mapToJson(levelMap);

			Map<String, String> factorMap = dictionariesService.listChildrenByEN(WebConstant.HIDDEN_DANGER_FACTOR, true);
			List<Object> factorJsonList =mapToJson(factorMap);

			pd = rectifyinfoService.findById(pd);

			//获取图片地址先转成string数组再转成list最后再转成jsonarray,这样才能在js里面赋值
			if(pd.getString("IMG_URL") != null && !pd.getString("IMG_URL").equals("")){
				String[] test = (String[])pd.get("IMG_ARR");
				List<Object> list = new ArrayList<>();
				for(String str : test){
					list.add(str);
				}

				JSONArray jsonarray= JSONArray.fromObject(list);
				mv.addObject("arrP", jsonarray);
			}

			mv.addObject("classifyMap", classifyMap);
			mv.addObject("levelMap",levelMap);
			mv.addObject("factorMap",factorMap);
			mv.addObject("classifyJsonList", classifyJsonList);
			mv.addObject("levelJsonList",levelJsonList);
			mv.addObject("factorJsonList",factorJsonList);
			mv.addObject("org",morgService.findById(pd));			//用于显示所属机构
			mv.addObject("msg", "Edit");		//用于判断是新增还是编辑
			mv.addObject("pd",pd);

		}

		return mv;
	}

	/**进入新增页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goEdit")
	public ModelAndView goEdit() throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();

		//判断是否登录
		Session session = Jurisdiction.getSession();
		PageData verify = (PageData) session.getAttribute(Const.SESSION_USER_HK);
		if(verify == null){
			mv.setViewName("/frontend/mobile/login");
		}
		else{
			mv.setViewName("/frontend/mobile/form");

			//在sys_dictionaries查找对应parentid下的数据,然后转成Map数组
			//json数组中存入的是对象，需要一个对应的类让前端拿到元素,所以这里新建了Picker类用于方便获取对象属性
			Map<String, String> classifyMap = dictionariesService.listChildrenByEN(WebConstant.HIDDEN_DANGER_CLASSIFY, true);
			List<Object> classifyJsonList =mapToJson(classifyMap);

			Map<String, String> levelMap = dictionariesService.listChildrenByEN(WebConstant.HIDDEN_DANGER_LEVEL, true);
			List<Object> levelJsonList =mapToJson(levelMap);

			Map<String, String> factorMap = dictionariesService.listChildrenByEN(WebConstant.HIDDEN_DANGER_FACTOR, true);
			List<Object> factorJsonList =mapToJson(factorMap);

			pd = rectifyinfoService.findById(pd);

			//获取图片地址先转成string数组再转成list最后再转成jsonarray,这样才能在js里面赋值
			if(pd.getString("IMG_URL") != null && !pd.getString("IMG_URL").equals("")){
				String[] test = (String[])pd.get("IMG_ARR");
				List<Object> list = new ArrayList<>();
				for(String str : test){
					list.add(str);
				}

				JSONArray jsonarray= JSONArray.fromObject(list);
				/*JSONArray jsonarray = new JSONArray();
				jsonarray.add(list);*/
				mv.addObject("arrP", jsonarray);
			}

			mv.addObject("classifyMap", classifyMap);
			mv.addObject("levelMap",levelMap);
			mv.addObject("factorMap",factorMap);
			mv.addObject("classifyJsonList", classifyJsonList);
			mv.addObject("levelJsonList",levelJsonList);
			mv.addObject("factorJsonList",factorJsonList);
			mv.addObject("msg", "Edit");		//用于判断是新增还是编辑
			mv.addObject("pd",pd);

		}

		return mv;
	}


	/**进入新增页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goAdd")
	public ModelAndView goAdd() throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();

		//判断是否登录
		Session session = Jurisdiction.getSession();
		PageData verify = (PageData) session.getAttribute(Const.SESSION_USER_HK);
		if(verify == null){
			mv.setViewName("/frontend/mobile/login");
		}
		else{
			mv.setViewName("/frontend/mobile/form");

			pd = userService.findById(verify);
			pd = morgService.findById(pd);
			//在sys_dictionaries查找对应parentid下的数据,然后转成Map数组
			//json数组中存入的是对象，需要一个对应的类让前端拿到元素,所以这里新建了Picker类用于方便获取对象属性
			Map<String, String> classifyMap = dictionariesService.listChildrenByEN(WebConstant.HIDDEN_DANGER_CLASSIFY, true);
			List<Object> classifyJsonList =mapToJson(classifyMap);

			Map<String, String> levelMap = dictionariesService.listChildrenByEN(WebConstant.HIDDEN_DANGER_LEVEL, true);
			List<Object> levelJsonList =mapToJson(levelMap);

			Map<String, String> factorMap = dictionariesService.listChildrenByEN(WebConstant.HIDDEN_DANGER_FACTOR, true);
			List<Object> factorJsonList =mapToJson(factorMap);

			mv.addObject("classifyMap", classifyMap);
			mv.addObject("levelMap",levelMap);
			mv.addObject("factorMap",factorMap);
			mv.addObject("classifyJsonList", classifyJsonList);
			mv.addObject("levelJsonList",levelJsonList);
			mv.addObject("factorJsonList",factorJsonList);
			mv.addObject("msg", "Add");		//用于判断是新增还是编辑
			mv.addObject("pd",pd);
		}


		return mv;
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

	/**进入新增页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goPreview")
	@ResponseBody
	public ModelAndView goPreview() throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		PageData constPd = new PageData();

		//判断是否登录
		Session session = Jurisdiction.getSession();
		PageData verify = (PageData) session.getAttribute(Const.SESSION_USER_HK);
		if(verify == null){
			mv.setViewName("/frontend/mobile/login");
		}
		else{
			pd = this.getPageData();
			pd = rectifyinfoService.findById(pd);
			constPd = morgService.findById(pd);//用于获取机构名称显示在preview页面

			//前端根据MAP的key判断隐患类型、级别和因素
			mv.addObject("classifyMap", dictionariesService.listChildrenByEN(WebConstant.HIDDEN_DANGER_CLASSIFY, true));
			mv.addObject("levelMap", dictionariesService.listChildrenByEN(WebConstant.HIDDEN_DANGER_LEVEL, true));
			mv.addObject("factorMap", dictionariesService.listChildrenByEN(WebConstant.HIDDEN_DANGER_FACTOR, true));
			mv.addObject("pd",pd);
			mv.addObject("constPd",constPd);
			mv.setViewName("/frontend/mobile/preview");
		}


		return mv;
	}

	/**进入新增页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/perviewSubmit")
	@ResponseBody
	public ModelAndView perviewSubmit() throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();

		//判断是否登录
		Session session = Jurisdiction.getSession();
		PageData verify = (PageData) session.getAttribute(Const.SESSION_USER_HK);
		if(verify == null){
			mv.setViewName("/frontend/mobile/login");
		}
		else{
			pd = this.getPageData();
			pd = rectifyinfoService.findById(pd);
			pd.put("IS_SUBMITE","1");
			rectifyinfoService.edit(pd);

			mv.addObject("pd",pd);
			mv.setViewName("/frontend/mobile/myself");
		}


		return mv;
	}

	/**
	 * 查询未提交、未完成、已逾期的列表数据
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/list")
	@ResponseBody
	public PageData list(Page page) throws Exception{
		PageData pd = new PageData();
		Session session = Jurisdiction.getSession();
		pd = (PageData) session.getAttribute(Const.SESSION_USER_HK);
		PageData listType = this.getPageData();

		//放入pd中的属性都会存在session中，需要置为空值
		if(listType.getString("TYPE").equals("NO_SUBMITE")){		//未提交列表
			listType.put("IS_COMPLETE","");
			listType.put("NOW","");
			listType.put("IS_SUBMITE","0");
		}
		else if(listType.getString("TYPE").equals("NO_COMPLETE")){		//未完成列表
			listType.put("IS_SUBMITE","1");
			listType.put("NOW","");
			listType.put("IS_COMPLETE","0");
		}
		else{																//已逾期列表
			listType.put("IS_SUBMITE","1");
			listType.put("IS_COMPLETE","");

			Date date = Tools.getDayAgo(new Date(),0);
			String dayStr = Tools.date2Str(date, "yyyy-MM-dd");		//获取今天日期
			listType.put("NOW", dayStr);
		}

		/*listType.put("ORG_ID",pd.getString("ORG_ID"));*/
		if(!pd.getString("USER_ID").equals("1")){
			listType.put("USER_ID_QX",pd.getString("USER_ID"));
		}

		List<PageData> list = new ArrayList<>();
		String showCount = listType.getString("showCount");
		String currentPage = listType.getString("currentPage");

		page.setShowCount(Integer.parseInt(showCount));
		page.setCurrentPage(Integer.parseInt(currentPage));
		page.setPd(listType);
		list = rectifyinfoService.list(page);

		PageData listPd = new PageData();
		listPd.put("list",list);
		listPd.put("totalPage",page.getTotalPage());

		return listPd;
	}

	/**退出到登录页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/myselfToLogin")
	@ResponseBody
	public ModelAndView myself() throws Exception{
		Session session = Jurisdiction.getSession();
		session.removeAttribute(Const.SESSION_USER_HK);

		ModelAndView mv = this.getModelAndView();
		mv.setViewName("frontend/mobile/login");
		return mv;
	}

	@RequestMapping(value = "/test")
	@ResponseBody
	public JSON test(@RequestParam(value = "fileVal") MultipartFile testData) throws  Exception{
		JSON a = null;
		return a;

	}

	/**
	 * 查询未提交、未完成、已逾期的列表数据
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getItemList")
	@ResponseBody
	public PageData getItemList(Page page) throws Exception{
		Session session = Jurisdiction.getSession();
		PageData constPd = (PageData) session.getAttribute(Const.SESSION_USER_HK);		//从session中读取机构id
		PageData pd = this.getPageData();

		ModelAndView mv = this.getModelAndView();

		//page分页
		List<PageData> list = new ArrayList<>();
		String showCount = pd.getString("showCount");
		String currentPage = pd.getString("currentPage");
		if(!constPd.getString("USER_ID").equals("1")){
			pd.put("USER_ID_QX",constPd.getString("USER_ID"));
		}
		pd.put("NOW", Tools.date2Str(new Date(), "yyyy-MM-dd"));

		//设置page属性查询列表
		page.setShowCount(Integer.parseInt(showCount));
		page.setCurrentPage(Integer.parseInt(currentPage));
		page.setPd(pd);
		list = rectifyinfoService.list(page);

		PageData listPd = new PageData();
		listPd.put("list",list);
		listPd.put("totalPage",page.getTotalPage());

		return listPd;
	}

	/**
	 * 查询未提交、未完成、已逾期的列表数据
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getFinishList")
	@ResponseBody
	public PageData getFinishList(Page page) throws Exception{
		Session session = Jurisdiction.getSession();
		PageData constPd = (PageData) session.getAttribute(Const.SESSION_USER_HK);		//从session中读取机构id
		PageData pd = this.getPageData();

		ModelAndView mv = this.getModelAndView();

		//page分页
		List<PageData> list = new ArrayList<>();
		String showCount = pd.getString("showCount");
		String currentPage = pd.getString("currentPage");
		pd.put("IS_COMPLETE","1");
		if(!constPd.getString("USER_ID").equals("1")){
			pd.put("USER_ID_QX",constPd.getString("USER_ID"));
		}
		pd.put("NOW", Tools.date2Str(new Date(), "yyyy-MM-dd"));

		//设置page属性查询列表
		page.setShowCount(Integer.parseInt(showCount));
		page.setCurrentPage(Integer.parseInt(currentPage));
		page.setPd(pd);
		list = rectifyinfoService.list(page);

		PageData listPd = new PageData();
		listPd.put("list",list);
		listPd.put("totalPage",page.getTotalPage());

		return listPd;
	}

	/**
	 * 查询backlog页面数据
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/backlog")
	public ModelAndView backlog(Page page) throws Exception{
		Session session = Jurisdiction.getSession();
		PageData constPd = (PageData) session.getAttribute(Const.SESSION_USER_HK);

		ModelAndView mv = this.getModelAndView();
		//判断是否登录
		if (constPd == null) {
			mv.setViewName("/frontend/mobile/login");
		}
		else{
			Date date = Tools.getDayAgo(new Date(),0);
			String dayStr = Tools.date2Str(date, "yyyy-MM-dd");		//获取今天日期
			
			PageData param = new PageData();
			String USER_ID = constPd.getString("USER_ID");
			if (!"1".equals(USER_ID)) {
				param.put("USER_ID_QX", USER_ID);
			}
			param.put("NOW", dayStr);

			PageData result = rectifyinfoService.tongjiAll(param);
			result.remove("ORG_CODE");

			mv.addObject("pd",result);
			mv.setViewName("frontend/mobile/backlog");
		}
		return mv;
	}

	/**提交表单数据，新增隐患
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/editFinish")
	@ResponseBody
	public ModelAndView editFinish(
			@RequestParam(value="ORG_ID",required=false) String ORG_ID,		//机构id
			@RequestParam(value="saveImg",required=false) String saveImg,		//base64
			@RequestParam(value="RECTIFY_ID",required=false) String RECTIFY_ID, 	//整改信息id
			@RequestParam(value="HIDDEN_DANGER_CLASSIFY",required=false) String HIDDEN_DANGER_CLASSIFY, 	//隐患类别
			@RequestParam(value="HIDDEN_DANGER_LEVEL",required=false) String HIDDEN_DANGER_LEVEL, 	//隐患级别
			@RequestParam(value="HIDDEN_DANGER_FACTOR",required=false) String HIDDEN_DANGER_FACTOR, 	//隐患因素
			@RequestParam(value="HIDDEN_DANGER_INFO",required=false) String HIDDEN_DANGER_INFO, 	//隐患情况
			@RequestParam(value="RECTIFY_MEASURES",required=false) String RECTIFY_MEASURES, 	//整改措施
			@RequestParam(value="PLAN_COMPLETE_TIME",required=false) String PLAN_COMPLETE_TIME, 	//计划完成时间
			@RequestParam(value="IS_COMPLETE",required=false) String IS_COMPLETE, 	//是否提交
			@RequestParam(value="FILE_CODE",required=false) String FILE_CODE,		//机构id
			@RequestParam(value="PROJECT_NAME",required=false) String PROJECT_NAME,		//机构id
			@RequestParam(value="PERSON_RESPONSIBLE",required=false) String PERSON_RESPONSIBLE,		//机构id
			@RequestParam(value="REMARK",required=false) String REMARK,		//备注
			@RequestParam(value="RECTIFY_INVESTMENT",required=false) String RECTIFY_INVESTMENT		//整改投入
	)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = this.getPageData();
		Session session = Jurisdiction.getSession();
		PageData constPd = (PageData) session.getAttribute(Const.SESSION_USER_HK);

		//没有通过登录就跳到登录页面
		if(constPd == null){
			mv.setViewName("/frontend/mobile/login");
		}
		else{
			String IMG_URL = ImgArrayToString(saveImg);

			pd.put("ORG_ID",constPd.getString("ORG_ID"));	//从session中获取org_id
			if(ORG_ID != null && !ORG_ID.equals("")){
				pd.put("ORG_ID",ORG_ID);	//改变的ORG_ID
			}
			pd.put("IMG_URL",IMG_URL);	//图片
			pd.put("ISDEL","0");	//是否删除
			pd.put("RECTIFY_ID", RECTIFY_ID);	//整改信息id
			pd.put("MODIFYER", constPd.getString("USERNAME"));	//创建人
			pd.put("MODIFY_DATE", Tools.date2Str(new Date()));	//创建时间
			pd.put("HIDDEN_DANGER_CLASSIFY",HIDDEN_DANGER_CLASSIFY);	//隐患类别
			pd.put("HIDDEN_DANGER_LEVEL",HIDDEN_DANGER_LEVEL);	//隐患级别
			pd.put("HIDDEN_DANGER_FACTOR",HIDDEN_DANGER_FACTOR);	//隐患因素
			pd.put("HIDDEN_DANGER_INFO",HIDDEN_DANGER_INFO);	//隐患情况
			pd.put("RECTIFY_MEASURES",RECTIFY_MEASURES);	//整改措施
			pd.put("IS_COMPLETE","1");	//是否完成
			pd.put("PLAN_COMPLETE_TIME",PLAN_COMPLETE_TIME);	//计划完成时间
			pd.put("FILE_CODE",FILE_CODE);	//文件编号
			pd.put("PROJECT_NAME",PROJECT_NAME);	//项目名称
			pd.put("PERSON_RESPONSIBLE",PERSON_RESPONSIBLE);	//负责人
			pd.put("RECTIFY_INVESTMENT",RECTIFY_INVESTMENT);	//整改投入
			pd.put("REMARK",REMARK);	//备注


			//提交时间，分割成年月日存入数据库
			String nowDay = Tools.date2Str(new Date(), "yyyy-MM-dd");
			String COMMIT_TIME = nowDay;
			int month = Integer.parseInt(COMMIT_TIME.substring(5, 7));
			pd.put("COMMIT_TIME", COMMIT_TIME);
			pd.put("YEAR", COMMIT_TIME.substring(0, 4));
			pd.put("MONTH", COMMIT_TIME.substring(5, 7));
			pd.put("DAY", COMMIT_TIME.substring(8, 10));
			pd.put("QUARTER", (month + 2) / 3 + 1);

			rectifyinfoService.edit(pd);

			getModelAndView().addObject(pd);

			//result用于返回统计的数据
			PageData result = new PageData();
			String USER_ID = constPd.getString("USER_ID");
			if (!"1".equals(USER_ID)) {
				result.put("USER_ID_QX", USER_ID);
			}
			result.put("NOW", Tools.date2Str(new Date(), "yyyy-MM-dd"));
			
			mv.addObject("pd",rectifyinfoService.tongjiAll(result));

			mv.setViewName("frontend/mobile/backlog");
		}


		return mv;
	}

	/**提交表单数据，新增隐患
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/Add")
	@ResponseBody
	public ModelAndView Add(
			@RequestParam(value="ORG_ID",required=false) String ORG_ID,		//选中的机构名
			@RequestParam(value="saveImg",required=false) String saveImg,		//base64
			@RequestParam(value="RECTIFY_ID",required=false) String RECTIFY_ID, 	//整改信息id
			@RequestParam(value="HIDDEN_DANGER_CLASSIFY",required=false) String HIDDEN_DANGER_CLASSIFY, 	//隐患类别
			@RequestParam(value="HIDDEN_DANGER_LEVEL",required=false) String HIDDEN_DANGER_LEVEL, 	//隐患级别
			@RequestParam(value="HIDDEN_DANGER_FACTOR",required=false) String HIDDEN_DANGER_FACTOR, 	//隐患因素
			@RequestParam(value="HIDDEN_DANGER_INFO",required=false) String HIDDEN_DANGER_INFO, 	//隐患情况
			@RequestParam(value="RECTIFY_MEASURES",required=false) String RECTIFY_MEASURES, 	//整改措施
			@RequestParam(value="IS_COMPLETE",required=false) String IS_COMPLETE,	//是否完成
			@RequestParam(value="PLAN_COMPLETE_TIME",required=false) String PLAN_COMPLETE_TIME, 	//计划完成时间
			@RequestParam(value="IS_SUBMITE",required=false) String IS_SUBMITE, 	//是否提交
			@RequestParam(value="FILE_CODE",required=false) String FILE_CODE,		//机构id
			@RequestParam(value="PROJECT_NAME",required=false) String PROJECT_NAME,		//机构id
			@RequestParam(value="PERSON_RESPONSIBLE",required=false) String PERSON_RESPONSIBLE,		//负责人
			@RequestParam(value="REMARK",required=false) String REMARK,		//备注
			@RequestParam(value="RECTIFY_INVESTMENT",required=false) String RECTIFY_INVESTMENT		//整改投入
	)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = this.getPageData();
		Session session = Jurisdiction.getSession();
		PageData constPd = (PageData) session.getAttribute(Const.SESSION_USER_HK);

		//没有通过登录就跳到登录页面
		if(constPd == null){
			mv.setViewName("/frontend/mobile/login");
		}
		else{
			//获取图片地址的部分
			String IMG_URL = null;
			String[] base64ImgF = saveImg.split("。");//按照这个格式分割会出现第一个元素为空的情况
			String[] base64Img = Arrays.copyOfRange(base64ImgF, 1, base64ImgF.length);//拿到base64字符串然后分割成数组
			for(String str : base64Img){
				//上传图片
				if(str.indexOf("uploadFiles") >= 0){//如果是已经存入的图片就添加进img_url然后跳过
					if (StringUtils.isEmpty(IMG_URL)) {
						IMG_URL = str;
					} else {
						IMG_URL += "," + str;
					}
					continue;
				}
				//去掉base64前缀,只有去掉data:image/jpeg;base64,这一段才能存入图片
				int length = 0;
				for(int i = 0;i<str.length();i++){
					if(str.charAt(i) == ','){
						length = i;
					}
				}
				String str2 = str.substring(length+1,str.length());

				String imgUrlString = ImageAnd64Binary.saveImage(str2);//将base64转换成图片然后返回保存地址
				if (StringUtils.isEmpty(IMG_URL)) {
					IMG_URL = imgUrlString;
				} else {
					IMG_URL += "," + imgUrlString;
				}
			}

			//pagedata赋值
			pd.put("ORG_ID",constPd.getString("ORG_ID"));	//从session中获取org_id
			if(!ORG_ID.equals("") && ORG_ID != null){
				pd.put("ORG_ID",ORG_ID);	//改变的ORG_ID
			}
			pd.put("IMG_URL",IMG_URL);	//图片
			pd.put("ISDEL","0");	//是否删除
			pd.put("RECTIFY_ID", this.get32UUID());	//主键
			pd.put("CREATER", constPd.getString("USERNAME"));	//创建人
			pd.put("CREATE_DATE", Tools.date2Str(new Date()));	//创建时间
			pd.put("HIDDEN_DANGER_CLASSIFY",HIDDEN_DANGER_CLASSIFY);	//隐患类别
			pd.put("HIDDEN_DANGER_LEVEL",HIDDEN_DANGER_LEVEL);	//隐患级别
			pd.put("HIDDEN_DANGER_FACTOR",HIDDEN_DANGER_FACTOR);	//隐患因素
			pd.put("HIDDEN_DANGER_INFO",HIDDEN_DANGER_INFO);	//隐患情况
			pd.put("RECTIFY_MEASURES",RECTIFY_MEASURES);	//整改措施
			pd.put("IS_COMPLETE",IS_COMPLETE);	//是否完成
			pd.put("IS_SUBMITE",IS_SUBMITE);	//是否提交
			pd.put("PLAN_COMPLETE_TIME",PLAN_COMPLETE_TIME);	//计划完成时间
			pd.put("FILE_CODE",FILE_CODE);	//文件编号
			pd.put("PROJECT_NAME",PROJECT_NAME);	//项目名称
			pd.put("PERSON_RESPONSIBLE",PERSON_RESPONSIBLE);	//负责人
			pd.put("RECTIFY_INVESTMENT",RECTIFY_INVESTMENT);	//整改投入
			pd.put("REMARK",REMARK);	//备注

			//提交时间，分割成年月日存入数据库
			String nowDay = Tools.date2Str(new Date(), "yyyy-MM-dd");
			String COMMIT_TIME = nowDay;
			int month = Integer.parseInt(COMMIT_TIME.substring(5, 7));
			pd.put("COMMIT_TIME", COMMIT_TIME);
			pd.put("YEAR", COMMIT_TIME.substring(0, 4));
			pd.put("MONTH", COMMIT_TIME.substring(5, 7));
			pd.put("DAY", COMMIT_TIME.substring(8, 10));
			pd.put("QUARTER", (month + 2) / 3 + 1);

			rectifyinfoService.save(pd);
			
			PageData result = new PageData();
			String USER_ID = constPd.getString("USER_ID");
			if (!"1".equals(USER_ID)) {
				result.put("USER_ID_QX", USER_ID);
			}
			result.put("NOW", Tools.date2Str(new Date(), "yyyy-MM-dd"));
			mv.addObject("pd",rectifyinfoService.tongjiAll(result));
 
			mv.setViewName("frontend/mobile/backlog");
		}
		return mv;
	}

	/**提交表单数据，新增隐患
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/Edit")
	@ResponseBody
	public ModelAndView Edit(
			@RequestParam(value="ORG_ID",required=false) String ORG_ID,		//机构id
			@RequestParam(value="saveImg",required=false) String saveImg,		//base64
			@RequestParam(value="RECTIFY_ID",required=false) String RECTIFY_ID, 	//整改信息id
			@RequestParam(value="HIDDEN_DANGER_CLASSIFY",required=false) String HIDDEN_DANGER_CLASSIFY, 	//隐患类别
			@RequestParam(value="HIDDEN_DANGER_LEVEL",required=false) String HIDDEN_DANGER_LEVEL, 	//隐患级别
			@RequestParam(value="HIDDEN_DANGER_FACTOR",required=false) String HIDDEN_DANGER_FACTOR, 	//隐患因素
			@RequestParam(value="HIDDEN_DANGER_INFO",required=false) String HIDDEN_DANGER_INFO, 	//隐患情况
			@RequestParam(value="RECTIFY_MEASURES",required=false) String RECTIFY_MEASURES, 	//整改措施
			@RequestParam(value="IS_COMPLETE",required=false) String IS_COMPLETE, 	//是否完成
			@RequestParam(value="PLAN_COMPLETE_TIME",required=false) String PLAN_COMPLETE_TIME, 	//计划完成时间
			@RequestParam(value="IS_SUBMITE",required=false) String IS_SUBMITE, 	//是否提交
			@RequestParam(value="FILE_CODE",required=false) String FILE_CODE,		//机构id
			@RequestParam(value="PROJECT_NAME",required=false) String PROJECT_NAME,		//机构id
			@RequestParam(value="PERSON_RESPONSIBLE",required=false) String PERSON_RESPONSIBLE,		//负责人
			@RequestParam(value="REMARK",required=false) String REMARK,		//备注
			@RequestParam(value="RECTIFY_INVESTMENT",required=false) String RECTIFY_INVESTMENT		//整改投入
	)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = this.getPageData();
		Session session = Jurisdiction.getSession();
		PageData constPd = (PageData) session.getAttribute(Const.SESSION_USER_HK);

		//没有通过登录就跳到登录页面
		if(constPd == null){
			mv.setViewName("/frontend/mobile/login");
		}
		else{
			String IMG_URL = ImgArrayToString(saveImg);


			pd.put("ORG_ID",constPd.getString("ORG_ID"));	//从session中获取org_id

			if(ORG_ID != null && !ORG_ID.equals("")){
				pd.put("ORG_ID",ORG_ID);	//改变的ORG_ID
			}
			pd.put("IMG_URL",IMG_URL);	//图片
			pd.put("ISDEL","0");	//是否删除
			pd.put("RECTIFY_ID", RECTIFY_ID);	//整改信息id
			pd.put("MODIFYER", constPd.getString("USERNAME"));	//创建人
			pd.put("MODIFY_DATE", Tools.date2Str(new Date()));	//创建时间
			pd.put("HIDDEN_DANGER_CLASSIFY",HIDDEN_DANGER_CLASSIFY);	//隐患类别
			pd.put("HIDDEN_DANGER_LEVEL",HIDDEN_DANGER_LEVEL);	//隐患级别
			pd.put("HIDDEN_DANGER_FACTOR",HIDDEN_DANGER_FACTOR);	//隐患因素
			pd.put("HIDDEN_DANGER_INFO",HIDDEN_DANGER_INFO);	//隐患情况
			pd.put("RECTIFY_MEASURES",RECTIFY_MEASURES);	//整改措施
			pd.put("IS_COMPLETE",IS_COMPLETE);	//是否完成
			pd.put("IS_SUBMITE",IS_SUBMITE);	//是否提交
			pd.put("PLAN_COMPLETE_TIME",PLAN_COMPLETE_TIME);	//计划完成时间
			pd.put("FILE_CODE",FILE_CODE);	//文件编号
			pd.put("PROJECT_NAME",PROJECT_NAME);	//项目名称
			pd.put("PERSON_RESPONSIBLE",PERSON_RESPONSIBLE);	//负责人
			pd.put("RECTIFY_INVESTMENT",RECTIFY_INVESTMENT);	//整改投入
			pd.put("REMARK",REMARK);	//备注

			//提交时间，分割成年月日存入数据库
			String nowDay = Tools.date2Str(new Date(), "yyyy-MM-dd");
			String COMMIT_TIME = nowDay;
			int month = Integer.parseInt(COMMIT_TIME.substring(5, 7));
			pd.put("COMMIT_TIME", COMMIT_TIME);
			pd.put("YEAR", COMMIT_TIME.substring(0, 4));
			pd.put("MONTH", COMMIT_TIME.substring(5, 7));
			pd.put("DAY", COMMIT_TIME.substring(8, 10));
			pd.put("QUARTER", (month + 2) / 3 + 1);


			rectifyinfoService.edit(pd);
			
			PageData result = new PageData();
			String USER_ID = constPd.getString("USER_ID");
			if (!"1".equals(USER_ID)) {
				result.put("USER_ID_QX", USER_ID);
			}
			result.put("NOW", Tools.date2Str(new Date(), "yyyy-MM-dd"));
			
			mv.addObject("pd",rectifyinfoService.tongjiAll(result));


			mv.setViewName("frontend/mobile/backlog");
		}


		return mv;
	}

	/**删除单个数据
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/delete")
	@ResponseBody
	public ModelAndView delete() throws Exception{
		ModelAndView mv = this.getModelAndView();

		//为了返回backlog有数据，所以要获取当前机构的id
		Session session = Jurisdiction.getSession();
		PageData pd = (PageData) session.getAttribute(Const.SESSION_USER_HK);

		//没有通过登录就跳到登录页面
		if(pd == null){
			mv.setViewName("/frontend/mobile/login");
		}
		else{
			PageData pds = this.getPageData();//获取要删除的整改信息然后进行删除
			rectifyinfoService.delete(pds);

			Date date = Tools.getDayAgo(new Date(),0);
			String dayStr = Tools.date2Str(date, "yyyy-MM-dd");		//获取今天日期
			
			String USER_ID = pd.getString("USER_ID");
			PageData result = new PageData();
			if (!"1".equals(USER_ID)) {
				result.put("USER_ID_QX", pd.getString("USER_ID"));
			}
			result.put("NOW", dayStr);

			pd = rectifyinfoService.tongjiAll(result);

			getModelAndView().addObject(pd);
			mv.addObject("pd",pd);

			mv.setViewName("frontend/mobile/backlog");
		}


		return mv;
	}

	/**请求登录，验证用户
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/login_login" ,produces="application/json;charset=UTF-8")
	@ResponseBody
	public Object login()throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		PageData pd = new PageData();
		pd = this.getPageData();	//获取用户名和密码
		String errInfo = "";
		String KEYDATA[] = pd.getString("KEYDATA").replaceAll("qq313596790fh", "").replaceAll("QQ978336446fh", "").split(",fh,");
		if(null != KEYDATA && KEYDATA.length == 2){//pc登录页面第三个参数是验证码，手机端暂时去掉
			Session session = Jurisdiction.getSession();

			String USERNAME = KEYDATA[0];	//登录过来的用户名
			String PASSWORD  = KEYDATA[1];	//登录过来的密码
			pd.put("USERNAME", USERNAME);
			String passwd = new SimpleHash("SHA-1", USERNAME, PASSWORD).toString();	//密码加密
			pd.put("PASSWORD", passwd);
			pd = userService.getUserByNameAndPwd(pd);	//根据用户名和密码去读取用户信息
			if(pd != null){
				this.removeSession();//清缓存
				PageData morg = morgService.findById(pd);
				pd.put("LAST_LOGIN", DateUtil.getTime().toString());		//获取当前时间
				pd.put("ORG_CODE",morg == null ? "" : morg.getString("ORG_CODE"));		//放入org_code方便查找下级机构
				userService.updateLastLogin(pd);
				session.setAttribute(Const.SESSION_USER_HK, pd);			//把用户信息放session中
			}
			else{
				errInfo = "usererror"; 				//用户名或密码有误
				logBefore(logger, USERNAME+"登录系统密码或用户名错误");
			}
			if(Tools.isEmpty(errInfo)){
				errInfo = "success";				//验证成功
				logBefore(logger, USERNAME+"登录系统");
			}
		}
		else{
			errInfo = "error";						//缺少参数
		}
		map.put("result", errInfo);
		return AppUtil.returnObject(new PageData(), map);
	}

	/**
	 * 编辑新增页面获取机构名称
	 */
	@RequestMapping(value = "/getOrgName")
	@ResponseBody
	public List<PageData> getOrgName() throws Exception{
		Session session = Jurisdiction.getSession();
		PageData pd = (PageData) session.getAttribute(Const.SESSION_USER_HK);
		if(pd.getString("USER_ID").equals("1")){
			pd.put("USER_ID","");
		}
		List<PageData> list = morgService.listAll(pd);
		return list;
	}

	/**
	 * 将前端图片地址和base64的字符串转化成数组然后存入本地
	 */
	public String ImgArrayToString(String saveImg){		//前端传入的图片地址和base64拼接的字符串
		String IMG_URL = null;
		String[] base64ImgF = saveImg.split("。");//按照这个格式分割会出现第一个元素为空的情况
		String[] base64Img = Arrays.copyOfRange(base64ImgF, 1, base64ImgF.length);//拿到base64字符串然后分割成数组
		for(String str : base64Img){
			//上传图片
			if(str.indexOf("uploadFiles") >= 0){//如果是已经存入的图片就添加进img_url然后跳过
				if (StringUtils.isEmpty(IMG_URL)) {
					IMG_URL = str;
				} else {
					IMG_URL += "," + str;
				}
				continue;
			}
			//去掉base64前缀,只有去掉data:image/jpeg;base64,这一段才能存入图片
			int length = 0;
			for(int i = 0;i<str.length();i++){
				if(str.charAt(i) == ','){
					length = i;
				}
			}
			String str2 = str.substring(length+1,str.length());
			String result = ImageAnd64Binary.saveImage(str2);//将base64转换成图片然后返回保存地址
			if (StringUtils.isEmpty(IMG_URL)) {
				IMG_URL = result;
			} else {
				IMG_URL += "," + result;
			}
		}
		return IMG_URL;
	}



	/**
	 * 清理session
	 */
	public void removeSession(){
		Session session = Jurisdiction.getSession();	//以下清除session缓存
		session.removeAttribute(Const.SESSION_USER_HK);
	}
}
