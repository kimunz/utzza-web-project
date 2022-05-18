var page = 2;
var query = searchParam('query');

function nextPage(){
    $.ajax({
        url : "/ajax/list",
        type : "get",
        dataType : "json",
        data : {"query" : query,
                "page" : page},

        success : function(jary) {
            var content="";
            var list = jary;

            if(list == "none"){
                alert("더이상 불러올 짤이 없습니다.");
                return false;
            }
            $.each(list, function(index,item){
                content +=
                "<div class='col-xs-6 col-sm-4 col-md-3 col-lg-3'>"+
                    "<div class='content'>"+
                        "<a href='/view?id="+item.id+"'>"+
                            "<img src='/storage/"+item.imgPath+"'>"+
                        "</a>"+
                        "<div class='keyword'>"+
                            "<a href='#'>"+item.title[0]+"</a>"+
                            "<a href='#'>"+item.title[1]+"</a>"+
                            "<a href='#'>"+item.title[2]+"</a>"+
                        "</div>"+
                    "</div>"+
                "</div>";

            });
            $('#row').append(content);
            page++;
        },error:function(request,status,error){
            alert("message:"+request.responseText+"\n");
        }
    });
}
function searchParam(key) {
    return new URLSearchParams(location.search).get(key);
};