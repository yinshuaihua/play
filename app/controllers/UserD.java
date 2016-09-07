package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * Created by Administrator on 2016/9/6 0006.
 */
public class UserD extends Controller {


    public Result getUserList() {
        ObjectNode res = Json.newObject();
        models.UserD user = new models.UserD();
        user.setUserName("yinshuaihua");
        user.setUserEmail("809808232@qq.com");
        user.setUserPassword("yin056201");
        user.save();
        models.UserD getUser = new models.UserD();
        List<models.UserD> users = getUser.findByName("yinshuaihua");
        String email = users.get(0).getUserEmail();
        res.put("email",email);
        return ok(res);
    }

}