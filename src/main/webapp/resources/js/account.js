function changeSortByAccount(){
    let sortByAccount = document.getElementById("sortByAccount").value;
    //Gọi controller
    window.location="accountGetAllData?sortBy="+sortByAccount;
}
function changeDirectionAccount(){
    let directionAccount = document.getElementById("directionAccount").value;
    switch (directionAccount) {
        case "Default":
            window.location="accountGetAllData?direction=ASC&sortBy=accId";
            break;
        case "ASC":
            window.location="accountGetAllData?direction=" + directionAccount;
            break;
        case "DESC":
            window.location="accountGetAllData?direction=" + directionAccount;
            break;
    }
}