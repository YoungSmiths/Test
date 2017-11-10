package cn.internetware.yancloud.dataretention.common.utils;

import cn.internetware.yancloud.dataretention.common.entity.ApiRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ Desc
 * @ Author YoungSmith
 * @ Date 17-10-18 下午10:33
 */
public class ApiHttpClient {

    private static final Logger logger = LoggerFactory.getLogger(ApiHttpClient.class);

    private static HttpClient httpClient;

    private static HttpClientContext context = HttpClientContext.create();

    private static CookieStore cookieStore = new BasicCookieStore();

    private ApiHttpClient() {
    }

    static {
        context.setCookieStore(cookieStore);
        HttpClientBuilder httpclientbuilder;
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, (arg0, arg1) -> true).build();
            httpclientbuilder = HttpClients.custom().disableRedirectHandling().setSSLContext(sslContext)
                    .setSSLHostnameVerifier(new NoopHostnameVerifier());
        } catch (Exception e) {
            throw new RuntimeException("Cannot create http client !", e);
        }
        httpClient = httpclientbuilder.build();
    }

    /**
     * 执行请求
     *
     * @param httpUriRequest
     * @return
     * @throws Exception
     */
    private static HttpResponse executeRequest(HttpUriRequest httpUriRequest) throws Exception {
        if (httpClient == null) {
            httpClient = HttpClients.custom().build();
        }
        return httpClient.execute(httpUriRequest, context);
    }

    /**
     * 关闭响应
     *
     * @param httpResponse
     * @throws IOException
     */
    private static void closeResponse(HttpResponse httpResponse) throws IOException {
        EntityUtils.consume(httpResponse.getEntity());
    }

    /**
     * 关闭客户端
     *
     * @param httpClient
     * @throws HttpOperationException
     */
    private static void closeHttpClient(HttpClient httpClient) throws HttpOperationException {
        if (httpClient != null && httpClient instanceof CloseableHttpClient) {
            try {
                ((CloseableHttpClient) httpClient).close();
            } catch (IOException e) {
                throw new HttpOperationException("closeHttpClient error ...... ", e);
            }
        }
    }

    /**
     * 返回字符串
     *
     * @param apiRequest
     * @return
     * @throws Exception
     */
    public static String request4Str(ApiRequest apiRequest) throws Exception {
        HttpResponse response = request(apiRequest);
        String result = EntityUtils.toString(response.getEntity());
        closeResponse(response);
        return result;
    }

    public static byte[] request4byte(ApiRequest apiRequest) throws Exception {
        HttpResponse response = request(apiRequest);
        byte[] bytes = EntityUtils.toByteArray(response.getEntity());
        closeResponse(response);
        return bytes;
    }

    /**
     * 调用后需要手动关闭response,外部类不建议直接调用
     *
     * @param apiRequest
     * @return
     * @throws Exception
     */
    public static HttpResponse request(ApiRequest apiRequest) throws Exception {
        String method = apiRequest.getRequestLine().getMethod();
        String uri = getUri(apiRequest);
        HttpUriRequest httpRequest = build(method, uri);
        Map<String, String> headers = apiRequest.getHeaders();
        String contentType = headers.get(HTTP.CONTENT_TYPE);
        if (method.equalsIgnoreCase("post")) {
            dealResponseBody((HttpPost) httpRequest, apiRequest, contentType);
        }
        return executeRequest(httpRequest);
    }

    /**
     * 默认使用 application-json
     *
     * @param httpRequest
     * @param apiRequest
     * @param contentType
     * @throws IOException
     */
    private static void dealResponseBody(HttpPost httpRequest, ApiRequest apiRequest, String contentType) throws IOException {
        String requestBody = apiRequest.getRequestBody();
        if (!StringUtils.hasText(requestBody)) {
            return;
        }
        if (ContentType.APPLICATION_FORM_URLENCODED.getMimeType().equalsIgnoreCase(contentType)) {
            Map<String, Object> map = GsonUtil.json2Map(requestBody);

            List<NameValuePair> nvps = new ArrayList<>();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), (String) entry.getValue()));
            }
            httpRequest.setEntity(new UrlEncodedFormEntity(nvps));
        } else// (ContentType.APPLICATION_JSON.getMimeType().equalsIgnoreCase(contentType)) //默认使用 application-json
        {
            StringEntity stringEntity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
            httpRequest.setEntity(stringEntity);
        }
    }

    public static String getUri(ApiRequest apiRequest) {
        StringBuilder uri = new StringBuilder(apiRequest.getRequestLine().getUri());
        List<String> path = apiRequest.getRequestLine().getPath();
        for (String p : path) {
            uri.append("/").append(p);
        }
        Map<String, String> query = apiRequest.getRequestLine().getQuery();
        if (query.size() > 0)
            uri.append("?");
        for (Map.Entry<String, String> entry : query.entrySet()) {
            uri.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        String str = uri.toString();
//        if (str.lastIndexOf("&") == str.length() - 1)
//            return str.substring(0, str.length() - 2);
        return str;
    }

    private static HttpUriRequest build(String method, String uri) throws HttpOperationException {
        HttpUriRequest httpRequest;
        method = method.toLowerCase();
        switch (method) {
            case "post":
                httpRequest = new HttpPost(uri);
                break;
            case "get":
                httpRequest = new HttpGet(uri);
                break;
            default:
                throw new HttpOperationException("can not support [" + method + "] httpRequest!");
        }
        return httpRequest;
    }

}
