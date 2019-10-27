package cn.kgc.mapper;

import cn.kgc.domain.Product;
import cn.kgc.domain.ProductExample;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
    @Update("update product set quantity=quantity-#{param2} where id=#{param1}")
    int updateQuantity(Integer id,Integer quantity);
    @Select("select quantity from product where id=#{param1}")
    int selectQuantity(Integer id);
}