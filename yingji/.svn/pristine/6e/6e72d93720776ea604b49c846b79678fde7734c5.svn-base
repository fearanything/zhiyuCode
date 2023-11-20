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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.util.AppUtil;
import com.fh.util.Const;
import com.fh.util.FileUpload;
import com.fh.util.ObjectExcelView;
import com.fh.util.PageData;
import com.fh.util.PathUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.Tools;
import com.fh.service.backend.file.FileManager;
import com.fh.service.backend.filetype.FiletypeManager;

/** 
 * 说明：文件管理
 * 创建人：FH Q313596790
 * 创建时间：2022-10-25
 */
@Controller
@RequestMapping(value="/file")
public class FileController extends BaseController {
	
	String menuUrl = "file/list.do"; //菜单地址(权限用)
	@Resource(name="fileService")
	private FileManager fileService;
	@Resource(name="filetypeService")
	private FiletypeManager filetypeService;
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save(
			@RequestParam(value="FILE_URL",required=false) String FILE_URL,
			@RequestParam(value="FILETYPE_ID",required=false) String FILETYPE_ID,
			@RequestParam(value="FILE_NAME",required=false) String FILE_NAME,
			@RequestParam(value="SORT",required=false) String SORT,
			@RequestParam(value="excel",required=false) MultipartFile file
			) throws Exception{
		
		logBefore(logger, Jurisdiction.getUsername()+"新增File");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		if (null != file && !file.isEmpty()) {
			String fileName1 =file.getOriginalFilename();
			String fileName2 = file.getOriginalFilename().substring(0,file.getOriginalFilename().lastIndexOf("."));
			String filePath = PathUtil.getClasspath() + Const.FILEPATHFILE;//文件上传路径								
		    FileUpload.fileUp(file, filePath, fileName2);//执行上传
			FILE_URL=Const.FILEPATHFILE+fileName1;
		}
		PageData pd = new PageData();
		//pd = this.getPageData();
		pd.put("FILE_ID", this.get32UUID());	//主键
		pd.put("FILETYPE_ID", FILETYPE_ID);//文件分类
		pd.put("FILE_NAME", FILE_NAME);//文件名称
		pd.put("FILE_URL", FILE_URL);//文件路径
		pd.put("SORT", SORT);//排序
		pd.put("ISDEL", "0");	//删除标志
		String datestr=Tools.date2Str(new Date());
		pd.put("CREATER", Jurisdiction.getUserId());	//创建人
		pd.put("CREATE_DATE", datestr);	//创建时间
		pd.put("MODIFYER", Jurisdiction.getUserId());	//修改人
		pd.put("MODIFY_DATE", datestr);	//修改时间
		fileService.save(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"删除File");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		fileService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit(
			@RequestParam(value="FILE_ID",required=false) String FILE_ID,
			@RequestParam(value="FILE_URL",required=false) String FILE_URL,
			@RequestParam(value="FILETYPE_ID",required=false) String FILETYPE_ID,
			@RequestParam(value="FILE_NAME",required=false) String FILE_NAME,
			@RequestParam(value="SORT",required=false) String SORT,
			@RequestParam(value="excel",required=false) MultipartFile file
			) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改File");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		if (null != file && !file.isEmpty()) {
			String fileName1 =file.getOriginalFilename();
			String fileName2 = file.getOriginalFilename().substring(0,file.getOriginalFilename().lastIndexOf("."));
			String filePath = PathUtil.getClasspath() + Const.FILEPATHFILE;//文件上传路径								
		    FileUpload.fileUp(file, filePath, fileName2);//执行上传
			FILE_URL=Const.FILEPATHFILE+fileName1;
		}
		PageData pd = new PageData();
		//pd = this.getPageData();
		pd.put("FILE_ID", FILE_ID);	//主键
		pd.put("FILETYPE_ID", FILETYPE_ID);//文件分类
		pd.put("FILE_NAME", FILE_NAME);//文件名称
		pd.put("FILE_URL", FILE_URL);//文件路径
		pd.put("SORT", SORT);//排序
		String datestr=Tools.date2Str(new Date());
		pd.put("MODIFYER", Jurisdiction.getUserId());	//修改人
		pd.put("MODIFY_DATE", datestr);	//修改时间
		fileService.edit(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"列表File");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
		List<PageData>	varList = fileService.list(page);	//列出File列表
		mv.setViewName("backend/file/file_list");
		List<PageData> filetypeList=filetypeService.listAll(pd);
		mv.addObject("filetypeMap", filetypeList);
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
		mv.setViewName("backend/file/file_edit");
		List<PageData> filetypeList=filetypeService.listAll(pd);
		mv.addObject("filetypeMap", filetypeList);
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
		pd = fileService.findById(pd);	//根据ID读取
		mv.setViewName("backend/file/file_edit");
		List<PageData> filetypeList=filetypeService.listAll(pd);
		mv.addObject("filetypeMap", filetypeList);
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
		logBefore(logger, Jurisdiction.getUsername()+"批量删除File");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			fileService.deleteAll(ArrayDATA_IDS);
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
		logBefore(logger, Jurisdiction.getUsername()+"导出File到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("文件ID");	//1
		titles.add("文件分类ID");	//2
		titles.add("文件名称");	//3
		titles.add("文件路径");	//4
		titles.add("排序");	//5
		titles.add("删除标志");	//6
		titles.add("创建人");	//7
		titles.add("创建时间");	//8
		titles.add("修改人");	//9
		titles.add("修改时间");	//10
		dataMap.put("titles", titles);
		List<PageData> varOList = fileService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("FILE_ID"));	    //1
			vpd.put("var2", varOList.get(i).getString("FILETYPE_ID"));	    //2
			vpd.put("var3", varOList.get(i).getString("FILE_NAME"));	    //3
			vpd.put("var4", varOList.get(i).getString("FILE_URL"));	    //4
			vpd.put("var5", varOList.get(i).get("SORT").toString());	//5
			vpd.put("var6", varOList.get(i).get("ISDEL").toString());	//6
			vpd.put("var7", varOList.get(i).getString("CREATER"));	    //7
			vpd.put("var8", varOList.get(i).getString("CREATE_DATE"));	    //8
			vpd.put("var9", varOList.get(i).getString("MODIFYER"));	    //9
			vpd.put("var10", varOList.get(i).getString("MODIFY_DATE"));	    //10
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
