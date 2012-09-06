package com.gap.release.calendar

import grails.converters.JSON
import org.bson.types.ObjectId
import org.joda.time.*
import org.joda.time.format.*
import java.text.SimpleDateFormat
import com.google.code.morphia.Datastore

class RelCalRestController {
	
	def calDayGeneratorService
	def datastoreService

    def index() { }
	
	def list = {
		Datastore datastore = datastoreService.releaseCalendarDatastore()
		
		def List <Release> releaseList = datastore.find(Release.class).asList()
		render releaseList as JSON
	}
	
	def listRel = {
		Datastore datastore = datastoreService.releaseCalendarDatastore()
		
		def Release release = datastore.find(Release.class, "releaseName =", params.get("releaseID")).get()
		render release.encodeAsJSON()
	}
	
	def listDay = {
		Datastore datastore = datastoreService.releaseCalendarDatastore()
		
		Date calendarDate = new SimpleDateFormat("yyyy-MM-dd").parse(params.calDate)
		
		def Day day = datastore.find(Day.class, "relCalDay =", calendarDate).get()
		render day.encodeAsJSON()
	}
	
	def save = {
		def json = request.JSON
		
		def release = new Release()
		
		release.releaseName = json.releaseName
		release.releaseDesc = json.releaseDesc
		DateTimeFormatter parser = ISODateTimeFormat.dateTimeParser()
		DateTime startDate = parser.parseDateTime(json.startDate)
		release.startDate = new SimpleDateFormat("yyyy-MM-dd").parse(json.startDate)
		release.relDurationDays = json.duration.toInteger()
		release.numIterations = json.iterations.toInteger()
		release.iterationNumber = json.iterationNumber.toInteger()
		release.releaseFormat = json.releaseFormat
		
		if (release.save()) {
			calDayGeneratorService.generateDays(release)
			render contentType: "application/json", {
				// Return the ID of the new release
				['id' : release.id.toString()]
			}
		}
		else {
			render contentType: "application/json", {
				['status' : 'FAILED']
			}
		}
	}
}
