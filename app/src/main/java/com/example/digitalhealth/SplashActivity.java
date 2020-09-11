package com.example.digitalhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public
class SplashActivity extends AppCompatActivity {

   ImageView mdoc2;
    ImageView mdoc;
    Animation frombottom;
    Animation fromtop;
    ImageView mgetStarted;

    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

       mdoc2 = findViewById(R.id.img_doc2);
        mdoc =findViewById(R.id.img_doc);
        mgetStarted = findViewById(R.id.img_getStarted);

        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);
        mdoc2.setAnimation(frombottom);
        fromtop = AnimationUtils.loadAnimation(this, R.anim.fromtop);
        mdoc.setAnimation(fromtop);

        mgetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public
            void onClick(View view) {

                Intent projectIntent = new Intent(SplashActivity.this,ProjectActivity.class);
                startActivity(projectIntent);
            }
        });

    }
}