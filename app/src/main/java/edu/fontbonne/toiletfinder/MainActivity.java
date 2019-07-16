package edu.fontbonne.toiletfinder;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //initialize value
    ImageView icon;
    Button Login;
    Button Register;
    Button Guest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set image for ImageView
        icon = (ImageView)findViewById(R.id.iv_icon);
        icon.setImageResource(R.drawable.icon);

        //handle the button
        Login =(Button)findViewById(R.id.btn_login);
        Register = (Button)findViewById(R.id.btn_register);
        Guest = (Button)findViewById(R.id.btn_guest);

        //set onClick for each button
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        //set on click for register button
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        //set on click for Guest button
        Guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MapActivity.class);
                startActivity(intent);
            }
        });

    }
}
