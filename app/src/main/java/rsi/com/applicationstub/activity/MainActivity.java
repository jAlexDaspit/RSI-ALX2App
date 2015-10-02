package rsi.com.applicationstub.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;

import com.squareup.otto.Bus;

import javax.inject.Inject;

import dagger.ObjectGraph;
import rsi.com.applicationstub.DaggerModule;
import rsi.com.applicationstub.R;
import rsi.com.applicationstub.event.FABEvent;
import rsi.com.applicationstub.view.JobListFragment;

public class MainActivity extends AppCompatActivity {

    private ObjectGraph mObjectGraph;

    @Inject
    Bus mEventBus;

    private static String LIST_TAG = "A";

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        mObjectGraph = ObjectGraph.create(new DaggerModule(this));
        mObjectGraph.inject(this);

        setContentView(R.layout.activity_main);
        FloatingActionButton addJobButton = (FloatingActionButton) findViewById(R.id.addJobButton);
        addJobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEventBus.post(new FABEvent());
            }
        });

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.JobListFragmentContainer, new JobListFragment(), LIST_TAG)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_job_list_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public ObjectGraph getObjectGraph() {
        return mObjectGraph;
    }
}
