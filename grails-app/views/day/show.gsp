
<%@ page import="com.gap.release.calendar.Day" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'day.label', default: 'Day')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-day" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-day" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list day">
			
				<g:if test="${dayInstance?.releaseId}">
				<li class="fieldcontain">
					<span id="releaseId-label" class="property-label"><g:message code="day.releaseId.label" default="Release Id" /></span>
					
						<span class="property-value" aria-labelledby="releaseId-label"><g:fieldValue bean="${dayInstance}" field="releaseId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${dayInstance?.iterationDay}">
				<li class="fieldcontain">
					<span id="iterationDay-label" class="property-label"><g:message code="day.iterationDay.label" default="Iteration Day" /></span>
					
						<span class="property-value" aria-labelledby="iterationDay-label"><g:fieldValue bean="${dayInstance}" field="iterationDay"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${dayInstance?.iterationNumber}">
				<li class="fieldcontain">
					<span id="iterationNumber-label" class="property-label"><g:message code="day.iterationNumber.label" default="Iteration Number" /></span>
					
						<span class="property-value" aria-labelledby="iterationNumber-label"><g:fieldValue bean="${dayInstance}" field="iterationNumber"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${dayInstance?.relCalDay}">
				<li class="fieldcontain">
					<span id="relCalDay-label" class="property-label"><g:message code="day.relCalDay.label" default="Rel Cal Day" /></span>
					
						<span class="property-value" aria-labelledby="relCalDay-label"><g:formatDate date="${dayInstance?.relCalDay}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${dayInstance?.release}">
				<li class="fieldcontain">
					<span id="release-label" class="property-label"><g:message code="day.release.label" default="Release" /></span>
					
						<span class="property-value" aria-labelledby="release-label"><g:fieldValue bean="${dayInstance}" field="release"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${dayInstance?.id}" />
					<g:link class="edit" action="edit" id="${dayInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
