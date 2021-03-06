package com.caxs.base.service;

import com.caxs.base.daos.HmUserMapper;
import com.caxs.base.domain.HmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
/**
 * @description:
 * @author: Dongjiawei
 * @date: 2018/8/2 20:50
 * @param:
 * @return:
 */
public class HmUserService implements IHmUserService{

    @Autowired
    private HmUserMapper hmUserMapper;

    @Override
    public HmUser selectByLoginId(String loginId) {
        return hmUserMapper.slectByLoginId(loginId);
    }

    @Override
    public int insertHmUser(HmUser hmUser) {
        return hmUserMapper.insertSelective(hmUser);
    }

    @Override
    public int updateById(HmUser hmUser) {
        return hmUserMapper.updateByPrimaryKeySelective(hmUser);
    }
}
