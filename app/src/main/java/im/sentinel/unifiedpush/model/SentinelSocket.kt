package im.molly.unifiedpush.model

import android.net.Uri

sealed class SentinelSocket(val vapid: String) {

  class AirGapped(vapid: String) : SentinelSocket(vapid)
  class WebServer(vapid: String, val url: String) : SentinelSocket(vapid)

  companion object {
    fun parseLink(uri: Uri): SentinelSocket? {
      if (!uri.isHierarchical || uri.scheme != "sentinelsocket" || uri.authority != "link") {
        return null
      }
      val vapid = uri.getQueryParameter("vapid")
      if (vapid?.length != 87) {
        return null
      }
      val type = uri.getQueryParameter("type")
      return when (type) {
        "airgapped" -> {
          AirGapped(vapid)
        }

        "webserver" -> {
          val url = uri.getQueryParameter("url") ?: return null
          val parsedUrl = Uri.parse(url)
          if (parsedUrl.scheme != "https") return null
          WebServer(vapid = vapid, url = url)
        }

        else -> null
      }
    }
  }
}
