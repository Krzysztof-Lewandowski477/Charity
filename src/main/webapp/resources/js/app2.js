
function createSummary() {
    var x = document.getElementById("streetID");
    document.getElementById("liStreetID").innerHTML = x.value;
    x = document.getElementById("cityID");
    document.getElementById("liCityID").innerHTML = x.value;
    x = document.getElementById("codeID");
    document.getElementById("liCodeID").innerHTML = x.value;
    x = document.getElementById("phoneID");
    document.getElementById("liPhoneID").innerHTML = x.value;
    x = document.getElementById("quantityID");
    document.getElementById("liQuantityID").innerHTML = x.value + ',';
    x = document.getElementById("dateID");
    document.getElementById("liDateID").innerHTML = x.value;
    x = document.getElementById("timeID");
    document.getElementById("liTimeID").innerHTML = x.value;
    x = document.getElementById("commentID");
    document.getElementById("liCommentID").innerHTML = x.value;

    var radioElems = document.getElementsByName('institution');

    for (i = 0; i < radioElems.length; i++) {
        if (radioElems[i].checked) {
            document.getElementById("liInstitutionNameID").innerHTML = '"' + radioElems[i].dataset.orgname + '"';
        }
    }

    // insideID
    var categoriesElems = document.getElementsByName('categories');
    var categoriesSummary = '';
    for (i = 0; i < categoriesElems.length; i++) {
        if (categoriesElems[i].checked)
            categoriesSummary += categoriesElems[i].nextElementSibling.nextElementSibling.innerHTML + ', ';
    }
    document.getElementById("liInsideID").innerHTML = categoriesSummary;
}
