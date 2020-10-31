package org.apache.dubbo.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.admin.annotation.Authority;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuanlei
 * @date 2020-10-30
 */
@RestController
@RequestMapping("/api/metaData")
@Slf4j
@EnableScheduling
public class MetaDataController {
    @RequestMapping(value = "/detailAccess", method = RequestMethod.GET)
    public Map detailAccess(@RequestParam String name) {
        log.info("名字是："+name);
        Map<String,String> result = new HashMap<>();
        result.put("name",name);
        return result;
    }

    //定义一个按一定频率执行的定时任务，每隔1分钟执行一次
    @Scheduled(fixedRate = 1000 * 50)
    public void job2() {
        //执行代码
        log.info("这是定时器");
    }
}
