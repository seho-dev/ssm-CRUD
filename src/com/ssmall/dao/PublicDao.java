package com.ssmall.dao;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.ssmall.pojo.Userpojo;

public interface PublicDao {
	public PageInfo<Userpojo> getAll(Integer index);
	public Userpojo get(int id);
	public boolean deleteById(Integer id);
	public boolean addUser(Userpojo user);
	public boolean updateUser(Userpojo user);
}
