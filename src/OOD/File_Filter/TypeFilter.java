package OOD.File_Filter;

/**
 * ${Description}
 *
 * @author KeithLiu on 2020-04-11
 */

public class TypeFilter implements AbstractFilter{
    @Override
    public boolean filter(FilterParam param, File file){
        return file.endWith(param.getType());
    }

}
