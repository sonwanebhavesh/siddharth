package com.example.owner.sgfitnessfreaks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginPage extends AppCompatActivity {
    Button b1;
    EditText e1;
    //DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        //db=new DatabaseHelper(this);
        e1=(EditText)findViewById(R.id.editText);
        //  e2=(EditText)findViewById(R.id.editText2);
        b1=(Button)findViewById(R.id.button);
        //b2=(Button)findViewById(R.id.register);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=e1.getText().toString();
                // String password=e2.getText().toString();
                // Boolean chkemailpass=db.emailpassword(email,password);
                if(email.equals("9424420130")){
                    //  if(chkemailpass==true){

                    Toast.makeText(getApplicationContext(),"login successful",Toast.LENGTH_LONG).show();
                    Intent g=new Intent(LoginPage.this,Customer.class);
                    startActivity(g);
                    e1.setText("");
                    //e2.setText("");


                }

                else{
                    Toast.makeText(getApplicationContext(),"Wrong email or password",Toast.LENGTH_LONG).show();
                    e1.setText("");
                    // e2.setText("");


                }
            }
        });
        // b2.setOnClickListener(new View.OnClickListener() {
        //   @Override
        // public void onClick(View v) {
        //   Intent i=new Intent(Login.this,Register.class);
        // startActivity(i);
        //}
        //});
    }
}
