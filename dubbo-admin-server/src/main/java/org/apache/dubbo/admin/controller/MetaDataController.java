package org.apache.dubbo.admin.controller;

import lombok.extern.slf4j.Slf4j;
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
public class MetaDataController {
    @RequestMapping(value = "/detailAccess", method = RequestMethod.GET)
    public Map detailAccess(@RequestParam String name) {
        log.info("名字是："+name);
        Map<String,String> result = new HashMap<>();
        result.put("name",name);
        return result;
    }
}
