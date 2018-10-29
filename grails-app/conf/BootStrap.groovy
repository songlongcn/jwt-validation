import com.msong.City
import grails.util.Environment

class BootStrap {

    def init = { servletContext ->
        def result = ' ############ running in unclear mode'
        println "Application starting ... "
        switch (Environment.current) {
            case {Environment.DEVELOPMENT}:
                result = 'now running in  Dev mode'
                seedTestData()
                break
            case Environment.TEST:
                result = "now running in TEST mode"
                seedTestData()
                break
            case Environment.PRODUCTION:
                result = "now running in PROD mode."
                seedTestData()
                break
        }
        println "current environment: $Environment.current"
        println "$result"
    }

    def destroy = {
        println "Application shutting down ..."
    }

    private void seedTestData(){
        def city = null
        println 'staring loading cities into database'
        city = new City(cityName: 'Munich', postalCode: "81927", countryCode: 'DE' )
        assert city.save(failOnError:true, flush: true, insert: true)
        city.errors = null

        city = new City(cityName: 'Berlin', postalCode: "10115", countryCode: 'DE')
        assert city.save(failOnError: true, flush:true, insert: true)
        city.errors = null

        assert City.count == 2;
        println "Finished loading $City.count cities into database"
    }
}
