package com.example.ashwin.loginfragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ashwin on 20/12/16.
 */

public class LoginFragment extends DialogFragment implements View.OnClickListener
{
    private EditText mUsernameEditText, mPasswordEditText;
    private Button mLoginButton;
    private Dialog mDialog;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        //Dialog mDialog = super.onCreateDialog(savedInstanceState);
        mDialog = new Dialog(getActivity(), R.style.DialogFragment);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(mDialog.getWindow().getAttributes());
        //layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        //layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.gravity = Gravity.BOTTOM;
        layoutParams.windowAnimations = R.style.SlideUpDownDialog;

        final View view = View.inflate(getActivity(), R.layout.login_fragment, null);
        mDialog.getWindow().setAttributes(layoutParams);
        mDialog.setContentView(view);

        return mDialog;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.login_fragment, container, false);

        mDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);
        initListeners();
    }

    private void initViews(View view)
    {
        mUsernameEditText = (EditText) view.findViewById(R.id.usernameEditText);
        mPasswordEditText = (EditText) view.findViewById(R.id.passwordEditText);
        mLoginButton = (Button) view.findViewById(R.id.loginButton);
    }

    private void initListeners()
    {
        mLoginButton.setOnClickListener(this);
    }

    private void onLoginButtonClicked()
    {
        String username = mUsernameEditText.getText().toString();
        String password = mPasswordEditText.getText().toString();
        if(!username.equals("") && !password.equals(""))
        {
            mDialog.dismiss();
            Toast.makeText(getActivity(), "Thank you " + username + " for logging in", Toast.LENGTH_LONG).show();
            // Login successful
        }
        else
        {
            Toast.makeText(getActivity(), "Please fill all fields", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View view)
    {
        int id = view.getId();
        switch(id)
        {
            case R.id.loginButton:
                onLoginButtonClicked();
                break;
            default:
                // Do nothing
                break;
        }
    }
}
