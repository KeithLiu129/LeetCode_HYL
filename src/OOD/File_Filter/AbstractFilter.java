package OOD.File_Filter;

/**
 * ${Description}
 *
 * @author KeithLiu on 2020-04-11
 */

public interface AbstractFilter {
    abstract boolean filter(FilterParam param, File file);

}
