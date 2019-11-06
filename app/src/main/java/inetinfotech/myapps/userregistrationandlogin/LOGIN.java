package inetinfotech.myapps.userregistrationandlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LOGIN extends AppCompatActivity {
    EditText et,ed;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et=findViewById(R.id.editText5);
        ed=findViewById(R.id.editText6);
        btn=findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(et.getText().toString().isEmpty()||ed.getText().toString().isEmpty()))
                {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST,"https://transvestic-bear.000webhostapp.com/Registration.php",
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
//If we are getting success from server
                                    Toast.makeText(LOGIN.this,response, Toast.LENGTH_LONG).show();

//                                    try {
//                                        JSONArray jsonArray=new JSONArray(response);
//                                        for(int i=0;i<jsonArray.length();i++){
//                                            JSONObject json_obj = jsonArray.getJSONObject(i);
//                                            latitude = json_obj.getString("latitude");
//                                            longitude=json_obj.getString("longitude");
//                                            Toast.makeText(MapsActivity.this,latitude,Toast.LENGTH_SHORT).show();
//                                        }
//                                    } catch (JSONException e) {
//                                        e.printStackTrace();
//                                    }

                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
//You can handle error here if you want
                                }

                            }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> params = new HashMap<>();
//Adding parameters to request

                            params.put("Name",et.getText().toString());
                            params.put("Password",ed.getText().toString());
                            params.put("status","2");
//returning parameter
                            return params;
                        }
                    };

//Adding the string request to the queue
                    RequestQueue requestQueue = Volley.newRequestQueue(LOGIN.this);
                    requestQueue.add(stringRequest);


                }
                else
                {
                    Toast.makeText(LOGIN.this,"Failed",Toast.LENGTH_LONG).show();




                }

            }
        });

    }
}
