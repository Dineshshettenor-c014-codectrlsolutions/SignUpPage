package com.example.signuppage;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText phoneNumber;
    EditText email;
    EditText password;
    EditText cnfPassword;
    EditText reffCode;

    CheckBox checkBox;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btn);
        firstName = findViewById(R.id.fname);
        lastName = findViewById(R.id.lname);
        phoneNumber = findViewById(R.id.phno);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        cnfPassword = findViewById(R.id.cnfpassword);
        reffCode = findViewById(R.id.reffcode);
        checkBox = findViewById(R.id.check);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                checkDataEntered();
                Toast.makeText(MainActivity.this, "SignUp Successfull", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void checkDataEntered(){
        if(isEmpty(firstName)){
            Toast.makeText( this, "You must enter the first name ", Toast.LENGTH_SHORT).show();
        }
        if(isEmpty(lastName)){
            Toast.makeText( this, "You must enter the last name ", Toast.LENGTH_SHORT).show();
        }

        isPhonenumber(phoneNumber);

        isEmail(email);

        isPassword(password,cnfPassword);

        if(!checkBox.isChecked()){
            Toast.makeText( this, "Please accept the Terms and Conditions ", Toast.LENGTH_SHORT).show();
        }

    }
    boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    void isPhonenumber(EditText number){
        String MobilePattern = "[0-9]{10}";
        if(!number.getText().toString().matches(MobilePattern))
        {
            Toast.makeText(getApplicationContext(), "Please enter valid 10 digit phone number", Toast.LENGTH_SHORT).show();
        }
    }
    void isEmail(EditText text){
        String regex = "^(.+)@(.+)$";
        if(!text.getText().toString().matches(regex)) {
            Toast.makeText(getApplicationContext(), "Please enter valid email Address", Toast.LENGTH_SHORT).show();
        }
    }
    void isPassword(EditText password,EditText cnfPassword) {
//        Log.d(TAG, "isPassword: "+cnfPassword);
        if (password.length() < 6 && password.length() > 12) {
            Toast.makeText(getApplicationContext(), "Password shoud be between 6 to 12 only", Toast.LENGTH_SHORT).show();
        }
//        if (!password.toString().equals(cnfPassword.toString())){
//            Toast.makeText(getApplicationContext(), "Password not Matched ", Toast.LENGTH_SHORT).show();
//        }
    }
}