package me.monster.blogtest;

/**
 * @description
 * @author: Created jiangjiwei in 2019-10-26 16:28
 */
public class BindSampleBinding {
    public BindSampleBinding(BindSample activity) {
        activity.tvHello = activity.findViewById(R.id.tv_hello);
    }
}
