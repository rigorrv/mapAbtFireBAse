package com.example.notificacionesfcm;

import android.Manifest;
import android.animation.Animator;
import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.CalendarContract;
import android.renderscript.Sampler;
import android.telephony.SmsManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Rigo Romero on 9/06/2019.
 */
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    LatLng city;


    private static final String CHANNEL_ID = "1";
    private static final int WIZARD_NOTIFICATION_ID = 1;
    TextView timeText;
    TextView timeTextTest;
    LinearLayout infoAbout;
    LinearLayout progressInfo;
    int contadorInfo;
    private Timer timerNotification;
    private Timer timer;
    private TimerTask timerTaskNotification;
    private TimerTask timerTask;
    private Handler handler = new Handler();
    LinearLayout favBtn0;
    LinearLayout favBtn1;
    LinearLayout favBtn2;
    LinearLayout favBtn3;
    LinearLayout favBtn4;
    LinearLayout favBtn5;
    LinearLayout favBtn6;
    LinearLayout favBtn7;
    ImageView menuBAckBTN1;
    ImageView menuBAckBTN2;
    ImageView menuBAckBTN3;
    ImageView menuBAckBTN4;
    ImageView menuBAckBTN5;
    ImageView menuBAckBTN6;
    ImageView menuBAckBTN7;
    ImageView menuBAckBTN8;
    LinearLayout clearFAv;
    String finalNameValue;
    String compareFavoriteONoff;
    Boolean menuFav = false;
    Boolean buttonsMapAtivates = false;
    int idRehabID;
    Double latitudForFav;
    Double longitudForFav;
    Boolean FavoritesWindow = false;
    ImageView menuBTN1;
    ImageView menuBTN2;
    ImageView menuBTN3;
    ImageView menuBTN4;
    ImageView menuBTN5;
    ImageView menuBTN6;
    ImageView menuBTN7;
    ImageView menuBTN8;
    int PaddingForStreet = 32;
    Boolean MapaWindo = true;
    //current Location
    private static final int REQUEST_LOCATION = 1;
    Button button;
    TextView textView;
    //LocationManager MainActivity.locationManager;
    Boolean FavoritesInfo = false;
    Boolean favItem = false;
    //Variables Layout
    int centerRehabId = 0;
    Set<String> getListValueFromKey;
    Set<String> tempArrayList;
    String[] targetArray;
    SharedPreferences sharedPreferences;
    public static final String PREFS_NAME = "namefile";
    Object[] resourceArray;
    Object[] stringNameeArray;
    Object[] newXMList;
    LinearLayout[] favTNitem;
    LinearLayout[] favClick;
    ImageView[] exitFav;
    TextView[] textFavoriteInfo;
    ImageView[] iconFavoriteInfo;
    int newButtonFav;
    int id = 0;
    int identification = 0;
    String LatitudInfo;
    String LongitudInfo;
    int f = 0;
    String calle;
    String identity;
    Double latitudNumber;
    Double longitudNumber;
    private static final String FILE_NAME = "example.txt";
    String text;
    String valores;
    TextView getDirText;
    TextView caleText;
    public static String ColorFavTextOn;
    public static String ColorSelectionLight;
    public static String ColorSelectionDark;
    public static int CounterBackBtn;
    public static String selectToggleBoxColor;
    public static String textTittleColor;
    public static String tittleName;
    String textShortingTitle = "";
    LinearLayout backBTN1;
    LinearLayout backBTN2;
    LinearLayout backBTN3;
    LinearLayout backBTN4;
    LinearLayout backBTN5;
    LinearLayout backBTN6;
    LinearLayout backBTN7;
    LinearLayout backBTN8;
    ImageView logoHeadChange;
    Boolean mapStart = false;
    Boolean byDistance = true;
    Boolean ActivatebyDistance = false;
    Boolean byTime = false;
    Boolean linksActive = false;
    LinearLayout ToggleBoxColor;
    Boolean InfoSelection = false;
    public Boolean botoneraClick = false;
    String info;
    String NameLocationText;
    String identidad;
    String titleDB;
    RelativeLayout accordionOne;
    RelativeLayout accordionTwo;
    RelativeLayout accordionTree;
    RelativeLayout closeMenu;
    int showInCanvas = 0;
    int outOfCanvas = -4000;
    ImageView MeetingBTN;
    Button backFromMeeting;
    LinearLayout backFromFavorites;
    Button noClose;
    Button yesClose;
    Button goLocationsBTN;
    LinearLayout LayoutButonLocation;
    LinearLayout Favorities;
    Boolean closeThisMenu = false;
    LinearLayout tituloMenu;
    LinearLayout buttonsMapLink;
    RelativeLayout mapaLayoutContenido;
    RelativeLayout linksMap;
    LinearLayout favoriteBox;
    LinearLayout linksColorMap;
    LinearLayout ButtonsMap;
    Double latMap;
    Double lngMap;
    TextView titleInputText;
    TextView titleInputTextOne;
    TextView textShorting;
    LinearLayout TitleBox;
    LinearLayout getDirectionBTN;
    LinearLayout FavoriteBTN;
    LinearLayout emailBTN;
    LinearLayout calendarBTN;
    LinearLayout textBTN;
    TextView textsendText;
    TextView NameLocation;
    Subject subject;
    LinearLayout FavoriteTittleBox;
    View vista;
    String transferInfo;
    TextView emailText;
    Long favoriteValue;
    int favoriteIDOnOf;
    Double latText;
    Double lngText;
    public LatLng userLocation;
    //vars layout
    TextView textViewToChange;
    LinearLayout linearFav;
    Context context;
    LinearLayout linear;
    long identificationMapClick;
    long identificationMapClickDist;
    String miles = "";
    String timeVar = "";
    String[] Herifler = {"Alcoholics Anonymous", "Heroin Anonymous", "Cocaine Anonymous", "Narcotic Anonymous", "Al - Anon", "CMA", "Al - Anon", "CMA", "Al - Anon", "CMA", "Al - Anon", "CMA", "CMA", "CMA", "CMA", "CMA", "CMA", "CMA", "CMA"};
    String title;
    int valor = +0;
    TextView favText;
    //vars mapa
    MapFragment mapFragment;
    public GoogleMap gMap;
    MarkerOptions markerOptions = new MarkerOptions();
    MarkerOptions macandoMapa = new MarkerOptions();
    CameraPosition cameraPosition;
    LatLng center, latLng;
    Boolean request = false;
    LocationManager locationManagerNew;
    LocationListener locationListener;
    public static final String ID = "id";
    public static final String TITLE = "Name";
    public static final String LAT = "Latitude";
    public static final String LNG = "Longitude";
    ListView SubjectFullFormListView;
    ListView SubjectFullFormListViewDistance;
    ProgressBar progressBar;
    ProgressBar progressBar2;
    ListAdapter adapter;
    ListAdapter adapterDistance;
    ListAdapter adapterFavorite;
    List<Subject> SubjectFullFormListInfo;
    List<Subject> SubjectFullFormList;
    List<Subject> SubjectFullFormListDistance;
    EditText editText;
    Boolean favFirstTime = false;
    String flagues = "Type=";
    String Latitudes = "&Latitude=33.86671";
    String Longitudes = "&Longitude=-112.147785";
    String idLocation;
    String cityAdd;
    String DayAdd;
    double latti;
    double longi;
    String HttpURLTime;
    String HTTPTEST;
    String HttpURLLoadinDistanceLocation;
    //String HttpURLLoadinDistance = HttpURLTime + MainActivity.LocationSection + latMap + lngMap;
    String tag_json_obj = "json_obj_req";
    HttpServiceClass HttpTest;
    HttpServiceClass httpServiceClass;
    HttpServiceClass httpServiceClassDistance;
    HttpServiceClass httpServiceClassFav;
    public Marker myMarker;
    Drawable marker;
    int videoCounter = 1;
    int i = 1;
    ToggleButton[] toggles;
    ImageView[] togglesImage;
    ImageView[] togglesImageDist;

    Location lastKnownLocation;
    String enterText = "favoritos";
    int idForIcon = 5;
    private Integer[] mThumbIds = {R.drawable.icon_set, R.drawable.icon_1, R.drawable.icon_2, R.drawable.icon_3, R.drawable.icon_4, R.drawable.icon_5, R.drawable.icon_6, R.drawable.icon_7, R.drawable.icon_8};
    private Integer[] favoriteBTNTogle = {R.drawable.shadow, R.drawable.shadow_ha_on};
    Context contexto;
    Context contextual;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    Button sendBtn;
    EditText txtphoneNo;
    EditText txtMessage;
    String phoneNo;
    String message;
    ImageView closeSMS;
    TextView millageText;
    RelativeLayout smsWindow;
    Uri gmmIntentUri;
    Intent mapIntent;
    String googleDirection = "http://maps.google.com/?q=" + latMap + "," + lngMap;
    String weekDay = "";
    int dayOfWeek;
    int dayOfMonth;
    int MonthNumb;
    int YearNum;
    int SortSelection = 2;
    String TimeInMeeting;
    String subString;
    int TimeInt;
    String distMeeting;
    int AMPMint;
    int currentHour24;
    int currentMIN24;
    //for shcedule meeting
    int currentHour24Schedule;
    int currentMIN24Schedule;

    int currentHour12;
    int currentMin12;
    String Hour24;
    String Hour12;
    int currentDay;
    String currentDayString;
    int currentMonth;
    int currentDayMonth;
    int currentYear;
    int AMPM;
    String AMPMString;
    String compareDate;
    String compareDateTime;
    ImageView[] logosCheckLat;
    int contador;
    TextClock textClock;
    TextClock textClock2;

    EditText EditcitySerch;
    RelativeLayout exitSerchEditText;
    public static double Latitud;
    public static double Longitud;
    ImageView serchAdd;
    RelativeLayout loadingCity;


    LinearLayout noFormat;
    LinearLayout yesFormat;

    RelativeLayout formatAppWindow;
    LinearLayout formatApp;

    RelativeLayout meetingMessage;

    LottieAnimationView[] addingMeetAnim;
    LottieAnimationView[] removeMeetAnim;


    RelativeLayout savingInFav;
    RelativeLayout removingInFav;

    Context contextNotification;

    String idValueMeeting;

    String aprovedMeeting;
    String nameMeeting;
    String idMeetingID;
    String idMeetingLat;
    String idMeetingLong;
    String idMeetingAdd;
    String idMeetingType;

    String registerUrl;
    MediaPlayer aprovedSound;
    MediaPlayer denieddSound;


    Set<String> getListValueFromKeyID;
    public static final String PREFS_ID = "idfile";
    SharedPreferences sharedPreferencesID;

    Set<String> idMeetingPreference;
    public static final String PREFS_IDMeet = "idMeeting";
    SharedPreferences sharedPreferencesIDMeeting;


    LinearLayout notificationsBTN;
    ImageView toggleNotifyON;
    ImageView toggleNotifyOFF;

    Boolean notificationValue;


    Set<String> getListValueFromKeyNotfy;
    SharedPreferences sharedPreferencesNotify;
    public static final String PREFS_Noty = "notifications";

    Set<String> getListValueFromSchedule;
    SharedPreferences sharedPreferencesSchule;
    public static final String PREFS_Schudele = "schudelmeetings";


    LinearLayout togglebyTyme;
    LinearLayout togglebyDitance;

    RelativeLayout loadNewWindow;


    Boolean xmlIdMeeting = false;

    //0 is not waiting // 1 is waiting
    int deniedWaiting = 0;

    String putNameMeeting;

    RelativeLayout scheduleMeeting;

    LinearLayout schudelBTN;
    LinearLayout backFromMeetings;

    RelativeLayout meetingAcordion;
    LinearLayout meetingAcordionBTN;


    LinearLayout formAcordionBTN;
    LinearLayout formAcordion;

    LinearLayout calendario;

    ImageView checkMArk1;
    ImageView checkMArk2;

    LinearLayout[] meetingBTN;

    ImageView icon_meeting_bg;
    ImageView icon_meeting_demo;
    TextView meeting_type;
    private Integer[] meetingteBTNTogle = { R.drawable.icon_1, R.drawable.icon_1, R.drawable.icon_2, R.drawable.icon_3, R.drawable.icon_4, R.drawable.icon_5, R.drawable.icon_6, R.drawable.icon_7, R.drawable.icon_8 };
    String [] meetingTypeData = {"", "Alcoholis Anonimous", "Heroin Anonymous", "Narcotics Anonymous", "Cocaine Anonymous", "Nar Anon", "Anon", "CMA", "Celebrate Recovery"};
    CalendarView simpleCalendarView;
    TextView serchAddres;
    LinearLayout searchSchudele;
    Boolean meetingTipo = false;
    Boolean dayOfMeetingTipo = false;
    Boolean cityOfMeetingTypo =false;
    LinearLayout ProgresBarBox;
    LinearLayout errorLoading;
    RelativeLayout loadingCityAddress;
    LinearLayout searchingFor;
    TextView searchingForText;
    RelativeLayout saveSchedule;
    LinearLayout noSchedule;
    LinearLayout yesSchedule;
    Boolean AddScheduleClicked = false;
    LinearLayout toogleVisivility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //loading the interface depends if there is in regular o in schedule meeting
        if(MainActivity.RegularMeeting == true) {
            setContentView(R.layout.activity_maps);
        }
        if(MainActivity.RegularMeeting == false) {
            setContentView(R.layout.activity_schedule);
        }
        if(MainActivity.RegularMeeting == false) {
            searchingForText = findViewById(R.id.searchingForText);
            searchingForText.setText("Searching: "+MainActivity.direccion + " - "+ MainActivity.dayLongName + " " + MainActivity.DayMonthSchedule + " " + MainActivity.yearSchedule);
        }
        //this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        //Hide Navigation BAr
        hideNavigationBar();





        toogleVisivility = findViewById(R.id.toogleVisivility);
        saveSchedule = findViewById(R.id.saveSchedule);
        saveSchedule.setVisibility(View.GONE);
        noSchedule = findViewById(R.id.noSchedule);
        yesSchedule = findViewById(R.id.yesSchedule);
        loadingCityAddress = findViewById(R.id.loadingCityAddress);
        loadingCityAddress.setVisibility(View.GONE);
        schudelBTN = findViewById(R.id.schudelBTN);

        loadNewWindow= findViewById(R.id.loadNewWindow);
        loadNewWindow.setVisibility(View.GONE);

        togglebyTyme = findViewById(R.id.togglebyTyme);
        togglebyDitance = findViewById(R.id.togglebyDitance);

        togglebyTyme.setVisibility(View.GONE);
        togglebyDitance.setVisibility(View.GONE);

        textShorting = findViewById(R.id.textShorting);
        errorLoading = findViewById(R.id.errorLoading);
        errorLoading.setVisibility(View.GONE);


        if(MainActivity.sort.contains("1")){
            MainActivity.textShorting = "Sorting by Time";
            textShorting.setText(MainActivity.textShorting);

            togglebyTyme.setVisibility(View.VISIBLE);
            togglebyDitance.setVisibility(View.GONE);
        }
        if(MainActivity.sort.contains("2")){
            togglebyDitance.setVisibility(View.VISIBLE);
            togglebyTyme.setVisibility(View.GONE);

            MainActivity.textShorting = "Sorting by Distance";
            textShorting.setText(MainActivity.textShorting);

        }



        Log.d("notificaciones",""+ MainActivity.Notifications);
        //for My ID File
        sharedPreferencesIDMeeting = getSharedPreferences(PREFS_IDMeet, Context.MODE_PRIVATE);//store or retrieved file "idfile.xml".
        idMeetingPreference = sharedPreferencesIDMeeting.getStringSet("myFields", new HashSet<String>());
        aprovedSound = MediaPlayer.create(this, R.raw.accepted);
        denieddSound = MediaPlayer.create(this, R.raw.denied);

        EditcitySerch = (EditText) findViewById(R.id.EditcitySerch);

        checkingMeetingXML();

        //checkMeetingTime();

        serchAdd = (ImageView) findViewById(R.id.serchAdd);

        textClock = (TextClock) findViewById(R.id.simpleDigitalClock);
        textClock.setFormat12Hour("K:ma");

        textClock2 = (TextClock) findViewById(R.id.simpleDigitalClockMenu);
        textClock2.setFormat12Hour("K:ma");

        loadingCity = (RelativeLayout) findViewById(R.id.loadingCity);


        isDeviceTablet();
        if (MainActivity.lattitude == null) {
            hideNavigationBar();
            Intent startNewActivity = new Intent(this, MainActivity.class);
            startActivity(startNewActivity);
            Toast.makeText(MapsActivity.this, "Sorry Try Again. We have a problem triying to get your current Location", Toast.LENGTH_SHORT).show();
        }

        Log.d("latitud", "" + MainActivity.lattitude);
        Log.d("longitud", "" + MainActivity.longitude);

        addingMeetAnim = new LottieAnimationView[8];
        removeMeetAnim = new  LottieAnimationView[8];
        savingInFav=findViewById(R.id.savingInFav);
        savingInFav.setVisibility(View.GONE);
        removingInFav=findViewById(R.id.removingInFav);
        removingInFav.setVisibility(View.GONE);
        sendBtn = (Button) findViewById(R.id.sendBtn);
        txtphoneNo = (EditText) findViewById(R.id.editText);
        txtMessage = (EditText) findViewById(R.id.txtMessage);

        Calendar rightNow = Calendar.getInstance();


        if(MainActivity.RegularMeeting == true) {
            currentHour24 = rightNow.get(Calendar.HOUR_OF_DAY); // return the hour in 24 hrs format (ranging from 0-23)
            currentMIN24 = rightNow.get(Calendar.MINUTE); // return the hour in 24 hrs format (ranging from 0-23)
            currentHour24Schedule = rightNow.get(Calendar.HOUR_OF_DAY); // return the hour in 24 hrs format (ranging from 0-23)
            currentMIN24Schedule = rightNow.get(Calendar.MINUTE); // return the hour in 24 hrs format (ranging from 0-23)
            currentDay = rightNow.get(Calendar.DAY_OF_WEEK); // return the hour in 24 hrs format (ranging from 0-23)
            currentMonth = rightNow.get(Calendar.MONTH);
            currentDayMonth = rightNow.get(Calendar.DAY_OF_MONTH);
            currentYear = rightNow.get(Calendar.YEAR);
            AMPM = rightNow.get(Calendar.AM_PM);
            Hour24 = currentHour24 + ":" + currentMIN24;
            MainActivity.Day = currentDay - 1;
            Log.d("todayIs", "" + MainActivity.Day);
            Log.d("hour24", "" + Hour24);

            if(MainActivity.Day == 1){
                currentDayString = "Monday";
            }
            if(MainActivity.Day == 2) {
                currentDayString = "Tuesday";
            }
            if(MainActivity.Day == 3) {
                currentDayString = "Wednesday";
            }
            if(MainActivity.Day == 4) {
                currentDayString = "Thursday";
            }
            if(MainActivity.Day == 5) {
                currentDayString = "Friday";
            }
            if(MainActivity.Day == 6) {
                currentDayString = "Saturday";
            }
            if(MainActivity.Day == 7) {
                currentDayString = "Sunday";
            }


            if(AMPM == 0){
                AMPMString = "AM";
            }

            if(AMPM == 1){
                AMPMString = "PM";
            }
            //Log.d("comparacion",""+currentHour24 + ":" + currentMIN24 + " " + AMPMString + " " + currentDayString+ " " + currentDayMonth+ " " + currentYear);

            if(currentHour24 >11){
                Log.d("currentHour24","We don't have meeting schedule for today, try tomorrow");
            }
        }

        if(MainActivity.RegularMeeting == false) {
            currentHour24 = rightNow.get(Calendar.HOUR_OF_DAY); // return the hour in 24 hrs format (ranging from 0-23)
            currentMIN24 = rightNow.get(Calendar.MINUTE); // return the hour in 24 hrs format (ranging from 0-23)
            currentDay = rightNow.get(Calendar.DAY_OF_WEEK); // return the hour in 24 hrs format (ranging from 0-23)
            currentMonth = rightNow.get(Calendar.MONTH);
            currentDayMonth = rightNow.get(Calendar.DAY_OF_MONTH);
            currentYear = rightNow.get(Calendar.YEAR);
            AMPM = rightNow.get(Calendar.AM_PM);
            Hour24 = currentHour24 + ":" + currentMIN24;
            MainActivity.Day = currentDay - 1;
            Log.d("todayIs", "" + MainActivity.Day);
            Log.d("hour24", "" + Hour24);

            if(MainActivity.Day == 1){
                currentDayString = "Monday";
            }
            if(MainActivity.Day == 2) {
                currentDayString = "Tuesday";
            }
            if(MainActivity.Day == 3) {
                currentDayString = "Wednesday";
            }
            if(MainActivity.Day == 4) {
                currentDayString = "Thursday";
            }
            if(MainActivity.Day == 5) {
                currentDayString = "Friday";
            }
            if(MainActivity.Day == 6) {
                currentDayString = "Saturday";
            }
            if(MainActivity.Day == 7) {
                currentDayString = "Sunday";
            }


            if(AMPM == 0){
                AMPMString = "AM";
            }

            if(AMPM == 1){
                AMPMString = "PM";
            }
            //Log.d("comparacion",""+currentHour24 + ":" + currentMIN24 + " " + AMPMString + " " + currentDayString+ " " + currentDayMonth+ " " + currentYear);

            if(currentHour24 >11){
                Log.d("currentHour24","We don't have meeting schedule for today, try tomorrow");
            }
        }

        compareDateTime = ""+currentHour24Schedule + ":" + currentMIN24Schedule + " " + AMPMString + " " + currentDayString+ " " + currentDayMonth+ " " + currentYear;
        compareDate = ""+ currentDayString+ " " + currentDayMonth+ " " + currentYear;
        Log.d("comparacion","" + compareDateTime);


        //checking schedule meeting
        //checkSchudelMeeting();



        ProgresBarBox = findViewById(R.id.ProgresBarBox);
        ProgresBarBox.setVisibility(View.VISIBLE);



        formatApp = findViewById(R.id.formatApp);
        noFormat = findViewById(R.id.noFormat);
        yesFormat = findViewById(R.id.yesFormat);
        formatAppWindow = findViewById(R.id.formatAppWindow);
        formatAppWindow.setVisibility(View.GONE);
        meetingMessage = findViewById(R.id.meetingMessage);

        notificationsBTN = findViewById(R.id.notificationsBTN);
        toggleNotifyON = findViewById(R.id.toggleNotifyON);
        toggleNotifyOFF = findViewById(R.id.toggleNotifyOFF);


        //for My Notifications File
        sharedPreferencesNotify = getSharedPreferences(PREFS_Noty, Context.MODE_PRIVATE);//store or retrieved file "idfile.xml".
        getListValueFromKeyNotfy = sharedPreferencesNotify.getStringSet("myFields", new HashSet<String>());


        //for My Schudele File
        sharedPreferencesSchule = getSharedPreferences(PREFS_Schudele, Context.MODE_PRIVATE);//store or retrieved file "idfile.xml".
        getListValueFromSchedule = sharedPreferencesSchule.getStringSet("myFields", new HashSet<String>());


        backFromMeetings = findViewById(R.id.backFromMeetings);
        scheduleMeeting = findViewById(R.id.scheduleMeeting);
        scheduleMeeting.setVisibility(View.GONE);
        schudelBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideNavigationBar();

                scheduleMeeting.setVisibility(View.VISIBLE);
            }
        });

        backFromMeetings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideNavigationBar();
                hideKeyboard();
                scheduleMeeting.setVisibility(View.GONE);
            }
        });

        meetingAcordion=findViewById(R.id.meetingAcordion);
        meetingAcordion.setVisibility(View.GONE);
        meetingAcordionBTN=findViewById(R.id.meetingAcordionBTN);
        formAcordion=findViewById(R.id.formAcordion);
        formAcordionBTN=findViewById(R.id.formAcordionBTN);
        calendario = findViewById(R.id.calendario);
        searchSchudele = findViewById(R.id.searchSchudele);

        calendario.setVisibility(View.VISIBLE);

        meetingBTN = new  LinearLayout[8];

        for (int i = 0; i < meetingBTN.length; i++) {
            //add icon to the button
            String meetingBTName = "meetingBTN" + (i);
            int meetingInfoID = getResources().getIdentifier(meetingBTName, "id", getPackageName());
            meetingBTN[i] = ((LinearLayout) findViewById(meetingInfoID));


            meetingBTN[i].setId(i);
            meetingBTN[i].setClickable(true);


            icon_meeting_bg=findViewById(R.id.icon_meeting_bg);
            icon_meeting_demo=findViewById(R.id.icon_meeting_demo);
            meeting_type=findViewById(R.id.meeting_type);


            final int finalI = i+1;
            meetingBTN[i].setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                public void onClick(View v) {

                    hideNavigationBar();

                    icon_meeting_bg.setVisibility(View.VISIBLE);
                    icon_meeting_demo.setVisibility(View.GONE);
                    Log.d("click","you Click " + finalI);
                    icon_meeting_bg.setBackgroundResource(meetingteBTNTogle[finalI]);
                    meeting_type.setText(meetingTypeData[finalI]);
                    meetingAcordion.setVisibility(View.GONE);
                    MainActivity.LocationSection = finalI;
                    Log.d("meetingType", ""+MainActivity.LocationSection);
                    Log.d("meetingType", ""+meetingTypeData[finalI]);
                    meetingTipo = true;
                    Log.d("meetingTipo", ""+meetingTipo);





                }
            });

        }


        meetingAcordionBTN.setOnClickListener(

                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        hideNavigationBar();
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


        simpleCalendarView = findViewById(R.id.simpleCalendarView);
        simpleCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, dayOfMonth);
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                MainActivity.Day = dayOfWeek - 1;

                if(MainActivity.Day == 1){
                    MainActivity.dayLongName = "Monday";
                }if(MainActivity.Day == 2) {
                    MainActivity.dayLongName = "Tuesday";
                }
                if(MainActivity.Day == 3) {
                    MainActivity.dayLongName = "Wednesday";
                }
                if(MainActivity.Day == 4) {
                    MainActivity.dayLongName = "Thursday";
                }
                if(MainActivity.Day == 5) {
                    MainActivity.dayLongName = "Friday";
                }
                if(MainActivity.Day == 6) {
                    MainActivity.dayLongName = "Saturday";
                }
                if(MainActivity.Day == 7) {
                    MainActivity.dayLongName = "Sunday";
                }



                MainActivity.DayMonthSchedule = calendar.get(Calendar.DAY_OF_MONTH);
                MainActivity.yearSchedule = calendar.get(Calendar.YEAR);

                Log.d("Day",""+MainActivity.Day);
                dayOfMeetingTipo = true;
                Log.d("dayOfMeetingTipo", ""+dayOfMeetingTipo);

            }
        });


        serchAddres= findViewById(R.id.serchAddres);
        serchAddres.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {

                    if(serchAddres.getText().toString().length()>1) {
                        hideKeyboard();
                        hideNavigationBar();
                        cityOfMeetingTypo = true;
                    }else{
                        Log.d("serchCity","necesitas agregar address");
                        cityOfMeetingTypo = false;

                    }

                    return true;
                }
                return false;
            }
        });

        meetingTipo = false;
        dayOfMeetingTipo = false;
        cityOfMeetingTypo =false;



        searchSchudele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideNavigationBar();

                if(meetingTipo == true && dayOfMeetingTipo == true) {
                    currentHour24 = 06;
                    currentMIN24 = 00;
                    convertAddressSchedule();
                    if(meetingTipo == true && dayOfMeetingTipo == true && cityOfMeetingTypo == true){
                        loadingCityAddress.setVisibility(View.VISIBLE);
                        hideNavigationBar();
                        MainActivity.RegularMeeting = false;
                        loadScheduleWindow();
                    }

                    if(serchAddres.getText().toString().length()>0) {
                        cityOfMeetingTypo = true;
                    }

                }else{
                    Log.d("Schedule Form","is incomplete");

                    if(meetingTipo == false) {
                        Toast.makeText(MapsActivity.this, "You need to select Meeting Type", Toast.LENGTH_SHORT).show();
                    }
                    if(dayOfMeetingTipo == false) {
                        Toast.makeText(MapsActivity.this, "You need to select the day", Toast.LENGTH_SHORT).show();
                    }
                    if(cityOfMeetingTypo == false) {
                        Toast.makeText(MapsActivity.this, "You need to select the location", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });



        //check if notification.xml has Truo or False and change the buttons
        try {
            checkNotifyButton();
        } catch (IOException e) {
            e.printStackTrace();
        }
        notificationsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hideNavigationBar();

                try {
                    checkNotifyFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        if(MainActivity.meetingAdded == false) {
            meetingMessage.setVisibility(View.GONE);
        }else{
            meetingMessage.setVisibility(View.VISIBLE);

        }


        meetingMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideNavigationBar();

                MainActivity.meetingAdded = false;
                meetingMessage.setVisibility(View.GONE);
                //checkMeetingTime();
            }
        });

        formatApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideNavigationBar();

                formatAppWindow.setVisibility(View.VISIBLE);
            }
        });

        noFormat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideNavigationBar();

                formatAppWindow.setVisibility(View.GONE);
            }
        });

        yesFormat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideNavigationBar();

                formatAppWindow.setVisibility(View.GONE);

                //remove warning mesage
                String filePath = getApplicationContext().getFilesDir().getParent()+"/shared_prefs/warning.xml";
                File deletePrefFile = new File(filePath );
                deletePrefFile.delete();

                //remove Favorites List
                Toast.makeText(MapsActivity.this, "You Removed your Data", Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear(); //[important] Clearing your editor before using it.
                //editor.putStringSet("myFields", getListValueFromKey);
                editor.commit();

            }
        });

        noFormat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideNavigationBar();

                formatAppWindow.setVisibility(View.GONE);


            }
        });





        logosCheckLat = new ImageView[4];

        String logoCheck = "logo" + (i);
        int logoCheckLati = getResources().getIdentifier(logoCheck, "id", getPackageName());
        logosCheckLat[i] = ((ImageView) findViewById(logoCheckLati));

        logosCheckLat[i].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideNavigationBar();

                contador += 1;
                Log.d("contador", "" + contador);
                if (contador == 10) {
                    Toast.makeText(MapsActivity.this, "Latitude is " + MainActivity.lattitude + " Longitude is " + MainActivity.longitude, Toast.LENGTH_SHORT).show();
                    Log.d("latitud", "" + MainActivity.lattitude);
                    Log.d("longitud", "" + MainActivity.longitude);

                    contador = 0;
                }
            }
        });


        currentHour12 = rightNow.get(Calendar.HOUR); // return the hour in 12 hrs format (ranging from 0-11)
        currentMin12 = rightNow.get(Calendar.MINUTE); // return the hour in 12 hrs format (ranging from 0-11)

        Hour12 = currentHour12 + ":" + currentMin12;

        Log.d("hour12", "" + Hour12);


        favBtn0 = (LinearLayout) findViewById(R.id.favBtn0);
        favBtn1 = (LinearLayout) findViewById(R.id.favBtn1);
        favBtn2 = (LinearLayout) findViewById(R.id.favBtn2);
        favBtn3 = (LinearLayout) findViewById(R.id.favBtn3);
        favBtn4 = (LinearLayout) findViewById(R.id.favBtn4);
        favBtn5 = (LinearLayout) findViewById(R.id.favBtn5);
        favBtn6 = (LinearLayout) findViewById(R.id.favBtn6);
        favBtn7 = (LinearLayout) findViewById(R.id.favBtn7);

        closeSMS = (ImageView) findViewById(R.id.closeSMS);

        timeText = (TextView) findViewById(R.id.timeText);
        timeTextTest = (TextView) findViewById(R.id.timeTextTest);
        infoAbout = (LinearLayout) findViewById(R.id.infoAbout);
        progressInfo = (LinearLayout) findViewById(R.id.progressInfo);
        progressInfo.setVisibility(View.GONE);


        //timeTextTest.setText("hola");

        millageText = (TextView) findViewById(R.id.millageText);


        getCurrentDay();

        changeColorApp();

        Object key = "key";


        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);//store or retrieved file "namefile.xml".
        String prefname = sharedPreferences.getString("name", "Not Found");
        getListValueFromKey = sharedPreferences.getStringSet("myFields", new HashSet<String>());


        resourceArray = getListValueFromKey.toArray();
        //convert object into String

        tempArrayList = Collections.singleton(sharedPreferences.getString("FOOTHILLS CHURCH", ""));


        stringNameeArray = tempArrayList.toArray();


        // sendEmail();


        FavoriteBTN = findViewById(R.id.FavoriteBTN);
        favText = (TextView) findViewById(R.id.favText);

        //favText.setTextColor(Color.parseColor(ColorSelectionLight));

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideNavigationBar();

                SMSsendMSG();

            }
        });


        closeSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideNavigationBar();

                smsWindow.setVisibility(View.GONE);
            }
        });

        clearFAv = (LinearLayout) findViewById(R.id.clearFAv);

        clearFAv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideNavigationBar();

                Toast.makeText(MapsActivity.this, "You Remove your favorite List", Toast.LENGTH_SHORT).show();
                Log.d("YouRemove", "" + identity);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear(); //[important] Clearing your editor before using it.
                //editor.putStringSet("myFields", getListValueFromKey);
                editor.commit();
                int rem = 0;
                for (rem = 0; rem < newXMList.length; rem++) {
                    String favID = "favBtn" + (rem);
                    int favorieID = getResources().getIdentifier(favID, "id", getPackageName());
                    favTNitem[rem] = ((LinearLayout) findViewById(favorieID));
                    favTNitem[rem].setVisibility(View.GONE);
                }
                createFavButtons();



            }
        });

        FavoriteBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideNavigationBar();

                addingtoFav();
            }
        });


        getmyCurrentLocation();


        //current location

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
/*
        textView = (TextView)findViewById(R.id.text_location);
        button = (Button)findViewById(R.id.button_location);
*/
        //button.setOnClickListener(this);


        //////Log.d("myTag", "location section is "+HttpURLLoading);


        //Conditions Layout
        hideNavigationBar();
        //Var Time
        miles = "100 Miles";
        timeVar = "1:00 PM";
        //VAR BUTTOMS
        Button toggleDist;
        //FIND BUTTOS IN ACTIVITY

        backBTN1 = (LinearLayout) findViewById(R.id.backButton1);
        backBTN2 = (LinearLayout) findViewById(R.id.backButton2);
        backBTN3 = (LinearLayout) findViewById(R.id.backButton3);
        backBTN4 = (LinearLayout) findViewById(R.id.backButton4);
        backBTN5 = (LinearLayout) findViewById(R.id.backButton5);
        backBTN6 = (LinearLayout) findViewById(R.id.backButton6);
        backBTN7 = (LinearLayout) findViewById(R.id.backButton7);
        backBTN8 = (LinearLayout) findViewById(R.id.backButton8);


        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int hp = metrics.heightPixels;
        int wp = metrics.widthPixels;

        linear = new LinearLayout(this);
        linearFav = new LinearLayout(this);
        //linearFav = (LinearLayout)findViewById(R.id.linearFav);


        // Creating an empty array list
        ArrayList<String> list = new ArrayList<String>();
        // Adding items to arrayList
        list.add("hola");
        list.add("buenos dias ");
        list.add(2, "como estas"); // it will add Item3 to the third position of
        // array list
        list.add("quien eres");
        // Display the contents of the array list
        //////Log.d("myTag",""+Herifler);


        //conditions Map


        textViewToChange = (TextView) findViewById(R.id.SubjectFullFormListViewTwo);


        //////Log.d("myTag","activityMaps");

        mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        ToggleBoxColor = (LinearLayout) findViewById(R.id.ToggleBoxColor);
        ButtonsMap = (LinearLayout) findViewById(R.id.ButtonsMap);
        favoriteBox = (LinearLayout) findViewById(R.id.favoriteBox);
        linksColorMap = (LinearLayout) findViewById(R.id.linksColorMap);
        //loading Buttons And Layouts
        accordionOne = (RelativeLayout) findViewById(R.id.AccordionOne);
        accordionTwo = (RelativeLayout) findViewById(R.id.AccordionTwo);
        accordionTree = (RelativeLayout) findViewById(R.id.AccordionTree);
        closeMenu = (RelativeLayout) findViewById(R.id.closeMenu);
        Favorities = (LinearLayout) findViewById(R.id.Favorities);
        LayoutButonLocation = (LinearLayout) findViewById(R.id.LayoutButonLocation);
        linksMap = (RelativeLayout) findViewById(R.id.linksMap);
        mapaLayoutContenido = (RelativeLayout) findViewById(R.id.mapaLayoutContenido);


        goLocationsBTN = (Button) findViewById(R.id.goLocation);
        tituloMenu = (LinearLayout) findViewById(R.id.tituloMenu);
        buttonsMapLink = (LinearLayout) findViewById(R.id.buttonsMapLink);
        yesClose = (Button) findViewById(R.id.yesClose);
        noClose = (Button) findViewById(R.id.noClose);
        backFromFavorites = (LinearLayout) findViewById(R.id.backFromFavorites);
        backFromMeeting = (Button) findViewById(R.id.backFromMeeting);
        MeetingBTN = (ImageView) findViewById(R.id.MeetingBTN);
        NameLocation = (TextView) findViewById(R.id.NameLocation);

        closeMenu.setX(outOfCanvas);
        accordionOne.setX(outOfCanvas);
        accordionTwo.setX(outOfCanvas);
        accordionTree.setX(outOfCanvas);
        linksMap.setX(outOfCanvas);


        //CONDITION FOR BOTONES TRUE AND FALSE IF THE MENU CLOSE IS ACTIVATE OR NOT

        noClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideNavigationBar();

                closeThisMenu = false;
                //////Log.d("myTag","Desactivamos menu cerra botones  deben funcionar"+closeThisMenu);
                closeMenu.setX(outOfCanvas);
            }
        });
        yesClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideNavigationBar();

                closeThisMenu = false;
                closeMenu.setX(outOfCanvas);
                accordionOne.setX(outOfCanvas);
                accordionTwo.setX(outOfCanvas);
                accordionTree.setX(outOfCanvas);
                tituloMenu.setY(showInCanvas);
                buttonsMapLink.setX(showInCanvas);
                mapaLayoutContenido.setX(showInCanvas);
            }
        });

        if (closeThisMenu == false) {
            buttonsOn();
        } else {
            //////Log.d("myTag","No estan Funcionando Botones putos"+closeThisMenu);
            closeThisMenu = false;
        }
        //codition and loading layout for inf in maps
        SubjectFullFormListView = (ListView) findViewById(R.id.SubjectFullFormListView);
        SubjectFullFormListViewDistance = (ListView) findViewById(R.id.SubjectFullFormListViewDistance);

        editText = (EditText) findViewById(R.id.edittext1);
        progressBar = (ProgressBar) findViewById(R.id.ProgressBar1);
        progressBar2 = (ProgressBar) findViewById(R.id.ProgressBar2);

        progressBar.setVisibility(View.VISIBLE);
        progressBar2.setVisibility(View.VISIBLE);

        mapaLayoutContenido.setVisibility(View.VISIBLE);
        buttonsMapLink.setVisibility(View.VISIBLE);
        linksMap.setVisibility(View.VISIBLE);
        accordionOne.setVisibility(View.VISIBLE);
        accordionTwo.setVisibility(View.VISIBLE);
        accordionTree.setVisibility(View.VISIBLE);
        closeMenu.setVisibility(View.VISIBLE);
        tituloMenu.setVisibility(View.VISIBLE);
        adapter = new ListAdapter(SubjectFullFormList, context);


        //changing color of LinearLayouts
        favoriteBox.setBackgroundColor(Color.parseColor(ColorSelectionLight));
        linksColorMap.setBackgroundColor(Color.parseColor(ColorSelectionLight));


        titleInputText = (TextView) findViewById(R.id.titleInputText);
        titleInputTextOne = (TextView) findViewById(R.id.titleInputTextOne);
        textShorting = (TextView) findViewById(R.id.textShorting);
        TitleBox = (LinearLayout) findViewById(R.id.TitleBox);
        searchingFor = findViewById(R.id.searchingFor);
        getDirectionBTN = (LinearLayout) findViewById(R.id.getDirectionBTN);
        FavoriteBTN = (LinearLayout) findViewById(R.id.FavoriteBTN);
        emailBTN = (LinearLayout) findViewById(R.id.emailBTN);
        calendarBTN = (LinearLayout) findViewById(R.id.calendarBTN);
        textBTN = (LinearLayout) findViewById(R.id.textBTN);
        FavoriteTittleBox = (LinearLayout) findViewById(R.id.FavoriteTittleBox);
        getDirText = (TextView) findViewById(R.id.getDirText);
        emailText = (TextView) findViewById(R.id.emailText);
        caleText = (TextView) findViewById(R.id.caleText);
        textsendText = (TextView) findViewById(R.id.textsendText);
        smsWindow = (RelativeLayout) findViewById(R.id.smsWindow);


        //textViewToChange.setTextColor(Color.parseColor(ColorSelectionDark));
        getDirText.setTextColor(Color.parseColor(ColorSelectionLight));
        emailText.setTextColor(Color.parseColor(ColorSelectionLight));
        caleText.setTextColor(Color.parseColor(ColorSelectionLight));
        textsendText.setTextColor(Color.parseColor(ColorSelectionLight));
        titleInputText.setText(tittleName);
        titleInputTextOne.setText(tittleName);
        TitleBox.setBackgroundColor(Color.parseColor(ColorSelectionDark));
        searchingFor.setBackgroundColor(Color.parseColor(ColorSelectionDark));
        FavoriteTittleBox.setBackgroundColor(Color.parseColor(ColorSelectionDark));
        favText.setTextColor(Color.parseColor(ColorSelectionLight));
        favText.setText("Add To Favorites");


        menuBTN1 = (ImageView) findViewById(R.id.menuBTN1);
        menuBTN2 = (ImageView) findViewById(R.id.menuBTN2);
        menuBTN3 = (ImageView) findViewById(R.id.menuBTN3);
        menuBTN4 = (ImageView) findViewById(R.id.menuBTN4);
        menuBTN5 = (ImageView) findViewById(R.id.menuBTN5);
        menuBTN6 = (ImageView) findViewById(R.id.menuBTN6);
        menuBTN7 = (ImageView) findViewById(R.id.menuBTN7);
        menuBTN8 = (ImageView) findViewById(R.id.menuBTN8);

        menuBTN1.setVisibility(View.GONE);
        menuBTN2.setVisibility(View.GONE);
        menuBTN3.setVisibility(View.GONE);
        menuBTN4.setVisibility(View.GONE);
        menuBTN5.setVisibility(View.GONE);
        menuBTN6.setVisibility(View.GONE);
        menuBTN7.setVisibility(View.GONE);
        menuBTN8.setVisibility(View.GONE);


        emailBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideNavigationBar();
                sendEmail();
            }
        });


        TitleBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideNavigationBar();
            }
        });


        //botones Toggle
        //hide Question Buttons
        String BackbuttonID = "menuBTN" + CounterBackBtn;
        int backresID = getResources().getIdentifier(BackbuttonID, "id", getPackageName());
        final View menuBTN = findViewById(backresID);
        menuBTN.setVisibility(View.VISIBLE);

/*
        //botones Menu
        //hide Question Buttons
        String SelectoggleButton = "togglebutton" + CounterBackBtn;
        int togglekresID = getResources().getIdentifier(SelectoggleButton, "id", getPackageName());
        final View toggleBTN = findViewById(togglekresID);
        //toggleBTN.setVisibility(View.VISIBLE);


 */

        //botones Menu
        //hide Toggles for Time
        String SelectoggleButtonIMG = "togglebuttonIMG" + CounterBackBtn;
        int togglekresIDIMG = getResources().getIdentifier(SelectoggleButtonIMG, "id", getPackageName());
        final View toggleBTNIMG = findViewById(togglekresIDIMG);
        toggleBTNIMG.setVisibility(View.VISIBLE);


        //hide Toggles for Distance
        String SelectoggleButtonIMGDist = "DistogglebuttonIMG" + CounterBackBtn;
        int togglekresIDIMGDist = getResources().getIdentifier(SelectoggleButtonIMGDist, "id", getPackageName());
        final View toggleBTNIMGDist = findViewById(togglekresIDIMGDist);
        toggleBTNIMGDist.setVisibility(View.VISIBLE);




        menuBAckBTN1 = (ImageView) findViewById(R.id.menuBAckBTN1);
        menuBAckBTN2 = (ImageView) findViewById(R.id.menuBAckBTN2);
        menuBAckBTN3 = (ImageView) findViewById(R.id.menuBAckBTN3);
        menuBAckBTN4 = (ImageView) findViewById(R.id.menuBAckBTN4);
        menuBAckBTN5 = (ImageView) findViewById(R.id.menuBAckBTN5);
        menuBAckBTN6 = (ImageView) findViewById(R.id.menuBAckBTN6);
        menuBAckBTN7 = (ImageView) findViewById(R.id.menuBAckBTN7);
        menuBAckBTN8 = (ImageView) findViewById(R.id.menuBAckBTN8);

        menuBAckBTN1.setVisibility(View.GONE);
        menuBAckBTN2.setVisibility(View.GONE);
        menuBAckBTN3.setVisibility(View.GONE);
        menuBAckBTN4.setVisibility(View.GONE);
        menuBAckBTN5.setVisibility(View.GONE);
        menuBAckBTN6.setVisibility(View.GONE);
        menuBAckBTN7.setVisibility(View.GONE);
        menuBAckBTN8.setVisibility(View.GONE);


        //botones Menu
        //hide Question Buttons
        String menuBackID = "menuBAckBTN" + CounterBackBtn;
        int menubackresID = getResources().getIdentifier(menuBackID, "id", getPackageName());
        final View menuBAckBTN = findViewById(menubackresID);
        menuBAckBTN.setVisibility(View.VISIBLE);


        //smsWindow.setVisibility(View.GONE);

        textBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //smsActivity();
                hideNavigationBar();
                smsWindow.setVisibility(View.VISIBLE);
            }
        });


        getDirectionBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myLat", "" + latText);
                Log.d("myLat", "" + lngText);

                hideNavigationBar();


                gmmIntentUri = Uri.parse("google.navigation:q=" + latText + "," + lngText);
                mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

            }
        });


        calendarBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideNavigationBar();
                addingCalendar();
            }
        });

        menuBAckBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideNavigationBar();
                if (menuFav == false) {
                    //Log.d("menubtn", "precionado");
                    InfoSelection = false;
                    closeThisMenu = false;
                    closeMenu.setX(outOfCanvas);
                    accordionOne.setX(outOfCanvas);
                    accordionTwo.setX(outOfCanvas);
                    accordionTree.setX(outOfCanvas);
                    tituloMenu.setY(showInCanvas);
                    buttonsMapLink.setX(showInCanvas);
                    mapaLayoutContenido.setX(showInCanvas);
                    LayoutButonLocation.setVisibility(View.VISIBLE);
                    //closeMenu.setX(showInCanvas);
                    // closeThisMenu = true;
                    //////Log.d("myTag","Activamos menu cerra botones no deben funcionar"+closeThisMenu);

                }
                if (menuFav == true) {
                    //Log.d("menubtn", "precionado");
                    InfoSelection = false;
                    closeThisMenu = false;
                    closeMenu.setX(outOfCanvas);
                    accordionOne.setX(outOfCanvas);
                    accordionTwo.setX(outOfCanvas);
                    accordionTree.setX(outOfCanvas);
                    tituloMenu.setY(showInCanvas);
                    buttonsMapLink.setX(outOfCanvas);
                    mapaLayoutContenido.setX(showInCanvas);
                    LayoutButonLocation.setVisibility(View.VISIBLE);
                    linksMap.setX(showInCanvas);
                    //closeMenu.setX(showInCanvas);
                    // closeThisMenu = true;
                    //////Log.d("myTag","Activamos menu cerra botones no deben funcionar"+closeThisMenu);

                }


            }
        });


        menuBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideNavigationBar();

                //////Log.d("myTag","Muestra el botton de cerrar ");
                closeThisMenu = false;
                tituloMenu.setY(outOfCanvas);
                buttonsMapLink.setX(outOfCanvas);
                mapaLayoutContenido.setX(outOfCanvas);
                accordionOne.setX(showInCanvas);
                linksMap.setX(outOfCanvas);
                LayoutButonLocation.setVisibility(View.GONE);

            }
        });


        //Botones back
        //hide Question Buttons
        String buttonID = "backButton" + CounterBackBtn;
        int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
        final View buttons = findViewById(resID);
        buttons.setVisibility(View.VISIBLE);

        buttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideNavigationBar();

                ColorFavTextOn = "#FFFFFF";
                favText.setTextColor(Color.parseColor(ColorSelectionLight));
                FavoriteBTN.setBackgroundResource(favoriteBTNTogle[0]);

                if (InfoSelection == false) {
                    //////Log.d("myTag", "click en " + buttons);
                    hideNavigationBar();
                    MainMenu();
                }
                if (InfoSelection == true) {
                    InfoSelection = false;
                    LayoutButonLocation.setVisibility(View.VISIBLE);
                    linksMap.setX(outOfCanvas);
                    tituloMenu.setY(showInCanvas);
                    buttonsMapLink.setX(showInCanvas);
                    mapaLayoutContenido.setX(showInCanvas);

                }
                if (FavoritesWindow == false && buttonsMapAtivates == false) {
                    //Log.d("checa aqui", "back to menu "+ FavoritesWindow+ " "+ buttonsMapAtivates );
                    MainMenu();
                }

            }
        });


        //For Loop for Toggles for Time
        togglesImage = new ImageView[8];

        for (int i = 0; i < togglesImage.length; i++) {
            {
                //toggle for time
                String TexttoggleID = "togglebuttonIMG" + (i + 1);
                int toggleID = getResources().getIdentifier(TexttoggleID, "id", getPackageName());
                togglesImage[i] = ((ImageView) findViewById(toggleID));
                //toggles[i].setOnClickListener((View.OnClickListener) this);
                togglesImage[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        hideNavigationBar();

                        Log.d("myToggle", "do Something");
                        SortByTime();

                    }
                });
            }

        }

        //For Loop for Toggles for Distance
        togglesImageDist = new ImageView[8];

        for (int i = 0; i < togglesImageDist.length; i++) {
            {
                String TexttoggleIDDist = "DistogglebuttonIMG" + (i + 1);
                int toggleIDDist = getResources().getIdentifier(TexttoggleIDDist, "id", getPackageName());
                togglesImageDist[i] = ((ImageView) findViewById(toggleIDDist));
                togglesImageDist[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        hideNavigationBar();

                        Log.d("myToggle", "do Something");
                        SortByTime();

                    }
                });
            }

        }

        //Start With Shared Folders

        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);//store or retrieved file "namefile.xml".
        //String prefname = sharedPreferences.getString("name", "Not Found");
        getListValueFromKey = sharedPreferences.getStringSet("myFields", new HashSet<String>());
        //Toast.makeText(getApplicationContext(), sharedPreferences.toString(), Toast.LENGTH_LONG).show();
        //add to an Array

        File fileXML = new File("/data/data/com.example.notificacionesfcm/shared_prefs/namefile.xml");
        if (fileXML.exists()) {
            ////Log.d("MIArchivo", "existe");

        } else {
            //create the file
            //getListValueFromKey.add("");
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear(); //[important] Clearing your editor before using it.
            //editor.putStringSet("myFields", getListValueFromKey);
            editor.commit();
        }

        resourceArray = getListValueFromKey.toArray();
        String[] resourceArray = new String[3];

        //convert object into String
        LatitudInfo = String.valueOf(resourceArray);
        LongitudInfo = String.valueOf(resourceArray);

        final Random rand = new Random();
        final Handler handler = new Handler();

        EditcitySerch.clearFocus();

        exitSerchEditText = (RelativeLayout) findViewById(R.id.exitSerchEditText);
        exitSerchEditText.setVisibility(View.GONE);
        exitSerchEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideNavigationBar();

                exitSerchEditText.setVisibility(View.GONE);
                EditcitySerch.clearFocus();
                hideKeyboard();
            }
        });

        EditcitySerch.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View arg0, boolean hasfocus) {
                if (hasfocus) {
                    Log.e("TAG", "focused");
                    exitSerchEditText.setVisibility(View.VISIBLE);

                } else {
                    Log.e("TAG", "not focused");
                    exitSerchEditText.setVisibility(View.GONE);
                    hideNavigationBar();

                }
            }
        });




        loadingCity.setVisibility(View.GONE);

        serchAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideNavigationBar();

                if(EditcitySerch.getText().toString().length()>0) {
                    //loadingCity.setVisibility(View.VISIBLE);
                    loadingCityAddress.setVisibility(View.VISIBLE);
                    convertAddress();
                    exitSerchEditText.setVisibility(View.GONE);
                    hideKeyboard();
                }else{
                    Log.d("serchCity","You need to add an Address");
                }
            }
        });

        EditcitySerch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    hideNavigationBar();
                    if(EditcitySerch.getText().toString().length()>0) {
                        //loadingCity.setVisibility(View.VISIBLE);
                        loadingCityAddress.setVisibility(View.VISIBLE);
                        convertAddress();
                        exitSerchEditText.setVisibility(View.GONE);
                        hideKeyboard();
                    }else{
                        Log.d("serchCity","You need to add an Address");
                    }

                    return true;
                }
                return false;
            }
        });

    }

    public void addingtoFav() {


        //save();
        center = new LatLng(latText, lngText);
        //Log.d("FacoriteClicked","you save in favorites" + center);
        text = "1\n";
        identification += 1;
        calle = info;
        identity = idLocation;
        latitudNumber = latText;
        longitudNumber = lngText;
        f = 0;
        File fileXML = new File("/data/data/com.example.notificacionesfcm/shared_prefs/namefile.xml");


        try {
            FileInputStream in = new FileInputStream(fileXML);
            int len = 0;
            byte[] data1 = new byte[1024];
            while (-1 != (len = in.read(data1))) {
                if (new String(data1, 0, len).contains(identity)) {
                    //Toast.makeText(MapsActivity.this, "You Remove " + identity + " from Favorites", Toast.LENGTH_SHORT).show();
                    Log.d("YouRemove", "" + identity);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.remove(identity);
                    editor.apply();
                    FavoriteBTN.setBackgroundResource(favoriteBTNTogle[0]);
                    createFavButtons();
                    checktextButton();
                    removingInFav.setVisibility(View.VISIBLE);
                    String lottieAnimRemoveID = "removeMeetAnim" + (MainActivity.LocationSection);
                    int animLottieMeetingRemove = getResources().getIdentifier(lottieAnimRemoveID, "id", getPackageName());

                    removeMeetAnim[i] = (findViewById(animLottieMeetingRemove));
                    removeMeetAnim[i].setVisibility(View.VISIBLE);
                    removeMeetAnim[i].isAnimating();
                    removeMeetAnim[i].playAnimation();
                    Log.d("isPlaying",""+lottieAnimRemoveID);
                    removeMeetAnim[i].addAnimatorListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            //Log.d("animation", "Start");
                            savingInFav.setVisibility(View.GONE);

                        }
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            Log.d("animation", "animation eds");
                            savingInFav.setVisibility(View.GONE);
                            removingInFav.setVisibility(View.GONE);

                        }
                        @Override
                        public void onAnimationCancel(Animator animation) {
                        }
                        @Override
                        public void onAnimationRepeat(Animator animation) {
                        }
                    });





                } else {
                    if (resourceArray.length < 9) {
                        //Log.d("MyWord", "Created");
                        //Toast.makeText(MapsActivity.this, "You put " + identity + " in Favorites", Toast.LENGTH_SHORT).show();
                        savingInFav.setVisibility(View.VISIBLE);
                        String lottieAnimID = "addingMeetAnim" + (MainActivity.LocationSection);
                        int animLottieMeeting = getResources().getIdentifier(lottieAnimID, "id", getPackageName());

                        addingMeetAnim[i] = (findViewById(animLottieMeeting));
                        addingMeetAnim[i].setVisibility(View.VISIBLE);
                        addingMeetAnim[i].isAnimating();
                        addingMeetAnim[i].playAnimation();
                        addingMeetAnim[i].addAnimatorListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animator) {
                                //Log.d("animation", "Start");
                                removingInFav.setVisibility(View.GONE);
                            }

                            @Override
                            public void onAnimationEnd(Animator animator) {
                                Log.d("animation", "animation eds");
                                savingInFav.setVisibility(View.GONE);
                                removingInFav.setVisibility(View.GONE);
                            }

                            @Override
                            public void onAnimationCancel(Animator animator) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animator) {

                            }
                        });




                        getListValueFromKey.add("*" + MainActivity.LocationSection + "/ The address is: +" + calle + "%, Latitud is: {" + latitudNumber + "} , Longitud is: (" + longitudNumber + ")" + "this is the ID : ?" + identity + "^");
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        //editor.clear(); //[important] Clearing your editor before using it.
                        //editor.putStringSet("myFields", getListValueFromKey);
                        editor.putString(identity, String.valueOf(getListValueFromKey));
                        editor.apply();
                        favText.setText("");
                        FavoriteBTN.setBackgroundResource(favoriteBTNTogle[1]);
                        //editor.commit();
                        createFavButtons();
                    } else {
                        Toast.makeText(MapsActivity.this, "You are Avobe the limits od favorites ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getmyCurrentLocation() {
        MainActivity.locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (!MainActivity.locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {

        } else if (MainActivity.locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            getLocation();
        }
    }

    private void getLocation() {


        if (ActivityCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (MapsActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

        } else {
            Location location = MainActivity.locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            Location location1 = MainActivity.locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            Location location2 = MainActivity.locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);

            if (location != null) {
                latti = location.getLatitude();
                longi = location.getLongitude();
                MainActivity.lattitude = String.valueOf(latti);
                MainActivity.longitude = String.valueOf(longi);


/*
                textView.setText("Your current location is"+ "\n" + "MainActivity.lattitude = " + MainActivity.lattitude
                        + "\n" + "Longitude = " + MainActivity.longitude);
*/
            } else if (location1 != null) {
                latti = location1.getLatitude();
                longi = location1.getLongitude();
                MainActivity.lattitude = String.valueOf(latti);
                MainActivity.longitude = String.valueOf(longi);

/*
                textView.setText("Your current location is"+ "\n" + "MainActivity.lattitude = " + MainActivity.lattitude
                        + "\n" + "Longitude = " + MainActivity.longitude);
*/

            } else if (location2 != null) {
                latti = location2.getLatitude();
                longi = location2.getLongitude();
                MainActivity.lattitude = String.valueOf(latti);
                MainActivity.longitude = String.valueOf(longi);

/*
                textView.setText("Your current location is"+ "\n" + "MainActivity.lattitude = " + MainActivity.lattitude
                        + "\n" + "Longitude = " + MainActivity.longitude);
*/
            }
        }
        //////Log.d("myTag", "MainActivity.lattitude is "+MainActivity.lattitude);



        if(MainActivity.serachCity == false) {
            Log.d("serch by location" , "true");
            HttpURLTime = "http://ec2-18-224-214-122.us-east-2.compute.amazonaws.com/api/meeting/read.php?" + "&long=" + longi + "&lat=" + latti + "&type=" + MainActivity.LocationSection + "&sort=" + MainActivity.sort + "&day=" + MainActivity.Day + "&dist=20" + "&time=" + currentHour24 + ":" + currentMIN24;

            HttpURLLoadinDistanceLocation = "http://ec2-18-224-214-122.us-east-2.compute.amazonaws.com/api/meeting/read.php?" + "&long=" + longi + "&lat=" + latti + "&type=" + MainActivity.LocationSection + "&sort=" + MainActivity.sort + "&day=" + MainActivity.Day + "&dist=20" + "&time=" + currentHour24 + ":" + currentMIN24;

            HTTPTEST = "http://ec2-18-224-214-122.us-east-2.compute.amazonaws.com/api/meeting/read.php?" + "&long=" + longi + "&lat=" + latti + "&type=" + MainActivity.LocationSection + "&sort=" + MainActivity.sort + "&day=" + MainActivity.Day + "&dist=20" + "&time=" + currentHour24 + ":" + currentMIN24;

        }
        if(MainActivity.serachCity == true){
            Log.d("serch by City" , "true");

            HttpURLTime = "http://ec2-18-224-214-122.us-east-2.compute.amazonaws.com/api/meeting/read.php?" + "&long=" + MainActivity.CityLong + "&lat=" + MainActivity.CityLat + "&type=" + MainActivity.LocationSection + "&sort=" + MainActivity.sort + "&day=" + MainActivity.Day + "&dist=20" + "&time=" + currentHour24 + ":" + currentMIN24;

            HttpURLLoadinDistanceLocation = "http://ec2-18-224-214-122.us-east-2.compute.amazonaws.com/api/meeting/read.php?" + "&long=" + MainActivity.CityLong + "&lat=" + MainActivity.CityLat + "&type=" + MainActivity.LocationSection + "&sort=" + MainActivity.sort + "&day=" + MainActivity.Day + "&dist=20" + "&time=" + currentHour24 + ":" + currentMIN24;

            HTTPTEST = "http://ec2-18-224-214-122.us-east-2.compute.amazonaws.com/api/meeting/read.php?" + "&long=" + MainActivity.CityLong + "&lat=" + MainActivity.CityLat + "&type=" + MainActivity.LocationSection + "&sort=" + MainActivity.sort + "&day=" + MainActivity.Day + "&dist=20" + "&time=" + currentHour24 + ":" + currentMIN24;



        }

        Log.d("myURL", "" + HttpURLTime);
        Log.d("myURL2", "" + HttpURLLoadinDistanceLocation);


        HttpTest = new HttpServiceClass(HTTPTEST);//Load Distance
        httpServiceClass = new HttpServiceClass(HttpURLTime);//Load Distance
        httpServiceClassDistance = new HttpServiceClass(HttpURLLoadinDistanceLocation);//Load Distance
        httpServiceClassFav = new HttpServiceClass(HTTPTEST);//test


        ActivatebyDistance = true;

        new ParseJSonDataClass(this).execute();


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        //botonera
        if (MainActivity.LocationSection == 1) {
            markerOptions.icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.aa_mrk_one));
        }
        if (MainActivity.LocationSection == 2) {
            markerOptions.icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.aa_mrk_one2));
        }
        if (MainActivity.LocationSection == 3) {
            markerOptions.icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.aa_mrk_one3));
        }
        if (MainActivity.LocationSection == 4) {
            markerOptions.icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.aa_mrk_one4));
        }
        if (MainActivity.LocationSection == 5) {
            markerOptions.icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.aa_mrk_one5));
        }
        if (MainActivity.LocationSection == 6) {
            markerOptions.icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.aa_mrk_one6));
        }
        if (MainActivity.LocationSection == 7) {
            markerOptions.icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.aa_mrk_one7));
        }
        if (MainActivity.LocationSection == 8) {
            markerOptions.icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.aa_mrk_one8));
        }


        noSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideNavigationBar();

                saveSchedule.setVisibility(View.GONE);
            }
        });
        yesSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideNavigationBar();

                saveSchedule.setVisibility(View.GONE);
                addingCalendarSchedule();
                //addingtoSchedule();
                AddScheduleClicked= false;

            }
        });


        //botonera para viejo proyecto
        /*
        //botonera o botones para map Links
        SubjectFullFormListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(MainActivity.RegularMeeting == true) {
                    hideNavigationBar();
                    buttonsMapAtivates = true;
                    linksActive = true;
                    botoneraClick = true;
                    ////Log.d("myTag", "click 1 ");
                    identificationMapClick = id;
                    favoriteValue = id;
                    favoriteIDOnOf = (int) id;
                    center = new LatLng(latText, lngText);
                    linksMap.setX(showInCanvas);
                    buttonsMapLink.setX(outOfCanvas);
                    MapaWindo = false;
                    new ParseJSonDataClass(context).execute();
                    removeLastMark();
                    InfoSelection = true;
                    textViewToChange.setText("");
                    timeText.setText("");
                    millageText.setText("");
                    infoAbout.setVisibility(View.GONE);
                    progressInfo.setVisibility(View.VISIBLE);
                    startTimerFull();
                }if(MainActivity.RegularMeeting == false) {
                    saveSchedule.setVisibility(View.VISIBLE);
                    identificationMapClickDist = id;
                    AddScheduleClicked= true;
                    new ParseJSonDataClass(context).execute();



                }
            }
        });

         */


        SubjectFullFormListViewDistance.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(MainActivity.RegularMeeting == true) {
                    hideNavigationBar();
                    buttonsMapAtivates = true;
                    linksActive = true;
                    botoneraClick = true;
                    ////Log.d("myTag", "click 2 ");

                    identificationMapClickDist = id;
                    center = new LatLng(latText, lngText);
                    linksMap.setX(showInCanvas);
                    buttonsMapLink.setX(outOfCanvas);
                    MapaWindo = false;
                    new ParseJSonDataClass(context).execute();
                    removeLastMark();
                    InfoSelection = true;
                    textViewToChange.setText("");
                    timeText.setText("");
                    millageText.setText("");
                    infoAbout.setVisibility(View.GONE);
                    progressInfo.setVisibility(View.VISIBLE);

                    //star this to wait until the info of the button is loaded then show the info of the link
                    startTimerFull();
                }
                if(MainActivity.RegularMeeting == false) {


                    hideNavigationBar();
                    buttonsMapAtivates = true;
                    linksActive = true;
                    botoneraClick = true;
                    ////Log.d("myTag", "click 2 ");

                    identificationMapClickDist = id;
                    center = new LatLng(latText, lngText);

                    //put this invisible for schedule meeting
                    //linksMap.setX(showInCanvas);
                    //buttonsMapLink.setX(outOfCanvas);

                    MapaWindo = false;
                    new ParseJSonDataClass(context).execute();
                    removeLastMark();
                    InfoSelection = true;
                    textViewToChange.setText("");
                    timeText.setText("");
                    millageText.setText("");
                    infoAbout.setVisibility(View.GONE);
                    progressInfo.setVisibility(View.VISIBLE);

                    //star this to wait until the info of the button is loaded then show the info of the link
                    startTimerFull();
                    AddScheduleClicked= true;



                }
            }
        });

        getMarkers();
        request = true;
        myLocation();
    }

    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    private void addMarker(LatLng latlng, final String title) {
        markerOptions.position(latlng);
        markerOptions.title(title);
        if (gMap == null) {
            //nothing
        } else {
            gMap.addMarker(markerOptions);
        }
    }

    // Fungsi get JSON marker
    private void getMarkers() {
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest getRequest = new StringRequest(Request.Method.GET, HttpURLLoadinDistanceLocation,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.isEmpty()) {
                            Log.d("notificar meeting", "Contiene info");
                        }

                        //Log.e("Response: ", response.toString());
                        JSONArray jsonArray = null;
                        try {
                            jsonArray = new JSONArray(response);
                            JSONObject jsonObject;
                            Subject subject;
                            for (int i = 0; i < jsonArray.length(); i++) {
                                jsonObject = jsonArray.getJSONObject(i);
                                title = jsonObject.getString(TITLE);
                                latLng = new LatLng(Double.parseDouble(jsonObject.getString(LAT)), Double.parseDouble(jsonObject.getString(LNG)));
                                // Add marker data to display to google map
                                addMarker(latLng, title);
                            }

                        } catch (JSONException e) {
                            // JSON error
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        //Log.d("Response ERROR", "error => " + error.toString());
                        Log.d("Response ERROR", "NO Contiene info");

                        ProgresBarBox.setVisibility(View.GONE);
                        errorLoading.setVisibility(View.VISIBLE);
                        toogleVisivility.setVisibility(View.GONE);



                        error.printStackTrace();

                    }
                }
        ) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("User-Agent", "FindAMeeting");
                params.put("Accept-Language", "fr");

                return params;

            }
        };
        queue.add(getRequest);

    }

    //My Position in google Map
    public void centreMapOnLocation(Location location, String title) {


        if(MainActivity.serachCity == false) {
            if (request == true && location != null) {
                userLocation = new LatLng(location.getLatitude(), location.getLongitude());

                //gMap.clear();
                gMap.addMarker(new MarkerOptions()
                        .position(userLocation)
                        .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.aa_mrk_tree)));
                cameraPosition = new CameraPosition.Builder().target(userLocation).zoom(11).build();
                gMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                request = false;
            }
        }

        if(MainActivity.serachCity == true) {
            if (request == true && location != null) {

                city = new LatLng(MainActivity.CityLat,MainActivity.CityLong);

                //gMap.clear();
                gMap.addMarker(new MarkerOptions()
                        .position(city)
                        .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.aa_mrk_tree)));
                cameraPosition = new CameraPosition.Builder().target(city).zoom(11).build();
                gMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                request = false;
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && MainActivity.GpsStatus == true) {
                MainActivity.locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

                Location lastKnownLocation = MainActivity.locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                centreMapOnLocation(lastKnownLocation, "Your Location");
            }
        }


    }

    //dirige a la locacion con el boton de la mira de pistola
    public void myLocation() {
        if (request == true && MainActivity.GpsStatus == true) {
            Intent intent = getIntent();
            if (intent.getIntExtra("Place Number", 0) == 0) {
                // Zoom into users location
                MainActivity.locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
                locationListener = new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        centreMapOnLocation(location, "Your Location");
                    }

                    @Override
                    public void onStatusChanged(String s, int i, Bundle bundle) {

                    }

                    @Override
                    public void onProviderEnabled(String s) {

                    }

                    @Override
                    public void onProviderDisabled(String s) {

                    }
                };
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    MainActivity.locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
                    lastKnownLocation = MainActivity.locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    centreMapOnLocation(lastKnownLocation, "Your Location");
                } else {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                }
            }
            request = false;
        }

    }

    //addign info to Mapp
    public class ParseJSonDataClass extends AsyncTask<Void, Void, Void> {
        public Context context;
        String FinalJSonResult;
        String FinalJSonResultDistance;

        public ParseJSonDataClass(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            try {


                httpServiceClass.ExecuteGetRequest();
                httpServiceClassDistance.ExecuteGetRequest();
                httpServiceClassFav.ExecuteGetRequest();


                //I hide this as test I need to know if I need or not this code
                /*
                //for Time
                if (httpServiceClass.getResponseCode() == 200) {

                    FinalJSonResult = httpServiceClass.getResponse();

                    if (FinalJSonResult != null) {
                        JSONArray jsonArray = null;

                        try {

                            Log.d("ActivatebyDistance", "show time");

                            //info Time when you click in toggle
                            jsonArray = new JSONArray(FinalJSonResult);
                            JSONObject jsonObject;
                            SubjectFullFormList = new ArrayList<Subject>();
                            //SubjectFullFormListDistance = new ArrayList<Subject>();

                            for (int i = 0; i < jsonArray.length(); i++) {
                                subject = new Subject();
                                jsonObject = jsonArray.getJSONObject(i);
                                subject.Subject_Name = jsonObject.getString("Address");
                                subject.Subject_Full_Form = jsonObject.getString("Name");
                                subject.hourSubj = jsonObject.getString("Time");
                                TimeInMeeting = jsonObject.getString("Time");
                                distMeeting = jsonObject.getString("Distance");
                                idLocation = jsonObject.getString("ID");
                                subject.distanceSubj = jsonObject.getString("Distance") + " miles";
                                titleDB = jsonObject.getString("Latitude");


                                SubjectFullFormList.add(subject);

                            }

                            //Info when you click in the maps buttons
                            for (int i = 0; i <= identificationMapClick; i++) {
                                jsonObject = jsonArray.getJSONObject(i);
                                NameLocationText = jsonObject.getString("Name");
                                info = jsonObject.getString("Address");
                                latMap = jsonObject.getDouble("Latitude");
                                lngMap = jsonObject.getDouble("Longitude");
                                TimeInMeeting = jsonObject.getString("Time");
                                distMeeting = jsonObject.getString("Distance");
                                idLocation = jsonObject.getString("ID");

                                //subject.distanceSubj = jsonObject.getString("Distance")+ " miles";

                                String filename = "abc.def.ghi";     // full file name
                                int iend = TimeInMeeting.indexOf(":"); //this finds the first occurrence of "."
                                // in string thus giving you the index of where it is in the string
                                // Now iend can be -1, if lets say the string had no "." at all in it i.e. no "." is found.
                                // So check and account for it.
                                if (iend != -1) {
                                    subString = TimeInMeeting.substring(0, iend); //this will give abc

                                    Log.d("subString", "" + subString);
                                }


                                if (TimeInMeeting.contains("PM")) {
                                    AMPMint = 1;
                                    Log.i("hora", "has PM" + AMPMint);
                                } else {
                                    AMPMint = 0;
                                    Log.i("hora", "has AM" + AMPMint);

                                }
                            }
                        } catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                } else {
                    Toast.makeText(context, httpServiceClass.getErrorMessage(), Toast.LENGTH_SHORT).show();
                }

                 */


                //by Ditance
                //I change this condition  temporaly
                if (ActivatebyDistance == true) {
                    if (httpServiceClass.getResponseCode() == 200) {

                        FinalJSonResult = httpServiceClass.getResponse();

                        if (FinalJSonResult != null) {
                            JSONArray jsonArray = null;

                            try {
                                Log.d("ActivatebyDistance", "show distance");
                                //info Time when you click in toggle
                                jsonArray = new JSONArray(FinalJSonResult);
                                JSONObject jsonObject;
                                SubjectFullFormList = new ArrayList<Subject>();
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    subject = new Subject();
                                    jsonObject = jsonArray.getJSONObject(i);
                                    subject.Subject_Name = jsonObject.getString("Address");
                                    subject.Subject_Full_Form = jsonObject.getString("Name");
                                    subject.hourSubj = jsonObject.getString("Time");
                                    TimeInMeeting = jsonObject.getString("Time");
                                    distMeeting = jsonObject.getString("Distance");
                                    idLocation = jsonObject.getString("ID");
                                    subject.distanceSubj = jsonObject.getString("Distance") + " miles";
                                    titleDB = jsonObject.getString("Latitude");
                                    SubjectFullFormList.add(subject);
                                }
                                //info Distance when you click in toggle
                                if (byDistance == true) {
                                    //Info when you click in the maps buttons
                                    for (int i = 0; i <= identificationMapClickDist; i++) {
                                        jsonObject = jsonArray.getJSONObject(i);
                                        NameLocationText = jsonObject.getString("Name");
                                        TimeInMeeting = jsonObject.getString("Time");
                                        distMeeting = jsonObject.getString("Distance");
                                        idLocation = jsonObject.getString("ID");
                                        cityAdd = jsonObject.getString("City");
                                        DayAdd = jsonObject.getString("Day");
                                        //subject.distanceSubj = jsonObject.getString("Distance")+ " miles";
                                        info = jsonObject.getString("Address");
                                        latMap = jsonObject.getDouble("Latitude");
                                        lngMap = jsonObject.getDouble("Longitude");
                                        String filename = "abc.def.ghi";     // full file name
                                        int iend = TimeInMeeting.indexOf(":"); //this finds the first occurrence of "."
                                        // in string thus giving you the index of where it is in the string
                                        // Now iend can be -1, if lets say the string had no "." at all in it i.e. no "." is found.
                                        // So check and account for it.
                                        if (iend != -1) {
                                            subString = TimeInMeeting.substring(0, iend); //this will give abc
                                            Log.d("subString", "" + subString);
                                        }
                                        if (TimeInMeeting.contains("PM")) {
                                            AMPMint = 1;
                                            Log.i("hora", "has PM" + AMPMint);
                                        } else {
                                            AMPMint = 0;
                                            Log.i("hora", "has AM" + AMPMint);
                                        }
                                    }
                                }
                            } catch (JSONException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    } else {
                        Toast.makeText(context, httpServiceClass.getErrorMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            return null;


        }


        @Override
        protected void onPostExecute(Void result) {

            Log.d("byTime", "" + byTime);
            Log.d("byDistance", "" + byDistance);


            if (SubjectFullFormList == null && SubjectFullFormListDistance == null) {

                Log.d("myListAdapter", "empty");

            } else {

                Log.d("myListAdapter", "has info");

                ProgresBarBox.setVisibility(View.GONE);
                progressBar.setVisibility(View.GONE);
                progressBar2.setVisibility(View.GONE);


                SubjectFullFormListView.setVisibility(View.GONE);
                SubjectFullFormListViewDistance.setVisibility(View.GONE);

                if (byTime == true) {

                    Log.d("listView", "Tiempo activadas");

                    SubjectFullFormListView.setVisibility(View.VISIBLE);
                    SubjectFullFormListView.setX(300);

                    SubjectFullFormListViewDistance.setVisibility(View.GONE);

                }
                if (byDistance == true) {

                    Log.d("listView", "Distancia activadas");

                    SubjectFullFormListViewDistance.setVisibility(View.VISIBLE);
                    SubjectFullFormListView.setVisibility(View.GONE);


                }


                if (MapaWindo == true) {

                    Log.d("lista", "activadas");
                    adapterDistance = new ListAdapter(SubjectFullFormListDistance, context);

                    adapter = new ListAdapter(SubjectFullFormList, context);

                    SubjectFullFormListView.setAdapter(adapter);
                    SubjectFullFormListViewDistance.setAdapter(adapterDistance);

                    MapaWindo = false;
                }


                textViewToChange.setText("" + info);
                NameLocation.setText("" + NameLocationText);
                timeText.setText("" + TimeInMeeting);
                millageText.setText("" + distMeeting + " miles away");


                if(MainActivity.RegularMeeting == false){
                    if(AddScheduleClicked == true) {

                    }
                }


                existFav();


                latText = latMap;
                lngText = lngMap;
                camaraMove();

                if (ListAdapter.subject_list == null) {
                    Log.d("lista", "vacia");

                } else {
                    Log.d("lista", "llena");
                }
            }

        }
    }

    //Buttons for menu
    void buttonsOn() {
        //BUTONS

        goLocationsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideNavigationBar();

                //////Log.d("myTag","Click en Boton Menu "+closeThisMenu);
                if (closeThisMenu == false) {
                    request = true;
                    myLocation();
                    linksMap.setX(outOfCanvas);
                    buttonsMapLink.setX(showInCanvas);
                }
            }
        });

        MeetingBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                hideNavigationBar();
                Registration();
            }
        });
        Favorities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideNavigationBar();

                //////Log.d("myTag","Favorite is Working"+closeThisMenu);
                if (closeThisMenu == false) {
                    accordionOne.setX(outOfCanvas);
                    accordionTree.setX(showInCanvas);


                    createFavButtons();
                    existFav();

                }
            }
        });
        backFromMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideNavigationBar();

                if (closeThisMenu == false) {
                    accordionOne.setX(showInCanvas);
                    accordionTwo.setX(outOfCanvas);
                }
            }
        });
        backFromFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideNavigationBar();
                if (closeThisMenu == false) {
                    accordionOne.setX(showInCanvas);
                    accordionTree.setX(outOfCanvas);
                }
            }
        });
    }

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

    public void existFav() {

        if (ListAdapter.subject_list == null) {
            Log.d("lista", "vacia");

        } else {
            Log.d("lista", "llena");
            File fileXML = new File("/data/data/com.example.notificacionesfcm/shared_prefs/namefile.xml");
            try {
                FileInputStream in = new FileInputStream(fileXML);
                int len = 0;
                byte[] data1 = new byte[1024];
                while (-1 != (len = in.read(data1))) {

                    if (new String(data1, 0, len).contains(idLocation)) {
                        //Toast.makeText(MapsActivity.this, "You have now "+NameLocationText+" in Favorites", Toast.LENGTH_SHORT).show();
                        //ColorFavTextOn = "#FFFFFF";
                        //favText.setTextColor(Color.parseColor(ColorFavTextOn));
                        FavoriteBTN.setBackgroundResource(favoriteBTNTogle[1]);
                        favText.setText("");
                    } else {

                        favText.setText("Add To Favorites");
                        //Toast.makeText(MapsActivity.this, "You dont have "+NameLocationText+" in Favorites", Toast.LENGTH_SHORT).show();
                        //ColorFavTextOn = "#FFFFFF";
                        //favText.setTextColor(Color.parseColor(ColorSelectionLight));
                        FavoriteBTN.setBackgroundResource(favoriteBTNTogle[0]);

                    }


                }
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    //Loading from SharedPreferences

    public void createFavButtons() {
        favBtn0.setVisibility(View.GONE);
        favBtn1.setVisibility(View.GONE);
        favBtn2.setVisibility(View.GONE);
        favBtn3.setVisibility(View.GONE);
        favBtn4.setVisibility(View.GONE);
        favBtn5.setVisibility(View.GONE);
        favBtn6.setVisibility(View.GONE);
        favBtn7.setVisibility(View.GONE);

        Log.d("reload", "reload");


        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);//store or retrieved file "namefile.xml".
        String prefname = sharedPreferences.getString("name", "Not Found");
        //getListValueFromKey = sharedPreferences.getStringSet("myFields", new HashSet<String>());
        getListValueFromKey = sharedPreferences.getStringSet("myFields", new HashSet<String>());


        Map<String, ?> prefsMap = sharedPreferences.getAll();


        List<Sampler.Value> list = new ArrayList<Sampler.Value>((Collection<? extends Sampler.Value>) prefsMap.values());
        newXMList = list.toArray();


        resourceArray = getListValueFromKey.toArray();

        String infoFavText = "hola";
        favTNitem = new LinearLayout[10];
        favClick = new LinearLayout[10];
        exitFav = new ImageView[10];
        textFavoriteInfo = new TextView[10];
        iconFavoriteInfo = new ImageView[10];
        List<List<String>> options;
        options = new ArrayList<>();

        int questionIndex = 0;


        options.add(Collections.singletonList(LatitudInfo));

        for (int i = 0; i < newXMList.length; i++) {
            ////Log.d("esteArray", "" + newXMList[3]);

            if (i < 8) {

                //add button
                String favID = "favBtn" + (i);
                int favorieID = getResources().getIdentifier(favID, "id", getPackageName());
                favTNitem[i] = ((LinearLayout) findViewById(favorieID));
                favTNitem[i].setVisibility(View.VISIBLE);
                favTNitem[i].setClickable(true);


                String favClickID = "favClick" + (i);
                int favoriteClickID = getResources().getIdentifier(favClickID, "id", getPackageName());
                favClick[i] = ((LinearLayout)findViewById(favoriteClickID));
                favClick[i].setVisibility(View.VISIBLE);
                favClick[i].setClickable(true);


                String exitFavClickID = "exitFav" + (i);
                int exitfavoriteClickID = getResources().getIdentifier(exitFavClickID, "id", getPackageName());
                exitFav[i] = ((ImageView)findViewById(exitfavoriteClickID));
                exitFav[i].setVisibility(View.VISIBLE);
                exitFav[i].setClickable(true);

                //add text to the button
                String favInfoID = "textFavoriteInfo" + (i);
                int favorieInfoID = getResources().getIdentifier(favInfoID, "id", getPackageName());
                textFavoriteInfo[i] = ((TextView) findViewById(favorieInfoID));
                //toggles[i].setOnClickListener((View.OnClickListener) this);


                ////Log.d("iconImage", "is running");


                //convert object into String
                LatitudInfo = String.valueOf(newXMList[i]);
                LongitudInfo = String.valueOf(newXMList[i]);

                //Geting Name, Altitud And Latitud from the XML
                String idValue = LatitudInfo, abr = "*", crr = "/";
                String nameValue = LatitudInfo, abriendo = "+", cerrando = "%";
                String latitudes = LatitudInfo, open = "{", close = "}";
                String longitudes = LatitudInfo, abierto = "(", cerrado = ")";
                idValue = idValue.substring(idValue.indexOf(abr) + 1, idValue.lastIndexOf(crr));
                latitudes = latitudes.substring(latitudes.indexOf(open) + 1, latitudes.lastIndexOf(close));
                longitudes = longitudes.substring(longitudes.indexOf(abierto) + 1, longitudes.lastIndexOf(cerrado));
                nameValue = nameValue.substring(nameValue.indexOf(abriendo) + 1, nameValue.lastIndexOf(cerrando));


                final int finalI = i;
                finalNameValue = nameValue;
                final String finalLatitudes = latitudes;
                final String finalLongitudes = longitudes;
                final String idValueRehab = idValue;


                idRehabID = Integer.parseInt(idValue.toString());


                //add icon to the button
                String iconInfoID = "iconFavoriteInfo" + (i);
                int iconoInfoID = getResources().getIdentifier(iconInfoID, "id", getPackageName());
                iconFavoriteInfo[i] = ((ImageView) findViewById(iconoInfoID));


                ////Log.d("myIcons","estos son mis iconos "+idRehabID);



                final int finalI1 = i;


                //click buttons for remove favorite button

                exitFav[i].setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        hideNavigationBar();


                        String convertNameString = (String) newXMList[finalI1];
                        String nameIDTittle = convertNameString, abriendo = "+", cerrando = "%";
                        nameIDTittle = nameIDTittle.substring(nameIDTittle.indexOf(abriendo) + 1, nameIDTittle.lastIndexOf(cerrando));


                        String idTittle = convertNameString, abriendose = "?", cerrandose = "^";
                        idTittle = idTittle.substring(idTittle.indexOf(abriendose) + 1, idTittle.lastIndexOf(cerrandose));



                        NameLocation.setText(nameIDTittle);
                        NameLocationText = nameIDTittle;
                        idLocation = idTittle;

                        timeText.setText("" + TimeInMeeting);
                        textViewToChange.setText(nameIDTittle);




                        Log.d("idLocation", "" + idLocation);

                        progressInfo.setVisibility(View.VISIBLE);

                        Log.d("closeFav","youClick "+idLocation+" "+NameLocationText);


                            Toast.makeText(MapsActivity.this, "You Remove " + idLocation + " from Favorites", Toast.LENGTH_SHORT).show();
                            Log.d("YouRemove", "" + idLocation);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.remove(idLocation);
                            editor.apply();
                            createFavButtons();


                    }
                });

                //click button for favorite buttons
                favClick[i].setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {


                        hideNavigationBar();

                        String convertNameString = (String) newXMList[finalI1];
                        String nameIDTittle = convertNameString, abriendo = "+", cerrando = "%";
                        nameIDTittle = nameIDTittle.substring(nameIDTittle.indexOf(abriendo) + 1, nameIDTittle.lastIndexOf(cerrando));


                        String idTittle = convertNameString, abriendose = "?", cerrandose = "^";
                        idTittle = idTittle.substring(idTittle.indexOf(abriendose) + 1, idTittle.lastIndexOf(cerrandose));


                        menuBTN1.setVisibility(View.GONE);
                        menuBTN2.setVisibility(View.GONE);
                        menuBTN3.setVisibility(View.GONE);
                        menuBTN4.setVisibility(View.GONE);
                        menuBTN5.setVisibility(View.GONE);
                        menuBTN6.setVisibility(View.GONE);
                        menuBTN7.setVisibility(View.GONE);
                        menuBTN8.setVisibility(View.GONE);

                        backBTN1.setVisibility(View.GONE);
                        backBTN2.setVisibility(View.GONE);
                        backBTN3.setVisibility(View.GONE);
                        backBTN4.setVisibility(View.GONE);
                        backBTN5.setVisibility(View.GONE);
                        backBTN6.setVisibility(View.GONE);
                        backBTN7.setVisibility(View.GONE);
                        backBTN8.setVisibility(View.GONE);

                        menuBAckBTN1.setVisibility(View.GONE);
                        menuBAckBTN2.setVisibility(View.GONE);
                        menuBAckBTN3.setVisibility(View.GONE);
                        menuBAckBTN4.setVisibility(View.GONE);
                        menuBAckBTN5.setVisibility(View.GONE);
                        menuBAckBTN6.setVisibility(View.GONE);
                        menuBAckBTN7.setVisibility(View.GONE);
                        menuBAckBTN8.setVisibility(View.GONE);

                        FavoritesWindow = true;


                        latitudForFav = Double.parseDouble(finalLatitudes.toString());

                        longitudForFav = Double.parseDouble(finalLongitudes.toString());

                        idRehabID = Integer.parseInt(idValueRehab.toString());


                        InfoSelection = false;
                        closeThisMenu = false;
                        closeMenu.setX(outOfCanvas);
                        accordionOne.setX(outOfCanvas);
                        accordionTwo.setX(outOfCanvas);
                        accordionTree.setX(outOfCanvas);
                        tituloMenu.setY(showInCanvas);
                        buttonsMapLink.setX(outOfCanvas);
                        mapaLayoutContenido.setX(showInCanvas);
                        LayoutButonLocation.setVisibility(View.VISIBLE);
                        linksMap.setX(showInCanvas);
                        accordionTree.setX(outOfCanvas);
                        linksActive = true;
                        botoneraClick = true;
                        //identificationMapClick = finalI;
                        //favoriteValue = id;
                        center = new LatLng(latitudForFav, longitudForFav);
                        //Log.d("myTag", "latitud is " + latitudForFav + " Longitud is " + longitudForFav + " this center say " + center);

                        //buttonsMapLink.setX(outOfCanvas);
                        MapaWindo = false;
                        //new ParseJSonDataClass(context).execute();
                        InfoSelection = true;

                        gMap.clear();
                        ///getMarkers();


                        NameLocation.setText(nameIDTittle);
                        NameLocationText = nameIDTittle;
                        idLocation = idTittle;

                        timeText.setText("" + TimeInMeeting);
                        textViewToChange.setText(nameIDTittle);

                        latText = latitudForFav;
                        lngText = longitudForFav;


                        Log.d("idLocation", "" + idLocation);

                        progressInfo.setVisibility(View.VISIBLE);
                        startTimerFull();


                        Log.d("nameLocation", "is " + NameLocationText);
                        camaraMoveFav();
                        existFav();


                        if (idRehabID == 1) {
                            //Log.d("changeColor", "change");
                            tittleName = "Alocoholics Anonymous";
                            textTittleColor = "#FFFFFF";
                            ColorSelectionLight = "#E66C5E";
                            ColorSelectionDark = "#CC4A48";
                            CounterBackBtn = 1;
                            selectToggleBoxColor = "#CC4A48";
                        }
                        if (idRehabID == 2) {
                            //Log.d("changeColor", "change");
                            tittleName = "Heroin Anonymous";
                            ColorSelectionLight = "#F69E43";
                            ColorSelectionDark = "#ED7844";
                            CounterBackBtn = 2;
                            selectToggleBoxColor = "#ED7844";
                        }
                        if (idRehabID == 3) {
                            //Log.d("changeColor", "change");
                            tittleName = "Narcotics Anonymous";
                            ColorSelectionLight = "#EFE740";
                            ColorSelectionDark = "#C3C33C";
                            CounterBackBtn = 3;
                            selectToggleBoxColor = "#C3C33C";
                        }
                        if (idRehabID == 4) {
                            tittleName = "Cocaine Anonymous";
                            ColorSelectionLight = "#74C179";
                            ColorSelectionDark = "#4DA763";
                            CounterBackBtn = 4;
                            selectToggleBoxColor = "#4DA763";
                        }
                        if (idRehabID == 5) {
                            tittleName = "Nar Anon";
                            ColorSelectionLight = "#5EADCE";
                            ColorSelectionDark = "#4690B6";
                            CounterBackBtn = 5;
                            selectToggleBoxColor = "#4690B6";
                        }
                        if (idRehabID == 6) {
                            tittleName = "Anon";
                            ColorSelectionLight = "#3A85C3";
                            ColorSelectionDark = "#326DAD";
                            CounterBackBtn = 6;
                            selectToggleBoxColor = "#326DAD";
                        }
                        if (idRehabID == 7) {
                            tittleName = "CMA";
                            ColorSelectionLight = "#9169AB";
                            ColorSelectionDark = "#6C53A0";
                            CounterBackBtn = 7;
                            selectToggleBoxColor = "#6C53A0";
                        }
                        if (idRehabID == 8) {
                            tittleName = "Celebrate Recovery";
                            ColorSelectionLight = "#BB5CA1";
                            ColorSelectionDark = "#9B2780";
                            CounterBackBtn = 8;
                            selectToggleBoxColor = "#9B2780";
                        }


                        Log.d("idRehabID", "" + idRehabID);


                        //changing color of LinearLayouts
                        favoriteBox.setBackgroundColor(Color.parseColor(ColorSelectionLight));
                        linksColorMap.setBackgroundColor(Color.parseColor(ColorSelectionLight));

                        //textViewToChange.setTextColor(Color.parseColor(MainActivity.ColorSelectionDark));
                        getDirText.setTextColor(Color.parseColor(ColorSelectionLight));
                        favText.setTextColor(Color.parseColor(ColorSelectionLight));
                        emailText.setTextColor(Color.parseColor(ColorSelectionLight));
                        caleText.setTextColor(Color.parseColor(ColorSelectionLight));
                        textsendText.setTextColor(Color.parseColor(ColorSelectionLight));
                        titleInputText.setText(tittleName);
                        titleInputTextOne.setText(tittleName);
                        TitleBox.setBackgroundColor(Color.parseColor(ColorSelectionDark));
                        FavoriteTittleBox.setBackgroundColor(Color.parseColor(ColorSelectionDark));


                        String BackbuttonID = "menuBTN" + idRehabID;
                        int backresID = getResources().getIdentifier(BackbuttonID, "id", getPackageName());
                        final View menuBTN = findViewById(backresID);

                        menuBTN.setVisibility(View.VISIBLE);

                        menuBTN.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {


                                hideNavigationBar();

                                if (FavoritesWindow == true) {
                                    //Log.d("checa", "Working Again");
                                    menuFav = true;

                                    //////Log.d("myTag","Muestra el botton de cerrar ");
                                    closeThisMenu = false;
                                    //tituloMenu.setY(outOfCanvas);
                                    //buttonsMapLink.setX(outOfCanvas);
                                    //mapaLayoutContenido.setX(outOfCanvas);
                                    accordionOne.setX(showInCanvas);
                                    linksMap.setX(outOfCanvas);
                                    //LayoutButonLocation.setVisibility(View.GONE);
                                }
                            }
                        });


                        //botones Menu
                        //hide Question Buttons
                        String menuBackID = "menuBAckBTN" + CounterBackBtn;
                        int menubackresID = getResources().getIdentifier(menuBackID, "id", getPackageName());
                        final View menuBAckBTN = findViewById(menubackresID);
                        menuBAckBTN.setVisibility(View.VISIBLE);

                        menuBAckBTN.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                hideNavigationBar();

                                if (menuFav == false) {
                                    //Log.d("menubtn", "precionado");
                                    InfoSelection = false;
                                    closeThisMenu = false;
                                    closeMenu.setX(outOfCanvas);
                                    accordionOne.setX(outOfCanvas);
                                    accordionTwo.setX(outOfCanvas);
                                    accordionTree.setX(outOfCanvas);
                                    tituloMenu.setY(showInCanvas);
                                    buttonsMapLink.setX(showInCanvas);
                                    mapaLayoutContenido.setX(showInCanvas);
                                    LayoutButonLocation.setVisibility(View.VISIBLE);
                                    //closeMenu.setX(showInCanvas);
                                    // closeThisMenu = true;
                                    //////Log.d("myTag","Activamos menu cerra botones no deben funcionar"+closeThisMenu);

                                }
                                if (menuFav == true) {
                                    //Log.d("menubtn", "precionado");
                                    InfoSelection = false;
                                    closeThisMenu = false;
                                    closeMenu.setX(outOfCanvas);
                                    accordionOne.setX(outOfCanvas);
                                    accordionTwo.setX(outOfCanvas);
                                    accordionTree.setX(outOfCanvas);
                                    tituloMenu.setY(showInCanvas);
                                    buttonsMapLink.setX(outOfCanvas);
                                    mapaLayoutContenido.setX(showInCanvas);
                                    LayoutButonLocation.setVisibility(View.VISIBLE);
                                    linksMap.setX(showInCanvas);
                                    //closeMenu.setX(showInCanvas);
                                    // closeThisMenu = true;
                                    //////Log.d("myTag","Activamos menu cerra botones no deben funcionar"+closeThisMenu);

                                }
                            }
                        });

                        String buttonID = "backButton" + idRehabID;
                        int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                        final View buttons = findViewById(resID);

                        //buttons.setId(idRehabID);
                        buttons.setClickable(true);
                        buttons.setVisibility(View.VISIBLE);

                        buttons.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                hideNavigationBar();

                                if (FavoritesWindow == true) {
                                    ////Log.d("checa aqui", "Reload" + FavoritesWindow);
                                    MainActivity.LocationSection = idRehabID;
                                    reloadWindow();
                                    FavoritesWindow = false;

                                }
                            }
                        });


                    }
                });
                textFavoriteInfo[i].setText(nameValue);
                iconFavoriteInfo[i].setBackgroundResource(mThumbIds[idRehabID]);


                favFirstTime = true;
            } else {
                //Log.d("myButtons", "you put more than 8 fav buttons ");
            }
        }
    }

    void camaraMove() {


        getMarkers();
        macandoMapa = new MarkerOptions().position(new LatLng(latText, lngText)).title("" + info);
        if (linksActive == true) {

            macandoMapa = new MarkerOptions().position(new LatLng(latText, lngText)).title("" + info)
                    .zIndex(0)
                    .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.aa_mrk_two));
        }
        if (myMarker == null) {
            //nothing
        } else {
            myMarker = gMap.addMarker(macandoMapa);
        }
        center = new LatLng(latText, lngText);
        if (botoneraClick == true) {
            cameraPosition = new CameraPosition.Builder().target(center).zoom(11).build();
            gMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }
    }

    void camaraMoveFav() {


        macandoMapa = new MarkerOptions().position(new LatLng(latitudForFav, longitudForFav)).title("" + info);
        if (linksActive == true) {

            if (idRehabID == 1) {
                macandoMapa = new MarkerOptions().position(new LatLng(latitudForFav, longitudForFav)).title("" + info)
                        .zIndex(0)
                        .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.aa_mrk_one));
            }
            if (idRehabID == 2) {
                macandoMapa = new MarkerOptions().position(new LatLng(latitudForFav, longitudForFav)).title("" + info)
                        .zIndex(0)
                        .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.aa_mrk_one2));
            }
            if (idRehabID == 3) {
                macandoMapa = new MarkerOptions().position(new LatLng(latitudForFav, longitudForFav)).title("" + info)
                        .zIndex(0)
                        .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.aa_mrk_one3));
            }
            if (idRehabID == 4) {
                macandoMapa = new MarkerOptions().position(new LatLng(latitudForFav, longitudForFav)).title("" + info)
                        .zIndex(0)
                        .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.aa_mrk_one4));
            }
            if (idRehabID == 5) {
                macandoMapa = new MarkerOptions().position(new LatLng(latitudForFav, longitudForFav)).title("" + info)
                        .zIndex(0)
                        .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.aa_mrk_one5));
            }
            if (idRehabID == 6) {
                macandoMapa = new MarkerOptions().position(new LatLng(latitudForFav, longitudForFav)).title("" + info)
                        .zIndex(0)
                        .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.aa_mrk_one6));
            }
            if (idRehabID == 7) {
                macandoMapa = new MarkerOptions().position(new LatLng(latitudForFav, longitudForFav)).title("" + info)
                        .zIndex(0)
                        .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.aa_mrk_one7));
            }
            if (idRehabID == 8) {
                macandoMapa = new MarkerOptions().position(new LatLng(latitudForFav, longitudForFav)).title("" + info)
                        .zIndex(0)
                        .icon(bitmapDescriptorFromVector(getApplicationContext(), R.drawable.aa_mrk_one8));
            }

        }
        myMarker = gMap.addMarker(macandoMapa);


        center = new LatLng(latitudForFav, longitudForFav);
        if (botoneraClick == true) {
            cameraPosition = new CameraPosition.Builder().target(center).zoom(11).build();
            gMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }
    }

    void removeLastMark() {
        if (myMarker == null) {
            //nothing
        } else {
            myMarker.remove();
            //////Log.d("myTag", "remover nuevos tags");
        }
    }

    public void changeColorApp() {
        if (MainActivity.LocationSection == 1) {
            tittleName = "Alocoholics Anonymous";
            textTittleColor = "#FFFFFF";
            ColorSelectionLight = "#E66C5E";
            ColorSelectionDark = "#CC4A48";
            CounterBackBtn = 1;
            selectToggleBoxColor = "#CC4A48";
        }
        if (MainActivity.LocationSection == 2) {
            tittleName = "Heroin Anonymous";
            ColorSelectionLight = "#F69E43";
            ColorSelectionDark = "#ED7844";
            CounterBackBtn = 2;
            selectToggleBoxColor = "#ED7844";

        }
        if (MainActivity.LocationSection == 3) {
            tittleName = "Narcotics Anonymous";
            ColorSelectionLight = "#EFE740";
            ColorSelectionDark = "#C3C33C";
            CounterBackBtn = 3;
            selectToggleBoxColor = "#C3C33C";
        }
        if (MainActivity.LocationSection == 4) {
            tittleName = "Cocaine Anonymous";
            ColorSelectionLight = "#74C179";
            ColorSelectionDark = "#4DA763";
            CounterBackBtn = 4;
            selectToggleBoxColor = "#4DA763";
        }
        if (MainActivity.LocationSection == 5) {
            tittleName = "Nar Anon";
            ColorSelectionLight = "#5EADCE";
            ColorSelectionDark = "#4690B6";
            CounterBackBtn = 5;
            selectToggleBoxColor = "#4690B6";
        }
        if (MainActivity.LocationSection == 6) {
            tittleName = "Anon";
            ColorSelectionLight = "#3A85C3";
            ColorSelectionDark = "#326DAD";
            CounterBackBtn = 6;
            selectToggleBoxColor = "#326DAD";
        }
        if (MainActivity.LocationSection == 7) {
            tittleName = "CMA";
            ColorSelectionLight = "#9169AB";
            ColorSelectionDark = "#6C53A0";
            CounterBackBtn = 7;
            selectToggleBoxColor = "#6C53A0";
        }
        if (MainActivity.LocationSection == 8) {
            tittleName = "Celebrate Recovery";
            ColorSelectionLight = "#BB5CA1";
            ColorSelectionDark = "#9B2780";
            CounterBackBtn = 8;
            selectToggleBoxColor = "#9B2780";
        }
    }

    public void reloadWindow() {
        Intent startNewActivity = new Intent(this, MapsActivity.class);
        startActivity(startNewActivity);
    }

    public void MainMenu() {

        MainActivity.introAnimation = false;
        //Log.d("Main","go to MAin Menu");
        Intent startNewMainMenu = new Intent(this, MainActivity.class);
        startActivity(startNewMainMenu);
    }

    public void Registration() {

        //MainActivity.introAnimation = false;
        //Log.d("Main","go to MAin Menu");
        Intent registrationNewMainMenu = new Intent(this, RegisterActivity.class);
        startActivity(registrationNewMainMenu);
    }

    public void checktextButton() {

        if (favText.getText().toString().matches("")) {
            favText.setText("Add To Favorites");
        }
    }

    protected void sendEmail() {

        googleDirection = "http://maps.google.com/?q=" + latMap + "," + lngMap;

        String[] TO = {""};


        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        //emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Check This Meeting");

        String junta = "Alcoholic Anonymous";
        String urlJunta = "www.junta.com";
        String CalleJunta = "4608 w maryland ave Apt 136 Glendale Az 85301";

        Log.d("myDirection", "" + gmmIntentUri);


        //emailIntent.putExtra(Intent.EXTRA_TEXT, "Hey! The meeting is called "+junta+" - its located at: "+urlJunta+" - "+CalleJunta+" I found it with the Find a meeting app from https://detoxtorehab.com. If you want to download it to your iphone or android:  Ios is link is here and android is here.");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Hey! The meeting is called " + tittleName + " - its located at: " + googleDirection + " - " + info + " I found it with the Find a meeting app from https://detoxtorehab.com. If you want to download it to your iphone or android:  Ios is link is here and android is here.");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            //finish();
            Log.d("EmailsSend", "Finished sending email...");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MapsActivity.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

    public void SMSsendMSG() {

        googleDirection = "http://maps.google.com/?q=" + latMap + "," + lngMap;


        //String smsMSG = "Hey! The meeting is called "+tittleName+" - its located at: "+googleDirection+" - "+info+" I found it with the Find a meeting app from https://detoxtorehab.com. If you want to download it to your iphone or android:  Ios is link is here and android is here.";
        String smsMSG = "Hey! The meeting is called " + tittleName + " it's located at: " + googleDirection + " Download in https://detoxtorehab.com.";
        try {
            SmsManager smgr = SmsManager.getDefault();
            smgr.sendTextMessage(txtphoneNo.getText().toString(), null, smsMSG, null, null);
            Toast.makeText(MapsActivity.this, "SMS Sent Successfully", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(MapsActivity.this, "SMS Failed to Send, Please try again", Toast.LENGTH_SHORT).show();
        }
    }

    public void getCurrentDay() {


        Calendar c = Calendar.getInstance();
        dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        MonthNumb = c.get(Calendar.MONTH);
        YearNum = c.get(Calendar.YEAR);


        if (Calendar.MONDAY == dayOfWeek) {
            weekDay = "1";
        } else if (Calendar.TUESDAY == dayOfWeek) {
            weekDay = "2";
        } else if (Calendar.WEDNESDAY == dayOfWeek) {
            weekDay = "3";
        } else if (Calendar.THURSDAY == dayOfWeek) {
            weekDay = "4";
        } else if (Calendar.FRIDAY == dayOfWeek) {
            weekDay = "5";
        } else if (Calendar.SATURDAY == dayOfWeek) {
            weekDay = "6";
        } else if (Calendar.SUNDAY == dayOfWeek) {
            weekDay = "7";
        }

        System.out.println(MonthNumb);
        System.out.println(dayOfMonth);
        System.out.println(YearNum);

    }

    public void addingCalendar() {


        int TimeInt = Integer.decode(subString);

        Intent calendarIntent = new Intent(Intent.ACTION_INSERT);
        calendarIntent.setData(CalendarContract.Events.CONTENT_URI);
        calendarIntent.putExtra(CalendarContract.Events.TITLE, "" + tittleName);
        calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "" + info);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        cal.set(Calendar.MONTH, MonthNumb);
        cal.set(Calendar.YEAR, YearNum);
        cal.set(Calendar.AM_PM, AMPMint);
        cal.set(Calendar.HOUR, TimeInt);
        cal.set(Calendar.MINUTE, 0);
        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, cal.getTime().getTime());
        cal.set(Calendar.AM_PM, AMPMint);
        cal.set(Calendar.HOUR, TimeInt + 1);
        cal.set(Calendar.MINUTE, 0);
        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, cal.getTime().getTime());
        startActivity(calendarIntent);


    }

    public void SortByTime() {
        if(MainActivity.sort.equals("1")) {
            Log.d("changeActivity","change by Distance");
            if (MainActivity.lattitude == null) {
                hideNavigationBar();
                Intent startNewActivity = new Intent(this, MainActivity.class);
                startActivity(startNewActivity);
            }

            hideNavigationBar();
            MainActivity.sort = "2";
            MainActivity.textShorting = "Sorting by Distance";
            loadNewWindow.setVisibility(View.VISIBLE);
            Intent startNewActivity = new Intent(this, MapsActivity.class);
            startActivity(startNewActivity);
        }else {
            Log.d("changeActivity", "change by Time");
            if (MainActivity.lattitude == null) {
                hideNavigationBar();
                Intent startNewActivity = new Intent(this, MainActivity.class);
                startActivity(startNewActivity);
            }
            hideNavigationBar();
            MainActivity.sort = "1";
            MainActivity.textShorting = "Sorting by Time";
            loadNewWindow.setVisibility(View.VISIBLE);
            Intent startNewActivity = new Intent(this, MapsActivity.class);
            startActivity(startNewActivity);
        }
    }

    public boolean isDeviceTablet() {
        DisplayMetrics metrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        float yInches = metrics.heightPixels / metrics.ydpi;
        float xInches = metrics.widthPixels / metrics.xdpi;
        double diagonalInches = Math.sqrt(xInches * xInches + yInches * yInches);
        if (diagonalInches >= 6.5) {
            Log.d("dispositivo", "Tablet");


            return true;

        }
        Log.d("dispositivo", "Telefono");

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // Make to run your application only in portrait mode
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); // Make to run your application only in LANDSCAPE mode

        return false;
    }

    //check if the info is loaded when you click in the button
    private void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timer.purge();
            Log.d("timer", "Stop timer");
        }
    }

    //To start timer
    private void startTimerFull() {
        timer = new Timer();
        timerTask = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        Log.d("contadorInfo", "" + contadorInfo);

                        if (timeText.getText().toString().matches("")) {
                            Log.d("timeText", "NO tiene");
                            infoAbout.setVisibility(View.GONE);
                            progressInfo.setVisibility(View.VISIBLE);

                            if(MainActivity.RegularMeeting == true){
                                saveSchedule.setVisibility(View.GONE);
                            }

                        } else {
                            Log.d("timeText", "SI tiene");
                            infoAbout.setVisibility(View.VISIBLE);
                            progressInfo.setVisibility(View.GONE);
                            contadorInfo += 1;

                            if(MainActivity.RegularMeeting == false){
                                saveSchedule.setVisibility(View.VISIBLE);
                            }


                            if(MainActivity.RegularMeeting == true) {
                                if (contadorInfo >= 3) {
                                    contadorInfo = 0;
                                    stopTimer();
                                }
                            }

                            if(MainActivity.RegularMeeting == false) {
                                stopTimer();
                            }
                        }
                    }
                });
            }
        };
        timer.schedule(timerTask, 1000, 1000);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK )) {
            //Log.d(this.getClass().getName(), "back button pressed");
            Log.d("backBTN", "Pressed");

        }
        return super.onKeyDown(keyCode, event);
    }

    public void hideKeyboard(){
            InputMethodManager inputMethodManager=(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);

    }

    //serching addres top search
    private void convertAddress() {
        hideKeyboard();
        hideNavigationBar();
        String direccionAddres = EditcitySerch.getText().toString();
        Geocoder coder = new Geocoder(this);
        List<Address> addresses;
        try {
            addresses = coder.getFromLocationName(direccionAddres, 5);
            if (addresses == null) {
                Log.i("Lng", "empty");
            }
            else {
                Address location = addresses.get(0);
                Latitud = location.getLatitude();
                Longitud = location.getLongitude();
                //Log.i("Lat", "" + Latitud);
                //Log.i("Lng", "" + Longitud);
                MainActivity.CityLat = Latitud;
                MainActivity.CityLong = Longitud;
                Log.i("Direction", "" + direccionAddres);
                Log.i("ciudadLat", "" + MainActivity.CityLat);
                Log.i("ciudadLng", "" + MainActivity.CityLong);
                MainActivity.serachCity = true;
                Intent startNewActivity = new Intent(this, MapsActivity.class);
                startActivity(startNewActivity);
                //new ParseJSonDataClass(context).execute();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //serching addres Menu Schudel Meeting
    private void convertAddressSchedule() {
        Log.d("tomando","direccion");
        MainActivity.direccion = serchAddres.getText().toString();
        Geocoder coder = new Geocoder(this);
        List<Address> addresses;
        try {
            addresses = coder.getFromLocationName(MainActivity.direccion, 5);
            if (addresses == null) {
                Log.i("Lng", "empty");
            }
            else {
                Log.i("Direction schedule", "" + MainActivity.direccion);
                Address location = addresses.get(0);
                Latitud = location.getLatitude();
                Longitud = location.getLongitude();
                //Log.i("Lat", "" + Latitud);
                //Log.i("Lng", "" + Longitud);
                MainActivity.CityLat = Latitud;
                MainActivity.CityLong = Longitud;
                Log.i("ciudadLat", "" + MainActivity.CityLat);
                Log.i("ciudadLng", "" + MainActivity.CityLong);
                cityOfMeetingTypo = true;
                Log.d("cityOfMeetingTypo",""+cityOfMeetingTypo);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //notifications

    private void deniedNotification() {

        //heads up notification
        Notification notification = new NotificationCompat.Builder(this, "channel01")
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("ABT Map")
                .setContentText("You see me!")
                .setDefaults(Notification.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)   // heads-up
                .build();
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(0, notification);

    }

    //stop time notification
    private void stopTimerNotification() {
        if (timerNotification != null) {
            timerNotification.cancel();
            timerNotification.purge();
            Log.d("checando notificacion", "Stop timer Notification");
        }
    }

    //checking meeting aproved each 10 seconds
    /*
    private void checkMeetingTime() {
        timerNotification = new Timer();
        timerTaskNotification = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        Log.d("checking meeting","checking");
                        //checkMeeting();
                    }
                });
            }
        };
        timerNotification.schedule(timerTaskNotification, 1000, 10000);
    }
     */
    //checking meeting aproved in the DB
    private void checkMeeting() {

        deniedWaiting +=1;
        Log.d("deniedWaiting",""+deniedWaiting);
        if(deniedWaiting >= 3){
            deniedWaiting=0;
        }

        //kourtis
        registerUrl = "http://ec2-18-224-214-122.us-east-2.compute.amazonaws.com/api/meeting/status.php?install="+idValueMeeting;

        //mine
        //registerUrl = "http://nonstopcode.com/testmydb/SubjectFullForm_dos.php?Install="+idValueMeeting;

        StringRequest request = new StringRequest(Request.Method.GET, registerUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {



                    try {
                    checkNotifyButton();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //Log.d("Message", "" + response);
                if (response.contains("Approved")) {
                    try {
                        JSONArray arr = new JSONArray(response);
                        JSONObject obj = arr.getJSONObject(0);
                        aprovedMeeting = obj.getString("Approved");

                        int ApprovedMeetingInt = Integer.parseInt(aprovedMeeting);

                        //counting hwo many antries has the jsopn array (meetings that i created)
                        int sum = 0;
                        sum = sum + arr.length();
                        Log.d("meetings creadas", "" + sum);

                        JSONObject jsonObject;
                        for (int i = 0; i < arr.length(); i++) {
                            jsonObject = arr.getJSONObject(i);
                            aprovedMeeting = jsonObject.getString("Approved");
                            idMeetingID = jsonObject.getString("ID");
                            idMeetingLat = jsonObject.getString("Latitude");
                            idMeetingLong = jsonObject.getString("Longitude");
                            idMeetingAdd = jsonObject.getString("Address");
                            idMeetingType = jsonObject.getString("Type");
                            nameMeeting = jsonObject.getString("Name");


                            int aprovedMetInt = Integer.parseInt(aprovedMeeting);
                            checkinidMeetingFile();
                            if(xmlIdMeeting == true) {
                                if (aprovedMeeting.contains("1")) {
                                    //approved --------------------------------------------------------
                                    SharedPreferences.Editor editor = sharedPreferencesIDMeeting.edit();
                                    editor.putString(idMeetingID, String.valueOf(idMeetingPreference));
                                    editor.apply();
                                    putNameMeeting = nameMeeting;
                                    Log.d("putNameMeeting", "" + putNameMeeting);
                                    addNotification();
                                    //editor.commit();
                                }
                                if (aprovedMeeting.contains("0")) {
                                    //denied ----------------------------------------------------------
                                    DeniedaddNotification();
                                    idMeetingPreference.add("");
                                    SharedPreferences.Editor editor = sharedPreferencesIDMeeting.edit();
                                    //editor.clear(); //[important] Clearing your editor before using it.
                                    //editor.putStringSet("myFields", getListValueFromKey);
                                    editor.putString(idMeetingID, String.valueOf(idMeetingPreference));
                                    editor.apply();
                                    //editor.commit();
                                }
                            }
                        }
                    } catch (Throwable t) {
                        Log.e("My App", "Could not parse malformed JSON: \"" + response + "\"");
                    }
                    //Toast.makeText(getApplicationContext(), "Welcome!!", Toast.LENGTH_SHORT).show();
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
                return params;
            }
        };
        Volley.newRequestQueue(this).add(request);

    }

    private void addNotification() {
        Log.d("notificationHead",""+MainActivity.Notifications);

        if(MainActivity.Notifications == true){
            Log.d("info similar", "true");
            aprovedSound.start();
            Intent notificationIntent = new Intent(MapsActivity.this, MapsActivity.class);
            Bundle bundle = new Bundle();
            notificationIntent.putExtras(bundle);
            PendingIntent contentIntent = PendingIntent.getActivity(MapsActivity.this, WIZARD_NOTIFICATION_ID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            //heads up notification
            Notification notification = new NotificationCompat.Builder(this, "channel01")
                    .setSmallIcon(android.R.drawable.ic_dialog_info)
                    .setContentTitle("Find a meeting app - " + nameMeeting)
                    .setContentText("Thank you, Your meeting was approved!")
                    .setDefaults(Notification.BADGE_ICON_LARGE)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)   // heads-up
                    .setContentIntent(contentIntent)
                    .setSound(null)
                    .build();
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
            notificationManager.notify(0, notification);
        }
    }

    private void DeniedaddNotification() {
        if(MainActivity.Notifications == true) {

            deniedWaiting = 1;
            denieddSound.start();
            //heads up notification
            Notification notification = new NotificationCompat.Builder(this, "channel01")

                    .setSmallIcon(android.R.drawable.ic_dialog_info)
                    .setContentTitle("Find a meeting app - " + nameMeeting)
                    .setContentText("Sorry your meeting couldn’t be approved at this time.")
                    .setDefaults(Notification.BADGE_ICON_LARGE)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)   // heads-up
                    .setSound(null)
                    .build();
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
            notificationManager.notify(0, notification);


        }
    }


    public void checkingMeetingXML(){
        //for My ID File
        sharedPreferencesID = getSharedPreferences(PREFS_ID, Context.MODE_PRIVATE);//store or retrieved file "idfile.xml".
        getListValueFromKeyID = sharedPreferencesID.getStringSet("myFields", new HashSet<String>());
        //create idfile.xml MSG file
        File idFile = new File("/data/data/com.example.notificacionesfcm/shared_prefs/idfile.xml");
        if (idFile.exists()) {
            Log.d("idfile.xml", "existe");
            sharedPreferencesID = getSharedPreferences(PREFS_ID, Context.MODE_PRIVATE);//store or retrieved file "idfile.xml".
            idValueMeeting = sharedPreferencesID.getString("name", "Not Found");
            Log.d("valor en idfile.xml",""+idValueMeeting);
        } else {
            Log.d("idfile.xml", "Doesn't existe");
        }
    }

    public void checkinidMeetingFile() throws IOException {
        //Log.d("checar ID",""+idMeetingID);
        File fileXML = new File("/data/data/com.example.notificacionesfcm/shared_prefs/idMeeting.xml");
        FileInputStream in = new FileInputStream(fileXML);
        int len = 0;
        byte[] data1 = new byte[1024];
        while (-1 != (len = in.read(data1))) {
            if (new String(data1, 0, len).contains(idMeetingID)) {
                Log.d("info similar","verdad");
                xmlIdMeeting= false;
            }
            else{
                xmlIdMeeting = true;
            }
        }
    }
    public void checkNotifyButton() throws IOException {
        File fileXML = new File("/data/data/com.example.notificacionesfcm/shared_prefs/notifications.xml");
        FileInputStream in = new FileInputStream(fileXML);
        int len = 0;
        byte[] data1 = new byte[1024];
        while (-1 != (len = in.read(data1))) {
            if (new String(data1, 0, len).contains("true")) {
                toggleNotifyON.setVisibility(View.VISIBLE);
                toggleNotifyOFF.setVisibility(View.GONE);
                MainActivity.Notifications = true;
            }
            if (new String(data1, 0, len).contains("false")) {
                toggleNotifyON.setVisibility(View.GONE);
                toggleNotifyOFF.setVisibility(View.VISIBLE);
                MainActivity.Notifications = false;
            }
        }
    }

    public void checkNotifyFile() throws IOException {
        SharedPreferences.Editor editorNotify = sharedPreferencesNotify.edit();
        editorNotify.clear(); //[important] Clearing your editor before using it.
        File fileXML = new File("/data/data/com.example.notificacionesfcm/shared_prefs/notifications.xml");
        FileInputStream in = new FileInputStream(fileXML);
        int len = 0;
        byte[] data1 = new byte[1024];
        while (-1 != (len = in.read(data1))) {
            if (new String(data1, 0, len).contains("true")) {
                MainActivity.NotificationsBoolena = false;
                Log.d("noficacion Boleana",""+MainActivity.NotificationsBoolena);
                editorNotify.putString("Notificaciones", "false");
                //editorNotify.commit();
                editorNotify.apply();
                MainActivity.Notifications = true;
                toggleNotifyON.setVisibility(View.GONE);
                toggleNotifyOFF.setVisibility(View.VISIBLE);

            }
            if (new String(data1, 0, len).contains("false")) {
                MainActivity.NotificationsBoolena = true;
                Log.d("noficacion Boleana",""+MainActivity.NotificationsBoolena);
                editorNotify.putString("Notificaciones", "true");
                //editorNotify.commit();
                editorNotify.apply();
                MainActivity.Notifications = false;
                toggleNotifyON.setVisibility(View.VISIBLE);
                toggleNotifyOFF.setVisibility(View.GONE);


            }

        }
    }

    public void loadScheduleWindow(){
        MainActivity.serachCity = true;
        Intent startNewActivity = new Intent(this, MapsActivity.class);
        startActivity(startNewActivity);
        //new ParseJSonDataClass(context).execute();

    }

    //adding to Schedule File
    /*
    public void addingtoSchedule() {
        //adding
        getListValueFromSchedule.add("Meeting will be in :"+ cityAdd + " in this address " + info + " at: " + TimeInMeeting + " "+ MainActivity.dayLongName + " " + MainActivity.DayMonthSchedule + " " + MainActivity.yearSchedule);
        SharedPreferences.Editor editor = sharedPreferencesSchule.edit();
        editor.putStringSet(NameLocationText, getListValueFromSchedule);
        editor.commit();
        AddScheduleClicked = false;

    }
     */


    //adding Meeting to shared preference
    public void addingtoSchedule() {
        //getListValueFromSchedule.add(cityAdd + " in this address " + info + " at: " + TimeInMeeting + " "+ MainActivity.dayLongName + " " + MainActivity.DayMonthSchedule + " " + MainActivity.yearSchedule);
        //getListValueFromKey.add("*" + MainActivity.LocationSection + "/ The address is: +" + calle + "%, Latitud is: {" + latitudNumber + "} , Longitud is: (" + longitudNumber + ")" + "this is the ID : ?" + identity + "^");
        getListValueFromSchedule.add("");
        SharedPreferences.Editor editor = sharedPreferencesSchule.edit();
        //editor.clear(); //[important] Clearing your editor before using it.
        //editor.putStringSet("myFields", getListValueFromKey);

        String NameString = NameLocationText + " " + TimeInMeeting + " "+ MainActivity.dayLongName + " " + MainActivity.DayMonthSchedule + " " + MainActivity.yearSchedule;
        editor.putString(NameString, String.valueOf(getListValueFromKey));
        editor.apply();
        //editor.commit();

    }

    //checking Schedule meeting
    /*
    public void checkSchudelMeeting(){

        File fileXML = new File("/data/data/com.example.notificacionesfcm/shared_prefs/schudelmeetings.xml");


        //compare with the day
        try {
            FileInputStream in = new FileInputStream(fileXML);
            int len = 0;
            byte[] data1 = new byte[1024];
            while (-1 != (len = in.read(data1))) {
                if (new String(data1, 0, len).contains(compareDate)) {

                    Log.d("contiene","SI contiene");

                    //heads up notification
                    Notification notification = new NotificationCompat.Builder(this, "channel01")
                            .setSmallIcon(android.R.drawable.ic_dialog_info)
                            .setContentTitle("You Have a Meeting Today")
                            .setContentText(compareDateTime)
                            .setDefaults(Notification.DEFAULT_ALL)
                            .setPriority(NotificationCompat.PRIORITY_HIGH)   // heads-up
                            .build();
                    NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
                    notificationManager.notify(0, notification);


                } else {
                    Log.d("contiene","NO contiene");

                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //compare with especific date and hour
        try {
            FileInputStream in = new FileInputStream(fileXML);
            int len = 0;
            byte[] data1 = new byte[1024];
            while (-1 != (len = in.read(data1))) {
                if (new String(data1, 0, len).contains(compareDateTime)) {

                    Log.d("contiene","SI contiene");

                    //heads up notification
                    Notification notification = new NotificationCompat.Builder(this, "channel01")
                            .setSmallIcon(android.R.drawable.ic_dialog_info)
                            .setContentTitle("You Have a Meeting Today")
                            .setContentText(compareDateTime)
                            .setDefaults(Notification.DEFAULT_ALL)
                            .setPriority(NotificationCompat.PRIORITY_HIGH)   // heads-up
                            .build();
                    NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
                    notificationManager.notify(0, notification);


                } else {
                    Log.d("contiene","NO contiene");

                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
     */

    //adding in the calendar schedule meeting
    public void addingCalendarSchedule() {
        TimeInt = Integer.decode(subString);
        Intent calendarIntent = new Intent(Intent.ACTION_INSERT);
        calendarIntent.setData(CalendarContract.Events.CONTENT_URI);
        calendarIntent.putExtra(CalendarContract.Events.TITLE, "" + NameLocationText + " at: "+TimeInMeeting);
        calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "" + info);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        cal.set(Calendar.MONTH, MonthNumb);
        cal.set(Calendar.YEAR, YearNum);
        cal.set(Calendar.AM_PM, AMPMint);
        cal.set(Calendar.HOUR, TimeInt);
        cal.set(Calendar.MINUTE, 0);
        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, cal.getTime().getTime());
        cal.set(Calendar.AM_PM, AMPMint);
        cal.set(Calendar.HOUR, TimeInt + 1);
        cal.set(Calendar.MINUTE, 0);

        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, cal.getTime().getTime());
        startActivity(calendarIntent);


    }


}