package com.example.vgtu_final;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.internal.NavigationMenu;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vgtu_final.LecturesContract.LecturesEntry;

public class LoginActivity extends AppCompatActivity {
    String password;
    String login;

    EditText Password;
    EditText Login;
    Button SubmitButton;
    DBManager manager;
    LecturesDBHelper helper;
    SQLiteDatabase db;
    DisplayLectures display;
    Context context;

    boolean GO_TO_APP = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        manager = new DBManager(this);
        helper = new LecturesDBHelper(this);


        db = helper.getReadableDatabase();

        Password = (EditText) findViewById(R.id.Password);
        Login = (EditText) findViewById(R.id.Login);

        final String query = "select " + LecturesEntry.COLUMN_LOGIN_NAME +
                " , " + LecturesEntry.COLUMN_LOGIN_SURNAME +
                " , " + LecturesEntry.COLUMN_LOGIN_MAIL +
                " ," + LecturesEntry.COLUMN_LOGIN_STATUS +
                " FROM " + LecturesEntry.TABLE_LOGIN_LIST +
                " WHERE EXISTS ( select * FROM " + LecturesEntry.TABLE_LOGIN_LIST +
                "WHERE " + LecturesEntry.TABLE_LOGIN_LIST+"."+LecturesEntry.COLUMN_LOGIN_IDCODE+"=" + login  +
                " and " + LecturesEntry.TABLE_LOGIN_LIST+"."+LecturesEntry.COLUMN_LOGIN_PASS+"="+password+" );";


        context = this;

        SubmitButton = (Button) findViewById(R.id.SubmitButton);
        SubmitButton.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View v){
                                                login = Login.getText().toString();
                                                password = Password.getText().toString();
                                                String[] getData = checkPass(login,password);
                                                Log.i("Button","passs " + getData[0]);
                                                if(getData[0] != null){

                                                    context.startActivity(new Intent(context,MainActivity.class));


                                                }

                                            }
                                        }
        );
    }

    public String[] checkPass(String idEnter, String passEnter){

         String[] arry = {LecturesEntry.COLUMN_LOGIN_IDCODE, LecturesEntry.COLUMN_LOGIN_PASS, LecturesEntry.COLUMN_LOGIN_NAME,
                 LecturesEntry.COLUMN_LOGIN_SURNAME,
                 LecturesEntry.COLUMN_LOGIN_MAIL,
                 LecturesEntry.COLUMN_LOGIN_STATUS};
        Cursor cursor = db.query(LecturesEntry.TABLE_LOGIN_LIST,
                arry,
                null,
                null,
                null,
                null,
                null,
                null);

        String[] ans;

        String name = null;
        String surname = null;
        String mail = null;
        String status = null;

        while (cursor.moveToNext()) {
            String idcode =  cursor.getString(cursor.getColumnIndex(arry[0]));
            String pass = cursor.getString(cursor.getColumnIndex(arry[1]));
            //Log.i("Button","Compare " + idcode + " and " + idEnter + "pass:" + pass + " " + passEnter);
            if(idcode.trim().equals(idEnter.trim())  && pass.trim().equals(passEnter.trim())  ){
                Log.i("Button","Compare " + idcode + " and " + idEnter + "pass:" + pass + " " + passEnter);
                 name = cursor.getString(cursor.getColumnIndex(arry[2]));
                 surname = cursor.getString(cursor.getColumnIndex(arry[3]));
                 mail = cursor.getString(cursor.getColumnIndex(arry[4]));
                 status = cursor.getString(cursor.getColumnIndex(arry[5]));
                break;
            }

           continue;
            }



        Log.i("Button","nasss " + name);

        ans = new String[]{name, surname, mail, status};



        return ans;
    }


    }

