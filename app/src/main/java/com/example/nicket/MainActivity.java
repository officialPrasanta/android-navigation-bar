package com.example.nicket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.transition.MaterialContainerTransform;

public class MainActivity extends AppCompatActivity {

   NavigationBarView bottomNavigationView;
   private boolean isStateChanged = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(
                        R.anim.slide_in,
                        R.anim.fade_out
                )
                .replace(R.id.container, new FragmentHome())
                .commit();
        bottomNavigationView.setSelectedItemId(R.id.tab1);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch(item.getItemId()) {
                    case R.id.tab1:

                        if(FragmentHome.active == false){
                            fragment = new FragmentHome();
                            isStateChanged = true;
                        }
                        else {
                            isStateChanged = false;
                        }
                        break;
                    case R.id.tab2:
                        if(FragmentTrending.active == false){
                            fragment = new FragmentTrending();
                            isStateChanged = true;
                        }
                        else {
                            isStateChanged = false;
                        }
                        break;
                    case R.id.tab3:
                        if(FragmentVideo.active == false){
                            fragment = new FragmentVideo();
                            isStateChanged = true;
                        }
                        else {
                            isStateChanged = false;
                        }
                        break;
                    case R.id.tab4:
                        if(FragmentAudio.active == false){
                            fragment = new FragmentAudio();
                            isStateChanged = true;
                        }
                        else {
                            isStateChanged = false;
                        }
                        break;
                    case R.id.tab5:
                        if(FragmentAccount.active == false){
                            fragment = new FragmentAccount();
                            isStateChanged = true;
                        }
                        else {
                            isStateChanged = false;
                        }
                        break;
                }

                if(isStateChanged){
                    getSupportFragmentManager()
                            .beginTransaction()
                            .setCustomAnimations(
                                    R.anim.slide_in,
                                    R.anim.fade_out
                            )
                            .replace(R.id.container, fragment)
                            .commit();
                }
                return true;
            }
        });
    }


}