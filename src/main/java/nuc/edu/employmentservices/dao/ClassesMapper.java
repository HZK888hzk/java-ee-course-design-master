package nuc.edu.employmentservices.dao;

import nuc.edu.employmentservices.enity.Classes;
import nuc.edu.employmentservices.enity.Graduates;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassesMapper {

    /**
     * 查询所有的班级
     * @return
     */
    public List<Classes> getAllClasses();

    /**
     * 饼状图的数据
     * @return
     */

    public List<Classes> getFiveClasses();
    /**
     * 通过ID查询班级号
     * @param classId
     * @return
     */
    public Classes getClassesById(Integer classId);

    public List<Graduates> getGraduatesByClasses(Integer classId);

    /**
     * 查询各个班级的人数
     * @return
     */
    public List<Classes> getClassesNums();

    /**
     * 柱状图的数据
     * @return
     */
    public List<Classes> getQUClasses();
    /**
     * 查询数据库中一共有几条数据
     * @return
     */
    public Integer getClassCount();


    List<Classes> classesList();

    /*
     * 增加保存用户
     */
    void save(Classes classes);

    /*
     * 根据id删除用户
     */
    int delete(Integer id);

    /*
     * 根据id查找用户
     */
    Classes findUserById(int id);




}
