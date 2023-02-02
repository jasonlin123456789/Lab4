package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        loadProfile();
    }

    @Override
    protected void onDestroy() {
        saveProfiles();
        super.onDestroy();
    }

    public void loadProfile(){
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        String name = preferences.getString("name", "Name");
        String status = preferences.getString("status", "Status");

        TextView nameTextView = findViewById(R.id.name_textview);
        TextView statusTextView = findViewById(R.id.status_textview);

        nameTextView.setText(name);
        statusTextView.setText(status);

    }
    public void saveProfiles() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        TextView nameTextView = findViewById(R.id.name_textview);
        TextView statusTextView = findViewById(R.id.status_textview);

        editor.putString("name", nameTextView.getText().toString());
        editor.putString("status", statusTextView.getText().toString());
        editor.apply();
    }
    public void OnGoBackClicked(View view) {
        finish();
    }
}