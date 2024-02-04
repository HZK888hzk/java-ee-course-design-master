package nuc.edu.employmentservices.enity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class User {//登录用户
    private Integer userId;//登录用户ID
    private String userName;//登录用户的名字
    private String useraccount;//登录用户的账户
    private String userPassword;//登录用户的密码
    private Integer types;//登录用户的类别(0-管理员 1-毕业生 2-超级管理员）
    private Integer graID;//毕业生的ID（管理员为空）
    private Company company;
    private  Company comAddress;   //就业的地区

    public User(Integer userId, String userName, String useraccount, String userPassword, Integer types, Integer graID, Company company, Company comAddress) {
        this.userId = userId;
        this.userName = userName;
        this.useraccount = useraccount;
        this.userPassword = userPassword;
        this.types = types;
        this.graID = graID;
        this.company = company;
        this.comAddress = comAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", useraccount='" + useraccount + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", types=" + types +
                ", graID=" + graID +
                ", company=" + company +
                ", comAddress=" + comAddress +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getTypes() {
        return types;
    }

    public void setTypes(Integer types) {
        this.types = types;
    }

    public Integer getGraID() {
        return graID;
    }

    public void setGraID(Integer graID) {
        this.graID = graID;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getComAddress() {
        return comAddress;
    }

    public void setComAddress(Company comAddress) {
        this.comAddress = comAddress;
    }
}
