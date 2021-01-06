package com.wqh.jpa.util;

import com.wqh.jpa.entity.PageInfo;
import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CommonUtil
 * @Author wqh
 * @Date 2021/1/5 14:31
 * @Description TODO
 * @Version 1.0
 */
public class CommonUtil {

    public static Map<String, Object> getResponse(Page pages) {
        Map<String, Object> resultMap = new HashMap<>();
        List<Object> list = pages.getContent();
        PageInfo pageInfo = new PageInfo(pages.getNumber(), pages.getSize(), pages.getTotalPages(), pages.getSize() * pages.getTotalPages());
        resultMap.put("resultObject", list);
        resultMap.put("pageInfo", pageInfo);
        return resultMap;
    }
}
