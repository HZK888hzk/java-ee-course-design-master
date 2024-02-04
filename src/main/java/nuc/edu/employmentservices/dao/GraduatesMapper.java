package nuc.edu.employmentservices.dao;

import nuc.edu.employmentservices.enity.Graduates;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GraduatesMapper {
    /**
     * 查询所有的毕业生信息
     * @return
     */
    public List<Graduates> getAllGraduates();

    /**查询未审核的信息
     *
     * @return
     */
    public List<Graduates> getWtj();
    public List<Graduates> getWt(Integer garid);


    /**
     * 通过Id查询毕业生的信息
     * @param graID
     * @return
     */
    public Graduates getGraduatesById(Integer graID);

    /**
     * 通过id查找未通过审批的学生。
     * @param
     * @return
     */
    public Graduates getWtjByid(Integer graIgetAllGraduatesD);
    /**
     * 通过Id查询毕业生的信息
     * @param graClassId
     * @return
     */
    public Graduates getGraduatesByClassId(Integer graClassId);

    /**
     * 通过Id查询毕业生的信息
     * @param graClassId
     * @return
     */
    public List<Graduates> getGraduatesByClass(Integer graClassId);

    /**
     * 通过企业Id查询毕业生的信息
     * @param comId
     * @return
     */
    public List<Graduates> getGraduatesByCompany(Integer comId);

    /**
     * 通过方向查询毕业生
     */
    public  List<Graduates> getGraduatesByDirection(Integer dirId);

    /**
     * 增加毕业生信息
     * @param graduates
     */
    public void insertGraduates(Graduates graduates);

    /**
     * 通过Id删除毕业生信息
     * @param graId
     */
    public void deleteGraduates(Integer graId);

    /**
     * 修改毕业生信息
     * @param graduates
     */
    public void updateGraduatesById(Graduates graduates);

    /**
     * 修改状态
     * @param graduates
     */
    public void updateById(Graduates graduates);
    /**
     * 统计毕业生人数
     */
    public Integer Getgranum();

    /**
     * 就业信息查询
     * @param graduates
     */
    public List<Graduates> select(Graduates graduates);

    /**
     * 薪资的统计 柱状图
     */
    public List<Graduates> getSalary();

    /**
     * 饼状图
     * @return
     */
    public List<Graduates> getASalary();


    /**
     * 地区的柱状图
     */
    public List<Graduates> getRegion();

    /**
     * 地区的饼状图
     */
    public List<Graduates> getARegion();
}
