package kiroru.scc2017_android_java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent i = getIntent();
        String imageUrl = i.getStringExtra("imageUrl");
        String jname = i.getStringExtra("jname");
        String ename = i.getStringExtra("ename");

        ImageView iv = (ImageView)findViewById(R.id.imageView);
        Glide.with(this).load(imageUrl).into(iv);

        TextView tv1 = (TextView)findViewById(R.id.textView1);
        tv1.setText(jname);

        TextView tv2 = (TextView)findViewById(R.id.textView2);
        tv2.setText(ename);

        Button b = (Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
