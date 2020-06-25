package pl.tamides.tamides913.database.daos

import androidx.room.Dao
import androidx.room.Insert
import pl.tamides.tamides913.database.entities.Test1

@Dao
interface Test1Dao {
    @Insert
    fun insert(item: Test1)
}