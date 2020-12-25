package com.juliuszhu.ecommerce.service.imp;

import com.juliuszhu.ecommerce.domain.entity.GoodsIssue;
import com.juliuszhu.ecommerce.domain.mapper.GoodsIssueMapper;
import com.juliuszhu.ecommerce.service.GoodsIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * date: 2020/12/25
 * time: 12:22
 *
 * @author:julius.zhu
 * @describe: 商品常见问题service
 */
@Service
public class GoodsIssueServiceImp implements GoodsIssueService {
    @Autowired
    private GoodsIssueMapper issueMapper;
    @Override
    public List<GoodsIssue> getIssue(Integer goodsId) {
        return issueMapper.getIssue(goodsId);
    }
}
