package com.best.controller;

import com.best.common.domain.Video;
import com.best.common.domain.VideoOrder;
import com.best.service.VideoOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

/**
 * @Auther: Hari
 * @Date: 2020/12/31 14:52
 * @Description:
 */

@RestController
@RequestMapping("order")
public class OrderController {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private VideoOutService videoOutService;

    @RequestMapping("/save")
    public Object save(int videoId){

        Video video = videoOutService.findById(videoId);

        VideoOrder videoOrder = new VideoOrder();
        videoOrder.setVideoId(video.getId());
        videoOrder.setVideoTitle(video.getTitle());
        videoOrder.setCreateTime(new Date());

        return videoOrder;
    }



}
