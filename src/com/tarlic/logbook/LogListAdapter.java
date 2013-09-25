package com.tarlic.logbook;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.content.Context;

public class LogListAdapter extends BaseAdapter {
	 private static ArrayList<LogItem> logItemArrayList;
	 
	 private LayoutInflater mInflater;

	 public LogListAdapter(Context listFragment, ArrayList<LogItem> logItems) {
		 logItemArrayList = logItems;
	  mInflater = LayoutInflater.from(listFragment);
	 }

	 public int getCount() {
	  return logItemArrayList.size();
	 }

	 public Object getItem(int position) {
	  return logItemArrayList.get(position);
	 }

	 public long getItemId(int position) {
	  return position;
	 }

	 public View getView(int position, View convertView, ViewGroup parent) {
         // A ViewHolder keeps references to children views to avoid unnecessary calls
         // to findViewById() on each row.
	  ViewHolder holder;
	  
	  // When convertView is not null, we can reuse it directly, there is no need
	  // to reinflate it. We only inflate a new View when the convertView supplied
	  // by ListView is null.
      if (convertView == null) {	  
	   convertView = mInflater.inflate(R.layout.list_row, null);
	   holder = new ViewHolder();
	   holder.title = (TextView) convertView.findViewById(R.id.title);
	   holder.text = (TextView) convertView.findViewById(R.id.text);
	   holder.date = (TextView) convertView.findViewById(R.id.date);

	   convertView.setTag(holder);
	  } else {
	   holder = (ViewHolder) convertView.getTag();
	  }
	  
	  holder.title.setText(logItemArrayList.get(position).getTitle());
	  holder.text.setText(logItemArrayList.get(position).getText());
	  
	  // Formatting the date
	  
	  String format = new String("yyyy-MM-dd");	  
	  SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);	  
	  String date = sdf.format(logItemArrayList.get(position).getDate()); 
	  
	  holder.date.setText(date);

	  return convertView;
	 }

	 static class ViewHolder {
	  //ImageView icon;
	  TextView title;
	  TextView text;
	  TextView date;
	 }
	}