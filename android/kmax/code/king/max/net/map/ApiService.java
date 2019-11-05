package king.max.net.map;

import king.max.BuildConfig;
import king.max.net.entity.Result;

import retrofit2.http.*;

import java.util.Map;

import io.reactivex.Observable;

public interface ApiService {

    /* 服务器地址, 在 build.gradle 中配置 */
    String BASE_URL = BuildConfig.SERVER_BASE;
    /* 超时 */
    int TIME_OUT = 15;

    @GET("api/{api_name}/{api_version}")
    Observable<Result> getRequest(
	 @Path("api_name")    String apiName,
         @Path("api_version") String apiVersion,
	 @Query("action")     String action,
         @QueryMap Map<String, Object> options
    );

    @POST("api/{api_name}/{api_version}")
    @FormUrlEncoded
    Observable<Result> postRequest(
	 @Path("api_name")    String apiName,
         @Path("api_version") String apiVersion,
	 @Field("action")     String action,
	 @FieldMap Map<String, Object> aptions
    );

}
