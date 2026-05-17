package com.example.yuyinriji.mapper;

import com.example.yuyinriji.entity.Diary;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface DiaryMapper {
    int insert(Diary diary);
    List<Diary> selectByUserId(Integer userId);
    Diary selectById(Integer id);
    int update(Diary diary);
    int deleteByIdAndUserId(@org.apache.ibatis.annotations.Param("id") Integer id, @org.apache.ibatis.annotations.Param("userId") Integer userId);
}