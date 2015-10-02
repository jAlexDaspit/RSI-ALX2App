package rsi.com.applicationstub.event;
import rsi.com.applicationstub.domain.Job;

public class EditJobEvent {
    public Job job;

    public EditJobEvent(Job job) {
        this.job = job;
    }
}
