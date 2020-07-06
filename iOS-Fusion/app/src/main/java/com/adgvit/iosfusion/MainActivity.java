package com.adgvit.iosfusion;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    String pol = "https://akshit8.github.io/privacy-policy.github.io/";
    String pavit = "https://play.google.com/store/apps/details?id=com.namankhurpia.paper";
    String tapvit = "https://play.google.com/store/apps/details?id=patel.abhay.adg_tap_app";

    public void policy(View view)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData((Uri.parse(pol)));
        startActivity(intent);
    }
    public void papvit(View view)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData((Uri.parse(pavit)));
        startActivity(intent);
    }
    public void tapvit(View view)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData((Uri.parse(tapvit)));
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);

    }

    @Override
    public void onBackPressed()
    {
        moveTaskToBack(true);
    }
}
