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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class QuickSendActivity extends Activity{
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quicksendlayout);
        setTypeSpinner();
        setResultSpinner();

    }
	public void setTypeSpinner(){
		String[] items = new String[] {"Physical violence", 
        		"Harassment", 
        		"Court hearing",
        		"Other"};
        Spinner spinner = (Spinner) findViewById(R.id.qspolicetype);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
	}

	public void setResultSpinner(){
		String[] items = new String[] {"Fines", 
        		"Arrests", 
        		"Released"};
        Spinner spinner = (Spinner) findViewById(R.id.qspoliceresults);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
	}
	
	public void onqsPhotoUploadPressed(View v){
		Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	    startActivityForResult(takePictureIntent, 0);
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == Activity.RESULT_OK) {
			Bundle extras = data.getExtras();
		    Bitmap mImageBitmap = (Bitmap) extras.get("data");
		    savePhoto(mImageBitmap);
		}
	}
	
	public void savePhoto(Bitmap photo){
		File appDir = new File("/sdcard/LittleBrother/");
        if(!appDir.exists()){
        	appDir.mkdirs();
        }
	        
		File sv = new File("/sdcard/LittleBrother/"+new SimpleDateFormat("yyyyMMDD_HHmmss").format(new Date()) + ".png");
		if(!sv.exists()){
			try{
				FileOutputStream fos = new FileOutputStream(sv);
				
				ByteArrayOutputStream stream = new ByteArrayOutputStream();
				photo.compress(Bitmap.CompressFormat.PNG, 100, stream);
				byte[] buffer = stream.toByteArray();
				fos.write(buffer);
				
				fos.close();
			}
			catch(Exception e){
				Log.v("Exception", "Output stream exception");
			}
		}
		else{
			Log.v("asas", "File does not exists");
		}
	}
}
