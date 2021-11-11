package retrofit;

import io.reactivex.Observable;
import retrofit.bean.Data;
import retrofit.bean.Info;
import retrofit2.http.GET;

public interface ApiUrl {

    @GET(Constans.retrofit2)
    Observable<Data<Info>> getDemo();

}
