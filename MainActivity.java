package com.example.mysqldata;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private int newVar = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final Button btn1 = (Button)findViewById(R.id.button1);
        final Button btn2 = (Button)findViewById(R.id.button2);
        final Button btn3 = (Button)findViewById(R.id.button3);
        
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
        
        btn3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog();
			}
		});
    }
    
    protected void showDialog(){
    	
//    	get the view
    	LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
    	View promptView = layoutInflater.inflate(R.layout.dialog_custom, null);
    	AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
    	alertDialogBuilder.setView(promptView);
    	
    	final EditText editText = (EditText)promptView.findViewById(R.id.edittext);
    	alertDialogBuilder.setCancelable(false)
    			.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int id) {
						// TODO Auto-generated method stub
						Toast.makeText(getApplicationContext(), editText.getText(), Toast.LENGTH_SHORT).show();
						
					}
				})
				.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int id) {
						// TODO Auto-generated method stub
						dialog.cancel();
					}
				});
    	
//    	create an alert dialog
    	AlertDialog alert = alertDialogBuilder.create();
    	alert.show();
    }
}





