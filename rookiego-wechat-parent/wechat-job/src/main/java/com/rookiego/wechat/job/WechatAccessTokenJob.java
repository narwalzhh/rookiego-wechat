package com.rookiego.wechat.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * <b>类名称:</b>WechatAccessTokenJob<br/>
 * <b>类注释:</b>微信AccessToken维护作业<br/>
 * <b>类描述:</b><br/>
 * <b>创建人:</b>rookie<br/>
 * <b>修改人:</b>rookie<br/>
 * <b>修改时间:</b>2017年07月24日 22时57分45秒<br/>
 * <b>修改备注:</b><br/>
 *
 * @version 1.0.0<br/>
 */
public class WechatAccessTokenJob implements SimpleJob {
    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println("-------------+++++++++++++++++++++--------------");
    }
}
