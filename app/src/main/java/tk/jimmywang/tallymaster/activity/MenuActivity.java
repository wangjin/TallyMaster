package tk.jimmywang.tallymaster.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tk.jimmywang.tallymaster.R;
import tk.jimmywang.tallymaster.entity.MenuItem;

public class MenuActivity extends AppCompatActivity {

    private List<MenuItem> menuItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        GridView menuGrid = (GridView) findViewById(R.id.menu_gridview);
        if (menuGrid != null) {
            menuGrid.setAdapter(new MenuAdapter(this));
        }

        //初始化菜单项
        initMenuItems();
    }


    private void initMenuItems() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(R.drawable.jigong, "记工管理", 1));
        menuItems.add(new MenuItem(R.drawable.renyuan, "人员管理", 2));
        menuItems.add(new MenuItem(R.drawable.gongdi, "工地管理", 3));
        menuItems.add(new MenuItem(R.drawable.liushui, "记工统计", 4));
        menuItems.add(new MenuItem(R.drawable.didian, "地点管理", 4));
    }

    private class MenuViewHolder {
        public ImageView menuImage;
        public TextView menuName;
    }

    private class MenuAdapter extends BaseAdapter {

        private Context context;
        private LayoutInflater inflater;

        public MenuAdapter(Context context) {
            this.context = context;
            this.inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            if (menuItems != null) {
                return menuItems.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //初始化菜单项视图
            MenuViewHolder menuViewHolder;
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.menu_item, parent, false);
                menuViewHolder = new MenuViewHolder();
                menuViewHolder.menuImage = (ImageView) convertView.findViewById(R.id.menu_image);
                menuViewHolder.menuName = (TextView) convertView.findViewById(R.id.menu_name);
                convertView.setTag(menuViewHolder);
            } else {
                menuViewHolder = (MenuViewHolder) convertView.getTag();
            }

            //菜单项赋值及绑定点击事件
            if (getCount() != 0) {
                menuViewHolder.menuName.setText(menuItems.get(position).getMenuName());
                menuViewHolder.menuImage.setImageDrawable(context.getResources().getDrawable(menuItems.get(position).getMenuImage()));
                final Integer menuFlag = menuItems.get(position).getMenuFlag();
                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (menuFlag) {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                        }
                    }
                });
            }


            return convertView;
        }
    }
}
