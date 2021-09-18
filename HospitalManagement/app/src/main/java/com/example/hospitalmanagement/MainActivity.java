package com.example.hospitalmanagement;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.microsoft.identity.common.internal.util.StringUtil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.textclassifier.TextLanguage;
import android.view.textclassifier.TextSelection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //Toolbar toolbar = findViewById(R.id.toolbar);
        EditText userName = findViewById(R.id.userName);
        EditText password = findViewById(R.id.password);
        Button signIn = findViewById(R.id.signIn);
        Button signUp = findViewById(R.id.signUp);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openNewActivity();
            }
        });
        signIn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                callAPIAndValidate(userName,password);
            }
        });

    }

    private void callAPIAndValidate(EditText userName, EditText password) {

        if(StringUtils.isBlank(String.valueOf(userName.getText())) || StringUtils.isBlank(String.valueOf(password.getText()))) {
            Log.i("Data------- Error",String.valueOf(userName.getText()));
            TextView t = findViewById(R.id.errorMessage);
            t.setVisibility(1);
            t.setText("UserName/Password can't be empty");
            
//            returnLoginActivity();
        } else{
            Log.i("no--- Data------- Error","no error");
        }
    }

    private void returnLoginActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private void openNewActivity() {

        Intent intent = new Intent(this,DoctorsActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}