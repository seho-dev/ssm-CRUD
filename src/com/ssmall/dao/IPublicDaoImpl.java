package com.ssmall.dao;

import java.util.List;

import javax.annotation.Resource;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssmall.mapping.UserMapping;
import com.ssmall.pojo.Userpojo;

@Repository
public class IPublicDaoImpl extends SqlSessionDaoSupport implements PublicDao{
	
	/*super.setSqlSessionFactory(sessionFactory)：调用父类方法，将sqlsessionfactory注入进去*/
    @Resource
    public void setSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
    
    /**
     * 公共dao层方法
     */
	public Userpojo get(int id) {
		
		UserMapping mapper = this.getSqlSession().getMapper(UserMapping.class);
		Userpojo user = mapper.getUser(id);
		return user;
	}


	//查询数量
	public static final int PAGE_SHOW_NUMBER=5;
	@Override
	public PageInfo<Userpojo> getAll(Integer index) {
		UserMapping mapper = this.getSqlSession().getMapper(UserMapping.class);
		PageHelper.startPage(index, PAGE_SHOW_NUMBER);
		List<Userpojo> all =mapper.getAll();
		//用PageInfo对结果进行包装
		PageInfo<Userpojo> pageInfo = new PageInfo<Userpojo>(all);
		return pageInfo;
	}
	
	//查询数据的总页数
	

	@Override
	public boolean deleteById(Integer id) {
		UserMapping mapper = this.getSqlSession().getMapper(UserMapping.class);
		return mapper.deleteById(id);
	}

	@Override
	public boolean addUser(Userpojo user) {
		UserMapping mapper = this.getSqlSession().getMapper(UserMapping.class);
		return mapper.add(user);
	}

	@Override
	public boolean updateUser(Userpojo user) {
		UserMapping mapper = this.getSqlSession().getMapper(UserMapping.class);
		return mapper.update(user);
	}
	
}
