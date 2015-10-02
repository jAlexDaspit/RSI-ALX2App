package rsi.com.applicationstub;


import android.app.Activity;
import android.support.v4.app.DialogFragment;

import com.squareup.otto.Bus;

import javax.inject.Inject;

import rsi.com.applicationstub.activity.MainActivity;

public class BaseDialogFragment extends DialogFragment {

    @Inject
    public Bus mEventBus;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).getObjectGraph().inject(this);
        mEventBus.register(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mEventBus.unregister(this);
    }
}
