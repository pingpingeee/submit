package com.lgy.item_std_oracle.service;

import java.util.ArrayList;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lgy.item_std_oracle.dao.ItemDAO;
import com.lgy.item_std_oracle.dto.ItemDTO;

@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void write(HashMap<String, String> param) {
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		dao.write(param);
	}

	@Override
	public ArrayList<ItemDTO> list() {
		ItemDAO dao = sqlSession.getMapper(ItemDAO.class);
		ArrayList<ItemDTO> list = dao.list();
		return list;
	}

}
