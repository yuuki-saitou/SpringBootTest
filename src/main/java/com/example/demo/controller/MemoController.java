
package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Memo;
import com.example.demo.service.MemoService;

@Controller
public class MemoController {

	@Autowired
	private MemoService memoService;

	List<Memo> memoList = new ArrayList<>();

	@GetMapping("/memo")
	public String showMemo(Model model) {

		model.addAttribute("memos", memoList);

		return "memo-list";
	}

	@PostMapping("/addMemo")
	public String addMemo(@RequestParam("memo") String title,
			@RequestParam("message") String message) {

		memoList.add(new Memo(title, message));

		return "redirect:/memo";

	}

	@GetMapping("/memo/sort")
	public String sortMemo(@RequestParam("order") String order, Model model) {
		if ("desc".equals(order)) {
			memoList.sort(Comparator.comparing(Memo::getTitle).reversed());
		} else {
			memoList.sort(Comparator.comparing(Memo::getTitle));
		}
		model.addAttribute("memos", memoList);
		return "memo-list";
	}

	@PostMapping("/deleteMemo")
	public String deleteMemo(@RequestParam("id") int id) {
		memoList.removeIf(memo -> memo.getId() == id);
		return "redirect:/memo";
	}

	@PostMapping("completeMemo")
	public String completeMemo(@RequestParam("id") int id) {
		memoList.stream()
				.filter(memo -> memo.getId() == id)
				.findFirst()
				.ifPresent(memo -> memo.setCompleted(!memo.isCompleted()));
		return "redirect:/memo";

	}

}
