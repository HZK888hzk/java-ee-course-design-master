package nuc.edu.employmentservices.service;

import nuc.edu.employmentservices.dao.DirectionMapper;
import nuc.edu.employmentservices.dao.JobsMapper;
import nuc.edu.employmentservices.enity.Direction;
import nuc.edu.employmentservices.enity.Jobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobsService {
    @Autowired
    private JobsMapper jobsMapper;
    public List<Jobs> getAllJobs()
    {
        List<Jobs> jobs=jobsMapper.getAllJobs();
        return jobs;
    }
    public Jobs getJobsById(Integer jobId)
    {
        Jobs jobs=jobsMapper.getJobsById(jobId);
        return  jobs;
    }
}
