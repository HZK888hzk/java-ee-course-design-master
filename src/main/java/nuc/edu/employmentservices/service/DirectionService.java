package nuc.edu.employmentservices.service;

import nuc.edu.employmentservices.dao.DirectionMapper;
import nuc.edu.employmentservices.enity.Direction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectionService {
    @Autowired
    private DirectionMapper directionMapper;


    /**
     * 获得所有的学生信息
     * @return
     */
    public List<Direction> getAllDirection()
    {
        List<Direction>  directions=directionMapper.getAllDirection();
        return directions;
    }



    public Direction getDirectionById(Integer dirID)
    {
        Direction direction=directionMapper.getDirectionById(dirID);
        return  direction;
    }

    public Direction getDirectionGraById(Integer dirID)
    {
        return directionMapper.getDirectionGraById(dirID);
    }

    public Integer getDirectionCount()
    {
        return directionMapper.getDirectionCount();
    }

    public List<Direction> getDirectionNums()
    {
        List<Direction> directionList=directionMapper.getDirectionNums();
        return directionList;
    }
}
