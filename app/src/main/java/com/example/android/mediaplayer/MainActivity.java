package com.example.android.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.hello);
        Button playBtn = (Button)findViewById(R.id.play);
        Button puseBtn = (Button)findViewById(R.id.pause);

        playBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
                    public void onCompletion(MediaPlayer mediaPlayer){
                        releaseMediaPlayer();
                        Toast.makeText(MainActivity.this,"Imdone",Toast.LENGTH_SHORT).show();
                    }
                });
                Toast.makeText(MainActivity.this,"Play",Toast.LENGTH_SHORT).show();
            }
        });

        puseBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                mediaPlayer.pause();
                Toast.makeText(MainActivity.this,"Pausey",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void releaseMediaPlayer()
    {
        if(mediaPlayer != null)
        {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
    protected void onStop()
    {
        super.onStop();
        releaseMediaPlayer();
    }
}
