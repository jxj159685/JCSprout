package com.crossoverjie.design.pattern.mybatis;

import com.crossoverjie.design.pattern.mybatis.service.UpdateService;

public class UpdateServiceImpl implements UpdateService {
    @Override
    public void update() {
        System.out.println("更新数据！");
    }
}
