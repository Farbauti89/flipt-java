package com.flipt.api.resources.authmethodtoken;

import com.flipt.api.core.ClientOptions;
import com.flipt.api.core.ObjectMappers;
import com.flipt.api.core.RequestOptions;
import com.flipt.api.resources.auth.types.AuthenticationToken;
import com.flipt.api.resources.authmethodtoken.requests.AuthenticationTokenCreateRequest;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AuthMethodTokenClient {
    protected final ClientOptions clientOptions;

    public AuthMethodTokenClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public AuthenticationToken createToken(AuthenticationTokenCreateRequest request) {
        return createToken(request, null);
    }

    public AuthenticationToken createToken(AuthenticationTokenCreateRequest request, RequestOptions requestOptions) {
        HttpUrl _httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("auth/v1/method/token")
                .build();
        Map<String, Object> _requestBodyProperties = new HashMap<>();
        _requestBodyProperties.put("name", request.getName());
        _requestBodyProperties.put("description", request.getDescription());
        if (request.getExpiresAt().isPresent()) {
            _requestBodyProperties.put("expiresAt", request.getExpiresAt());
        }
        RequestBody _requestBody;
        try {
            _requestBody = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(_requestBodyProperties),
                    MediaType.parse("application/json"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(_httpUrl)
                .method("POST", _requestBody)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request _request = _requestBuilder.build();
        try {
            Response _response = clientOptions.httpClient().newCall(_request).execute();
            if (_response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(_response.body().string(), AuthenticationToken.class);
            }
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
