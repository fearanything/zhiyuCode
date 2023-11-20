package com.fh.service.backend.m_monitor_project.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;
import com.fh.service.backend.m_monitor_project.M_monitor_projectManager;

/** 
 * 说明： 监控和项目关联
 * 创建人：FH Q313596790
 * 创建时间：2023-10-27
 * @version
 */
@Service("m_monitor_projectService")
public class M_monitor_projectService implements M_monitor_projectManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception{
		dao.save("M_monitor_projectMapper.save", pd);
	}
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception{
		dao.delete("M_monitor_projectMapper.delete", pd);
	}
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception{
		dao.update("M_monitor_projectMapper.edit", pd);
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("M_monitor_projectMapper.datalistPage", page);
	}
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("M_monitor_projectMapper.listAll", pd);
	}

	/**监控名字，id
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listForName(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("M_monitor_projectMapper.listForName", pd);
	}

	/**根据项目id删除
	 * @param pd
	 * @throws Exception
	 */
	public void deleteByProject(PageData pd)throws Exception{
		dao.delete("M_monitor_projectMapper.deleteByProject", pd);
	}

	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("M_monitor_projectMapper.findById", pd);
	}
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("M_monitor_projectMapper.deleteAll", ArrayDATA_IDS);
	}
	
}

