//$(document).ready(function() {
//    $.ajax({
//        url: '/header.do',
//        method: 'GET', 
//        dataType: 'json',
//        success: function(response) {
//			log.info("!!!!!!!!!response : ",response);
//            var fileStorename = response;
//            var imageUrl = './images/userprofile/' + fileStorename;
//            $('#fileImage').attr('src', imageUrl);
//        },
//        error: function() {
//            console.log('실패..');
//        }
//    });
//});