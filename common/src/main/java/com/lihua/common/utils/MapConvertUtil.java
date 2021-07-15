package com.lihua.common.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author IGisvity
 */
public class MapConvertUtil {
    /**
     * map转换成list
     * @param map
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static List<Object> mapTransitionList(Map map) {
        List list = new ArrayList();
        // 获得map的Iterator
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            list.add(entry.getValue());
        }
        return list;
    }
}
