var EzToolkit = EzToolkit || {};

(function (toolkit, win) {

    //---------- Initial function
    (function () {
        $.ajaxSetup({
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            type: "POST",
            statusCode : {
                404: function() {
                    //404 process
                }
            },
            timeout: 2000,
            error: function(xhr, status, errorThrown){

            },
            success: function(data, status, xhr){

            }
        });
    })();
    //---------- Initial function

    var ajax = {
        sendRequest : function(requestUrl, requestData, sussessCallback){
            $.ajax({
                url: requestUrl,
                data: JSON.stringify(requestData),
            })
            .done(sussessCallback);
        }

    }

    toolkit.ajax = ajax;

})(EzToolkit, window);