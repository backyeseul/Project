package com.example.so.project;

import android.os.CountDownTimer;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Handler;
import android.os.Message;

public class HintCountDownTimer extends CountDownTimer {
    private GamePlay gamePlay;
    private AlertDialog ad;
    private long mTimeLeftInMillis = 5000;

    public HintCountDownTimer (GamePlay gamePlay, AlertDialog ad, long a, int b) {
        super(a, b);
        this.gamePlay = gamePlay;
        this.ad = ad;
    }

    public void onTick(long millisUntilFinished) {
        mTimeLeftInMillis = millisUntilFinished;
    }

    @Override
    public void onFinish() {
        ad.dismiss();
        //isHintDialogOpen = false;
        Message sendmsg =  gamePlay.getHandler().obtainMessage();/////////////////////////////////////////////////
        sendmsg.what = GamePlay.HINT_TIME_OVER;                                                     //상수는 class 이름으로 일반적으로 한다
        gamePlay.getHandler().sendMessage(sendmsg);
    }
}
