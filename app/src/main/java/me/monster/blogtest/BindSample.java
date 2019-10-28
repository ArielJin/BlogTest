package me.monster.blogtest;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import me.monster.bind_lib.Bind;
import me.monster.lib_annotaion.BindView;

/**
 * @description
 * @author: Created jiangjiwei in 2019-10-26 16:28
 */
public class BindSample extends AppCompatActivity {

    @BindView(R.id.tv_hello)
    TextView tvHello;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_sample);
        Bind.bind(this);


        tvHello.setText("嘻嘻嘻");
    }
}
