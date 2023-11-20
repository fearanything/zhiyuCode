package com.fh.service.backend.answer.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;
import com.fh.service.backend.answer.AnswerManager;

/** 
 * 说明： 应急响应
 * 创建人：FH Q313596790
 * 创建时间：2022-09-21
 * @version
 */
@Service("answerService")
public class AnswerService implements AnswerManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception{
		dao.save("AnswerMapper.save", pd);
	}
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception{
		dao.delete("AnswerMapper.delete", pd);
	}
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception{
		dao.update("AnswerMapper.edit", pd);
	}
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit2(PageData pd)throws Exception{
		dao.update("AnswerMapper.edit2", pd);
	}
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("AnswerMapper.datalistPage", page);
	}
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("AnswerMapper.listAll", pd);
	}
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("AnswerMapper.findById", pd);
	}
	/**通过单位名称取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findByName(PageData pd)throws Exception{
		return (PageData)dao.findForObject("AnswerMapper.findByName", pd);
	}
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("AnswerMapper.deleteAll", ArrayDATA_IDS);
	}
	
}

