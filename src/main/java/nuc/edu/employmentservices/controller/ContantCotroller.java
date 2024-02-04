package nuc.edu.employmentservices.controller;

import nuc.edu.employmentservices.enity.Contant;
import nuc.edu.employmentservices.service.ContantService;
import nuc.edu.employmentservices.service.GraduatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class ContantCotroller {

    @Autowired
    private ContantService service;
    @Autowired
    private GraduatesService graduatesService;
    /**
     * html 发送请求，调用controller 方法
     */
    @GetMapping("/contantList")
    public String skipJSP(Model model){
        List<Contant> all = service.getAll();
        model.addAttribute("contantList",all);
        Integer classCount = service.getClassCount();
        model.addAttribute("num",classCount);
        return "contant";
    }

    /**
     * 普通用户看到的所有公告信息
     * @param model
     * @return
     */
    @GetMapping("/select")
    public String add(Model model){
        List<Contant> all = service.getAll();
        model.addAttribute("contantList",all);
        Integer classCount = service.getClassCount();
        model.addAttribute("num",classCount);
        return "select";
    }

    @GetMapping("/add")
    public String skipAdd(Model model,HttpSession session){

        return "add";
    }

    /**
     * 查看按钮的请求路径
     * 普通用户查看公告
     * @param model
     * @param id
     * @param session
     * @return
     */
    @GetMapping("/view/{id}")
    public String view(Model model, @PathVariable(value = "id") Integer id, HttpSession session){
        Contant contant = service.getClassesById(id);
        session.setAttribute("contant",contant);
        return "redirect:/skipSelect";
    }

    /**
     *
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/skipSelect")
    public String skipSelect(Model model,HttpSession session){
        Contant contant = (Contant)session.getAttribute("contant");
        model.addAttribute("contant",contant);
        return "viewSelect";
    }

    /**
     * 删除（根据ID删除）
     * @param ids
     * @return
     */
    @GetMapping("/del/{ids}")
    public String delete(@PathVariable(value = "ids") Integer ids){
        service.delete(ids);
        return "redirect:/contantList";
    }

    /**
     * 编辑公告（根据id）
     * @param ids
     * @param session
     * @return
     */
    @GetMapping("/edit/{ids}")
    public String edit(@PathVariable(value = "ids") Integer ids,HttpSession session){
        Contant contant = service.getClassesById(ids);
        session.setAttribute("contant",contant);
        return "redirect:/editSkip";
    }
    @GetMapping("/editSkip")
    public String editSkip(Model model,HttpSession session){
        Contant contant = (Contant)session.getAttribute("contant");
        model.addAttribute("contant",contant);
        return "edit";
    }

    /**
     * 增加公告
     * @param id
     * @param request
     * @param model
     * @return
     * @throws ParseException
     */
    @PostMapping("/saveEdit/{id}")
    public String saveEdit(@PathVariable("id") Integer id,HttpServletRequest request,Model model) throws ParseException {
        String type = request.getParameter("type");
        String title = request.getParameter("title");
        String contant = request.getParameter("contant");
        String time = request.getParameter("time");
        Contant contant1 = new Contant();
        contant1.setConstant(contant);
        contant1.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(time));
        contant1.setType(type);
        contant1.setTitle(title);
        contant1.setId(id);
        service.update(contant1);
        List<Contant> all = service.getAll();
        model.addAttribute("contantList",all);
        Integer classCount = service.getClassCount();
        model.addAttribute("num",classCount);
        return "redirect:/contantList";
    }

    @GetMapping("/findClassesById")
    public Contant findClassesById(Integer Id){
         return service.getClassesById(Id);
    }

    /**
     * 修改
     * @param contant
     */
    @GetMapping("/update")
    public  void update(Contant contant){
        service.update(contant);
    }
    //获得addContant这个数据/**

    /**
     * 搜索功能
     *
     * @param model
     * @param request
     * @return
     * @throws ParseException
     */
    @PostMapping("/addContant")
    //    HttpServletRequest客户端请求
    public String insert(Model model,HttpServletRequest request) throws ParseException {
//        String type = request.getParameter("type");获得表单中type的值，封装起来
        String type = request.getParameter("type");
        String title = request.getParameter("title");
        String contant = request.getParameter("contant");
        String time = request.getParameter("time");

        Contant contant1 = new Contant();
        contant1.setConstant(contant);
        contant1.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(time));
        contant1.setType(type);
        contant1.setTitle(title);
        service.insert(contant1);
        List<Contant> all = service.getAll();
        //后端往前台传数据
        model.addAttribute("contantList",all);
        Integer classCount = service.getClassCount();
        model.addAttribute("num",classCount);
        return "contant";
    }

    @GetMapping("/findClassCount")
    public Integer findClassCount(){
        return service.getClassCount();
    }


}
