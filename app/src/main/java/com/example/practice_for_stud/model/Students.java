package com.example.practice_for_stud.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity
public class Students implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String nameS;

    @ColumnInfo(name = "surname")
    public String surnameS;

    @ColumnInfo(name = "patronymic")
    public String patronymicS;

    @ColumnInfo(name = "timestamp")
    public long timestamp;

    public Students(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Students)) return false;
        Students students = (Students) o;
        return id == students.id &&
                timestamp == students.timestamp &&
                Objects.equals(nameS, students.nameS) &&
                Objects.equals(surnameS, students.surnameS) &&
                Objects.equals(patronymicS, students.patronymicS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameS, surnameS, patronymicS, timestamp);
    }

    protected Students(Parcel in) {
        id = in.readInt();
        nameS = in.readString();
        surnameS = in.readString();
        patronymicS = in.readString();
        timestamp = in.readLong();
    }

    public static final Creator<Students> CREATOR = new Creator<Students>() {
        @Override
        public Students createFromParcel(Parcel in) {
            return new Students(in);
        }

        @Override
        public Students[] newArray(int size) {
            return new Students[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nameS);
        dest.writeString(surnameS);
        dest.writeString(patronymicS);
        dest.writeLong(timestamp);
    }
}
