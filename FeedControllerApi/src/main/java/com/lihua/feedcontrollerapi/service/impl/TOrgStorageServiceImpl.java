package com.lihua.feedcontrollerapi.service.impl;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.lihua.feedcontrollerapi.service.TOrgStorageService;
import com.lihua.feedcontrollerapi.dao.TOrgStorageDao;
import com.lihua.feedcontrollerapi.entity.TOrgStorage;
/**
 * TOrgStorage的服务接口的实现类
 *
 * @author
 *
 */
@Service("TOrgStorageService")
public class TOrgStorageServiceImpl extends ServiceImpl<TOrgStorageDao, TOrgStorage> implements TOrgStorageService {
	private final Logger LOG = LogManager.getLogger(this.getClass());

	@Override
	public List<Map<String, Object>> listDeps(String name) {
		return baseMapper.listDeps(name);
	}
}