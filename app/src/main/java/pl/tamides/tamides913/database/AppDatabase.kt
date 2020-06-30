package pl.tamides.tamides913.database

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.tamides.tamides913.database.daos.*
import pl.tamides.tamides913.database.entities.*

@Database(
        entities = [
            CombatLevel::class,
            NecromancerLevel::class,
            HunterGuildLevel::class,
            LaborerGuildLevel::class,
            RangerGuildLevel::class,
            MercenaryGuildLevel::class,
            WatcherGuildLevel::class,
            LeaderGuildLevel::class
        ], version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun combatLevelDao(): CombatLevelDao
    abstract fun necromancerLevelDao(): NecromancerLevelDao
    abstract fun hunterGuildLevelDao(): HunterGuildLevelDao
    abstract fun laborerGuildLevelDao(): LaborerGuildLevelDao
    abstract fun rangerGuildLevelDao(): RangerGuildLevelDao
    abstract fun mercenaryGuildLevelDao(): MercenaryGuildLevelDao
    abstract fun watcherGuildLevelDao(): WatcherGuildLevelDao
    abstract fun leaderGuildLevelDao(): LeaderGuildLevelDao
}