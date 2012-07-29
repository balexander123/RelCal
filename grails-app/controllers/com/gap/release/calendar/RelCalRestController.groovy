package com.gap.release.calendar

import grails.converters.JSON
import org.bson.types.ObjectId
import org.joda.time.*
import org.joda.time.format.*
import java.text.SimpleDateFormat

class RelCalRestController {
	
	def calDayGeneratorService

    def index() { }
	
	def list = {
		def relCalMap = [release:"12.08", iteration:"213", day:"2"]
		render relCalMap as JSON
	}
	
	def save = {
		def json = request.JSON
		
		def release = new Release()
		
		release.relDescription = json.release
		DateTimeFormatter parser = ISODateTimeFormat.dateTimeParser()
		DateTime startDate = parser.parseDateTime("2012-06-29T00:00:00-05:00")
		release.startDate = new SimpleDateFormat("yyyy-MM-dd").parse("2012-06-29")
		release.relDurationDays = json.duration.toInteger()
		release.numIterations = json.iterations.toInteger()
		release.iterationNumber = json.iterationNumber.toInteger()
		release.releaseFormat = json.releaseFormat
		//release.relName = release.startDate.toString()
		//release.relName = release.relName[26..27]
		//DateTime nextReleaseDate = startDate.plusDays(release.getRelDurationDays())
		//def relMonth = nextReleaseDate.monthOfYear.toString().padLeft(2,'0')
		//release.relName = release.relName + '.' + relMonth
		
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
