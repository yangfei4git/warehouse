package cn.kgc.mapper;

import cn.kgc.domain.Takeout;
import cn.kgc.domain.TakeoutExample;
import java.util.List;

public interface TakeoutMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Takeout record);

    int insertSelective(Takeout record);

    List<Takeout> selectByExample(TakeoutExample example);

    Takeout selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Takeout record);

    int updateByPrimaryKey(Takeout record);
}