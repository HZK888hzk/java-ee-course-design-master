package nuc.edu.employmentservices.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Graduates {//毕业生类
    private Integer graID;//毕业生编号
    private String graSex;//毕业生的性别
    private long graTel;//毕业生的电话
//    private Integer graClassId;//毕业生的班级编号
    private  Classes classes;//毕业生对应的班级
    private Date graTime;//毕业生就业时间
//    private Integer graComId;//毕业生公司编号
    private Company company;//毕业之后到的公司
//    private Integer graDirId;//毕业生方向编号
    private Direction direction;//毕业生对应的方向
    private String graSalary;//毕业生工资
    private String num;     //统计工资的数量
    private User user;//用户信息
    private String num1;    //地区的统计
    private  Company comAddress;   //就业的地区
    private  Contant type;
    private Contant title;
    private  String status = "0";    //审核的状态

    private String gracomAdd;

    public Integer getGraID() {
        return graID;
    }

    public void setGraID(Integer graID) {
        this.graID = graID;
    }

    public String getGraSex() {
        return graSex;
    }

    public void setGraSex(String graSex) {
        this.graSex = graSex;
    }

    public long getGraTel() {
        return graTel;
    }

    public void setGraTel(long graTel) {
        this.graTel = graTel;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Date getGraTime() {
        return graTime;
    }

    public void setGraTime(Date graTime) {
        this.graTime = graTime;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String getGraSalary() {
        return graSalary;
    }

    public void setGraSalary(String graSalary) {
        this.graSalary = graSalary;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public Company getComAddress() {
        return comAddress;
    }

    public void setComAddress(Company comAddress) {
        this.comAddress = comAddress;
    }

    public Contant getType() {
        return type;
    }

    public void setType(Contant type) {
        this.type = type;
    }

    public Contant getTitle() {
        return title;
    }

    public void setTitle(Contant title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGracomAdd() {
        return gracomAdd;
    }

    public void setGracomAdd(String gracomAdd) {
        this.gracomAdd = gracomAdd;
    }
}
