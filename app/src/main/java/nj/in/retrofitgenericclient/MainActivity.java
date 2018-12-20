package nj.in.retrofitgenericclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import nj.in.retrofitgenericclient.model.MyPojo;
import nj.in.retrofitgenericclient.model.ServiceRequest;
import nj.in.retrofitgenericclient.network.ResponseCallback;
import nj.in.retrofitgenericclient.network.RetrofitServiceManager;
import nj.in.retrofitgenericclient.network.ServiceManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ServiceManager serviceManager = new RetrofitServiceManager(getApplicationContext());
        ServiceRequest serviceRequest = new ServiceRequest();
        serviceRequest.setUrl("https://jsonplaceholder.typicode.com/todos/1");
        serviceManager.executeService(serviceRequest, new ResponseCallback<MyPojo>() {
            @Override
            public void onSuccess(MyPojo response) {
                Log.d("resp",response.toString());
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
