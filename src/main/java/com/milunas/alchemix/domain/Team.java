package com.milunas.alchemix.domain;

import com.milunas.alchemix.common.Result;
import com.milunas.alchemix.external.Item;
import com.milunas.alchemix.external.Mission;

class Team
{
    Result hire(Hero hero)
    {
        return Result.failure();
    }

    Result equip(Hero hero, Item item)
    {
        return Result.failure();
    }

    Result sendOn(Mission mission)
    {
        return Result.failure();
    }
}
