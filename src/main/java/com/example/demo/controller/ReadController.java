package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.UserSearchRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class ReadController {

	@Autowired
	UserService userService;

	@GetMapping(value = "user/search")
	public String displaySearch(Model model) {
		return "user/search";
	}

	/**
	 * ユーザー情報検索
	 * @return ユーザー情報一覧画面
	 */
	@RequestMapping(value = "/user/id_search", method = RequestMethod.POST)
	public String search(@ModelAttribute UserSearchRequest userSearchRequest, Model model) {
		User user = userService.search(userSearchRequest);
		model.addAttribute("userinfo", user);
		return "user/search";
	}
	
	//ユーザー登録
	@GetMapping("/user/register")
    public String registerUser(Model model, @ModelAttribute User u) {
        model.addAttribute("user", u);
        return "user/register";
    }

	@PostMapping("/user/register")
	public String create(@Validated @ModelAttribute User u, BindingResult result) {
		if (result.hasErrors()) {
			return "user/register";
		}
		userService.insertOne(u);
		return "redirect:/user/search";
	}
	
	//ユーザー情報の更新フォーム
	@GetMapping("/user/update")
	public String updateUser(Model model, @ModelAttribute User u) {
		model.addAttribute("user", u);
		return "user/update";
	}
	//名前の更新
	@PostMapping("/user/updateName")
	public String updateName(@Validated @ModelAttribute User u, BindingResult result) {
		if (result.hasErrors()) {
			return "user/update";
		}
		userService.updateName(u);
		return "redirect:/user/search";
	}
	//住所の更新
	@PostMapping("/user/updateAddress")
	public String updateAddress(@Validated @ModelAttribute User u, BindingResult result) {
		if (result.hasErrors()) {
			return "user/update";
		}
		userService.updateAddress(u);
		return "redirect:/user/search";
	}
	//電話番号の更新
	@PostMapping("/user/updatePhone")
	public String updatePhone(@Validated @ModelAttribute User u, BindingResult result) {
		if (result.hasErrors()) {
			return "user/update";
		}
		userService.updatePhone(u);
		return "redirect:/user/search";
	}
	
	//ユーザー削除
	@GetMapping("/user/delete")
	public String deleteUser(Model model, @ModelAttribute User u) {
		model.addAttribute("user", u);
		return "user/delete";
	}
	@PostMapping("/user/deleteUser")
	public String userDelete(@Validated @ModelAttribute User u, BindingResult result) {
		if (result.hasErrors()) {
			return "user/delete";
		}
		userService.deleteOne(u);
		return "redirect:/user/search";
	}
}
