package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
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
        models.UserD getUser = new models.UserD();//新建一个userD的对象
        List<models.UserD> users = getUser.findByName("yinshuaihua");//通过昵称寻找符合的对象并赋值给列表元素
        String email = users.get(0).getUserEmail();//提取数据库返回值第一行数据的email属性值
        res.put("email",email);//返回此email内容
        return ok(res);//返回给请求页面res变量
    }

    //用户注册接口
    public Result userRegister(){
        DynamicForm requestData = Form.form().bindFromRequest();
        String nickname = requestData.get("nickname");
        String userEmail = requestData.get("userEmail");
        String userPassword = requestData.get("userPassword");
        Logger.debug("regist test"+nickname+userEmail+userPassword);

        ObjectNode res = Json.newObject();
        models.UserD registerUser = new models.UserD();//新建一个数据库models的userD对象，名字叫registerUser
        registerUser.setUserName(nickname);//添加用户昵称
        registerUser.setUserEmail(userEmail);//添加用户邮箱
        registerUser.setUserPassword(userPassword);//添加用户密码
        registerUser.save();
        return ok(res);
    }

    //用户注册页面
    public Result registerPage(){
        return ok(views.html.registerPage.render());
    }

    //登录接口
    public Result login(){
        DynamicForm requestData = Form.form().bindFromRequest();//绑定Form表单数据
        ObjectNode res = Json.newObject();//新建一个res对象存储返回信息
        String htmlAccount = requestData.get("account");//nickName or email
        String htmlUserPassword = requestData.get("userPassword");//user's main password
        Logger.debug("user information"+"---"+htmlAccount+"---"+htmlUserPassword);//return user information to debug
        models.UserD getUserInfo = new  models.UserD();
        List<models.UserD> userEmail = getUserInfo.findByEmail(htmlAccount);//只能通过邮箱登录
        models.UserD user = userEmail.get(0);//只获取匹配到的第一个用户
        String dbUserEmail = user.userEmail;//从数据库拉取相关信息
        String dbUserPassword = user.userPassword;
        Logger.debug("db email password "+"---"+dbUserEmail+"---"+dbUserPassword);
        //对比账户和密码
        if (htmlAccount.equals(dbUserEmail)  && htmlUserPassword.equals(dbUserPassword)  ){
            //登录成功
            return ok(views.html.loginOk.render());
        }else return ok(views.html.loginBad.render());
    }

}