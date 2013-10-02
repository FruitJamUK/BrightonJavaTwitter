package com.blundell.twitter;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends Activity implements GetTweetsTask.OnGotTweetsListener {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new GetTweetsTask(this).execute("Brighton Java");
    }

    @Override
    public void onGotTweets(List<Tweet> tweets) {
        for (Tweet tweet : tweets) {
            Log.d("TEST", tweet.toString());
        }
    }
}
