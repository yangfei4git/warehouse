package cn.kgc.service;

import cn.kgc.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    public List<Product> getProductAll();
}
