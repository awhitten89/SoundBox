package catdogapp.alan.com.soundbox;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button playButton;
    private Button prevButton;
    private Button nextButton;
    private MediaPlayer mediaPlayer;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.game_field);

        text = (TextView) findViewById(R.id.artist_name);

        playButton = (Button)findViewById(R.id.play_Button);
        prevButton = (Button)findViewById(R.id.prev_Button);
        nextButton = (Button)findViewById(R.id.next_Button);

        playButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.play_Button:
                if(mediaPlayer.isPlaying()){
                    pauseMusic();
                } else {
                    playMusic();
                }
                break;
            case R.id.prev_Button:
                //do something
                break;
            case R.id.next_Button:
                //do something
                break;
        }

    }

    public void playMusic(){

        if(mediaPlayer != null){
            mediaPlayer.start();
            text.setText("Music playing now.....");
            playButton.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.ic_media_pause));
        }
    }

    public void pauseMusic(){

        if(mediaPlayer != null){
            mediaPlayer.start();
            text.setText("Music Paused!");
            playButton.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.ic_media_play));
        }
    }

    public void prevMusic(){

        if(mediaPlayer != null){
            //do something
        }
    }

    public void nextMusic(){

        if(mediaPlayer != null){
            //do something
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
