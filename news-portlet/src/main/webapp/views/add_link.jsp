<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<portlet:defineObjects />

<portlet:renderURL var="returnUrl">
</portlet:renderURL>

<portlet:actionURL var="addNewLink">
  <portlet:param name="action" value="addNewLink" />
</portlet:actionURL>

<form action="${addNewLink}" method="post">
  <aui:input type="hidden" name="categoryId" value="${categoryId}"/>
  <aui:input type="text" name="title" label="Title of link"/><br/>
  <button type="submit">Add</button>
</form>

<a href="${returnUrl}">Return</a>