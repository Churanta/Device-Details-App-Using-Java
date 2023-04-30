package com.example.javalocationapp;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView deviceDetailsTextView;
    private Button refreshButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        deviceDetailsTextView = findViewById(R.id.deviceDetailsTextView);
        refreshButton = findViewById(R.id.refreshButton);

        refreshButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                updateDeviceDetails();
            }
        });

        updateDeviceDetails();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void updateDeviceDetails() {
        String deviceDetails = "Device Details: \n\n" +
                "Manufacturer: " + Build.MANUFACTURER + "\n" +
                "Model: " + Build.MODEL + "\n" +
                "Product: " + Build.PRODUCT + "\n" +
                "Hardware: " + Build.HARDWARE + "\n" +
                "Serial: " + Build.SERIAL + "\n" +
                "Android Version: " + Build.VERSION.RELEASE + "\n" +
                "API Level: " + Build.VERSION.SDK_INT + "\n" +
                "Build ID: " + Build.ID + "\n" +
                "Kernel Version: " + System.getProperty("os.version") + "\n";

        deviceDetailsTextView.setText(deviceDetails);
    }
}
