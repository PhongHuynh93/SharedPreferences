package dhbk.android.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btnlogin;
    private EditText edituser, editpassword;
    private CheckBox chksaveaccount;

    public static final String prefname = "my_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        btnlogin = (Button) findViewById(R.id.btnlogin);
        edituser = (EditText) findViewById(R.id.editUser);
        editpassword = (EditText) findViewById(R.id.editPassword);
        chksaveaccount = (CheckBox) findViewById(R.id.chksaveaccount);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        savingPreferences();
    }

    @Override
    protected void onResume() {
        super.onResume();
        restoringPreferences();
    }



    public void onClickButton(View view) {
        doLogin();
    }

    // dang nhap he thong
    private void doLogin() {
        Intent i = new Intent(this, DangNhapThanhCongActivity.class);
        i.putExtra("user", edituser.getText().toString());
        startActivity(i);
    }

    // lưu pref
    public void savingPreferences() {
        SharedPreferences pre = getSharedPreferences(prefname, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pre.edit();
        String user = edituser.getText().toString();
        String pwd = editpassword.getText().toString();
        boolean bchk = chksaveaccount.isChecked();

        if (!bchk) {
            editor.clear();
        } else {
            editor.putString("user", user);
            editor.putString("pwd", pwd);
            editor.putBoolean("checked", bchk);
        }

        editor.apply();
    }

    // đọc pref
    public void restoringPreferences() {
        SharedPreferences pre = getSharedPreferences(prefname, Context.MODE_PRIVATE);
        boolean bchk = pre.getBoolean("checked", false);

        if (bchk) {
            String user = pre.getString("user", "");
            String pwd = pre.getString("pwd", "");
            edituser.setText(user);
            editpassword.setText(pwd);
        }

        chksaveaccount.setChecked(bchk);
    }




}
