package nuc.edu.employmentservices.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nuc.edu.employmentservices.enity.*;
import nuc.edu.employmentservices.service.GraduatesService;
import nuc.edu.employmentservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    GraduatesService graduatesService;

    /**
     * 获得uer表中的数据
     * @param model
     * @return
     */
    @GetMapping("/getAllUsers")
    public String getAllUsers(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users",users);
        return "index1";
    }


    //登录的后端验证。
    @RequestMapping("/login")
    //RequestParam
    public String login(@RequestParam("uname")  String name,
                        @RequestParam("pws")  String psw,
                        Model model,HttpSession session){

        User user = IsLogin(name,psw);
        if(user.getUserName()!=null){
            session.setAttribute("loginuser",user);
            List<Graduates> graduatesList = graduatesService.getAllGraduates();
            model.addAttribute("graduatesList",graduatesList);  //就是这个
            return "index1";
        }else{
            return "fail";
        }
    }
// 套用Spring Security
    @GetMapping("/tologin")
    public String tologin(){
        return "index";
    }

    /**
     * 用户名和密码是否都一致
     * @param account
     * @param password
     * @return
     */
    public User IsLogin(String account,String password){
        User user = new User();
        List<User> users = (List<User>) userService.getAllUsers();
        for(User user2:users){
            if(account.equals(user2.getUseraccount()) && password.equals(user2.getUserPassword())){
                return user2;
            }
        }
        return user;
    }

    @GetMapping("/userlist")
    public String grauser(Model model)
    {
        List<User> userlist=userService.getAllUsers();
        Integer usernum=userService.GetUserNum();
        model.addAttribute("userlist",userlist);
        model.addAttribute("usernum",usernum);
        return "userlist";

    }

    @GetMapping("/toindex")
    public String toindex(Model model)
    {
        List<Graduates> graduatesList=graduatesService.getAllGraduates();
        model.addAttribute("graduatesList",graduatesList);
        return "index1";

    }


    @RequestMapping("/account")
    public String account(){

        return "updateaccount";
    }

    @RequestMapping("/doupdateaccount")
    public String doupdateaccount(User user,HttpSession session){

        User user1 = new User();
        user1 = (User)session.getAttribute("loginuser");
        user.setUserId(user1.getUserId());
        user.setGraID(user1.getGraID());
        user.setTypes(user1.getTypes());
        user.setUserName(user1.getUserName());

        userService.updateUserBy(user);
        session.setAttribute("loginuser",user);
        return "redirect:/dodeletegradutes";
    }

    @RequestMapping("/manageaccount")
    public String manageaccount(Model model){
        List<User> manageUsers = userService.selectUserByType(0);
        model.addAttribute("manageUsers",manageUsers);
        return "/manageaccountlist";
    }

    @RequestMapping("/deletemanageaccount/{deid}")
    public String deletemanageaccount(@PathVariable("deid") Integer deid){
        userService.deleteUserByuserId(deid);
        return  "redirect:/dodeletegradutes";
    }

    @RequestMapping("/toaddmanageaccount")
    public String toaddmanageaccount(){
        return "/toaddmanageaccount";
    }

    @RequestMapping("/addmanageaccount")
    public String addmanageaccount(User user){
        userService.insertUser(user);
        return  "redirect:/dodeletegradutes";
    }

    @RequestMapping("/toupdatemanageaccount/{upid}")
    public String toupdatemanageaccount(@PathVariable("upid") Integer upid, HttpSession session){
        User user = userService.getUserById(upid);
        session.setAttribute("upmauser",user);
        return "redirect:/toIndexup";
    }

    @RequestMapping("/toIndexup")
    public String toIndexup(HttpSession session,Model model){
        User user = (User)session.getAttribute("upmauser");
        model.addAttribute("upuser",user);
        return "/toupdatemanageaccount";
    }

    @RequestMapping("/doupdatemanageaccount")
    public String doupdatemanageaccount(User user){
        userService.updateUserByuserid(user);
        return  "redirect:/dodeletegradutes";
    }

    /**
     * 就业方向的统计图
     * @param model
     * @param request
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping("/skipEcharts")
    public String skipEcharts(Model model, HttpServletRequest request)
                throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        List<View> gather = userService.gather();
        model.addAttribute("list",mapper.writeValueAsString(gather));
        return "admin";
    }
    /**
     * 就业统计的柱状图
     */

    @GetMapping("/skipEcharts1")
    public void classeslist2(Model model)
    {
//        List<Classes> classesList=classesService.getFiveClasses();

    }
    @RequestMapping("/skipEcharts1")
    @ResponseBody
    public List<View> findById2(Model model) {
        List<View> admins1 = userService.admins();
        model.addAttribute("admins1",admins1);
        return admins1;
    }
    /**
     * 前端参数
     */
    public String find(String userName,Integer classId,String comName){
//        select  userName,classId,comName from table;
        return "";
    }

}
