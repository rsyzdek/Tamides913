package pl.tamides.tamides913.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Test1 {
    @PrimaryKey(autoGenerate = true)
    var uid: Int? = null

    @ColumnInfo(name = "first_name")
    var firstName: String? = null
}