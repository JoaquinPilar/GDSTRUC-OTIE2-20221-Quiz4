package com.Quiz4;

import java.util.Objects;

// This is the storedplayer class
public class StoredPlayer
{
    public String key;
    public Player value;
    public StoredPlayer(String key, Player value)
    {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoredPlayer that = (StoredPlayer) o;
        return Objects.equals(key, that.key) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString()
    {
        return "StoredPlayer{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }
}