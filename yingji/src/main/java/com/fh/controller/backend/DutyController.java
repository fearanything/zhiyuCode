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
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.util.AppUtil;
import com.fh.util.Const;
import com.fh.util.FileDownload;
import com.fh.util.FileUpload;
import com.fh.util.ObjectExcelView;
import com.fh.util.PageData;
import com.fh.util.PathUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.ObjectExcelRead;
import com.fh.util.Tools;
import com.hazelcast.util.StringUtil;
import com.fh.service.backend.duty.DutyManager;
import com.fh.service.backend.typhoon.TyphoonManager;

/** 
 * 说明：值班人员
 * 创建人：FH Q313596790
 * 创建时间：2022-09-20
 */
@Controller
@RequestMapping(value="/duty")
public class DutyController extends BaseController {
	
	String menuUrl = "duty/list.do"; //菜单地址(权限用)
	@Resource(name="dutyService")
	private DutyManager dutyService;
	@Resource(name="typhoonService")
	private TyphoonManager typhoonService;
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增Duty");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("DUTY_ID", this.get32UUID());	//主键
		
		pd.put("ISDEL", "0");	//删除标志
		String datestr=Tools.date2Str(new Date());
		pd.put("CREATER", Jurisdiction.getUserId());	//创建人
		pd.put("CREATE_DATE", datestr);	//创建时间
		pd.put("MODIFYER", Jurisdiction.getUserId());	//修改人
		pd.put("MODIFY_DATE", datestr);	//修改时间
		dutyService.save(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"删除Duty");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		dutyService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改Duty");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String datestr=Tools.date2Str(new Date());
		pd.put("MODIFYER", Jurisdiction.getUserId());	//修改人
		pd.put("MODIFY_DATE", datestr);	//修改时间
		dutyService.edit(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"列表Duty");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
		List<PageData>	varList = dutyService.list(page);	//列出Duty列表
		mv.setViewName("backend/duty/duty_list");
		List<PageData> typhoonList=typhoonService.listAll(pd);
		mv.addObject("typhoonMap", typhoonList);
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
		mv.setViewName("backend/duty/duty_edit");
		List<PageData> typhoonList=typhoonService.listAll(pd);
		mv.addObject("typhoonMap", typhoonList);
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
		pd = dutyService.findById(pd);	//根据ID读取
		mv.setViewName("backend/duty/duty_edit");
		List<PageData> typhoonList=typhoonService.listAll(pd);
		mv.addObject("typhoonMap", typhoonList);
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
		logBefore(logger, Jurisdiction.getUsername()+"批量删除Duty");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			dutyService.deleteAll(ArrayDATA_IDS);
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
		logBefore(logger, Jurisdiction.getUsername()+"导出Duty到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("事件名称");	//1
		titles.add("值班员姓名");	//2
		titles.add("联系方式");	//3
		titles.add("开始时间");	//4
		titles.add("结束时间");	//4
		titles.add("职位");	//5
		titles.add("单位");	//6
		titles.add("备注");	//7
		titles.add("排序");	//8
		
		dataMap.put("titles", titles);
		pd.put("limitStar", 0);
		pd.put("limitEnd", 2000);
		List<PageData> varOList = dutyService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			
			vpd.put("var1", varOList.get(i).getString("TYPHOON_NAME"));	    //2
			vpd.put("var2", varOList.get(i).getString("DUTY_NAME"));	    //3
			vpd.put("var3", varOList.get(i).getString("DUTY_TEL"));	    //4
			vpd.put("var4", varOList.get(i).getString("START_DATE"));	    //5
			vpd.put("var5", varOList.get(i).getString("END_DATE"));	    //5
			vpd.put("var6", varOList.get(i).getString("DUTY_JOB"));	    //5
			vpd.put("var7", varOList.get(i).getString("DUTY_CORP"));	    //5
			vpd.put("var8", varOList.get(i).getString("DUTY_REMARK"));	    //6
			vpd.put("var9", varOList.get(i).get("SORT").toString());	//7
			
			varList.add(vpd);
		}
		dataMap.put("varList", varList);
		ObjectExcelView erv = new ObjectExcelView();
		mv = new ModelAndView(erv,dataMap);
		return mv;
	}
	/**打开上传EXCEL页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/goUploadExcel")
	public ModelAndView goUploadExcel()throws Exception{
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("backend/duty/uploadexcel");
		return mv;
	}
	/**下载模版
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/downExcel")
	public void downExcel(HttpServletResponse response)throws Exception{
		FileDownload.fileDownload(response, PathUtil.getClasspath() + Const.FILEPATHFILE + "duty.xlsx", "duty.xlsx");
	}
	
	/**从EXCEL导入到数据库
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/readExcel")
	public ModelAndView readExcel(
			@RequestParam(value="excel",required=false) MultipartFile file
			) throws Exception{
	
		logBefore(logger, Jurisdiction.getUsername()+"从EXCEL导入到数据库");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;}
		if (null != file && !file.isEmpty()) {
			String filePath = PathUtil.getClasspath() + Const.FILEPATHFILE;								//文件上传路径
			String fileName =  FileUpload.fileUp(file, filePath, "userexcel");							//执行上传
			List<PageData> listPd = (List)ObjectExcelRead.readExcel(filePath, fileName, 1, 0, 0);		//执行读EXCEL操作,读出的数据导入List 2:从第3行开始；0:从第A列开始；0:第0个sheet
			/*存入数据库操作======================================*/
			String dateStr=Tools.date2Str(new Date());
			for(int i=0;i<listPd.size();i++){		
				pd.put("DUTY_ID", this.get32UUID());//ID
				String TYPHOON_NAME=listPd.get(i).getString("var0");//公台风名称
				pd.put("TYPHOON_NAME", TYPHOON_NAME);
				PageData TYPHOON=typhoonService.findByName(pd);
				String TYPHOON_ID="";
				if(TYPHOON!=null) {
					TYPHOON_ID=TYPHOON.getString("TYPHOON_ID");
				    pd.put("TYPHOON_ID", TYPHOON_ID);//公台风名称
					pd.put("DUTY_NAME", listPd.get(i).getString("var1"));//值班员姓名
					pd.put("DUTY_TEL", listPd.get(i).getString("var2"));//联系方式
					pd.put("START_DATE", listPd.get(i).getString("var3"));//开始时间
					pd.put("END_DATE", listPd.get(i).getString("var4"));//结束时间
					pd.put("DUTY_JOB", listPd.get(i).getString("var5"));//职位
					pd.put("DUTY_CORP", listPd.get(i).getString("var6"));//单位
					pd.put("DUTY_REMARK", listPd.get(i).getString("var7"));//备注
					pd.put("SORT", listPd.get(i).getString("var8"));//排序
		
					pd.put("ISDEL", "0");	//删除标志
					pd.put("CREATER", Jurisdiction.getUserId());	//创建人
					pd.put("CREATE_DATE", dateStr);	//创建时间
					pd.put("MODIFYER",Jurisdiction.getUserId());	//修改人
					pd.put("MODIFY_DATE",dateStr);	//修改时间
					
					dutyService.save(pd);
				}
				
			}
			/*存入数据库操作======================================*/
			mv.addObject("msg","success");
		}
		mv.setViewName("save_result");
		return mv;
	}
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}
}
