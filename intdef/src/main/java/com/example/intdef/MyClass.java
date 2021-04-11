package com.example.intdef;


import androidx.annotation.DrawableRes;
import androidx.annotation.IntDef;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 项目名称 AnnotationTest
 * 创建人 xiaojinli
 * 创建时间 2020/7/9 1:10 PM
 **/
public class MyClass {

    public static void main(String[] args){
        MyClass myClass = new MyClass();

        myClass.havePet(DOG);
//        myClass.havePet(TIGER); //

    }

    private static final int DOG = 0;
    private static final int CAT = 1;
    private static final int TIGER = 2;

    @IntDef({DOG,CAT}) //限定两个值
    @Target({ElementType.PARAMETER,ElementType.FIELD})
    @Retention(RetentionPolicy.SOURCE)
    @interface pet{

    }

    @pet
    private int myPet;

    /**
     * 用pet注解修饰后，该方法就只能接收由pet注解限定的两个参数值，
     * 如果传入其他的数值，会出现警告
     * @param pet
     */
    public void havePet(@pet int pet){
        myPet = pet;
    }

    //使用系统已经定义的注解
    /**
     * 只能传入drawable资源ID
     * @param id
     */
    public void haveDraw(@DrawableRes int id){

    }
}
