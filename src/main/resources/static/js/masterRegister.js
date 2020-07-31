$(function(){
    $(document).ready(function(){
        $('#assigneeTable').tablesort();

        $('button[name="masterDeleteModal"]').on('click',function(){
            // モーダルダイアログ表示
            $('.ui.basic.modal').modal("show");

            // モーダルダイアログに設定
            $('#delAssigneeId').text('・拠点番号：'+$(this).attr("data-id"));
            $('#delAssigneeName').text('・拠点名：'+$(this).attr("data-assigneeName"));
            $('form[name="masterFormModal"]').attr("action","/masterDelete/"+$(this).attr("data-id")+"/");
        });
    });
});