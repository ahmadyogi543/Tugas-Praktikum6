package com.joyapps.tugaspraktikum6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.handlePreferences();
        this.handleSettingsButton();
    }

    private  void handlePreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences("app-data", MODE_PRIVATE);
        RelativeLayout mainLayout = findViewById(R.id.main_activity_layout);
        TextView textView = findViewById(R.id.text_view);

        int selectedBgColor = getResources().getColor(sharedPreferences.getInt("bgColor", R.color.grey));
        float selectedTextSize = sharedPreferences.getFloat("textSize", 14);

        mainLayout.setBackgroundColor(selectedBgColor);
        textView.setTextSize(selectedTextSize);
    }

    private void handleSettingsButton() {
        Button settingsBtn = findViewById(R.id.settings_btn);

        settingsBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        });
    }
}
