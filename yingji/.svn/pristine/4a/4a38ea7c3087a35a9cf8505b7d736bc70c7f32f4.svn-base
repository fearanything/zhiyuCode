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
import com.fh.service.backend.typhoon.TyphoonManager;

/** 
 * 说明：台风信息
 * 创建人：FH Q313596790
 * 创建时间：2022-09-19
 */
@Controller
@RequestMapping(value="/typhoon")
public class TyphoonController extends BaseController {
	
	String menuUrl = "typhoon/list.do"; //菜单地址(权限用)
	@Resource(name="typhoonService")
	private TyphoonManager typhoonService;
	
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增Typhoon");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("TYPHOON_ID", this.get32UUID());	//主键
		pd.put("SORT", "0");	//排序
		pd.put("ISDEL", "0");	//删除标志
		String datestr=Tools.date2Str(new Date());
		pd.put("CREATER", Jurisdiction.getUserId());	//创建人
		pd.put("CREATE_DATE", datestr);	//创建时间
		pd.put("MODIFYER", Jurisdiction.getUserId());	//修改人
		pd.put("MODIFY_DATE", datestr);	//修改时间
		//如果是当前台风，更新以前的台风为不是当前
		if(pd.getString("IS_NOW").equals(WebConstant.IS_NOW)) {
			typhoonService.updatestatic(pd);
		}
		typhoonService.save(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"删除Typhoon");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		typhoonService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改Typhoon");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String datestr=Tools.date2Str(new Date());
		pd.put("MODIFYER", Jurisdiction.getUserId());	//修改人
		pd.put("MODIFY_DATE", datestr);	//修改时间
		//如果是当前台风，更新以前的台风为不是当前
		if(pd.getString("IS_NOW").equals(WebConstant.IS_NOW)) {
			typhoonService.updatestatic(pd);
		}
		typhoonService.edit(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"列表Typhoon");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
		List<PageData>	varList = typhoonService.list(page);	//列出Typhoon列表
		mv.setViewName("backend/typhoon/typhoon_list");
		Map<String, String> staticMap=WebConstant.getStaticMap();
		mv.addObject("staticMap", staticMap);
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
		mv.setViewName("backend/typhoon/typhoon_edit");
		Map<String, String> staticMap=WebConstant.getStaticMap();
		mv.addObject("staticMap", staticMap);
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
		pd = typhoonService.findById(pd);	//根据ID读取
		mv.setViewName("backend/typhoon/typhoon_edit");
		Map<String, String> staticMap=WebConstant.getStaticMap();
		mv.addObject("staticMap", staticMap);
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
		logBefore(logger, Jurisdiction.getUsername()+"批量删除Typhoon");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			typhoonService.deleteAll(ArrayDATA_IDS);
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
		logBefore(logger, Jurisdiction.getUsername()+"导出Typhoon到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("台风ID");	//1
		titles.add("台风年份");	//2
		titles.add("台风号");	//3
		titles.add("台风名称");	//4
		titles.add("台风描述");	//5
		titles.add("排序");	//6
		titles.add("删除标志");	//7
		titles.add("创建人");	//8
		titles.add("创建时间");	//9
		titles.add("修改人");	//10
		titles.add("修改时间");	//11
		dataMap.put("titles", titles);
		List<PageData> varOList = typhoonService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("TYPHOON_ID"));	    //1
			vpd.put("var2", varOList.get(i).getString("TYPHOON_YEAR"));	    //2
			vpd.put("var3", varOList.get(i).getString("TYPHOON_NO"));	    //3
			vpd.put("var4", varOList.get(i).getString("TYPHOON_NAME"));	    //4
			vpd.put("var5", varOList.get(i).getString("TYPHOON_REMARK"));	    //5
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
