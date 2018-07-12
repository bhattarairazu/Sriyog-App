package com.example.manjil.sriyogapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;



import java.util.HashMap;


public class Sessionmanagement {
    //share preferance objec
    SharedPreferences pref;
    //sharedpreference editor object
    Editor editor;
    //context
    Context mcontext;
    //sharedpreference mode
    private int PRIVATE_MODE=0;
    //shared preference file name
    private static final String PREF_NAME = "EGOVERNANCE";
    //shared preference key
    private static final String KEY_VALUE="IsLoggedIn";
    private static final String KEY_VALUE_Favouritenews = "isfavourite";
    //value for storing facebook details
    public static final String KEY_NAME = "name";
   // public static final String KEY_APPID="id";
    public static final String KEY_PHONE = "phone";

    public static final String Key_BIBARAN="bibaran";

    //value for storing favourite news details
    public static final String KEY_NAME_news = "fnewsname";
    public static final String KEY_ID_news="fnewsid";
    public static final String KEY__desc_news = "fnewsdesc";


    public Sessionmanagement(Context context){
        this.mcontext = context;
        pref = mcontext.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
       editor = pref.edit();
    }
    ///implementing login fucntion
    public void createloginsession(String name,String phone,String bibaran){
        editor.putBoolean(KEY_VALUE,true);
        editor.putString(KEY_NAME,name);
       // editor.putString(KEY_APPID,fbid);
        editor.putString(KEY_PHONE,phone);
        editor.putString(Key_BIBARAN,bibaran);

        editor.commit();
    }
    public HashMap<String,String> getuserdetails(){
        HashMap<String,String> user = new HashMap<String,String>();
        user.put(KEY_NAME,pref.getString(KEY_NAME,null));
       // user.put(KEY_APPID,pref.getString(KEY_APPID,null));
        user.put(KEY_PHONE,pref.getString(KEY_PHONE,null));
        user.put(Key_BIBARAN,pref.getString(Key_BIBARAN,null));

        return user;
    }
    //checking login
//    public void checkloginstatus(){
//        if (!this.isLoggedIn()){
//            Intent intents = new Intent(mcontext,MainActivity.class);
//            intents.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            intents.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            mcontext.startActivity(intents);
//        }
//        //if(this.isLoggedIn()){
//           // Intent intents = new Intent(mcontext,Dashboard.class);
//           // mcontext.startActivity(intents);
//
//        //}
//
//    }
//    public boolean isLoggedIn(){
//        return pref.getBoolean(KEY_VALUE, false);
//    }
//    public void logout(){
//        editor.clear();
//        editor.commit();
//        Intent intents = new Intent(mcontext,MainActivity.class);
//        intents.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        intents.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        mcontext.startActivity(intents);
//    }

}
