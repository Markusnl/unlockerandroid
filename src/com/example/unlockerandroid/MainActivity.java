package com.example.unlockerandroid;

import android.app.Activity;
import android.content.Context;
import android.hardware.ConsumerIrManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	ConsumerIrManager CIR;
	int freq;
	boolean poc;
	Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11,
			btn12, btn13, btn14, btn15, btn16, btn17;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		CIR = (ConsumerIrManager) getSystemService(Context.CONSUMER_IR_SERVICE);
		btn1 = (Button) findViewById(R.id.button1);
		btn1.setOnClickListener(sendIRcode);

		btn2 = (Button) findViewById(R.id.button2);
		btn2.setOnClickListener(sendIRcode);

		btn3 = (Button) findViewById(R.id.button3);
		btn3.setOnClickListener(sendIRcode);

		btn4 = (Button) findViewById(R.id.button4);
		btn4.setOnClickListener(sendIRcode);

		btn5 = (Button) findViewById(R.id.button5);
		btn5.setOnClickListener(sendIRcode);

		btn6 = (Button) findViewById(R.id.button6);
		btn6.setOnClickListener(sendIRcode);

		btn7 = (Button) findViewById(R.id.button7);
		btn7.setOnClickListener(sendIRcode);

		btn8 = (Button) findViewById(R.id.button8);
		btn8.setOnClickListener(sendIRcode);

		btn9 = (Button) findViewById(R.id.button9);
		btn9.setOnClickListener(sendIRcode);

		btn10 = (Button) findViewById(R.id.button10);
		btn10.setOnClickListener(sendIRcode);

		btn11 = (Button) findViewById(R.id.button11);
		btn11.setOnClickListener(sendIRcode);

		btn12 = (Button) findViewById(R.id.button12);
		btn12.setOnClickListener(sendIRcode);

		btn13 = (Button) findViewById(R.id.button13);
		btn13.setOnClickListener(sendIRcode);

		btn14 = (Button) findViewById(R.id.button14);
		btn14.setOnClickListener(sendIRcode);

		btn15 = (Button) findViewById(R.id.button15);
		btn15.setOnClickListener(sendIRcode);

		btn16 = (Button) findViewById(R.id.button16);
		btn16.setOnClickListener(sendIRcode);

		btn17 = (Button) findViewById(R.id.button17);
		btn17.setOnClickListener(sendIRcode);
		poc = false;

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private OnClickListener sendIRcode = new OnClickListener() {

		public void onClick(View v) {
			if (CIR.hasIrEmitter()) {
				if (v == btn1) {
					freq = 30000;
				} else if (v == btn2) {
					freq = 31000;
				} else if (v == btn3) {
					freq = 32000;
				} else if (v == btn4) {
					freq = 33000;
				} else if (v == btn5) {
					freq = 34000;
				} else if (v == btn6) {
					freq = 35000;
				} else if (v == btn7) {
					freq = 36000;
				} else if (v == btn8) {
					freq = 37000;
				} else if (v == btn9) {
					freq = 38000;
				} else if (v == btn10) {
					freq = 39000;
				} else if (v == btn11) {
					freq = 40000;
				} else if (v == btn12) {
					freq = 42000;
				} else if (v == btn13) {
					freq = 45000;
				} else if (v == btn14) {
					freq = 47000;
				} else if (v == btn15) {
					freq = 50000;
				} else if (v == btn16) {
					freq = 55000;
				} else if (v == btn17) {
					freq = 38000;
					poc = true;
				}
				// proof of concept tv
				int[] mod1 = { 335, 163, 24, 17, 24, 17, 24, 57, 24, 17, 24,
						17, 24, 17, 24, 17, 24, 17, 24, 57, 24, 57, 24, 17, 24,
						57, 24, 57, 24, 57, 24, 57, 24, 57, 24, 17, 24, 17, 24,
						17, 24, 57, 24, 17, 24, 17, 24, 17, 24, 17, 24, 57, 24,
						57, 24, 57, 24, 17, 24, 57, 24, 56, 26, 56, 24, 57, 24,
						3000 };

				// unlock signal
				int[] mod2 = { 5, 67, 5, 14, 2, 51, 5, 67, 5, 67, 5, 13, 3, 51,
						5, 67, 5, 67, 5, 67, 5, 13, 4, 49, 5, 67, 5, 67, 5, 14,
						2, 51, 5, 67, 5, 67, 5, 67, 5, 14, 2, 51, 5, 14, 3, 50,
						5, 67, 5, 13, 2, 51, 5, 67, 5, 67, 5, 13, 4, 49, 5, 13,
						3, 50, 5, 13, 3, 50, 5, 67, 5, 14, 3, 50, 5, 67, 5, 67,
						5, 13, 4, 49, 6, 66, 5, 67, 5, 67, 5, 13, 4, 49, 6, 66,
						5, 67, 5, 13, 4, 50, 5, 67, 5, 67, 5, 67, 5, 14, 3, 50,
						5, 13, 5, 49, 5, 67, 5, 13, 3, 50, 5, 67, 6, 66, 6, 13,
						3, 3000 };

				if (poc) {
					CIR.transmit(38000, mod1);
					poc = false;
				} else {
					CIR.transmit(freq, mod2);
				}

				Log.e("whoopwhhooppp", "greaaaatttt successss");
			} else {
				Log.e("IR ERROR", "Device has no IR Emitter :(");
			}
		}

	};

}
