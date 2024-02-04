package nuc.edu.employmentservices.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jobs {//职务类
    private Integer jobId;//职务的ID
    private String jobName;//岗位名称
    private String jobDe;//岗位要求

    @Override
    public String toString() {
        return "Jobs{" +
                "jobId=" + jobId +
                ", jobName='" + jobName + '\'' +
                ", jobDe='" + jobDe + '\'' +
                '}'+"\n";
    }
}
