package com.milunas.alchemix.domain;

import com.milunas.alchemix.common.Result;

class Player
{
    private final Integer teamsLimit;

    private Player(Integer teamsLimit) {
        this.teamsLimit = teamsLimit;
    }

    static Player of(Integer teamsLimit)
    {
        return new Player(teamsLimit);
    }

    Result form()
    {
        return Result.failure();
    }

    Result sendOn(Mission mission)
    {
        return Result.failure();
    }
}
