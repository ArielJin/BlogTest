package me.monster.bind_lib;

import android.app.Activity;
import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @description
 * @author: Created jiangjiwei in 2019-10-26 16:47
 */
public class Bind {
    private static final String TAG = "Bind";

    public static void bind(Activity activity) {
        try {
            Class bindClass = Class.forName(activity.getClass().getCanonicalName() + "Binding");
            Class activityClass = Class.forName(activity.getClass().getCanonicalName());
            Constructor constructor = bindClass.getDeclaredConstructor(activityClass);
            constructor.newInstance(activity);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
