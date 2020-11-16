package com.example.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnSubmit, btnCancel;
    private EditText etName, etAge, etPhone, etAddress;
    private RadioGroup rgGender; //性别
    private CheckBox cbSport, cbMusic, cbLetter, cbTravel;
    private TextView tvContent;
    private String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btnSubmit = findViewById(R.id.btn_submit);
        btnCancel = findViewById(R.id.btn_cancel);
        btnSubmit.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        etName = findViewById(R.id.et_name);
        etAge = findViewById(R.id.et_age);
        etPhone = findViewById(R.id.et_phone);
        etAddress = findViewById(R.id.et_address);

        rgGender = findViewById(R.id.rg_gender);

        cbSport = findViewById(R.id.cb_sport);
        cbMusic = findViewById(R.id.cb_music);
        cbLetter = findViewById(R.id.cb_letter);
        cbTravel = findViewById(R.id.cb_travel);

        tvContent = findViewById(R.id.tv_content);

        CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                switch (compoundButton.getId()){
                    case R.id.cb_sport:
                        if(isChecked==true){
                            Toast.makeText(MainActivity.this,"体育",Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.cb_music:
                        if(isChecked==true){
                            Toast.makeText(MainActivity.this,"音乐",Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.cb_letter:
                        if(isChecked==true){
                            Toast.makeText(MainActivity.this,"文学",Toast.LENGTH_SHORT).show();
                        }
                        break;  case R.id.cb_travel:
                        if(isChecked==true){
                            Toast.makeText(MainActivity.this,"旅行",Toast.LENGTH_SHORT).show();
                        }
                        break;

                }
            }
        };
        cbSport.setOnCheckedChangeListener(checkedChangeListener);
        cbMusic.setOnCheckedChangeListener(checkedChangeListener);
        cbLetter.setOnCheckedChangeListener(checkedChangeListener);
        cbTravel.setOnCheckedChangeListener(checkedChangeListener);

        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton rb = findViewById(i);
                gender = rb.getText().toString();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_submit:
                StringBuilder hobby = new StringBuilder();
                if(cbSport.isChecked()){
                    hobby.append(cbSport.getText().toString()).append("  ");
                }
                if(cbMusic.isChecked()){
                    hobby.append(cbMusic.getText().toString()).append("  ");
                }
                if(cbLetter.isChecked()){
                    hobby.append(cbLetter.getText().toString()).append("  ");
                } if(cbTravel.isChecked()){
                hobby.append(cbTravel.getText().toString());
            }
                StringBuilder info = new StringBuilder();
                info.append("姓名:"+etName.getText().toString()+"\n");
                info.append("年龄:"+etAge.getText().toString()+"\n");
                info.append("电话:"+etPhone.getText().toString()+"\n");
                info.append("地址:"+etAddress.getText().toString()+"\n");
                info.append("性别"+gender+"\n");
                info.append("爱好"+hobby.toString());
                tvContent.setText(info.toString());
                break;
            case R.id.btn_cancel:
                break;
        }
    }
}