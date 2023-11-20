package com.fh.service.backend.userorg.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.service.backend.userorg.UserOrgManager;
import com.fh.util.PageData;

/** 
 * 说明： 用户组织权限
 * 创建人：FH Q313596790
 * 创建时间：2023-07-04
 * @version
 */
@Service("userorgService")
public class UserOrgService implements UserOrgManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception{
		dao.save("UserOrgMapper.save", pd);
	}
	
	/**批量新增
	 * @param pd
	 * @throws Exception
	 */
	public void batchSave(List<PageData> list)throws Exception{
		dao.save("UserOrgMapper.batchSave", list);
	}
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception{
		dao.delete("UserOrgMapper.delete", pd);
	}
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void deleteOrg(PageData pd)throws Exception{
		dao.delete("UserOrgMapper.deleteOrg", pd);
	}
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception{
		dao.update("UserOrgMapper.edit", pd);
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("UserOrgMapper.datalistPage", page);
	}
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("UserOrgMapper.listAll", pd);
	}
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("UserOrgMapper.findById", pd);
	}
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("UserOrgMapper.deleteAll", ArrayDATA_IDS);
	}
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteNotIn(PageData pd)throws Exception{
		dao.delete("UserOrgMapper.deleteNotIn", pd);
	}
	
}

