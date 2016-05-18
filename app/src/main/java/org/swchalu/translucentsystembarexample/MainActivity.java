package org.swchalu.translucentsystembarexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_img;
    private Button btn_color;
    private Button btn_draw;
    private Button btn_alpha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_img = (Button) findViewById(R.id.btn_img);
        btn_color = (Button) findViewById(R.id.btn_color);
        btn_draw = (Button) findViewById(R.id.btn_draw);
        btn_alpha = (Button) findViewById(R.id.btn_alpha);

        btn_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, ImageTranslucentBarActivity.class);
                MainActivity.this.startActivity(it);
            }
        });
        btn_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, ColorTranslucentBarActivity.class);
                MainActivity.this.startActivity(it);
            }
        });
        btn_draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Main2Activity.class);
                MainActivity.this.startActivity(it);
            }
        });
        btn_alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Main3Activity.class);
                MainActivity.this.startActivity(it);
            }
        });
    }
}
