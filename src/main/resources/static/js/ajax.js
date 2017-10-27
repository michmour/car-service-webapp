
var SEARCH_USER = '/admin/search/users';
var SEARCH_REPAIR = '/admin/search/repairs';
var SEARCH_VEHICLE = '/admin/search/vehicles';


jQuery.support.cors = true;


var Search = (function(window, $){

    var $userTitles = $('#location thead');
    var $searchResultsTable = $('#location tbody');

    var fetchResults = function ( url, data, callback ) {
        var options = {
            url: url,
            method: 'GET',
            cache: true,
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            data: data || []
        };
        $.ajax(options)
        .done(function(response){
            callback && callback(response);
        })
        .fail(function(response) {
            callback && callback(response);
        });
    };

    var printResults = function ( data, bodyTemplate, titles ) {
        data = data || [];
        var tableCode = '';
        data.forEach(function( row ){
            tableCode += bodyTemplate(row);
        });
        $userTitles.html(titles);
        $searchResultsTable.html(tableCode);
    };

   var search = function ( url, data, bodyTemplate, titles ) {
          fetchResults( url, data, (function (bodyTemplate, titles) {
              return function (results) {
                  printResults( results, bodyTemplate, titles);
              };
          })( bodyTemplate, titles ));
      };

    return {
		ajax: fetchResults,
		print: printResults,
        search: search
    };

})(this, jQuery);


var searchUserSsn = function ( keyword ) {
    var url = SEARCH_USER,
        data = { ownerssn: keyword };
        bodyTemplate = function ( person ) {
        return    ( '<tr>'+
                    '<td>'+person.userid+'</td>'+
                    '<td>'+person.ssn+'</td>'+
                    '<td>'+person.name+'</td>'+
                    '<td>'+person.surname+'</td>'+
                    '<td>'+person.email+'</td>'+
                    '<td>'+person.address+'</td>'+
                    '<td>'+
                        '<div class="btn-group" role="group">'+
                            '<a class="btn btn-default btn-sm" href="/admin/users/'+person.userid+'/edit">Edit</a>'+
                            '<a class="btn btn-danger btn-sm" href="/admin/users/'+person.userid+'/delete">Delete</a>'+
                        '</div'+
                  '</td>'+
                '</tr>');


        },
        titles = '<tr><th>ID</th><th>Social Security Number</th><th>Name</th><th>Surname</th><th>E-mail</th><th>Address</th><th>Actions</th></tr>';
    Search.search( url, data, bodyTemplate, titles );
};


var searchUserEmail = function ( keyword ) {
    var url = SEARCH_USER,
        data = { owneremail: keyword };
        bodyTemplate = function ( person ) {
            return ('<tr>'+
                                       '<td>'+person.userid+'</td>'+
                                       '<td>'+person.ssn+'</td>'+
                                       '<td>'+person.name+'</td>'+
                                       '<td>'+person.surname+'</td>'+
                                       '<td>'+person.email+'</td>'+
                                       '<td>'+person.address+'</td>'+
                                       '<td>'+
                                           '<div class="btn-group" role="group">'+
                                               '<a class="btn btn-default btn-sm" href="/admin/users/'+person.userid+'/edit">Edit</a>'+
                                               '<a class="btn btn-danger btn-sm" href="/admin/users/'+person.userid+'/delete">Delete</a>'+
                                           '</div'+
                                     '</td>'+
                                   '</tr>');
        },
        titles = '<tr><th>ID</th><th>Social Security Number</th><th>Name</th><th>Surname</th><th>E-mail</th><th>Address</th><th>Actions</th></tr>';
    Search.search( url, data, bodyTemplate, titles );
};


var searchRepairPlate = function ( keyword ) {
    var url = SEARCH_REPAIR,
        data = { repairplate: keyword };
        bodyTemplate = function ( person ) {
            return ('<tr>'+
                    '<td>'+person.serviceid+'</td>'+
                    '<td>'+person.servicedate+'</td>'+
                    '<td>'+person.status+'</td>'+
                    '<td>'+person.type+'</td>'+
                    '<td>'+person.servicecost+'</td>'+
                    '<td>'+person.details+'</td>'+
                    '<td>'+
                        '<div class="btn-group" role="group">'+
                            '<a class="btn btn-default btn-sm" href="/admin/repairs/'+person.serviceid+'/edit">Edit</a>'+
                            '<a class="btn btn-danger btn-sm" href="/admin/repairs/'+person.serviceid+'/delete">Delete</a>'+
                        '</div'+
                  '</td>'+
                '</tr>');
        },
        titles = '<tr><th>ID</th><th>Scheduled Date</th><th>Status</th><th>Type</th><th>Cost</th><th>Details</th><th>Actions</th></tr>';
    Search.search( url, data, bodyTemplate, titles );
};

var searchRepairSsn = function ( keyword ) {
    var url = SEARCH_REPAIR,
        data = { repairssn: keyword };
        bodyTemplate = function ( person ) {
            return ('<tr>'+
                                       '<td>'+person.serviceid+'</td>'+
                                       '<td>'+person.servicedate+'</td>'+
                                       '<td>'+person.status+'</td>'+
                                       '<td>'+person.type+'</td>'+
                                       '<td>'+person.servicecost+'</td>'+
                                       '<td>'+person.details+'</td>'+
                                       '<td>'+
                                           '<div class="btn-group" role="group">'+
                                               '<a class="btn btn-default btn-sm" href="/admin/repairs/'+person.serviceid+'/edit">Edit</a>'+
                                               '<a class="btn btn-danger btn-sm" href="/admin/repairs/'+person.serviceid+'/delete">Delete</a>'+
                                           '</div'+
                                     '</td>'+
                                   '</tr>');
        },
        titles = '<tr><th>ID</th><th>Scheduled Date</th><th>Status</th><th>Type</th><th>Cost</th><th>Details</th><th>Actions</th></tr>';
    Search.search( url, data, bodyTemplate, titles );
};

var searchVehiclePlate = function ( keyword ) {
    var url = SEARCH_VEHICLE,
        data = { vehicleplate: keyword };
        bodyTemplate = function ( repair ) {
           return (
                       '<tr>'+
                           '<td>'+repair.vehiclemodel+'</td>'+
                           '<td>'+repair.year+'</td>'+
                           '<td>'+repair.platenumber+'</td>'+
                           '<td>'+repair.colour+'</td>'+
                           '<td>'+
                               '<div class="btn-group" role="group">'+
                                   '<a class="btn btn-default btn-sm" href="/admin/vehicles/'+repair.vehicleid+'/edit">Edit</a>'+
                                   '<a class="btn btn-danger btn-sm" href="/admin/vehicles/'+repair.vehicleid+'/delete">Delete</a>'+
                               '</div'+
                           '</td>'+
                       '</tr>'
                       );
        },
        titles = '<tr><th>Model</th><th>Year</th><th>Plate Number</th><th>Colour</th><th>Actions</th></tr>';
    Search.search( url, data, bodyTemplate, titles );
};

var searchVehicleSsn = function ( keyword ) {
    var url = SEARCH_VEHICLE,
        data = { vehiclessn: keyword };
        bodyTemplate = function ( repair ) {
            return (
            '<tr>'+
                '<td>'+repair.vehiclemodel+'</td>'+
                '<td>'+repair.year+'</td>'+
                '<td>'+repair.platenumber+'</td>'+
                '<td>'+repair.colour+'</td>'+
                '<td>'+
                    '<div class="btn-group" role="group">'+
                        '<a class="btn btn-default btn-sm" href="/admin/vehicles/'+repair.vehicleid+'/edit">Edit</a>'+
                        '<a class="btn btn-danger btn-sm" href="/admin/vehicles/'+repair.vehicleid+'/delete">Delete</a>'+
                    '</div'+
                '</td>'+
            '</tr>'
            );
        },
        titles = '<tr><th>Model</th><th>Year</th><th>Plate Number</th><th>Colour</th><th>Actions</th></tr>';
    Search.search( url, data, bodyTemplate, titles );
};



var doSearch = function () {

    var keyword = $('#searchInput').val();
    var category = $('#CategoryId').val();

    switch (category) {
        case 'ownerssn':
            searchUserSsn(keyword);
            break;
        case 'owneremail':
            searchUserEmail(keyword);
            break;
        case 'repairplate':
            searchRepairPlate(keyword);
            break;
        case 'repairssn':
            searchRepairSsn(keyword);
            break;
        case 'vehicleplate':
            searchVehiclePlate(keyword);
            break;
        case 'vehiclessn':
            searchVehicleSsn(keyword);
            break;
    }
};


$(document).on('change', '#CategoryId', doSearch );

var inputTyped = null;
$(document).on('keyup', '#searchInput', function () {
    clearTimeout(inputTyped);
    inputTyped = setTimeout(function(){
        doSearch();
    }, 450);
});