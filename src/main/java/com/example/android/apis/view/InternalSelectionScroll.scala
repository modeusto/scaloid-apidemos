/*
 * Copyright (C) 2007 The Android Open Source Project
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
import android.view.ViewGroup
import android.widget.{FrameLayout, LinearLayout, ScrollView}

/**
 * Demonstrates how a well behaved view with internal selection
 * ({@link InternalSelectionView}) can cause its parent {@link android.widget.ScrollView}
 * to scroll to keep the internally interesting rectangle on the screen.
 *
 * {@link InternalSelectionView} achieves this by calling {@link android.view.View#requestRectangleOnScreen}
 * each time its internal selection changes.
 *
 * {@link android.widget.ScrollView}, in turn, implements {@link android.view.View#requestRectangleOnScreen}
 * thereby acheiving the result.  Note that {@link android.widget.ListView} also implements the
 * method, so views that call {@link android.view.View#requestRectangleOnScreen} that are embedded
 * within either {@link android.widget.ScrollView}s or {@link android.widget.ListView}s can
 * expect to keep their internal interesting rectangle visible.
 */
class InternalSelectionScroll extends Activity {
  protected override def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    val sv: ScrollView = new ScrollView(this)
    val svLp: ViewGroup.LayoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    val ll: LinearLayout = new LinearLayout(this)
    ll.setLayoutParams(svLp)
    sv.addView(ll)
    val isv: InternalSelectionView = new InternalSelectionView(this, 10)
    val screenHeight: Int = getWindowManager.getDefaultDisplay.getHeight
    val llLp: LinearLayout.LayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 2 * screenHeight)
    isv.setLayoutParams(llLp)
    ll.addView(isv)
    setContentView(sv)
  }
}