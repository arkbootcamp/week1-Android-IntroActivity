package com.erdin.latihanandroidweek1.room

import androidx.room.*

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(word: WordRoomEntity)

    @Query("SELECT * FROM word_table ORDER BY name ASC")
    fun getAllWord(): List<WordRoomEntity>

    @Query("SELECT * FROM word_table WHERE id = :wordId")
    fun getWord(wordId: Int): WordRoomEntity

    @Update
    fun updateWord(word: WordRoomEntity)

    @Delete
    fun deleteWord(word: WordRoomEntity)

    @Query("DELETE FROM word_table")
    fun deleteAll()
}