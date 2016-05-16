package com.example.project.forrent;

/**
 * Created by Rex M Henzie on 5/16/2016.
 * Credit due: http://www.mkyong.com/java/java-md5-hashing-example/
 */
import android.content.Intent;
import java.security.NoSuchAlgorithmException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.EditText;
import java.util.Random;
import java.io.FileInputStream;
import java.security.MessageDigest;


public class RandomEncryptActivity extends AppCompatActivity{
    private FrameLayout layout;
    Random rand = new Random();
    private int randNumber = rand.nextInt(32000);
    //public EditText randNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_encrypt);
        Button encrypt = (Button) (this.findViewById(com.example.project.forrent.R.id.encrypt));
        EditText randNum = (EditText) findViewById(R.id.randNumber);
        encrypt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText password = (EditText) findViewById(R.id.password);
                String passString = password.getText().toString();
                passString = MD5HashingExample(passString);
                password.setText(passString);
            }
        });

        randNum.setText(String.valueOf(randNumber));
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
