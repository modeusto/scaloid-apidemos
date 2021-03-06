/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.apis.view

import android.app.Activity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.Toast
import com.example.android.apis.R

/**
 * Demonstrates the use of the toggle switch widget.
 */
class Switches extends Activity with CompoundButton.OnCheckedChangeListener {
  protected override def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.switches)
    val s: Switch = findViewById(R.id.monitored_switch).asInstanceOf[Switch]
    if (s != null) {
      s.setOnCheckedChangeListener(this)
    }
  }

  def onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
    Toast.makeText(this, "Monitored switch is " + (if (isChecked) "on" else "off"), Toast.LENGTH_SHORT).show
  }
}