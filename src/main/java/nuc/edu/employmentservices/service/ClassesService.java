package nuc.edu.employmentservices.service;

import nuc.edu.employmentservices.dao.ClassesMapper;
import nuc.edu.employmentservices.enity.Classes;
import nuc.edu.employmentservices.enity.Graduates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesService {

    @Autowired
    private ClassesMapper classesMapper;
    /*查询所有用户*/
    public List<Classes> getAllClasses(){
        List<Classes> classes = classesMapper.getAllClasses();
        return classes;
    }

    public Classes getClassesById(Integer classId){
        return  classesMapper.getClassesById(classId);
    }


    public List<Graduates> getGraduatesByClasses(Integer classId){

        List<Graduates> graduatesList=classesMapper.getGraduatesByClasses(classId);

        return graduatesList;
    }

    /**
     *
     * @return
     */
    public List<Classes> getClassesNums(){
        List<Classes> classesList=classesMapper.getClassesNums();
        return classesList;
    }


    /**
     * 饼图所用的数据
     * @return
     */
    public List<Classes> getFiveClasses(){
        List<Classes> classes = classesMapper.getFiveClasses();
        return classes;
    }

    /**
     * 柱状图的数据
     * @return
     */

    public List<Classes> getQUClasses(){
        List<Classes> classes = classesMapper.getQUClasses();
        return classes;
    }

}
