package com.example.kevca.elementosgraficos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        TextView text01=(TextView) findViewById(R.id.text01);
        switch(view.getId()) {
            case R.id.radio01:
                if (checked)
                    text01.setText("Radio 1");
                    break;
            case R.id.radio02:
                if (checked)
                    text01.setText("Radio 2");
                    break;
        }
    }

    public void onCheckboxClicked(View view) {
        TextView text02=(TextView) findViewById(R.id.text02);
        CheckBox check01=(CheckBox) findViewById(R.id.checkbox01);
        CheckBox check02=(CheckBox) findViewById(R.id.checkbox02);
        int a=0;
        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.checkbox01:
                if (checked){
                    text02.setText("Check 1");
                }
                else{
                    text02.setText("UNCheck 1");
                }
                break;
            case R.id.checkbox02:
                if (checked){
                    text02.setText("Check 2");
                }
                else{
                    text02.setText("UNCheck 2");
                }
                break;
        }
    }
}
