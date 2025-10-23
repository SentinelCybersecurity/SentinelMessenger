package org.thoughtcrime.securesms.jobmanager.impl;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import androidx.annotation.NonNull;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.signal.core.util.logging.Log;
import org.thoughtcrime.securesms.events.NetworkAvailableEvent;
import org.thoughtcrime.securesms.jobmanager.ConstraintObserver;

public class NetworkConstraintObserver implements ConstraintObserver {

  private static final String REASON = Log.tag(NetworkConstraintObserver.class);

  private final Application application;

  public NetworkConstraintObserver(Application application) {
    this.application = application;
  }

  @Override
  public void register(@NonNull Notifier notifier) {
    application.registerReceiver(new BroadcastReceiver() {
      @Override
      public void onReceive(Context context, Intent intent) {
        if (NetworkConstraint.isMet(application)) {
          notifier.onConstraintMet(REASON);
        }
      }
    }, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));

    EventBus.getDefault().register(new Object() {
      @Subscribe(threadMode = ThreadMode.MAIN)
      public void onNetworkReadyEvent(@NonNull NetworkAvailableEvent event) {
        if (NetworkConstraint.isMet(application)) {
          notifier.onConstraintMet(REASON);
        }
      }
    });
  }
}
