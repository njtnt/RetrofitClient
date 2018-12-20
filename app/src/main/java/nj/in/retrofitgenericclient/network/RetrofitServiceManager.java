package nj.in.retrofitgenericclient.network;

import android.content.Context;

import nj.in.retrofitgenericclient.model.ServiceRequest;
import nj.in.retrofitgenericclient.network.apiInterfaces.RetrofitApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nitesh on 20-12-2018.
 */

public class RetrofitServiceManager extends ServiceManager{

    RetrofitApiInterface apiInterface;

    public RetrofitServiceManager(Context context) {
        super(context);
        apiInterface = getClient(context).create(RetrofitApiInterface.class);
    }

    private static Retrofit getClient(Context context){
        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl("http://www.google.com")
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        ).build();
        return retrofit;
    }

    @Override
    public void executeService(final ServiceRequest request, final ResponseCallback responseCallback) {
           Call<Object> call =  apiInterface.executeGetService(request.getUrl(),request.getHeaders(),request.getParameters());
           call.enqueue(new RetrofitCallBack<Object>(responseCallback));
        }


     private class RetrofitCallBack<T> implements Callback<T>{
        ResponseCallback responseCallback;

        RetrofitCallBack(ResponseCallback<T> responseCallback){
            this.responseCallback = responseCallback;
        }

         @Override
         public void onResponse(Call<T> call, Response<T> response) {
             responseCallback.castResponse(response.toString());
         }

         @Override
         public void onFailure(Call<T> call, Throwable t) {
            responseCallback.onFailure(t);
         }
     }
}
