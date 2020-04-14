package OOD.File_Filter;

import java.util.Date;

/**
 * ${Description}
 *
 * @author KeithLiu on 2020-04-11
 */

public class FilterParam {
    private String name;
    private int size;
    private Date createTime;
    private String owner;
    private String type;

    public FilterParam(String name, int size, String type, String owner, Date date){
        this.name = name;
        this.size = size;
        this.createTime = date;
        this.owner = owner;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getOwner() {
        return owner;
    }

    public String getType() {
        return type;
    }
}
