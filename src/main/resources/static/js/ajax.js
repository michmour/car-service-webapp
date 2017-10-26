
	$(document).ready(function(){
       $('#searchbutton').click(function(){
        jQuery.support.cors = true;

        $.ajax(
        {
            type: "GET",
            url: '/admin/search/users',
            data: "[]",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            cache: false,
            success: function (data) {

			console.log("Success: ", data);


             var table = $("#location");
             var tableCode = '';
                $.each(data, function(idx, elem){
                  table.append("<tr><td>"+elem.ssn+"</td> <td>"+elem.surname+"</td></tr>");
                });

             table.html(tableCode);


  //          var trHTML = '';

//            $.each(data.surname, function (i, item) {
//                trHTML += '<tr><td>' + item + '</td><td>' + data.ssn[i] + '</td></tr>';
//            });
//
//            $('#location').append(trHTML);



//            $('#location').append(
//
//                $.map(data.surname, function (surname, index) {
//                    return '<tr><td>' + surname + '</td><td>' + data.ssn[index] + '</td></tr>';
//            }).join());

            },

            error: function (msg) {

                alert(msg.responseText);
            }
        });
    });
    });
