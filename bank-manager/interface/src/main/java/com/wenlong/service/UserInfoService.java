package com.wenlong.service;

import com.wenlong.dto.Page;
import com.wenlong.dto.Result;
import com.wenlong.pojo.po.Userinfo;

import java.util.List;

public interface UserInfoService {
    Result<Userinfo> listUserInfoByPage(Page page);

    int deleteUserInfoById(List<Integer> userIds);
}
