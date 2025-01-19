package com.example.mathprojectdavid.MyProject;

import android.graphics.Bitmap;
import android.net.Uri;

public class User {
    private String name;
    private int score;
    private int rate;
    private Long id;
    private Uri uri;
    private Bitmap bitmap;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public User(String name, int score,int rate, Long id, Bitmap bitmap) {
        this.name = name;
        this.score = score;
        this.rate = rate;
        this.id = id;
        this.bitmap = bitmap;

    }
    public User(){}

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }
}
