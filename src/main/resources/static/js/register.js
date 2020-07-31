$(function () {

  // 画像アップロード
  function sendFileToServer(formData, status) {
    var uploadURL = "/upload"; //Upload URL
    $.ajax({
      url: uploadURL,
      type: "POST",
      contentType: false,
      processData: false,
      cache: false,
      data: formData,
      timeout: 30000,
      beforeSend: function (xhr, settings) {
        //送信前の処理
      },
      complete: function (xhr, textStatus) {
        //通信完了
      },
      success: function (result, textStatus, xhr) {
        //ajax通信が成功した
        $('#dragdroparea').removeAttr('src');
        $('#dragdroparea').attr('src', result);
        $('#photo').val(result);
        $("#status1").append("File upload Done<br>");
      },
      error: function (xhr, textStatus, error) {
        //ajax通信が失敗した
        $('#status1').append('送信に失敗しました<br>');
      }
    });
  }

  function handleFileUpload(files, obj) {
    var fd = new FormData();
    for (var i = 0; i < files.length; i++) {
      fd.append('files', files[i]);
    }
    sendFileToServer(fd, status);
  }

  $(document).ready(function () {
    const pwd = document.getElementById('password');
    const pwdCheck = document.getElementById('password-check');
    pwdCheck.addEventListener('change', function () {
      if (pwdCheck.checked) {
        pwd.setAttribute('type', 'text');
      } else {
        pwd.setAttribute('type', 'password');
      }
    }, false);
    $('.ui.dropdown').dropdown();
    var obj = $("#dragdroparea");
    obj.on('dragenter', function (e) {
      e.stopPropagation();
      e.preventDefault();
    });
    obj.on('dragover', function (e) {
      e.stopPropagation();
      e.preventDefault();
    });
    obj.on('drop', function (e) {
      e.preventDefault();
      var files = e.originalEvent.dataTransfer.files;
      handleFileUpload(files);
    });
    $(document).on('dragenter', function (e) {
      e.stopPropagation();
      e.preventDefault();
    });
    $(document).on('dragover', function (e) {
      e.stopPropagation();
      e.preventDefault();
    });
    $(document).on('drop', function (e) {
      e.stopPropagation();
      e.preventDefault();
    });

  });


});