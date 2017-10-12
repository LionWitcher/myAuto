package com.example.lionwitcher.autorepair;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final String LOG_TAG = this.getClass().getSimpleName();

    Button buttonSave;
    TextView resultSave;
    EditText brand, model, VIN, odometr, purchaseDate, year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        buttonSave = (Button) findViewById(R.id.save);
        resultSave = (TextView) findViewById(R.id.saveResult);

        View.OnClickListener ButtonSave = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Car car = new Car();
                String tempStr;
                int tempInt;

                brand = (EditText) findViewById(R.id.brand);
                tempStr = brand.getText().toString().trim();
                car.setBrand(tempStr);

                model = (EditText) findViewById(R.id.model);
                tempStr = model.getText().toString().trim();
                car.setModel(tempStr);

                VIN = (EditText) findViewById(R.id.VIN);
                car.parseVIN(VIN);

                odometr = (EditText) findViewById(R.id.odometr);
                car.parseOdometr(odometr);


                Log.e(LOG_TAG, "Add car: " + car.toString());
                resultSave.setText("Сохранено...");

            }
        };

        buttonSave.setOnClickListener(ButtonSave);


    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
