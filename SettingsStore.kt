package com.example.eyecheck

import android.content.Context

class SettingsStore(context: Context) {
    private val prefs = context.getSharedPreferences("eyecheck_settings", Context.MODE_PRIVATE)

    fun setAzyterMode(enabled: Boolean) {
        prefs.edit().putBoolean("azyter_mode", enabled).apply()
    }

    fun azyterMode(): Boolean = prefs.getBoolean("azyter_mode", false)
}
