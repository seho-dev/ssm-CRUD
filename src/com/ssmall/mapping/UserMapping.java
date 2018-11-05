package com.ssmall.mapping;

import java.util.List;

import com.ssmall.pojo.Userpojo;

public interface UserMapping {
	public List<Userpojo> getAll();
	public Userpojo getUser(Integer id);
	public boolean deleteById(Integer id);
	public boolean add(Userpojo user);
	public boolean update(Userpojo user);
}