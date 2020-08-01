package com.example.fograinbow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.Display;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.fograinbow.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //下面二段代码给页面顶部加了一段.
        NavController controller = Navigation.findNavController(this,R.id.fragment4);
        NavigationUI.setupActionBarWithNavController(this,controller);

    }

    @Override
    public boolean onSupportNavigateUp() {
        //return super.onSupportNavigateUp();
        NavController controller = Navigation.findNavController(this,R.id.fragment4);
        return  controller.navigateUp();
    }

    /**Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText  editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }

}
