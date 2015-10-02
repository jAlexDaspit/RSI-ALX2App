package rsi.com.applicationstub.domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.sql.Timestamp;
import java.util.Date;

public class Job implements Parcelable {

    private String companyName;
    private String position;
    private String location;
    private String description;
    private Date timestamp;

    public Job() {
        // default constructor
    }

    public Job(String companyName, String position, String location, String description) {
        this.companyName = companyName;
        this.position = position;
        this.location = location;
        this.description = description;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    private Job(Parcel in) {
        companyName = in.readString();
        position = in.readString();
        location = in.readString();
        description = in.readString();
        timestamp = new Timestamp(in.readLong());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(companyName);
        dest.writeString(position);
        dest.writeString(location);
        dest.writeString(description);
        dest.writeLong(timestamp.getTime());
    }

    public static final Parcelable.Creator<Job> CREATOR = new Parcelable.Creator<Job>() {

        @Override
        public Job createFromParcel(Parcel source) {
            return new Job(source);
        }

        @Override
        public Job[] newArray(int size) {
            return new Job[size];
        }
    };

    @Override
    public boolean equals(Object object) {
        if (object != null && object instanceof Job) {
            Job otherJob = (Job) object;
            return companyName.equals(otherJob.getCompanyName())
                    && position.equals(otherJob.getPosition())
                    && location.equals(otherJob.getLocation())
                    && timestamp.equals(otherJob.getTimestamp())
                    && description.equals(otherJob.getDescription());
        }
        return false;
    }
}
