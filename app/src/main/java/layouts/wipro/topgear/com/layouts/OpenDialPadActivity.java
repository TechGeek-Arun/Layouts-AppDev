package layouts.wipro.topgear.com.layouts;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by SH353349 on 3/12/2017.
 */
public class OpenDialPadActivity extends AppCompatActivity implements View.OnClickListener {
    Button one,two,three,four,five,six,seven,eight,nine,zero,star,hash,clear,call;
    private Boolean userIsInTheMiddleOfTypingANumber = false;
    EditText mDialDisplay ;
    private static final String DIGITS = "0123456789*#";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_dial_pad);

        mDialDisplay = (EditText) findViewById(R.id.edit);
        mDialDisplay.setText("");
        findViewById(R.id.button0).setOnClickListener(this);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);
        findViewById(R.id.buttonClear).setOnClickListener(this);
        findViewById(R.id.buttonHash).setOnClickListener(this);
        findViewById(R.id.buttonStar).setOnClickListener(this);
        findViewById(R.id.button_call).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        String buttonPressed = ((Button) view).getText().toString();

        if (DIGITS.contains(buttonPressed)) {

            // digit was pressed
            if (userIsInTheMiddleOfTypingANumber) {

               /* if (buttonPressed.equals(".") && mDialDisplay.getText().toString().contains(".")) {
                    // ERROR PREVENTION
                    // Eliminate entering multiple decimals
                } else */
                    mDialDisplay.append(buttonPressed);


            } else {

                /*if (buttonPressed.equals(".")) {
                    // ERROR PREVENTION
                    // This will avoid error if only the decimal is hit before an operator, by placing a leading zero
                    // before the decimal
                    mDialDisplay.setText(0 + buttonPressed);
                } else {*/
                    mDialDisplay.setText(buttonPressed);


                userIsInTheMiddleOfTypingANumber = true;
            }



        }else {
            int slength = mDialDisplay.length();

            if (slength > 0) {

                //get the last character of the input
                String selection = mDialDisplay.getText().toString().substring(slength - 1, slength);
                Log.e("Selection", selection);

                String result = mDialDisplay.getText().toString().replace(selection, "");
                Log.e("Result", result);

                mDialDisplay.setText(result);
                mDialDisplay.setSelection(mDialDisplay.getText().length());
            }
        }

        if(view.getId()==R.id.button_call) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + mDialDisplay.getText()));
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "No permission to call!", Toast.LENGTH_SHORT).show();
                return;
            }
            startActivity(callIntent);

        }
    }
}
