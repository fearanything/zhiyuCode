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
import com.fh.service.backend.Employee.EmployeeManager;
import com.fh.service.backend.mdepartment.MdepartmentManager;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.ObjectExcelView;
import com.fh.util.PageData;
import com.fh.util.Tools;

/** 
 * 说明：项目人员
 * 创建人：FH Q313596790
 * 创建时间：2022-03-25
 */
@Controller
@RequestMapping(value="/employee")
public class EmployeeController extends BaseController {
	
	String menuUrl = "employee/list.do"; //菜单地址(权限用)
	@Resource(name="employeeService")
	private EmployeeManager employeeService;
	@Resource(name="mdepartmentService")
	private MdepartmentManager mdepartmentService;
	
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增Employee");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("EMPLOYEE_ID", this.get32UUID());	//主键
		pd.put("SORT", "0");	//顺序
		pd.put("ISDEL", "0");	//删除标志
		pd.put("CREATER", Jurisdiction.getUserId());	//创建人
		pd.put("CREATE_DATE", Tools.date2Str(new Date()));	//创建时间
		employeeService.save(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"删除Employee");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("MODIFYER", Jurisdiction.getUserId());	//修改人
		pd.put("MODIFY_DATE", Tools.date2Str(new Date()));	//修改时间
		employeeService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改Employee");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("MODIFYER", Jurisdiction.getUserId());	//修改人
		pd.put("MODIFY_DATE", Tools.date2Str(new Date()));	//修改时间
		employeeService.edit(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"列表Employee");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
		List<PageData>	varList = employeeService.list(page);	//列出Employee列表
		mv.setViewName("backend/employee/employee_list");
		mv.addObject("varList", varList);
		mv.addObject("pd", pd);
		mv.addObject("departmentList", mdepartmentService.listAll(null));
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
		mv.setViewName("backend/employee/employee_edit");
		mv.addObject("msg", "save");
		mv.addObject("pd", pd);
		mv.addObject("departmentList", mdepartmentService.listAll(null));
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
		pd = employeeService.findById(pd);	//根据ID读取
		mv.setViewName("backend/employee/employee_edit");
		mv.addObject("msg", "edit");
		mv.addObject("pd", pd);
		mv.addObject("departmentList", mdepartmentService.listAll(null));
		return mv;
	}	
	
	 /**批量删除
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteAll")
	@ResponseBody
	public Object deleteAll() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"批量删除Employee");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			pd.put("array", ArrayDATA_IDS);
			pd.put("MODIFYER", Jurisdiction.getUserId());	//修改人
			pd.put("MODIFY_DATE", Tools.date2Str(new Date()));	//修改时间
			employeeService.deleteAll(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"导出Employee到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("项目人员ID");	//1
		titles.add("部门");	//2
		titles.add("顺序");	//3
		titles.add("删除标志");	//4
		titles.add("创建人");	//5
		titles.add("创建时间");	//6
		titles.add("修改人");	//7
		titles.add("修改时间");	//8
		titles.add("姓名");	//9
		titles.add("职位");	//10
		titles.add("手机号");	//11
		dataMap.put("titles", titles);
		List<PageData> varOList = employeeService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("EMPLOYEE_ID"));	    //1
			vpd.put("var2", varOList.get(i).getString("DEPARTMENT_ID"));	    //2
			vpd.put("var3", varOList.get(i).get("SORT").toString());	//3
			vpd.put("var4", varOList.get(i).get("ISDEL").toString());	//4
			vpd.put("var5", varOList.get(i).getString("CREATER"));	    //5
			vpd.put("var6", varOList.get(i).getString("CREATE_DATE"));	    //6
			vpd.put("var7", varOList.get(i).getString("MODIFYER"));	    //7
			vpd.put("var8", varOList.get(i).getString("MODIFY_DATE"));	    //8
			vpd.put("var9", varOList.get(i).getString("EMPLOYEE_NAME"));	    //9
			vpd.put("var10", varOList.get(i).getString("EMPLOYEE_JOB"));	    //10
			vpd.put("var11", varOList.get(i).getString("EMPLOYEE_TEL"));	    //11
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
