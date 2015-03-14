<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />

<portlet:renderURL var="returnToMainPage">
</portlet:renderURL>

<%=
    renderRequest.getAttribute("number")
%>
    *
<%=
    renderRequest.getAttribute("random")
%>
    =
<%=
 renderRequest.getAttribute("result")
%>

</br>
<a href="<%= returnToMainPage %>"> Do you want to try one more time? </a>