package im.molly.unifiedpush.components.settings.app.notifications

import im.molly.unifiedpush.model.SentinelSocketDevice
import im.molly.unifiedpush.model.RegistrationStatus

data class Distributor(
  val applicationId: String,
  val name: String,
)

data class UnifiedPushSettingsState(
  val airGapped: Boolean,
  val device: SentinelSocketDevice?,
  val aci: String?,
  val registrationStatus: RegistrationStatus,
  val distributors: List<Distributor>,
  val selected: Int,
  val selectedNotAck: Boolean,
  val endpoint: String?,
  val sentinelSocketUrl: String?,
)
