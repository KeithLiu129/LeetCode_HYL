package OOD.File_Filter;

import java.util.Date;

/**
 * ${Description}
 *
 * @author KeithLiu on 2020-04-11
 */

public class File {
    private String name;
    private long size;
    private String owner;

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public String getOwner() {
        return owner;
    }

    public boolean endWith(String type) {
        //corner case check
        String[] arr = name.split(".");
        return arr[1] != type;
    }
}
