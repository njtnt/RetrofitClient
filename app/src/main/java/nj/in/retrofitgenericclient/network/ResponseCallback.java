package nj.in.retrofitgenericclient.network;

/**
 * Created by nitesh on 20-12-2018.
 */

public interface ResponseCallback {
    void onSuccess(Object response);
    void onFailure(Throwable t);
}
