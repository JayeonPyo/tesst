package com.example.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ListwowViewAdapter extends BaseAdapter {
    private ArrayList<ListViewItem> listViewItemList=new ArrayList<ListViewItem>();

    public ListwowViewAdapter() {

    }
    private TextView textView;

    @Override
    public int getCount() {
        return  listViewItemList.size();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.back, parent, false);
        }

        textView=convertView.findViewById(R.id.tv_yes);

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        final Button descTextView =  convertView.findViewById(R.id.btn_yes) ;
String str;
descTextView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String str=descTextView.getText().toString();

    }
});
        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        ListViewItem listViewItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영

        descTextView.setText(listViewItem.getTitle());

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(String title) {
        ListViewItem item = new ListViewItem();


        item.setTitle(title);


        listViewItemList.add(item);
    }


}
