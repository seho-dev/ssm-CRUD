package com.ssmall.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ssmall.pojo.Userpojo;

public interface UserService {
		//根据ID查询
		public Userpojo get(Integer id);
		//查询全部
		public PageInfo<Userpojo> getAll(Integer pageNum);
		//根据id删除
		public boolean deleteById(Integer id);
		//添加用户
		public boolean addUser(Userpojo user);
		//修改用户
		public boolean updateUser(Userpojo user);
}
