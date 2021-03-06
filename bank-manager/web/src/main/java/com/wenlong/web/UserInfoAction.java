package com.wenlong.web;

import com.wenlong.dto.Page;
import com.wenlong.dto.Result;
import com.wenlong.pojo.po.Userinfo;
import com.wenlong.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class UserInfoAction {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserInfoService ser;
    @ResponseBody
    @RequestMapping("/userinfo-list")
    public Result<Userinfo> userInfoList(Page page) {
        Result<Userinfo> result = null;
        try {
            result = ser.listUserInfoByPage(page);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/userinfo-delete")
    public int userInfoDelete(@RequestParam("arr[]") List<Integer> userIds){
        int i = 0;
        i = ser.deleteUserInfoById(userIds);
        return i;
    }
}
