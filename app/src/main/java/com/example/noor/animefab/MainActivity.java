package com.example.noor.animefab;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fabLift, fabFly, fabFan, fabAdd;
    Animation fadeIn, fadeOut, rotateOpen, rotateClose;
    boolean isOpen;
    ImageView ivMinionWithBalloons, ivMinionOnRocket, ivSupperMinion;
    Animation launch, fly, land,revLaunch, revFly, revLand;
    boolean isLaunched,isLanded,isFlied;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isOpen = false;

        fabAdd = findViewById(R.id.fabAdd);
        fabFan = findViewById(R.id.fabFan);
        fabFly = findViewById(R.id.fabFly);
        fabLift = findViewById(R.id.fabLift);

        ivMinionWithBalloons = findViewById(R.id.ivMinionWithBalloons);
        ivMinionOnRocket = findViewById(R.id.ivMinionOnRocket);
        ivSupperMinion = findViewById(R.id.ivSupperMinion);

        fadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        fadeOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
        rotateOpen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_open);
        rotateClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_close);

        isLanded=false;
        isLanded=false;
        isFlied=false;

        revLand=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rev_land);
        revFly=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rev_fly);
        revLaunch=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rev_launch);

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen) {
                    fabAdd.startAnimation(rotateClose);
                    fabFan.startAnimation(fadeOut);
                    fabFly.startAnimation(fadeOut);
                    fabLift.startAnimation(fadeOut);

                    fabFan.setClickable(false);
                    fabFly.setClickable(false);
                    fabLift.setClickable(false);

                    fabFan.setVisibility(View.INVISIBLE);
                    fabFly.setVisibility(View.INVISIBLE);
                    fabLift.setVisibility(View.INVISIBLE);

                    if (isLanded) {
                        ivMinionWithBalloons.startAnimation(revLand);
                        isLanded=false;
                    }
                    if (isFlied){
                        ivSupperMinion.startAnimation(revFly);
                        isFlied=false;
                    }
                    if (isLaunched) {
                        ivMinionOnRocket.startAnimation(revLaunch);
                        isLaunched=false;
                    }

                    isOpen = false;
                } else {
                    fabAdd.startAnimation(rotateOpen);
                    fabFan.startAnimation(fadeIn);
                    fabFly.startAnimation(fadeIn);
                    fabLift.startAnimation(fadeIn);

                    fabFan.setClickable(true);
                    fabFly.setClickable(true);
                    fabLift.setClickable(true);

                    fabFan.setVisibility(View.VISIBLE);
                    fabFly.setVisibility(View.VISIBLE);
                    fabLift.setVisibility(View.VISIBLE);

                    isOpen = true;
                }
            }
        });
        fabLift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLaunched) {
                    launch = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.launch);
                    ivMinionOnRocket.startAnimation(launch);
                }
                isLaunched=true;
            }
        });
        fabFly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFlied) {
                    fly = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fly);
                    ivSupperMinion.startAnimation(fly);
                }
                isFlied=true;
            }
        });
        fabFan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLanded) {
                    land = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.land);
                    ivMinionWithBalloons.startAnimation(land);
                }
                isLanded=true;
            }
        });

    }
}
