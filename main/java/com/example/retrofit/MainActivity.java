package com.example.retrofit;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private TextView tv_id, tv_pass;
    private DrawerLayout drawer;
    private String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawer =findViewById(R.id.drawer_layout);
        ListViewAdapter adapter = new ListViewAdapter();

        ListView listview = findViewById(R.id.lv_list);
        listview.setAdapter(adapter);

        Intent intent = getIntent();
        id = intent.getExtras().getString("id");

        ArrayList<String> titli = new ArrayList<>();
        titli.add("오늘의 야식");
        String[] title = new String[]{"오늘의 야식", "일본 불매 운동에 대해", "스마트폰 중독에 대해", "오늘 친구랑 싸웠어요" ,"앱둘떨둘 화이팅"};//괄호내용을 서버에서 받은 값으로 변경해

        //서버 연결해서 이거는 지우고 서버에서 받은 값을 List or 문자열에 저장시켜서 for문 으로 addItem
        for (int i = 0; i < title.length; i++) {

            adapter.addItem(title[i]);
        }
        ImageView iv_menu = findViewById(R.id.iv_menu);
        iv_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.START);
            }
        });
        ImageView iv_post = findViewById(R.id.iv_post);
        iv_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "good", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,WritePost.class);
                intent.putExtra("id",id);

                startActivity(intent);
            }
        });
    }


    class ListViewAdapter extends BaseAdapter {
        private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();

        public ListViewAdapter() {

        }

        private TextView textView;

        @Override
        public int getCount() {
            return listViewItemList.size();
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final int pos = position;
            final Context context = parent.getContext();

            // "listview_item" Layout을 inflate하여 convertView 참조 획득.
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.item, parent, false);
            }


            // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
            final Button descTextView = convertView.findViewById(R.id.text_title);
            String str;
            descTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String str = descTextView.getText().toString();

                }
            });
            // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
            ListViewItem listViewItem = listViewItemList.get(position);

            // 아이템 내 각 위젯에 데이터 반영

            descTextView.setText(listViewItem.getTitle());
        Intent intent=getIntent();
            final String id=intent.getExtras().getString("id");


            descTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String str = descTextView.getText().toString();
                    Intent intent = new Intent(MainActivity.this, wow_soSleep.class);
                    intent.putExtra("title", str);
                    intent.putExtra("id", id);
                    startActivity(intent);
                }
            });

            return convertView;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
        @Override
        public Object getItem(int position) {
            return listViewItemList.get(position);
        }

        // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
        public void addItem(String title) {
            ListViewItem item = new ListViewItem();
            item.setTitle(title);
            listViewItemList.add(item);
        }


    }

}