package nuc.edu.employmentservices.dao;

import nuc.edu.employmentservices.enity.Jobs;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JobsMapper {

    /**
     * 查询所有的岗位信息
     * @return
     */
    public List<Jobs> getAllJobs();

    /**
     * 通过岗位ID查询岗位信息
     * @param jobId
     * @return
     */
    public Jobs getJobsById(Integer jobId);


}
