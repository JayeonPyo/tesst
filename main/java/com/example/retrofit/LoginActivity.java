package com.example.retrofit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    public void setEt_id(EditText et_id) {
        this.et_id = et_id;
    }

    private EditText et_id, et_pass;
    private Button btn_login, btn_register;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _id = et_id.getText().toString();
                String passwd = et_pass.getText().toString();
                if(_id != null || passwd != null){
                    setEt_id(et_id);
                    login();
                }else{
                    Toast.makeText(LoginActivity.this, "값이 비어 있습니다.", Toast.LENGTH_SHORT).show();
                }

            }
        });
/*
 public void onClick(View v) {
                String id = et_id.getText().toString();
                String passwd = et_pass.getText().toString();
                String email = et_email.getText().toString();
                if(id != null || passwd != null || email != null){
                    if(passwd.length() > 8){
                        //Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        //startActivity(intent);
                        register();
                    }else{
                        Toast.makeText(RegisterActivity.this, "비밀번호는 8자 이상이여야 합니다.", Toast.LENGTH_SHORT).show();
                }
            }else{

                }
            }
 */
        //회원가입 버튼 클릭 시 실행
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


    }


    void login(){
        NetworkHelper.getInstance().login(et_id.getText().toString(),et_pass.getText().toString())
                .enqueue(new Callback<ResponseBody>() {

                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Log.e("response",response.toString()+"");
                        //Toast.makeText(getApplicationContext(),"로그인이 완료되었습니다.", response.body(),Toast.LENGTH_SHORT).show();
                        //Toast.makeText(getApplicationContext(),"로그인이 실패되었습니다.", response.body(),Toast.LENGTH_SHORT).show();
                        if(response.isSuccessful()){
                            if(response.code() == 200){
                                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                intent.putExtra("id",et_id.getText().toString());
                                startActivity(intent);
                            }else{
                                Toast.makeText(LoginActivity.this, ""+response.message(), Toast.LENGTH_SHORT).show();
                            }

                        }else{
                            Toast.makeText(LoginActivity.this, ""+response.message(), Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("error",t.toString());
                    }
                });
    }


}