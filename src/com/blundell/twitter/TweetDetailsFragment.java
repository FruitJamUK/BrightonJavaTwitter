package com.blundell.twitter;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TweetDetailsFragment extends Fragment {

    private TextView detailsTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tweet_details, container, false);

        detailsTextView = (TextView) root.findViewById(R.id.tweet_details_text);
        detailsTextView.setText(detailsTextView.getText().toString() + System.currentTimeMillis());

        return root;
    }

    public void showNewTweet(Tweet tweet) {
        detailsTextView.setText(getString(R.string.stub_tweet_details) + " " + System.currentTimeMillis());
    }
}
