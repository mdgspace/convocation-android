package ac.in.iitr.mdg.convocation.network;

import java.util.ArrayList;

import ac.in.iitr.mdg.convocation.responsemodels.ChiefGuestResponse;
import ac.in.iitr.mdg.convocation.responsemodels.CommonResponse;
import ac.in.iitr.mdg.convocation.responsemodels.DegreeResponseModel;
import ac.in.iitr.mdg.convocation.responsemodels.MedalsResponseModel;
import ac.in.iitr.mdg.convocation.responsemodels.ScheduleModel;
import ac.in.iitr.mdg.convocation.responsemodels.UserResponseModel;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ConvoApi {

    @GET("schedule/")
    Observable<ArrayList<ScheduleModel>> getSchedule();

    @GET("oauth/")
    Observable<UserResponseModel> getOauth(@Query("code") String code);

    @FormUrlEncoded
    @POST("user/register/")
    Observable<CommonResponse> registerUser(@Field("enr_no") String enrollmentNumber,
                                            @Field("ph_no") String phoneNumber,
                                            @Field("name") String name,
                                            @Field("email") String email,
                                            @Field("adults") int adults,
                                            @Field("four_wheeler") int isFourWheeler,
                                            @Field("transaction_id") String transactionId,
                                            @Field("tshirt_size") int tShirtSize,
                                            @Field("address") String address,
                                            @Field("profile_image") String profileImage);

    @GET("user/chief_guests/")
    Observable<ArrayList<ChiefGuestResponse>> getChiefGuests();

    @GET("user/medals/")
    Observable<ArrayList<MedalsResponseModel>> getMedals();

    @GET("user/degrees/")
    Observable<ArrayList<DegreeResponseModel>> getDegrees();

    @GET("user/profile/")
    Observable<UserResponseModel> getProfile();

}
