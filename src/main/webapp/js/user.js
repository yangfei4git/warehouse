$(function () {
    $('#dg').datagrid({
        title:"用户信息",
        toolbar:"#tb",
        url:'searchUser',
        pagination:true,
        pageSize:5,
        pageList:[5,10,15,20],
        columns:[[
            {field:'ch',checkbox:true,width:100,align:'center'},
            {field:'id',title:'编号',width:100,align:'center'},
            {field:'name',title:'用户名',width:100,align:'center'},
            {field:'telephone',title:'电话',width:100,align:'center'},
            {field:'dd',title:'操作',width:100,align:'center',
                formatter: function(value,row,index){
                    //同步
                    return "<a href=''>删除</a> | <a href=''>修改</a>";
                }
            }

        ]]
    });
});

function search() {
    var telephone=$("#stelephone").val();
    var name=$("#sname").val();
    $("#dg").datagrid("reload",{"name":name,"telephone":telephone});
}




