package OOD.File_Filter;

/**
 * ${Description}
 *
 * @author KeithLiu on 2020-04-12
 */

public class SizeFilter implements AbstractFilter{
    @Override
    public boolean filter(FilterParam param, File file){
        return file.getSize() == param.getSize();
    }
}
