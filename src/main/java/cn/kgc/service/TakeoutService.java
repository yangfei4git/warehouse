package cn.kgc.service;

import cn.kgc.domain.Takeout;

public interface TakeoutService {

    public boolean addTakeout(Takeout takeout);

    public Integer SearchQuantity(Integer id);
}
