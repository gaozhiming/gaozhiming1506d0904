package com.example.administrator.gaozhiming1506d0904;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button but01;
    private Button but02;
    private Button but03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        but01 = (Button) findViewById(R.id.tvbut01);
        but02 = (Button) findViewById(R.id.tvbut02);
        but03 = (Button) findViewById(R.id.tvbut03);



    }
}
