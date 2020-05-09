package com.milunas.alchemix

import com.milunas.alchemix.domain.Hero
import com.milunas.alchemix.external.Item
import spock.lang.Specification

class HeroTest extends Specification {

    def "should hire hero"() {
        when:
            def hero = new Hero()
        then:
            hero.hire().isSuccessful()
    }

    def "shouldn't hire hero if he's not free"() {
        given:
            def hero = new Hero()
        when:
            assert hero.hire().isSuccessful()
        then:
            hero.hire().isFailure()
    }

    def "should equip hero"() {
        when:
            def hero = new Hero()
        then:
            hero.equip().isSuccessful()
    }

    def "shouldn't equip hero if he is overloaded"() {
        given:
            def hero = new Hero()
            def firstItem = new Item()
            def secondItem = new Item()
        when:
            assert hero.equip(firstItem).isSuccessful()
        then:
            hero.equip(secondItem).isFailure()
    }
}
