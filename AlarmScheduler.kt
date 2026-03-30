package com.example.eyecheck

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import java.util.Calendar

class AlarmScheduler(private val context: Context) {
    private val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

    fun scheduleAll(azyterMode: Boolean) {
        cancelAll()
        listOf(Schedules.weekday, Schedules.weekend).forEach { schedule ->
            schedule
                .filter { azyterMode || it.enabledWhenAzyterMode }
                .forEach { item -> scheduleExact(item) }
        }
    }

    fun cancelAll() {
        (Schedules.weekday + Schedules.weekend).forEach { item ->
            alarmManager.cancel(alarmPendingIntent(item))
        }
    }

    private fun scheduleExact(item: ScheduleItem) {
        val triggerAt = nextTriggerMillis(item)
        val pi = alarmPendingIntent(item)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, triggerAt, pi)
        } else {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, triggerAt, pi)
        }
    }

    private fun nextTriggerMillis(item: ScheduleItem): Long {
        val now = Calendar.getInstance()
        val cal = Calendar.getInstance().apply {
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
            set(Calendar.HOUR_OF_DAY, item.hour)
            set(Calendar.MINUTE, item.minute)
        }

        // weekday items fire Mon-Fri, weekend items Sat-Sun
        val targetWeekend = Schedules.weekend.any { it.id == item.id }
        while (true) {
            val day = cal.get(Calendar.DAY_OF_WEEK)
            val isWeekend = day == Calendar.SATURDAY || day == Calendar.SUNDAY
            val dayMatches = if (targetWeekend) isWeekend else !isWeekend
            val isFuture = cal.after(now)
            if (dayMatches && isFuture) return cal.timeInMillis
            cal.add(Calendar.DAY_OF_MONTH, 1)
        }
    }

    private fun alarmPendingIntent(item: ScheduleItem): PendingIntent {
        val intent = Intent(context, ReminderReceiver::class.java).apply {
            action = ReminderReceiver.ACTION_REMINDER
            putExtra(ReminderReceiver.EXTRA_ID, item.id)
            putExtra(ReminderReceiver.EXTRA_TITLE, item.title)
            putExtra(ReminderReceiver.EXTRA_DETAIL, item.detail)
        }
        return PendingIntent.getBroadcast(
            context,
            item.id.hashCode(),
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
        )
    }
}
