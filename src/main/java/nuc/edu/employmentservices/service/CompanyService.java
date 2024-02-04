package nuc.edu.employmentservices.service;

import nuc.edu.employmentservices.dao.CompanyMapper;
import nuc.edu.employmentservices.enity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyMapper companyMapper;


    public List<Company> getAllCompany(){
        List<Company> companyList = companyMapper.getAllCompany();
        return companyList;
    }

    /**
     * 查询前五条就业信息
     * @param
     * @return
     */
    public List<Company> getFiveCompany(){
        List<Company> companyList = companyMapper.getFiveCompany();
        return companyList;
    }

    /**
     * 柱状图
     * @param
     * @return
     */
    public List<Company> getQUCompany(){
        List<Company> companyList1 = companyMapper.getQUCompany();
        return companyList1;
    }


    public Company getCompanyById(Integer comId){
        return companyMapper.getCompanyById(comId);
    }

    //通过公司id查毕业生信息
    public Company getCompanyGraById(Integer comId)
    {
        return companyMapper.getCompanyGraById(comId);
    }

    public List<Company> getCompanyNums(){
        return companyMapper.getCompanyNums();
    }

    public Integer getCompanyCount(){
        return companyMapper.getCompanyCount();
    }

    public void insertCompany(Company company)
    {
        companyMapper.insertCompany(company);
    }

    public void deleteCompany(Integer comId)
    {
        companyMapper.deleteCompany(comId);
    }

    public void updateCompany(Company company)
    {
        companyMapper.updateCompany(company);
    }
}
