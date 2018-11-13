package com.cooper.gomanezan.Activty;

import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.cooper.gomanezan.R;
import com.cooper.gomanezan.fragment.BookbankFragment;
import com.cooper.gomanezan.fragment.DashbordFragment;
import com.cooper.gomanezan.fragment.MybooksFragment;



public class MainActivity extends BaseActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.booksBank:
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_activity__load_frame, new BookbankFragment(), "tobooksbank").addToBackStack("BankBook").commit();
                    return true;
                case R.id.navigation_dashboard:
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_activity__load_frame, new MybooksFragment(), "tomybooks").addToBackStack("mybooks").commit();
                    return true;
                case R.id.navigation_notifications:
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_activity__load_frame, new DashbordFragment(), "todashboard").addToBackStack("dashbord").commit();
                    return true;
            }
            return false;
        }
    };


    @Override
    public void setupElements() {
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_activity__load_frame, new MybooksFragment(), "tomybooks").addToBackStack("mybooks").commit();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void setupToolbar() {

    }

    @Override
    public void loadStaticData() {

    }

    @Override
    public void loadDynamicData(boolean auto_load_data) {

    }

    @Override
    public void setupElementsWithData(boolean auto_load_data) {

    }

    @Override
    public void setupOnClick() {

    }

    @Override
    public void setupListener() {

    }

}
