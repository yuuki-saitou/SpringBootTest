package com.example.demo.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Memo;
import com.example.demo.mapper.MemoMapper;

@Service
public class MemoService {
	@Autowired //Mapperと依存関係を作る
	private MemoMapper memoMapper;

	public void addMemo(Memo memo) {
		memoMapper.insertMemo(memo);
	}

	public void deleteMemoById(int id) {
		memoMapper.deleteMemoById(id);
	}

	public Memo getMemoById(int id) {
		return memoMapper.findMemoById(id);
	}

	public List<Memo> getAllMemos() {
		return memoMapper.findAllMemos();
	}

	public List<Memo> getSortMemos(String order) {
		List<Memo> memoList = memoMapper.findAllMemos();
		if ("desc".equals(order)) {
			memoList.sort(Comparator.comparing(Memo::getTitle).reversed());
		} else {
			memoList.sort(Comparator.comparing(Memo::getTitle));
		}
		return memoList;
	}
}
