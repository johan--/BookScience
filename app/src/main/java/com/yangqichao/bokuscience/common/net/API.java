package com.yangqichao.bokuscience.common.net;


import com.yangqichao.bokuscience.business.bean.BackGroundBean;
import com.yangqichao.bokuscience.business.bean.BookBean;
import com.yangqichao.bokuscience.business.bean.FeedBean;
import com.yangqichao.bokuscience.business.bean.GetKeShiPerson;
import com.yangqichao.bokuscience.business.bean.InitBookBean;
import com.yangqichao.bokuscience.business.bean.InitVideoBean;
import com.yangqichao.bokuscience.business.bean.LevelBean;
import com.yangqichao.bokuscience.business.bean.LoginBean;
import com.yangqichao.bokuscience.business.bean.MeetingDetailBean;
import com.yangqichao.bokuscience.business.bean.MessageBean;
import com.yangqichao.bokuscience.business.bean.MessageDetail;
import com.yangqichao.bokuscience.business.bean.MyBookBean;
import com.yangqichao.bokuscience.business.bean.MyMeetingBean;
import com.yangqichao.bokuscience.business.bean.RegisteBean;
import com.yangqichao.bokuscience.business.bean.ScienceDynamicBean;
import com.yangqichao.bokuscience.business.bean.ShareItemBean;
import com.yangqichao.bokuscience.business.bean.ShowPersonBean;
import com.yangqichao.bokuscience.business.bean.VideoListBean;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by yangqc on 2017/3/22.
 */
public interface API {

//    @POST("app/login")
//    Observable<Response<LoginBean>> login(@Body RequestBody requestBody);
//
//    @GET("app/searchWordQr/{id}/{userId}")
//    Observable<Response<String>> searchWordQr(@Path("id") String id,
//                                              @Path("userId") String userId);

    @GET("app/searchPatentAppPic")
    Observable<Response<String>> searchPatentAppPic();


    @GET("app/user/check/{tel}")
    Observable<Response<String>> check(@Path("tel") String tel);

    @POST("app/user/login")
    Observable<Response<LoginBean>> login(@Body RequestBody requestBody);

    @GET("app/province/get")
    Observable<Response<List<LevelBean>>> get();

    @GET("app/orgsub/get/{pid}")
    Observable<Response<List<LevelBean>>> getLevel(@Path("pid") String pid);

//    @POST("app/registe/add")
//    Observable<Response<>> add(RequestBody requestBody);

    @POST("/app/user/registe")
    Observable<Response<RegisteBean>> registe(@Body RequestBody requestBody);

    @GET("/app/user/resetpassword/{tel}/{checkcode}")
    Observable<Response<String>> resetpassword(@Path("tel") String tel,@Path("checkcode") String checkcode);

    @GET("/app/notifications/getbyuser/{userId}")
    Observable<Response<List<ScienceDynamicBean>>> getbyuser(@Path("userId") String userId);

    @Multipart
    @POST("/app/sharemsg/insertInfo")
    Observable<Response<String>> insertInfo(@PartMap Map<String, okhttp3.RequestBody> params);

    @Multipart
    @POST("/app/sharemsg/insertInfo")
    Observable<Response<String>> insertInfo(@PartMap Map<String, okhttp3.RequestBody> params
                                                     ,@Part MultipartBody.Part file);


    @POST("/app/org/users")
    Observable<Response<GetKeShiPerson>> users(@Body RequestBody requestBody);

    @POST("/app/mymeetings/select")
    Observable<Response<MyMeetingBean>> select(@Body RequestBody requestBody);


    @GET("/app/meeting/get/{id}")
    Observable<Response<MeetingDetailBean>> meetingDetail(@Path("id") int id);

    @GET
    Observable<Response<String>> sign(@Url String url);

    @GET("/app/meetingjoin/select/{meetingId}")
    Observable<Response<ShowPersonBean>> showPerson(@Path("meetingId") String meetingId);

    @Multipart
    @POST("/app/meeting/publish")
    Observable<Response<String>> publish(@PartMap() Map<String, okhttp3.RequestBody> partMap,
                                         @Part MultipartBody.Part file);
    @Multipart
    @POST("/app/meeting/publish")
    Observable<Response<String>> publish(@PartMap() Map<String, okhttp3.RequestBody> partMap);

    @POST("/app/sharemsg/select")
    Observable<Response<ShareItemBean>> selectShare(@Body RequestBody requestBody);


    @GET("/app/meeting/signflag/{meetingId}/{flag}")
    Observable<Response<ShowPersonBean>> signflag(@Path("meetingId") int meetingId,@Path("flag") int flag);


    @GET("/app/videos/init/{userId}")
    Observable<Response<InitVideoBean>> initVideo(@Path("userId") String userId);

    @POST("/app/videos/select")
    Observable<Response<VideoListBean>> selectVideoList(@Body RequestBody requestBody);


    @GET("/app/book/init")
    Observable<Response<InitBookBean>> initBook();

    @POST("/app/book/selectpage")
    Observable<Response<BookBean>> selectBook(@Body RequestBody requestBody);

    @POST("/app/mybook/add")
    Observable<Response<String>> add(@Body RequestBody requestBody);

    @POST("/app/mybook/delete")
    Observable<Response<String>> delete(@Body RequestBody requestBody);

    @POST("/app/mybook/selectpage")
    Observable<Response<MyBookBean>> selectMyBook(@Body RequestBody requestBody);

    @GET("/app/meeting/cancel/{meetingId}")
    Observable<Response<String>> cancelMeeting(@Path("meetingId") String meetingid);

    @GET("/app/feedtype/get")
    Observable<Response<List<FeedBean>>> getFeedList();

    @POST("/app/feedback/add")
    Observable<Response<String>> addFeed(@Body RequestBody requestBody);


    @POST("/app/user/motifyPassword")
    Observable<Response<String>> motifyPassword(@Body RequestBody requestBody);


    @POST("/app/notifications/getbytype")
    Observable<Response<MessageBean>> getbytype(@Body RequestBody requestBody);

    @GET("/app/notifications/get/{id}")
    Observable<Response<MessageDetail>> getMessageDetail(@Path("id") String id);

    @GET("/app/background/get")
    Observable<Response<BackGroundBean>> getBackGround();

    @GET("/app/videos/get/{id}")
    Observable<Response<VideoListBean.RecordsBean>> getVideoDetail(@Path("id") int id);


}
