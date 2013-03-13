package il.ac.huji.todolist;

import java.util.List;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class TodoListAdapter extends ArrayAdapter<String> {
	
	public TodoListAdapter(TodoListManagerActivity activity, List<String> tasks) {
		super(activity, android.R.layout.simple_list_item_1, tasks);
	}
	

	public View getView(int position, View convertView, ViewGroup parent) {
		
		String task = getItem(position);
		
		LayoutInflater inflater = LayoutInflater.from(getContext());
		View view = inflater.inflate(R.layout.row, null);
		
		TextView txtTask = (TextView)view.findViewById(R.id.txtTask);
		
		txtTask.setText(task);
		
		if(position % 2 == 0)
		{
			txtTask.setTextColor(Color.RED);
		}
		else{
			txtTask.setTextColor(Color.BLUE);
		}

		return view;
	}

}
