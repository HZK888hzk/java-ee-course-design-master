package nuc.edu.employmentservices.enity;

import java.util.List;


public class Classes {//班级类
    private Integer classId;//班级的ID
    private Integer classNum;//班级的编号
    private List<Graduates> graduatesList;//班级中所有的毕业生信息

    private Integer count;      //班级的总人数
    private Integer classcount;//班级中的人数
    @Override
    public String toString() {
        return "Classes{" +
                "classId=" + classId +
                ", classNum=" + classNum +
                ", graduatesList=" + graduatesList +
                ", count=" + count +
                ", classcount=" + classcount +
                '}';
    }

    public Classes() {
    }

    public Classes(Integer classId, Integer classNum, List<Graduates> graduatesList, Integer count, Integer classcount) {
        this.classId = classId;
        this.classNum = classNum;
        this.graduatesList = graduatesList;
        this.count = count;
        this.classcount = classcount;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getClassNum() {
        return classNum;
    }

    public void setClassNum(Integer classNum) {
        this.classNum = classNum;
    }

    public List<Graduates> getGraduatesList() {
        return graduatesList;
    }

    public void setGraduatesList(List<Graduates> graduatesList) {
        this.graduatesList = graduatesList;
    }

    public Integer getClasscount() {
        return classcount;
    }

    public void setClasscount(Integer classcount) {
        this.classcount = classcount;
    }



}
