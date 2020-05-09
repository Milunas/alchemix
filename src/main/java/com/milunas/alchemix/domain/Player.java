package com.milunas.alchemix.domain;

import com.milunas.alchemix.common.Result;
import com.milunas.alchemix.external.Mission;

import java.util.Set;

class Player
{
    private final Set<Mission> unblockedMissions;

    private Player()
    {
        this.unblockedMissions = Set.of();
    }

    private Player(Set<Mission> unblockedMissions)
    {
        this.unblockedMissions = unblockedMissions;
    }

    static Player of()
    {
        return new Player();
    }

    Result form()
    {
        return Result.failure();
    }

    Result deform()
    {
        return Result.failure();
    }

    Result<SentOnMission> sendOn(Mission mission)
    {
        return Result.failure();
    }
}
