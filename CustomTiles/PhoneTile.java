/*
 * Copyright (C) 2014 The Android Open Source Project
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

package com.android.systemui.qs.tiles;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import com.android.internal.logging.MetricsLogger;
import com.android.systemui.R;
import com.android.systemui.qs.QSTile;

import android.content.pm.PackageManager;

/** Quick settings tile: Phone Tile **/
public class PhoneTile extends QSTile<QSTile.BooleanState> {
    private final AnimationIcon mEnable =
            new AnimationIcon(R.drawable.ic_signal_airplane_enable_animation);
    private final AnimationIcon mDisable =
            new AnimationIcon(R.drawable.ic_signal_airplane_disable_animation);

    public PhoneTile(Host host) {
        super(host);
    }

    @Override
    protected BooleanState newTileState() {
        return new BooleanState();
    }

    @Override
    public void handleClick() {
        Intent i;
        PackageManager manager = mContext.getPackageManager();
        try {
            i = manager.getLaunchIntentForPackage("com.android.dialer");
            if (i == null) throw new PackageManager.NameNotFoundException();
            i.addCategory(Intent.CATEGORY_LAUNCHER);
            mContext.startActivity(i);
            mHost.collapsePanels();
        } catch (PackageManager.NameNotFoundException e) {
            // Do nothing
        }
    }

    private void setEnabled(boolean enabled) {
        final ConnectivityManager mgr =
                (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        mgr.setAirplaneMode(enabled);
    }

    @Override
    protected void handleUpdateState(BooleanState state, Object arg) {
        state.value = true;
        state.visible = true;
        state.label = "Phone";
        state.icon = mEnable;
        state.contentDescription =  mContext.getString(R.string.accessibility_quick_settings_phone);
    }

    @Override
    public int getMetricsCategory() {
        return MetricsLogger.QS_AIRPLANEMODE;
    }

    @Override
    protected String composeChangeAnnouncement() {
        if (mState.value) {
            return mContext.getString(R.string.accessibility_quick_settings_phone);
        } else {
            return mContext.getString(R.string.accessibility_quick_settings_phone);
        }
    }

    public void setListening(boolean listening) {
        return;
    }
}
