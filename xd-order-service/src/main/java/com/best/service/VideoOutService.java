package com.best.service;

import com.best.common.domain.Video;
import com.best.service.fallback.VideoServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: Hari
 * @Date: 2021/1/5 13:45
 * @Description:
 */

@FeignClient(name = "xdclass-video-service", fallback = VideoServiceFallBack.class)
public interface VideoOutService {

    @GetMapping(value = "/video/findById")
    Video findById(@RequestParam("videoId") int videoId);

    @PostMapping(value = "/video/save")
    Video saveVideo(@RequestBody Video video);

}
