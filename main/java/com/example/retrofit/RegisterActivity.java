package com.example.retrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retrofit.Model.ArticleModel;
import com.example.retrofit.Model.UserModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterActivity extends AppCompatActivity {

    private EditText et_id,et_pass,et_email;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //액티비티 시작시 처음으로 실행
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        //아이디 값 찾아주기
        et_id = findViewById(R.id.et_id);
        et_pass= findViewById(R.id.et_pass);
        et_email = findViewById(R.id.et_email);

// 회원가입 버튼 클릭시 수행
        btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener(){
            @Override
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
        });

    }
/*
    void getArticles(String id, String title) {
        NetworkHelper.getInstance().getarticles(id, title).enqueue(new Callback<ArrayList<ArticleModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ArticleModel>> call, Response<ArrayList<ArticleModel>> response) {
                Log.e("articles: ",response.body().toString());
        }

            @Override
            public void onFailure(Call<ArrayList<ArticleModel>> call, Throwable t) {

            }
        });
    }
    */
    void register(){


      NetworkHelper.getInstance().register(et_id.getText().toString(),et_pass.getText().toString(),et_email.getText().toString()).enqueue(new Callback<UserModel>() {
           @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if(response.isSuccessful()){
                    Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(RegisterActivity.this, "회원가입을 할 수 없습니다.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Log.e("error",t.toString());

            }
        });
   }
    /*void register(){
        NetworkHelper.getInstance().register("id", "pw","email")
                .enqueue(new Callback<ResponseBody>() {

                    @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                        if(response.isSuccessful()){
                            if(response.body() != null){
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);




                            }

                        }




                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("error",t.toString());
                    }
                });
    }*/
}
