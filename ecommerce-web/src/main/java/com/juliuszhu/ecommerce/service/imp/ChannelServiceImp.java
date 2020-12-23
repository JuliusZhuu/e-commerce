package com.juliuszhu.ecommerce.service.imp;

import com.juliuszhu.ecommerce.domain.entity.Channel;
import com.juliuszhu.ecommerce.domain.mapper.ChannelMapper;
import com.juliuszhu.ecommerce.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * date: 2020/12/23
 * time: 22:39
 *
 * @author:julius.zhu
 * @describe:
 */
@Service
public class ChannelServiceImp implements ChannelService {
    @Autowired
    private ChannelMapper channelMapper;

    @Override
    public List<Channel> getHomeChannel() {
        return channelMapper.getChannels();
    }
}
