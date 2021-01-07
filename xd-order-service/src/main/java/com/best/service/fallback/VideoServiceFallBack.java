package com.best.service.fallback;

import com.best.common.domain.Video;
import com.best.service.VideoOutService;
import org.springframework.stereotype.Service;

/**
 * @Auther: Hari
 * @Date: 2021/1/7 11:29
 * @Description:
 */

@Service
public class VideoServiceFallBack implements VideoOutService {

    @Override
    public Video findById(int videoId) {
        Video video = new Video();
        video.setTitle("熔断降级数据");
        return video;
    }

    @Override
    public Video saveVideo(Video video) {
        return null;
    }
}
