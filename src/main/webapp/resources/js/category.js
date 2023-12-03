

// Lắng nghe sự kiện khi modal được đóng
$('#createData').on('hidden.bs.modal', function (e) {
    $('#categoryId').val('');
    $('#categoryName').val('');
    $('#categoryDescription').val('');
    $('#categoryStatus').val('true');

});

$('table .delete').click(function () {
    let getId = $(this).parent().find('#caId').val();
    $('#catalogIdDelete').val(getId);
});

function changeDirection(){
    let direction = document.getElementById("direction").value;
    switch (direction) {
        case "Default":
            window.location="categoryGetAllData?direction=ASC&sortBy=categoryId";
            break;
        case "ASC":
            window.location="categoryGetAllData?direction=" + direction + "&sortBy=categoryName";
            break;
        case "DESC":
            window.location="categoryGetAllData?direction=" + direction + "&sortBy=categoryName";
            break;
    }
}










