package rsi.com.applicationstub;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.squareup.otto.Bus;

import java.lang.reflect.Type;
import java.util.Date;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import rsi.com.applicationstub.activity.MainActivity;
import rsi.com.applicationstub.service.JobService;
import rsi.com.applicationstub.view.AddJobDialog;
import rsi.com.applicationstub.view.JobListFragment;

@Module(injects = {
        BaseDialogFragment.class, BaseFragment.class, MainActivity.class, JobListFragment.class,
        AddJobDialog.class
})
public class DaggerModule {

    private Context mContext;

    private RestAdapter mBuilder;

    public DaggerModule(Context context) {
        mContext = context;

        JsonSerializer<Date> ser = new JsonSerializer<Date>() {
            @Override
            public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext
                    context) {
                return src == null ? null : new JsonPrimitive(src.getTime());
            }
        };

        JsonDeserializer<Date> deser = new JsonDeserializer<Date>() {
            @Override
            public Date deserialize(JsonElement json, Type typeOfT,
                                    JsonDeserializationContext context) throws JsonParseException {
                return json == null ? null : new Date(json.getAsLong());
            }
        };

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, ser)
                .registerTypeAdapter(Date.class, deser).create();

        mBuilder = new RestAdapter.Builder()
                .setConverter(new GsonConverter(gson))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(mContext.getResources().getString(R.string.endpoint))
                .build();
    }

    @Provides
    @Singleton
    public JobService getJobListService() {
        return mBuilder.create(JobService.class);
    }

    @Provides
    @Singleton
    public Bus getBus() {
        return new Bus();
    }

}
