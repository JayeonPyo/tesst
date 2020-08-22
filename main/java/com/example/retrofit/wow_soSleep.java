package com.example.retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofit.Model.ArticleModel;
import com.example.retrofit.Model.UserModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class wow_soSleep extends AppCompatActivity {
    private ListView list_v;
    private TextView tv_em;
    private Button btn_send;
    private EditText et_message;
    String title;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        Intent intent=getIntent();
        final String id = intent.getExtras().getString("id");
        //String title=intent.getExtras().getString("title");
        final String title=intent.getExtras().getString("title");
//title을 가지고 댓글 검색
        et_message=findViewById(R.id.et_message);
        list_v=findViewById(R.id.list_v);
        tv_em=findViewById(R.id.tv_em);
        ListwowViewAdapter adapter= new ListwowViewAdapter();
        tv_em.setText(title);
        list_v.setAdapter(adapter);


        btn_send=findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity getid = new LoginActivity();
                WritePost getEt_title = new WritePost();
                String str = et_message.getText().toString();
                comment(id,title,str);
                getComment(id,title);
            }
        });
    }


    void getComment(String id, String title){
        NetworkHelper.getInstance().getarticles(id,title).enqueue((new Callback<ArrayList<ArticleModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ArticleModel>> call, Response<ArrayList<ArticleModel>> response) {
                if(response.isSuccessful()){
                    if(response.code() == 200){

                    }else{
                        Toast.makeText(wow_soSleep.this, ""+response.message(), Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(wow_soSleep.this, ""+response.message(), Toast.LENGTH_SHORT).show();



                }
            }

            @Override
            public void onFailure(Call<ArrayList<ArticleModel>> call, Throwable t) {
                Toast.makeText(wow_soSleep.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    void comment(String id, String title,String str){
        NetworkHelper.getInstance().postComment(id,title,str).enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if(response.isSuccessful()){
                    Intent intent=new Intent(wow_soSleep.this,WritePost.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(wow_soSleep.this, ""+response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Toast.makeText(wow_soSleep.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
