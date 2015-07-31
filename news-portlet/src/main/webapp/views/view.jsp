<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<portlet:defineObjects />

<portlet:actionURL var="submitSample">
	<portlet:param name="action" value="firstMethod"></portlet:param>
</portlet:actionURL>

<form action="${submitSample}" method="post">
	<aui:input type="text" name="number" id="number"/><br/>
	<button type="submit">Submit</button>
</form>



<portlet:actionURL var="submitSampleTra">
	<portlet:param name="action" value="addTrash"></portlet:param>
</portlet:actionURL>

<form action="${submitSampleTra}" method="post">
	<aui:input type="text" name="number" id="number"/><br/>
	<button type="submit">Submit</button>
</form>


Count of categories is <%= renderRequest.getAttribute("categoriesCount") %>