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
import android.widget.TextView;

public class HelpActivity extends Activity{
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helplayout);
    }
	
	public void onLicencePressed(View v){
		Intent startNewActivityOpen = new Intent(this, LicenceActivity.class);
		startActivityForResult(startNewActivityOpen, 0);
	}
}
