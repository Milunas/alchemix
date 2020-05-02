package com.milunas.alchemix

import com.milunas.alchemix.domain.Player
import spock.lang.Specification

class PlayerTest extends Specification {

    def "player should form a team"() {
        when:
            def player = Player.of(1)
        then:
            player.form().isSuccessful()
    }

    def "player shouldn't form more teams then his limit is"() {
        given:
            def player = new Player(1)
        when:
            assert player.form().isSuccessful()
        then:
            player.form().isFailure()
    }

    def "player should send team on mission" () {}

    def "shouldn't send team on a not unblocked mission" () {}
}
