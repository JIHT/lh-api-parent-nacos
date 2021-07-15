package com.lihua.feedcontrollerapi.service;


import com.baomidou.mybatisplus.service.IService;
import com.lihua.feedcontrollerapi.entity.TOrgStorage;

import java.util.List;
import java.util.Map;

/**
 * TOrgStorage的服务接口
 *
 * @author
 *
 */
public interface TOrgStorageService extends IService<TOrgStorage>{

    List<Map<String, Object>> listDeps(String name);
}
