package com.blundell.twitter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends Activity implements GetTweetsTask.OnGotTweetsListener {

    private ListView listView;
    private View emptyView;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new GetTweetsTask(this).execute("Brighton Java");

        listView = (ListView) findViewById(R.id.main_list_view);
        emptyView = findViewById(android.R.id.empty);
    }

    @Override
    public void onGotTweets(List<Tweet> tweets) {
        listView.setAdapter(new ArrayAdapter<Tweet>(this, android.R.layout.simple_list_item_1, android.R.id.text1, tweets));
        emptyView.setVisibility(View.GONE);
    }
}
