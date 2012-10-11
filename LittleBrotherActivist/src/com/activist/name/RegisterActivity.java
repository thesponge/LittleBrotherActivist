/* ============================================================
 *
 * This file is a part of TODO Project
 * http://http://whcomputing.wikispaces.com/
 *
 * Date        :
 * Description :
 *
 * Copyright (C) Cosmin Mihai <yonutix.mc@gmail.com>
 * 				 Octavian Moraru <tavah89@gmail.com>
 * 				 
 *
 * This program is free software; you can redistribute it
 * and/or modify it under the terms of the GNU General
 * Public License as published by the Free Software Foundation;
 * either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * ============================================================ */

package com.activist.name;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity{
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerlayout);
    }
	public void onRegisterSendCredentials(View v){
		Log.v("register", "pressed");
		if(!checkContent()){
			return;
		}
		
		if(register()){
			finish();
		}
		else{
			Toast.makeText(getApplicationContext(), "Could not register!", Toast.LENGTH_LONG).show();
		}
	}
	
	public boolean checkContent(){
		EditText username = (EditText)findViewById(R.id.registeruser);
		if(username.getText().toString().length() < 5){
			Toast.makeText(getApplicationContext(), "Username field is too short", Toast.LENGTH_LONG).show();
			return false;
		}
		
		EditText email = (EditText)findViewById(R.id.registeremail);
		if(email.getText().toString().length() < 4){
			Toast.makeText(getApplicationContext(), "Email field can not be validate", Toast.LENGTH_LONG).show();
			return false;
		}
		
		EditText password = (EditText)findViewById(R.id.registerpassword);
		if(password.getText().toString().length() < 4){
			Toast.makeText(getApplicationContext(), "Password field is too short", Toast.LENGTH_LONG).show();
			return false;
		}
		
		EditText confirmpassword = (EditText)findViewById(R.id.registerpasswordconfirm);
		if(confirmpassword.getText().toString().compareTo(password.getText().toString()) == 0){
			Toast.makeText(getApplicationContext(), "Mismatch password", Toast.LENGTH_LONG).show();
			return false;
		}
		
		EditText firstname = (EditText)findViewById(R.id.firstname);
		if(firstname.getText().toString().length() < 4){
			Toast.makeText(getApplicationContext(), "First name too short", Toast.LENGTH_LONG).show();
			return false;
		}
		
		EditText lastname = (EditText)findViewById(R.id.lastname);
		if(lastname.getText().toString().length() < 4){
			Toast.makeText(getApplicationContext(), "Last name is too short", Toast.LENGTH_LONG).show();
			return false;
		}
		
		EditText organization = (EditText)findViewById(R.id.organization);
		if(organization.getText().toString().length() < 4){
			Toast.makeText(getApplicationContext(), "Organization name is too short", Toast.LENGTH_LONG).show();
			return false;
		}

		return true;
	}
	
	public boolean register(){
		
		return false;
	}
}
