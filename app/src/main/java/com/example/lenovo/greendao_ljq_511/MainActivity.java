package com.example.lenovo.greendao_ljq_511;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.lenovo.greendao_ljq_511.app.MyApp;
import com.example.lenovo.greendao_ljq_511.bean.DaoSession;
import com.example.lenovo.greendao_ljq_511.bean.User;
import com.example.lenovo.greendao_ljq_511.bean.UserDao;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btInsert)
    Button btInsert;
    @BindView(R.id.btDel)
    Button btDel;
    @BindView(R.id.btUpdate)
    Button btUpdate;
    @BindView(R.id.btSelect)
    Button btSelect;

     public DaoSession daoSession;
 public   UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        daoSession = MyApp.getDaoSession();
        userDao = daoSession.getUserDao();

    }

    @OnClick({R.id.btInsert, R.id.btDel, R.id.btUpdate, R.id.btSelect})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btInsert:

                //插入10条数据
                for (int i=1; i<=10;i++){
                    //new了一个user

                    User user=new User();
                   user.setName("lijingqian_"+i);
                   user.setAge("age_"+i);
                   userDao.insert(user);

                }
                Toast.makeText(this,"添加成功",Toast.LENGTH_LONG).show();

                break;
            case R.id.btDel:

                //删除的方法
               User user= new User();
                user.setId(1L);
                user.setName("name_1");
                user.setAge("age_1");
                userDao.delete(user);
                Toast.makeText(this,"删除成功",Toast.LENGTH_LONG).show();
                break;
            case R.id.btUpdate:

                //修改的方法
                User user1= new User();
                user1.setId(1L);
                user1.setName("good good study");
                user1.setAge("30");
                userDao.update(user1);

                Toast.makeText(this,"修改成功",Toast.LENGTH_LONG).show();
                break;
            case R.id.btSelect:

                chaxun1();
                break;
        }

    }

    private void chaxun1(){
        //查询所有
        List<User> list = userDao.queryBuilder().build()
                .list();

        //循环遍历查询插入的数据
        for (int i=0;i<list.size();i++){
            Log.e("lijinqgain",list.get(i).toString());
        }
        Toast.makeText(this,"查询成功",Toast.LENGTH_SHORT).show();
    }

    private void chaxun2(){

        //查询相同的id字段
        List<User> list = userDao.queryBuilder()
                .where(UserDao.Properties.Id.eq("3")).build().list();
        //循环遍历查询插入的数据
        for (int i=0;i<list.size();i++){
            Log.e("lijinqgain",list.get(i).toString());
        }
        Toast.makeText(this,"查询成功",Toast.LENGTH_SHORT).show();
    }

    private  void chaxun3(){

        //按照降序的方式排列
        List<User> list = userDao.queryBuilder()
                .orderDesc(UserDao.Properties.Id).build().list();

        //循环遍历查询插入的数据
        for (int i=0;i<list.size();i++){
            Log.e("lijinqgain",list.get(i).toString());
        }
        Toast.makeText(this,"查询成功",Toast.LENGTH_SHORT).show();
    }
}
