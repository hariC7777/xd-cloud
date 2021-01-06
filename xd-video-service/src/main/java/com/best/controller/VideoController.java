package com.best.controller;

import com.best.common.domain.Video;
import com.best.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: Hari
 * @Date: 2020/12/31 10:57
 * @Description:
 */

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @RequestMapping("findById")
    public Object findById(int videoId){
        return videoService.findById(videoId);
    }

    @PostMapping("save")
    public Object save(@RequestBody Video video){
        System.out.println(video.getTitle());
        return video;
    }

}
