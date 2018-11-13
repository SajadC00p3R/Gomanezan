package com.cooper.gomanezan.Activty;


import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {


    public boolean auto_load_data = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Auto_refresh();
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshData();
    }

    public void Auto_refresh(){
        setupElements();
        setupToolbar();
        loadData();
        setupElementsWithData(auto_load_data);
        setupOnClick();
        setupListener();
        auto_load_data = true;
    }

    public void refreshData(){
        loadDynamicData(auto_load_data);
        setupElementsWithData(auto_load_data);
    }
    public void refreshViewOnly(){
        setupElementsWithData(auto_load_data);
    }

    public void loadData(){
        loadStaticData();
        loadDynamicData(auto_load_data);
    }

    public abstract void setupElements();
    public abstract void setupToolbar();
    public abstract void loadStaticData();
    public abstract void loadDynamicData(boolean auto_load_data);
    public abstract void setupElementsWithData(boolean auto_load_data);
    public abstract void setupOnClick();
    public abstract void setupListener();


}


