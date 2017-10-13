<#import "/spring.ftl" as spring/>
<html>
<body>


<h2> Search For Books by title</h2>


<form name="searchForm" action="/search" method="post">
    <label> Title:</label><input type="text" name="title" placeholder="Title"/>

    <input type="submit" value="Search">
</form>


<h2>${errorMessage!""}</h2>


<#if books??>
<h3>Retrieved books:</h3>
<select id="booksList" name="select">

    <#list books as book>
        <option value="${book.title}">${book.title}</option>
    </#list>
</select>
</#if>

</body>
</html>