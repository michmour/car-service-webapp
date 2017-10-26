var SEARCH_USER = '/admin/search/users';

jQuery.support.cors = true;

var SearchUser = (function(window, $){

    var $userTitles = $('#location thead');
    var $searchResultsTable = $('#location tbody');

    var fetchResults = function ( keyword, callback ) {
        var options = {
            url: SEARCH_USER,
            method: 'GET',
            cache: false,
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            data: keyword || []
        };
        $.ajax(options)
        .done(function(response){
            callback && callback(response);
        })
        .fail(function(response) {
            callback && callback(response);
        });
    };

    var printResults = function ( data ) {
        data = data || [];




        var tableCode = '';
        data.forEach(function( person ){

            tableCode += ("<tr><td>"+person.ssn+"</td><td>"+person.surname+"</td><td>");
        });

        $userTitles.html('<tr><th>Ssn</th><th>Surname</th></tr>');


        $searchResultsTable.html(tableCode);
    };

    var search = function ( keyword ) {
        fetchResults( keyword, printResults );
    };

    return {
		ajax: fetchResults,
		print: printResults,
        search: search
    };

})(this, jQuery);

$(document).on('click', '#searchuserbutton', function (){
SearchUser.search(null);
});












var SEARCH_REPAIR = '/admin/search/repairs';

jQuery.support.cors = true;

var SearchRepair = (function(window, $){


    var $repairTitles = $('#location thead');
    var $searchResultsTable = $('#location tbody');

    var fetchResults = function ( keyword, callback ) {
        var options = {
            url: SEARCH_REPAIR,
            method: 'GET',
            cache: false,
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            data: keyword || []
        };
        $.ajax(options)
        .done(function(response){
            callback && callback(response);
        })
        .fail(function(response) {
            callback && callback(response);
        });
    };



    var printResults = function ( data ) {
        data = data || [];



        var tableCode = '';
        data.forEach(function( repair ){
            tableCode += ("<tr><td>"+repair.serviceid+"</td><td>"+repair.servicedate+"</td><td>"+repair.type+"</td><td>"+"<div class=\"btn-group\" role=\"group\"> " +
              "<button type=\"button\" class=\"btn btn-default btn-sm\" href=\"repairs/" +repair.serviceid+ "/edit"+"\">Edit </button>" +
             "<button type=\"button\" class=\"btn btn-danger btn-sm\" href=repairs/" +repair.serviceid+ "/delete"+"\">Delete </button>"+"</td></tr>");
        });

        $repairTitles.html('<tr><th>ID</th><th>Date</th><th>Type</th><th>Actions</th></tr>');

        $searchResultsTable.html(tableCode);
    };

    var search = function ( keyword ) {
        fetchResults( keyword, printResults );
    };

    return {
		ajax: fetchResults,
		print: printResults,
        search: search
    };

})(this, jQuery);

$(document).on('click', '#searchrepairbutton', function (){
SearchRepair.search(null);
});
