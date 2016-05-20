package org.swchalu.translucentsystembarexample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    private EditText et_content;
    private TextView tv_counter;
    private int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        et_content = (EditText) findViewById(R.id.et_content);
        tv_counter = (TextView) findViewById(R.id.tv_textsum);
        color = tv_counter.getCurrentTextColor();
        tv_counter.setText(String.valueOf(0));

        et_content.addTextChangedListener(new TextWatcher() {
            private CharSequence content = "";
            private int length_content = 0;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                content = et_content.getText();
                length_content = content.length();
                tv_counter.setText(String.valueOf(length_content));
                if (length_content > Constants.LENGTH_CONTENT)
                    tv_counter.setTextColor(Color.RED);
                else
                    tv_counter.setTextColor(color);
            }
        });
    }

}
