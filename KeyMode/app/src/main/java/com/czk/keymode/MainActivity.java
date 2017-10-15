package com.czk.keymode;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvSearch = (ListView) findViewById(R.id.lv_key_mode);
        final List<String> list = new KeyMode().getKeyList();
        lvSearch.setAdapter((new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, list)));
        lvSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (list.get(position)) {
                    case KeyMode.DEFAULT_KEYS_DIALER:
                        setDefaultKeyMode(DEFAULT_KEYS_DIALER);
                        break;
                    case KeyMode.DEFAULT_KEYS_DISABLE:
                        setDefaultKeyMode(DEFAULT_KEYS_DISABLE);
                        break;
                    case KeyMode.DEFAULT_KEYS_SEARCH_LOCAL:
                        setDefaultKeyMode(DEFAULT_KEYS_SEARCH_LOCAL);
                        onSearchRequested();
                        break;
                    case KeyMode.DEFAULT_KEYS_SEARCH_GLOBAL:
                        setDefaultKeyMode(DEFAULT_KEYS_SEARCH_GLOBAL);
                        break;
                    case KeyMode.DEFAULT_KEYS_SHORTCUT:
                        setDefaultKeyMode(DEFAULT_KEYS_SHORTCUT);
                        break;
                }

                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        super.onPrepareOptionsMenu(menu);
        menu.clear();
        menu.removeItem(0);
        menu.removeItem(1);
        menu.add( 0, 0, 0, "Show 0").setShortcut('0', '0').setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(){

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity.this,"DEFAULT_KEYS_SHORTCUT:0",Toast.LENGTH_SHORT).show();
                return true;
            }});
        menu.add( 0, 1, 0, "Show 1").setShortcut('1', '1').setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(){

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity.this,"DEFAULT_KEYS_SHORTCUT:1",Toast.LENGTH_SHORT).show();
                return true;
            }});

        return true;
    }
}
