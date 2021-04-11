package com.example.inject;

import android.app.Activity;
import android.drm.DrmStore;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 项目名称 Annotation
 * 创建人 xiaojinli
 * 创建时间 2020/7/9 3:05 PM
 **/
public class InjectUtils {

    private static final String TAG = "InjectUtils";
    /**
     * 利用反射获取Activity的所有成员，筛选出被规定的注解修饰的变量，获取ID值，然后调用findViewById即可实例化View
     * @param activity
     */
    public static void injectView(Activity activity){
        Class<?> clazz = activity.getClass();
        //获取所有的Fields
        Field[] fields = clazz.getDeclaredFields();
        //遍历变量
        for (Field field : fields) {
            //判断变量是否被InjectView注解修饰
            if(field.isAnnotationPresent(InjectView.class)){
                InjectView injectView = field.getAnnotation(InjectView.class);
                int value = injectView.value();
                Log.d(TAG,"value = "  + value);
                try {
                    //方法1
//                    Method findViewById = clazz.getMethod("findViewById",int.class);
//                    findViewById.setAccessible(true);
//                    Object view = findViewById.invoke(activity,value);
//                    field.setAccessible(true);
//                    field.set(activity,view);
                    //方法2
                    Object view = activity.findViewById(value);
                    field.setAccessible(true);
                    field.set(activity,view);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
