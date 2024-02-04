package nuc.edu.employmentservices.controller;

import nuc.edu.employmentservices.enity.Company;
import nuc.edu.employmentservices.enity.Graduates;
import nuc.edu.employmentservices.enity.Jobs;
import nuc.edu.employmentservices.service.CompanyService;
import nuc.edu.employmentservices.service.GraduatesService;
import nuc.edu.employmentservices.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private GraduatesService graduatesService;

    @Autowired
    private JobsService jobsService;

    /**
     * 根据id获得
     * @param comId
     * @param session
     * @return
     */
    @GetMapping("/getCompanyById/{comId}")
    public String getCompanyById(@PathVariable("comId") Integer comId,HttpSession session){
        Company company=companyService.getCompanyById(comId);
        session.setAttribute("company",company);
        List<Jobs> jobsList = jobsService.getAllJobs();
        session.setAttribute("jobsList",jobsList);
        return "redirect:/updateCompany";
    }

    /**
     * 修改公司信息
     * @return
     */
    @GetMapping("/updateCompany")
    public String toupdateCompany()
    {
        return "updateCompany";
    }

    @GetMapping("/companyall/{id}")
    public String companyall(@PathVariable("id") Integer id, HttpSession session){
        List<Graduates> graduatesListbycomid =graduatesService.getGraduatesByCompany(id);
        System.out.println(graduatesListbycomid);
        session.setAttribute("graduatesListbycomid",graduatesListbycomid);
        String  comName = companyService.getCompanyById(id).getComName();
        session.setAttribute("comNum",companyService.getCompanyById(id).getComName());

        return "redirect:/tocompanyall";
    }

    @RequestMapping("tocompanyall")
    public String tocompanyall(Model model,HttpSession session){
        List<Graduates> graduatesListbycomid = (List<Graduates>)session.getAttribute("graduatesListbycomid");
        String comName = (String)session.getAttribute("comNum");
        model.addAttribute("graduatesListbycomid",graduatesListbycomid);
        model.addAttribute("comName",comName);
        return "companyall";
    }
    //到添加界面
    @GetMapping("/toaddcompany")
    public String toaddcompany(Model model)
    {
        List<Jobs> jobsList = jobsService.getAllJobs();
        model.addAttribute("jobsList",jobsList);

        return "toaddcompany";
    }

    //添加公司操作
    @PostMapping("/addcompany")
    public String addcompany(Company company)
    {
        companyService.insertCompany(company);
        return "redirect:/companylist";
    }
    //删除公司操作
    @GetMapping("/deleteCompany/{comId}")
    public String deleteCompany(@PathVariable("comId")  Integer comId)
    {
        companyService.deleteCompany(comId);
        return "redirect:/companylist";
    }
    @PostMapping("/updateCompany")
    public String updateCompany(Company company)
    {
            companyService.updateCompany(company);
            return "redirect:/companylist";
    }

    /**
     * 查询前五条的就业信息
     */

   @GetMapping("/companyshow")
    public void companylist(Model model)
    {}

    @RequestMapping ("/companyshow")
    @ResponseBody
    public List<Company> getCompanyById(Model model) {
        List<Company> companyshow = companyService.getFiveCompany();
        model.addAttribute("companyshow",companyshow);
        return companyshow;
    }

    /***
     * 柱状图
     * @return
     */

    @GetMapping("/companyshow1")
    public void companylist1(Model model)
    {}

    @RequestMapping ("/companyshow1")
    @ResponseBody
    public List<Company> getCompanyById1(Model model) {
        List<Company> companyshow1 = companyService.getQUCompany();
        model.addAttribute("companyshow1",companyshow1);
        return companyshow1;
    }


    //展示柱状图
    @RequestMapping( "/showbar2")
    public String show2() {

        return "bar";
    }

    //展示饼图
    @RequestMapping( "/companyshowshowpie2")
    public String show3() {

        return "pie";
    }
    //展示折线图
    @RequestMapping( "/showline2")
    public String show4() {
        return "line";
    }


}
