package com.yqc.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by fangzhipeng on 2017/4/6.
 */
@FeignClient(value = "id-generator", fallback = ComputeClientHystrix.class)
public interface FeignService {

    @RequestMapping(value = "/getId", method = RequestMethod.GET)
    String getId();
}
