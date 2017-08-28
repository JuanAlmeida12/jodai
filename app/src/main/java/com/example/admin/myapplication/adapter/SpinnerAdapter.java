package com.example.admin.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.models.Mission;
import com.example.admin.myapplication.models.Task;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Admin on 16/08/2017.
 */

public class SpinnerAdapter extends BaseAdapter {

    private List<Mission> missions_names;
    private List<Task> tasks_names;
    private Context context;

    public SpinnerAdapter(List<Mission> missions_names, List<Task> tasks_names, Context context) {
        this.missions_names = missions_names;
        this.tasks_names = tasks_names;
        this.context = context;
    }

    @Override
    public int getCount() {
        return missions_names == null? tasks_names.size():missions_names.size();
    }

    @Override
    public Object getItem(int position) {
        return missions_names == null? tasks_names.get(position):missions_names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.spinner_layout, null);

        TextView name = (TextView) view.findViewById(R.id.text_spinner);

        name.setText(missions_names == null?tasks_names.get(position).getTask_name():missions_names.get(position).getMission_name());

        return view;
    }
}
