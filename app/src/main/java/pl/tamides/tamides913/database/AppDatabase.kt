package pl.tamides.tamides913.database

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.tamides.tamides913.database.daos.Test1Dao
import pl.tamides.tamides913.database.daos.Test2Dao
import pl.tamides.tamides913.database.entities.Test1
import pl.tamides.tamides913.database.entities.Test2

@Database(
    entities = [
        Test1::class,
        Test2::class
    ], version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun test1Dao(): Test1Dao
    abstract fun test2Dao(): Test2Dao
}