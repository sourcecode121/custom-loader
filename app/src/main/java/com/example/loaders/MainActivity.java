package com.example.loaders;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<User>> {

    TextView textView1;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView) findViewById(R.id.text_view_1);
        textView2 = (TextView) findViewById(R.id.text_view_2);

        // Initialize loader
        getSupportLoaderManager().initLoader(0, null, this).forceLoad();
    }

    @Override
    public Loader<List<User>> onCreateLoader(int id, Bundle args) {
        return new CustomLoader(MainActivity.this);
    }

    @Override
    public void onLoadFinished(Loader<List<User>> loader, List<User> data) {
        textView1.setText(data.get(0).getFirstName() + " " + data.get(0).getLastName());
        textView2.setText(data.get(1).getFirstName() + " " + data.get(1).getLastName());
    }

    @Override
    public void onLoaderReset(Loader<List<User>> loader) {
        textView1.setText(null);
        textView2.setText(null);
        Log.i("MainActivity", "Loader Reset");
    }
}
