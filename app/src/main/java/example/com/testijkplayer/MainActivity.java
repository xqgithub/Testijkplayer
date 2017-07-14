package example.com.testijkplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import example.com.testijkplayer.common.PlayerManager;
import example.com.testijkplayer.widget.media.IjkVideoView;

public class MainActivity extends AppCompatActivity implements PlayerManager.PlayerStateListener {

    private IjkVideoView videoView;

    private PlayerManager player;
    private String url1 = "http://gslb.miaopai.com/stream/IHqmO5vPfRT3ET4OCyXVTy2jzk~W--eM.mp4?ssig=0771298073b2bbe75357504671d25143&time_stamp=1500020088416&cookie_id=5966f65ec5b5a&vend=1&os=3&partner=1&platform=2&cookie_id=&refer=miaopai&scid=IHqmO5vPfRT3ET4OCyXVTy2jzk%7EW--eM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = (IjkVideoView) findViewById(R.id.video_view);
//        videoView.setAspectRatio(IRenderView.AR_ASPECT_FIT_PARENT);
//        videoView.setVideoURI(Uri.parse("http://gslb.miaopai.com/stream/IHqmO5vPfRT3ET4OCyXVTy2jzk~W--eM.mp4?ssig=0771298073b2bbe75357504671d25143&time_stamp=1500020088416&cookie_id=5966f65ec5b5a&vend=1&os=3&partner=1&platform=2&cookie_id=&refer=miaopai&scid=IHqmO5vPfRT3ET4OCyXVTy2jzk%7EW--eM"));
//        videoView.start();
        initPlayer();

    }

    private void initPlayer() {
        player = new PlayerManager(this);
        player.setFullScreenOnly(true);
        player.setScaleType(PlayerManager.SCALETYPE_FILLPARENT);
        player.playInFullScreen(true);
        player.setPlayerStateListener(this);
        player.play(url1);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (player.gestureDetector.onTouchEvent(event))
            return true;
        return super.onTouchEvent(event);
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onPlay() {

    }
}
