package cn.kgc.service.impl;

import cn.kgc.domain.Product;
import cn.kgc.domain.ProductExample;
import cn.kgc.domain.Takeout;
import cn.kgc.mapper.ProductMapper;
import cn.kgc.mapper.TakeoutMapper;
import cn.kgc.service.TakeoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TakeoutServiceImpl implements TakeoutService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private TakeoutMapper takeoutMapper;

    @Override
    @Transactional
    public boolean addTakeout(Takeout takeout) {

        int i = productMapper.updateQuantity(takeout.getProductid(), takeout.getQuantity());
        int j = takeoutMapper.insertSelective(takeout);

        return (i>0&&j>0)?true:false;
    }

    @Override
    public Integer SearchQuantity(Integer id) {
        int i = productMapper.selectQuantity(id);
        return i;

    }
}
