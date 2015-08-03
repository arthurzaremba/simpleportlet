<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<portlet:defineObjects/>

<portlet:renderURL var="addCategoryUrl">
    <portlet:param name="action" value="renderAddCategory"/>
</portlet:renderURL>

<portlet:renderURL var="showLinksUrl">
    <portlet:param name="categoryId" value="cat_id"/>
    <portlet:param name="action" value="renderLinks"/>
</portlet:renderURL>

<portlet:renderURL var="addLinkUrl">
    <portlet:param name="categoryId" value="cat_id"/>
    <portlet:param name="action" value="renderAddLink"/>
</portlet:renderURL>

<div class="ct_headers">
    <c:forEach items="${categoriesList}" var="item">
        <c:choose>
            <c:when test="${item.id == selectedCategoryId}">
                <span class="ct_entity" style="background-color: lime">
                    <a href="${fn:replace(showLinksUrl, 'cat_id', item.id)}">${item.title}</a>
                </span>
            </c:when>
            <c:otherwise>
                <span class="ct_entity">
                    <a href="${fn:replace(showLinksUrl, 'cat_id', item.id)}">${item.title}</a>
                </span>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <span>
        <a href="${addCategoryUrl}">Add</a>
    </span>
</div>
<div class="ct_content">
    <div class="ct_links">
        <c:if test="${not empty selectedCategoryId}">
            <c:forEach items="${linksList}" var="item">
                <div class="ct_entity">
                    <a>${item.title}</a><br/>
                </div>
            </c:forEach>
            <a href="${fn:replace(addLinkUrl, 'cat_id', selectedCategoryId)}">Add link</a>
        </c:if>
    </div>
</div>
<div class="ct_pagination">
    padding
</div>