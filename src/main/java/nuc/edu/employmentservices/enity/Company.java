package nuc.edu.employmentservices.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private Integer comId;//公司的ID
    private String comName;//公司的名字
    private String comMeg;//公司的简介
   private String comAddress;//公司的地址
    private String comHr;//公司联系人
    private Integer comHrTel;//公司联系人电话
    private Integer comJobId;//公司岗位id
    Jobs jobses; //公司对应的多个岗位
    private List<Graduates> gralist;

    private Integer comCount;//公司中的人数
    private Integer comcount;
    private  String count;
    @Override
    public String toString() {
        return "Company{" +
                "comId=" + comId +
                ", comName='" + comName + '\'' +
                ", comMeg='" + comMeg + '\'' +
                ", comAddress='" + comAddress + '\'' +
                ", comHr='" + comHr + '\'' +
                ", comHrTel=" + comHrTel +
                ", comJobId=" + comJobId +
                ", jobses=" + jobses +
                ", gralist=" + gralist +
                ", comCount=" + comCount +
                '}';
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComMeg() {
        return comMeg;
    }

    public void setComMeg(String comMeg) {
        this.comMeg = comMeg;
    }

    public String getComAddress() {
        return comAddress;
    }

    public void setComAddress(String comAddress) {
        this.comAddress = comAddress;
    }

    public String getComHr() {
        return comHr;
    }

    public void setComHr(String comHr) {
        this.comHr = comHr;
    }

    public Integer getComHrTel() {
        return comHrTel;
    }

    public void setComHrTel(Integer comHrTel) {
        this.comHrTel = comHrTel;
    }

    public Integer getComJobId() {
        return comJobId;
    }

    public void setComJobId(Integer comJobId) {
        this.comJobId = comJobId;
    }

    public Jobs getJobses() {
        return jobses;
    }

    public void setJobses(Jobs jobses) {
        this.jobses = jobses;
    }

    public List<Graduates> getGralist() {
        return gralist;
    }

    public void setGralist(List<Graduates> gralist) {
        this.gralist = gralist;
    }

    public Integer getComCount() {
        return comCount;
    }

    public void setComCount(Integer comCount) {
        this.comCount = comCount;
    }

    public Integer getComcount() {
        return comcount;
    }

    public void setComcount(Integer comcount) {
        this.comcount = comcount;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

}
