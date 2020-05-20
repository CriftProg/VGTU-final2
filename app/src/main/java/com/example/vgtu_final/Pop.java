package com.example.vgtu_final;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vgtu_final.LecturesContract.LecturesEntry;

public class Pop extends AppCompatActivity {
    String[] columns_sub = {LecturesEntry.COLUMN_SUBJECT_NAME,LecturesEntry.COLUMN_SUBJECT_TEACHER, LecturesEntry.COLUMN_SUBJECT_DATE, LecturesEntry.COLUMN_SUBJECT_GROUP};
    int [] pop_array = {R.id.button_popOutLecture1_1,R.id.button_popOutLecture2_1,R.id.button_popOutLecture3_1, R.id.button_popOutLecture4_1, R.id.button_popOutLecture5_1, R.id.button_popOutLecture6_1};

    DisplayLectures displayLectures;
    LecturesDBHelper helperDb;
    SQLiteDatabase db;
    Context context;
    StringBuffer buffer;

    LecturesFragment lec_today;
    TomorrowFragment lec_tommorow;

    CallBack callBack = new CallBack();




    public String caller = callBack.getCaller();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popwindow);

        context = this;

        getIntent();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int heigth = dm.heightPixels;

        getWindow().setLayout((int)(width*.8), (int)(heigth*.8));

        TextView subject = findViewById(R.id.pop_name);
        TextView teacher = findViewById(R.id.pop_teacher_info);
        TextView date = findViewById(R.id.pop_date_info);
        TextView group = findViewById(R.id.pop_group_info);

        final EditText editContent = findViewById(R.id.editText_content);
        final EditText editDate = findViewById(R.id.editText_date);

        Button addhome = findViewById(R.id.button_hw);
        Button addtest = findViewById(R.id.button_test);

        helperDb = new LecturesDBHelper(context);
        db = helperDb.getReadableDatabase();

        displayLectures = new DisplayLectures(context, db);
        String[][] array = new String[100][15];
        array = displayLectures.getPopData(LecturesEntry.TABLE_SUBJECT_LIST,columns_sub);

        caller = displayLectures.getCaller(LecturesEntry.TABLE_CALLER,new String[]{LecturesEntry.COLUMN_CALLER_CONTENT});


        for(int i = 0; i < displayLectures.pop_count ; i++){
            Log.i("Button", "POOOPS " + caller + "arr" + array[i][0]);
            if(caller.equals(array[i][0])){
                subject.setText(array[i][0]);
                teacher.setText(array[i][1]);
                date.setText(array[i][2]);
                group.setText(array[i][3]);
            }


        }

        helperDb.dropCall(db);

        addhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] array = {caller,editContent.getText().toString(),editDate.getText().toString()};
                DBManager dbManager = new DBManager(context);
                dbManager.fillDB_homwork(array,LecturesEntry.TABLE_SUBJECT_HOMEWORK);
                Toast.makeText(context,"Homework added", Toast.LENGTH_SHORT);
            }
        });

        addtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] array = {caller,editContent.getText().toString(),editDate.getText().toString()};
                DBManager dbManager = new DBManager(context);
                dbManager.fillDB_homwork(array,LecturesEntry.TABLE_SUBJECT_TEST);
                Toast.makeText(context,"Test added", Toast.LENGTH_SHORT);
            }
        });



    }

    public void ReadBuffer(StringBuffer buffer){
        caller = buffer.toString();
        Log.i("Butten", "Buffer transfer " + caller);
    }

    public void openPop(View rootView, final Context context1 , int button, int lecture){

        final TextView name = rootView.findViewById(lecture);

        ImageButton b = rootView.findViewById(button);




        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String caller = (String) name.getText();

                DBManager dbManager = new DBManager(context1);
                dbManager.fillDB_caller(caller,LecturesEntry.TABLE_CALLER);

                Log.i("Button","caller  "+  caller);

                context1.startActivity(new Intent(context1,Pop.class));



            }
        });
    }
}


