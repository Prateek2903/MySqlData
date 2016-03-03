package com.example.mysqldata;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private int newVar = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final Button btn1 = (Button)findViewById(R.id.button1);
        final Button btn2 = (Button)findViewById(R.id.button2);
        
        btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				newVar++;
				Toast.makeText(getApplicationContext(), Integer.toString(newVar), Toast.LENGTH_SHORT
						).show();
				GlobalVar.getInstance().setMyVar(newVar);
			}
		});
        
        btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int recievedVar;
				recievedVar = GlobalVar.getInstance().getMyVar();
				Toast.makeText(getApplicationContext(), Integer.toString(recievedVar), Toast.LENGTH_SHORT).show();
			}
		});
    }
}
