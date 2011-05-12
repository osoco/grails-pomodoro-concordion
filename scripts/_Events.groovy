import es.osoco.grails.plugins.concordion.ConcordionGrailsTestType
import org.codehaus.groovy.grails.test.support.GrailsTestMode


 
eventAllTestsStart = {
    phasesToRun << "concordion"
    // tryToLoadConcordionTestType()
}

def mode = new GrailsTestMode(autowire: true)
def concordionTestType = new ConcordionGrailsTestType('concordion', 'concordion', mode)
concordionTests = [ concordionTestType ]

tryToLoadConcordionTestType = {
    def testMode = new GrailsTestMode(autowire: true)
    tryToLoadTestType(
        'concordion', 
        'cocordion', 
        'es.osoco.grails.plugins.concordion.ConcordionGrailsTestType',
        testMode)
    println "concordionTests: ${concordionTests}"
}

tryToLoadTestType = { name, directory, typeClassName, testMode ->	
    def typeClass = softLoadClass(typeClassName)
    if (typeClass) {
        concordionTests << typeClass.newInstance(name, directory, testMode)
    }
}

softLoadClass = { className ->
    try {
        classLoader.loadClass(className)
    } catch (ClassNotFoundException e) {
        println "Error loading class $className required by Concordion Grails Plugin"
    }
}
 
concordionTestPhasePreparation = {
    functionalTestPhasePreparation()
}
concordionTestPhaseCleanUp = {
    functionalTestPhaseCleanUp()
}
