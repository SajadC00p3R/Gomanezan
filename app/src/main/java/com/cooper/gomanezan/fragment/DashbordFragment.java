package com.cooper.gomanezan.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cooper.gomanezan.R;

public class DashbordFragment extends BaseFragment {

    @Override
    public View initRootView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_dashbord, container, false);

    }

    @Override
    public void setupElements() {

    }

    @Override
    public void loadStaticData() {

    }

    @Override
    public boolean loadDynamicData(boolean Auto_load) {
        return false;
    }

    @Override
    public void setupElementsWithData(boolean Auto_load) {

    }

    @Override
    public void setupOnClick() {

    }

    @Override
    public void setupListeners() {

    }
}
