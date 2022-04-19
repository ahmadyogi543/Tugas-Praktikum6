package com.joyapps.tugaspraktikum6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        this.handleSaveSettingsButton();
    }


    private void handleSaveSettingsButton() {
        SharedPreferences sharedPreferences = getSharedPreferences("app-data", MODE_PRIVATE);
        Spinner bgColorSpinner = findViewById(R.id.bg_col_spinner);
        Spinner textSizeSpinner = findViewById(R.id.text_size_spinner);

        Button saveBtn = findViewById(R.id.save_settings_btn);
        saveBtn.setOnClickListener(view -> {
            @SuppressLint("CommitPrefEdits")
            SharedPreferences.Editor editor = sharedPreferences.edit();

            int selectedBgColor;
            switch (bgColorSpinner.getSelectedItem().toString()) {
                case "Merah":
                    selectedBgColor = R.color.red;
                    break;
                case "Hijau":
                    selectedBgColor = R.color.green;
                    break;
                case "Kuning":
                    selectedBgColor = R.color.yellow;
                    break;
                case "Biru":
                    selectedBgColor = R.color.blue;
                    break;
                default:
                    selectedBgColor = R.color.grey;
            }

            float selectedTextSize;
            switch (textSizeSpinner.getSelectedItem().toString()) {
                case "Sedang":
                    selectedTextSize = 16;
                    break;
                case "Besar":
                    selectedTextSize = 18;
                    break;
                default:
                    selectedTextSize = 14;
            }

            editor.putInt("bgColor", selectedBgColor);
            editor.putFloat("textSize", selectedTextSize);
            editor.apply();

            Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
