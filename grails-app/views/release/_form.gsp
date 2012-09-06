<%@ page import="com.gap.release.calendar.Release" %>



<div class="fieldcontain ${hasErrors(bean: releaseInstance, field: 'startDate', 'error')} required">
	<label for="startDate">
		<g:message code="release.startDate.label" default="Start Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="startDate" precision="day"  value="${releaseInstance?.startDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: releaseInstance, field: 'releaseFormat', 'error')} ">
	<label for="releaseFormat">
		<g:message code="release.releaseFormat.label" default="Release Format" />
		
	</label>
	<g:textField name="releaseFormat" value="${releaseInstance?.releaseFormat}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: releaseInstance, field: 'releaseDesc', 'error')} ">
	<label for="releaseDesc">
		<g:message code="release.releaseDesc.label" default="Release Desc" />
		
	</label>
	<g:textField name="releaseDesc" value="${releaseInstance?.releaseDesc}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: releaseInstance, field: 'iterationNumber', 'error')} required">
	<label for="iterationNumber">
		<g:message code="release.iterationNumber.label" default="Iteration Number" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="iterationNumber" required="" value="${fieldValue(bean: releaseInstance, field: 'iterationNumber')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: releaseInstance, field: 'numIterations', 'error')} required">
	<label for="numIterations">
		<g:message code="release.numIterations.label" default="Num Iterations" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="numIterations" required="" value="${fieldValue(bean: releaseInstance, field: 'numIterations')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: releaseInstance, field: 'releaseName', 'error')} ">
	<label for="releaseName">
		<g:message code="release.releaseName.label" default="Release Name" />
		
	</label>
	<g:textField name="releaseName" value="${releaseInstance?.releaseName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: releaseInstance, field: 'relDurationDays', 'error')} required">
	<label for="relDurationDays">
		<g:message code="release.relDurationDays.label" default="Rel Duration Days" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="relDurationDays" required="" value="${fieldValue(bean: releaseInstance, field: 'relDurationDays')}"/>
</div>

