package nuc.edu.employmentservices.dao;

import nuc.edu.employmentservices.enity.User;
import nuc.edu.employmentservices.enity.View;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 查询所有的登录用户信息
     * @return
     */
    public List<User> getAllUsers();

    /**
     * 通过用户ID查询用户信息
     * @param userId
     * @return
     */
    public User getUserById(Integer userId);

    /**
     * 插入用户
     * @param user
     */
    public void insertUser(User user);

    /**
     * 修改用户信息
     * @param user
     */
    public void updateUserBy(User user);

    /**
     * 删除用户通过编号
     * @param userId
     */
    public void deleteUserById(Integer userId);

    /**
     * 统计用户人数
     * @return
     */
    public  Integer GetUserNum();

    /**
     * 通过用户类别查询对应用户
     * @param typeid
     * @return
     */
    public List<User> selectUserByType(Integer typeid);

    public void deleteUserByuserId(Integer userId);

    public void updateUserByuserid(User user);

    /**
     * echarts 展示
     * @return
     */

    public List<View> gather();

    /**
     * 柱状图
     * @return
     */
    public List<View> admins();
}
