package cn.internetware.yancloud.dataretention.common.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Desc
 * @ Author YoungSmith
 * @ Date 17-9-26 下午2:46
 */
public class ApiRequest {
    private Map<String, String> headers = new HashMap<>();
    private RequestLine requestLine;
    private String requestBody;

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public RequestLine getRequestLine() {
        return requestLine;
    }

    public void setRequestLine(RequestLine requestLine) {
        this.requestLine = requestLine;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    @Override
    public String toString() {
        return "ApiRequest{" +
                "headers=" + headers +
                ", requestLine=" + requestLine +
                ", requestBody='" + requestBody + '\'' +
                '}';
    }

    public ApiRequest() {
    }

    public ApiRequest(Map<String, String> headers, RequestLine requestLine, String requestBody) {
        this.headers = headers;
        this.requestLine = requestLine;
        this.requestBody = requestBody;
    }
}