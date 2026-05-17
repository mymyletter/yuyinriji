package com.example.yuyinriji.service;

import com.example.yuyinriji.entity.Diary;
import java.util.List;

public interface DiaryService {
    // 1. 保存日记
    void save(Integer userId, String content, String emotion, String audioUrl);

    // 2. 根据用户ID查询日记列表
    List<Diary> listByUserId(Integer userId);

    // 3. 根据ID和用户ID删除日记（校验所有权）
    boolean delete(Integer id, Integer userId);
}