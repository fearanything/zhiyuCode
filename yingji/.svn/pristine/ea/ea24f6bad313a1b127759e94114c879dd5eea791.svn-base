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
import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.util.AppUtil;
import com.fh.util.ObjectExcelView;
import com.fh.util.PageData;
import com.fh.util.Jurisdiction;
import com.fh.util.Tools;
import com.fh.service.backend.city.CityManager;
import com.fh.service.backend.project.ProjectManager;
import com.fh.service.backend.projectType.ProjectTypeManager;

/** 
 * 说明：工程项目
 * 创建人：FH Q313596790
 * 创建时间：2023-01-06
 */
@Controller
@RequestMapping(value="/project")
public class ProjectController extends BaseController {
	
	String menuUrl = "project/list.do"; //菜单地址(权限用)
	@Resource(name="projectService")
	private ProjectManager projectService;
	@Resource(name="projectTypeService")
	private ProjectTypeManager projectTypeService;
	@Resource(name="cityService")
	private CityManager cityService;
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增Project");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("PROJECT_ID", this.get32UUID());	//主键
		
		pd.put("SORT", "0");	//排序
		pd.put("ISDEL", "0");	//删除标志
		String datestr=Tools.date2Str(new Date());
		pd.put("CREATER", Jurisdiction.getUserId());	//创建人
		pd.put("CREATE_DATE", datestr);	//创建时间
		pd.put("MODIFYER", Jurisdiction.getUserId());	//修改人
		pd.put("MODIFY_DATE", datestr);	//修改时间
		projectService.save(pd);
		updateCount(pd.getString("PROJECTTYPE_ID"));//更新数量
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	public void updateCount(String PROJECTTYPE_ID) {
		try 
		{
			PageData pd = new PageData();
			pd.put("PROJECTTYPE_ID", PROJECTTYPE_ID);
			List<PageData> pdList=projectService.listAll(pd);
			if(pdList!=null) {
				pd.put("PROJECTTYPE_NUM", pdList.size());
				projectTypeService.editCount(pd);
			}
		}catch(Exception ex) {
			
		}
		
		
	}
	/**删除
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value="/delete")
	public void delete(PrintWriter out) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"删除Project");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		PageData pdProject =projectService.findById(pd);
		String PROJECTTYPE_ID="";
		if(pdProject!=null) {
			PROJECTTYPE_ID=pdProject.getString("PROJECTTYPE_ID");
		}
		projectService.delete(pd);
		updateCount(PROJECTTYPE_ID);//更新数量
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改Project");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String datestr=Tools.date2Str(new Date());
		pd.put("MODIFYER", Jurisdiction.getUserId());	//修改人
		pd.put("MODIFY_DATE", datestr);	//修改时间
		projectService.edit(pd);
		updateCount(pd.getString("PROJECTTYPE_ID"));//更新数量
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
		logBefore(logger, Jurisdiction.getUsername()+"列表Project");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
		List<PageData>	varList = projectService.list(page);	//列出Project列表
		List<PageData> projectTypeList=projectTypeService.listAll(pd);
		mv.addObject("projectTypeMap", projectTypeList);
		List<PageData> cityList=cityService.listAll(pd);
		mv.addObject("cityMap", cityList);
		mv.setViewName("backend/project/project_list");
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
		List<PageData> projectTypeList=projectTypeService.listAll(pd);
		mv.addObject("projectTypeMap", projectTypeList);
		List<PageData> cityList=cityService.listAll(pd);
		mv.addObject("cityMap", cityList);
		mv.setViewName("backend/project/project_edit");
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
		pd = projectService.findById(pd);	//根据ID读取
		List<PageData> projectTypeList=projectTypeService.listAll(pd);
		mv.addObject("projectTypeMap", projectTypeList);
		List<PageData> cityList=cityService.listAll(pd);
		mv.addObject("cityMap", cityList);
		mv.setViewName("backend/project/project_edit");
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
		logBefore(logger, Jurisdiction.getUsername()+"批量删除Project");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			projectService.deleteAll(ArrayDATA_IDS);
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
		logBefore(logger, Jurisdiction.getUsername()+"导出Project到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("项目分类");	//2
		titles.add("所在城市");	//2
		titles.add("工程项目名称");	//3
		titles.add("工程项目描述");	//4
		titles.add("排序");	//5
		
		dataMap.put("titles", titles);
		List<PageData> varOList = projectService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("PROJECTTYPE_NAME"));	    //2
			vpd.put("var2", varOList.get(i).getString("CITY_NAME"));	    //2
			vpd.put("var3", varOList.get(i).getString("PROJECT_NAME"));	    //3
			vpd.put("var4", varOList.get(i).getString("PROJECT_REMARK"));	    //4
			vpd.put("var5", varOList.get(i).get("SORT").toString());	//5
			
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
