package kiroru.scc2017_android_java;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    class Item {
        String BASE_URL = "https://kiroru-inc.jp/share/scc2017/";
        String imageUrl;
        String jname;
        String ename;

        public Item(String imageUrl, String jname, String ename) {
            this.imageUrl = BASE_URL + imageUrl;
            this.jname = jname;
            this.ename = ename;
        }
    }

    private List<Item> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items.add(new Item("Japan.png", "日本", "Japan"));
        items.add(new Item("China.png", "中国", "China"));
        items.add(new Item("USA.png", "アメリカ", "America"));
        items.add(new Item("England.png", "イギリス", "England"));
        items.add(new Item("France.png", "フランス", "France"));

        ListView lv = (ListView)findViewById(R.id.listView);
        lv.setAdapter(new MyAdapter(this));
    }


    class MyAdapter extends BaseAdapter {

        private ViewHolder holder;
        private LayoutInflater inflater;

        public MyAdapter(Context context) {
            super();
            inflater = ((Activity)context).getLayoutInflater();
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.cell_main, null);
                holder = new ViewHolder();
                holder.iv = (ImageView)convertView.findViewById(R.id.imageView);
                holder.tv1 = (TextView)convertView.findViewById(R.id.textView1);
                holder.tv2 = (TextView)convertView.findViewById(R.id.textView2);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder)convertView.getTag();
            }

            Item item = items.get(position);

            Glide.with(MainActivity.this).load(item.imageUrl).into(holder.iv);
            holder.tv1.setText(item.jname);
            holder.tv2.setText(item.ename);

            return convertView;
        }

        class ViewHolder {
            ImageView iv;
            TextView tv1;
            TextView tv2;
        }
    }
}
