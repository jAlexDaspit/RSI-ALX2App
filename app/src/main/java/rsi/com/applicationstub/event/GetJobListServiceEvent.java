package rsi.com.applicationstub.event;

import java.util.List;

import rsi.com.applicationstub.domain.Job;

public class GetJobListServiceEvent {

    public boolean isSuccessful;
    public List<Job> jobs;

    public GetJobListServiceEvent(boolean isSuccessful, List<Job> jobs) {
        this.jobs = jobs;
        this.isSuccessful = isSuccessful;
    }

}
