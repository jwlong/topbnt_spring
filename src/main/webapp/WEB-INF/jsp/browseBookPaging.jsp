<%@ page contentType="text/html;charset=gb2312" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
>
<html>
<head>
	<title>�������</title>
	<link href="css/bookstore.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<jsp:include page="head.jsp"/>
	<div class="content">
		<div class="left">
			<div class="list_box">
				<div class="list_bk">
					<s:action name="browseCatalog" executeResult="true"/>
				</div>
			</div>
		</div>
		<div class="right">
			<div class="right_box">
				<s:iterator value="#request['books']" id="book">
					<table width="600" border="0">
						<tr>
							<td width="200" align="center">
								<img src="/bookstore/picture/<s:property value="#book.picture"/>" width="100"/>
							</td>
							<td valign="top" width="400">
								<table>
									<tr>
										<td>
											����:<s:property value="#book.bookname"/><br>
										</td>
									</tr>
									<tr>
										<td>
											�۸�:<s:property value="#book.price"/>Ԫ
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<form action="addToCart.action" method="post">
												����:
												<input type="text" name="quantity" value="0" size="4"/>
												<input type="hidden" name="bookid" value="<s:property value="#book.bookid"/>">
												<input type="image" name="submit" src="/bookstore/picture/buy.gif"/>
											</form>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</s:iterator>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<s:set name="pager" value="#request.pager"/>
				<s:if test="#pager.hasFirst">
					<a href="browseBookPaging.action?currentPage=1">��ҳ</a>
				</s:if>
				<s:if test="#pager.hasPrevious">
					<a href="browseBookPaging.action?currentPage=<s:property value="#pager.currentPage-1"/>">
						��һҳ
					</a>
				</s:if>
				<s:if test="#pager.hasNext">
					<a href="browseBookPaging.action?currentPage=<s:property value="#pager.currentPage+1"/>">
						��һҳ
					</a>
				</s:if>
				<s:if test="#pager.hasLast">
					<a href="browseBookPaging.action?currentPage=<s:property value="#pager.totalPage"/>">
						βҳ
					</a>
				</s:if>
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				��ǰ��<s:property value="#pager.currentPage"/>ҳ���ܹ�<s:property value="#pager.totalPage"/>ҳ
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp"/>
</body>
</html>
