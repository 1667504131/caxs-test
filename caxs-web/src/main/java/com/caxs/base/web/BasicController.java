package com.caxs.base.web;

import com.caxs.base.domain.HmUser;
import com.caxs.base.domain.JsonResponse;
import com.caxs.base.service.IHmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/hm_users")
public class BasicController {

    @Autowired
    private IHmUserService hmUserService;

    @RequestMapping(value = "/new")
    public JsonResponse createHmUser(@ModelAttribute HmUser hmUser,HttpServletRequest request){
        int i = hmUserService.insertHmUser(hmUser);
        if(i == 1){
            return JsonResponse.success("创建成功");
        }else {
            return JsonResponse.fail("-1","创建失败");
        }
    }

    @RequestMapping(value = "/edit")
    public JsonResponse updateHmUser(@PathVariable String hm_user_id, @ModelAttribute HmUser hmUser){
        if( null == hm_user_id || "".equals(hm_user_id)){
            return JsonResponse.success("未作修改");
        }else {
            hmUser.setId(hm_user_id);
            int i =  hmUserService.updateById(hmUser);
            if(i > 0){
                return JsonResponse.success("修改成功");
            }else {
                return JsonResponse.fail("-1","修改失败");
            }
        }
    }
}
