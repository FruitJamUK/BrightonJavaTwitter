package com.blundell.twitter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity implements TweetListFragment.OnTweetClickedListener {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onTweetClicked(Tweet tweet) {
        if (getResources().getBoolean(R.bool.tablet_7_inch)) {
            TweetDetailsFragment fragment = (TweetDetailsFragment) getFragmentManager().findFragmentById(R.id.fragment_tweet_details);
            fragment.showNewTweet(tweet);
        } else {
            Intent intent = new Intent(this, TweetDetailsActivity.class);
            startActivity(intent);
        }
    }
}
