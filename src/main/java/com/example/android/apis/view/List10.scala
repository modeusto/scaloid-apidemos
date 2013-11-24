/*
 * Copyright (C) 2008 The Android Open Source Project
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

import android.app.ListActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class List10 extends ListActivity {
  // Scaloid >>
  val ListView_CHOICE_MODE_SINGLE = android.widget.AbsListView.CHOICE_MODE_SINGLE
  // Scaloid <<

  private final val GENRES: Array[String] = Array[String]("Action", "Adventure", "Animation", "Children", "Comedy", "Documentary", "Drama", "Foreign", "History", "Independent", "Romance", "Sci-Fi", "Television", "Thriller")

  override def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setListAdapter(new ArrayAdapter[String](this, android.R.layout.simple_list_item_single_choice, GENRES))
    val listView: ListView = getListView
    listView.setItemsCanFocus(false)
    listView.setChoiceMode(ListView_CHOICE_MODE_SINGLE)
  }
}