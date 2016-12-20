package com.example.ashwin.loginfragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button mShowLoginDialogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListeners();
    }

    private void initViews()
    {
        mShowLoginDialogButton = (Button) findViewById(R.id.showLoginDialogButton);
    }

    private void initListeners()
    {
        mShowLoginDialogButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        int id = view.getId();
        switch(id)
        {
            case R.id.showLoginDialogButton:
                new LoginFragment().show(getSupportFragmentManager(), "LoginDialog");
                break;
        }
    }
}
