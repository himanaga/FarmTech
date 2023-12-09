package com.example.farmtech;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.hbb20.CountryCodePicker;

public class login extends AppCompatActivity {
    CountryCodePicker countryCodePicker;
    EditText phoneInput;
    Button sendOtpBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        countryCodePicker = findViewById(R.id.login_countrycode);
        phoneInput = findViewById(R.id.editTextPhone);
        sendOtpBtn = findViewById(R.id.button9);
        countryCodePicker.registerCarrierNumberEditText(phoneInput);
        sendOtpBtn.setOnClickListener((v)->{
            if(!countryCodePicker.isValidFullNumber()){
                phoneInput.setError("Phone number not valid");
                return;
            }

            Intent intent = new Intent(login.this,otp.class);
            intent.putExtra("phone",countryCodePicker.getFullNumberWithPlus());
            startActivity(intent);
        });
    }


}