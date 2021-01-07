package com.best.controller;

import com.best.common.domain.Video;
import com.best.common.domain.VideoOrder;
import com.best.service.VideoOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("save")
    public Object save(int videoId){

        Video video = videoOutService.findById(videoId);

        VideoOrder videoOrder = new VideoOrder();
        videoOrder.setVideoId(video.getId());
        videoOrder.setVideoTitle(video.getTitle());
        videoOrder.setCreateTime(new Date());

        return videoOrder;
    }

    int temp = 0;

    @RequestMapping("list")
    public Object list(HttpServletRequest request){

//
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        temp++;
        if(temp%3 == 0){
             throw  new RuntimeException();
        }
        Map<String, String> map = new HashMap<>();
        map.put("title1","ALibabaCloud微服务专题");
        map.put("title2","小滴课堂面试专题第一季");
        map.put("port",request.getServerPort()+"");

        return map;
    }



}
