package com.example.fragmentcomment;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements CommentFragment.OnFragmentInteractionListener{

    private Button mButton;
    private boolean isFragmentDisplayed = false;

    private String comment = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.open_button);
    }

    public void openClick(View view){
        if (!isFragmentDisplayed){
            displayFragment();
        }else{
            closeFragment();
        }
    }

    public void displayFragment(){
        CommentFragment commentFragment = CommentFragment.newInstance(comment);
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, commentFragment).addToBackStack(null).commit();


        mButton.setText(R.string.close);
        isFragmentDisplayed = true;
    }

    public  void closeFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        CommentFragment commentFragment = (CommentFragment) fragmentManager.findFragmentById(R.id.fragment_container);


        if (commentFragment != null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(commentFragment).commit();
        }

        mButton.setText(R.string.open);
        isFragmentDisplayed = false;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onInputComment(String comment) {
        this.comment = comment;
    }
}
