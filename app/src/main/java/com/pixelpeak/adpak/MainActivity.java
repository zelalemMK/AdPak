package com.pixelpeak.adpak;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        VideoView initialVideo = (VideoView) findViewById(R.id.initialVideo);
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.initial_video);
        initialVideo.setVideoURI(videoUri);
        initialVideo.start();
        initialVideo.setOnCompletionListener(mediaPlayer -> {
            initialVideo.start();
        });

        initialVideo.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }
}