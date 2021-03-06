package com.blueskylinks.spc_main;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.provider.Telephony;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import static com.blueskylinks.spc_main.Main2Activity.progressDialog;

public class UsersActivity extends AppCompatActivity {
    String no;
    String SMSBody1;
    TextView text1;
    TextView text2;
    TextView text3;
    TextView text4;
    TextView text5;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    String user1;
    String user2;
    String user3;
    String user4;
    String user5;
    String phoneNumber = "9663261329";
    EditText et1;
    EditText et2;
    ProgressBar pbar1;
    ProgressBar pbar2;
    ProgressBar pbar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        String message = "SPC,92";
        SmsManager smsManager = SmsManager.getDefault();
     smsManager.sendTextMessage(phoneNumber, null, message, null, null);
        Log.i("Test", "SMS sent!");
        pbar1.setVisibility(View.VISIBLE);
        textView1.setText("Command Sent, Please Wait...For 2 minutes");
        progress();
        text1 = findViewById(R.id.u_text11);
        text2 = findViewById(R.id.u_text22);
        text3 = findViewById(R.id.u_text33);
        text4 = findViewById(R.id.u_text44);
        text5 = findViewById(R.id.u_text55);

        textView1=findViewById(R.id.onoff_status_text_1);
        textView2 = findViewById(R.id.onoff_status_text_2);
        pbar2 = findViewById(R.id.onoff_pgbar_1);
        et1 = findViewById(R.id.add_us_t3);
        pbar3 = findViewById(R.id.onoff_pgbar1);
        textView3 = findViewById(R.id.onoff_status_text1);
    }

@Override
public void onResume(){
        super.onResume();
        SMSBody1="";
    final IntentFilter IntentFilter = new IntentFilter(Telephony.Sms.Intents.SMS_RECEIVED_ACTION);
    registerReceiver(addorremovereceiver, IntentFilter);
    registerReceiver(addorremovereceiver,IntentFilter);
}

    public void settings(View view){
        //starting another activity..
        Intent it1 = new Intent(UsersActivity.this, SettingsActivity.class);
        startActivity(it1);
    }

    //Hoome functions
    public void home(View view){
        Intent it1 = new Intent(UsersActivity.this, Main2Activity.class);
        startActivity(it1);
    }

    public void ON_OFF(View view){
        //starting another activity..
        Intent it2 = new Intent(UsersActivity.this, ON_OFFActivity.class);
        startActivity(it2);
    }

    public void manual(View view){
        //starting another activity..
        Intent it4 = new Intent(UsersActivity.this, ManualActivity.class);
        startActivity(it4);
    }

    //Progress Dialog
    public void progress(){
        progressDialog = new ProgressDialog(UsersActivity.this);
        progressDialog.setMessage("Loading..."); // Setting Message
        progressDialog.setTitle(" "); // Setting Title
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
        progressDialog.show(); // Display Progress Dialog
        progressDialog.setCancelable(false);
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();
            }
        }).start();
    }

    //Add users
    public void Add_users(View view) {
        user2 = text2.getText().toString();
        user3 = text3.getText().toString();
        user4 = text4.getText().toString();
        user5 = text5.getText().toString();
        no = et1.getText().toString();
        if(TextUtils.isEmpty(no)) {et1.setError("enter valid number");}
        else{
            Log.i("test", user2);
            if (no.equals(user2) || no.equals(user3) || no.equals(user4) || no.equals(user5) || no.equals(user1)) {
                Toast.makeText(this, "User already added", Toast.LENGTH_SHORT).show();
                Log.i("..", "Error msg");
            } else {
                if (user2.equals(" ")) {
                    String message = "SPC,38,1," + no;
                    Log.i("added no", message);
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                    Log.i("Test", "SMS sent!");
                    pbar2.setVisibility(View.VISIBLE);
                    textView2.setText("Command Sent, Please Wait...For 2 minutes");
                } else if (user3.equals(" ")) {
                    String message = "SPC,39,1," + no;
                    Log.i("added no", message);
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                    Log.i("Test", "SMS sent!");
                    pbar2.setVisibility(View.VISIBLE);
                    textView2.setText("Command Sent, Please Wait...For 2 minutes");
                } else if (user4.equals(" ")) {
                    String message = "SPC,40,1," + no;
                    Log.i("added no", message);
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                    Log.i("Test", "SMS sent!");
                    pbar2.setVisibility(View.VISIBLE);
                    textView2.setText("Command Sent, Please Wait...For 2 minutes");
                } else if (user5.equals(" ")) {
                    String message = "SPC,41,1," + no;
                    Log.i("added no", message);
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                    Log.i("Test", "SMS sent!");
                    pbar2.setVisibility(View.VISIBLE);
                    textView2.setText("Command Sent, Please Wait...For 2 minutes");
                } else et1.setError("you reached maximum limit!!...");
            }
            et1.getText().clear();
        }
    }

    public void refresh(View view){
        pbar1=findViewById(R.id.onoff_pgbar11);
        String message = "SPC,92";
        SmsManager smsManager = SmsManager.getDefault();
         smsManager.sendTextMessage(phoneNumber, null, message, null, null);
        Log.i("Test", "SMS sent!");
      pbar1.setVisibility(View.VISIBLE);
      textView1.setText("Command Sent, Please Wait...For 2 minutes");

        text2.setText(" ");
        text3.setText(" ");
        text4.setText(" ");
        text5.setText(" ");
    }


    public void remove(View view) {
        user2 = text2.getText().toString();
        user3 = text3.getText().toString();
        user4 = text4.getText().toString();
        user5 = text5.getText().toString();
        et2 = findViewById(R.id.add_us_t1);
        String Rno = et2.getText().toString();

        if (TextUtils.isEmpty(Rno)) {
          et2.setError("enter valid number");
        }
        else {
            if (Rno.equals(user2)) {
                String message = "SPC,38,0";
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                Log.i("Test", "SMS sent!");
                pbar3.setVisibility(View.VISIBLE);
                textView3.setText("Command Sent, Please Wait...For 2 minutes");
            } else if (Rno.equals(user3)) {
                String message = "SPC,39,0";
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                Log.i("Test", "SMS sent!");
                pbar3.setVisibility(View.VISIBLE);
                textView3.setText("Command Sent, Please Wait...For 2 minutes");
            } else if (Rno.equals(user4)) {
                String message = "SPC,40,0";
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                Log.i("Test", "SMS sent!");
                pbar3.setVisibility(View.VISIBLE);
                textView3.setText("Command Sent, Please Wait...For 2 minutes");
            } else if (Rno.equals(user5)) {
                String message = "SPC,41,0";
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                Log.i("Test", "SMS sent!");
                pbar3.setVisibility(View.VISIBLE);
                textView3.setText("Command Sent, Please Wait...For 2 minutes");
            } else {
                Toast.makeText(this, "please enter valid number", Toast.LENGTH_SHORT).show();
            }
            et2.getText().clear();
        }
    }

    private final BroadcastReceiver addorremovereceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent1) {
            if (Telephony.Sms.Intents.SMS_RECEIVED_ACTION.equals(intent1.getAction())) {
                for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent1)) {
                    SMSBody1 = smsMessage.getMessageBody().toString();
                    Log.i("Received sms", SMSBody1);
                    String sms = SMSBody1;
                    Log.i("length",String.valueOf(SMSBody1.length()));
                    String[] lines = SMSBody1.split("\\r?\\n");
                    if(sms.length()>21) {
                        if (lines[2].toString().contains("Spcmno")) {
                            text1.setText(lines[2].toString().substring(10));
                            Log.i("test", lines[2].toString().substring(10));
                              pbar1.setVisibility(View.INVISIBLE);
                             textView1.setText("users list updated");
                            for (int i = 3; i <= 6; i++) {
                                    if (lines[i].toString().contains("Spcbno")) {
                                        text2.setText(lines[i].toString().substring(10));
                                        Log.i("test", lines[i].toString().substring(10));
                                    } else if (lines[i].toString().contains("Spccno")) {
                                        text3.setText(lines[i].toString().substring(10));
                                        Log.i("test", lines[i].toString().substring(10));
                                    } else if (lines[i].toString().contains("Spcdno")) {
                                        text4.setText(lines[i].toString().substring(10));
                                        Log.i("test", lines[i].toString().substring(10));
                                    } else if (lines[i].toString().contains("Spceno")) {
                                        text5.setText(lines[i].toString().substring(10));
                                        Log.i("test", lines[i].toString().substring(10));
                                    } else return;
                                }
                            }else if (lines[2].toString().contains("New")) {
                            textView2.setText(lines[2]);
                            pbar2.setVisibility(View.INVISIBLE);
                        }else if(lines[1].toString().contains("deleted")){
                            textView3.setText(lines[1].substring(11));
                            pbar3.setVisibility(View.INVISIBLE);
                        }
                        }
                    }
                        SMSBody1 = "";
                    }
        }
    };

    @Override
   public void onPause(){
        super.onPause();
        unregisterReceiver(addorremovereceiver);
    }
}
