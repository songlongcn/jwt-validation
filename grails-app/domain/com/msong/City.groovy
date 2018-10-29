package com.msong

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString(includeNames = true, includeFields = true, excludes = 'dateCreated,lastUpdated,metaClass')
@EqualsAndHashCode
class City {

    Long id
    Long version

    Date dateCreated
    Date lastUpdated

    String cityName
    String postalCode
    String countryCode

    static constraints = {
        postalCode blank: false, nullable: false
        cityName blank: false, nullable: false
        countryCode minSize:2, maxSize: 3, blank: false, nullable: false, matches: "[A-Z]+"
    }
}
