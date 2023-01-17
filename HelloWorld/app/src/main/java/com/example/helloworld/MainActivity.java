//Written by: Nina S. 17.01.23
//Unfilterd api extracted data via button press
package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONObject;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView txtResponse;
    String url = "https://catfact.ninja/fact";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResponse = findViewById(R.id.txt_view);
        btn = findViewById(R.id.btn_change);

    }//end on create

    public void changeTxt(View view) {

        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest strReq = new StringRequest(Request.Method.GET, url,
                response -> {
                    txtResponse.setText(response);
                    System.out.println(response);
                },
                error -> {
                    Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                }
        );//end string req

        queue.add(strReq);

    }// end change text

}//end main activity