package com.example.owner.sgfitnessfreaks;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Customer extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText Name,Mobile,Joining,Payment;
    Button Insertf,Selectf,Updatef,Deletef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        myDb =new DatabaseHelper(this);
        Name=(EditText)findViewById(R.id.Name);
        Mobile=(EditText)findViewById(R.id.Mobile);
        Joining=(EditText)findViewById(R.id.Joining);
        Payment=(EditText)findViewById(R.id.Payment);
        Insertf=(Button) findViewById(R.id.Insertf);
        Updatef=(Button)findViewById(R.id.Updatef);
        Selectf=(Button) findViewById(R.id.Selectf);
        Deletef=(Button)findViewById(R.id.Deletef);
        AddData();
        viewAll();
        UpdateData();
        DeleteData();
    }
    public void AddData()
    {
        Insertf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                boolean isInserted=myDb.inserdataf(Name.getText().toString(),Mobile.getText().toString(),Joining.getText().toString(),Payment.getText().toString());
                String s1=Name.getText().toString();
                String s2=Mobile.getText().toString();
                String s3=Joining.getText().toString();
                String s4=Payment.getText().toString();

                if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")){
                    Toast.makeText(Customer.this,"Field is empty",Toast.LENGTH_LONG).show();

                }
                if (isInserted==true){
                    Toast.makeText(Customer.this,"record inserted",Toast.LENGTH_LONG).show();
                    Name.setText("");
                    Mobile.setText("");
                    Joining.setText("");
                    Payment.setText("");
                }
                else {
                    Toast.makeText(Customer.this,"record not inserted",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void viewAll()
    {
        Selectf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = myDb.getAllData();
                if (res.getCount() == 0) {
                    showMessage("Error", "No data show");
                    return;
                } else {
                    StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext()) {
                        buffer.append("Name:" + res.getString(0) + "\n");
                        buffer.append("Mobile:" + res.getString(1) + "\n");
                        buffer.append("Joining:" + res.getString(2) + "\n");
                        buffer.append("Payment:" + res.getString(3) + "\n\n");
                    }
                    showMessage(" Customer Data",buffer.toString());
                }
            }
        });
    }
    public void showMessage(String title,String msg)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();
    }
    public void UpdateData()
    {
        Updatef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=Name.getText().toString();
                boolean isUpdate=myDb.updateData(Name.getText().toString(),Mobile.getText().toString(),Joining.getText().toString(),Payment.getText().toString());
                if(s1.equals("")){
                    Toast.makeText(Customer.this,"Enter Name ",Toast.LENGTH_LONG).show();

                }
                if (isUpdate==true)
                {
                    Toast.makeText(Customer.this,"record update",Toast.LENGTH_LONG).show();
                    Name.setText("");
                    Mobile.setText("");
                    Joining.setText("");
                    Payment.setText("");
                }
                else {
                    Toast.makeText(Customer.this,"record not update",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    public void DeleteData()
    {
        Deletef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=Name.getText().toString();
                Integer deletedRows=myDb.deleteData(Name.getText().toString());
                if(s1.equals("")){
                    Toast.makeText(Customer.this,"Enter Name ",Toast.LENGTH_LONG).show();

                }


                if (deletedRows>0){
                    Toast.makeText(Customer.this,"record deleted",Toast.LENGTH_LONG).show();
                    Name.setText("");
                    Mobile.setText("");
                    Joining.setText("");
                    Payment.setText("");
                }
                else {
                    Toast.makeText(Customer.this,"record not deleted",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
