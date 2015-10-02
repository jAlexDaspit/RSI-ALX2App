package rsi.com.applicationstub;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.squareup.otto.Bus;

import javax.inject.Inject;

import rsi.com.applicationstub.activity.MainActivity;

public class BaseFragment extends Fragment {

    @Inject
    public Bus mEventBus;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((MainActivity) context).getObjectGraph().inject(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mEventBus.register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        mEventBus.unregister(this);
    }
}
