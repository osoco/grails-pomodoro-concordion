import java.util.logging.Level

grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()

        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        mavenLocal()
        mavenCentral()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.13'

	test("org.codehaus.geb:geb-core:latest.release")
	test("org.seleniumhq.selenium:selenium-firefox-driver:2.0a7")
    }
}

// concordion.extensions = [ 
//    "org.concordion.ext.TimestampFormatterExtension", 
//    "org.concordion.ext.ScreenshotExtension", 
//    "org.concordion.ext.LoggingTooltipExtension" ]

concordion.extensionFactories = [ 
    "es.osoco.grails.plugins.concordion.extensions.ConfigurableScreenshotExtensionFactory",
    "es.osoco.grails.plugins.concordion.extensions.ConfigurableLoggingTooltipExtensionFactory" ]

concordion.screenshotExtensionFactoryConfiguration = {
    screenshotOnThrowable true
    screenshotOnAssertionFailure true
    screenshotOnAssertionSuccess true
    maxWidth 400
}

concordion.loggingTooltipExtensionFactoryConfiguration = {
    loggers "org.example.pomodoro.pages, selenium.events"
    level Level.FINE
    showConsoleLogging true
}