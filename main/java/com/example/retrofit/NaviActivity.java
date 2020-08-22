package com.example.retrofit;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class NaviActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private View drawView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

//
//        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
//        drawView= (View) findViewById(R.id.drawer);
//
//        Button btn_open = (Button)findViewById(R.id.btn_open);
//        btn_open.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                drawerLayout.openDrawer(drawView);
//            }
//        });
//
//        Button btn_close = (Button)findViewById(R.id.btn_close);
//        btn_close.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                drawerLayout.closeDrawers();
//
//            }
//        });
//
//        drawerLayout.setDrawerListener(listner);
//        drawView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return true;
//            }
//        });
//
//
//
//    }

        //수정 필요
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        drawView = (View) findViewById(R.id.drawer);


    }
}
