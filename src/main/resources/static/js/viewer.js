$(function () {
  $(document).ready(function () {
    $('table').tablesort();

    $('button[name="deleteModal"]').on('click', function() {
      // モーダルダイアログ表示
      $('.ui.basic.modal').modal('show');

      // モーダルダイアログに設定
      $('#delEmpNo').text('・社員番号：' + $(this).attr("data-id"));
      $('#delUserName').text('・氏名　　：' + $(this).attr("data-userName"));
      $('form[name="formModal"]').attr("action", "/delete/" + $(this).attr("data-id") + "/");

    });

  });


});