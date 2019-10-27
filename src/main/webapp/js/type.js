$(function () {
    $('#dg').datagrid({
        toolbar:"#tb",
        url:'selectTypeByPage',
        pagination:true,
        pageSize:4,
        pageList:[4,10,15,20],
        columns:[[
            {field:'ch',checkbox:true,width:100,align:'center'},
            {field:'id',title:'区域编号',width:100,align:'center'},
            {field:'name',title:'区域名称',width:100,align:'center'},
            {field:'dd',title:'操作',width:100,align:'center',
                formatter: function(value,row,index){
                    //同步
                    return "<a href='javascript:DeleteByFruitName("+row.id+");'>删除</a> | <a href=''>修改</a>";
                }
            }

        ]]
    });
});
function add() {
    $("#AddDialog").dialog("setTitle","添加区域");
    $("#AddDialog").dialog("open");
}
function CloseDialog(id) {
    $("#"+id).dialog("close");
}
function SaveDialog() {
    /*$.post("insertType",{"name":$("#name").val()},function (data) {
        if (data.result>0){

            $('#dg').datagrid('reload');


            $("#AddDialog").dialog("close");

        }else {
            alert("添加失败!!!")
        }

    },"json")*/

    $('#addForm').form('submit',{   //提交按钮
        url:"insertType",
        success:function(data){ //获得是json字符串
            //将json字符串转化为json对象
            data=$.parseJSON(data);
            if(data.result==1){
                $("#dg").datagrid('reload'); //刷新
                $("#AddDialog").dialog("close");//关闭窗口
            }else{
                alert("添加失败!!!");
            }
        }
    });
}
function updateDialog() {

    $.post("updateType",{"name":$("#update").val(),"id":$('#dg').datagrid('getSelected').id},function (data) {
        if (data.result>0){
            $('#dg').datagrid('reload');
            $("#upDialog").dialog("close");

        }else {
            alert("修改失败!!!")
        }
    },"json")


}
function ModifyBySelect() {
    var SelectRows = $("#dg").datagrid('getSelections');
    if (SelectRows.length == 1) {

        $("#upDialog").dialog("setTitle","修改区域");
        $("#upDialog").dialog("open");

        $.post("selectByTypePrimaryKeyId",{"id":$('#dg').datagrid('getSelected').id},function (data) {
            $("#update").val(data.name);
        },"json");
    }else {
        $.messager.alert('提示信息','你没有选中行或者选中多行','warning');
    }
}

function DeleteByFruitName() {

    /* $.messager.confirm('删除区域','真的想删除吗?',function (r) {
         if (r){
             $.post("delType",{"id":$('#dg').datagrid('getSelected').id},function (data) {
                 if (data.result>0){
                     $("#dg").datagrid('reload'); //刷新
                     alert("删除成功!!!")
                 } else {
                     alert("删除失败!!!")
                 }
             },"json")
         }
     })*/
    var idList=[];
    var selectRows=$('#dg').datagrid('getSelections');
    for (var i = 0; i < selectRows.length; i++) {
        idList.push(selectRows[i].id);
    }
    var idLists=idList.join(",");
    if (selectRows.length == 0) {
        $.messager.alert('提示消息','请先选择一行或多行数据!','warning')
    }else {
        $.messager.confirm('删除区域','真的想删除吗?',function (r) {
            if (r){
                $.post("delTypes",{"array":idLists},function (data) {
                    if (data.result>0){
                        $("#dg").datagrid('reload'); //刷新
                        alert("删除成功!!!")
                    } else {
                        alert("删除失败!!!")
                    }
                },"json")
            }
        })
    }


}