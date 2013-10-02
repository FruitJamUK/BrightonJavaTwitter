package com.blundell.twitter;

import android.text.Html;
import android.text.Spanned;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class SpeedHelper {

    private static final String TAG = "TEST";

    // Step 1

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

    // Step 2

    public static List<Tweet> parseTweets(String content) {
        return new GetTweetsParser().parse(content);
    }

    public static class GetTweetsParser {

        public static final String TAG_USERNAME_START = "<strong class=\"fullname js-action-profile-name show-popup-with-id\">";
        public static final String TAG_USERNAME_END = "</strong>";
        public static final String TAG_TWEET_START = "<p class=\"js-tweet-text tweet-text\">";
        public static final String TAG_TWEET_END = "</p>";

        public List<Tweet> parse(String htmlTweets) {
            List<Tweet> tweets = new ArrayList<Tweet>();

            String html = htmlTweets;

            while (hasMoreTweets(html)) {
                String userName = getUserName(html);
                html = jumpPastUsername(html);

                String tweetContent = getTweet(html);
                html = jumpPastTweet(html);

                Tweet tweet = new Tweet(userName, tweetContent);
                tweets.add(tweet);
            }

            return tweets;
        }

        private boolean hasMoreTweets(String content) {
            return content.contains(TAG_USERNAME_START);
        }

        private String jumpToFirstUserName(String content) {
            return content.substring(content.indexOf(TAG_USERNAME_START) + TAG_USERNAME_START.length());
        }

        private String getUserName(String content) {
            String userNameAtStart = jumpToFirstUserName(content);
            return userNameAtStart.substring(0, userNameAtStart.indexOf(TAG_USERNAME_END));
        }

        private String jumpPastUsername(String content) {
            String userNameAtStart = jumpToFirstUserName(content);
            content = userNameAtStart.substring(userNameAtStart.indexOf(TAG_USERNAME_END) + TAG_USERNAME_END.length());
            return content;
        }

        private String getHtmlTweet(String htmlTweetAtStart) {
            return htmlTweetAtStart.substring(0, htmlTweetAtStart.indexOf(TAG_TWEET_END) + TAG_TWEET_END.length());
        }

        private String jumpToFirstTweet(String content) {
            return content.substring(content.indexOf(TAG_TWEET_START));
        }

        private String getTweet(String content) {
            String htmlTweetAtStart = jumpToFirstTweet(content);
            String htmlTweet = getHtmlTweet(htmlTweetAtStart);
            Spanned markupTweet = Html.fromHtml(htmlTweet);
            return markupTweet.toString();
        }

        private String jumpPastTweet(String content) {
            String htmlTweetAtStart = jumpToFirstTweet(content);
            content = htmlTweetAtStart.substring(htmlTweetAtStart.indexOf(TAG_TWEET_END) + TAG_TWEET_END.length());
            return content;
        }

    }
}
