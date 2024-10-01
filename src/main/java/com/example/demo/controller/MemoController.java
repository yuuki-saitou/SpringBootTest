package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Memo;

@Controller
public class MemoController {
	
	List<Memo> memoList = new ArrayList<>();
	
	@GetMapping("/memo")
	public String showMemo(Model model) {
		model.addAttribute("memoList", memoList);
		return "memo-list";
	}
	
	@PostMapping("/addMemo")
	public String addMemo(@RequestParam String title,
			@RequestParam String message) {
		
		memoList.add(new Memo(title, message));
		
		return "redirect:/memo";
	}
	
	@PostMapping("/delMemo/{id}")
	public String delMemo(@PathVariable int id) {
		memoList.removeIf(memo -> memo.getId() == id); //変数memoにmemoListのオブジェクトを代入している
		return "redirect:/memo";
	}

}
