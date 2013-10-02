package com.blundell.twitter;

import android.util.Log;

public class SpeedHelper {

    private static final String TAG = "TEST";

    public static void debugTestPrintFirstTweetUsername(String content) {
        String htmlUserNameAtStart = content.substring(content.indexOf("<strong class=\"fullname js-action-profile-name show-popup-with-id\">"));
        String htmlUserName = htmlUserNameAtStart.substring(0, htmlUserNameAtStart.indexOf("</strong>") + 9);
        Log.d(TAG, htmlUserName);
    }

    public static void debugTestPrintFirstTweet(String content) {
        String htmlTweetAtStart = content.substring(content.indexOf("<p class=\"js-tweet-text tweet-text\">"));
        String htmlTweet = htmlTweetAtStart.substring(0, htmlTweetAtStart.indexOf("</p>") + 4);
        Log.d("TEST", htmlTweet);
    }
}
