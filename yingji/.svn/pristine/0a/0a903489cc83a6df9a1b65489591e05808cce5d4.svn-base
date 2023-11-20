package com.fh.controller.backend;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fh.common.WebConstant;
import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.util.AppUtil;
import com.fh.util.ObjectExcelView;
import com.fh.util.PageData;
import com.fh.util.Jurisdiction;
import com.fh.util.Tools;
import com.fh.service.backend.answer.AnswerManager;
import com.fh.service.backend.notice.NoticeManager;
import com.fh.service.backend.typhoon.TyphoonManager;

/** 
 * 说明：应急响应
 * 创建人：FH Q313596790
 * 创建时间：2022-09-21
 */
@Controller
@RequestMapping(value="/answer")
public class AnswerController extends BaseController {
	
	String menuUrl = "answer/list.do"; //菜单地址(权限用)
	@Resource(name="answerService")
	private AnswerManager answerService;
	@Resource(name="typhoonService")
	private TyphoonManager typhoonService;
	@Resource(name="noticeService")
	private NoticeManager noticeService;
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增Answer");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("ANSWER_ID", this.get32UUID());	//主键
		pd.put("SORT", "0");	//排序
		pd.put("ISDEL", "0");	//删除标志
		String datestr=Tools.date2Str(new Date());
		pd.put("CREATER", Jurisdiction.getUserId());	//创建人
		pd.put("CREATE_DATE", datestr);	//创建时间
		pd.put("MODIFYER", Jurisdiction.getUserId());	//修改人
		pd.put("MODIFY_DATE", datestr);	//修改时间
		answerService.save(pd);
		//应急响应发通知公告
		PageData pdNotice = new PageData();
		pdNotice.put("NOTICE_ID", this.get32UUID());	//主键
		String TYPHOON_ID=pd.getString("TYPHOON_ID");
		pdNotice.put("TYPHOON_ID", TYPHOON_ID);	//台风
		String datestr3=Tools.date3Str(new Date());
		pdNotice.put("NOTICE_DATETIME", datestr3);	//响应时间
		String NOTICE_TITLE=pd.getString("ANSWER_COMPANY")+"应急响应"+pd.getString("ANSWER_LEVEL")+"级";
		pdNotice.put("NOTICE_TITLE", NOTICE_TITLE);	//标题
		String NOTICE_DATETIME=pd.getString("START_DATETIME");
		String NOTICE_CONTENT=pd.getString("ANSWER_COMPANY")+"应急响应"+pd.getString("ANSWER_LEVEL")+"级";
		NOTICE_CONTENT=NOTICE_CONTENT+"  响应时间："+NOTICE_DATETIME;
		pdNotice.put("NOTICE_CONTENT", NOTICE_CONTENT);	//内容
		pdNotice.put("SORT", "0");	//排序
		pdNotice.put("ISDEL", "0");	//删除标志
		pdNotice.put("CREATER", Jurisdiction.getUserId());	//创建人
		pdNotice.put("CREATE_DATE", datestr);	//创建时间
		pdNotice.put("MODIFYER", Jurisdiction.getUserId());	//修改人
		pdNotice.put("MODIFY_DATE", datestr);	//修改时间
		noticeService.save(pdNotice);
		//更新之前的响应结束时间
//		PageData pdW = new PageData();
//		pdW.put("TYPHOON_ID",pd.getString("TYPHOON_ID"));
//		pdW.put("ANSWER_COMPANY", pd.getString("ANSWER_COMPANY"));
//		List<PageData> answerList=answerService.listAll(pdW);
//		for(PageData pd1:answerList) {
//			if(!pd1.getString("ANSWER_ID").equals(pd.getString("ANSWER_ID"))) {
//				pd1.put("END_DATETIME", pd.getString("START_DATETIME"));
//				answerService.edit2(pd1);
//			}
//		}
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**删除
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value="/delete")
	public void delete(PrintWriter out) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"删除Answer");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		answerService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改Answer");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String datestr=Tools.date2Str(new Date());
		pd.put("MODIFYER", Jurisdiction.getUserId());	//修改人
		pd.put("MODIFY_DATE", datestr);	//修改时间
		answerService.edit(pd);
		
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"列表Answer");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
		List<PageData>	varList = answerService.list(page);	//列出Answer列表
		mv.setViewName("backend/answer/answer_list");
		List<PageData> typhoonList=typhoonService.listAll(pd);
		mv.addObject("typhoonMap", typhoonList);
		Map<String, String> answerlevelMap=WebConstant.getAnswerLevelMap();
		mv.addObject("answerlevelMap", answerlevelMap);
		mv.addObject("varList", varList);
		mv.addObject("pd", pd);
		mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
		return mv;
	}
	
	/**去新增页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goAdd")
	public ModelAndView goAdd()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("backend/answer/answer_edit");
		List<PageData> typhoonList=typhoonService.listAll(pd);
		mv.addObject("typhoonMap", typhoonList);
		Map<String, String> answerlevelMap=WebConstant.getAnswerLevelMap();
		mv.addObject("answerlevelMap", answerlevelMap);
		mv.addObject("msg", "save");
		mv.addObject("pd", pd);
		return mv;
	}	
	
	 /**去修改页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goEdit")
	public ModelAndView goEdit()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = answerService.findById(pd);	//根据ID读取
		mv.setViewName("backend/answer/answer_edit");
		List<PageData> typhoonList=typhoonService.listAll(pd);
		mv.addObject("typhoonMap", typhoonList);
		Map<String, String> answerlevelMap=WebConstant.getAnswerLevelMap();
		mv.addObject("answerlevelMap", answerlevelMap);
		mv.addObject("msg", "edit");
		mv.addObject("pd", pd);
		return mv;
	}	
	
	 /**批量删除
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteAll")
	@ResponseBody
	public Object deleteAll() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"批量删除Answer");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			answerService.deleteAll(ArrayDATA_IDS);
			pd.put("msg", "ok");
		}else{
			pd.put("msg", "no");
		}
		pdList.add(pd);
		map.put("list", pdList);
		return AppUtil.returnObject(pd, map);
	}
	
	 /**导出到excel
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/excel")
	public ModelAndView exportExcel() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"导出Answer到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("应急响应ID");	//1
		titles.add("台风ID");	//2
		titles.add("应急响应级别");	//3
		titles.add("应急响应单位");	//4
		titles.add("应急响应备注");	//5
		titles.add("排序");	//6
		titles.add("删除标志");	//7
		titles.add("创建人");	//8
		titles.add("创建时间");	//9
		titles.add("修改人");	//10
		titles.add("修改时间");	//11
		dataMap.put("titles", titles);
		List<PageData> varOList = answerService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("ANSWER_ID"));	    //1
			vpd.put("var2", varOList.get(i).getString("TYPHOON_ID"));	    //2
			vpd.put("var3", varOList.get(i).getString("ANSWER_LEVEL"));	    //3
			vpd.put("var4", varOList.get(i).getString("ANSWER_COMPANY"));	    //4
			vpd.put("var5", varOList.get(i).getString("ANSWER_REMARK"));	    //5
			vpd.put("var6", varOList.get(i).get("SORT").toString());	//6
			vpd.put("var7", varOList.get(i).get("ISDEL").toString());	//7
			vpd.put("var8", varOList.get(i).getString("CREATER"));	    //8
			vpd.put("var9", varOList.get(i).getString("CREATE_DATE"));	    //9
			vpd.put("var10", varOList.get(i).getString("MODIFYER"));	    //10
			vpd.put("var11", varOList.get(i).getString("MODIFY_DATE"));	    //11
			varList.add(vpd);
		}
		dataMap.put("varList", varList);
		ObjectExcelView erv = new ObjectExcelView();
		mv = new ModelAndView(erv,dataMap);
		return mv;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}
}
