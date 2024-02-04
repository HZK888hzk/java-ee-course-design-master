package nuc.edu.employmentservices.controller;

import nuc.edu.employmentservices.enity.Direction;
import nuc.edu.employmentservices.enity.Graduates;
import nuc.edu.employmentservices.service.DirectionService;
import nuc.edu.employmentservices.service.GraduatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DirectionController {
    @Autowired
    private DirectionService directionService;

    @Autowired
    private GraduatesService graduatesService;


    @GetMapping("/directionlist")
    public String directionlist(Model model)
    {
        List<Direction> directionNums=directionService.getAllDirection();
        Integer num=directionService.getDirectionCount();
        model.addAttribute("directionnum",num);
        model.addAttribute("directionNums",directionNums);
        return "directionlist";
    }

    @GetMapping("/getdirectionall/{dirId}")
    public String directionall(@PathVariable("dirId") Integer dirId, HttpSession session){
        List<Graduates> graduatesList=graduatesService.getGraduatesByDirection(dirId);
        session.setAttribute("graduatesList",graduatesList);
        String directionName=directionService.getDirectionById(dirId).getDirName();
        System.out.println(directionName);
        session.setAttribute("directionName",directionName);
        return "redirect:/todirectionall";
    }

    @RequestMapping("/todirectionall")
    public String todirectionall(Model model,HttpSession session){
        List<Graduates> graduatesList=(List<Graduates>)session.getAttribute("graduatesList");
        String directionName=(String)session.getAttribute("directionName");
        model.addAttribute("graduatesList",graduatesList);
        model.addAttribute("directionName",directionName);
        return "directionall";
    }



}
