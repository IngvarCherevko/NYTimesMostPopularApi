package com.ingvar.just01.inteface;


        import com.ingvar.just01.model.ApiResponse;

        import retrofit2.Call;
        import retrofit2.http.GET;
        import retrofit2.http.Path;
        import retrofit2.http.Query;

public interface NYTApi {
    @GET("{type}/{section}/{time-period}.json")
    Call<ApiResponse> getResult(@Path("type") String type, @Path("section") String section, @Path("time-period") int timePeriod, @Query("api_key") String apiKey);

}
