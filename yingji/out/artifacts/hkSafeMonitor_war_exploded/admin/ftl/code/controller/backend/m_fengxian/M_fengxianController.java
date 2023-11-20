package com.fh.controller.backend.m_fengxian;

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
import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.util.AppUtil;
import com.fh.util.ObjectExcelView;
import com.fh.util.PageData;
import com.fh.util.Jurisdiction;
import com.fh.util.Tools;
import com.fh.service.backend.m_fengxian.M_fengxianManager;

/** 
 * 说明：风险
 * 创建人：FH Q313596790
 * 创建时间：2023-09-28
 */
@Controller
@RequestMapping(value="/m_fengxian")
public class M_fengxianController extends BaseController {
	
	String menuUrl = "m_fengxian/list.do"; //菜单地址(权限用)
	@Resource(name="m_fengxianService")
	private M_fengxianManager m_fengxianService;
	
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增M_fengxian");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("M_FENGXIAN_ID", this.get32UUID());	//主键
		m_fengxianService.save(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"删除M_fengxian");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		m_fengxianService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改M_fengxian");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		m_fengxianService.edit(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"列表M_fengxian");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
		List<PageData>	varList = m_fengxianService.list(page);	//列出M_fengxian列表
		mv.setViewName("backend/m_fengxian/m_fengxian_list");
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
		mv.setViewName("backend/m_fengxian/m_fengxian_edit");
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
		pd = m_fengxianService.findById(pd);	//根据ID读取
		mv.setViewName("backend/m_fengxian/m_fengxian_edit");
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
		logBefore(logger, Jurisdiction.getUsername()+"批量删除M_fengxian");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			m_fengxianService.deleteAll(ArrayDATA_IDS);
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
		logBefore(logger, Jurisdiction.getUsername()+"导出M_fengxian到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("风险id");	//1
		titles.add("是否删除1删除0未删除");	//2
		titles.add("排序");	//3
		titles.add("创建人");	//4
		titles.add("创建时间");	//5
		titles.add("修改人");	//6
		titles.add("修改时间");	//7
		titles.add("二级公司");	//8
		titles.add("三级机构");	//9
		titles.add("地址");	//10
		titles.add("区域");	//11
		titles.add("危险源");	//12
		titles.add("可能导致的事故类型");	//13
		titles.add("风险等级");	//14
		titles.add("控制措施");	//15
		titles.add("应急措施");	//16
		titles.add("危险源持续时间");	//17
		titles.add("管理层级");	//18
		titles.add("责任单位(组织机构)");	//19
		titles.add("责任人");	//20
		titles.add("责任人联系方式");	//21
		titles.add("识别时间");	//22
		titles.add("持续周期");	//23
		dataMap.put("titles", titles);
		List<PageData> varOList = m_fengxianService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("FENGXIAN_ID"));	    //1
			vpd.put("var2", varOList.get(i).get("ISDEL").toString());	//2
			vpd.put("var3", varOList.get(i).get("SORT").toString());	//3
			vpd.put("var4", varOList.get(i).getString("CREATER"));	    //4
			vpd.put("var5", varOList.get(i).getString("CREATE_DATE"));	    //5
			vpd.put("var6", varOList.get(i).getString("MODIFYER"));	    //6
			vpd.put("var7", varOList.get(i).getString("MODIFY_DATE"));	    //7
			vpd.put("var8", varOList.get(i).getString("SECOND_UNIT"));	    //8
			vpd.put("var9", varOList.get(i).getString("THIRD_UNIT"));	    //9
			vpd.put("var10", varOList.get(i).getString("FENGXIAN_ADDRESS"));	    //10
			vpd.put("var11", varOList.get(i).getString("FENGXIAN_AREA"));	    //11
			vpd.put("var12", varOList.get(i).getString("FENGXIAN_HAZARD"));	    //12
			vpd.put("var13", varOList.get(i).getString("FENGXIAN_ACCIDENT_TYPE"));	    //13
			vpd.put("var14", varOList.get(i).getString("FENGXIAN_LEVEL"));	    //14
			vpd.put("var15", varOList.get(i).getString("CONTROL_MEASURE"));	    //15
			vpd.put("var16", varOList.get(i).getString("EMERGENCY_MEASURE"));	    //16
			vpd.put("var17", varOList.get(i).getString("HAZARD_DURATION"));	    //17
			vpd.put("var18", varOList.get(i).getString("MANAGEMENT_LEVEL"));	    //18
			vpd.put("var19", varOList.get(i).getString("RESPONSIBILITY_UNIT"));	    //19
			vpd.put("var20", varOList.get(i).getString("RESPONSIBILITY_PEOPLE"));	    //20
			vpd.put("var21", varOList.get(i).getString("RESPONSIBILITY_PHONE"));	    //21
			vpd.put("var22", varOList.get(i).getString("RECOGNITION_TIME"));	    //22
			vpd.put("var23", varOList.get(i).getString("DURANTION_CIRCLE"));	    //23
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
