package com.mycompany.app;

import java.util.TreeSet;

public class Transition {

    public Slide left;
    public Slide right;

    public Transition(Slide left, Slide right) {
        this.left = left;
        this.right = right;
    }

    public int score(){
        TreeSet<String> leftNotRight = new TreeSet<>(this.left.tags());
        leftNotRight.removeAll(this.right.tags());

        TreeSet<String> rightNotLeft = new TreeSet<>(this.right.tags());
        rightNotLeft.removeAll(this.left.tags());

        TreeSet<String> leftAndRight = new TreeSet<>(this.left.tags());
        leftAndRight.retainAll(this.right.tags());

        return Math.min(leftNotRight.size(), Math.min(leftAndRight.size(), rightNotLeft.size()));
    }
}
