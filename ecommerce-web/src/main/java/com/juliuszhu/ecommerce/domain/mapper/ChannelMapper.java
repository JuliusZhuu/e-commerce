package com.juliuszhu.ecommerce.domain.mapper;

import com.juliuszhu.ecommerce.domain.entity.Channel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * date: 2020/12/23
 * time: 22:47
 *
 * @author:julius.zhu
 * @describe: 频道mapper
 */
public interface ChannelMapper {
    /**
     * 获取所有的频道信息
     * @return
     */
    @Select("select * from channel")
    List<Channel> getChannels();
}
