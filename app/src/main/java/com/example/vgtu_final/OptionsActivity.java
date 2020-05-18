package com.example.vgtu_final;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;



public class OptionsActivity extends AppCompatActivity  {


    private android.widget.RadioGroup RadioGroup, RG2;
    private RadioButton radioEN, radioLT, vib, sound, nosound;
    private Vibrator vibrator;
    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options);

        RadioGroup = (android.widget.RadioGroup) findViewById(R.id.RadioGroup);
        vibrator= (Vibrator) getSystemService(VIBRATOR_SERVICE);

        RadioGroup.setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.RadioGroup group, int checkedId) {
                if(checkedId==R.id.radioEN){
                    Toast.makeText(getApplicationContext(), "choice:English",
                            Toast.LENGTH_SHORT).show();
                }else if (checkedId==R.id.radioLT){
                    Toast.makeText(getApplicationContext(), "choice:Lithuanian",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        RG2 = (android.widget.RadioGroup) findViewById(R.id.RG2);
        final MediaPlayer mp= MediaPlayer.create(this, R.raw.awareness);
        RG2.setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener(){
                                           @Override
                                           public void onCheckedChanged(android.widget.RadioGroup group, int checkedId){
                                               if(checkedId==R.id.vib){
                                                   //function for notifications
                                                   vibrator.vibrate(50);
                                               }
                                               if (checkedId==R.id.sound){
                                                   //sound
                                                   mp.start();
                                               }
                                           }
                                       }

        );
    }

    public void button1 (View view){
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.vgtu.lt/informaciniu-technologiju-ir-sistemu-centras/it-paslaugos-vgtu-bendruomenei/kompiuteriu-prieziura/103998"));
        startActivity(browserIntent);
    }


}
