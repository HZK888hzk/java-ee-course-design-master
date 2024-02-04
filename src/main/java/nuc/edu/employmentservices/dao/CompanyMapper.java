package nuc.edu.employmentservices.dao;

import nuc.edu.employmentservices.enity.Company;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyMapper {

    /**
     * 查询所有的公司信息
     * @return
     */
    public List<Company> getAllCompany();
    /**
     * 查询前五条数据
     */
    public List<Company> getFiveCompany();

    /**
     * 柱状图
     */
    public List<Company> getQUCompany();

    /**
     * 通过ID查询公司信息
     * @param comId
     * @return
     */
    public Company getCompanyById(Integer comId);

    /**
     * 通过公司id查公司的毕业生
     */
    public Company getCompanyGraById(Integer comId);

    /**
     * 查询各个公司的人数
     * @return
     */
    public List<Company> getCompanyNums();

    /**
     * 查询数据库中一共有几条数据
     * @return
     */
    public Integer getCompanyCount();

    /**
     * 添加公司
     */
     public void insertCompany(Company company);

    /***
     * 删除公司
     */
    public void deleteCompany(Integer comId);
    /**
     * 修改公司
     */
    public void updateCompany(Company company);



    public Integer getCompanycomCount();


    List<Company> comCountList();

    /*
     * 增加保存用户
     */
    void save(Company Company);

    /*
     * 根据id删除用户
     */
    int delete(Integer id);

    /*
     * 根据id查找用户
     */
    Company findUserById(int id);

}
