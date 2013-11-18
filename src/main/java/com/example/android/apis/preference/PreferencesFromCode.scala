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
package com.example.android.apis.preference

import com.example.android.apis.R
import android.content.Intent
import android.content.res.TypedArray
import android.net.Uri
import android.os.Bundle
import android.preference.CheckBoxPreference
import android.preference.EditTextPreference
import android.preference.ListPreference
import android.preference.PreferenceActivity
import android.preference.PreferenceCategory
import android.preference.PreferenceScreen

class PreferencesFromCode extends PreferenceActivity {
  protected override def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setPreferenceScreen(createPreferenceHierarchy)
  }

  private def createPreferenceHierarchy: PreferenceScreen = {
    val root: PreferenceScreen = getPreferenceManager.createPreferenceScreen(this)
    val inlinePrefCat: PreferenceCategory = new PreferenceCategory(this)
    inlinePrefCat.setTitle(R.string.inline_preferences)
    root.addPreference(inlinePrefCat)
    val checkboxPref: CheckBoxPreference = new CheckBoxPreference(this)
    checkboxPref.setKey("checkbox_preference")
    checkboxPref.setTitle(R.string.title_checkbox_preference)
    checkboxPref.setSummary(R.string.summary_checkbox_preference)
    inlinePrefCat.addPreference(checkboxPref)
    val switchPref: android.preference.SwitchPreference = new android.preference.SwitchPreference(this)
    switchPref.setKey("switch_preference")
    switchPref.setTitle(R.string.title_switch_preference)
    switchPref.setSummary(R.string.summary_switch_preference)
    inlinePrefCat.addPreference(switchPref)
    val dialogBasedPrefCat: PreferenceCategory = new PreferenceCategory(this)
    dialogBasedPrefCat.setTitle(R.string.dialog_based_preferences)
    root.addPreference(dialogBasedPrefCat)
    val editTextPref: EditTextPreference = new EditTextPreference(this)
    editTextPref.setDialogTitle(R.string.dialog_title_edittext_preference)
    editTextPref.setKey("edittext_preference")
    editTextPref.setTitle(R.string.title_edittext_preference)
    editTextPref.setSummary(R.string.summary_edittext_preference)
    dialogBasedPrefCat.addPreference(editTextPref)
    val listPref: ListPreference = new ListPreference(this)
    listPref.setEntries(R.array.entries_list_preference)
    listPref.setEntryValues(R.array.entryvalues_list_preference)
    listPref.setDialogTitle(R.string.dialog_title_list_preference)
    listPref.setKey("list_preference")
    listPref.setTitle(R.string.title_list_preference)
    listPref.setSummary(R.string.summary_list_preference)
    dialogBasedPrefCat.addPreference(listPref)
    val launchPrefCat: PreferenceCategory = new PreferenceCategory(this)
    launchPrefCat.setTitle(R.string.launch_preferences)
    root.addPreference(launchPrefCat)
    val screenPref: PreferenceScreen = getPreferenceManager.createPreferenceScreen(this)
    screenPref.setKey("screen_preference")
    screenPref.setTitle(R.string.title_screen_preference)
    screenPref.setSummary(R.string.summary_screen_preference)
    launchPrefCat.addPreference(screenPref)
    val nextScreenCheckBoxPref: CheckBoxPreference = new CheckBoxPreference(this)
    nextScreenCheckBoxPref.setKey("next_screen_toggle_preference")
    nextScreenCheckBoxPref.setTitle(R.string.title_next_screen_toggle_preference)
    nextScreenCheckBoxPref.setSummary(R.string.summary_next_screen_toggle_preference)
    screenPref.addPreference(nextScreenCheckBoxPref)
    val intentPref: PreferenceScreen = getPreferenceManager.createPreferenceScreen(this)
    intentPref.setIntent(new Intent().setAction(Intent.ACTION_VIEW).setData(Uri.parse("http://www.android.com")))
    intentPref.setTitle(R.string.title_intent_preference)
    intentPref.setSummary(R.string.summary_intent_preference)
    launchPrefCat.addPreference(intentPref)
    val prefAttrsCat: PreferenceCategory = new PreferenceCategory(this)
    prefAttrsCat.setTitle(R.string.preference_attributes)
    root.addPreference(prefAttrsCat)
    val parentCheckBoxPref: CheckBoxPreference = new CheckBoxPreference(this)
    parentCheckBoxPref.setTitle(R.string.title_parent_preference)
    parentCheckBoxPref.setSummary(R.string.summary_parent_preference)
    prefAttrsCat.addPreference(parentCheckBoxPref)
    val a: TypedArray = obtainStyledAttributes(R.styleable.TogglePrefAttrs)
    val childCheckBoxPref: CheckBoxPreference = new CheckBoxPreference(this)
    childCheckBoxPref.setTitle(R.string.title_child_preference)
    childCheckBoxPref.setSummary(R.string.summary_child_preference)
    childCheckBoxPref.setLayoutResource(a.getResourceId(R.styleable.TogglePrefAttrs_android_preferenceLayoutChild, 0))
    prefAttrsCat.addPreference(childCheckBoxPref)
    a.recycle
    return root
  }
}