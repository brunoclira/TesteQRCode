package ifpb.edu.br.testeqrcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Botões da activity_main
        Button scanBtn;
        TextView formatTxt, contentTxt;

        //Atribuindo valores ao button e ao textview
        scanBtn = (Button) findViewById(R.id.scan_button);
        formatTxt = (TextView) findViewById(R.id.scan_format);
        contentTxt = (TextView) findViewById(R.id.scan_content);

        //Adicionando lista ao button
        //scanBtn.setOnClickListener(this);
        scanBtn.setOnClickListener(new View.OnClickListener() {
            //Método para resposta dos click
           @Override
            public void onClick(View v) {
                if (v.getId() == R.id.scan_button) {
                    IntentIntegrator scanIntegrator = new IntentIntegrator(MainActivity.this);
                    scanIntegrator.initiateScan();
                }
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        //retrieve scan result
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

        if (scanningResult != null) {
            //we have a result
            String scanContent = scanningResult.getContents();
            String scanFormat = scanningResult.getFormatName();

            TextView formatTxt = null;
            formatTxt.setText("FORMAT: " + scanFormat);
            TextView contentTxt = null;
            contentTxt.setText("CONTENT: " + scanContent);

        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

   // @Override
    //public void onClick(View v) {

    //}
}


