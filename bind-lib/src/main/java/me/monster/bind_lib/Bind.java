package me.monster.bind_lib;

import android.app.Activity;
import android.util.Log;

import java.lang.reflect.Field;

/**
 * @description
 * @author: Created jiangjiwei in 2019-10-26 16:47
 */
public class Bind {
    private static final String TAG = "Bind";

    public static void bind(Activity activity) {
        // 获取所有的 public 变量
        for (Field field : activity.getClass().getFields()) {
            Log.d(TAG, "getFields: field name: " + field.getName());
            BindView annotation = field.getAnnotation(BindView.class);
            if (annotation != null) {
                Log.e(TAG, "bind: " + annotation.value());
            }
        }
        // 获取开发者声明的变量
        for (Field field : activity.getClass().getDeclaredFields()) {
            Log.d(TAG, "getDeclaredFields: field name: " + field.getName());
            BindView annotation = field.getAnnotation(BindView.class);
            if (annotation != null) {
                try {
                    field.setAccessible(true);
                    field.set(activity, activity.findViewById(annotation.value()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
