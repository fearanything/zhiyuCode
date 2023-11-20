package com.fh.service.system.dictionaries.impl;

import java.util.*;

import javax.annotation.Resource;

import com.fh.entity.backend.MOrg;
import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.entity.system.Dictionaries;
import com.fh.service.system.dictionaries.DictionariesManager;
import com.fh.util.PageData;

/** 
 * 说明： 数据字典
 * 创建人：FH Q313596790
 * 创建时间：2015-12-16
 * @version
 */
@Service("dictionariesService")
public class DictionariesService implements DictionariesManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception{
		dao.save("DictionariesMapper.save", pd);
	}
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception{
		dao.delete("DictionariesMapper.delete", pd);
	}
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception{
		dao.update("DictionariesMapper.edit", pd);
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("DictionariesMapper.datalistPage", page);
	}
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("DictionariesMapper.findById", pd);
	}
	
	/**通过编码获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findByBianma(PageData pd)throws Exception{
		return (PageData)dao.findForObject("DictionariesMapper.findByBianma", pd);
	}

	/**通过名字获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findByName(PageData pd)throws Exception{
		return (PageData)dao.findForObject("DictionariesMapper.findByName", pd);
	}
	
	/**
	 * 通过ID获取其子级列表
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Dictionaries> listSubDictByParentId(String parentId) throws Exception {
		return (List<Dictionaries>) dao.findForList("DictionariesMapper.listSubDictByParentId", parentId);
	}

	/**
	 * 通过ID获取其子级列表
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listSubDictByParentIdPd(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("DictionariesMapper.listSubDictByParentIdPd", pd);
	}
	
	/**
	 * 获取所有数据并填充每条数据的子级列表(递归处理)
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public List<Dictionaries> listAllDict(String parentId) throws Exception {
		List<Dictionaries> dictList = this.listSubDictByParentId(parentId);
		for(Dictionaries dict : dictList){
			dict.setTreeurl("dictionaries/list.do?DICTIONARIES_ID="+dict.getDICTIONARIES_ID());
			dict.setSubDict(this.listAllDict(dict.getDICTIONARIES_ID()));
			dict.setTarget("treeFrame");
		}
		return dictList;
	}
	
	/**列表(全部，用于生成ID下拉树结构) 
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Dictionaries> listAllForIdSelectTree(String parentId)throws Exception{
		PageData listoldPd = getParentPageData();
		
		return listAllMakeIdSelectTree(parentId, listoldPd);
	}
	
	/**
	 * 一次拿出全部数据，整合到pd中，按PARENT_ID分类，key：PARENT_ID   value：List
	 * @return
	 * @throws Exception
	 */
	public PageData getParentPageData() throws Exception {
		List<Dictionaries> dictList = listAllByBean();
		PageData listoldPd = new PageData(); // key：PARENT_ID   value：List
		for (Dictionaries dict : dictList) {
			String PARENT_ID = dict.getPARENT_ID();
			List<Dictionaries> newList = new ArrayList<>();
			if (listoldPd.get(PARENT_ID) != null) {
				newList = (List<Dictionaries>)listoldPd.get(PARENT_ID);
			}
			newList.add(dict);
			listoldPd.put(PARENT_ID, newList);
		}
		
		return listoldPd;
	}
	/**
	 * 递归生成树
	 * @param parentId
	 * @param data
	 * @return
	 */
	public List<Dictionaries> listAllMakeIdSelectTree(String parentId, PageData data) {
		List<Dictionaries> list = getChildrenFromData(parentId, data);
		List<Dictionaries> nextAll = new LinkedList<>();
		for (Dictionaries dict : list) {
			List<Dictionaries> next = this.listAllMakeIdSelectTree(dict.getDICTIONARIES_ID(), data);
//			dict.setSubDict(next);
			nextAll.addAll(next);
			dict.setTreeurl("dictionaries/list.do?DICTIONARIES_ID="+dict.getDICTIONARIES_ID());
			dict.setTarget("treeFrame");
		}
		list.addAll(nextAll);
		return list;
	}
	/**
	 * 用parentId从pd中获取数据
	 * @param parentId
	 * @param data
	 * @return
	 */
	public List<Dictionaries> getChildrenFromData(String parentId, PageData data) {
		List<Dictionaries> list = new ArrayList<>();
		if (data.get(parentId) != null) {
			list = (List<Dictionaries>)data.get(parentId);
		}
		return list;
	}

	/**
	 * 获取所有数据并填充每条数据的子级列表(递归处理)
	 * @param MENU_ID
	 * @return
	 * @throws Exception
	 */
	public List<PageData> listSelectTree(PageData pd) throws Exception {
		List <PageData> rList = new ArrayList<PageData>();

		List<PageData> valueList = this.listSubDictByParentIdPd(pd);
		for(PageData fhentity : valueList){
			PageData paramPd = new PageData();
			paramPd.putAll(pd);
			paramPd.put("PARENT_ID", fhentity.getString("DICTIONARIES_ID"));

			PageData aData = new PageData();
			aData.put("name", fhentity.getString("NAME"));
			aData.put("id", fhentity.getString("DICTIONARIES_ID"));
			aData.put("parentId", fhentity.getString("PARENT_ID"));
			rList.add(aData);
			List<PageData> next = this.listSelectTree(paramPd);
			rList.addAll(next);
		}
		return rList;
	}
	
	/**
	 * 获取全部数据，返回实体类List
	 * @return
	 * @throws Exception
	 */
	public List<Dictionaries> listAllByBean() throws Exception {
		return (List<Dictionaries>) dao.findForList("DictionariesMapper.listAllByBean", null);
	}
	
	/**
	 * 通过英文名称获取下级
	 * @return
	 * @throws Exception
	 */
	public Map<String, String> listChildrenByEN(String NAME_EN, boolean isBianmaKey) throws Exception {
		List<PageData> list = (List<PageData>) dao.findForList("DictionariesMapper.listChildrenByEN", NAME_EN);
		
		Map<String, String> map = new LinkedHashMap<>();
		for (PageData data : list) {
			if (isBianmaKey) {
				map.put(data.getString("BIANMA"), data.getString("NAME"));
			} else {
				map.put(data.getString("NAME"), data.getString("BIANMA"));
			}
		}
		
		return map;
	}
	
	/**排查表检查是否被占用
	 * @param pd
	 * @throws Exception
	 */
	public PageData findFromTbs(PageData pd)throws Exception{
		return (PageData)dao.findForObject("DictionariesMapper.findFromTbs", pd);
	}
	
}

