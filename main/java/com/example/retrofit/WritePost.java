package com.example.retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.retrofit.Model.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WritePost extends AppCompatActivity {
    private Button btn_push;
    private EditText et_title;
    private  EditText et_text;
    private  String id;

    public String getEt_title() {
        return et_title.getText().toString();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write);
        btn_push=findViewById(R.id.btn_push);
        et_title=findViewById(R.id.et_title);
        et_text=findViewById(R.id.et_text);
        Intent intent =  getIntent();
        id=intent.getStringExtra("id");
        final String title = et_title.getText().toString();
        final String text = et_text.getText().toString();



        btn_push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WritePost(id,title,text);
            }
        });


    }

    void WritePost(final String get,String title, String text){
        NetworkHelper.getInstance().postarticle(id,title,text).enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if(response.isSuccessful()){
                    Intent intent = new Intent(WritePost.this,MainActivity.class);
                    intent.putExtra("id",get);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {

            }
        });
    }
}
