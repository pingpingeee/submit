package com.lgy.item_jdbc_oracle.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lgy.item_jdbc_oracle.dao.ItemDAO;
import com.lgy.item_jdbc_oracle.dto.ItemDTO;

public class ItemContentService implements ItemService {

	@Override
	public void execute(Model model) {
		ItemDAO dao = new ItemDAO();
		ArrayList<ItemDTO> dtos = dao.contentView();
		model.addAttribute("contentView", dtos);
	}

}
