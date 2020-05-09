package com.milunas.alchemix

import com.milunas.alchemix.domain.Player
import com.milunas.alchemix.external.Mission
import spock.lang.Specification

class PlayerTest extends Specification {

    def "should form a team"() {
        when:
            def player = new Player()
        then:
            player.form().isSuccessful()
    }

    def "should deform a formed team"() {
        given:
            def player = new Player()
        when:
            assert player.form().isSuccessful()
        then:
            player.deform().isFailure()
    }

    def "shouldn't form team if already has one"() {
        given:
            def player = new Player()
        when:
            assert player.form().isSuccessful()
        then:
            player.form().isFailure()
    }

    def "should send team on mission" () {
        given:
            def player = new Player()
        and:
            def mission = new Mission()
        when:
            assert player.form().isSuccessful()
        then:
            player.sendOn(mission).isSuccessful()
    }

    def "shouldn't send on mission when no team is formed" () {
        when:
            def mission = new Mission()
            def unblockedMissions = Set.of(mission)
        and:
            def player = new Player(unblockedMissions)
        then:
            player.sendOn(mission).isFailure()
    }

    def "shouldn't send on not unblocked mission" () {
        given:
            def player = new Player()
        and:
            def mission = new Mission()
        when:
            assert player.form().isSuccessful()
        then:
            player.sendOn(mission).isFailure()
    }
}
