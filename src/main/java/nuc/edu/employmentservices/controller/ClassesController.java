package nuc.edu.employmentservices.controller;

import nuc.edu.employmentservices.enity.Classes;
import nuc.edu.employmentservices.enity.Graduates;
import nuc.edu.employmentservices.service.ClassesService;
import nuc.edu.employmentservices.service.GraduatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ClassesController {

    @Autowired
    private ClassesService classesService;

    @Autowired
    private GraduatesService graduatesService;

    /**
     * 饼状图的逻辑
     * @param model
     */
    @GetMapping("/classeslist")
    public void classeslist(Model model)
    {
//        List<Classes> classesList=classesService.getFiveClasses();

    }

    /**
     * 查询学生
     * @param model
     * @return
     */
    @RequestMapping("/classeslist")
    @ResponseBody
    public List<Classes> findById(Model model) {
        List<Classes> classesList = classesService.getFiveClasses();
        model.addAttribute("classeslist",classesList);
        return classesList;
    }


    /**
     * 柱状图的数据
     * @param
     * @param
     * @return
     */
    @GetMapping("/classeslist1")
    public void classeslist1(Model model)
    {
//        List<Classes> classesList=classesService.getFiveClasses();

    }
    @RequestMapping("/classeslist1")
    @ResponseBody
    public List<Classes> findById1(Model model) {
        List<Classes> classesList1= classesService.getQUClasses();
        model.addAttribute("classeslist1",classesList1);
        return classesList1;
    }

    /**
     * 根据id查询
     * @param id
     * @param session
     * @return
     */
    @GetMapping("/classesal/{id}")
    public String classesall(@PathVariable("id") Integer id, HttpSession session){
        List<Graduates> graduatesListbyclassid = graduatesService.getGraduatesByClass(id);
        session.setAttribute("graduatesListbyclassid",graduatesListbyclassid);
        session.setAttribute("classNum",classesService.getClassesById(id).getClassNum());
        return "redirect:/toclassesall";
    }

    /**
     * 拆查询全部
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("toclassesall")
    public String toclassesall(Model model,HttpSession session){
        List<Graduates> graduatesListbyclassid = (List<Graduates>)session.getAttribute("graduatesListbyclassid");
        Integer classnum = (Integer) session.getAttribute("classNum");
        model.addAttribute("graduatesclassid",graduatesListbyclassid);
        model.addAttribute("classnum",classnum);
        return "classesall";
    }

    //展示柱状图
    @RequestMapping( "/showbar1")
    public String show2() {

        return "bar";
    }

    //展示饼图
    @RequestMapping( "/classeslistpie1")
    public String show3() {

        return "pie";
    }
    //展示折线图
    @RequestMapping( "/showline1")
    public String show4() {
        return "line";
    }




}
