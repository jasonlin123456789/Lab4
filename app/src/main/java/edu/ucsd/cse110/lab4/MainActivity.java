package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Optional;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLaunchProfileClicked(View view) {
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);

    }

    public void onShowCounterClicked(View view) {
        Intent intent = new Intent(this, CounterActivity.class);

        TextView maxcountView = findViewById(R.id.max_count_view);
        String maxCountStr = maxcountView.getText().toString();

        Optional<Integer> maybeMaxCount = Utilities.parseCount(maxCountStr);

        if (!maybeMaxCount.isPresent()) {
            Utilities.showAlert(this, "This isn't a number");
            return;
        }

        int maxCount = maybeMaxCount.get();

        if (maxCount <= 0) {
            Utilities.showAlert(this, "Please enter a positive number");
            return;
        }

        intent.putExtra("maxCount", maxCount);
        startActivity(intent);
    }
}