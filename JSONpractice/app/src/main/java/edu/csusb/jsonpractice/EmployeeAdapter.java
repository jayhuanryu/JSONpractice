package edu.csusb.jsonpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jay Ryu on 3/2/17.
 */

public class EmployeeAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Employee> arrayList;
    private LayoutInflater inflater;

    public EmployeeAdapter(Context context,ArrayList<Employee> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Employee getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row_item, parent, false);
        }

        Employee employee = arrayList.get(position);

        TextView nameTextView = (TextView) convertView.findViewById(R.id.tv_name);
        TextView ageTextView = (TextView) convertView.findViewById(R.id.tv_age);

        nameTextView.setText(employee.getName());
        ageTextView.setText(String.valueOf(employee.getAge()));

        return convertView;
    }
}
