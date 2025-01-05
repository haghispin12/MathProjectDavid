package com.example.mathprojectdavid;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.lang.reflect.Type;
import java.net.Proxy;
import java.util.ArrayList;

import DBHekper.DBHelper;

public class MainViewModel extends ViewModel {

    MutableLiveData<Integer> vnum1;

    MutableLiveData<Integer> vnum2;

    Exercize exercize;
    int Type;

    User user;

    MutableLiveData<ArrayList<User>> users = new MutableLiveData<ArrayList<User>>();

    public void setUsers(MutableLiveData<ArrayList<User>> users) {
        this.users = users;
    }

    public MainViewModel(){
        vnum1 = new MutableLiveData<>();
        vnum2 = new MutableLiveData<>();
        exercize = new Exercize();
        user = new User();
    }

    //create action that call etgar action
    public void vEtgar(){
        exercize.generateNumEtgar();
        vnum1.setValue(exercize.getNum3());
        vnum2.setValue(exercize.getNum4());
        Type = 20;
        ;
    }

    public void vKefel(){
        exercize.generateNumstill20();
        vnum1.setValue(exercize.getNum3());
        vnum2.setValue(exercize.getNum4());
        Type = 10;
    }

    public void vloach(){
        exercize.generateNumloach();
        vnum1.setValue(exercize.getNum3());
        vnum2.setValue(exercize.getNum4());
        Type = 15;
    }
    public boolean vcheck(String s){
        return exercize.checkAnswer(s);
    }

    public void updateName(String s){
        user.setName(s);
    }

    public int getType() {
        return Type;
    }

    public User getUser() {
        return user;
    }

    public long dbAddUser(Context context){
        DBHelper dbHelper = new DBHelper(context);
        long id = dbHelper.insert(user,context);
        Log.d("david", id+"");
        return id;
    }

    public void getUsersDB(Context context){
        DBHelper dbHelper = new DBHelper(context);
        users.setValue(dbHelper.selectAll());
    }
}
