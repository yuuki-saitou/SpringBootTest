package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.Memo;

@Mapper
public interface MemoMapper {
	@Insert("INSERT INTO memos (title, content, created_at) VALUES (#{title}, #{content}, #{createdAt})")
	void insertMemo(Memo memo);

	@Select("SELECT * FROM memos WHERE id = #{id}")
	Memo findMemoById(int id);

	@Select("SELECT * FROM memos")
	List<Memo> findAllMemos();
}
