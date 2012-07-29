<%@ page import="com.gap.release.calendar.Day" %>



<div class="fieldcontain ${hasErrors(bean: dayInstance, field: 'releaseId', 'error')} required">
	<label for="releaseId">
		<g:message code="day.releaseId.label" default="Release Id" />
		<span class="required-indicator">*</span>
	</label>
	
</div>

<div class="fieldcontain ${hasErrors(bean: dayInstance, field: 'iterationDay', 'error')} required">
	<label for="iterationDay">
		<g:message code="day.iterationDay.label" default="Iteration Day" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="iterationDay" required="" value="${fieldValue(bean: dayInstance, field: 'iterationDay')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: dayInstance, field: 'iterationNumber', 'error')} required">
	<label for="iterationNumber">
		<g:message code="day.iterationNumber.label" default="Iteration Number" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="iterationNumber" required="" value="${fieldValue(bean: dayInstance, field: 'iterationNumber')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: dayInstance, field: 'releaseName', 'error')} ">
	<label for="releaseName">
		<g:message code="day.releaseName.label" default="Release Name" />
		
	</label>
	<g:textField name="releaseName" value="${dayInstance?.releaseName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: dayInstance, field: 'relCalDay', 'error')} required">
	<label for="relCalDay">
		<g:message code="day.relCalDay.label" default="Rel Cal Day" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="relCalDay" precision="day"  value="${dayInstance?.relCalDay}"  />
</div>

