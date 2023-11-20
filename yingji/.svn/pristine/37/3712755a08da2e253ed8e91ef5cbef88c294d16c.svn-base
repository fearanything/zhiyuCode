package com.fh.service.backend.typhoon.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;
import com.fh.service.backend.typhoon.TyphoonManager;

/** 
 * 说明： 台风信息
 * 创建人：FH Q313596790
 * 创建时间：2022-09-19
 * @version
 */
@Service("typhoonService")
public class TyphoonService implements TyphoonManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception{
		dao.save("TyphoonMapper.save", pd);
	}
	/**更新台风状态为不是当前
	 * @param pd
	 * @throws Exception
	 */
	public void updatestatic(PageData pd)throws Exception{
		dao.delete("TyphoonMapper.updatestatic", pd);
	}
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception{
		dao.delete("TyphoonMapper.delete", pd);
	}
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception{
		dao.update("TyphoonMapper.edit", pd);
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("TyphoonMapper.datalistPage", page);
	}
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("TyphoonMapper.listAll", pd);
	}
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("TyphoonMapper.findById", pd);
	}
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findByName(PageData pd)throws Exception{
		return (PageData)dao.findForObject("TyphoonMapper.findByName", pd);
	}
	/**获取当前台风
	 * @param pd
	 * @throws Exception
	 */
	public PageData findByNow(PageData pd)throws Exception{
		return (PageData)dao.findForObject("TyphoonMapper.findByNow", pd);
	}
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("TyphoonMapper.deleteAll", ArrayDATA_IDS);
	}
	
}

