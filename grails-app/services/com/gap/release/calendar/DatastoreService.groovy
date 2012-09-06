package com.gap.release.calendar

import org.springframework.beans.BeansException
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware

import com.google.code.morphia.Datastore
import com.google.code.morphia.Morphia
import com.mongodb.Mongo

class DatastoreService implements ApplicationContextAware {

	def applicationContext
	
    Datastore releaseCalendarDatastore() {
		Mongo mongo = applicationContext.getBean("myRelCalMongo")
		Datastore datastore = new Morphia().createDatastore(mongo, "ReleaseCalendar")
		datastore.ensureCaps()
		return datastore
	}
	
	@Override
	public void setApplicationContext(ApplicationContext ctx)
	throws BeansException {
		applicationContext = ctx
	}
}