package com.gap.release.calendar

import com.google.code.morphia.annotations.*
//import org.joda.time.DateTime
import org.bson.types.ObjectId

//@Entity(value="Day", noClassnameStored=true, cap=@CappedAt(count = 365L))
@Entity(value="Day", noClassnameStored=true)
class Day {
	
	//DateTime relCalDay
	Date relCalDay
	String release
	Integer iterationNumber
	Integer iterationDay
	ObjectId releaseId

    static constraints = {
    }
}
