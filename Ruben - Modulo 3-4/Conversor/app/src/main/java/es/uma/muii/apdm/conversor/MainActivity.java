package es.uma.muii.apdm.conversor;

import android.content.Context;
import android.content.res.Resources;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int numButton[] = {R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9};
    private Button cButton;     // clear button
    private Button dButton;     // delete last digit button
    private Button convButton;  // convert button

    private Integer decNumber = 0;   // decimal number to convert

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupButtons();                                     // setups listener for buttons

        if (savedInstanceState != null) {
            decNumber = savedInstanceState.getInt("Dec");
            ((EditText)this.findViewById(R.id.editText2)).setText(savedInstanceState.getString("Out", "0"));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("Dec", decNumber);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private class myButtonListener implements Button.OnClickListener {  // listener for button or buttons
        @Override
        public void onClick(View v) {
            // clear button?
            if (cButton.getId() == v.getId()) {
                decNumber = 0;                              // set decimal number to 0
            } else if (dButton.getId() == v.getId()){
                decNumber /= 10;
            } else if (convButton.getId() == v.getId()){
                showConvertedNumber();
            } else
                number(v);

            showDecNumber();
        }
    }

    private void setupButtons() {
        // create listener for button/buttons
        myButtonListener mbl = new myButtonListener();
        // register buttons and listener for each button
        cButton = (Button) this.findViewById(R.id.buttonC);
        dButton = (Button) this.findViewById(R.id.buttonD);
        convButton = (Button) this.findViewById(R.id.convert);

        cButton.setOnClickListener(mbl);
        dButton.setOnClickListener(mbl);
        convButton.setOnClickListener(mbl);

        for (int i : numButton)
            this.findViewById(i).setOnClickListener(mbl);
    }

    public void number(View v){
        Button b = this.findViewById(v.getId());
        int numero = Integer.parseInt(b.getText().toString());

        if (decNumber <= Integer.MAX_VALUE / 10 - numero) {
            decNumber *= 10;
            decNumber += numero;
        }

        showDecNumber();
    }

    private void showDecNumber() {
        EditText decView = (EditText) this.findViewById(R.id.editText);  // get reference of decimal number view
        decView.setText(decNumber.toString());                  // set the value of view to the actual decimal number
    }

    private void showConvertedNumber() {
        EditText convertView = (EditText) this.findViewById(R.id.editText2);
        if (((RadioButton)this.findViewById(R.id.binaryRB)).isChecked())
            convertView.setText(Integer.toBinaryString(decNumber));
        else if (((RadioButton)this.findViewById(R.id.hexadecimalRB)).isChecked())
            convertView.setText(Integer.toHexString(decNumber));
        else if (((RadioButton)this.findViewById(R.id.octalRB)).isChecked())
            convertView.setText(Integer.toOctalString(decNumber));
    }
}
