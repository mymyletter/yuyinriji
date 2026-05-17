package com.example.yuyinriji.service.impl;

import com.example.yuyinriji.entity.Diary;
import com.example.yuyinriji.mapper.DiaryMapper;
import com.example.yuyinriji.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DiaryServiceImply implements DiaryService {

    @Autowired
    private DiaryMapper diaryMapper;

    /**
     * 保存日记
     */
    @Override
    public void save(Integer userId, String content, String emotion, String audioUrl) {
        Diary diary = new Diary();
        diary.setUserId(userId);
        diary.setContent(content);
        diary.setEmotion(emotion);
        diary.setAudioUrl(audioUrl);
        diary.setCreateTime(LocalDateTime.now());
        diaryMapper.insert(diary);
    }

    /**
     * 根据用户ID查询日记列表
     */
    @Override
    public List<Diary> listByUserId(Integer userId) {
        return diaryMapper.selectByUserId(userId);
    }

    /**
     * 根据ID和用户ID删除日记（校验所有权，防止跨用户删除）
     */
    @Override
    public boolean delete(Integer id, Integer userId) {
        int rows = diaryMapper.deleteByIdAndUserId(id, userId);
        return rows > 0;
    }
}