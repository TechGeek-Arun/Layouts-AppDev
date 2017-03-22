package layouts.wipro.topgear.com.layouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LinearLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_login);

        Button login = (Button) findViewById(R.id.linearLogin);
        //login1= (Button) findViewById(R.id.login1);

        login.setText("LOGIN");
        // login.setText("LOGIN WITH GOOGLE");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LinearLoginActivity.this, RelativeLoginActivity.class);
                startActivity(intent);

            }
        });

    }
}
