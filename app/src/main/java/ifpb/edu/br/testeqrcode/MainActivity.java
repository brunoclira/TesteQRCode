package ifpb.edu.br.testeqrcode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new IntentIntegrator(this).initiateScan(); // `this` is the current Activity
        IntentIntegrator integrator = new IntentIntegrator(this);
    }


    /*public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String contents = intent.getStringExtra("SCAN_RESULT");
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
                // Handle successful scan
            } else if (resultCode == RESULT_CANCELED) {
                // Handle cancel
            }
        }
    }*/

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case IntentIntegrator.REQUEST_CODE:
                IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
                final String result = scanResult.getContents();
                if ((result != null) && (scanResult.getFormatName().toString().contentEquals("EAN_13"))) {
                    handler.post(new Runnable() {
                        public void run() {
                            Intent it = new Intent(getBaseContext(), EditarProduto.class);
                            it.putExtra("cod_barras", result);
                            startActivity(it);
                        }
                    });
                } else {
                    Toast.makeText(getBaseContext(), "Código inválido ou inexistente.", 5).show();
                }
                break;
            default:
        }
    }*/

}
