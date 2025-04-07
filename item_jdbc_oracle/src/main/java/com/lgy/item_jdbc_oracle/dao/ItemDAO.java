package com.lgy.item_jdbc_oracle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.lgy.item_jdbc_oracle.dto.ItemDTO;
import com.lgy.item_jdbc_oracle.util.Constant;

public class ItemDAO {
	JdbcTemplate template = null;

	public ItemDAO() {
		template = Constant.template;
	}

	public void write(final String name, final String price, final String description) {
		System.out.println("test DAO1");
		template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "insert into tbl_item (name, price, description) values(?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, price);
				pstmt.setString(3, description);
				return pstmt;
			}
		});
	}

	public ArrayList<ItemDTO> contentView() {
		System.out.println("test DAO");
		String sql="select name, price, description from tbl_item";
		return (ArrayList<ItemDTO>) template.query(sql, new BeanPropertyRowMapper(ItemDTO.class));
//		return (ArrayList<ItemDTO>) template.query("select name, price, description from tbl_item", new BeanPropertyRowMapper(ItemDTO.class));
	}
}
