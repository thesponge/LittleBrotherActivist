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
import android.widget.TextView;

public class LicenceActivity extends Activity{
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.licencelayout);
		TextView licence_text = (TextView)findViewById(R.id.licence);
		String buffer = new String();
		buffer = "This program is free software; you can redistribute it\n"+
				"and/or modify it under the terms of the GNU General\n"+
				"Public License as published by the Free Software Foundation;\n"+
				"either version 2, or (at your option)\n"+
				"any later version.\n"+
				"\n"+
				"This program is distributed in the hope that it will be useful,\n"+
				"but WITHOUT ANY WARRANTY; without even the implied warranty of\n"+
				"MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\n"+
				"GNU General Public License for more details.\n";
		licence_text.setText(buffer);
    }
}
