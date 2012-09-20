<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
A:link {
    color: #000000;
    text-decoration: none;
}
A:visited {
    color: #000000;
    text-decoration: none;
}
A:hover {
    color: #333333;
    text-decoration: underline;}
.STYLE22{
	font-size:12px;
	color:#295568;
}
</style>
  </head>
  
  <body>
   <table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="30" bgcolor="#353c44" colspan="4">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr><td><span style="color:#E1E2E3 ;font-size:12px">账户详细信息列表</span></td></tr>
					</table>
				</td>
			</tr>
						<tr  style="font-size:12px;font-weight:bold;color:#000000">
							<td width="20%" height="20" bgcolor="d3eaef" class="STYLE10">
								<div align="center">
									编号
								</div>
							</td>
							<td  width="30%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">时间</span>
								</div>
							</td>
							<td  width="25%" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">操作类型</span>
								</div>
							</td>
							<td  width="25%" height="20" bgcolor="d3eaef" class="STYLE6">
								<div align="center">
									<span class="STYLE10">金额</span>
								</div>
							</td>
						</tr>
			<c:forEach items="${list }" var="one" varStatus="status">
							<tr
								<c:choose>
				<c:when test="${status.count%2==0}">bgcolor="#ede8e8"</c:when>
				<c:otherwise>bgcolor="#ffffff"</c:otherwise></c:choose>>
								<td  height="20" class="STYLE19">
									<div align="center">
										${status.count }
									</div>
								</td>
								<td height="20" class="STYLE19">
									<div align="center">
										<span class="STYLE19"> ${one.otime }</span>
									</div>
								</td>
								<td height="20" class="STYLE19">
									<div align="center">
										<span class="STYLE19"> ${one.otype }</span>
									</div>
								</td>
								<td height="20" class="STYLE19">
									<div align="center">
										<span class="STYLE19"> ${one.balance }</span>
									</div>
								</td>
							</tr>
						</c:forEach>
			<tr>
				<td height="30" colspan="4">
					<table width="100%" border="0" cellspacing="0" cellpadding="0" style="color:#295568;font-size:12px">
						<tr>
							<td width="33%">
								<div align="left">
									<span class="STYLE22">&nbsp;&nbsp;&nbsp;&nbsp;共有<strong>
											${page.allRecord }</strong> 条记录，当前第<strong><span id="pageNow">${page.pageNow}</span>
									</strong> 页，共 <strong>${page.allPage}</strong> 页</span>
								</div>
							</td>
							<td width="67%" style="font-size:12x">
								<table width="312" border="0" align="right" cellpadding="0"
									cellspacing="0">
									<tr>
										<td width="49">
											<div align="center">
												<span class="STYLE22"><a
													href="queryAllRecordsByPage?page.pageNow=1"
													class="STYLE13">首页</a> </span>
											</div>
										</td>
										<c:if test="${page.pageNow!='1' }">
											<td width="49">
												<div align="center">
													<span class="STYLE22"><a
														href="queryAllRecordsByPage?page.pageNow=${page.pageNow-1}"
														class="STYLE13">上一页</a> </span>
												</div>
											</td>
										</c:if>

										<c:if test="${page.pageNow < page.allPage}">
											<td width="49">
												<div align="center">
													<span class="STYLE22"><a
														href="queryAllRecordsByPage?page.pageNow=${page.pageNow+1}"
														class="STYLE13">下一页</a> </span>
												</div>
											</td>
										</c:if>
										<td width="49">
											<div align="center">
												<span class="STYLE22"><a
													href="queryAllRecordsByPage?page.pageNow=${page.allPage}"
													class="STYLE13">末页</a> </span>
											</div>
										</td>
										<td width="37" class="STYLE22">
											<div align="center"></div>
										</td>
										<td width="22">
											<div align="center">

											</div>
										</td>
										<td width="22" class="STYLE22">
											<div align="center"></div>
										</td>
									</tr>

								</table>
							</td>
						</tr>
					</table>
					</td>
					</tr>
		</table>
  </body>
</html>
