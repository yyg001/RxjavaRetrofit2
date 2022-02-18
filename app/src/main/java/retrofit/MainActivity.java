package retrofit;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.trello.rxlifecycle2.components.RxActivity;
import retrofit.Utils.MyObserver;
import retrofit.bean.Data;
import retrofit.bean.Info;


public class MainActivity extends RxActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private TextView tv_retrofit;
    private MyObserver<Info> myObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        findViewById(R.id.btn_1).setOnClickListener(this);
        tv_retrofit = findViewById(R.id.tv_retrofit);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_1:
                getData();
                break;
        }
    }

    private void getData() {
        myObserver = new MyObserver<Info>(this) {

            @Override
            public void onSuccess(Info result) {
                Log.i("a6789", "onSuccess: "+"返回的数据：" + "\n\n" + result.getName() + "\n\n" + result.getPicurl());
                tv_retrofit.setText("返回的数据：" + "\n\n" + result.getName() + "\n\n" + result.getPicurl());
            }

            @Override
            public void onFailure(Throwable e, String errorMsg) {
                Log.i("a6789", "onFailure: "+errorMsg);
                tv_retrofit.setText(errorMsg);
            }
        };
        RequestUtils.getInfo(this,myObserver);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        myObserver.cancleRequest();
    }
}
