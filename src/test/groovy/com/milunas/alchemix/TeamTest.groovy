package com.milunas.alchemix

import com.milunas.alchemix.domain.Hero
import com.milunas.alchemix.domain.Team
import com.milunas.alchemix.external.Item
import com.milunas.alchemix.external.Mission
import spock.lang.Specification

class TeamTest extends Specification {

    def "should hire hero"() {
        when:
            def team = new Team()
            def hero = new Hero()
        then:
            team.hire(hero).isSuccessful()
    }

    def "shouldn't hire hero if team is full"() {
        given:
            def team = new Team()
            def firstHero = new Hero()
            def secondHero = new Hero()
        when:
            assert team.hire(firstHero).isSuccessful()
        then:
            team.hire(secondHero).isFailure()
    }

    def "should equip hero"() {
        given:
            def team = new Team()
            def item = new Item()
        and:
            def hero = new Hero()
        when:
            assert team.hire(hero).isSuccessful()
        then:
            team.equip(hero, item).isSuccessful()
    }

    def "shouldn't equip hero if he is not in team"() {
        when:
            def team = new Team()
            def item = new Item()
        and:
            def hero = new Hero()
        then:
            team.equip(hero, item).isFailure()
    }

    def "should send on mission"() {
        when:
            def team = new Team()
        and:
            def mission = new Mission()
        then:
            team.sendOn(mission).isSuccessful()
    }

    def "shouldn't send on mission if team is on another"() {
        given:
            def team = new Team()
        and:
            def firstMission = new Mission()
            def secondMission = new Mission()
        when:
            assert team.sendOn(firstMission).isSuccessful()
        then:
            team.sendOn(secondMission).isFailure()
    }
}
