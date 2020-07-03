package pl.tamides.tamides913.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class WatcherGuildLevel {
    @ColumnInfo(name = "Level")
    var level: Int? = null

    @ColumnInfo(name = "Exp")
    var exp: Double? = null

    @ColumnInfo(name = "ToNextLevelExp")
    var toNextLevelExp: Double? = null

    @PrimaryKey
    @ColumnInfo(name = "CreationDate")
    var creationDate: String = ""
}