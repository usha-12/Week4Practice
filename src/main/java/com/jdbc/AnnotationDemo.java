package com.jdbc;

import java.lang.annotation.*;
/*
 *     Create annoation
 *  Use annoation     @Annoation
 *  Extracting Annoation data => country + GST
 *
 */
/************
 * @Author
 *
 */

@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@interface companyInfo {
    String country() default "India";

    String GST()  default "XYZ";
}

@companyInfo(country="India",GST="2SDGDFGFDG34")
//@companyInfo
// @data
// @sample              // India , XYZ
class Company {
    int noOfEmployees; // 0
}

public class AnnotationDemo {
    public static void main(String[] args) {
        Company company = new Company();
       // company.noOfEmployees=100;
        Class c = company.getClass();
        Annotation annotation = c.getAnnotation(companyInfo.class);
        companyInfo comp = (companyInfo) annotation;
        System.out.println(comp.country());
        System.out.println(comp.GST());
        //System.out.println(company.noOfEmployees = 100);
        System.out.println(company.noOfEmployees);

    }

}