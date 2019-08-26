package com.example.deepgandhi.dsslab2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapterCustom extends ArrayAdapter<User> {
    Context context;
    List<User> users;

    public ListAdapterCustom(Context context,  List<User> users) {
        super(context, 0,users);
        this.users = users;
        this.context = context;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        }

        TextView tvName = convertView.findViewById(R.id.userName);
        TextView tvId = convertView.findViewById(R.id.userId);

        tvId.setText(users.get(position).getId());
        tvName.setText(users.get(position).getName());

        return convertView;
    }
}
