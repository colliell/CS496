package com.example.project.forrent;

/**
 * Created by Rex M Henzie on 5/26/2016.
 * Credit due: http://www.mkyong.com/java/java-md5-hashing-example/
 */

import java.util.Random;
import java.security.MessageDigest;

public class RandomEncrypt {

    private int randomNum;
    private String ePassword;
    private String dPassword;

    public RandomEncrypt(){
        randomNum = 0;
        dPassword = "default";
    }

    public int getRandomNum(){
        return randomNum;
    }

    public void setRandomNum(){
        Random rand = new Random();
        randomNum = rand.nextInt(32000);
    }

    public String getePassword(){
        return ePassword;
    }

    public void setePassword(String password){
        dPassword = password;
        ePassword = MD5HashingExample(dPassword);
    }

    public String MD5HashingExample(String password){
        MessageDigest md = null;
        StringBuffer hexString = new StringBuffer();
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte byteData[] = md.digest();
            for (int i = 0; i < byteData.length; i++) {
                String hex = Integer.toHexString(0xff & byteData[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return hexString.toString();
    }
}
