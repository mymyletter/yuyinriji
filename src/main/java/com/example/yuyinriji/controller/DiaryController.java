package com.example.yuyinriji.controller;
import com.example.yuyinriji.entity.Diary;
import com.example.yuyinriji.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.List;
@RestController
@RequestMapping("/diary")
public class DiaryController {
    @Autowired
    private DiaryService diaryService;
    // 上传日记+音频
    @PostMapping("/add")
    public String addDiary(
            @RequestParam Integer userId,
            @RequestParam String content,
            @RequestParam String emotion,
            @RequestParam MultipartFile audioFile
    ) throws IOException {
        // 1. 生成唯一文件名，按用户ID分目录存储
        String fileName = UUID.randomUUID() + "_" + audioFile.getOriginalFilename();
        File saveFile = new File(System.getProperty("user.dir") + "/audio/" + userId + "/" + fileName);
        saveFile.getParentFile().mkdirs();
        audioFile.transferTo(saveFile);
        String audioUrl = "/audio/" + userId + "/" + fileName;
        System.out.println("[DiaryController] 音频已保存: " + saveFile.getAbsolutePath()
                + " (size=" + saveFile.length() + " bytes, url=" + audioUrl + ")");
        diaryService.save(userId, content, emotion, audioUrl);
        return "添加成功";
    }
    // 查询用户日记列表
    @GetMapping("/list")
    public List<Diary> list(@RequestParam Integer userId) {
        return diaryService.listByUserId(userId);
    }
    // 删除日记（校验用户所有权）
    @PostMapping("/delete")
    public String delete(@RequestParam Integer id, @RequestParam Integer userId) {
        return diaryService.delete(id, userId) ? "删除成功" : "删除失败";
    }
}