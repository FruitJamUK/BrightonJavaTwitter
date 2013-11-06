package com.blundell.twitter;

public class Tweet { // implements Parcelable {
    private final String username;
    private final String content;

    public Tweet(String username, String content) {
        this.username = username;
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return username + " : " + content;
    }

    // Parceleable

//    public Tweet(Parcel in) {
//        String[] data = new String[2];
//        in.readStringArray(data);
//        this.username = data[0];
//        this.content = data[1];
//    }
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeStringArray(new String[]{this.username, this.content});
//    }
//
//    public static final Parcelable.Creator<Tweet> CREATOR = new Parcelable.Creator<Tweet>() {
//        @Override
//        public Tweet createFromParcel(Parcel source) {
//            return new Tweet(source);
//        }
//
//        @Override
//        public Tweet[] newArray(int size) {
//            return new Tweet[size];
//        }
//    };
}
