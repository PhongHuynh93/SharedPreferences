package dhbk.android.sharedpreferences;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DangNhapThanhCongActivity extends AppCompatActivity {
    TextView txtMsg;
    Button btnThoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap_thanh_cong);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        txtMsg = (TextView) findViewById(R.id.txtmsg);
        btnThoat = (Button) findViewById(R.id.btnThoat);

        Intent i = getIntent();
        txtMsg.setText("Hello: " + i.getStringExtra("user"));

    }

    public void onClickThoat(View view) {
        finish();
    }
}
