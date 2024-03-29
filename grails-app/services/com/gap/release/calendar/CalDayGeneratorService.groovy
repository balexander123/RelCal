package com.gap.release.calendar

import org.joda.time.DateTime
import org.joda.time.Period

class CalDayGeneratorService {
	
    def generateDays(Release release) {		
		Integer totalDuration = 0
		DateTime nextReleaseDate = new DateTime(release.getStartDate())
		nextReleaseDate = nextReleaseDate.plus(Period.days(release.getRelDurationDays()*2))
		Date relCalDate = release.getStartDate()
		Integer iterationNumber = release.getIterationNumber()
		while (totalDuration < 365) {
			Integer relCnt = 0
		    while (relCnt < release.getRelDurationDays()) {
				String relName = nextReleaseDate.toString()
				relName = relName[2..3]
				def relMonth = nextReleaseDate.monthOfYear.toString().padLeft(2,'0')
				relName = relName + '.' + relMonth
		
				for (int iterationCnt=0; iterationCnt < release.getNumIterations(); iterationCnt++) {
					int itDay=1
					for (int iterationDays=0; iterationDays < (release.getRelDurationDays())/2; iterationDays++ ) {
						if ((relCalDate[Calendar.DAY_OF_WEEK] != Calendar.SATURDAY) &&
							(relCalDate[Calendar.DAY_OF_WEEK] != Calendar.SUNDAY)) {
								def day = new Day()
								day.iterationDay = itDay++
								day.iterationNumber = iterationNumber
								day.relCalDay = relCalDate
								day.release = relName
								day.releaseId = release.id
								day.save()
						}
						relCalDate = relCalDate + 1
						relCnt++
					}
					iterationNumber++
				}
		    }
		    totalDuration = totalDuration + release.getRelDurationDays()
			nextReleaseDate = nextReleaseDate.plus(Period.days(release.getRelDurationDays()))
		}
    }
}
