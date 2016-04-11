package com.shrestha.barsha.bmicalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button_calculate = (Button) findViewById(R.id.button_calculate);
        final EditText weight_field = (EditText) findViewById(R.id.weight_field);
        final EditText height_ft_field = (EditText) findViewById(R.id.height_ft_field);
        final EditText height_inch_field = (EditText) findViewById(R.id.height_inch_field);
        final TextView bmi_field = (TextView) findViewById(R.id.bmi_field);
        final TextView message_field = (TextView) findViewById(R.id.message_field);

        button_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double weight;
                double height_ft;
                double height_inch;
                double height;
                double bmi;
                String message = "";

                weight = Double.parseDouble(weight_field.getText().toString()) * 0.45;
                height_ft = Double.parseDouble(height_ft_field.getText().toString())* 12 * 0.025;
                height_inch = Double.parseDouble(height_inch_field.getText().toString()) * 0.025;
                height = Math.pow((height_ft + height_inch ), 2);
                bmi = Math.round(weight / height);
                bmi_field.setText(String.valueOf(bmi));

                if (bmi < 18.5) {
                    message = "Underweight :(";
                }
                else if (bmi >18.5 && bmi < 24.9){
                    message = "Normal Weight :)";
                }
                else if (bmi > 25 && bmi < 29.9){
                    message = "Overweight :(";
                }

                else if (bmi > 30) {
                    message = "Obese :/" ;
                }

                message_field.setText(message);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
