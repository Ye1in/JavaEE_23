<%@ page contentType="text/html;charset=gb2312" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script language=javascript>
<!-- ��JavaScriptʵ����֤���������Ϊ����-->
<!--
	function check(thisObject){
		var sTmp="";
		sTmp=thisObject.value;
		if(isNaN(sTmp)){
			alert("����������");
			thisObject.select();//����������֣��������ѡ��
		}
}
//-->
</script>
<link href="css/bookstore.css" rel="stylesheet" type="text/css">
<h1><span class="green14b">����չʾ</span></h1>
<br>
	<div class=info_bk1>
   <s:iterator value="#request['books']" id="book">
   <div class=xh5>
      <img  height=105 width=80 src="./picture/<s:property value="#book.picture"/>"/><BR>
      <s:property value="#book.bookname"/>
       <br>�۸�:<s:property value="#book.price"/>Ԫ<br>
       <form action="addToCart.action" method="post">
          ����:<input type="text" name="quantity" id="quantity" value="0" size="4" 
						onblur="check(this);"/>
          <input type="hidden" value="<s:property value="#book.bookid"/>" name="bookid">
          <input type="image" name="submit" src="./picture/buy.gif"/>
       </form>
    </div>
    </s:iterator>
 </div>
