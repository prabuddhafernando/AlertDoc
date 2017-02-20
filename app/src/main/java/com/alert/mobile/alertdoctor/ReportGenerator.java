package com.alert.mobile.alertdoctor;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v4.os.AsyncTaskCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

public class ReportGenerator extends Activity {

    private EditText edName , edProblem;
    private TextView locationDetails;
    private Button btnSendToServer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_generator);
        edName = (EditText) findViewById(R.id.edName);
        edProblem  = (EditText) findViewById(R.id.edProblem);

        locationDetails = (TextView) findViewById(R.id.txtlocation);
        btnSendToServer = (Button) findViewById(R.id.buttonsend);
        //locationDetails.setText("Your Location Latitude "+AppConfigData.user_location.getLatitude()+"\nLongitude "+AppConfigData.user_location.getLongitude());
        btnSendToServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(AppConfigData.isGPSAvailable){
                    String nametoSend=edName.getText().toString();
                    String reporttoSend=edProblem.getText().toString() ;

                    if(!nametoSend.equals("") && !reporttoSend.equals("")){
                        sendToServerAz send = new sendToServerAz();
                        send.execute("");
                    }else{
                        Toast.makeText(ReportGenerator.this,"Please insert the data form correctly",Toast.LENGTH_LONG).show();
                    }
                }else{
                    // handle this
                }
            }
        });
    }
    public JSONObject sendPost(){
        String nametoSend=edName.getText().toString();
        String reporttoSend=edProblem.getText().toString() ;
        JSONObject obj = new JSONObject();
        if(!nametoSend.equals("") && !reporttoSend.equals("")){
            try {
                obj.put("name", nametoSend.toString());
                obj.put("report", reporttoSend.toString());
                obj.put("lat", AppConfigData.user_location.getLatitude());
                obj.put("lon", AppConfigData.user_location.getLongitude());

                Log.d("alert","Json"+obj.toString());
            }catch (Exception e){
                    obj= null;
            }
        }else{
                obj = null;
            Toast.makeText(ReportGenerator.this,"Please insert the data form correctly", Toast.LENGTH_LONG ).show();
        }
        return  obj;
    }

    class sendToServerAz extends AsyncTask{

        String retrunValue="";
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Object[] params) {


            try {

                JSONObject object = sendPost();
                //post method
                if(object!=null) {
                    retrunValue =  HttpManager.sendOnPost(object);
                }else{
                    retrunValue = "";
                }

                // get method
               // HttpManager.getData(params[0].toString());
            }catch (Exception e ){
                Log.e("alert","error aznc "+e);
            }
            return retrunValue;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            Log.e("alert","On Post :: "+ retrunValue);
        }
    }


}
