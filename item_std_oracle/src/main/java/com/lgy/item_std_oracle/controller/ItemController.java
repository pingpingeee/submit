package com.lgy.item_std_oracle.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lgy.item_std_oracle.dao.ItemDAO;
import com.lgy.item_std_oracle.dto.ItemDTO;
import com.lgy.item_std_oracle.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService service;
	
	// 아이템뷰 (값 읽어들임)
	@RequestMapping("/content_view")
	public String content_view(Model model) {
		ArrayList<ItemDTO> list = service.list();
		model.addAttribute("content_view", service.list());
		return "content_view";
	}

	// 작성 뷰
	@RequestMapping("/item_write")
	public String write_view() {
		return "item_write";
	}

	// wrtie 로직
	@RequestMapping("/item_write_ok")
		public String write(@RequestParam HashMap<String, String> param) {
		service.write(param);

		return "write_result";
	}
	
	// write_result
	@RequestMapping("/write_result")
	public String write_result() {
		return "write_result";
	}

}
