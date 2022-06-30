var page = 2;

function nextPage(){
    var query = searchParam('q');
    $.ajax({
        url : "/ajax/list",
        type : "get",
        dataType : "json",
        data : {"q" : query,
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
                            "<a href='/search?q="+item.title[0]+"'>"+item.title[0]+"</a>"+
                            "<a href='/search?q="+item.title[1]+"'>"+item.title[1]+"</a>"+
                            "<a href='/search?q="+item.title[2]+"'>"+item.title[2]+"</a>"+
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

function nextPageByCategory(){
    var item = searchParam('item');
    $.ajax({
        url : "/ajax/category",
        type : "get",
        dataType : "json",
        data : {"item" : item,
                "page" : page},

        success : function(jary) {
            var content="";
            var list = jary;

            if(list == "none"){
                alert("더이상 불러올 짤이 없습니다.");
                return false;
            }
            $.each(list, function(index,i){
                content +=
                "<div class='col-xs-6 col-sm-4 col-md-3 col-lg-3'>"+
                    "<div class='content'>"+
                        "<a href='/view?id="+i.id+"'>"+
                            "<img src='/storage/"+i.imgPath+"'>"+
                        "</a>"+
                        "<div class='keyword'>"+
                            "<a href='/search?q="+i.title[0]+"'>"+i.title[0]+"</a>"+
                            "<a href='/search?q="+i.title[1]+"'>"+i.title[1]+"</a>"+
                            "<a href='/search?q="+i.title[2]+"'>"+i.title[2]+"</a>"+
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