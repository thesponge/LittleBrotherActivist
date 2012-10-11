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
import android.util.Log;
import android.view.View;
import android.widget.Button;

class UserData {
	boolean loggedIn;
	String username;
	String passwd;

	UserData() {
		loggedIn = false;
	}

	UserData(String username, String passwd) {
		this.username = username;
		this.passwd = passwd;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public String getUserName() {
		return username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void login() {
		loggedIn = true;
	}

	public void logout() {
		loggedIn = false;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public void clear(){
		username = "";
		passwd = "";
		logout();
	}
}

public class ActivistApplicationNameActivity extends Activity {
	/** Called when the activity is first created. */
	UserData user;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		user = new UserData();
		Button logout = (Button)findViewById(R.id.log_out_btn);
		logout.setVisibility(View.GONE);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == Activity.RESULT_OK) {
			user.setUsername(data.getStringExtra("username"));
			user.setPasswd(data.getStringExtra("password"));
			user.login();
			Button login_btn = (Button)findViewById(R.id.log_in_btn);
			login_btn.setVisibility(View.GONE);
			Button logout = (Button)findViewById(R.id.log_out_btn);
			logout.setVisibility(View.VISIBLE);
		}
	}

	public void onLogInButtonPressed(View v) {
		Log.v("msg", "Log i button pressed");
		Intent startNewActivityOpen = new Intent(
				ActivistApplicationNameActivity.this, LogInActivity.class);
		startActivityForResult(startNewActivityOpen, 0);

	}
	
	public void onLogOutPressed(View v){
		user.clear();
		Button login_btn = (Button)findViewById(R.id.log_in_btn);
		login_btn.setVisibility(View.VISIBLE);
		Button logout = (Button)findViewById(R.id.log_out_btn);
		logout.setVisibility(View.GONE);
	}

	public void onRegisterPush(View v) {
		Log.v("msg", "Register pushed");
		Intent startNewActivityOpen = new Intent(this, RegisterActivity.class);
		startActivityForResult(startNewActivityOpen, 0);
	}

	public void onQuickSendPush(View v) {
		Log.v("msg", "Quick send pushed");
		Intent startNewActivityOpen = new Intent(this, QuickSendActivity.class);
		startActivityForResult(startNewActivityOpen, 0);
	}

	public void onContactsPush(View v) {
		Log.v("msg", "Contacts pushed");
		Intent startNewActivityOpen = new Intent(
				ActivistApplicationNameActivity.this, ContactsActivity.class);
		startActivityForResult(startNewActivityOpen, 0);
	}

	public void onHelpPush(View v) {
		Log.v("msg", "Help pushed");
		Intent startNewActivityOpen = new Intent(
				ActivistApplicationNameActivity.this, HelpActivity.class);
		startActivityForResult(startNewActivityOpen, 0);
	}
}