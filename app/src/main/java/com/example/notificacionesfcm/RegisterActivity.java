package com.example.notificacionesfcm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

//import android.support.v7.app.AppCompatActivity;
//import com.vicmikhailau.maskededittext.MaskedEditText;

public class RegisterActivity extends AppCompatActivity {

    EditText cityLocation, stateLocation, meetingName, addressLocation, regZipCode ;

    //EditText[] fieldText = { cityLocation, stateLocation, meetingName, addressLocation, regZipCode };
    LinearLayout btnRegister;
    LinearLayout timeLinear;
    ImageView menuBAckBTN1;
    LinearLayout dayWeek0;
    LinearLayout dayWeek1;
    LinearLayout dayWeek2;
    LinearLayout dayWeek3;
    LinearLayout dayWeek4;
    LinearLayout dayWeek5;
    LinearLayout dayWeek6;
    EditText info;


    private TextView textView;


    double Latitud;
    double Longitud;


    String weekDay;

    public static int CounterBackBtn;
    String flag;

    String conected = "1";
    String approved = "1";

    Boolean pardotCheck =false;
    Boolean webCheck = false;

    LinearLayout signup;

    LinearLayout meetingAcordion;
    LinearLayout meetingAcordionBTN;


    LinearLayout formAcordionBTN;
    LinearLayout formAcordion;
    ImageView checkMArk1;
    ImageView checkMArk2;
    ImageView icon_meeting_bg;
    ImageView icon_meeting_demo;
    private Integer[] meetingteBTNTogle = { R.drawable.icon_1, R.drawable.icon_1, R.drawable.icon_2, R.drawable.icon_3, R.drawable.icon_4, R.drawable.icon_5, R.drawable.icon_6, R.drawable.icon_7, R.drawable.icon_8 };
    String [] meetingTypeData = {"", "Alcoholis Anonimous", "Heroin Anonymous", "Narcotics Anonymous", "Cocaine Anonymous", "Nar Anon", "Anon", "CMA", "Celebrate Recovery"};
    LinearLayout[] meetingBTN;
    LinearLayout [] weekDays;
    TextView meeting_type;
    EditText timeEvent;
    LinearLayout currentLocation;
    int[] allbuttons;
    String lat;
    String lng;



    String temporalat = "33.5318713";
    String tempralLong = "-112.159194";




    Boolean meetingAcord = false;


    int contador;
    private Timer timer;
    private TimerTask timerTask;
    private Handler handler = new Handler();


    //private static final String registerUrl="http://oldslurry.com/registeruser_app.php";

    //Kourtis URL
    private static final String registerUrl="http://ec2-18-224-214-122.us-east-2.compute.amazonaws.com/api/meeting/create.php";

    //mine
    //private static final String registerUrl="http://nonstopcode.com/testmydb/registeruser_app.php";


    int AMPMint;

    int currentHour24;
    int currentMIN24;

    int currentHour12;
    int currentMin12;

    String Hour24;
    String Hour12;

    int currentDay;
    int Day;
    String DayString;

    Set<String> getListValueFromKeyID;
    public static final String PREFS_ID = "idfile";
    SharedPreferences sharedPreferencesID;

    String idValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Calendar rightNow = Calendar.getInstance();
        currentHour24 = rightNow.get(Calendar.HOUR_OF_DAY); // return the hour in 24 hrs format (ranging from 0-23)
        currentMIN24 = rightNow.get(Calendar.MINUTE); // return the hour in 24 hrs format (ranging from 0-23)
        currentDay = rightNow.get(Calendar.DAY_OF_WEEK); // return the hour in 24 hrs format (ranging from 0-23)


        Hour24 = currentHour24+":"+currentMIN24;

        Day = currentDay - 1;


        DayString = String.valueOf(Day);


        Log.d("todayIs",""+DayString);

        Log.d("hour24",""+Hour24);


        Log.d("weekday","" + weekDay);


        hideNavigationBar();
        startTimerFull();

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        meetingBTN = new  LinearLayout[8];
        allbuttons = new  int [8];

        weekDays = new LinearLayout[7];
        regZipCode = findViewById(R.id.regZipCode);
        cityLocation=findViewById(R.id.cityLocation);
        stateLocation=findViewById(R.id.stateLocation);
        meetingName=findViewById(R.id.meetingName);
        addressLocation=findViewById(R.id.addressLocation);
        meetingAcordion=findViewById(R.id.meetingAcordion);
        meetingAcordion.setVisibility(View.GONE);
        meetingAcordionBTN=findViewById(R.id.meetingAcordionBTN);
        formAcordion=findViewById(R.id.formAcordion);
        formAcordionBTN=findViewById(R.id.formAcordionBTN);
        formAcordion.setVisibility(View.GONE);
        checkMArk1=findViewById(R.id.checkMArk1);
        checkMArk1.setVisibility(View.GONE);
        checkMArk2=findViewById(R.id.checkMArk2);
        icon_meeting_bg=findViewById(R.id.icon_meeting_bg);
        icon_meeting_demo=findViewById(R.id.icon_meeting_demo);
        meeting_type=findViewById(R.id.meeting_type);
        timeEvent=findViewById(R.id.timeEvent);
        currentLocation=findViewById(R.id.currentLocation);
        timeLinear=findViewById(R.id.timeLinear);
        menuBAckBTN1=findViewById(R.id.menuBAckBTN1);
        dayWeek0=findViewById(R.id.dayWeek0);
        dayWeek1=findViewById(R.id.dayWeek1);
        dayWeek2=findViewById(R.id.dayWeek2);
        dayWeek3=findViewById(R.id.dayWeek3);
        dayWeek4=findViewById(R.id.dayWeek4);
        dayWeek5=findViewById(R.id.dayWeek5);
        dayWeek6=findViewById(R.id.dayWeek6);
        info=findViewById(R.id.info);

        meeting_type.setEnabled(false);






        for (int i = 0; i < meetingBTN.length; i++) {
            //add icon to the button
            String meetingBTName = "meetingBTN" + (i);
            int meetingInfoID = getResources().getIdentifier(meetingBTName, "id", getPackageName());
            meetingBTN[i] = ((LinearLayout) findViewById(meetingInfoID));


            meetingBTN[i].setId(i);
            meetingBTN[i].setClickable(true);


            final int finalI = i+1;
            meetingBTN[i].setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                public void onClick(View v) {

                    icon_meeting_bg.setVisibility(View.VISIBLE);
                    icon_meeting_demo.setVisibility(View.GONE);
                    Log.d("click","you Click " + finalI);
                    icon_meeting_bg.setBackgroundResource(meetingteBTNTogle[finalI]);
                    meeting_type.setText(meetingTypeData[finalI]);
                    meetingAcordion.setVisibility(View.GONE);
                    flag = String.valueOf(finalI);

                    Log.d("meetingType", ""+flag);
                    Log.d("meetingType", ""+meetingTypeData[finalI]);

                }
            });

        }

        for (int i = 0; i < weekDays.length; i++) {
            //add icon to the button
            String dayWeekName = "dayWeek" + (i);
            int weekDaysID = getResources().getIdentifier(dayWeekName, "id", getPackageName());
            weekDays[i] = ((LinearLayout) findViewById(weekDaysID));
            weekDays[i].setId(i);
            weekDays[i].setClickable(true);
            final int finalI = i;
            weekDays[i].setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                public void onClick(View v) {
                    Log.d("click","you Click " + finalI);

                    changeDaysBg();
                    weekDays[finalI].setBackgroundResource(R.drawable.bluebtn_bg);
                    if(finalI == 0){
                        weekDay = "sunday";
                    }
                    if(finalI == 1){
                        weekDay = "Monday";

                    }if(finalI == 2){
                        weekDay = "Tuesday";

                    }if(finalI == 3){
                        weekDay = "Wednesday";

                    }if(finalI == 4){
                        weekDay = "Thursday";

                    }if(finalI == 5){
                        weekDay = "Friday";

                    }if(finalI == 6){
                        weekDay = "Saturday";

                    }

                    Log.d("myTag", ""+weekDay);

                }
            });

        }


        btnRegister=findViewById(R.id.btnRegister);
                btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Waiting For Server", Toast.LENGTH_LONG).show();
                if (weekDay == null){
                    Log.d("do","Nothing");
                    Toast.makeText(getApplicationContext(), "Error you need to Fill the Form", Toast.LENGTH_LONG).show();
                }else {
                convertAddress();
                registernewuser();

                   // newRecord();

                }
            }
        });



        meetingAcordionBTN.setOnClickListener(
                        new View.OnClickListener()
                        {
                            public void onClick(View v)
                            {
                                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                                if(inputMethodManager != null && inputMethodManager.isActive()) {
                                    if (getCurrentFocus() != null) {
                                        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                                    }
                                }
                                if (meetingAcordion.getVisibility() == View.VISIBLE)
                                {
                                    meetingAcordion.setVisibility(View.GONE);
                                }
                                else
                                {
                                    meetingAcordion.setVisibility(View.VISIBLE);
                                }
                            }
                        }
                );

        formAcordionBTN.setOnClickListener
                (
                        new View.OnClickListener()
                        {
                            public void onClick(View v)
                            {
                                checkMArk1.setVisibility(View.VISIBLE);
                                checkMArk2.setVisibility(View.GONE);
                                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                                if(inputMethodManager != null && inputMethodManager.isActive()) {
                                    if (getCurrentFocus() != null) {
                                        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                                    }
                                }
                                if (formAcordion.getVisibility() == View.VISIBLE)
                                {
                                    formAcordion.setVisibility(View.GONE);
                                }
                                else
                                {
                                    formAcordion.setVisibility(View.VISIBLE);

                                }
                            }
                        }
                );
        currentLocation.setOnClickListener
                (
                        new View.OnClickListener()
                        {
                            public void onClick(View v)
                            {
                                checkMArk1.setVisibility(View.GONE);
                                checkMArk2.setVisibility(View.VISIBLE);
                                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                                if(inputMethodManager != null && inputMethodManager.isActive()) {
                                    if (getCurrentFocus() != null) {
                                        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                                    }
                                }
                                if (formAcordion.getVisibility() == View.VISIBLE)
                                {
                                    formAcordion.setVisibility(View.GONE);
                                }
                                else
                                {
                                    formAcordion.setVisibility(View.GONE);
                                }
                            }
                        }
                );


   timeEvent.setOnTouchListener(new View.OnTouchListener() {
       @Override
       public boolean onTouch(View v, MotionEvent event) {
           Log.d("click","hide formAcordion");
           formAcordion.setVisibility(View.GONE);
           checkMArk2.setVisibility(View.GONE);

           //String checkName = fieldText.toString();

           return false;
       }
   });

        menuBAckBTN1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewVentana();
            }
        });


        //for My ID File
        sharedPreferencesID = getSharedPreferences(PREFS_ID, Context.MODE_PRIVATE);//store or retrieved file "idfile.xml".
        getListValueFromKeyID = sharedPreferencesID.getStringSet("myFields", new HashSet<String>());
        //create idfile.xml MSG file
        File idFile = new File("/data/data/com.example.mysqlmap/shared_prefs/idfile.xml");
        if (idFile.exists()) {
            Log.d("idfile.xml", "existe");
            sharedPreferencesID = getSharedPreferences(PREFS_ID, Context.MODE_PRIVATE);//store or retrieved file "idfile.xml".
            idValue = sharedPreferencesID.getString("name", "Not Found");
            Log.d("valor en idfile.xml",""+idValue);
        } else {
            Log.d("idfile.xml", "Doesn't existe");

        }

    }

//get Latitud and loingitud from address
    private void convertAddress() {
        String direccion = addressLocation.getText().toString()+" "+cityLocation.getText().toString()+" "+stateLocation.getText().toString()+" "+regZipCode.getText().toString();
        Geocoder coder = new Geocoder(this);
        List<Address> addresses;
        try {
            addresses = coder.getFromLocationName(direccion, 5);
            if (addresses == null) {
                Log.i("Lng", "empty");
            }
            else {
                Address location = addresses.get(0);
                Latitud = location.getLatitude();
                Longitud = location.getLongitude();
                //Log.i("Lat", "" + Latitud);
                //Log.i("Lng", "" + Longitud);


                lat = String.valueOf(Latitud);
                lng = String.valueOf(Longitud);

                Log.i("Direction", "" + direccion);

                Log.i("Lat", "" + lat);
                Log.i("Lng", "" + lng);



            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //Register USer to Our Web Server
    private void registernewuser() {

        StringRequest request=new StringRequest(Request.Method.POST, registerUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.contains("Meeting was created.")){
                    MainActivity.meetingAdded = true;

                    //webCheck = true;
                    Toast.makeText(getApplicationContext(), "Successfully Registered user Web Server", Toast.LENGTH_LONG).show();
                    NewVentana();

                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Error Registering New User", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Install", idValue);
                params.put("Name", meetingName.getText().toString());
                params.put("Type", flag);
                params.put("Address", addressLocation.getText().toString()+" "+cityLocation.getText().toString()+" "+stateLocation.getText().toString()+" "+regZipCode.getText().toString());
                params.put("Days", weekDay);
                params.put("Time", timeEvent.getText().toString());
                params.put("Latitude", lat);
                params.put("Longitude", lng);
                params.put("token", lng);

       /*
                params.put("Latitude", temporalat);
                params.put("Longitude", tempralLong);

        */
                params.put("Day", DayString);
                params.put("Comment", info.getText().toString());

                return params;
            }
        };
        Volley.newRequestQueue(this).add(request);
    }

    public void newRecord(){

        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        Map<String, String>  params = new HashMap<String, String>();
        params.put("Install", idValue);
        params.put("Name", meetingName.getText().toString());
        params.put("Type", flag);
        params.put("Address", addressLocation.getText().toString()+" "+cityLocation.getText().toString()+" "+stateLocation.getText().toString()+" "+regZipCode.getText().toString());
        params.put("Days", weekDay);
        params.put("Time", timeEvent.getText().toString());
        params.put("Latitude", lat);
        params.put("Longitude", lng);
        params.put("Day", DayString);
        params.put("Comment", info.getText().toString());


        JsonObjectRequest req = new JsonObjectRequest(registerUrl, new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            VolleyLog.v("Response:%n %s", response.toString(4));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
            }
        })
        {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                String username ="oldslurr";
                String password = "xjHVm2Zyb";

                String auth =new String(username + ":" + password);
                byte[] data = auth.getBytes();
                String base64 = Base64.encodeToString(data, Base64.NO_WRAP);
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Authorization","Basic "+base64);
                return headers;
            }

        };
        requestQueue.add(req);

    }

    //Fullscreen Code  (Interactive)
    private void hideNavigationBar() {
        this.getWindow().getDecorView()
                .setSystemUiVisibility (
                        View.SYSTEM_UI_FLAG_FULLSCREEN  |
                                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                );
    }
    //end  code Fullscreen  (Interactive)


    //timer for Compare the value true or false (remote Control)

    //To start timer
    private void startTimerFull(){
        timer = new Timer();
        timerTask = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run(){
                        hideNavigationBar();
                    }
                });
            }
        };
        timer.schedule(timerTask, 1000, 1000);
    }

    public void NewVentana() {
        hideNavigationBar();


        Intent startNewActivity = new Intent(this, MainActivity.class);
        startActivity(startNewActivity);

    }

    public void changeDaysBg(){
        dayWeek0.setBackgroundResource(R.drawable.bluebtn_bg_meting);
        dayWeek1.setBackgroundResource(R.drawable.bluebtn_bg_meting);
        dayWeek2.setBackgroundResource(R.drawable.bluebtn_bg_meting);
        dayWeek3.setBackgroundResource(R.drawable.bluebtn_bg_meting);
        dayWeek4.setBackgroundResource(R.drawable.bluebtn_bg_meting);
        dayWeek5.setBackgroundResource(R.drawable.bluebtn_bg_meting);
        dayWeek6.setBackgroundResource(R.drawable.bluebtn_bg_meting);
    }





}