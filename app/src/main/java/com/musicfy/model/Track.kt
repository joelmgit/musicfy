package com.musicfy.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName="track")
data class Track(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name="trackName")
    val trackName: String,
    @ColumnInfo(name="author")
    val author: String?,
    @ColumnInfo(name="album")
    val album: String?,
    @ColumnInfo(name="duration")
    val duration: String?,
    @ColumnInfo(name="trackAudioSource")
    val trackAudioSource: String?,
    @ColumnInfo(name="trackImageCoverSource")
    val trackImageCoverSource: String?
) : Parcelable