<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yangfei
  Date: 2019/10/20
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/js/jquery-1.8.3.js"></script>
    <script>


    </script>

</head>
<body>
<center>
    <h2>商品出库</h2>

    <form action="${pageContext.request.contextPath}/page/takeout" method="post" onsubmit="return check()">
        <table>
            <tr>
                <td>
                    出库商品:
                </td>
                <td><select name="productid" id="productid">
                    <option value="">--请选择出库商品--</option>
                    <c:forEach items="${productList}" var="product">
                        <option value="${product.id}" <c:if test="${take.productid==product.id}">selected</c:if>>${product.productname}</option>
                    </c:forEach>
                </select> <br></td>
            </tr>
            <tr>
                <td>
                    数量:
                </td>
                <td> <input type="text" name="quantity" id="quantity" value="${take.quantity}"> <span id="dd"></span><br></td>
            </tr>
            <tr>
                <td>
                    经手人:
                </td>
                <td><input type="text" name="handler" id="handler" value="${take.handler}"> <br></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="提交"> &nbsp; &nbsp;&nbsp;<input type="reset" value="重置"></td>
            </tr>
        </table>
    </form>
</center>
</body>
<script>
    function check() {
        var reg=/\S/;
        var reg2=/^[1-9][0-9]*/;
        var oproductid=$("#productid").val();
        var oquantity = $("#quantity").val();
        var ohandler = $("#handler").val();

        if (!reg.test(oproductid)){
            alert("请选择出库商品!");
            return false;
        }
        if (oquantity==null||oquantity==''){
            alert("请填写出库数量!");
            return false;
        }
        if (!reg2.test(oquantity)){
            alert("数量必须是大于0的整数!");
            return false;
        }
        if (ohandler==null||ohandler==''){
            alert("请填写经手人!");
            return false;
        }
        return true;
    }

</script>
<script>
    if (${xx=='t'}){
        alert("操作成功!");
    }
    if (${xx=='f'}){
        alert("操作失败!");
    }
</script>
<script>
    $("#quantity").keyup(function () {
        $.post("/page/searchQuantity",{"id":$("#productid").val(),"quantity":$("#quantity").val()},function (data) {
            $("#dd").text(data.msg)
        },"json")
    })
</script>
</html>
