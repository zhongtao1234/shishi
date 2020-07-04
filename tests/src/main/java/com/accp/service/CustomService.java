package com.accp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.CustomMapper;
import com.accp.dao.CustomaddressMapper;
import com.accp.domain.Custom;
import com.accp.domain.Customaddress;
import com.accp.domain.CustomaddressExample;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class CustomService {
	@Autowired
	CustomMapper mapper;
	@Autowired
	CustomaddressMapper mapper2;
	
	public Custom find(){
		List<Custom> list=mapper.findADesc();
		for (Custom custom : list) {
			Customaddress detail=mapper2.selectByPrimaryKey(custom.getId());
			custom.setDetail(detail);;
		}
		return  list.get(0);
	}
	
	
	public  Custom	findBybillno(int billno) {
		Custom tabill=mapper.selectByPrimaryKey(billno);
		CustomaddressExample example=new CustomaddressExample();
		example.createCriteria().andIdEqualTo(billno);
		 List<Customaddress> detail=mapper2.selectByExample(example);
		 tabill.setDetails(detail);
		return tabill;
	}
	
	public int insert(Custom list) {
		int i=mapper.insert(list);
		list.getDetail().setId(list.getId());
		int j=mapper2.insert(list.getDetail());
		if (i>0&&j>0) {
			return 1;
		}
		return 0;
	}
	
	public int inserts(Custom list) {
		try {
			int i=mapper.insert(list);
			int j=0;
			if (i>0) {
				for (Customaddress detail : list.getDetails()) {
					detail.setId(list.getId());
					 j=mapper2.insert(detail);
				}
			}
			return j;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int insertsAndRemoves(Custom tabill) {
		List<Custom> list=mapper.selectByExample(null);
		int i=0;
		for (Custom bill : list) {
			if (tabill.getId().equals(bill.getId())) {
				 i=mapper.deleteByPrimaryKey(tabill.getId());
				if (i>0) {
					for (Customaddress detail : tabill.getDetails()) {
						int j=mapper2.deleteByPrimaryKey(detail.getId());
					}
				}
				inserts(tabill);
			}
		}
		if (i==0) {
			inserts(tabill);
		}
		return i;
	}
	
	public int remove(int billno) {
		int i=mapper.deleteByPrimaryKey(billno);
		int j=mapper2.deleteByPrimaryKey(billno);
		if (i>0&&j>0) {
			return 2;
		}
		return 0;
	}
}


