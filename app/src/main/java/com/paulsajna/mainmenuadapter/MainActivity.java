package com.paulsajna.mainmenuadapter;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends ListActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);
		String[] titles = getResources().getStringArray(R.array.menu_titles);
		String[] descs = getResources().getStringArray(R.array.menu_descs);
		String[] classes = getResources().getStringArray(R.array.menu_classes);
				
		TypedArray icons = getResources().obtainTypedArray(R.array.menu_icons);		
		setListAdapter(new MainMenuAdapter(this, R.layout.main_list_item,
				titles, descs, icons, classes));
    }
	
	public void onListItemClick(ListView parent, View v, int position, long id) {
		String StringClassname = parent.getAdapter().getItem(position).toString();
		Class<?> c = null;
        if(StringClassname != null) {
            try {
                c = Class.forName(StringClassname);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        Intent intent = new Intent(this, c);
        startActivity(intent);
	}
}