package com.ssmall.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.ssmall.pojo.Userpojo;
import com.ssmall.service.UserService;

@Controller
public class UserAction {
	@Resource
	private UserService userService;

	/**
	 * 查询所有信息
	 * 
	 * @param null
	 * @return
	 */
	@RequestMapping("/user/all/{index}")
	public ModelAndView getUserAll(@PathVariable("index") Integer index) {
		ModelAndView model = new ModelAndView("list");
		PageInfo<Userpojo> all = userService.getAll(index);
		List<Userpojo> list = all.getList();
		model.addObject("allList", list);
		//存储当前索引在域中
		model.addObject("index", index);
		//计算能分多少页
		int pages = all.getPages();
		model.addObject("lastnum", pages);
		return model;
	}

	/**
	 * 根据id查询单条信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/user/get/{id}")
	public String getUserById(@PathVariable("id") Integer id) {
		Userpojo userpojo = userService.get(id);
		return "success";
	}

	/**
	 * 根据id删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteById")
	public String DeleteById(@RequestParam("id") Integer id) {
		// 执行删除
		boolean deleteById = userService.deleteById(id);
		// 删除成功后查询
		return "redirect:/user/all/1";
	}

	/**
	 * 新增用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/user/addUser")
	public String addUser(Userpojo user) {
		userService.addUser(user);
		return "redirect:/user/all";
	}

	// 新增用户的跳转方法
	@RequestMapping("/user/addready")
	public String addReady(Model model) {
		model.addAttribute("itemForm", "form");
		// 添加用户之后，在请求域中添加一个判断添加或者修改页面的依据
		// 根据这个依据，可以通过jstl共用form.jsp页面
		return "form";
	}

	/**
	 * 修改用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/update")
	public String update(Userpojo user){
		userService.updateUser(user);
		return "redirect:/user/all/1";
	}
	@RequestMapping("/updateById")
	public String updateReady(@RequestParam("id") Integer id,Model model) {
		Userpojo userpojo = userService.get(id);
		model.addAttribute("userlist", userpojo);
		return "form";
	}
	
	
}
