package com.example.eyecheck

data class ScheduleItem(
    val id: String,
    val hour: Int,
    val minute: Int,
    val title: String,
    val detail: String,
    val enabledWhenAzyterMode: Boolean = true,
)

object Schedules {
    val weekday = listOf(
        ScheduleItem("0900-vismed", 9, 0, "Vismed", "Œil droit"),
        ScheduleItem("0905-paupieres", 9, 5, "Chaleur + massage + rinçage", "Œil droit"),
        ScheduleItem("0915-dacryo", 9, 15, "Dacryoserum", "2 yeux"),
        ScheduleItem("0920-azyter", 9, 20, "Azyter", "Œil droit · uniquement pendant les cures", enabledWhenAzyterMode = false),
        ScheduleItem("0925-dexa", 9, 25, "Dexafree", "2 yeux"),
        ScheduleItem("0935-sterdex", 9, 35, "Sterdex", "Œil droit"),
        ScheduleItem("0945-vismed", 9, 45, "Vismed", "Œil droit"),
        ScheduleItem("1130-vismed", 11, 30, "Vismed", "Œil droit"),
        ScheduleItem("1300-dacryo", 13, 0, "Dacryoserum", "2 yeux"),
        ScheduleItem("1305-vismed", 13, 5, "Vismed", "Œil droit"),
        ScheduleItem("1530-vismed", 15, 30, "Vismed", "Œil droit"),
        ScheduleItem("1730-vismed", 17, 30, "Vismed", "Œil droit"),
        ScheduleItem("1830-vismed", 18, 30, "Vismed", "Œil droit"),
        ScheduleItem("2130-paupieres", 21, 30, "Chaleur + massage + rinçage", "Œil droit"),
        ScheduleItem("2145-dacryo", 21, 45, "Dacryoserum", "2 yeux"),
        ScheduleItem("2150-dexa", 21, 50, "Dexafree", "2 yeux"),
        ScheduleItem("2200-sterdex", 22, 0, "Sterdex", "Œil droit"),
        ScheduleItem("2210-vismed", 22, 10, "Vismed", "Œil droit"),
        ScheduleItem("2310-hydramed", 23, 10, "Hydramed Night", "Œil droit ± gauche"),
    )

    val weekend = listOf(
        ScheduleItem("1000-vismed", 10, 0, "Vismed", "Œil droit"),
        ScheduleItem("1005-paupieres", 10, 5, "Chaleur + massage + rinçage", "Œil droit"),
        ScheduleItem("1015-dacryo", 10, 15, "Dacryoserum", "2 yeux"),
        ScheduleItem("1020-azyter", 10, 20, "Azyter", "Œil droit · uniquement pendant les cures", enabledWhenAzyterMode = false),
        ScheduleItem("1025-dexa", 10, 25, "Dexafree", "2 yeux"),
        ScheduleItem("1035-sterdex", 10, 35, "Sterdex", "Œil droit"),
        ScheduleItem("1045-vismed", 10, 45, "Vismed", "Œil droit"),
        ScheduleItem("1230-vismed", 12, 30, "Vismed", "Œil droit"),
        ScheduleItem("1400-dacryo", 14, 0, "Dacryoserum", "2 yeux"),
        ScheduleItem("1405-vismed", 14, 5, "Vismed", "Œil droit"),
        ScheduleItem("1630-vismed", 16, 30, "Vismed", "Œil droit"),
        ScheduleItem("1830-vismed", 18, 30, "Vismed", "Œil droit"),
        ScheduleItem("1930-vismed", 19, 30, "Vismed", "Œil droit"),
        ScheduleItem("2130-paupieres", 21, 30, "Chaleur + massage + rinçage", "Œil droit"),
        ScheduleItem("2145-dacryo", 21, 45, "Dacryoserum", "2 yeux"),
        ScheduleItem("2150-dexa", 21, 50, "Dexafree", "2 yeux"),
        ScheduleItem("2200-sterdex", 22, 0, "Sterdex", "Œil droit"),
        ScheduleItem("2210-vismed", 22, 10, "Vismed", "Œil droit"),
        ScheduleItem("2310-hydramed", 23, 10, "Hydramed Night", "Œil droit ± gauche"),
    )
}
