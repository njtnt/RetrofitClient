package nj.in.retrofitgenericclient.network;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by nitesh on 20-12-2018.
 */

public abstract class ResponseCallback<T> {

    Class<T> type;
    T response;
    public ResponseCallback(){
       Type type  = getClass().getGenericSuperclass();
        while (!(type instanceof ParameterizedType)) {
            if (type instanceof ParameterizedType) {
                type = ((Class<?>) ((ParameterizedType) type).getRawType()).getGenericSuperclass();
            } else {
                type = ((Class<?>) type).getGenericSuperclass();
            }
        }
        this.type = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public abstract void onSuccess(T response);
    public abstract void onFailure(Throwable t);

    public void castResponse(String response){
        this.response = new Gson().fromJson(response,this.type);
        onSuccess(this.response);
    }
}
