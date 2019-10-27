package cn.kgc.service.impl;

import cn.kgc.domain.Product;
import cn.kgc.domain.ProductExample;
import cn.kgc.mapper.ProductMapper;
import cn.kgc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getProductAll() {

        return productMapper.selectByExample(new ProductExample());
    }
}
