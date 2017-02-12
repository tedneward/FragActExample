package edu.uw.ischool.activityandfragmentexample;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private boolean firstFragmentOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnActivity = (Button)findViewById(R.id.btnActivity);
        btnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        Button btnFragment = (Button)findViewById(R.id.btnFragment);
        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotateFragment();
            }
        });

        DwarfApplication app = (DwarfApplication)this.getApplication();
        final int numberOfDwarves = app.getRepository().getAllDwarves().size();
        Button btnToast = (Button)findViewById(R.id.btnToast);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "There are " + numberOfDwarves + " dwarves",
                        Toast.LENGTH_SHORT).show();
            }
        });

        rotateFragment();
    }

    private void rotateFragment() {
        Fragment frag = null;

        if (firstFragmentOn) {
            firstFragmentOn = false;
            frag = new FirstFragment();
        }
        else {
            firstFragmentOn = true;
            frag = SecondFragment.newInstance("param1", "param2");
        }

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentPlaceholder, frag);
        fragmentTransaction.commit();
    }
}
