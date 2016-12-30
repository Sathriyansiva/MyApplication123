package com.example.vcssolution.myapplication123;

/**
 * Created by VCSSolution on 12/29/2016.
 */

public class Samplepojo {
    String s1, s2, s3;

    public String getS1() {

        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }


    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

    public String getS3() {
        return s3;
    }

    public void setS3(String s2) {
        this.s3 = s2;
    }
    public Samplepojo(String id,String name,String email)
    {
        this.s1 = id;
        this.s2 = name;
        this.s3 = email;
    }
}
