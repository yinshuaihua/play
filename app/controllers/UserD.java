package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by Administrator on 2016/9/6 0006.
 */
public class UserD extends Controller {


    public Result getUserList() {
        ObjectNode res = Json.newObject();
        models.UserD user = new models.UserD();
        user.setUserName("yin");
        user.setUserPassword("yin056201");
        user.save();

        res.put("err",0);
        return ok(res);
    }

}