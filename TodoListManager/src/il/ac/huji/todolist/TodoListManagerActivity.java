package il.ac.huji.todolist;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class TodoListManagerActivity extends Activity {

	private ArrayAdapter<String> adapter;
	ListView listTasks;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_todo_list_manager);
		
		List<String> tasks = new ArrayList<String>();
		listTasks =  (ListView)findViewById(R.id.lstTodoItems);
		
		adapter = new TodoListAdapter(this, tasks);
		listTasks.setAdapter(adapter);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case R.id.menuItemAdd:
			EditText task = (EditText)findViewById(R.id.edtNewItem);
			String addTask = task.getText().toString();
			adapter.add(addTask);
			break;
		case R.id.menuItemDelete:
			String delTask = (String)listTasks.getSelectedItem();
			adapter.remove(delTask);
			break;
		
		}
		return true;
	}

}
