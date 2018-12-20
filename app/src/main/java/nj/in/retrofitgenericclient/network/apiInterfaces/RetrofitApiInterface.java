package nj.in.retrofitgenericclient.network.apiInterfaces;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by nitesh on 20-12-2018.
 */

public interface RetrofitApiInterface {

    @GET
    Call<Object> executeGetService(@Url String url, @HeaderMap Map<String, String> headers, @QueryMap Map<String, String> options);

}
