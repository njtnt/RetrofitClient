package nj.in.retrofitgenericclient.network;

import android.content.Context;

import nj.in.retrofitgenericclient.model.ServiceRequest;

/**
 * Created by nitesh on 20-12-2018.
 */

public abstract class ServiceManager {

    private Context context;

    public ServiceManager(Context context){
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public abstract void executeService(ServiceRequest request, ResponseCallback<?> responseCallback);

}
