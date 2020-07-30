$(function () {
  $(document).ready(function () {
    $('table').tablesort();

    $('button[id="searchItem"]').on('click', function() {
      $('form[name="searchForm"]').attr("action", "/itemViewer/" + $("#selectItem").val());
    });

  });


});