package com.example.vgtu_final;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;;
public class OptionsFragment extends Fragment {

    private android.widget.RadioGroup RadioGroup, RG2;
    private RadioButton radioEN, radioLT, vib, sound, nosound;
    private Vibrator vibrator;
    private Context context;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        View rootView = inflater.inflate(R.layout.options, container, false);
        RadioGroup = (android.widget.RadioGroup) rootView.findViewById(R.id.RadioGroup);
        vibrator= (Vibrator) context.getSystemService(context.VIBRATOR_SERVICE);

        RadioGroup.setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.RadioGroup group, int checkedId) {
                if(checkedId==R.id.radioEN){
                    Toast.makeText(context.getApplicationContext(), "choice:English",
                            Toast.LENGTH_SHORT).show();
                }else if (checkedId==R.id.radioLT){
                    Toast.makeText(context.getApplicationContext(), "choice:Lithuanian",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        RG2 = (android.widget.RadioGroup) rootView.findViewById(R.id.RG2);
        final MediaPlayer mp= MediaPlayer.create(context,R.raw.awareness);
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


         return rootView;
    }





}
