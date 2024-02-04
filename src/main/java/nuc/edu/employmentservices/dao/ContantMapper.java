package nuc.edu.employmentservices.dao;

import nuc.edu.employmentservices.enity.Contant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ContantMapper {

    List<Contant> getAll();

    Contant getClassesById(Integer contantId);

    void delete(Integer contanId);

    void  update(Contant contant);

    void insert(Contant contant);

    Integer getClassCount();
    /**
     * 公告信息
     * @param
     */
     List<Contant> getCkgg(@Param(value = "contant") Contant contant);
}
