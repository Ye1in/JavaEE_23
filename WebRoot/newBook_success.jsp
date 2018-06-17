<%@ page contentType="text/html;charset=gb2312" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script language=javascript>
<!-- 用JavaScript实现验证，输入必须为数字-->
<!--
	function check(thisObject){
		var sTmp="";
		sTmp=thisObject.value;
		if(isNaN(sTmp)){
			alert("请输入数字");
			thisObject.select();//如果不是数字，该输入框被选中
		}
}
//-->
</script>
<link href="css/bookstore.css" rel="stylesheet" type="text/css">
<h1><span class="green14b">新书展示</span></h1>
<br>
	<div class=info_bk1>
   <s:iterator value="#request['books']" id="book">
   <div class=xh5>
      <img  height=105 width=80 src="./picture/<s:property value="#book.picture"/>"/><BR>
      <s:property value="#book.bookname"/>
       <br>价格:<s:property value="#book.price"/>元<br>
       <form action="addToCart.action" method="post">
          数量:<input type="text" name="quantity" id="quantity" value="0" size="4" 
						onblur="check(this);"/>
          <input type="hidden" value="<s:property value="#book.bookid"/>" name="bookid">
          <input type="image" name="submit" src="./picture/buy.gif"/>
       </form>
    </div>
    </s:iterator>
 </div>
