package com.example.yuyinriji.entity;

import java.time.LocalDateTime;

public class Diary {
    private Integer id;
    private Integer userId;
    private String content;
    private String audioUrl;
    private String emotion;
    private LocalDateTime createTime;

    // 全量 getter 方法
    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public String getEmotion() {
        return emotion;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    // 全量 setter 方法（Controller 调用的就是这些！）
    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}