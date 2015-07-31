<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<portlet:defineObjects />

<portlet:renderURL var="returnUrl">
</portlet:renderURL>

<portlet:actionURL var="addNewUrl">
  <portlet:param name="action" value="addNewCategory" />
</portlet:actionURL>

<form action="${addNewUrl}" method="post">
  <aui:input type="text" name="title" label="Title of category"/><br/>
  <button type="submit">Add</button>
</form>

<a href="${returnUrl}">Return</a>