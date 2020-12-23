package com.juliuszhu.ecommerce.service;

import com.juliuszhu.ecommerce.domain.entity.Channel;

import java.util.List;

/**
 * date: 2020/12/23
 * time: 22:38
 *
 * @author:julius.zhu
 * @describe:首页频道service
 */
public interface ChannelService {
    List<Channel> getHomeChannel();
}
