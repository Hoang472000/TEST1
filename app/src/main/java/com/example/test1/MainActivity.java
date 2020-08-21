package com.example.test1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String SHOW_COUNT="textView";
    private static final String EDIT_TEXT="Edit_text";
    private int mcount;
    private TextView mShowCount;
    private View mButton;
    private TextView mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount=findViewById(R.id.textView);
        mButton=findViewById(R.id.button);
        mEditText=findViewById(R.id.editTextTextPersonName);
        if (savedInstanceState!=null){
            mShowCount.setText(savedInstanceState.getString(SHOW_COUNT).toString());
            mEditText.setText(savedInstanceState.getString(EDIT_TEXT).toString());
            mcount=savedInstanceState.getInt("conut");
        }

    }

    public void onclick(View view) {
        ++(mcount);
        if(mShowCount!=null)
            mShowCount.setText(Integer.toString(mcount));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mShowCount.getVisibility()==View.VISIBLE){
            outState.putBoolean("app_name",true);
            outState.putString(SHOW_COUNT,mShowCount.getText().toString());
            outState.putString(EDIT_TEXT, mEditText.getText().toString());
            outState.putInt("count",mcount);
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mcount=savedInstanceState.getInt("count");
    }
}

