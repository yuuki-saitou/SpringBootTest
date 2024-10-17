package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Memo;
import com.example.demo.mapper.MemoMapper;

@Service
public class MemoService {
	@Autowired
	private MemoMapper memoMapper;

	public void addMemo(Memo memo) {
		memoMapper.insertMemo(memo);
	}

	public Memo getMemoById(int id) {
		return memoMapper.findMemoById(id);
	}

	public List<Memo> getAllMemos() {
		return memoMapper.findAllMemos();
	}
}
