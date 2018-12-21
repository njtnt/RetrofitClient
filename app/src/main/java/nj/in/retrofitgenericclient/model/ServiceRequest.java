package nj.in.retrofitgenericclient.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nitesh on 20-12-2018.
 */

public class ServiceRequest<T> {

    private Class<?> responseClass;
    private String url;
    private Map<String,String> headers = new HashMap<>();
    private Map<String,String> parameters = new HashMap<>();
    private RequestType type;

    public Class<?> getResponseClass() {
        return responseClass;
    }

    public void setResponseClass(Class<?> responseClass) {
        this.responseClass = responseClass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public RequestType getType() {
        return type;
    }

    public void setType(RequestType type) {
        this.type = type;
    }
}
