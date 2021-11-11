package retrofit;

import com.trello.rxlifecycle2.components.RxActivity;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle2.components.support.RxFragment;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit.Utils.MyObserver;
import retrofit.Utils.RetrofitUtils;
import retrofit.Utils.RxHelper;
import retrofit.bean.Data;
import retrofit.bean.Info;

/**
 * 提交参数方式
 */
public class RequestUtils {

    public static void getInfo(RxActivity context, MyObserver<Info> observer){
        RetrofitUtils.getApiUrl().getDemo()
                .compose(RxHelper.observableIO2Main(context))
                .subscribe(observer);
    }

}

