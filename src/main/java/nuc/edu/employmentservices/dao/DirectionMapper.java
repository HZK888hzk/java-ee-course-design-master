package nuc.edu.employmentservices.dao;

import nuc.edu.employmentservices.enity.Direction;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DirectionMapper {

    /**
     * 查询所有的方向信息
     * @return
     */
    public List<Direction> getAllDirection();

    /**
     * 通过方向ID查询方向信息
     * @param dirID
     * @return
     */
    public Direction getDirectionById(Integer dirID);

    /**
     * 通过方向号进行查询毕业生
     */
    public Direction getDirectionGraById(Integer dirID);


    /***
     * 查询方向条数
     */
    public Integer getDirectionCount();

    /**
     * 查询各个方向有多少人
     */
    public List<Direction> getDirectionNums();
    /**
     * 薪资的统计
     */

}
