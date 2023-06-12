package com.jimi.easy_transfer.activity;

import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

import com.fatcat.easy_transfer.R;
import com.jimi.easy_transfer.base.BaseActivity;
import com.jimi.easy_transfer.utils.Tool;


/**
 * @author Administrator
 * @version $Rev$
 * @time 2016/4/917:53
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class AboutActivity extends BaseActivity {
    private Toolbar mToolbar;

    @Override
    public void initView() {
        setContentView(R.layout.activity_about);

        Tool.getInstance().show(this);
    }


    @Override
    protected void initActionBar() {
        super.initActionBar();

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        // toolbar.setLogo(R.drawable.ic_launcher);
        mToolbar.setTitle("关于");// 标题的文字需在setSupportActionBar之前，不然会无效
        // toolbar.setSubtitle("副标题");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initListener() {
        super.initListener();
    }

    @Override
    protected void initFragment() {
        super.initFragment();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
