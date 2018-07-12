package com.example.manjil.sriyogapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.suitebuilder.annotation.Suppress;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpClientStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.example.manjil.sriyogapp.Model.Model_new_iding;
import com.example.manjil.sriyogapp.Model.Model_notice_array;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.basgeekball.awesomevalidation.ValidationStyle.COLORATION;

public class MainActivity extends AppCompatActivity {

    EditText edtname,
            edtphone,
            edtbibaran,
            edt_address;

    TextView mtextview;
    Button btnsend;
    String username, phone, bibaran,addressss;
    String send;
    String city, shamuha;

    Sessionmanagement msession;
    Button mbtnsend, mbtncanel,selectphoto;
    RequestQueue mrequest;
    private String id_category,id_city;
    Spinner spinner;
    Spinner spinner1;
    private Boolean selection = false;
    ProgressDialog mdialogue;
    AwesomeValidation mAwesomvalidation = new AwesomeValidation(COLORATION);

    List<Model_notice_array> marraylist = new ArrayList<>();
    List<Model_new_iding> mgetidlist = new ArrayList<>();
    private static final int Gallery_Request = 1;
    Uri mimageuri = null;
    private Bitmap mbitmap;
    private String stringimage;
    String id_get;
    int iding = 0,category_id = 0;
    String id_Get_city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        //  mAwesomvalidation.setColor(Color.RED);
//        msession = new Sessionmangement(this);
        msession = new Sessionmanagement(this);
        mrequest = Volley.newRequestQueue(this);
        getdata_voolley();
        getdata_voolley1();
        mdialogue = new ProgressDialog(this);
        edtphone = (EditText) findViewById(R.id.edtphone);
        // mAwesomvalidation.addValidation(Registeractivity.this, R.id.phone,"[0-9]+", R.string.err_name);
        edtname = (EditText) findViewById(R.id.edtfullname);
        //edt_address = (EditText) findViewById(R.id.edit_address);
        //mAwesomvalidation.addValidation(Registeractivity.this, R.id.username, "[a-zA-Z\\s]+", R.string.err_name);
        edtbibaran = (EditText) findViewById(R.id.edtbibaran);
        spinner = (Spinner) findViewById(R.id.spinnercity);
        spinner1 = (Spinner) findViewById(R.id.spinnersamuha);
       // mtextview= (TextView) findViewById(R.id.mtext_hide);


        mbtncanel = (Button) findViewById(R.id.btncancel);
        mbtnsend = (Button) findViewById(R.id.btnsend);
//        selectphoto = (Button) findViewById(R.id.btnphoto);
//        selectphoto.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent mintents = new Intent(Intent.ACTION_GET_CONTENT);
//                mintents.setType("image/*");
//                startActivityForResult(mintents,Gallery_Request);
//            }
//        });

        mbtnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("es", "onClick: [[[[[[[[" + send);
                username = edtname.getText().toString();
                bibaran = edtbibaran.getText().toString();
                phone = edtphone.getText().toString();
               // addressss = edt_address.getText().toString();
                if(iding>=0){
                    id_Get_city = marraylist.get(iding).getId();
                    Log.d("ttt", "onClick: clickkkkkiiiiinnnngg"+iding+"kdkd_"+id_Get_city);

                }
                if(category_id>=0){
                    id_get = mgetidlist.get(category_id).getId();
                }
                if (username.length() > 0) {
                    edtname.setBackgroundResource(R.drawable.edittext_outerline);
                } else {
                    edtname.setBackgroundResource(R.drawable.edittext_errorouterline);
                }
                if (bibaran.length() > 0) {
                    edtbibaran.setBackgroundResource(R.drawable.edittext_outerline);
                } else {
                    edtbibaran.setBackgroundResource(R.drawable.edittext_errorouterline);
                }
                if (phone.length() == 10) {
                    edtphone.setBackgroundResource(R.drawable.edittext_outerline);
                } else {
                    edtphone.setBackgroundResource(R.drawable.edittext_errorouterline);
                }
//                if (addressss.length()>0) {
//                    edt_address.setBackgroundResource(R.drawable.edittext_outerline);
//                } else {
//                    edt_address.setBackgroundResource(R.drawable.edittext_errorouterline);
//                }
                if (username.length() > 0 && bibaran.length() > 0 && edtphone.length() == 10 ) {

                    voleyrequest();
                    edtname.setText(null);
                    edtbibaran.setText(null);
                    edtphone.setText(null);
                    //edt_address.setText(null);
                   // mtextview.setVisibility(View.GONE);

                    Toast.makeText(MainActivity.this, "Sent Successfully", Toast.LENGTH_SHORT).show();

                    edtname.setBackgroundResource(R.drawable.edittext_outerline);
                    edtbibaran.setBackgroundResource(R.drawable.edittext_outerline);
                    edtphone.setBackgroundResource(R.drawable.edittext_outerline);
                   // edt_address.setBackgroundResource(R.drawable.edittext_outerline);


                } else {
                    Toast.makeText(MainActivity.this, "Please Fill All the field", Toast.LENGTH_SHORT).show();
                }


            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                city=parent.getItemAtPosition(position).toString();
                iding = position;
               //id_Get_city = city.replace(parent.getItemAtPosition(position).toString(),marraylist.get(position).getId());
                Log.d("ttt", "onItemSelected: nnnnnnnnnn"+id_Get_city);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                shamuha=parent.getItemAtPosition(position).toString();
                category_id = position;
               // id_get = shamuha.replace(parent.getItemAtPosition(position).toString(),marraylist.get(position).getId());
                Log.d("ttt", "onItemSelected: nnnnnnnnnn"+id_get);
                //Toast.makeText(MainActivity.this, "sdfsdf"+id_category, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode == Gallery_Request && resultCode == RESULT_OK){
//             mimageuri = data.getData();
//            if(mimageuri!=null){
//                selection = true;
//                mtextview.setVisibility(View.VISIBLE);
//            }
//            try {
//                mbitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),mimageuri);
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            stringimage = imagetostring(mbitmap);
//            //Toast.makeText(this, "sdfs"+stringimage, Toast.LENGTH_SHORT).show();
//            // Toast.makeText(this, "uri"+muri, Toast.LENGTH_SHORT).show();
//
//        }
//    }
//    private String imagetostring(Bitmap mbittmap){
//        ByteArrayOutputStream bytess = new ByteArrayOutputStream();
//        mbittmap.compress(Bitmap.CompressFormat.JPEG,100,bytess);
//        byte [] mgetbute = bytess.toByteArray();
//        return Base64.encodeToString(mgetbute,Base64.DEFAULT);
//
//
//    }
    private void init(){

    }

    public void voleyrequest() {

        //Log.d("v", "voleyrequest: nnnnnnnnnnnn"+name+sub+body+phone+address);
        String url = "https://sriyog.com/api/register";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("success=l", "onResponse: sssssssssssss" + response.toString());
                //parseAndDisplayMessage3(response);
                //  mdialogue.dismiss();
                edtname.setText(null);
                edtbibaran.setText(null);
                edtphone.setText(null);

            }
        } , new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("fai", "onResponse: sssssssssssss"+error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
               // params.put("sent_to",send);
                params.put("name", username);
                params.put("address","default");
                Log.d("ttt", "getParams: address==============="+addressss);
                params.put("contact", phone);
                params.put("description", bibaran);
               params.put("userfile","noimage");
                Log.d("ttt", "getParams: nnnnnnnnnnnnnnnnnnnnnnnnnnn"+stringimage);
                params.put(" place_id",id_Get_city);
                params.put(" category_id",id_get);

                return params;
            }
        };
        mrequest.add(postRequest);

    }




    public void getdata_voolley(){
        String urls = "https://sriyog.com/api/getPlaces";
        JsonObjectRequest requestMessage = new JsonObjectRequest(Request.Method.GET, urls, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.v("About", response.toString());

                //readWrite.writeFile("About.txt", response);
                //Pref.sSavePreferences(getApplicationContext(),"About.txt", true);
                parseAndDisplayMessage(response);

                // final JSONObject result;
                // try {
                //  result = response.getJSONObject("result");
                // emails = result.getString("email");
                //Log.d("About", "onResponse: lllllllllllllllll"+emails);
                // } catch (JSONException e) {
                // e.printStackTrace();
                //  }

                // String body = result.getString("body");
                // String subTitle = result.getString("sub_title");
                // messageTitle.setText(Html.fromHtml(title));
                //messageBody.setText(Html.fromHtml(body));
                //messageSender.setText(Html.fromHtml(subTitle));




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ttt", "onErrorResponse: jjjjjjjjjjjjjj"+error.toString());
            }
        });

        mrequest.add(requestMessage);

    }
    public void parseAndDisplayMessage(JSONObject response)
    {
        //spinner
        ArrayList<String> list = new ArrayList<>();

        // list.add("Select Email to Send");
        try {
            JSONArray array = response.getJSONArray("result");

            // emails = result.getString("email");
            //Log.d("About", "onResponse: lllllllllllllllll"+emails);
            //String body = result.getString("body");
            // String subTitle = result.getString("sub_title");

            for(int i = 0; i<array.length(); i++)
            {
                JSONObject obj = array.getJSONObject(i);
                Model_notice_array mararys = new Model_notice_array();
                //Model_notice_array ema = new Model_notice_array(obj.getString("email"));
                Log.d("About", "onResponse: lllllllllllllllll"+obj.getString("place"));
                //mlistemail.add(ema);
                //list.add("Select Email to Send");
                list.add(obj.getString("place"));
                //String listss = obj.getString("email");
                //mlist.add(obj.getString("name"));
                mararys.setPlace(obj.getString("place"));
                mararys.setId(obj.getString("id"));
                // Log.d("ttt", "parseAndDisplayMessage: eeeeeeeeeeeee"+listss);
                marraylist.add(mararys);
            }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(arrayAdapter);
            //click listener on spinner items

        } catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    public void getdata_voolley1(){
        String urls1 = "https://sriyog.com/api/getCategories";
        JsonObjectRequest requestMessage1 = new JsonObjectRequest(Request.Method.GET, urls1, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.v("About", response.toString());

                //readWrite.writeFile("About.txt", response);
                //Pref.sSavePreferences(getApplicationContext(),"About.txt", true);
                parseAndDisplayMessage1(response);

                // final JSONObject result;
                // try {
                //  result = response.getJSONObject("result");
                // emails = result.getString("email");
                //Log.d("About", "onResponse: lllllllllllllllll"+emails);
                // } catch (JSONException e) {
                // e.printStackTrace();
                //  }

                // String body = result.getString("body");
                // String subTitle = result.getString("sub_title");
                // messageTitle.setText(Html.fromHtml(title));
                //messageBody.setText(Html.fromHtml(body));
                //messageSender.setText(Html.fromHtml(subTitle));




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ttt", "onErrorResponse: jjjjjjjjjjjjjj"+error.toString());

            }
        });

        mrequest.add(requestMessage1);

    }
    public void parseAndDisplayMessage1(JSONObject response)
    {
        //spinner
        ArrayList<String> list = new ArrayList<>();

        // list.add("Select Email to Send");
        try {
            JSONArray array = response.getJSONArray("result");

            // emails = result.getString("email");
            //Log.d("About", "onResponse: lllllllllllllllll"+emails);
            //String body = result.getString("body");
            // String subTitle = result.getString("sub_title");

            for(int i = 0; i<array.length(); i++)
            {
                JSONObject obj = array.getJSONObject(i);
                Model_new_iding mararys_iding = new Model_new_iding();
                Model_notice_array mararys = new Model_notice_array();
                //Model_notice_array ema = new Model_notice_array(obj.getString("email"));
                Log.d("About", "onResponse: lllllllllllllllll"+obj.getString("category"));
                //mlistemail.add(ema);
                //list.add("Select Email to Send");
                list.add(obj.getString("category"));
                //list.add(obj.getString("id"));
                //String listss = obj.getString("email");
                //mlist.add(obj.getString("name"));
                mararys.setPlace(obj.getString("category"));
                mararys_iding.setId(obj.getString("id"));
                 Log.d("ttt", "parseAndDisplayMessage: eeeeeeeeeeeee"+obj.getString("id"));
                marraylist.add(mararys);
                mgetidlist.add(mararys_iding);
            }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner1.setAdapter(arrayAdapter);
            //click listener on spinner items

        } catch (JSONException e)
        {
            e.printStackTrace();
        }
    }



     public void cancel(View view){

         finish();
     }
//    public void parseAndDisplayMessage3(String response)
//    {
//        //spinner
//        ArrayList<String> list = new ArrayList<>();
//        Toast.makeText(this, "run"+response, Toast.LENGTH_SHORT).show();

        // list.add("Select Email to Send");
//        try {
//            JSONArray array = response.getJSONArray("result");
//
//            // emails = result.getString("email");
//            //Log.d("About", "onResponse: lllllllllllllllll"+emails);
//            //String body = result.getString("body");
//            // String subTitle = result.getString("sub_title");
//
//            for(int i = 0; i<array.length(); i++)
//            {
//                JSONObject obj = array.getJSONObject(i);
//                Model_notice_array mararys = new Model_notice_array();
//                //Model_notice_array ema = new Model_notice_array(obj.getString("email"));
//                Log.d("About", "onResponse: lllllllllllllllll"+obj.getString("email"));
//                //mlistemail.add(ema);
//                //list.add("Select Email to Send");
//                Toast.makeText(this, "run"+obj.getString("name")+obj.getString("address"), Toast.LENGTH_SHORT).show();
//            }


            //click listener on spinner items

//        } catch (JSONException e)
//        {
//            e.printStackTrace();
//        }
    }




