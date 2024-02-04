package nuc.edu.employmentservices.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Direction {//方向
    private Integer dirID;//方向编号
    private String dirName;//方向的名字
    private List<Graduates> gralist;

    private Integer directionnum;//方向的人数

    public Integer getDirID() {
        return dirID;
    }

    public void setDirID(Integer dirID) {
        this.dirID = dirID;
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    public List<Graduates> getGralist() {
        return gralist;
    }

    public void setGralist(List<Graduates> gralist) {
        this.gralist = gralist;
    }

    public Integer getDirectionnum() {
        return directionnum;
    }

    public void setDirectionnum(Integer directionnum) {
        this.directionnum = directionnum;
    }
}
