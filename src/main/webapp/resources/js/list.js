function deleteSome() {

    // $("#mainForm").attr("action","/DeleteSomeServlet.do");
    // if (document.getElementById("id").checked){
    //     $("#mainForm").submit();
    // }
    var count = 0;
    var checkArray = document.getElementsByName("id");
    for ( var i = 0; i < checkArray.length; i++) {
        if(checkArray[i].checked == true){
            count++;
        }
    }
    if(count == 0){
        alert("请选择需要删除的项目再重新点击")
    }else
    {
    $("#mainForm").attr("action","/DeleteSomeServlet.do");
    $("#mainForm").submit();
    }





}
