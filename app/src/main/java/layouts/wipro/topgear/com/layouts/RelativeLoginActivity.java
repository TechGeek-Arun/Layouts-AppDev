package layouts.wipro.topgear.com.layouts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class RelativeLoginActivity extends AppCompatActivity {

    EditText username, password;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_login);

        username= (EditText) findViewById(R.id.username);
        password= (EditText) findViewById(R.id.password);
        b= (Button) findViewById(R.id.opendial);

        b.setText("Open DialPad");

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RelativeLoginActivity.this, OpenDialPadActivity.class);
                startActivity(intent);
               /* Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:(886) 130-6385"));
                startActivity(intent);*/
            }
        });

    }
}