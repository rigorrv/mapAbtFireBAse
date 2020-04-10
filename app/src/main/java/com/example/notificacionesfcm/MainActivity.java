package com.example.notificacionesfcm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.Manifest;
import android.animation.Animator;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import static android.content.ContentValues.TAG;


public class MainActivity extends AppCompatActivity {


    int contando=0;

    LinearLayout okayBTN;
    LinearLayout menuHome;
    LinearLayout warningWindow;
    ImageView logotipo;
    LottieAnimationView animation_view;
    LottieAnimationView ballion_Animation;
    int flag = 0;

    ArrayList<String> numberlist = new ArrayList<>();

    int contador;
    private Timer timer;
    private TimerTask timerTask;
    private Handler handler = new Handler();
    public static int LocationSection;
    public static Boolean tablet;


    public static boolean isClicked = false;
    Button totoB;

    Set<String> getListValueFromKey;
    Set<String> getListValueFromKeyID;
    Set<String> getListValueFromKeyMeet;
    Set<String> getListValueFromKeyNotfy;
    Set<String> getListValueFromSchedule;

    SharedPreferences sharedPreferences;
    SharedPreferences sharedPreferencesWrning;
    SharedPreferences sharedPreferencesID;
    SharedPreferences sharedPreferencesMeeting;
    SharedPreferences sharedPreferencesNotify;
    SharedPreferences sharedPreferencesSchedule;

    public static final String PREFS_NAME = "namefile";
    public static final String PREFS_WARNING = "warning";
    public static final String PREFS_ID = "idfile";
    public static final String PREFS_Meet = "idMeeting";
    public static final String PREFS_Noty = "notifications";
    public static final String PREFS_Schudele = "schudelmeetings";



    Object[] resourceArray;
    Object[] resourceArrayTXT;

    int newButtonFav;
    int id = 0;
    int identification = 0;

    String LatitudInfo;
    String LongitudInfo;

    int f = 0;

    String calle;
    Double latitudNumber;
    Double longitudNumber;

    private static final String FILE_NAME = "example.txt";

    String text;

    String valores;

    private static final int REQUEST_LOCATION = 1;

    public static Boolean introAnimation = true;
    public static Boolean Notifications = true;
    public static Boolean NotificationsBoolena = true;
    public static String sort = "1";
    public static String textShorting= "Sorting by Time";
    public static Boolean RegularMeeting = true;
    public static int Day;
    public static String direccion;
    public static String dayLongName;
    public static int DayMonthSchedule;
    public static int yearSchedule;
    Button button;
    TextView textview;
    Context contextos;

    Context context;
    public static LocationManager locationManager;
    static boolean GpsStatus;

    public static String lattitude, longitude;

    public static Boolean citySerch = false;

    double latti;
    double longi;

    public static Boolean meetingAdded = false;

    String weekDay;


    int currentHour24;
    int currentMIN24;
    int currentSeg24;

    int currentHour12;
    int currentMin12;

    String Hour24;
    String Hour12;

    int currentDay;
    String DayString;


    RelativeLayout loadingWindiow;

    private static final String registerUrl = "http://ec2-18-224-214-122.us-east-2.compute.amazonaws.com/api/shared/install.php";


    ListView listView;
    ListView listViewName;
    TextView lista;
    JSONObject jsonObject = null;
    JSONObject info = null;

    String downloadJSONNew;

    RequestQueue queue;
    String data = "";
    RequestQueue requestQueue;
    TextView results;
    ListView jsonData;

    String JsonURL = "https://raw.githubusercontent.com/ianbar20/JSON-Volley-Tutorial/master/Example-JSON-Files/Example-Object.JSON";


    String idNumber;

    Object[] resourceArrayID;

    String today;

    String MonthToday;

    Integer numberDay;

    Integer yearToday;

    String ourDate;

    public static Double CityLat,CityLong;

    public static Boolean serachCity = false;
    private static final int WIZARD_NOTIFICATION_ID = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RegularMeeting = true;


        Log.d("mi token es", ""+FirebaseInstanceId.getInstance().getToken());

        //

        sort = "1";
        serachCity = false;

        requestQueue = Volley.newRequestQueue(this);


        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        loadingWindiow = findViewById(R.id.loadingWindiow);


        Calendar rightNow = Calendar.getInstance();
        currentHour24 = rightNow.get(Calendar.HOUR_OF_DAY); // return the hour in 24 hrs format (ranging from 0-23)
        currentMIN24 = rightNow.get(Calendar.MINUTE); // return the hour in 24 hrs format (ranging from 0-23)
        currentDay = rightNow.get(Calendar.DAY_OF_WEEK); // return the hour in 24 hrs format (ranging from 0-23)
        currentSeg24 = rightNow.get(Calendar.SECOND);



        loadingWindiow.setVisibility(View.GONE);

        Hour24 = currentHour24 + ":" + currentMIN24 + ":"+currentSeg24;

        Day = currentDay - 1;

        Calendar calendar = Calendar.getInstance();
        int dia = calendar.get(Calendar.DAY_OF_WEEK);
        int mes = calendar.get(Calendar.MONTH);
        numberDay = calendar.get(Calendar.DAY_OF_MONTH);
        yearToday = calendar.get(Calendar.YEAR);


        //switch day
        switch (dia) {
            case Calendar.SUNDAY:
                // Current day is Sunday
                Log.d("hoy es","Sun");
                today = "Sun";
                break;
            case Calendar.MONDAY:
                // Current day is Monday
                Log.d("hoy es","Mon");
                today = "Mon";
                break;
            case Calendar.TUESDAY:
                // etc.
                Log.d("hoy es","Tue");
                today = "Tue";
                break;
            case Calendar.WEDNESDAY:
                // etc.
                Log.d("hoy es","Wen");
                today = "Wen";
                break;
            case Calendar.THURSDAY:
                // etc.
                Log.d("hoy es","Thu");
                today = "Thu";
                break;
            case Calendar.FRIDAY:
                // etc.
                Log.d("hoy es","Fri");
                today = "Fri";
                break;
            case Calendar.SATURDAY:
                // etc.
                Log.d("hoy es","Sat");
                today = "Sat";
                break;
        }

        //switch month
        switch (mes) {
            case Calendar.JANUARY:
                // Current day is january
                Log.d("el mes es","Jan");
                MonthToday = "Jan";
                break;
            case Calendar.FEBRUARY:
                // Current day is Frebruary
                Log.d("el mes es","Feb");
                MonthToday = "Feb";
                break;
            case Calendar.MARCH:
                // etc.
                Log.d("el mes es","Mar");
                MonthToday = "Mar";
                break;
            case Calendar.APRIL:
                // etc.
                Log.d("el mes es","Apr");
                MonthToday = "Apr";
                break;
            case Calendar.MAY:
                // etc.
                Log.d("el mes es","May");
                MonthToday = "May";
                break;
            case Calendar.JUNE:
                // etc.
                Log.d("el mes es","Jun");
                MonthToday = "Jun";
                break;
            case Calendar.JULY:
                // etc.
                Log.d("el mes es","Jul");
                MonthToday = "Jul";
                break;
            case Calendar.AUGUST:
                // etc.
                Log.d("el mes es","Aug");
                MonthToday = "Aug";
                break;
            case Calendar.SEPTEMBER:
                // etc.
                Log.d("el mes es","Sep");
                MonthToday = "Sep";
                break;
            case Calendar.OCTOBER:
                // etc.
                Log.d("el mes es","Oct");
                MonthToday = "Oct";
                break;
            case Calendar.NOVEMBER:
                // etc.
                Log.d("el mes es","Nov");
                MonthToday = "Nov";
                break;
            case Calendar.DECEMBER:
                // etc.
                Log.d("el mes es","Dec");
                MonthToday = "Dec";
                break;
        }


        ourDate = ""+today+" "+MonthToday+" "+numberDay+" "+Hour24+" "+yearToday;

        Log.d("nuestra fecha es", ""+ourDate);

        //Log.d("la fecha es", ""+today+" "+MonthToday+" "+numberDay+" "+Hour24+" "+yearToday);





        DayString = String.valueOf(Day);



        Log.d("todayIs", "" + DayString);

        Log.d("hour24", "" + Hour24);


        Log.d("weekday", "" + weekDay);


        isDeviceTablet();

        startTimerFull();
        hideNavigationBar();
        //VAR BUTTOMS
        //FIND BUTTOS IN ACTIVITY
        //NewVentana();
        //saveTxT();
        animation_view = findViewById(R.id.animation_view);
        //ballion_Animation = findViewById(R.id.ballion_Animation);
        menuHome = (LinearLayout) findViewById(R.id.menuHome);
        menuHome.setVisibility(View.GONE);

        warningWindow = (LinearLayout) findViewById(R.id.warningWindow);
        warningWindow.setVisibility(View.GONE);

        okayBTN = (LinearLayout) findViewById(R.id.okayBTN);


//lottie code
        if (introAnimation == true) {
            animation_view.setVisibility(View.VISIBLE);
            //Toast.makeText(MainActivity.this, "Boo!!", Toast.LENGTH_SHORT).show();
             animation_view.isAnimating();
            animation_view.playAnimation();
        }

        if (introAnimation == false) {
             animation_view.setVisibility(View.GONE);
            //Toast.makeText(MainActivity.this, "Boo!!", Toast.LENGTH_SHORT).show();
             animation_view.pauseAnimation();
            //ballion_Animation.playAnimation();
        }


        animation_view.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                //Log.d("animation", "Start");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("animation", "animation eds");
                introAnimation = false;
                //ballion_Animation.playAnimation();
                animation_view.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });



        //for favorites
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);//store or retrieved file "namefile.xml".
        getListValueFromKey = sharedPreferences.getStringSet("myFields", new HashSet<String>());


        //for warning MSG
        sharedPreferencesWrning = getSharedPreferences(PREFS_WARNING, Context.MODE_PRIVATE);//store or retrieved file "warning.xml".
        getListValueFromKey = sharedPreferencesWrning.getStringSet("myFields", new HashSet<String>());

        //for My ID File
        sharedPreferencesID = getSharedPreferences(PREFS_ID, Context.MODE_PRIVATE);//store or retrieved file "idfile.xml".
        getListValueFromKeyID = sharedPreferencesID.getStringSet("myFields", new HashSet<String>());

        //for My meeting File
        sharedPreferencesMeeting = getSharedPreferences(PREFS_Meet, Context.MODE_PRIVATE);//store or retrieved file "idfile.xml".
        getListValueFromKeyMeet = sharedPreferencesMeeting.getStringSet("myFields", new HashSet<String>());

        //for My Notifications File
        sharedPreferencesNotify = getSharedPreferences(PREFS_Noty, Context.MODE_PRIVATE);//store or retrieved file "idfile.xml".
        getListValueFromKeyNotfy = sharedPreferencesNotify.getStringSet("myFields", new HashSet<String>());

        //for My Notifications File
        sharedPreferencesSchedule = getSharedPreferences(PREFS_Schudele, Context.MODE_PRIVATE);//store or retrieved file "idfile.xml".
        getListValueFromSchedule = sharedPreferencesSchedule.getStringSet("myFields", new HashSet<String>());

        okayBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                downloadJSONNew = "http://ec2-18-224-214-122.us-east-2.compute.amazonaws.com/api/shared/install.php?Timestamp=" + currentDay + "&Latitude=" + lattitude + "&Longitude=" + longitude;

                Log.d("addingID", "ok");
                registernewuser();

                menuHome.setVisibility(View.VISIBLE);
                warningWindow.setVisibility(View.GONE);

                //create the file: warning.xml
                //getListValueFromKey.add("");
                SharedPreferences.Editor editorWarning = sharedPreferencesWrning.edit();
                editorWarning.clear(); //[important] Clearing your editor before using it.
                //editor.putStringSet("myFields", getListValueFromKey);
                editorWarning.commit();


            }
        });

        //Create favorites files
        File fileXML = new File("/data/data/com.example.notificacionesfcm/shared_prefs/namefile.xml");
        if (fileXML.exists()) {
            Log.d("MIArchivo", "existe");
            warningWindow.setVisibility(View.GONE);
        } else {

            //create the file
            //getListValueFromKey.add("");
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear(); //[important] Clearing your editor before using it.
            //editor.putStringSet("myFields", getListValueFromKey);
            editor.commit();
        }




        //create Warning MSG file
        File warningMsg = new File("/data/data/com.example.notificacionesfcm/shared_prefs/warning.xml");
        if (warningMsg.exists()) {
            menuHome.setVisibility(View.VISIBLE);
            Log.d("Warning", "existe");

        } else {
            warningWindow.setVisibility(View.VISIBLE);
            Log.d("Warning", "Doesn't existe");

        }

        //create idfile.xml MSG file
        File idFile = new File("/data/data/com.example.notificacionesfcm/shared_prefs/idfile.xml");
        if (idFile.exists()) {
            menuHome.setVisibility(View.VISIBLE);
            Log.d("Warning", "existe");

            sharedPreferencesID = getSharedPreferences(PREFS_ID, Context.MODE_PRIVATE);//store or retrieved file "idfile.xml".
            String prefname = sharedPreferencesID.getString("name", "Not Found");
            Log.d("valor en idfile.xml",""+prefname);



        } else {
            warningWindow.setVisibility(View.VISIBLE);
            Log.d("idfile", "Doesn't existe");

        }

        //create idMeeting.xml MSG file
        File meetingFile = new File("/data/data/com.example.notificacionesfcm/shared_prefs/idMeeting.xml");
        if (meetingFile.exists()) {
            Log.d("Warning", "existe");
            sharedPreferencesMeeting = getSharedPreferences(PREFS_Meet, Context.MODE_PRIVATE);//store or retrieved file "idfile.xml".
            String prefname = sharedPreferencesMeeting.getString("name", "Not Found");
            Log.d("valor en idMeeting.xml",""+prefname);
        } else {
            Log.d("idfile", "Doesn't existe");
            SharedPreferences.Editor editorMeeting = sharedPreferencesMeeting.edit();
            editorMeeting.clear(); //[important] Clearing your editor before using it.
            //editor.putStringSet("myFields", getListValueFromKey);
            editorMeeting.commit();

        }


        //create Notifications.xml MSG file
        File notificationsFile = new File("/data/data/com.example.notificacionesfcm/shared_prefs/notifications.xml");
        if (notificationsFile.exists()) {
            Log.d("notificationsFile", "existe");
            sharedPreferencesNotify = getSharedPreferences(PREFS_Noty, Context.MODE_PRIVATE);//store or retrieved file "idfile.xml".
            String prefname = sharedPreferencesNotify.getString("name", "Not Found");
            Log.d("valor en idMeeting.xml",""+prefname);
        } else {
            Log.d("notificationsFile", "Doesn't existe");
            SharedPreferences.Editor editorNotify = sharedPreferencesNotify.edit();
            editorNotify.putString("Notificaciones", "true");
            //editorNotify.commit();
            editorNotify.apply();

        }


        //create Notifications.xml MSG file
        File scheduleFile = new File("/data/data/com.example.notificacionesfcm/shared_prefs/schudelmeetings.xml");
        if (scheduleFile.exists()) {
            Log.d("notificationsFile", "existe");
            sharedPreferencesSchedule = getSharedPreferences(PREFS_Noty, Context.MODE_PRIVATE);//store or retrieved file "idfile.xml".
            String prefname = sharedPreferencesSchedule.getString("name", "Not Found");
        } else {
            Log.d("schudelmeetings", "Doesn't existe");
            SharedPreferences.Editor editorSchedule = sharedPreferencesSchedule.edit();
            //editorNotify.commit();
            editorSchedule.clear(); //[important] Clearing your editor before using it.
            //editor.putStringSet("myFields", getListValueFromKey);
            editorSchedule.commit();

        }



        resourceArray = getListValueFromKey.toArray();


        if (Arrays.asList(resourceArray).contains("Latitud")) {
            // true
            Log.d("myArray", "si contiene true");
        }

        for (int i = 0; i < resourceArray.length; i++) {
            Log.d(" Array", "" + resourceArray[0]);

        }
        //convert object into String
        LatitudInfo = String.valueOf(resourceArray);
        LongitudInfo = String.valueOf(resourceArray);


        logotipo = (ImageView) findViewById(R.id.logotipo);

        logotipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contando += 1;
                Log.d("contando",""+contando);
                if(contando == 20) {
                    Toast.makeText(MainActivity.this, ""+FirebaseInstanceId.getInstance().getToken(), Toast.LENGTH_SHORT).show();
                    Log.d("mi token es", "" + FirebaseInstanceId.getInstance().getToken());
                    contando = 0;
                }
            }
        });


        context = getApplicationContext();
        CheckGpsStatus();
        if (GpsStatus == true && locationManager != null) {
            Log.d("checagps", "SI");
        } else {
            Log.d("checagps", "NO");
        }

        getLocation();


        if (lattitude == null && longitude == null) {
            Log.d("latitud", "" + lattitude);
            Log.d("longitud", "" + longitude);
        } else {
            Log.d("mylatitud", "" + lattitude);
            Log.d("mylongitud", "" + longitude);
        }



    }

    public void myButtonOnClick(View v) {
        switch (v.getId()) {


        }

        // put your logic here.
        Log.d("myClick", "this" + id);

    }

    public void sendWebSite(View view) {


        Intent viewIntent =
                new Intent("android.intent.action.VIEW",
                        Uri.parse("https://detoxtorehab.com"));
        startActivity(viewIntent);

    }

    public void alcoholicsBTN(View view) throws IOException {
        loadingWindiow.setVisibility(View.VISIBLE);
        String name = "1";
        String add = "black";
        Log.d("myTag", "1");
        checkNotifyButton();
        NewVentana();
        LocationSection = 1;


    }

    public void heroineBTN(View view) throws IOException {
        loadingWindiow.setVisibility(View.VISIBLE);

        String name = "2";
        String add = "black";
        Log.d("myTag", "2");
        checkNotifyButton();
        NewVentana();
        LocationSection = 2;


    }

    public void narcoticsBTN(View view) throws IOException {
        loadingWindiow.setVisibility(View.VISIBLE);

        String name = "2";
        String add = "black";
        Log.d("myTag", "2");
        checkNotifyButton();
        NewVentana();
        LocationSection = 3;


    }

    public void cocaineBTN(View view) throws IOException {
        loadingWindiow.setVisibility(View.VISIBLE);
        String name = "2";
        String add = "black";
        Log.d("myTag", "2");
        checkNotifyButton();
        NewVentana();
        LocationSection = 4;


    }

    public void narBTN(View view) throws IOException {
        loadingWindiow.setVisibility(View.VISIBLE);
        String name = "2";
        String add = "black";
        Log.d("myTag", "2");
        checkNotifyButton();
        NewVentana();
        LocationSection = 5;


    }

    public void anonBTN(View view) throws IOException {
        loadingWindiow.setVisibility(View.VISIBLE);
        String name = "2";
        String add = "black";
        Log.d("myTag", "2");
        checkNotifyButton();
        NewVentana();
        LocationSection = 6;


    }

    public void cmaBTN(View view) throws IOException {
        loadingWindiow.setVisibility(View.VISIBLE);
        String name = "2";
        String add = "black";
        Log.d("myTag", "2");
        checkNotifyButton();
        NewVentana();
        LocationSection = 7;


    }

    public void celebrityBTN(View view) throws IOException {
        loadingWindiow.setVisibility(View.VISIBLE);
        String name = "2";
        String add = "black";
        Log.d("myTag", "2");
        checkNotifyButton();
        NewVentana();
        LocationSection = 8;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //here you can handle orientation change
    }

    public void NewVentana() {
        CheckGpsStatus();

        /*
            hideNavigationBar();
            Intent startNewActivity = new Intent(this, MapsActivity.class);
            startActivity(startNewActivity);
*/

        //change to true for restrict access to the app
        if (GpsStatus == true) {


            hideNavigationBar();
            Intent startNewActivity = new Intent(this, MapsActivity.class);
            startActivity(startNewActivity);
            finish();



        } else {
            Toast.makeText(MainActivity.this, "You dont have Your Location (GPS) Activate", Toast.LENGTH_SHORT).show();

        }


    }

    //Fullscreen Code  (Interactive)
    private void hideNavigationBar() {
        this.getWindow().getDecorView()
                .setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                );
    }

    //timer for Compare the value true or false (remote Control)
    //To stop timer
    private void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timer.purge();
            Log.d("myTag", "provando el timer");
        }
    }

    //To start timer
    private void startTimerFull() {
        timer = new Timer();
        timerTask = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        hideNavigationBar();
                        // Log.d("MyTag","hola");
                        // getLocation();
                    }
                });
            }
        };
        timer.schedule(timerTask, 1000, 1000);
    }

    private void saveStae(boolean isFavourite) {
        SharedPreferences aSharedPreferenes = this.getSharedPreferences("Favourite", Context.MODE_PRIVATE);
        SharedPreferences.Editor aSharedPreferenesEdit = aSharedPreferenes.edit();
        aSharedPreferenesEdit.putBoolean("State", isFavourite);
        aSharedPreferenesEdit.commit();
    }

    private boolean readStae() {
        SharedPreferences aSharedPreferenes = this.getSharedPreferences("Favourite", Context.MODE_PRIVATE);
        return aSharedPreferenes.getBoolean("State", true);
    }

    void loadInfoXML() {


        if (resourceArray.length > 0) {

            File fileXML = new File("/data/data/com.example.notificacionesfcm/shared_prefs/namefile.xml");
            if (fileXML.exists()) {
                Log.d("MIArchivo", "contine datos");


                resourceArray = getListValueFromKey.toArray();

                //convert object into String
                LatitudInfo = String.valueOf(resourceArray[f]);
                LongitudInfo = String.valueOf(resourceArray[f]);


                //Geting Name, Altitud And Latitud from the XML
                String idValue = LatitudInfo, abr = "*", crr = "/";
                String nameValue = LatitudInfo, abriendo = "+", cerrando = "%";
                String latitudes = LatitudInfo, open = "{", close = "}";
                String longitudes = LatitudInfo, abierto = "(", cerrado = ")";
                idValue = idValue.substring(idValue.indexOf(abr) + 1, idValue.lastIndexOf(crr));
                latitudes = latitudes.substring(latitudes.indexOf(open) + 1, latitudes.lastIndexOf(close));
                longitudes = longitudes.substring(longitudes.indexOf(abierto) + 1, longitudes.lastIndexOf(cerrado));
                nameValue = nameValue.substring(nameValue.indexOf(abriendo) + 1, nameValue.lastIndexOf(cerrando));

                Log.d("FValue", "F Value is " + f + "is" + nameValue);
                Log.d("id", "" + idValue);


                Log.d("Direction", "" + nameValue);
                Log.d("latitud", "" + latitudes);
                Log.d("longitud", "" + longitudes);


            } else {
                Log.d("MIArchivo", "No exist");

            }

        }
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        } else {
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            Location location1 = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            Location location2 = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
            if (location != null) {
                latti = location.getLatitude();
                longi = location.getLongitude();
                lattitude = String.valueOf(latti);
                longitude = String.valueOf(longi);
            } else if (location1 != null) {
                latti = location1.getLatitude();
                longi = location1.getLongitude();
                lattitude = String.valueOf(latti);
                longitude = String.valueOf(longi);
            } else if (location2 != null) {
                latti = location2.getLatitude();
                longi = location2.getLongitude();
                lattitude = String.valueOf(latti);
                longitude = String.valueOf(longi);
            }
        }


        Log.d("latitud", "" + lattitude);
        Log.d("longitud", "" + longitude);

    }

    public void CheckGpsStatus() {

        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        GpsStatus = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        Log.d("locationManager", "" + locationManager);
    }

    public boolean isDeviceTablet() {
        DisplayMetrics metrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        float yInches = metrics.heightPixels / metrics.ydpi;
        float xInches = metrics.widthPixels / metrics.xdpi;
        double diagonalInches = Math.sqrt(xInches * xInches + yInches * yInches);
        if (diagonalInches >= 6.5) {
            Log.d("dispositivo", "Tablet");
            tablet = true;
            return true;

        }
        Log.d("dispositivo", "Telefono");
        tablet = false;

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // Make to run your application only in portrait mode
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); // Make to run your application only in LANDSCAPE mode

        return false;
    }





    private void registernewuser() {
        StringRequest request = new StringRequest(Request.Method.POST, registerUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Message", "" + response);
                if (response.contains("ID")) {
                    try {
                        // JSONObject obj = new JSONObject(response);
                        // Log.d("this is my ID", obj.toString());
                        JSONArray arr = new JSONArray("["+response+"]");
                        JSONObject obj = arr.getJSONObject(0);
                        idNumber = obj.getString("ID");
                        Log.d("esta es mi ID", idNumber.toString());
                        Log.d("mi ID",""+ idNumber);
                        SharedPreferences.Editor editorID = sharedPreferencesID.edit();
                        getListValueFromKeyID.add(""+idNumber);
                        String cero = "";
                        editorID.clear(); //[important] Clearing your editor before using it.
                        editorID.putString("name",idNumber);
                        editorID.commit();
                    } catch (Throwable t) {
                        Log.e("My App", "Could not parse malformed JSON: \"" + response + "\"");
                    }
                    try {
                        JSONObject object = new JSONObject(response);
                        JSONArray array = object.names();
                        Log.d("myJSON", "" + array);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(getApplicationContext(), "Welcome!!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Error Registering New User", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Timestamp", ourDate);
                params.put("Latitude", lattitude);
                params.put("Longitude", longitude);
                params.put("Token", FirebaseInstanceId.getInstance().getToken());

                //params.put("Day", DayString);
                return params;
                // downloadJSON("http://ec2-18-224-214-122.us-east-2.compute.amazonaws.com/api/shared/install.php?Latitude="+lattitude+"&Longitude="+longitude);
            }


        };

        Volley.newRequestQueue(this).add(request);
    }


    public void checkNotifyButton() throws IOException {
        File fileXML = new File("/data/data/com.example.notificacionesfcm/shared_prefs/notifications.xml");
        FileInputStream in = new FileInputStream(fileXML);
        int len = 0;
        byte[] data1 = new byte[1024];
        while (-1 != (len = in.read(data1))) {
            if (new String(data1, 0, len).contains("true")) {
                MainActivity.Notifications = true;

            }
            if (new String(data1, 0, len).contains("false")) {
                MainActivity.Notifications = false;

            }
        }
    }





}
