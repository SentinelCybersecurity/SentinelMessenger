package org.thoughtcrime.securesms.keyvalue

import im.molly.unifiedpush.model.SentinelSocketDevice
import im.molly.unifiedpush.model.RegistrationStatus
import org.signal.core.util.logging.Log

class UnifiedPushValues(store: KeyValueStore) : SignalStoreValues(store) {

  companion object {
    private val TAG = Log.tag(UnifiedPushValues::class)

    private const val SENTINELSOCKET_DEVICE_ID = "sentinelsocket.deviceId"
    private const val SENTINELSOCKET_PASSWORD = "sentinelsocket.passwd"
    private const val SENTINELSOCKET_STATUS = "sentinelsocket.status"
    private const val SENTINELSOCKET_AIR_GAPPED = "sentinelsocket.airGapped"
    private const val SENTINELSOCKET_URL = "sentinelsocket.url"
    private const val SENTINELSOCKET_VAPID = "sentinelsocket.vapid"
    private const val UNIFIEDPUSH_ENABLED = "up.enabled"
    private const val UNIFIEDPUSH_ENDPOINT = "up.endpoint"
    private const val UNIFIEDPUSH_LAST_RECEIVED_TIME = "up.lastRecvTime"
  }

  override fun onFirstEverAppLaunch() = Unit

  override fun getKeysToIncludeInBackup() = emptyList<String>()

  @get:JvmName("isEnabled")
  var enabled: Boolean by booleanValue(UNIFIEDPUSH_ENABLED, false)

  var device: SentinelSocketDevice?
    get() {
      return SentinelSocketDevice(
        deviceId = getInteger(SENTINELSOCKET_DEVICE_ID, 0),
        password = getString(SENTINELSOCKET_PASSWORD, null) ?: return null,
      )
    }
    set(device) {
      store.beginWrite()
        .putInteger(SENTINELSOCKET_DEVICE_ID, device?.deviceId ?: 0)
        .putString(SENTINELSOCKET_PASSWORD, device?.password)
        .apply()
    }

  fun isSentinelSocketDevice(deviceId: Int): Boolean =
    deviceId != 0 && getInteger(SENTINELSOCKET_DEVICE_ID, 0) == deviceId

  var registrationStatus: RegistrationStatus
    get() = RegistrationStatus.fromValue(getInteger(SENTINELSOCKET_STATUS, -1)) ?: RegistrationStatus.UNKNOWN
    set(status) {
      putInteger(SENTINELSOCKET_STATUS, status.value)
    }

  var endpoint: String? by stringValue(UNIFIEDPUSH_ENDPOINT, null)

  var airGapped: Boolean by booleanValue(SENTINELSOCKET_AIR_GAPPED, false)

  var sentinelSocketUrl: String? by stringValue(SENTINELSOCKET_URL, null)

  var sentinelSocketVapid: String? by stringValue(SENTINELSOCKET_VAPID, null)

  var lastReceivedTime: Long by longValue(UNIFIEDPUSH_LAST_RECEIVED_TIME, 0)

  val isAvailableOrAirGapped: Boolean
    get() = enabled && registrationStatus == RegistrationStatus.REGISTERED
}
