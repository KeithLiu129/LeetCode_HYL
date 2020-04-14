package OOD.File_Filter;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * ${Description}
 *
 * @author KeithLiu on 2020-04-12
 */

public class FileFilter {

    public static void main(String[] args){
        AbstractFilter typeFilter = new TypeFilter();
        AbstractFilter sizeFilter = new SizeFilter();

        FilterParam filterParam = new FilterParam("PlaySnake", 10, "Java", "snake", new Date());
        //b || c
        FilterTreeNode filterRoot = new FilterTreeNode(Operator.OR, null, filterParam);
        FilterTreeNode left = new FilterTreeNode(null, sizeFilter, filterParam);
        FilterTreeNode right = new FilterTreeNode(null, typeFilter, filterParam);
        filterRoot.left = left;
        filterRoot.right = right;

        List<File> fileList = new LinkedList<>(); //get from frontend
        List<File> res = new LinkedList<>();
        FileFilter fileFilter = new FileFilter();
        for(File file : fileList) {
            if (fileFilter.evaluate(filterRoot, file)) {
                res.add(file);
            }
        }

        System.out.println(res.size());
    }

    public boolean evaluate(FilterTreeNode root, File file){
        if (root == null) {
            return true;
        }

        if (root.operator != null) {
            boolean left = evaluate(root.left, file);
            boolean right = evaluate(root.right, file);
            return root.operator.operate(left, right);
        }

        if (root.abstractFilter != null) {
            return root.abstractFilter.filter(root.filterParam, file);
        }

        throw new IllegalStateException();
    }
}
