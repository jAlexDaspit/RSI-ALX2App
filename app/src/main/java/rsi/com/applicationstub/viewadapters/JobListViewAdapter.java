package rsi.com.applicationstub.viewadapters;

import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import rsi.com.applicationstub.R;
import rsi.com.applicationstub.domain.Job;

public class JobListViewAdapter extends RecyclerView.Adapter<JobListViewAdapter.JobViewHolder> {

    private List<Job> jobs;

    private SimpleDateFormat mFormat = new SimpleDateFormat("MMMM d, h:mm", Locale.getDefault());

    @Override
    public JobViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.job_list_item, viewGroup, false);
        return new JobViewHolder(view, jobs.get(i));
    }

    @Override
    public void onBindViewHolder(JobViewHolder jobViewHolder, int i) {
        Job job = jobs.get(i);
        jobViewHolder.companyName.setText(job.getCompanyName());
        jobViewHolder.position.setText(job.getPosition());
        jobViewHolder.location.setText(job.getLocation());
        jobViewHolder.description.setText(job.getDescription());
        jobViewHolder.date.setText(mFormat.format(job.getTimestamp()));
    }

    @Override
    public int getItemCount() {
        return jobs != null ? jobs.size() : 0;
    }

    public class JobViewHolder extends RecyclerView.ViewHolder {
        TextView companyName, position, description, location, date;

        public JobViewHolder(View itemView, Job job) {
            super(itemView);

            companyName = (TextView) itemView.findViewById(R.id.companyName);
            position = (TextView) itemView.findViewById(R.id.position);
            description = (TextView) itemView.findViewById(R.id.description);
            location = (TextView) itemView.findViewById(R.id.location);
            date = (TextView) itemView.findViewById(R.id.date);

            if (job != null) {
                position.setText(job.getPosition());
                description.setText(job.getDescription());
                location.setText(job.getLocation());
                date.setText(mFormat.format(job.getTimestamp()));
            }
        }
    }

    public void refresh(List<Job> jobs) {
        this.jobs = jobs;
        notifyDataSetChanged();
    }
}
