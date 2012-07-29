package com.gap.release.calendar

import com.google.code.morphia.annotations.*
import org.joda.time.DateTime

import com.gap.mongo.converters.DateTimeConverter

@Entity(value="Release", noClassnameStored=true)
//@Converters(DateTimeConverter.class)
class Release {
	
	String relDescription
	//String relName
	//@Embedded
	//DateTime startDate
	Date startDate
	Integer relDurationDays
	Integer numIterations
	Integer iterationNumber
	String releaseFormat

    static constraints = {
    }
}