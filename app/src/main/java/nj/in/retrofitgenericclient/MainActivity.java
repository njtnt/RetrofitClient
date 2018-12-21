package nj.in.retrofitgenericclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import nj.in.retrofitgenericclient.model.MyPojo;
import nj.in.retrofitgenericclient.model.RequestType;
import nj.in.retrofitgenericclient.model.ServiceRequest;
import nj.in.retrofitgenericclient.network.ResponseCallback;
import nj.in.retrofitgenericclient.network.RetrofitServiceManager;
import nj.in.retrofitgenericclient.network.ServiceManager;

public class MainActivity extends AppCompatActivity implements ResponseCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ServiceManager serviceManager = new RetrofitServiceManager(getApplicationContext());
        ServiceRequest serviceRequest = new ServiceRequest();
        serviceRequest.setResponseClass(MyPojo.class);
        serviceRequest.setType(RequestType.GET);
        serviceRequest.setUrl("https://jsonplaceholder.typicode.com/todos/1");
        serviceManager.executeService(serviceRequest, this);
    }

    @Override
    public void onSuccess(Object response) {
        if(response instanceof MyPojo){
            Log.d("response",response.toString());
        }
    }

    @Override
    public void onFailure(Throwable t) {

    }
}
