package com.ledpixelart.piledriver;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class preferences extends PreferenceActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);    
      
    }
}
