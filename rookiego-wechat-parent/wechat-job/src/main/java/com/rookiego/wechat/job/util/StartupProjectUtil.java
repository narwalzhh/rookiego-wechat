package com.rookiego.wechat.job.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <b>类名称:</b>StartupProjectUtil<br/>
 * <b>类注释:</b>启动工程类<br/>
 * <b>类描述:</b><br/>
 * <b>创建人:</b>rookie<br/>
 * <b>修改人:</b>rookie<br/>
 * <b>修改时间:</b>2017年07月24日 23时00分21秒<br/>
 * <b>修改备注:</b><br/>
 *
 * @version 1.0.0<br/>
 */
public class StartupProjectUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(StartupProjectUtil.class);

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/*.xml");
    }
}
