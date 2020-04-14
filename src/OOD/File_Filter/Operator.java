package OOD.File_Filter;

/**
 * ${Description}
 *
 * @author KeithLiu on 2020-04-11
 */

public enum Operator {
    AND {
        public boolean operate(boolean b1, boolean b2) {
            return b1 && b2;
        }
    },
    OR{
        public boolean operate(boolean b1, boolean b2) {
            return b1 || b2;
        }
    };

    public abstract boolean operate(boolean b1, boolean b2);


}
