package OOD.File_Filter;

/**
 * ${Description}
 *
 * @author KeithLiu on 2020-04-11
 */

public class FilterTreeNode {
    Operator operator;
    FilterParam filterParam;
    AbstractFilter abstractFilter;
    FilterTreeNode left, right;

    public FilterTreeNode(Operator operator, AbstractFilter abstractFilter, FilterParam filterParam) {
        this.operator = operator;
        this.abstractFilter = abstractFilter;
        this.filterParam = filterParam;
    }
}
