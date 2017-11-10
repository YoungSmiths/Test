package cn.young.dev.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Desc
 * @ Author YoungSmith
 * @ Date 17-9-27 上午11:03
 */
public class RequestLine {
    private String protoversion;
    private String method;
    private String uri;
    private Map<String, String> query = new HashMap<>();
    private List<String> path = new ArrayList<>();

    public String getProtoversion() {
        return protoversion;
    }

    public void setProtoversion(String protoversion) {
        this.protoversion = protoversion;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Map<String, String> getQuery() {
        return query;
    }

    public void setQuery(Map<String, String> query) {
        this.query = query;
    }

    public List<String> getPath() {
        return path;
    }

    public void setPath(List<String> path) {
        this.path = path;
    }

    public RequestLine() {
    }
}