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
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LogInActivity extends Activity{
	UserData user;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlayout);
        user = new UserData();
    }
	
	public void onSendCredentials(View v){
		
		EditText username = (EditText)findViewById(R.id.user);
		EditText password = (EditText)findViewById(R.id.password);
		if(username.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
			return;
		}
		
		if(sendCredentials(username.getText().toString(), password.getText().toString())){
			user.setUsername(username.getText().toString());
			user.setPasswd(password.getText().toString());
			user.login();
			
			Intent result = new Intent();
			result.putExtra("username", user.getUserName());
			result.putExtra("password", user.getPasswd());
			result.putExtra("isloggedin", true);
			setResult(Activity.RESULT_OK, result);
			finish();
		}
	}
	public boolean sendCredentials(String username, String password){
		return true;
	}

}
