package com.example.composition.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class GameSettings(
    val maxSumValue: Int,
    val minCountOfRightAnswers: Int,
    val minPercentOfRightAnswers: Int,
    val gameTimeInSeconds: Int
):Parcelable
//{

////    interface Parcelable быстрее по сравнению с Serializable
////    Реализацию можно с помощью плагина     id 'kotlin-parcelize'
//
////    тут мы считываем все поля из данного объекта
//    constructor(parcel: Parcel) : this(
//        parcel.readInt(),
//        parcel.readInt(),
//        parcel.readInt(),
//        parcel.readInt()
//    ) {
//    }
//// суть работы в том что мы сами в ручную записываем поля объекта в объект парсл
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        parcel.writeInt(maxSumValue)
//        parcel.writeInt(minCountOfRightAnswers)
//        parcel.writeInt(minPercentOfRightAnswers)
//        parcel.writeInt(gameTimeInSeconds)
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
////    просто вызывает наш конструктор в которой мы передаем наш конструктор
//    companion object CREATOR : Parcelable.Creator<GameSettings> {
//        override fun createFromParcel(parcel: Parcel): GameSettings {
//            return GameSettings(parcel)
//        }
//
//// описывает создание массива объектов game settings
//        override fun newArray(size: Int): Array<GameSettings?> {
//            return arrayOfNulls(size)
//        }
//    }
//}