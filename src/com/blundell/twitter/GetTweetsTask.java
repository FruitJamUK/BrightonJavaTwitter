package com.blundell.twitter;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class GetTweetsTask extends AsyncTask<String, Void, List<Tweet>> {

    private final OnGotTweetsListener listener;

    public interface OnGotTweetsListener {
        void onGotTweets(List<Tweet> tweets);
    }

    public GetTweetsTask(OnGotTweetsListener listener) {
        this.listener = listener;
    }

    @Override
    protected List<Tweet> doInBackground(String... params) {
        List<Tweet> tweets = new ArrayList<Tweet>();
        try {
            String searchQuery = URLEncoder.encode(params[0], "UTF-8");
            HttpGet get = new HttpGet("https://twitter.com/search?q=" + searchQuery);
            HttpClient client = new DefaultHttpClient();
            HttpResponse response = client.execute(get);
            String content = convert(response.getEntity().getContent());

            tweets.addAll(SpeedHelper.parseTweets(content));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tweets;
    }

    @Override
    protected void onPostExecute(List<Tweet> tweets) {
        super.onPostExecute(tweets);
        listener.onGotTweets(tweets);
    }

    private String convert(InputStream stream) {
        Scanner s = new Scanner(stream).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

}


