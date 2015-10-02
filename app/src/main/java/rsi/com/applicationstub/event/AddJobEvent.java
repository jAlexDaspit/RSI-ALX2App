package rsi.com.applicationstub.event;

import rsi.com.applicationstub.domain.Job;

public class AddJobEvent {
    public Job job;

    public AddJobEvent(Job job) {
        this.job = job;
    }
}
