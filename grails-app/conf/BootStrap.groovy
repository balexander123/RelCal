import grails.converters.JSON
class BootStrap {

   def init = { servletContext ->
      String VCAP_SERVICES = System.getenv('VCAP_SERVICES')
      println "VCAP_SERVICES: ${System.getenv('VCAP_SERVICES')}"

      try {
         def servicesMap = JSON.parse(VCAP_SERVICES)
         servicesMap.each { key, services ->
            if (key.startsWith('mongodb')) {
               for (service in services) {
                  print "mongodb service $service.name: "
                  print "host='$service.credentials.hostname:$service.credentials.port', "
                  print "user='$service.credentials.user', "
                  println "password='$service.credentials.password'n"
               }
            }
         }
      }
      catch (e) {
         println "Error occurred parsing VCAP_SERVICES: $e.message"
      }
   }
}
