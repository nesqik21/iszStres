package com.example.tomas.stres;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class first extends AppCompatActivity {

    public Button btn1;
    public EditText vek;
    public EditText okres;
    public String pohlavie;
    public CheckBox checkBox;


    public void init(){
        vek = (EditText)findViewById(R.id.editText4);
        okres= (EditText)findViewById(R.id.editText5);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        btn1 = (Button)findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ( ( vek.getText().toString().trim().equals("")) )
                {
                    Toast.makeText(getApplicationContext(), "Vyplnte vas vek", Toast.LENGTH_SHORT).show();
                }
                else if( ( okres.getText().toString().trim().equals("")) )
                {
                    Toast.makeText(getApplicationContext(), "Vyplne vas okres", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent toy = new Intent(first.this,second.class);
                    pohlavie = "Žena";
                    if(checkBox.isChecked())
                        pohlavie = "Muž";
                    toy.putExtra("vek", vek.getText().toString());
                    toy.putExtra("pohlavie", pohlavie);
                    toy.putExtra("okres", okres.getText().toString());
                    startActivity(toy);
                }
            }
        });
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        init();
    }
}
