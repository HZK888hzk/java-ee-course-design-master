package nuc.edu.employmentservices.service;

import nuc.edu.employmentservices.dao.ContantMapper;
import nuc.edu.employmentservices.enity.Contant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContantService{

    @Autowired
    private ContantMapper contantMapper;

    public List<Contant> getAll() {
        return contantMapper.getAll();
    }           //为了让service调用

    public Contant getClassesById(Integer contantId) {
        return contantMapper.getClassesById(contantId);
    }

    public void delete(Integer contanId) {
        contantMapper.delete(contanId);
    }

    public void update(Contant contant) {
        contantMapper.update(contant);
    }

    public void insert(Contant contant) {
        contantMapper.insert(contant);
    }

    public Integer getClassCount() {
        return contantMapper.getClassCount();
    }


    public  List<Contant> getCkgg (Contant contant)
    {
        return contantMapper.getCkgg(contant);
    }
}
