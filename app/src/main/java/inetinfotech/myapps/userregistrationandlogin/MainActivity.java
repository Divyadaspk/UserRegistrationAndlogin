package inetinfotech.myapps.userregistrationandlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText et1,et2,et3,et4;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button);
        et1=findViewById(R.id.editText);
        et2=findViewById(R.id.editText2);
        et3=findViewById(R.id.editText3);
        et4=findViewById(R.id.editText4);
        tv=findViewById(R.id.textView);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,LOGIN.class);
                startActivity(intent);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(et1.getText().toString().isEmpty()||et2.getText().toString().isEmpty()||et3.getText().toString().isEmpty()||et4.getText().toString().isEmpty())&&(et3.getText().toString().equals(et4.getText().toString())))
                {

                    StringRequest stringRequest = new StringRequest(Request.Method.POST,"https://transvestic-bear.000webhostapp.com/Registration.php",
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
//If we are getting success from server
                                    Toast.makeText(MainActivity.this,response, Toast.LENGTH_LONG).show();

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

params.put("Name",et1.getText().toString());
params.put("email",et2.getText().toString());
params.put("Password",et3.getText().toString());
params.put("status","1");
//returning parameter
                            return params;
                        }
                    };

//Adding the string request to the queue
                    RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                    requestQueue.add(stringRequest);


                }
                else
                {
                    Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_LONG).show();




                }

            }
        });




    }
}
