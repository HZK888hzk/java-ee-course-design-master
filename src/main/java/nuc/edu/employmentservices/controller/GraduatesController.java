package nuc.edu.employmentservices.controller;

import nuc.edu.employmentservices.enity.*;
import nuc.edu.employmentservices.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class GraduatesController {
    @Autowired
    private GraduatesService graduatesService;
    @Autowired
    private UserService userService;
    @Autowired
    private ClassesService classesService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private DirectionService directionService;
    @Autowired
    private ContantService contantService;



    @GetMapping("/memberlist")
    public String memberlist(Model model){
        List<Graduates> graduatesList = graduatesService.getAllGraduates();
        Integer num=graduatesService.Getgranum();
        model.addAttribute("graduatesList1",graduatesList);
        model.addAttribute("num",num);
        return "memberlist";
    }

    /**
     * 得到未审核的信息  ，管理员页面
     * @param model
     * @return
     */
    @GetMapping("/scount1")
    public String memberlist3(Model model){
        List<Graduates> graduatesList = graduatesService.getWtj();
        Integer num=graduatesService.Getgranum();
        model.addAttribute("graduatesList3",graduatesList);
        model.addAttribute("num",num);

        return "scount1";
    }

    /**
     * 学生页面的就业信息是否通过,根据id获取
     * @param model
     * @return
     */
    @GetMapping("/out")
    public String memberlist4(HttpSession session, Model model){
       User user = (User) session.getAttribute("loginuser");
        System.out.println(user);
        Integer garid = user.getUserId();
        List<Graduates> graduatesList = graduatesService.getWt(garid);
        Integer num=graduatesService.Getgranum();
        model.addAttribute("graduatesList3",graduatesList);
        model.addAttribute("num",num);
        return "out";
    }


    /**
     * 审核通过的，状态变成1
     */
    @RequestMapping("/scount3/{graID}")
    public String allow(@PathVariable("graID") Integer graID, HttpSession session) throws ParseException {
        Graduates wtjByid = graduatesService.getWtjByid(graID);
        wtjByid.setStatus("1");
        String format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(wtjByid.getGraTime());
        Date parse = new SimpleDateFormat("yyy-MM-dd HH:mm:ss").parse(format);
        wtjByid.setGraTime(parse);
        graduatesService.updateById(wtjByid);
        return "redirect:/scount1";
    }

    /**
     * 审核不通过
     * @return
     */
    @RequestMapping("/scount4/{graID}")
    public String notAllow(){
        return "redirect:/scount1";

    }

    /**
     * 毕业生的信息统计
     * @param model
     * @return
     */
    @GetMapping("/scount")
    public String memberlist1(Model model){
        List<Graduates> graduatesList = graduatesService.getAllGraduates();
        Integer num=graduatesService.Getgranum();
        model.addAttribute("graduatesList1",graduatesList);
        model.addAttribute("num",num);
        return "scount";
    }

    /**
     * 查看公告
     * @param request
     * @param model
     * @return
     */
    @PostMapping("/memberlist2")
    public String memberlist2(HttpServletRequest request,Model model){
        String type = request.getParameter("type");
        String title = request.getParameter("title");

        Contant contant = new Contant();

         contant.setType(type.equals("") ? null :type);
        contant.setTitle(title.equals("") ? null :title);
        List<Contant> contantList = contantService.getCkgg(contant);
        Integer num=graduatesService.Getgranum();
        model.addAttribute("contantList",contantList);
        return "/select";
    }


    /**
     * 增加就业信息
     * @param model
     * @return
     */
    @RequestMapping("/toaddgradutes")
    public String toaddgradutes(Model model){
        List<Classes> classesList = classesService.getAllClasses();
        model.addAttribute("classesList",classesList);

        List<Company> companyList = companyService.getAllCompany();
        model.addAttribute("companyList",companyList);

        List<Direction> directionList = directionService.getAllDirection();
        model.addAttribute("directionList",directionList);

        return "toaddgradutes";
    }

    /**
     * 跳转到添加的页面，增加就业信息。
     * @param graduates
     * @return
     * @throws ParseException
     */
    @PostMapping("/addgradutes")
    public String addgradutes(Graduates graduates) throws ParseException {
        graduatesService.insertGraduates(graduates);
        User user = new User();
        user.setUserName(graduates.getUser().getUserName());
        user.setUseraccount(graduates.getUser().getUseraccount());
        user.setUserPassword(graduates.getUser().getUserPassword());
        user.setGraID(graduates.getGraID());
        user.setTypes(graduates.getUser().getTypes());
        user.setComAddress(graduates.getComAddress());
        userService.insertUser(user);
        return "/success";
    }

    /**
     * 毕业生信息修改
     * @param updateid
     * @param session
     * @return
     */
    @RequestMapping("/toupdategradutes/{updateid}")
    public String toupdategradutes(@PathVariable("updateid") Integer updateid, HttpSession session){
        Graduates graduates = graduatesService.getGraduatesById(updateid);
        session.setAttribute("upgraduates",graduates);

        return  "redirect:/toupda";
    }

    /**
     * 查看详情
     * @param model
     * @param session
     * @return
     */


    @RequestMapping("/toupda")
    public String toupda(Model model,HttpSession session){
        Graduates graduates =(Graduates)session.getAttribute("upgraduates");
        model.addAttribute("upgraduate",graduates);

        List<Classes> classesList = classesService.getAllClasses();
        model.addAttribute("classesList",classesList);

        List<Company> companyList = companyService.getAllCompany();
        model.addAttribute("companyList",companyList);

        List<Direction> directionList = directionService.getAllDirection();
        model.addAttribute("directionList",directionList);

        return "toupdategradutes";
    }

    @RequestMapping("/doupgradutes")
    public String doupgradutes(Graduates graduates){
        graduatesService.updateGraduatesById(graduates);
        User user = new User();
        user.setTypes(graduates.getUser().getTypes());
        user.setUserPassword(graduates.getUser().getUserPassword());
        user.setUseraccount(graduates.getUser().getUseraccount());
        user.setUserName(graduates.getUser().getUserName());
        user.setGraID(graduates.getGraID());

        userService.updateUserBy(user);
        return "/success";
    }

    @RequestMapping("/deletegradutes/{deleteid}")
    public String deletegradutes(@PathVariable("deleteid") Integer deleteid){
        graduatesService.deleteGraduates(deleteid);
        userService.deleteUserById(deleteid);
        return "redirect:/dodeletegradutes";
    }

    @RequestMapping("/dodeletegradutes")
    public String dodeletegradutes(){
        return "/success";
    }


/**
 *  通过字段找到学生信息，在首页
 */

    @PostMapping("/index1")

    public String index(HttpServletRequest request,Model model){
        String name = request.getParameter("name");
        String aClass = request.getParameter("class");
       String company1 = request.getParameter("comName");
        String comAddress = request.getParameter("comAddress");
        String dirName = request.getParameter("dirName");


        Graduates graduates = new Graduates();

        User user = new User();
        user.setUserName(name == "" ? null :name);
        graduates.setUser(user);

        Classes classes = new Classes();
        classes.setClassNum(aClass == "" ? null : Integer.valueOf(aClass));
        graduates.setClasses(classes);


        /**
         * 按照地区查询
         */
        Direction direction1 = new Direction();
        direction1.setDirName(dirName == "" ? null :dirName);
        graduates.setDirection(direction1);
        /**
         * 按照地区查询
         */
        Company company2 = new Company();
        company2.setComAddress(comAddress == "" ? null :comAddress);
        graduates.setCompany(company2);
        company2.setComName(company1 == "" ? null :company1);
        graduates.setCompany(company2);

        List<Graduates> graduatesList1 = graduatesService.getSelect(graduates);

        //返回的记录条数
        Integer num=graduatesService.Getgranum();
        model.addAttribute("graduatesList",graduatesList1);
        return "index1";
    }

    /***
     * 未审核的就业信息
     * @param request
     * @param model
     * @return
     */


    @PostMapping("/index2")

    public String index1(HttpServletRequest request,Model model){
        String name = request.getParameter("name");
        String aClass = request.getParameter("class");
        String company = request.getParameter("company");
        String comAddress = request.getParameter("comAddress");
        String dirName = request.getParameter("dirName");

        Graduates graduates = new Graduates();

        User user = new User();
        user.setUserName(name == "" ? null :name);
        graduates.setUser(user);

        Classes classes = new Classes();
        classes.setClassNum(aClass == "" ? null : Integer.valueOf(aClass));
        graduates.setClasses(classes);

        Company company1 = new Company();
        company1.setComName(company == "" ? null :company);
        graduates.setCompany(company1);

        /**
         * 按照地区查询
         */
        Direction direction1 = new Direction();
        direction1.setDirName(dirName == "" ? null :dirName);
        graduates.setDirection(direction1);
        /**
         * 按照地区查询
         */
        Company company2 = new Company();
        company2.setComAddress(comAddress == "" ? null :comAddress);
        graduates.setCompany(company2);


        List<Graduates> graduatesList1 = graduatesService.getSelect(graduates);

        //返回的记录条数
        Integer num=graduatesService.Getgranum();
        model.addAttribute("graduatesList1",graduatesList1);
        return "scount";
    }
    /**
     * 薪资的饼状图逻辑
     */
    @GetMapping("/salaryshow")
    public void graduatesList(Model model)
    {

    }
    @RequestMapping("/salaryshow")
    @ResponseBody
    public List<Graduates> findById(Model model) {
        List<Graduates> graduatesList= graduatesService.getSalary();
        model.addAttribute("graduatesList",graduatesList);
        return graduatesList;
    }

    /**
     * 薪资得到柱状图的逻辑
     */
    @GetMapping("/salaryshow1")
    public void graduatesList1(Model model){}


    @RequestMapping("/salaryshow1")
    @ResponseBody
    public  List<Graduates> findById1(Model model){
        List<Graduates> allGraduates = graduatesService.getASalary();
        model.addAttribute("allGraduates",allGraduates);
        return allGraduates;
    }

    /**
     * 地区的饼状图逻辑
     */
    @GetMapping("/regionshow")
    public void graduatesList2(Model model)
    {

    }
    @RequestMapping("/regionshow")
    @ResponseBody
    public List<Graduates> findById2(Model model) {
        List<Graduates> graduatesList1 = graduatesService.getRegion();
        model.addAttribute("graduatesList1",graduatesList1);
        return graduatesList1;
    }

    /**
     * 地区的柱状图逻辑
     */

    @GetMapping("/regionshow1")
    public void graduatesList3(Model model)
    {

    }
    @RequestMapping("/regionshow1")
    @ResponseBody
    public List<Graduates> findById3(Model model) {
        List<Graduates> aRegion = graduatesService.getARegion();
        model.addAttribute("aRegion",aRegion);
        return aRegion;
    }
}
