package rsi.com.applicationstub.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import rsi.com.applicationstub.domain.Job;

public interface JobService {

    @GET("/getJobs")
    void getJobs(Callback<List<Job>> cb);

    @POST("/addJob")
    void createJob(@Body Job job, Callback<Void> cb);

    @POST("/findJobsByLocation")
    void findJobsByLocation(@Body String location, Callback<List<Job>> cb);

    @POST("/findJobsByPosition")
    void findJobsByPosition(@Body String position, Callback<List<Job>> cb);

    @POST("/findJobsAfterTimestamp")
    void findJobsAfterTimestamp(@Body Date timestamp, Callback<List<Job>> cb);


}
