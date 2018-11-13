package  com.cooper.gomanezan.fragment;



import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
    //rootView is same as root
    public View rootView;
    public boolean Auto_load = false;

    public void Load_data() {
        setupElements();
        if (!loadData()) {
            setupElementsWithData(Auto_load);
            Auto_load = true;
        }
        setupOnClick();
        setupListeners();

    }

    @Override
    public void onResume() {
        super.onResume();
        refreshData();
    }

    public void refreshData() {
        if (isVisible()) {
            if (!loadDynamicData(Auto_load)) {
                setupElementsWithData(Auto_load);
                Auto_load = true;
            }
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    refreshData();
                }
            }, 100);
        }
    }

    public void refreshViewOnly() {
        if (isVisible()) {
            setupElementsWithData(Auto_load);
            Auto_load = true;
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    refreshViewOnly();
                }
            }, 100);
        }
    }


    private boolean loadData() {
        loadStaticData();
        if (isVisible()) {
            return loadDynamicData(Auto_load);
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    refreshData();
                }
            }, 100);
            return true;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Auto_load = false;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = initRootView(inflater, container);
        Load_data();
        return rootView;
    }

    public abstract View initRootView(LayoutInflater inflater, ViewGroup container);

    public abstract void setupElements();

    public abstract void loadStaticData();

    //#Return FALSE : call setupElementsWithData immediately after call loadDynamicData | TRUE : setupElementsWithData call in loadDynamicData
    public abstract boolean loadDynamicData(boolean Auto_load);

    public abstract void setupElementsWithData(boolean Auto_load);

    public abstract void setupOnClick();

    public abstract void setupListeners();

    public View findViewById(int resId) {
        return rootView.findViewById(resId);
    }

    public boolean onBackPressed() {
        if (getChildFragmentManager().getBackStackEntryCount() > 0) {
            getChildFragmentManager().popBackStack();
            return true;
        } else
            return false;
    }
}
