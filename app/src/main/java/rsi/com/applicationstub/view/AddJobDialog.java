package rsi.com.applicationstub.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import rsi.com.applicationstub.BaseDialogFragment;
import rsi.com.applicationstub.R;
import rsi.com.applicationstub.domain.Job;
import rsi.com.applicationstub.event.AddJobEvent;

public class AddJobDialog extends BaseDialogFragment {

    @Bind(R.id.state)
    EditText mState;
    @Bind(R.id.city)
    EditText mCity;
    @Bind(R.id.position)
    EditText mPositionText;
    @Bind(R.id.description)
    EditText mDescriptionText;
    @Bind(R.id.companyName)
    EditText mCompanyName;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle saveInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_add_job, null);
        ButterKnife.bind(this, view);

        builder.setTitle(R.string.dialog_add_job_title)
                .setPositiveButton(R.string.dialog_add, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Job job = new Job(mCompanyName.getText().toString(), mDescriptionText.getText().toString(),
                                mCity.getText().toString(), mPositionText.getText().toString());
                        mEventBus.post(new AddJobEvent(job));
                        mEventBus.post(new AddJobEvent(job));
                    }
                })
                .setNegativeButton(R.string.dialog_cancel, null)
                .setView(view);

        return builder.create();
    }
}
