/*
 * Ghost torch Madafucckas!!!!
 */

package com.android.systemui.qs.tiles;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.UserHandle;
import android.view.View;

import com.android.systemui.R;
import com.android.systemui.qs.QSTile;
import com.android.systemui.qs.QSTileView;
import com.android.internal.logging.MetricsLogger;

/** Quick settings tile: GhostTorch **/
public class GhostTorchTile extends QSTile<QSTile.BooleanState> {
        private static final Intent APP_TORCH_TILE = new Intent().setComponent(new ComponentName(
            "net.cactii.flash2", "net.cactii.flash2.TOGGLE_FLASHLIGHT"));

    public GhostTorchTile(Host host) {
        super(host);
    }

    @Override
    protected void handleDestroy() {
        super.handleDestroy();
    }
   @Override
    public int getMetricsCategory() {
        return MetricsLogger.DONT_TRACK_ME_BRO;
    }

    @Override
    protected BooleanState newTileState() {
        return new BooleanState();
    }

    @Override
    public void setListening(boolean listening) {
    }

    @Override
    protected void handleClick() {
        Intent i = new Intent("net.cactii.flash2.TOGGLE_FLASHLIGHT");
        mContext.sendBroadcast(i);
        //mHost.startActivityDismissingKeyguard(APP_TORCH_TILE);
    }

    @Override
    protected void handleUpdateState(BooleanState state, Object arg) {
        state.visible = true;
        state.label = mContext.getString(R.string.quick_settings_ghost_flashlight_label);
        state.icon = ResourceIcon.get(R.drawable.ic_qs_ghost_flashlight_on);
    }
}
