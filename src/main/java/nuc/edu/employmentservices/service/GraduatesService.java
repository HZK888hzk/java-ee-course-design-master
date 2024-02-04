package nuc.edu.employmentservices.service;

import nuc.edu.employmentservices.dao.GraduatesMapper;
import nuc.edu.employmentservices.enity.Graduates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.List;

@Controller
public class GraduatesService {
    @Autowired
    private GraduatesMapper graduatesMapper;


    public List<Graduates> getAllGraduates()
    {
        List<Graduates> graduates=graduatesMapper.getAllGraduates();
        return graduates;
    }

    /**
     * 获得未审核的信息
     *
     * @return
     */
    public List<Graduates> getWtj()
    {
        List<Graduates> graduates=graduatesMapper.getWtj();
        return graduates;
    }
    public List<Graduates> getWt(Integer garid)
    {
        List<Graduates> graduates=graduatesMapper.getWt(garid);
        return graduates;
    }
    /*
          毕业生信息修改
   */
    public Graduates getGraduatesById(Integer graID)
    {
        Graduates graduates=graduatesMapper.getGraduatesById(graID);
        System.out.println(graduates);
        return  graduates;
    }

    /**
     * 通过id查找毕业生的信息
     * @param graID
     * @return
     */
    public Graduates getWtjByid(Integer graID)
    {
        Graduates graduates=graduatesMapper.getWtjByid(graID);
        System.out.println(graduates);
        return  graduates;
    }


    public Graduates getGraduatesByClassId(Integer graClassId){
        Graduates graduates=graduatesMapper.getGraduatesByClassId(graClassId);
        return  graduates;
    }


    public  void insertGraduates(Graduates graduates) throws ParseException {

        graduatesMapper.insertGraduates(graduates);
    }


    public  void deleteGraduates(Integer graID){

        graduatesMapper.deleteGraduates(graID);
    }


    public  void updateGraduatesById(Graduates graduates){
        graduatesMapper.updateGraduatesById(graduates);
    }


    public  void updateById(Graduates graduates){
        graduatesMapper.updateById(graduates);
    }

    public Integer Getgranum()
    {
        return graduatesMapper.Getgranum();

    }

    public List<Graduates> getGraduatesByClass(Integer graClassId){
        return graduatesMapper.getGraduatesByClass(graClassId);
    }

    public List<Graduates> getGraduatesByCompany(Integer comId){
        return graduatesMapper.getGraduatesByCompany(comId);
    }

    public  List<Graduates> getGraduatesByDirection(Integer dirId)
    {
        return graduatesMapper.getGraduatesByDirection(dirId);
    }

    /**
     * 导航栏的查询
     * @param graduates
     * @return
     */
    public  List<Graduates> getSelect(Graduates graduates)
    {
        System.out.println(graduates.getCompany().getComName()+"bbbbbbbbbbbb");
//        return graduatesMapper.select(graduates);
        List<Graduates> getSelect = graduatesMapper.select(graduates);
        return getSelect;
    }


    /**
     * 薪资的统计饼状图
     */
    public List<Graduates> getSalary(){
        List<Graduates> salary = graduatesMapper.getSalary();
        return salary;
    }
    /**
     * 薪资统计的柱状图
     */
    public List<Graduates> getASalary(){
        List<Graduates> allSalary = graduatesMapper.getASalary();
        return  allSalary;
    }


    /***
     * 地区的饼状图
     */
    public List<Graduates> getRegion(){
        List<Graduates> region = graduatesMapper.getRegion();
        return region;
    }
    /**
     * 地区的柱状图
     */

    public List<Graduates> getARegion(){
        List<Graduates> aRegion = graduatesMapper.getARegion();
        return aRegion;
    }
}
