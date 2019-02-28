package hashcode.model;

import hashcode.model.Slide;

import java.util.TreeSet;

public final class Transition {

    public static int score(Slide left, Slide right){
        TreeSet<String> leftNotRight = new TreeSet<>(left.tags());
        leftNotRight.removeAll(right.tags());

        TreeSet<String> rightNotLeft = new TreeSet<>(right.tags());
        rightNotLeft.removeAll(left.tags());

        TreeSet<String> leftAndRight = new TreeSet<>(left.tags());
        leftAndRight.retainAll(right.tags());

        return Math.min(leftNotRight.size(), Math.min(leftAndRight.size(), rightNotLeft.size()));
    }
}